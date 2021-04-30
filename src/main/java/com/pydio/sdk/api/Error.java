package com.pydio.sdk.core.common.errors;

import com.pydio.sdk.api.SDKException;

public class Error {

    public int code;

    public Error(int code) {
        this.code = code;
    }

    public static Error fromException(SDKException e) {
        return new Error(e.getCode());
    }
}

