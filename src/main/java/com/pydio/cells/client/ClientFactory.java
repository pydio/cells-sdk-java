package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.legacy.P8Client;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.ServerFactory;
import com.pydio.cells.transport.auth.Token;

/**
 * Extend a server factory to manage client concepts.
 */
public abstract class ClientFactory extends ServerFactory {

    public ClientFactory(Store<Token> tokenStore, Store<Server> serverStore, Store<Transport> transportStore) {
        super(tokenStore, serverStore, transportStore);
    }

    /**
     * Creates a factory with in memory stores for tokens, servers and transports
     */
    public ClientFactory() {
        super();
    }

    /**
     * Implement this: it is the single entry point to inject the S3 client
     * that is platform specific
     */
    protected abstract CellsClient getCellsClient(CellsTransport transport);

    public Client getClient(Transport transport) {
        if (transport.getServer().isLegacy()) {
            return new P8Client(transport);
        } else {
            return getCellsClient((CellsTransport) transport);
        }
    }

    @Override
    protected void initAppData() {
        super.initAppData();
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaClient";
    }
}
