package com.pydio.sdk.core.model;

import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.SdkNames;

import java.util.Properties;

public class FileNode implements com.pydio.sdk.api.Node, SdkNames {

    public Properties properties = new Properties();

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

    public boolean equals(Object o) {
        boolean instanceOfNode = o instanceof com.pydio.sdk.api.Node;
        if (!instanceOfNode) {
            return false;
        }

        com.pydio.sdk.api.Node node = (com.pydio.sdk.api.Node) o;

        String workspaceSlug = getWorkspaceSlug();
        String nWorkspaceSlug = node.getProperty(NODE_PROPERTY_WORKSPACE_SLUG);

        String path = path();
        String nPath = node.path();

        return workspaceSlug.equals(nWorkspaceSlug) && nPath.equals(path);
    }

    @Override
    public String label() {
        return properties.getProperty(NODE_PROPERTY_TEXT);
    }

    @Override
    public String path() {
        return properties.getProperty(NODE_PROPERTY_FILENAME);
    }

    @Override
    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    @Override
    public int type() {
        return com.pydio.sdk.api.Node.TYPE_REMOTE_NODE;
    }

    @Override
    public String id() {
        return properties.getProperty(NODE_PROPERTY_UUID);
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

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

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

        String path = path();
        String nPath = node.path();

        if (nPath.equals(path)) {
            return same;
        }

        return different;
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
