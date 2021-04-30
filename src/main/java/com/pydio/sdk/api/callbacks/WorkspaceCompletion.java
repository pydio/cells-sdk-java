package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.core.model.WorkspaceNode;

public interface WorkspaceCompletion {
    void onComplete(WorkspaceNode w, Error error);
}
