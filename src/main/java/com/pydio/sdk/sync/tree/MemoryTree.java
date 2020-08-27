package com.pydio.sdk.sync.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * MemoryTree is a representation of node tree in memory. It provides methods to
 * get node ETag, name and children.
 */
public class MemoryTree implements Tree {

    private TreeMap<String, MemoryTree> children;
    private String eTag;
    private long size;
    private String name;
    private String path;
    private boolean isLeaf;
    private String encoded;

    public TreeMap<String, MemoryTree> getChildren() {
        return children;
    }

    public void setChildren(TreeMap<String, MemoryTree> children) {
        this.children = children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    @Override
    public long getLastEdit() {
        return 0;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public boolean isLeaf() {
        return isLeaf;
    }

    @Override
    public String getETag() {
        return eTag;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getEncoded() {
        return encoded;
    }

    @Override
    public List<Tree> children() {
        List<Tree> trees = new ArrayList<>();
        Set<String> sortedKeys = this.children.keySet();
        for (String key : sortedKeys) {
            trees.add(this.children.get(key));
        }
        return trees;
    }
}
