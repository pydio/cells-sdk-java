package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.legacy.P8Client;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.ServerFactory;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.utils.Log;

/**
 * Extend a server factory to manage client concepts.
 */
public abstract class ClientFactory extends ServerFactory {

    public ClientFactory(CredentialService credentialService, Store<Server> serverStore, Store<Transport> transportStore) {
        super(credentialService, serverStore, transportStore);
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
        ClientData instance = ClientData.getInstance();

        // Workaround to insure client data are OK:
        // if the AppName has changed, we consider client data are already correctly set.
        if (ClientData.DEFAULT_APP_NAME.equals(instance.getName())) {
            super.initAppData();
            instance.setPackageID(this.getClass().getPackage().getName());
            instance.setLabel("Cells Java Client");
            instance.setName("CellsJavaClient");
            Log.i("Client factory", "### After Setting client data, App name: "
                    + instance.getName() + " - " + instance.toString());
            ClientData.updateInstance(instance);
        }
    }
}
