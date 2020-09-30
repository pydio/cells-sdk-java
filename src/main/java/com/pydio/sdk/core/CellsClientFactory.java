package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

public class CellsClientFactory {
    public PydioCells get(ServerNode node) {
        return new PydioCells(node);
    }
}
