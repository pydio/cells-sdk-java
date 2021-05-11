package com.pydio.cells.client;

import com.pydio.cells.api.Transport;
import com.pydio.cells.legacy.P8Client;

@Deprecated
public class P8ClientFactory {
    public P8Client get(Transport session) {
        return new P8Client(session);
    }
}
