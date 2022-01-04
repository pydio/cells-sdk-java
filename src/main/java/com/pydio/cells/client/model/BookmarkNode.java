package com.pydio.cells.client.model;

import com.pydio.cells.api.ui.Node;

import java.util.Properties;

public class BookmarkNode implements Node {

    private final String label;
    private Properties properties;

    public BookmarkNode(String label) {
        this.label = label;
        this.properties = new Properties();
    }

    @Override
    public int getType() {
        return TYPE_BOOKMARK;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getPath() {
        return "/";
    }

    @Override
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public void setProperty(String key, String value) {
        this.properties.put(key, value);
    }

    @Override
    public void deleteProperty(String key) {
        this.properties.remove(key);
    }

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

    @Override
    public String getEncoded() {
        return "";
    }

    @Override
    public int compareTo(Node node) {
        // TODO implement
        if (node == null) {
            return -1;
        }

        return label.compareTo(node.getLabel());
    }

}
