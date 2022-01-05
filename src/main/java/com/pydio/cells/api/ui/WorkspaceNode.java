package com.pydio.cells.api.ui;

import com.pydio.cells.client.model.Action;

import java.util.List;

/**
 * Holds information about a distant workspace, in both Cells and legacy P8.
 * <p>
 * Warning: for comparison and equality, we assume that the workspaces are **in the same** server;
 * the workspaces don't hold a reference to there hosting server
 */

public class WorkspaceNode extends AbstractNode {

    public final static String TYPE_PERSONAL = "workspace-personal";
    public final static String TYPE_WS = "workspace";
    public final static String TYPE_CELL = "cell";

    private List<Plugin> plugins;
    private List<Action> availableActions;

    @Override
    public String getId() {
        return getSlug();
    }

    @Override
    public int getType() {
        return Node.TYPE_WORKSPACE;
    }

    @Override
    public String getPath() {
        return "/";
    }


    /* WORKSPACES SPECIFIC PROPERTIES */

    public void setActions(List<Action> actions) {
        this.availableActions = actions;
    }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    public Plugin getPlugin(String id) {
        if (plugins == null) {
            return null;
        }

        for (Plugin p : plugins) {
            if (id.equals(p.getId())) {
                return p;
            }
        }

        return null;
    }

    /* Getters */

    public String getDescription() {
        return properties.getProperty(NODE_PROPERTY_DESCRIPTION);
    }

    public String getLabel() {
        return properties.getProperty(NODE_PROPERTY_LABEL);
    }


    public String getSlug() {
        return properties.getProperty(WORKSPACE_PROPERTY_SLUG);
    }

    public String getAccessType() {
        return properties.getProperty(WORKSPACE_PROPERTY_ACCESS_TYPE);
    }

    public String getWorkspaceType() {
        return properties.getProperty(WORKSPACE_PROPERTY_TYPE);
    }

    public String getACL() {
        return properties.getProperty(WORKSPACE_PROPERTY_ACL);
    }

    public String getOwner() {
        return properties.getProperty(WORKSPACE_PROPERTY_OWNER);
    }

    public boolean isPublic() {
        return "true".equals(properties.getProperty(WORKSPACE_IS_PUBLIC));
    }

    public boolean isReadable() {
        return "r".equals(getACL()) || "rw".equals(getACL());
    }

    public boolean isWriteable() {
        return "w".equals(getACL()) || "rw".equals(getACL());
    }

    public boolean isReadActionAllowed(String action) {
        if (availableActions == null || availableActions.size() == 0) {
            return true;
        }

        for (Action a : availableActions) {
            if (action.equals(a.name)) {
                return a.read != null ? a.read : isReadable();
            }
        }
        return true;
    }

    public boolean isWriteActionAllowed(String action) {
        if (availableActions == null || availableActions.size() == 0) {
            return true;
        }

        for (Action a : availableActions) {
            if (action.equals(a.name)) {
                return a.write != null ? a.write : isWriteable();
            }
        }
        return true;
    }

    public boolean isShared() {
        return "true".equals(properties.getProperty(NODE_PROPERTY_AJXP_SHARED)) || "shared".equals(properties.getProperty(WORKSPACE_PROPERTY_OWNER));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorkspaceNode)) return false;
        // we rely on the workspace slug that is unique by construction
        return getSlug().equals(((WorkspaceNode) obj).getSlug());
    }

    @Override
    public int compareTo(Node node) {
        // Handles different types and null values
        int res = super.compareTo(node);
        if (res != 0) return res;

        // Specific order for workspaces with My File first
        WorkspaceNode other = (WorkspaceNode) node;
        res = getWeight(other) - getWeight(this);
        if (res != 0) return res;

        return getLabel().compareTo(other.getLabel());
    }

    private int getWeight(WorkspaceNode wn) {
        switch (wn.getWorkspaceType()) {
            case TYPE_PERSONAL:
                return 3;
            case TYPE_WS:
                return 2;
            case TYPE_CELL:
                return 1;
            default:
                return 0;
        }
    }
}
