package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;

public interface Completion {
    void onComplete(Error error);
}
