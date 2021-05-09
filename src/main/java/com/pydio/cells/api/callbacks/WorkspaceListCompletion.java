package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;
import com.pydio.cells.api.ui.WorkspaceNode;

import java.util.List;

public interface WorkspaceListCompletion {
    void onComplete(List<WorkspaceNode> nodes, Error error);
}
