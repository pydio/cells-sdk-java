package com.pydio.cells.api.ui;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.client.model.Action;

import java.util.List;
import java.util.Properties;

public abstract class AbstractNode implements Node, Comparable<Node>, SdkNames {

    protected Properties properties;

    @Override
    public void setProperties(Properties p) {
        properties = p;
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key, "");
    }

    @Override
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new Properties();
        }
        properties.setProperty(key, value);
    }

    @Override
    public void deleteProperty(String key) {
        if (properties != null && properties.contains(key)) {
            properties.remove(key);
        }
    }

    /**
     * Handle comparison when nodes are not of the same type
     */
    @Override
    public int compareTo(Node node) {
        if (node == null){
            return 1;
        }
        return getWeight(node) - getWeight(this);
    }

    private int getWeight(Node node) {
        switch (node.getType()) {
            case TYPE_WORKSPACE:
                return 1;
            case TYPE_REMOTE_NODE:
                return 2;
            default:
                return 99;
        }
    }


}
