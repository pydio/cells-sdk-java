package com.pydio.sdk.core.model;

import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.SdkNames;

import java.util.Properties;

public class FileNode implements Node, SdkNames {

    public Properties properties = new Properties();

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

    @Override
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new Properties();
        }
        properties.put(key, value);
    }

    @Override
    public void deleteProperty(String key) {
        if (properties != null) {
            properties.remove(key);
        }
    }


    /* Helpers to manipulate path */

    public static String getNameFromPath(String path) {
        int index = path.lastIndexOf("/");
        if (index < 0) {
            return path;
        }
        return path.substring(index + 1);
    }

    public static String nameFromTreeNodePath(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public static String slugFromTreeNodePath(String path) {
        return path.substring(0, path.indexOf("/"));
    }

    public static String pathFromTreeNodePath(String path) {
        String[] parts = path.substring(path.indexOf("/") + 1).split("/");
        StringBuilder pathBuilder = new StringBuilder();
        for (String part : parts) {
            pathBuilder.append("/").append(part);
        }
        return pathBuilder.toString();
    }

    public static String  toTreeNodePath(String ws, String path) {
        return new StringBuilder(ws).append(path).toString();
    }

    /* Comparators */

    @Override
    public int compare(Node node) {
        if (node == null) {
            return different;
        }

        String workspaceSlug = getWorkspaceSlug();
        String nWorkspaceSlug = node.getProperty(NODE_PROPERTY_WORKSPACE_SLUG);

        if (!workspaceSlug.equals(nWorkspaceSlug)) {
            return different;
        }

        String path = getPath();
        String nPath = node.getPath();

        if (nPath.equals(path)) {
            return same;
        }

        return different;
    }

    public boolean equals(Object o) {
        boolean instanceOfNode = o instanceof Node;
        if (!instanceOfNode) {
            return false;
        }

        Node node = (Node) o;

        String workspaceSlug = getWorkspaceSlug();
        String nWorkspaceSlug = node.getProperty(NODE_PROPERTY_WORKSPACE_SLUG);

        String path = getPath();
        String nPath = node.getPath();

        return workspaceSlug.equals(nWorkspaceSlug) && nPath.equals(path);
    }

    public boolean isImage() {
        return Boolean.parseBoolean(properties.getProperty(NODE_PROPERTY_IS_IMAGE))
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
            return Long.parseLong(properties.getProperty(NODE_PROPERTY_AJXP_MODIFTIME));
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
    public String getLabel() {
        return properties.getProperty(NODE_PROPERTY_TEXT);
    }

    @Override
    public String getPath() {
        return properties.getProperty(NODE_PROPERTY_PATH);
    }

    @Override
    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    @Override
    public int getType() {
        return com.pydio.sdk.api.Node.TYPE_REMOTE_NODE;
    }

    @Override
    public String getId() {
        return properties.getProperty(NODE_PROPERTY_UUID);
    }

    @Override
    public String getEncodedHash() {
        if (properties == null) {
            return null;
        }
        return properties.getProperty(NODE_PROPERTY_ENCODED_HASH);
    }

    @Override
    public String getEncoded() {
        if (properties == null) {
            return null;
        }
        return properties.getProperty(NODE_PROPERTY_ENCODED);
    }

}
