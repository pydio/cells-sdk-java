package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Message;

public interface MessageHandler {
    void onMessage(Message m);
}
