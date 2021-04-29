package com.pydio.sdk.core.model;

import com.pydio.sdk.api.Node;

import java.util.Properties;

public class ObjectNode implements com.pydio.sdk.api.Node {

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
        if(properties != null && properties.contains(key)){
            properties.remove(key);
        }
    }

    @Override
    public int getType() {
        return com.pydio.sdk.api.Node.TYPE_LOCAL_NODE;
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

    @Override
    public boolean equals(Object o) {
        try {
            return this == o || (o instanceof com.pydio.sdk.api.Node) && ((com.pydio.sdk.api.Node) o).getType() == getType() && getLabel().equals(((com.pydio.sdk.api.Node) o).getLabel()) && getPath().equals(((com.pydio.sdk.api.Node) o).getPath());
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public String getEncoded() {
        return null;
    }

    @Override
    public int compare(Node node) {
        return 0;
    }

    @Override
    public String getEncodedHash() {
        return null;
    }
}
