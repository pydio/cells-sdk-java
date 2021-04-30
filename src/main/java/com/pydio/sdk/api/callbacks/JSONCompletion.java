package com.pydio.sdk.api.callbacks;

import com.pydio.sdk.api.Error;

import org.json.JSONObject;

public interface JSONCompletion {
    void onComplete(JSONObject o, Error error);
}
