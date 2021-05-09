package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;

public interface Completion {
    void onComplete(Error error);
}
