package com.pydio.cells.api.callbacks;

import com.pydio.cells.client.model.NodeDiff;

public interface NodeDiffHandler {
    void onNodeDiff(NodeDiff diff);
}
