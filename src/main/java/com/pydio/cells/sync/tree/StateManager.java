package com.pydio.cells.sync.tree;

import java.util.List;

import com.pydio.cells.client.model.TreeNodeInfo;

public interface StateManager {

    TreeNodeInfo get(String path);

    List<TreeNodeInfo> getChildren(String path);


    /* Implicitely makes the mkdir */ 
    void put(String path, TreeNodeInfo node);
    // void update(String path, TreeNodeInfo node);

    /* Remove of a folder also remove the full sub tree implicitely */  
    void remove(String path);

}
