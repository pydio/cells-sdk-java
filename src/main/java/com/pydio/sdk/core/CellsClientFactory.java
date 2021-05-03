package com.pydio.sdk.core;

import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.nodes.ServerNode;

public class CellsClientFactory {

    public CellsClient get(ISession session) {
        return new CellsClient(session);
    }

}
