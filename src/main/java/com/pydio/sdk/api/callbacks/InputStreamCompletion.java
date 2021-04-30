package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;

import java.io.InputStream;

public interface InputStreamCompletion {
    void onComplete(InputStream in, Error error);
}
