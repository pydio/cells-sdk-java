package com.pydio.sdk.core;

import com.pydio.sdk.api.ISession;

public class P8ClientFactory {
    public P8Client get(ISession session) {
        return new P8Client(session);
    }
}
