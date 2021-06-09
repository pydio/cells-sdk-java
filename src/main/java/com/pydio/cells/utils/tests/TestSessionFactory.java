package com.pydio.cells.utils.tests;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.S3Client;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.CellsClient;
import com.pydio.cells.client.SessionFactory;
import com.pydio.cells.legacy.NoAwsS3Client;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.TokenService;

/**
 * This provides a convenient factory that works for everything,
 * except for file transfers TO or FROM a Cells server.
 */
public class TestSessionFactory extends SessionFactory {

    public TestSessionFactory(Store<Token> tokenStore, Store<Server> serverStore, Store<Transport> transportStore) {
        super(tokenStore, serverStore, transportStore);
    }

    public TestSessionFactory() {
        super();
    }

    protected CellsClient getCellsClient(CellsTransport transport) {
        return new CellsClient(transport, new NoAwsS3Client());
    }
}
