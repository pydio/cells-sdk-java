package com.pydio.sdk.core;

import com.pydio.sdk.api.nodes.ServerNode;

public class CellsClientFactory {

    public CellsClient get(ServerNode node) {
        return new CellsClient(node);
    }

}
