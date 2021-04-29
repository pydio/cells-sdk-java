package com.pydio.sdk.core.model;

import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.core.server.Plugin;

import java.util.List;
import java.util.Properties;

public class WorkspaceNode implements com.pydio.sdk.api.Node, SdkNames {
    private Properties properties;
    private Properties preferences;
    private List<Plugin> plugins;

    //@deprecated
    private List<String> actions;

    private List<Action> availableActions;

    public boolean allowsCrossCopy() {
        return "true".equals(properties.getProperty(WORKSPACE_PROPERTY_CROSS_COPY));
    }

    public String slug() {
        return properties.getProperty(WORKSPACE_PROPERTY_SLUG);
    }

    public String getDescription() {
        return properties.getProperty(NODE_PROPERTY_DESCRIPTION);
    }

    public String getAccessType() {
        return properties.getProperty(WORKSPACE_PROPERTY_ACCESS_TYPE);
    }

    public boolean syncable() {
        return "true".equals(getProperty(WORKSPACE_PROPERTY_META_SYNC));
    }

    public String label() {
        return properties.getProperty(NODE_PROPERTY_LABEL);
    }

    public String getId() {
        return properties.getProperty(WORKSPACE_PROPERTY_SLUG);
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

    public boolean isSyncable() {
        return "true".equals(getProperty(WORKSPACE_PROPERTY_META_SYNC));
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

    public void setActions(List<Action> actions) {
        this.availableActions = actions;
    }

    public void setPreferences(Properties prefs) {
        this.preferences = prefs;
    }

    public void setPlugins(List<Plugin> plugins){
        this.plugins = plugins;
    }

    public Plugin getPlugin(String id) {
        if (this.plugins == null){
            return null;
        }

        for(Plugin p: this.plugins){
            if(id.equals(p.id)){
                return p;
            }
        }

        return null;
    }

    public boolean isLoaded() {
        return this.actions != null && this.preferences != null && this.plugins != null;
    }
    //********************************************************************************************
    //                  Super class: NODE METHODS
    //********************************************************************************************
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
        if(properties != null && properties.contains(key)){
            properties.remove(key);
        }
    }

    @Override
    public int type() {
        return com.pydio.sdk.api.Node.TYPE_WORKSPACE;
    }

    @Override
    public String id() {
        return properties.getProperty(WORKSPACE_PROPERTY_SLUG);
    }

    @Override
    public String path() {
        return "/";
    }

    @Override
    public boolean equals(Object o) {
        try {
            return this == o || (o instanceof WorkspaceNode) && ((WorkspaceNode) o).getId() == getId() && ((WorkspaceNode) o).label() == label();
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
