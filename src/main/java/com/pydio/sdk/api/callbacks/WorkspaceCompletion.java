package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.nodes.WorkspaceNode;

public interface WorkspaceCompletion {
    void onComplete(WorkspaceNode w, Error error);
}
