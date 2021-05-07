package com.pydio.sdk.core;

import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.IServerFactory;
import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.ServerURL;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.model.CellsServer;
import com.pydio.sdk.core.model.P8Server;
import com.pydio.sdk.core.security.PasswordCredentials;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Optimistic implementation of a IServerFactory does not persist (cache) anything locally
 */
public class ServerFactory implements IServerFactory {

    private final TokenService tokenService;
    private Map<String, Server> servers = new HashMap<>();

    public ServerFactory(TokenService tokenService) {
        this.tokenService = tokenService;
        initAppData();
    }

    protected Map<String, Server> getServers(){
        return servers;
    }

    protected Server getServer(String id){
        return servers.get(id);
    }

    protected Server putServer(String id, Server server){
        return servers.put(id, server);
    }

    protected Server removeServer(String id){
        return servers.remove(id);
    }

    protected TokenService getTokenService(){
        return tokenService;
    }


    @Override
    public Server register(ServerURL serverURL) throws SDKException {

        if (getServer(serverURL.getId()) != null) {
            return getServer(serverURL.getId());
        }

        String type = checkServer(serverURL);

        Server server;
        if (TYPE_CELLS.equals(type)) {
            server = new CellsServer(serverURL);
        } else if (TYPE_LEGACY_P8.equals(type)) {
            server = new P8Server(serverURL);
        } else {
            throw new SDKException(ErrorCodes.not_pydio_server);
        }

        putServer(serverURL.getId(), server);
        return server;
    }

    @Override
    public String checkServer(ServerURL serverURL) throws SDKException {
        // We do not have any other choice than to try the various well-known endpoints
        try {
            ServerURL currURL = serverURL.withPath(CellsServer.BOOTCONF_PATH);
            currURL.ping();
            return TYPE_CELLS;
        } catch (IOException e) {
            try {
                // We do not have other choice than to try the various well known endpoints
                ServerURL currURL = serverURL.withPath(P8Server.BOOTCONF_PATH);
                currURL.ping();
                return TYPE_LEGACY_P8;
            } catch (IOException e2) {
                throw new SDKException(ErrorCodes.not_pydio_server, serverURL.getId(), e2);
            }
        }
    }

    @Override
    public ISession registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException {

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        ISession session = null;
        if (TYPE_CELLS.equals(server.getRemoteType())) {
            if (credentials instanceof PasswordCredentials) {
                PasswordCredentials pc = ((PasswordCredentials) credentials);
                session = new CellsSession(server, pc.getLogin());
                tokenService.legacyLogin((CellsSession) session, credentials);
                ((CellsSession) session).restore(tokenService);
            } else
                throw new RuntimeException("Unsupported credential " + credentials.getClass().toString() + " for Cells server: " + serverURL.getId());

        } else if (TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            session = new P8Session(server);
            ((P8Session) session).restore(tokenService);
            ((P8Session) session).setCredentials(credentials);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        return session;
    }


    @Override
    public ISession getSession(ServerURL serverURL, String login) throws SDKException {

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        ISession session = null;
        if (TYPE_CELLS.equals(server.getRemoteType())) {
            session = new CellsSession(server, login);
            ((CellsSession) session).restore(tokenService);
        } else if (TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            session = new P8Session(server);
            // ((CellsSession)session).restore(tokenService);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        return session;
    }

    private void initAppData() {

        ApplicationData.packageID = this.getClass().getPackage().getName();
        ApplicationData.name = "CellsJavaClient";
        ApplicationData.version = "0.2.0-dev";
        ApplicationData.platform = "Java";

    }

}
