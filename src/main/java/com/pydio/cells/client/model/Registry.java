package com.pydio.cells.client.model;

import com.pydio.cells.api.ui.Plugin;
import com.pydio.cells.api.ui.WorkspaceNode;

import java.util.List;

/**
 * Registry is an object that holds info about workspaces, actions and plugins that are available on
 * a remote Pydio Server
 *
 * One way to view it as an XML document is to access your Pydio server via the web browser and
 * using the developer, type and execute the following javascript function: <code>pydio.getXmlRegistry();</code>
 */
public interface Registry {

    List<WorkspaceNode> GetWorkspaces();

    List<Action> GetActions();

    List<Plugin> GetPlugins();

}
