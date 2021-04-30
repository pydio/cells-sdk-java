package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;

public interface StringCompletion {
    void onComplete(String str, Error error);
}
