package com.pydio.cells.api;

import com.google.gson.Gson;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generic exception for the java SDK that is server type agnostic and supports both Pydio Cells and the legacy Pydio 8 server.
 * It cannot yet extend the swagger generated API exception that is specific to Cells.
 * <p>
 * This can be changed when we stop supporting Pydio 8 in a near future.
 * <p>
 * // TODO smelly code, refactor with a clean generic error handling strategy.
 */
public class SDKException extends Exception {

    private final static String logTag = "SDKException";

    private int code;
    private String message;
    private Throwable cause;

    public SDKException(String message) {
        super(message);
    }

    public SDKException(Throwable cause) {
        super(cause);
    }

    public SDKException(String message, Throwable cause) {
        super(message, cause);
    }

    public static SDKException fromApiException(ApiException cause) {
        String body = cause.getResponseBody();
        Map<String, List<String>> headers = cause.getResponseHeaders();
        if (Str.notEmpty(body)) {
//             Log.e("SDKException", "Exception body [" + body + "]");
            if (headers.containsKey("content-type") && headers.get("content-type").get(0).startsWith("application/json")) {
                Gson gson = new Gson();
                // Best effort to gather more info about the error
                try {
                    HashMap<String, String> responseBody = gson.fromJson(body, HashMap.class);
                    return new SDKException(cause.getCode(), responseBody.get("Title"), cause);
                } catch (Exception je) {
                    Log.w(logTag, "Could not retrieve info from JSON response body: " + je.getMessage());
                }
                return new SDKException(cause.getCode(), "JSON parse error", cause);
                // if (headers.containsKey("content-type") && headers.get("content-type").get(0).startsWith("text/plain")) {
            } else {
                return new SDKException(cause.getCode(), body, cause);
            }
        } else if (cause.getCause() instanceof UnknownHostException ||
                cause.getCause() instanceof SocketException ||
                cause.getCause() instanceof IOException) {
            // Probably network error
            return new SDKException(ErrorCodes.con_failed, cause.getCause().getMessage(), cause.getCause());
        } else {
            return new SDKException(cause.getCode(), "Unhandled ApiException #" + cause.getCode() + ": " + cause.getMessage(), cause);
        }
    }

    public boolean isConnectionFailedError() {
        return code == ErrorCodes.no_token_available
                || code == ErrorCodes.authentication_required
                || code == ErrorCodes.refresh_token_expired
                || code == ErrorCodes.token_expired
                || code == ErrorCodes.authentication_with_captcha_required
                || code == ErrorCodes.con_failed
                || code == 401; // HTTP unauthorized. TODO use constant
    }

    // Legacy inherited SDK specific constructors => ease implementation of the Android app.

    public SDKException(int code, String message, Throwable cause) {
        this(ErrorCodes.toMessage(code) + ": " + message, cause);
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public SDKException(int code, String message) {
        this(message);
        this.code = code;
        this.message = message;
    }

    public SDKException(int code, Exception cause) {
        this(ErrorCodes.toMessage(code), cause);
        this.cause = cause;
        this.code = code;
    }

    public SDKException(int code) {
        this(ErrorCodes.toMessage(code));
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        if (message == null) {
            return super.getMessage();
        }
        return message;
    }

    @Override
    public Throwable getCause() {
        if (cause == null) {
            return super.getCause();
        }
        return cause;
    }

    /* Boiler plate shortcuts */
    public static SDKException cancel(String message) {
        return new SDKException(ErrorCodes.cancelled, message);
    }

    public static boolean isCancellation(SDKException e) {
        return ErrorCodes.cancelled == e.getCode();
    }

    public static SDKException malFormURI(Exception e) {
        return new SDKException(ErrorCodes.bad_uri, e);
    }

    public static SDKException encoding(Exception e) {
        return new SDKException(ErrorCodes.encoding_failed, e);
    }

    public static SDKException noSpaceLeft(IOException e) {
        return new SDKException(ErrorCodes.write_failed_no_space, e);
    }

    public static SDKException unexpectedContent(Exception e) {
        return new SDKException(ErrorCodes.unexpected_content, e);
    }

    public static SDKException notFound(Exception e) {
        return new SDKException(ErrorCodes.not_found, e);
    }

    // FIXME factorize and clean exception we have added 2 times the same object
    public static class RemoteIOException extends SDKException {
        public RemoteIOException(String s) {
            super(ErrorCodes.con_failed, s);
        }
    }

    static class IO extends SDKException {
        public IO(int code, String message, Throwable cause) {
            super(code, message, cause);
        }

        public IO(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static SDKException conFailed(String message, IOException e) {
        return new SDKException.IO(ErrorCodes.con_failed, message, e);
    }

    public static SDKException conReadFailed(String message, IOException e) {
        return new SDKException.IO(ErrorCodes.con_read_failed, message, e);
    }

    public static SDKException conWriteFailed(String message, IOException e) {
        return new SDKException.IO(ErrorCodes.con_write_failed, message, e);
    }

    class Api extends SDKException {
    }

    class Auth extends SDKException {
    }

    @SuppressWarnings({"unused"})
    private SDKException() {
    }
}
