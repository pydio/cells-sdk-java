package com.pydio.cells.legacy;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.utils.Params;

public class P8Request {

    private String method;
    private String action;
    private Params headers;
    private Params params;
    private P8RequestBody body;
    private String secureToken;
    private boolean ignoreCookies;
    private Credentials credentials;

//    public static P8RequestBuilder newBuilder() {
//        return new P8RequestBuilder();
//    }

    public String getMethod() {

        if (method != null && !"".equals(method)) {
            return method;
        }

        // Local hack to have a reasonable default if method is not set.
        if (body == null && params == null) {
            return "GET";
        } else if (params == null) {
            return "PUT";
        } else {
            return "POST";
        }
    }

    public String getAction() {
        return action;
    }

    public Params getHeaders() {
        return headers;
    }

    public Params getParams() {
        return params;
    }


    public P8RequestBody getBody() {
        return body;
    }

    public String getSecureToken() {
        return secureToken;
    }

    public boolean getIgnoreCookies() {
        return ignoreCookies;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setAction(String action) {
        this.action = action;
        setParam(P8Names.getAction, action);
    }

    public void setParam(String name, String value) {
        if (params == null) {
            params = Params.create(name, value);
        } else {
            params.set(name, value);
        }
    }

    public void setHeader(String name, String value) {
        if (headers == null) {
            headers = Params.create(name, value);
        } else {
            headers.set(name, value);
        }
    }

    public void setBody(P8RequestBody body) {
        this.body = body;
    }

    public void setSecureToken(String secureToken) {
        this.secureToken = secureToken;
    }

    public void setIgnoreCookies(boolean ignoreCookies) {
        this.ignoreCookies = ignoreCookies;
    }

}
