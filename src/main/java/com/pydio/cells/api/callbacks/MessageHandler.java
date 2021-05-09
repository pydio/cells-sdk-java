package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Message;

public interface MessageHandler {
    void onMessage(Message m);
}
