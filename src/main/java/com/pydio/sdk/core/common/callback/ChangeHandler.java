package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.core.model.Change;

public interface ChangeHandler {
    void onChange(Change c);
}
