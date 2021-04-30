package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Message;

public interface MessageHandler {
    void onMessage(Message m);
}
