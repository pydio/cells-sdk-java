package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;

import java.io.InputStream;

public interface InputStreamCompletion {
    void onComplete(InputStream in, Error error);
}
