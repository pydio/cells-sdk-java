package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

public class P8ClientFactory {
    public Pydio8 get(ServerNode node) {
        return new Pydio8(node);
    }
}
