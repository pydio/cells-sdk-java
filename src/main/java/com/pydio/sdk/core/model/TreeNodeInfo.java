package com.pydio.sdk.core.model;

public interface TreeNodeInfo {

    String getETag();

    String getName();

    String getPath();

    boolean isLeaf();

    long getSize();

    long getLastEdit();
}
