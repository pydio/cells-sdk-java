package com.pydio.sdk.core;

import com.pydio.sdk.api.nodes.ServerNode;

public class P8ClientFactory {
    public P8Client get(ServerNode node) {
        return new P8Client(node);
    }
}
