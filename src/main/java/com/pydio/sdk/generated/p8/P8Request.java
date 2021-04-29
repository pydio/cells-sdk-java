package com.pydio.sdk.generated.p8;

import com.pydio.sdk.core.common.http.ContentBody;
import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.core.utils.Params;

public class P8Request {

    Credentials credentials;
    String method;
    String action;
    Params params;
    Params headers;
    ContentBody body;
    String secureToken;
    boolean ignoreCookies;

    public static P8RequestBuilder newBuilder() {
        return new P8RequestBuilder();
    }
}
