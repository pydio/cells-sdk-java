package com.pydio.cells.client;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.IServerFactory;
import com.pydio.cells.api.ISession;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.security.PasswordCredentials;
import com.pydio.cells.legacy.P8Server;
import com.pydio.cells.legacy.P8Session;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

/**
 * Optimistic implementation of a IServerFactory does not persist (cache) anything locally
 */
public class ServerFactory implements IServerFactory {

    private final TokenService tokenService;
    private Map<String, Server> servers = new HashMap<>();
    private Map<String, ISession> sessions = new HashMap<>();

    public ServerFactory(TokenService tokenService) {
        this.tokenService = tokenService;
        initAppData();
    }

    @Override
    public String checkServer(ServerURL serverURL) throws SDKException {

        // Insure SSL is valid
        try {
            serverURL.ping();
        } catch (ConnectException ce) {
            throw new SDKException(ErrorCodes.not_found, serverURL.getId(), ce);
        } catch (IOException ioe){
            throw new SDKException(ErrorCodes.ssl_error, "Unvalid certificate found at "+serverURL.getId()+ ", Skip verify: "+serverURL.skipVerify(), ioe);
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
                // We do not have other choice than to try the various well known endpoints
                ServerURL currURL = serverURL.withPath(P8Server.BOOTCONF_PATH);
                currURL.ping();
                return SdkNames.TYPE_LEGACY_P8;
            } catch (IOException e2) {
                throw new SDKException(ErrorCodes.not_pydio_server, serverURL.getId(), e2);
            }
        }
    }

    @Override
    public Server register(ServerURL serverURL) throws SDKException {

        if (getServer(serverURL.getId()) != null) {
            return getServer(serverURL.getId());
        }

        String type = checkServer(serverURL);

        Server server;
        if (SdkNames.TYPE_CELLS.equals(type)) {
            server = new CellsServer(serverURL).init();
        } else if (SdkNames.TYPE_LEGACY_P8.equals(type)) {
            server = new P8Server(serverURL).init();
        } else {
            throw new SDKException(ErrorCodes.not_pydio_server);
        }

        putServer(serverURL.getId(), server);
        return server;
    }


    @Override
    public ISession registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException {

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        ISession session = null;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            if (credentials instanceof PasswordCredentials) {
                PasswordCredentials pc = ((PasswordCredentials) credentials);
                session = new CellsSession(server, pc.getLogin());

                tokenService.legacyLogin((CellsSession) session, credentials);
                //tokenService.loginPasswordGetToken((CellsSession) session, credentials);

                ((CellsSession) session).restore(tokenService);
            } else
                throw new RuntimeException("Unsupported credential " + credentials.getClass().toString() + " for Cells server: " + serverURL.getId());

        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            session = new P8Session(server);
            ((P8Session) session).restore(tokenService);
            ((P8Session) session).setCredentials(credentials);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());


        //  Rather do this in the client layer
        // return storeAccountInfo(accountID(credentials.getLogin(), serverURL), session);
        return session;
    }

//     /**
//      * Stores the session in a local HashMap, should be extended with client specific implementation,
//      * to typically use a persistent storage
//      */
//     public ISession storeAccountInfo(String id, ISession session) throws SDKException {
//         sessions.put(id, session);
//         return session;
//     }

    public void unregisterAccount(String accountID) throws SDKException {
        // TODO rather introduce another layer to ease use of a persistent store.
        sessions.remove(accountID);
    }


    public void unregisterAccount(String login, ServerURL serverURL) throws SDKException {
        unregisterAccount(accountID(login, serverURL));
    }

    @Override
    public ISession getSession(String login, ServerURL serverURL) throws SDKException {

        if (sessions.containsKey(accountID(login, serverURL))) {
            return sessions.get(accountID(login, serverURL));
        }

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        ISession session = null;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            session = new CellsSession(server, login);
            ((CellsSession) session).restore(tokenService);
        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            session = new P8Session(server);
            // ((CellsSession)session).restore(tokenService);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        sessions.put(accountID(login, serverURL), session);

        return session;
    }

    protected Map<String, Server> getServers() {
        return servers;
    }

    public Server getServer(String id) {
        return servers.get(id);
    }

    protected Server putServer(String id, Server server) {
        return servers.put(id, server);
    }

    protected Server removeServer(String id) {
        return servers.remove(id);
    }

    protected TokenService getTokenService() {
        return tokenService;
    }

    // Static helpers to ease implementation
    public static String accountID(String username, String urlStr) {
        return String.format("%s@%s", username, urlStr);
    }

    public static String accountID(String username, ServerURL serverURL) {
        return accountID(username, serverURL.getId());
    }

    public static String accountID(String username, Server server) {
        return accountID(username, server.getServerURL());
    }

    private void initAppData() {

        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaClient";
        ClientData.version = "0.2.0-dev";
        ClientData.platform = "Java";

    }

}
