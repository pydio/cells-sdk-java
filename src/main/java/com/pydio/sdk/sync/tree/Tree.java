package com.pydio.sdk.sync.tree;

import java.util.List;

public interface Tree {
    boolean isLeaf();
    String getETag();
    String getName();
    long getSize();
    long getLastEdit();
    List<Tree> children();
}
