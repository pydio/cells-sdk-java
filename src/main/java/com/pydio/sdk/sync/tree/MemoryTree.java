package com.pydio.sdk.sync.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;

/**
 * MemoryTree is a representation of node tree in memory
 * It provides methods to get node ETag, name and children.
 */
public class MemoryTree implements Tree {

    private TreeMap<String, MemoryTree> children;
    private String eTag;
    private String name;
    private boolean isDir;

    public MemoryTree() {
        this.children = new TreeMap<>();
    }

    public static MemoryTree FromEncoded(String encoded) {
        return new Gson().fromJson(encoded, MemoryTree.class);
    }

    public Map<String, MemoryTree> getChildren() {
        return children;
    }

    public void setChildren(TreeMap<String, MemoryTree> children) {
        this.children = children;
    }

    public String getETag() {
        return eTag;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public String getName() {
        return name;
    }
    @Override
    public List<Tree> children() {
        List<Tree> trees = new ArrayList<>();
        Set<String> sortedKeys = this.children.keySet();
        for (String key: sortedKeys) {
            trees.add(this.children.get(key));
        }
        return trees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
    }

    public String encode() {
        return new Gson().toJson(this);
    }
}
