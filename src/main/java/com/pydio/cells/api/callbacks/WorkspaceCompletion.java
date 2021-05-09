package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;
import com.pydio.cells.api.nodes.WorkspaceNode;

public interface WorkspaceCompletion {
    void onComplete(WorkspaceNode w, Error error);
}
