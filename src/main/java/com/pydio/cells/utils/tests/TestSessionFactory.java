package com.pydio.cells.utils.tests;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.S3Client;
import com.pydio.cells.client.CellsClient;
import com.pydio.cells.client.SessionFactory;
import com.pydio.cells.transport.auth.TokenService;

public class TestSessionFactory extends SessionFactory {

    public TestSessionFactory(TokenService tokenService) {
        super(tokenService);
    }

    public Client getClient(Transport transport, S3Client s3Client) {
        if (!transport.getServer().isLegacy()) {
            return new CellsClient(transport, s3Client);
        }
        return super.getClient(transport);
    }
}
