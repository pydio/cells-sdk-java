package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.core.model.NodeDiff;

public interface NodeDiffHandler {
    void onNodeDiff(NodeDiff diff);
}
