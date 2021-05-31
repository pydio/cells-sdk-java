package com.pydio.cells.client;

import com.pydio.cells.api.Transport;

@Deprecated
public class CellsClientFactory {

    public CellsClient get(Transport session) {
        return new CellsClient(session, null);
    }

}
