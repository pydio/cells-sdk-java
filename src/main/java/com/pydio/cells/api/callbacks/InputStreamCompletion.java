package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;

import java.io.InputStream;

public interface InputStreamCompletion {
    void onComplete(InputStream in, Error error);
}
