package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;

public interface Completion {
    void onComplete(Error error);
}
