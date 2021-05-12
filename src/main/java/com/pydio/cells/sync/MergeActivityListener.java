package com.pydio.cells.sync;

import com.pydio.cells.api.Change;

public interface MergeActivityListener {
    void onActionCompleted(Change c);

    void onActionFailed(Error error, Change c);

    void onChangesCount(Watch w, int count);
}
