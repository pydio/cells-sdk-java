package com.pydio.sdk.sync.tree;

import java.util.List;

import com.pydio.sdk.core.model.TreeNodeInfo;

public interface StateManager {
    void put(String path, TreeNodeInfo node);

    TreeNodeInfo get(String path);

    void update(String path, TreeNodeInfo node);

    void remove(String path);

    List<TreeNodeInfo> getChildren(String path);
}
