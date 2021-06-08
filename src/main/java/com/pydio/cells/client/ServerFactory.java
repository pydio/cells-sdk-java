package com.pydio.cells.client;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.IServerFactory;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.encoding.JavaCustomEncoder;
import com.pydio.cells.legacy.P8Server;
import com.pydio.cells.legacy.P8Transport;
import com.pydio.cells.transport.CellsServer;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.StateID;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.transport.auth.credentials.LegacyPasswordCredentials;

import java.io.IOException;
import java.net.ConnectException;
import java.util.HashMap;
import java.util.Map;

/**
 * Optimistic implementation of a IServerFactory that does not persist (cache) anything locally
 */
public class ServerFactory implements IServerFactory {

    private final Map<String, Server> servers = new HashMap<>();
    private final Map<String, Transport> transports = new HashMap<>();
    private final TokenService tokenService;

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
        } catch (IOException ioe) {
            throw new SDKException(ErrorCodes.ssl_error, serverURL.getId() + " does not provide a valid certificate. Skipping verify: " + serverURL.skipVerify(), ioe);
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
            server = new CellsServer(serverURL).refresh(false);
        } else if (SdkNames.TYPE_LEGACY_P8.equals(type)) {
            server = new P8Server(serverURL).init();
        } else {
            throw new SDKException(ErrorCodes.not_pydio_server);
        }

        putServer(serverURL.getId(), server);
        return server;
    }

    @Deprecated
    @Override
    public Transport registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException {

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        Transport transport;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            if (credentials instanceof LegacyPasswordCredentials) {
                LegacyPasswordCredentials pc = ((LegacyPasswordCredentials) credentials);
                transport = new CellsTransport(pc.getLogin(), server, getEncoder());
                tokenService.legacyLogin((CellsTransport) transport, pc);
                //tokenService.loginPasswordGetToken((CellsTransport) session, credentials);
                ((CellsTransport) transport).restore(tokenService);
            } else
                throw new RuntimeException("Unsupported credential " + credentials.getClass().toString() + " for Cells server: " + serverURL.getId());

        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            transport = new P8Transport(server, credentials, getEncoder());
            ((P8Transport) transport).restore(tokenService);
            // ((P8Transport) transport).setCredentials(credentials);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        //  Rather do this in the client layer
        // return storeAccountInfo(accountID(credentials.getLogin(), serverURL), session);
        return transport;

    }

    public void unregisterAccount(String accountID) throws SDKException {
        // TODO rather introduce another layer to ease use of a persistent store.
        transports.remove(accountID);
    }


    public void unregisterAccount(String login, ServerURL serverURL) throws SDKException {
        unregisterAccount(accountID(login, serverURL));
    }

    @Override
    public Transport getTransport(String login, ServerURL serverURL) throws SDKException {

        if (transports.containsKey(accountID(login, serverURL))) {
            return transports.get(accountID(login, serverURL));
        }

        Server server = getServer(serverURL.getId());
        if (server == null) {
            server = register(serverURL);
        }

        Transport transport;
        if (SdkNames.TYPE_CELLS.equals(server.getRemoteType())) {
            transport = new CellsTransport(login, server, getEncoder());
            ((CellsTransport) transport).restore(tokenService);
        } else if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            transport = new P8Transport(server, login, getEncoder());
            ((P8Transport) transport).restore(tokenService);
        } else
            throw new RuntimeException("Unknown type [" + server.getRemoteType() + "] for " + serverURL.getId());

        transports.put(accountID(login, serverURL), transport);

        return transport;
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
        return new StateID(username, urlStr).getId();
    }

    public static String accountID(String username, ServerURL serverURL) {
        return accountID(username, serverURL.getId());
    }

    public static String accountID(String username, Server server) {
        return accountID(username, server.getServerURL());
    }


    protected void initAppData() {
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaTransport";
        ClientData.version = "0.2.0-dev";
        ClientData.platform = "Java";
    }

    @Override
    public CustomEncoder getEncoder() {
        return new JavaCustomEncoder();
    }

}
