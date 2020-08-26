package com.pydio.sdk.sync.tree;

import java.util.List;

public interface Tree {
    String getETag();
    String getName();
    List<Tree> children();
}
