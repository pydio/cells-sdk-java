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
import com.pydio.cells.utils.MemoryStore;

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

    public ServerFactory() {
        credentialService = new CredentialService(new MemoryStore<>(), new MemoryStore<>());
        this.serverStore = new MemoryStore<>();
        this.transportStore = new MemoryStore<>();
        initAppData();
    }

    protected void initAppData() {
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaTransport";
        ClientData.version = "0.3.0-dev";
        ClientData.platform = "Java";
    }

    @Override
    public String checkServer(ServerURL serverURL) throws SDKException {

        // Insure server is up and SSL is valid
        try {
            serverURL.ping();
        } catch (SSLException se){
            throw new SDKException(ErrorCodes.ssl_error, "Un-valid TLS connection with " + serverURL.getId(), se);
        } catch (IOException ce) {
            throw new SDKException(ErrorCodes.not_found, "Cannot reach server at " + serverURL.getId(), ce);
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

    // TODO Add a boolean skipCredentialValidation flag ?
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
            // In the case of PWD creds,
            // we then rely on the transport to retrieve the effective secure token
            PasswordCredentials pc = (PasswordCredentials) credentials;
            credentialService.putPassword(accountID, pc.getPassword());
            transport.getTokenFromLegacyCredentials(pc);
        } else if (credentials instanceof JWTCredentials) {
            // In case of JWT credentials, we directly store the token in the token store
            // But we do not try to login at this time
            credentialService.put(accountID, ((JWTCredentials) credentials).getToken());
        }

        // TODO make a call to the server to insure everything is correctly set ?
        transportStore.put(accountID(credentials.getUsername(), server), transport);
        return  accountID;
    }

    /* Relies on the CredentialService to resurrect an account. */
    public Transport restoreAccount(ServerURL serverURL, String username) throws SDKException {
        String accountID = accountID(username, serverURL);
        Transport existing = transportStore.get(accountID);
        if (existing != null) {
            return existing;
        }

        Token token = credentialService.get(accountID);
        String pwd = credentialService.getPassword(accountID);
        if (token == null && pwd == null) {
            throw new SDKException(ErrorCodes.authentication_required, "Could not restore account " + accountID + ", no valid credential has been found in local store");
        }

        Server server = registerServer(serverURL);

        Transport transport;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            transport = new CellsTransport(credentialService, StateID.fromId(accountID).getUsername(), server, getEncoder());
        } else {
            transport = new P8Transport(credentialService, server, StateID.fromId(accountID).getUsername(), getEncoder());
        }
        transportStore.put(accountID, transport);
        return transport;
    }

    @Override
    public void unregisterAccount(String accountID) throws SDKException {
        transportStore.remove(accountID);
        credentialService.remove(accountID);
        credentialService.removePassword(accountID);
        // TODO? if no transport is defined anymore on a server, also remove?
    }

    public void unregisterAccount(ServerURL serverURL, String login) throws SDKException {
        unregisterAccount(accountID(login, serverURL));
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

    //
//    @Override
//    public Transport getTransport(String login, ServerURL serverURL) throws SDKException {
//
//        if (transports.containsKey(accountID(login, serverURL))) {
//            return transports.get(accountID(login, serverURL));
//        }
//
//        Server server = getServer(serverURL.getId());
//        if (server == null) {
//            server = register(serverURL);
//        }
//
//        Transport transport;
//        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
//            transport = new CellsTransport(login, server, getEncoder());
//            ((CellsTransport) transport).restore(tokenService);
//        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
//            transport = new P8Transport(server, login, getEncoder());
//            ((P8Transport) transport).restore(tokenService);
//        } else
//            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());
//
//        transports.put(accountID(login, serverURL), transport);
//
//        return transport;
//    }


}
