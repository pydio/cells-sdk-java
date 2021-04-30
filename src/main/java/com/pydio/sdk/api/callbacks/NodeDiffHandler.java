package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.core.model.NodeDiff;

public interface NodeDiffHandler {
    void onNodeDiff(NodeDiff diff);
}
