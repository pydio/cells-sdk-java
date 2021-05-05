package com.pydio.sdk.core;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.api.ISession;

public class ClientFactory {

    private static CellsClientFactory cellsDefaultFactory = new CellsClientFactory();
    private static P8ClientFactory p8DefaultFactory = new P8ClientFactory();

    public static void setCellsFactory(CellsClientFactory f) {
        cellsDefaultFactory = f;
    }

    public static void setP8Factory(P8ClientFactory f) {
        p8DefaultFactory = f;
    }

    public static Client get(ISession session) {
        if (session.getServer().isLegacy()){
            return p8DefaultFactory.get(session);
        }
            return cellsDefaultFactory.get(session);
    }
}
