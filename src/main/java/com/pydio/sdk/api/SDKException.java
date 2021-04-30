package com.pydio.sdk.core.common.errors;

import com.pydio.sdk.api.ErrorCodes;

import java.io.IOException;

/**
 * Generic exception for the java SDK that is server type agnostic and supports both Pydio Cells and the legacy Pydio 8 server.
 * It cannot yet extend the swagger generated API exception that is specific to Cells.
 * <p>
 * This can be changed when we stop supporting Pydio 8 in a near future.
 */
public class SDKException extends Exception {

    public int code;
    public Exception cause;

    public SDKException(String message) {
        super(message);
    }

    public SDKException(Throwable cause) {
        super(cause);
    }

    public SDKException(String message, Throwable cause) {
        super(message, cause);
    }

    // Legacy inherited SDK specific constructors => ease implementation of the Android app.

    public SDKException(int code, Exception cause) {
        this(ErrorCodes.toMessage(code), cause);
        this.cause = cause;
        this.code = code;
    }

    public SDKException(int code) {
        this(ErrorCodes.toMessage(code));
        this.code = code;
    }

    /* Boiler plate shortcuts */

    public static SDKException malFormURI(Exception e) {
        return new SDKException(ErrorCodes.bad_uri, e);
    }

    public static SDKException encoding(Exception e) {
        return new SDKException(ErrorCodes.encoding_failed, e);
    }

    public static SDKException conFailed(IOException e) {
        return new SDKException(ErrorCodes.con_failed, e);
    }

    public static SDKException conReadFailed(IOException e) {
        return new SDKException(ErrorCodes.con_read_failed, e);
    }

    public static SDKException conWriteFailed(IOException e) {
        return new SDKException(ErrorCodes.con_write_failed, e);
    }

    //public static SDKException conClosed(IOException e) {
    //    return new SDKException(ErrorCodes.con_closed, e);
    //}

    public static SDKException unexpectedContent(Exception e) {
        return new SDKException(ErrorCodes.unexpected_content, e);
    }

    // public static SDKException badConfig(Exception e){
    //     return new SDKException(ErrorCodes.bad_config, e);
    // }

    public static SDKException notFound(Exception e) {
        return new SDKException(ErrorCodes.not_found, e);
    }

    @SuppressWarnings({"unused"})
    private SDKException() {
    }
}
