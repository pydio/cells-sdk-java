package com.pydio.cells.client.model;

import com.pydio.cells.api.ui.AbstractNode;
import com.pydio.cells.api.ui.Node;

public class ObjectNode extends AbstractNode {

    protected String path;
    protected String label;

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
    public int compareTo(Node node) {
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
}
