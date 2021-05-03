package com.pydio.sdk.api;

import com.pydio.sdk.api.callbacks.ServerResolver;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public interface ServerFactory {

    String TYPE_CELLS = "cells";
    String TYPE_LEGACY_P8 = "pydio";

    Server register(ServerURL serverURL) throws SDKException;

}
