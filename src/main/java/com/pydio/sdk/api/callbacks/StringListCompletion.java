package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;

public interface StringListCompletion {
    void onComplete(String[] list, Error error);
}
