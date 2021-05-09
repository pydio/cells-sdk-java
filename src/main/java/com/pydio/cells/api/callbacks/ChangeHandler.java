package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Change;

public interface ChangeHandler {
    void onChange(Change c);
}
