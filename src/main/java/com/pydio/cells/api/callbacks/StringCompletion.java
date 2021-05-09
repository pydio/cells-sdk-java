package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;

public interface StringCompletion {
    void onComplete(String str, Error error);
}
