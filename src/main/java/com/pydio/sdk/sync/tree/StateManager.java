package com.pydio.sdk.sync.tree;

public interface StateManager {
    void saveState(String dir, Tree tree);
    Tree getState(String dir);
}
