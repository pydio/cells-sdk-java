package com.pydio.cells.api;

import com.pydio.cells.api.ui.Plugin;
import com.pydio.cells.api.ui.WorkspaceNode;
import com.pydio.cells.client.model.Action;

import java.util.List;

/**
 * The registry holds info about workspaces, actions and plugins that are available on a remote Pydio Server.
 * <p>
 * Tip: you can view the registry of your Pydio server via the developer console of your web browser.
 * Just type and execute the following javascript function: {@code pydio.getXmlRegistry();}
 */
public interface Registry {

    List<WorkspaceNode> GetWorkspaces();

    List<Action> GetActions();

    List<Plugin> GetPlugins();
}
