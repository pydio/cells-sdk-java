package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.client.encoding.JavaCustomEncoder;
import com.pydio.cells.legacy.P8Client;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.StateID;

/**
 * Extend a server factory to manage client concepts.
 */
public class SessionFactory extends ServerFactory {

    private final TokenService tokenService;

    public SessionFactory(TokenService tokenService) {
        super(tokenService);
        this.tokenService = tokenService;
        initAppData();
    }

    protected TokenService getTokenService() {
        return tokenService;
    }

    public Client getClient(Transport transport) {
        if (transport.getServer().isLegacy()) {
            return new P8Client(transport);
        } else {
            // FIXME change when problems with S3 dependencies have been solved.
            // return new CellsClient(transport, new PojoS3Client((CellsTransport)transport));
            return new CellsClient(transport, null);
        }
    }

    public CustomEncoder getEncoder() {
        return new JavaCustomEncoder();
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

    private void initAppData() {
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaClient";
        ClientData.version = "0.2.0-dev";
        ClientData.platform = "Java";
    }

}
