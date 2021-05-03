package com.pydio.sdk.api;

import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import org.json.JSONObject;

import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Map;

public interface ILegacySession extends ISession {

    InputStream getCaptcha() throws SDKException;

    boolean useCaptcha();

    JSONObject authenticationInfo() throws SDKException;

    String getToken() throws SDKException;

}
