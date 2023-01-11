package com.pydio.cells.client.model;

import static com.pydio.cells.utils.CellsPath.nameFromFullPath;

import com.google.gson.Gson;

public class TreeNodeInfo {

    private String eTag;
    private long size;
    private long lastEdit;
    private String name;
    private String path;
    private boolean isLeaf;

    public TreeNodeInfo() {
    }

    public TreeNodeInfo(String eTag, String path, boolean isLeaf, long size, long lastEdit) {
        this.eTag = eTag;
        this.path = path;
        this.name = nameFromFullPath(path);
        this.isLeaf = isLeaf;
        this.size = size;
        this.lastEdit = lastEdit;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
        this.name = nameFromFullPath(path);
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public void setLastEdit(long lastEdit) {
        this.lastEdit = lastEdit;
    }

    public long getLastEdit() {
        return lastEdit;
    }

    public long getSize() {
        return size;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public String getETag() {
        return eTag;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String encoded() {
        return new Gson().toJson(this);
    }

    public static TreeNodeInfo fromEncoded(String encoded) {
        return new Gson().fromJson(encoded, TreeNodeInfo.class);
    }
}
