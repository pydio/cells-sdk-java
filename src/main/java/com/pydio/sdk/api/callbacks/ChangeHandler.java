package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Change;

public interface ChangeHandler {
    void onChange(Change c);
}
