package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;
import com.pydio.cells.api.ui.Message;

public interface MessageCompletion {
    void onComplete(Message msg, Error error);
}
