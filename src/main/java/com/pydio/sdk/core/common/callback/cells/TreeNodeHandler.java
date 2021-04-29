package com.pydio.sdk.core.common.callback.cells;

import com.pydio.sdk.generated.cells.model.TreeNode;

public interface TreeNodeHandler {
    void onNode(TreeNode node);
}
