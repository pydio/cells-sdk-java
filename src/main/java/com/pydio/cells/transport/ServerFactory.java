package com.pydio.cells.transport;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.IServerFactory;
import com.pydio.cells.api.PasswordCredentials;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.legacy.P8Server;
import com.pydio.cells.legacy.P8Transport;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.credentials.JWTCredentials;
import com.pydio.cells.utils.JavaCustomEncoder;

import java.io.IOException;
import java.util.Map;

import javax.net.ssl.SSLException;

/**
 * Optimistic implementation of a IServerFactory that relies on provided stores to persist objects.
 */
public class ServerFactory implements IServerFactory {

    private final CredentialService credentialService;
    private final Store<Server> serverStore;
    private final Store<Transport> transportStore;

    public ServerFactory(CredentialService credentialService, Store<Server> serverStore, Store<Transport> transportStore) {
        this.credentialService = credentialService;
        this.serverStore = serverStore;
        this.transportStore = transportStore;
        initAppData();
    }

    protected void initAppData() {
        ClientData instance = ClientData.getInstance();
        if (ClientData.DEFAULT_APP_NAME.equals(instance.getName())) {
            instance.setPackageID(this.getClass().getPackage().getName());
            instance.setName("CellsJavaTransport");
            instance.setLabel("Cells Java Transport");
            // TODO this should not be hard coded
            instance.setVersion("0.4.3");
            instance.setPlatform("Java");
            ClientData.updateInstance(instance);
        }
    }

    @Override
    public String checkServer(ServerURL serverURL) throws SDKException {

        // Insure server is up and SSL is valid
        try {
            serverURL.ping();
        } catch (SSLException se) {
            throw new SDKException(ErrorCodes.ssl_error, "Un-valid TLS connection with " + serverURL.getId(), se);
        } catch (IOException ce) {
            throw new SDKException(ErrorCodes.unreachable_host, "Cannot reach server at " + serverURL.getId(), ce);
        }

        // We do not have any other choice than to try the various well-known endpoints
        try {
            ServerURL currURL = serverURL.withPath(CellsServer.BOOTCONF_PATH);
            currURL.ping();
            return SdkNames.TYPE_CELLS;
        } catch (IOException ce) {
            throw new SDKException(ErrorCodes.not_found, serverURL.getId(), ce);
        } catch (SDKException e) {
            if (e.getCode() == 404) {
                try {
                    ServerURL currURL = serverURL.withSpec(P8Server.BOOTCONF_PATH);
                    currURL.ping();
                    return SdkNames.TYPE_LEGACY_P8;
                } catch (IOException e2) {
                    throw new SDKException(ErrorCodes.not_found, serverURL.getId(), e2);
                } catch (SDKException e2) {
                    if (e.getCode() == 404) {
                        throw new SDKException(ErrorCodes.not_pydio_server, serverURL.getId(), e2);
                    }
                    throw e2;
                }
            } else {
                throw e;
            }
        }
    }

    @Override
    public Server registerServer(ServerURL serverURL) throws SDKException {

        Server server = serverStore.get(serverURL.getId());
        if (server != null) {
            return server;
        }

        String type = checkServer(serverURL);
        if (SdkNames.TYPE_CELLS.equals(type)) {
            server = new CellsServer(serverURL).refresh(false);
        } else if (SdkNames.TYPE_LEGACY_P8.equals(type)) {
            server = new P8Server(serverURL).init();
        } else {
            throw new SDKException(ErrorCodes.not_pydio_server);
        }
        serverStore.put(serverURL.getId(), server);
        return server;
    }

    protected Map<String, Server> getServers() {
        return serverStore.getAll();
    }

    /**
     * Retrieve an already registered server by id.
     *
     * @param id can be a server URL or an encoded account id (including the username)
     */
    public Server getServer(String id) {
        StateID stateID = StateID.fromId(id);
        return serverStore.get(stateID.getServerUrl());
    }

    protected void removeServer(String id) {
        serverStore.remove(id);
    }

    // TODO Add a boolean skipCredentialValidation flag?
    @Override
    public String registerAccountCredentials(ServerURL serverURL, Credentials credentials) throws SDKException {

        String accountID = accountID(credentials.getUsername(), serverURL);
        Server server = serverStore.get(serverURL.getId());
        if (server == null) {
            server = registerServer(serverURL);
        }

        Transport transport;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            transport = new CellsTransport(credentialService, credentials.getUsername(), server, getEncoder());
        } else {
            transport = new P8Transport(credentialService, server, credentials.getUsername(), getEncoder());
        }

        if (credentials instanceof PasswordCredentials) {
            // In the case of legacy password credentials,
            // we rely on the transport to retrieve the effective secure token.
            PasswordCredentials pc = (PasswordCredentials) credentials;
            // TODO might be a better place to forget about the precedent token
            //  that have been generated by P8 but this is compulsory at this time,
            //  among others, to force regeneration of the cookies.
            credentialService.remove(accountID);

            // Retrieve token and save both the credentials (for later refresh) and the newly created token.
            credentialService.put(accountID, transport.getTokenFromLegacyCredentials(pc));
            credentialService.putPassword(accountID, pc.getPassword());
        } else if (credentials instanceof JWTCredentials) {
            // In case of JWT credentials, we directly store the token in the token store
            // But we do not try to login at this time
            credentialService.put(accountID, ((JWTCredentials) credentials).getToken());
        }

        // TODO make a call to the server to insure everything is correctly set ?
        transportStore.put(accountID(credentials.getUsername(), server), transport);
        return accountID;
    }

    /* Relies on the CredentialService to resurrect an account if we have valid credentials. */
    public Transport restoreAccount(ServerURL serverURL, String username) throws SDKException {
        String accountID = accountID(username, serverURL);
        Transport existing = transportStore.get(accountID);
        if (existing != null) {
            return existing;
        }

        // We must register server even if we have no valid credentials, in order to be able
        // to trigger re-log action.
        Server server = registerServer(serverURL);

        Token token = credentialService.get(accountID);
        String pwd = credentialService.getPassword(accountID);
        if (token == null && pwd == null) {
            throw new SDKException(ErrorCodes.no_token_available, "Could not restore account " + accountID + ", no valid credential has been found in local store");
        }

        Transport transport;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            transport = new CellsTransport(credentialService, StateID.fromId(accountID).getUsername(), server, getEncoder());
        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            transport = new P8Transport(credentialService, server, StateID.fromId(accountID).getUsername(), getEncoder());
        } else {
            throw new SDKException(ErrorCodes.not_pydio_server, "Unknown server type, " + server.getRemoteType() + " cannot proceed for " + accountID);
        }
        transportStore.put(accountID, transport);
        return transport;
    }

    @Override
    public void unregisterAccount(String accountID) throws SDKException {
        transportStore.remove(accountID);
        credentialService.remove(accountID);
        credentialService.removePassword(accountID);
        // When no transport is defined because we do not have credentials, we still keep the server
        // to be able to re-log. // TODO("rather rely on a dynamic cache for the server store")
    }

    @Override
    public Transport getTransport(String accountID) {
        return transportStore.get(accountID);
    }

    @Override
    public CustomEncoder getEncoder() {
        return new JavaCustomEncoder();
    }

    public Transport getAnonymousTransport(String serverID) {
        Server server = serverStore.get(serverID);
        if (server == null) {
            return null;
        }

        if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            return new P8Transport(credentialService, server, Transport.ANONYMOUS_USERNAME, getEncoder());
        }
        return CellsTransport.asAnonymous(server, getEncoder());
    }

    // Static helpers to ease implementation
    public static String accountID(String username, String urlStr) {
        return new StateID(username, urlStr).getId();
    }

    public static String accountID(String username, ServerURL serverURL) {
        return accountID(username, serverURL.getId());
    }

    public static String accountID(String username, Server server) {
        return accountID(username, server.getServerURL());
    }

    /**
     * Convenience method to create a server factory that only relies on memory stores for quick testing
     */
//    public ServerFactory() {
//        this(new CredentialService(new MemoryStore<>(), new MemoryStore<>()),
//                new MemoryStore<>(), new MemoryStore<>());
//    }

//    public void unregisterAccount(ServerURL serverURL, String login) throws SDKException {
//        unregisterAccount(accountID(login, serverURL));
//    }

}
