package com.pydio.sdk.api;

public interface Code {
    public static final int ok = 0;
    public static final int bad_uri = 1;
    public static final int con_failed = 2;
    public static final int authentication_required = 3;
    public static final int authentication_with_captcha_required = 4;
    public static final int resource_found = 5;
    public static final int ssl_error = 6;
    public static final int ssl_certificate_not_signed = 7;
    public static final int tls_init = 8;
    public static final int unsupported_method = 9;
    public static final int unsupported_scheme = 10;
    public static final int redirect = 11;
    public static final int unexpected_content = 12;
    public static final int unexpected_response = 13;
    public static final int unreachable_host = 14;
    public static final int bad_config = 15;
    public static final int pydio_server_not_supported = 16;
    public static final int not_pydio_server = 17;
    public static final int encoding_failed = 18;
    public static final int con_read_failed = 19;
    public static final int con_write_failed = 20;
    public static final int con_closed = 21;
    public static final int not_found = 22;
    public static final int no_internet = 23;
    public static final int token_expired = 24;
    public static final int no_token_available = 25;


    /**
     * Returns a message given its code
     * TODO: externalise strings and add i18n
     *
     * @param code the message code number
     * @return the corresponding human readable message (not yet i18ned)
     */
    public static String toMessage(int code) {

        switch (code) {
            case ok:
                return "OK";
            case bad_uri:
                return "Bad URI";
            case con_failed:
                return "Connection failed";
            case authentication_required:
                return "Authentication required";
            case authentication_with_captcha_required:
                return "Authentication with captcha required";
            case resource_found:
                return "Resource found";
            case ssl_error:
                return "TLS error";
            case ssl_certificate_not_signed:
                return "TLS certificate not signed";
            case tls_init:
                return "TLS init";
            case unsupported_method:
                return "Unsupported method";
            case unsupported_scheme:
                return "Unsupported scheme";
            case redirect:
                return "Redirect";
            case unexpected_content:
                return "Unexpected content";
            case unexpected_response:
                return "Unexpected response";
            case unreachable_host:
                return "Unreachable host";
            case bad_config:
                return "Bad configuration";
            case pydio_server_not_supported:
                return "Pydio server is not supported";
            case not_pydio_server:
                return "Not a Pydio server";
            case encoding_failed:
                return "Encoding failed";
            case con_read_failed:
                return "Connection read failed";
            case con_write_failed:
                return "Connection write failed";
            case con_closed:
                return "Connection closed";
            case not_found:
                return "Not found";
            case no_internet:
                return "No internet";
            case token_expired:
                return "Token expired";
            case no_token_available:
                return "No token available";
        }
        return "Unknown exception (code: " + code + ")";
    }

    public static int fromHttpStatus(int status) {
        switch (status) {
            case 200:
                return ok;
            case 401:
            case 403:
                return authentication_required;
            case 404:
                return not_found;
        }
        return unexpected_response;
    }
}
