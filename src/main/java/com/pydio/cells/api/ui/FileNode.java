package com.pydio.cells.api.ui;

/**
 * Extends Node interface adding File specific methods
 */
public interface FileNode extends Node {

    boolean isImage();

    boolean isFile();

    boolean isFolder();

    String getETag();

    long lastModified();

    long size();

    String getWorkspaceSlug();
}
