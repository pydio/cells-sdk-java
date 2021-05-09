package com.pydio.cells.client.model;

import com.pydio.cells.api.nodes.FileNode;

import java.util.List;

public class FileNodeList {
    public int page;
    public int pageCount;
    public int offset;
    public int nodeCount;
    public List<FileNode> list;
}
