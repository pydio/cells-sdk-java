package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import java.util.List;

public interface WorkspaceListCompletion {
    void onComplete(List<WorkspaceNode> nodes, Error error);
}
