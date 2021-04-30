package com.pydio.sdk.api;

import com.pydio.sdk.core.model.Action;

import java.util.List;
import java.util.Properties;

public class WorkspaceNode implements Node, SdkNames {
    private Properties properties;
    // private Properties preferences;
    private List<Plugin> plugins;

    // private List<String> actions;

    private List<Action> availableActions;

    // public boolean allowsCrossCopy() {
    //     return "true".equals(properties.getProperty(WORKSPACE_PROPERTY_CROSS_COPY));
    // }

    public String getSlug() {
        return properties.getProperty(WORKSPACE_PROPERTY_SLUG);
    }

    public String getDescription() {
        return properties.getProperty(NODE_PROPERTY_DESCRIPTION);
    }

    public String getAccessType() {
        return properties.getProperty(WORKSPACE_PROPERTY_ACCESS_TYPE);
    }

    public String getLabel() {
        return properties.getProperty(NODE_PROPERTY_LABEL);
    }

    public String acl() {
        return properties.getProperty(WORKSPACE_PROPERTY_ACL);
    }

    public String owner() {
        return properties.getProperty(WORKSPACE_PROPERTY_OWNER);
    }

    public boolean isPublic() {
        String pub = properties.getProperty(WORKSPACE_IS_PUBLIC);
        return "true".equals(pub);
    }

    public boolean isReadable() {
        String acl = acl();
        return "r".equals(acl()) || "rw".equals(acl);
    }

    public boolean isWriteable() {
        String acl = acl();
        return "w".equals(acl) || "rw".equals(acl);
    }

    // public boolean isSyncable() {
    //     return "true".equals(getProperty(WORKSPACE_PROPERTY_META_SYNC));
    // }

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

    public void setActions(List<Action> actions) {
        this.availableActions = actions;
    }

    // public void setPreferences(Properties prefs) {
    //     this.preferences = prefs;
    // }

    public void setPlugins(List<Plugin> plugins) {
        this.plugins = plugins;
    }

    public Plugin getPlugin(String id) {
        if (this.plugins == null) {
            return null;
        }

        for (Plugin p : this.plugins) {
            if (id.equals(p.id)) {
                return p;
            }
        }

        return null;
    }

    // public boolean isLoaded() {
    //     return this.actions != null && this.preferences != null && this.plugins != null;
    // }

    /* Node methods */

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

    @Override
    public int getType() {
        return com.pydio.sdk.api.Node.TYPE_WORKSPACE;
    }

    @Override
    public String getId() {
        return getSlug();
    }

    @Override
    public String getPath() {
        return "/";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorkspaceNode)) return false;

        WorkspaceNode wn2 = (WorkspaceNode) obj;
        return getId().equals(wn2.getId());
        // TODO also compare labels ?
        // wn2.getLabel().equals(getLabel())
    }

    @Override
    public int compare(Node node) {
        // TODO implement this
        return 0;
    }

    /**
     * Unused methods for workspace nodes: it is never serialized
     */

    @Override
    public String getEncoded() {
        return null;
    }

    @Override
    public String getEncodedHash() {
        return null;
    }
}
