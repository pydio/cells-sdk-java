package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;
import com.pydio.cells.api.Node;

import java.util.List;

public interface NodeListCompletion {
    void onComplete(List<Node> nodes, Error error);
}
