package com.pydio.sdk.core.common.callback;

import com.pydio.sdk.api.Error;

import org.json.JSONObject;

public interface JSONCompletion {
    void onComplete(JSONObject o, Error error);
}
