package com.pydio.cells.sync.changes;

import com.pydio.cells.api.Change;

import java.util.List;

public interface ChangeStore {
    void putChanges(List<Change> c);

    void deleteChange(Change c);

    void putChange(Change c);

    List<Change> getChanges(int count);

    int count();
}
