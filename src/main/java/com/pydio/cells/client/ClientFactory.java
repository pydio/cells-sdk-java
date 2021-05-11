package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;

@Deprecated
public class ClientFactory {

    private static CellsClientFactory cellsDefaultFactory = new CellsClientFactory();
    private static P8ClientFactory p8DefaultFactory = new P8ClientFactory();

    public static void setCellsFactory(CellsClientFactory f) {
        cellsDefaultFactory = f;
    }

    public static void setP8Factory(P8ClientFactory f) {
        p8DefaultFactory = f;
    }

    public static Client get(Transport session) {
        if (session.getServer().isLegacy()){
            return p8DefaultFactory.get(session);
        }
            return cellsDefaultFactory.get(session);
    }
}
