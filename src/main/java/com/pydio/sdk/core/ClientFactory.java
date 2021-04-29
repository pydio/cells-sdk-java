package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

public class ClientFactory {

    private static CellsClientFactory cellsDefaultFactory = new CellsClientFactory();
    private static P8ClientFactory p8DefaultFactory = new P8ClientFactory();

    public static void setCellsFactory(CellsClientFactory f) {
        cellsDefaultFactory = f;
    }

    public static void setP8Factory(P8ClientFactory f) {
        p8DefaultFactory = f;
    }

    public static Client get(ServerNode node) {
        if (node.versionName().contains("cells")) {
            return cellsDefaultFactory.get(node);
        }
        return p8DefaultFactory.get(node);
    }
}
