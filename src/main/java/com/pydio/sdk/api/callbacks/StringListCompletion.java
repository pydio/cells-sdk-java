package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;

public interface StringListCompletion {
    void onComplete(String[] list, Error error);
}
