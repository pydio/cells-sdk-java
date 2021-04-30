package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.Message;

public interface MessageCompletion {
    void onComplete(Message msg, Error error);
}
