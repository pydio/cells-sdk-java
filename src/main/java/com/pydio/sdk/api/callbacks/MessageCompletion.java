package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.Message;

public interface MessageCompletion {
    void onComplete(Message msg, Error error);
}
