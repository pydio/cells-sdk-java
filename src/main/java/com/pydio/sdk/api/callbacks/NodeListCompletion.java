package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.Node;

import java.util.List;

public interface NodeListCompletion {
    void onComplete(List<Node> nodes, Error error);
}
