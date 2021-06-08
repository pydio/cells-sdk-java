package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.S3Client;
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
public abstract class SessionFactory extends ServerFactory {

    public SessionFactory(TokenService tokenService) {
        super(tokenService);
    }

    public Client getClient(Transport transport) {
        if (transport.getServer().isLegacy()) {
            return new P8Client(transport);
        } else {
            return getCellsClient(transport);
        }
    }

    /* This is only intended for extending factories, so that they have a single entry point to inject the S3 client */
    protected abstract CellsClient getCellsClient(Transport transport);
//    {
//            // return new CellsClient(transport, new PojoS3Client((CellsTransport)transport));
//            return new CellsClient(transport, s3Client);
//    }


    @Override
    /* Only update info that are specific to this layer */
    protected void initAppData() {
        super.initAppData();
        ClientData.packageID = this.getClass().getPackage().getName();
        ClientData.name = "CellsJavaClient";
    }


}
