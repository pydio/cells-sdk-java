package com.pydio.sdk.core.model;


public class BasicTreeNodeInfo implements TreeNodeInfo {
    private String eTag;
    private long size;
    private String name;
    private String path;
    private boolean isLeaf;
    private String encoded;

    public BasicTreeNodeInfo() {
    }

    public BasicTreeNodeInfo(String eTag, String path, String name, boolean isLeaf, long size, String encoded) {
        this.eTag = eTag;
        this.path = path;
        this.name = name;
        this.isLeaf = isLeaf;
        this.size = size;
        this.encoded = encoded;
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

}