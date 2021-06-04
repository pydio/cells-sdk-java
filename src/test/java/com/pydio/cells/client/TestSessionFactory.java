package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.client.s3.PojoS3Client;
import com.pydio.cells.transport.CellsTransport;

public class TestSessionFactory extends SessionFactory {

    public TestSessionFactory(TokenService tokenService) {
        super(tokenService);
    }

    public Client getClient(Transport transport) {
        if (!transport.getServer().isLegacy()) {
            return new CellsClient(transport, new PojoS3Client((CellsTransport) transport));
        }
        return super.getClient(transport);
    }
}
