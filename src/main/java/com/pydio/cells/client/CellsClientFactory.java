package com.pydio.cells.client;

import com.pydio.cells.api.ISession;

@Deprecated
public class CellsClientFactory {

    public CellsClient get(ISession session) {
        return new CellsClient(session);
    }

}
