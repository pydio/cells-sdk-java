package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;

public interface StringListCompletion {
    void onComplete(String[] list, Error error);
}
