package com.pydio.cells.sync.tree;

import com.pydio.cells.client.model.TreeNodeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Wraps a TreeMap to simply store the full tree in memory. Children are
 * computed based on the passed path.
 */
public class MemoryStateManager implements StateManager {

    private final TreeMap<String, TreeNodeInfo> nodes;

    public MemoryStateManager() {
        nodes = new TreeMap<String, TreeNodeInfo>();
    }

    @Override
    public void put(String path, TreeNodeInfo node) {
        nodes.put(path, node);
    }

    @Override
    public TreeNodeInfo get(String path) {
        return nodes.get(path);
    }

    // @Override
    // public void update(String path, TreeNodeInfo node) {
    //     nodes.put(path, node);
    // }

    @Override
    public void remove(String path) {
        nodes.remove(path);
    }

    /**
     * Optimistic vanilla implementation of the getChildren method for the PoC
     */
    @Override
    public List<TreeNodeInfo> getChildren(String path) {

        ArrayList<TreeNodeInfo> children = new ArrayList<>();

        // Boolean first = true;
        for (Map.Entry<String, TreeNodeInfo> currEntry : nodes.tailMap(path).entrySet()) {
            // if (first){
            //     first = false;
            //     continue;
            // }
            if (!currEntry.getKey().startsWith(path)) {
                break;
            } else if (currEntry.getKey().indexOf("/", path.length() + 1) > 1) {
                // We do not want children of our children. 
                // TODO enhance, this is not very reliable
                continue;
            } else {
                children.add(currEntry.getValue());
            }
        }
        return children;
    }

}
