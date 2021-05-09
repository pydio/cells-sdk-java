package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Error;

import org.json.JSONObject;

public interface JSONCompletion {
    void onComplete(JSONObject o, Error error);
}
