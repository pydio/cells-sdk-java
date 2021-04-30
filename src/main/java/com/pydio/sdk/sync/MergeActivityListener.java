package com.pydio.sdk.sync;

import com.pydio.sdk.api.Change;

public interface MergeActivityListener {
    void onActionCompleted(Change c);
    void onActionFailed(Error error, Change c);
    void onChangesCount(Watch w, int count);
}
