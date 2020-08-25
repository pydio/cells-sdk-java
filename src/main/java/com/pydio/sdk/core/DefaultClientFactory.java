package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

public class DefaultClientFactory extends ClientFactory {
    @Override
    public Client Client(ServerNode node) {
        if (node.versionName().contains("cells")) {
            return new PydioCells(node);
        }
        return new Pydio8(node);
    }
}
