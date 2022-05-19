package com.pydio.cells.api.ui;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.utils.Str;

import java.util.Properties;

/**
 * Represents a file or a folder META information.
 */
public class FileNode extends AbstractNode {

    /* Node generic methods */

    @Override
    public int getType() {
        return Node.TYPE_REMOTE_NODE;
    }

    @Override
    public String getId() {
        return properties.getProperty(NODE_PROPERTY_UID);
    }

    @Override
    public String getName() {
        return properties.getProperty(NODE_PROPERTY_FILENAME);
    }

    @Override
    public String getLabel() {
        String label = properties.getProperty(NODE_PROPERTY_TEXT);
        if (Str.empty(label)){
            return getName();
        } else {
            return label;
        }
    }

    @Override
    public String getPath() {
        return  properties.getProperty(NODE_PROPERTY_PATH);
    }

    /* File and folder specific methods */
    public String getWorkspace() {
        return this.getProperty(NODE_PROPERTY_WORKSPACE_SLUG);
    }

    public String getETag() {
        return properties.getProperty(NODE_PROPERTY_ETAG);
    }

    public String getMimeType() {
        return properties.getProperty(NODE_PROPERTY_MIME);
    }

    public long getSize() {
        String strSize = properties.getProperty(NODE_PROPERTY_BYTESIZE);
        if (strSize == null || "".equals(strSize))
            return 0;
        return Long.parseLong(strSize);
    }

    public long getLastModified() {
        try {
            return Long.parseLong(properties.getProperty(NODE_PROPERTY_MTIME));
        } catch (Exception e) {
            return 0;
        }
    }

    // Keep track of all meta returned by tghe server
    protected Properties meta;

    public void setMeta(Properties p) {
        meta = p;
    }

    public Properties getMeta() {
        return meta;
    }

    public int getMetaHashCode() {
        String hashStr = properties.getProperty(NODE_PROPERTY_META_HASH);
        if (Str.empty(hashStr)) {
            return 0;
        } else {
            return Integer.parseInt(hashStr);
        }
    }

    /* Various helpers */

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

    public boolean isBookmark() {
        return "true".equals(getProperty(NODE_PROPERTY_BOOKMARK));
    }

    public boolean isShared() {
        return "true".equals(getProperty(NODE_PROPERTY_SHARED));
    }


    public boolean hasThumb() {
        return "true".equals(getProperty(NODE_PROPERTY_HAS_THUMB));
    }

    public boolean isPreViewable() {
        return "true".equals(getProperty(NODE_PROPERTY_IS_PRE_VIEWABLE));
    }

    /**
     * Equality methods
     */

    @Override
    public boolean equals(Object obj) {

        if (obj == this) return true;
        if (!(obj instanceof FileNode)) return false;

        FileNode other = (FileNode) obj;
        return getWorkspace().equals(other.getWorkspace()) &&
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

        // We rather only rely on file names for canonical sorting,
        // The "User friendly sorting" (with folder before files) must be handled by the client.
//        if (isFolder() && other.isFile()) {
//            return -1;
//        } else if (isFile() && other.isFolder()) {
//            return 1;
//        }

        return getName().compareTo(other.getName());
    }
}