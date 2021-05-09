package com.pydio.cells.api;

import org.json.JSONObject;

import java.io.InputStream;

public interface ILegacySession extends ISession {

    InputStream getCaptcha() throws SDKException;

    boolean useCaptcha();

    JSONObject authenticationInfo() throws SDKException;

    String getToken() throws SDKException;

}
