package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;
import com.pydio.cells.api.nodes.WorkspaceNode;

import java.util.List;

public interface WorkspaceListCompletion {
    void onComplete(List<WorkspaceNode> nodes, Error error);
}
