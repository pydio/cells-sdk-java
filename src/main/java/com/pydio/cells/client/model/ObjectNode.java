package com.pydio.cells.client.model;

import com.pydio.cells.api.ui.Node;

import java.util.Properties;

public class ObjectNode implements Node {

    protected String path;
    protected String label;
    private Properties properties;

    @Override
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new Properties();
        }
        properties.setProperty(key, value);
    }

    @Override
    public void setProperties(Properties p) {
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key, "");
    }

    @Override
    public void deleteProperty(String key) {
        if (properties != null && properties.contains(key)) {
            properties.remove(key);
        }
    }

    @Override
    public int getType() {
        return Node.TYPE_LOCAL_NODE;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getLabel() {
        return label;
    }

    // TODO implement this

    @Override
    public int compare(Node node) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        try {
            return this == o || (o instanceof Node) && ((Node) o).getType() == getType() && getLabel().equals(((Node) o).getLabel()) && getPath().equals(((Node) o).getPath());
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String getEncoded() {
        return null;
    }

    @Override
    public String getEncodedHash() {
        return null;
    }
}
