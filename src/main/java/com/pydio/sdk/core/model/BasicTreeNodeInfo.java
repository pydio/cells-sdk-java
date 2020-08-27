package com.pydio.sdk.core.model;

import static com.pydio.sdk.core.utils.CellsPath.nameFromFullPath;

public class BasicTreeNodeInfo implements TreeNodeInfo {
    private String eTag;
    private long size;
    private String name;
    private String path;
    private boolean isLeaf;

    public BasicTreeNodeInfo() {
    }

    public BasicTreeNodeInfo(String eTag, String path, boolean isLeaf, long size) {
        this.eTag = eTag;
        this.path = path;
        this.name = nameFromFullPath(path);
        this.isLeaf = isLeaf;
        this.size = size;
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

}