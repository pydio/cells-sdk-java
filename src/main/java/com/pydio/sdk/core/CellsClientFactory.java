package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

public class CellsClientFactory {

    public CellsClient get(ServerNode node) {
        return new CellsClient(node);
    }

}
