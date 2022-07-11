package com.pydio.cells.utils.tests;

import com.pydio.cells.api.Server;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.CellsClient;
import com.pydio.cells.client.ClientFactory;
import com.pydio.cells.legacy.NoAwsS3Client;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.auth.CredentialService;

/**
 * This provides a convenient factory that works for everything,
 * except for file transfers TO or FROM a Cells server.
 */
public class TestClientFactory extends ClientFactory {

    public TestClientFactory(CredentialService credentialService, Store<Server> serverStore, Store<Transport> transportStore) {
        super(credentialService, serverStore, transportStore);
    }

//    public TestClientFactory() {
//        super();
//    }

    protected CellsClient getCellsClient(CellsTransport transport) {
        return new CellsClient(transport, new NoAwsS3Client());
    }
}
