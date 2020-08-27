package com.pydio.sdk.sync.tree;

import java.util.List;
import java.util.TreeMap;

import com.pydio.sdk.core.model.TreeNodeInfo;

/**
 * Wraps a TreeMap to simply store the full tree in memory. Children are
 * computed based on the passed path.
 */
public class MemoryStateManager implements StateManager {

    private TreeMap<String, TreeNodeInfo> nodes;

    @Override
    public void put(String dir, TreeNodeInfo node) {

    }

    @Override
    public TreeNodeInfo get(String path) {
        return nodes.get(path);
    }

    @Override
    public void update(String path, TreeNodeInfo node) {
        nodes.put(path, node);
    }

    @Override
    public void remove(String path) {
        nodes.remove(path);
    }

    @Override
    public List<TreeNodeInfo> getChildren(String dir) {
        // TODO implement
        // @Override
        // public List<Tree> children() {
        // List<Tree> trees = new ArrayList<>();
        // Set<String> sortedKeys = this.children.keySet();
        // for (String key : sortedKeys) {
        // trees.add(this.children.get(key));
        // }
        // return trees;
        // }
        return null;
    }

}
