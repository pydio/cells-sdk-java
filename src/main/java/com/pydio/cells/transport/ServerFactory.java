package com.pydio.cells.transport;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.IServerFactory;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.legacy.P8Server;
import com.pydio.cells.legacy.P8Transport;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.credentials.LegacyPasswordCredentials;
import com.pydio.cells.utils.JavaCustomEncoder;
import com.pydio.cells.utils.MemoryStore;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Map;

/**
 * Optimistic implementation of a IServerFactory that does not persist (cache) anything locally
 */
public class ServerFactory implements IServerFactory {

    private final Store<Token> tokenStore;
    private final Store<Server> serverStore;
    private final Store<Transport> transportStore;

    public ServerFactory(Store<Token> tokenStore, Store<Server> serverStore, Store<Transport> transportStore) {
        this.tokenStore = tokenStore;
        this.serverStore = serverStore;
        this.transportStore = transportStore;
        initAppData();
    }

    public ServerFactory() {
        this.tokenStore = new MemoryStore<>();
        this.serverStore = new MemoryStore<>();
        this.transportStore = new MemoryStore<>();
        initAppData();
    }

    @Override
    public String checkServer(ServerURL serverURL) throws SDKException {

        // Insure SSL is valid
        try {
            serverURL.ping();
        } catch (IOException ce) {
            throw new SDKException(ErrorCodes.not_found, serverURL.getId(), ce);
//        } catch (SDKException ioe) {
//            throw new SDKException(ErrorCodes.ssl_error, serverURL.getId() + " does not provide a valid certificate. Skipping verify: " + serverURL.skipVerify(), ioe);
        }

        // We do not have any other choice than to try the various well-known endpoints
        try {
            ServerURL currURL = serverURL.withPath(CellsServer.BOOTCONF_PATH);
            currURL.ping();
            return SdkNames.TYPE_CELLS;
        } catch (ConnectException ce) {
            throw new SDKException(ErrorCodes.not_found, serverURL.getId(), ce);
        } catch (IOException e) {
            try {
                ServerURL currURL = serverURL.withSpec(P8Server.BOOTCONF_PATH);
                currURL.ping();
                return SdkNames.TYPE_LEGACY_P8;
            } catch (IOException e2) {
                throw new SDKException(ErrorCodes.not_pydio_server, serverURL.getId(), e2);
            }
        }
    }

    @Override
    public Server register(ServerURL serverURL) throws SDKException {

        if (serverStore.get(serverURL.getId()) != null) {
            return serverStore.get(serverURL.getId());
        }

        String type = checkServer(serverURL);

        Server server;
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


    /* This relies on the token store to resurrect an account. */
    public Transport restoreAccount(String username, ServerURL serverURL) throws SDKException {
        String accountID = accountID(username, serverURL);
        Transport existing = transportStore.get(accountID);
        if (existing != null) {
            return existing;
        }

        Token token = tokenStore.get(accountID);
        if (token == null) {
            throw new SDKException("Could not restore account " + accountID + ", no valid token has been found in local store");
        }

        Server server = register(serverURL);
        if (server.isLegacy()) {
            throw new RuntimeException("Cannot restore a P8 account with no credentials");
        }
        CellsTransport transport = new CellsTransport(tokenStore, username, server, getEncoder());
        if (transport.getAccessToken() == null || "".equals(transport.getAccessToken())) {
            throw new SDKException("Could not restore account " + accountID + ", refresh token process has failed");
        }
        transportStore.put(accountID, transport);
        return transport;
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

    @Override
    public void registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException {

        Server server = serverStore.get(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        Transport transport;

        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            if (credentials instanceof LegacyPasswordCredentials) {
                transport = new CellsTransport(tokenStore, credentials.getLogin(), server, getEncoder());
            } else
                throw new RuntimeException("Unsupported credential " + credentials.getClass().toString() + " for Cells server: " + serverURL.getId());

        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            transport = new P8Transport(tokenStore, server, credentials.getLogin(), getEncoder());
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        transport.unlock(credentials);

        transportStore.put(accountID(credentials.getLogin(), server), transport);
    }

    @Override
    public void unregisterAccount(String accountID) throws SDKException {
        transportStore.remove(accountID);
        tokenStore.remove(accountID);
        // TODO? if no transport is defined anymore on a server, also remove?
    }

    @Override
    public Transport getTransport(String accountID) {
        return transportStore.get(accountID);
    }

    // @Override
    public Transport getAnonymousTransport(String serverID) {
        Server server = serverStore.get(serverID);
        if (server == null) {
            return null;
        }

        if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            return new P8Transport(tokenStore, server, Transport.ANONYMOUS_USERNAME, getEncoder());
        }
        return CellsTransport.asAnonymous(server, getEncoder());
    }


    public void unregisterAccount(String login, ServerURL serverURL) throws SDKException {
        unregisterAccount(accountID(login, serverURL));
    }

    @Override
    public CustomEncoder getEncoder() {
        return new JavaCustomEncoder();
    }

    protected void initAppData() {
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaTransport";
        ClientData.version = "0.2.0-dev";
        ClientData.platform = "Java";
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
