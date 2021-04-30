package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;

public interface StringCompletion {
    void onComplete(String str, Error error);
}
