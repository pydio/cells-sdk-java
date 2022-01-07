package com.pydio.cells.api.ui;

/**
 * Represents a file or a folder META information.
 * <p>
 * Warning: comparison only rely on the node type (folders before files) and name,
 * neither on the workspace slug nor on the path so that list can be ordered,
 * even in e.g. search results
 */
public class FileNode extends AbstractNode {

    /* Node generic methods */

    @Override
    public int getType() {
        return Node.TYPE_REMOTE_NODE;
    }

    @Override
    public String getId() {
        return properties.getProperty(NODE_PROPERTY_UUID);
    }

    @Override
    public String getLabel() {
        return properties.getProperty(NODE_PROPERTY_TEXT);
    }

    @Override
    public String getPath() {
        // TODO hack until we clean this in legacy P8
        String path = properties.getProperty(NODE_PROPERTY_PATH);
        String name = properties.getProperty(NODE_PROPERTY_FILENAME);

        if ((path == null || "".equals(path)) && name != null && !"".equals(name)) {
            setProperty(NODE_PROPERTY_PATH, name);
            return "/" + name;
            // TODO should we also extract the real name from the path ?
        }
        return path;
    }

    /* File and folder specific methods */
    public String getMimeType() {
        return properties.getProperty(NODE_PROPERTY_MIME);
    }

    public boolean isImage() {
        return
                // Cells
                Boolean.parseBoolean(properties.getProperty(NODE_PROPERTY_IS_IMAGE))
                        // P8
                        || "1".equals(properties.getProperty(NODE_PROPERTY_IS_IMAGE));
    }

    public boolean isFile() {
        return Boolean.parseBoolean(properties.getProperty(NODE_PROPERTY_IS_FILE));
    }

    public boolean isFolder() {
        String mime = getProperty(NODE_PROPERTY_IS_FILE);
        return "false".equals(mime);
    }

    public String getETag() {
        return properties.getProperty(NODE_PROPERTY_ETAG);
    }

    public long lastModified() {
        try {
            return Long.parseLong(properties.getProperty(NODE_PROPERTY_MTIME));
        } catch (Exception e) {
            return 0;
        }
    }

    public long size() {
        String strSize = properties.getProperty(NODE_PROPERTY_BYTESIZE);
        if (strSize == null || "".equals(strSize))
            return 0;
        return Long.parseLong(strSize);
    }

    public String getWorkspaceSlug() {
        return this.getProperty(NODE_PROPERTY_WORKSPACE_SLUG);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (!(obj instanceof FileNode)) return false;

        FileNode other = (FileNode) obj;
        return getWorkspaceSlug().equals(other.getWorkspaceSlug()) &&
                getPath().equals(other.getPath());
    }

    @Override
    public int compareTo(Node node) {
        if (node == null) {
            return 1;
        }

        // TODO finalize this, do we want to compare node with e.g. workspaces?
        if (!(node instanceof FileNode)) {
            return -1;
        }

        FileNode other = (FileNode) node;

        if (isFolder() && other.isFile()) {
            return -1;
        } else if (isFile() && other.isFolder()) {
            return 1;
        }

        return getLabel().compareTo(other.getLabel());
    }
}