package com.pydio.sdk.core.model;

import com.pydio.sdk.api.nodes.FileNode;

import java.util.List;

public class FileNodeList {
    public int page;
    public int pageCount;
    public int offset;
    public int nodeCount;
    public List<FileNode> list;
}
