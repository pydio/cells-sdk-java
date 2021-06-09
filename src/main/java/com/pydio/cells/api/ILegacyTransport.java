package com.pydio.cells.api;

import org.json.JSONObject;

import java.io.InputStream;

public interface ILegacyTransport extends Transport {

    InputStream getCaptcha() throws SDKException;

    boolean useCaptcha();

    JSONObject authenticationInfo() throws SDKException;


}
