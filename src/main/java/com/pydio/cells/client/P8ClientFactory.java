package com.pydio.cells.client;

import com.pydio.cells.api.ISession;
import com.pydio.cells.legacy.P8Client;

@Deprecated
public class P8ClientFactory {
    public P8Client get(ISession session) {
        return new P8Client(session);
    }
}
