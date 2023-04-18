package com.pydio.cells.api;

/**
 * Custom Error Codes for the Cells SDK.
 * Error codes between 100 and 600 are the standard HTTP status code that are returned
 * by the underlying generated openAPI SDK.
 */
public interface ErrorCodes {

    int ok = 0;
    int resource_found = 1;
    int cancelled = 2;

    int no_internet = 10;
//    int no_un_metered_connection = 11;
//    int no_metered_connection = 12;

    int not_found = 13;
    int redirect = 14;
    int bad_uri = 15;
    int unreachable_host = 16;

    int not_pydio_server = 20;
    int pydio_server_not_supported = 21;
    int unsupported_method = 22;
    int unsupported_scheme = 23;

    int ssl_error = 24;
    int ssl_certificate_not_signed = 25;
    int tls_init = 26;

    //    int unknown_account = 30;
    int invalid_credentials = 31;
    int authentication_required = 32;
    int authentication_with_captcha_required = 33;
    int token_expired = 34;
    int no_token_available = 35;
    int refresh_token_expired = 36;
    int cannot_refresh_token = 37;
    int refresh_token_not_valid = 38;

    int con_failed = 40;
    int con_closed = 41;
    int con_read_failed = 42;
    int con_write_failed = 43;
    int unexpected_content = 44;
    int unexpected_response = 45;
    int write_failed_no_space = 46;
    int server_configuration_issue = 47;

    int api_error = 50;
    int unsupported = 51;

    int no_local_file = 60;
    int no_local_node = 61;
    int local_io_error = 62;

    int panic = 80;
    int internal_error = 81;
    int init_failed = 82;
    int configuration_error = 83;
    int bad_config = 84;
    int encoding_failed = 85;

    /**
     * Returns a message given its code
     * TODO: externalise strings and add i18n
     *
     * @param code the message code number
     * @return the corresponding human readable message (not yet i18ned)
     */
    static String toMessage(int code) {

        switch (code) {
            case ok:
                return "OK";
            case resource_found:
                return "Resource found";

            case no_internet:
                return "No internet";
            case not_found:
                return "Not found";
            case redirect:
                return "Redirect";
            case bad_uri:
                return "Bad URI";
            case unreachable_host:
                return "Unreachable host";
            case not_pydio_server:
                return "Not a Pydio server";
            case pydio_server_not_supported:
                return "Pydio server is not supported";

            case unsupported_method:
                return "Unsupported method";
            case unsupported_scheme:
                return "Unsupported scheme";

            case ssl_error:
                return "TLS error";
            case ssl_certificate_not_signed:
                return "TLS certificate not signed";
            case tls_init:
                return "TLS init";

            case invalid_credentials:
                return "Invalid credentials";
            case authentication_required:
                return "Authentication required";
            case no_token_available:
                return "No token available";
            case token_expired:
                return "Token expired";
            case authentication_with_captcha_required:
                return "Authentication with captcha required";
            case refresh_token_expired:
                return "Refresh token has expired";

            case con_failed:
                return "Connection failed";
            case con_closed:
                return "Connection closed";
            case con_read_failed:
                return "Connection read failed";
            case con_write_failed:
                return "Connection write failed";
            case write_failed_no_space:
                return "No space left on device";
            case server_configuration_issue:
                return "Could not retrieve Auth info, please check your server config";

            case unexpected_content:
                return "Unexpected content";
            case unexpected_response:
                return "Unexpected response";

            case no_local_file:
                return "File is not yet in local cache";
            case no_local_node:
                return "Record could not be found in local index";
            case local_io_error:
                return "Could not read/write in local application directory";

            case api_error:
                return "API error";

            case panic:
                return "Panic";
            case internal_error:
                return "Internal server error";
            case init_failed:
                return "Initialisation failed";
            case bad_config:
                return "Bad configuration";
            case encoding_failed:
                return "Encoding failed";
        }
        return "Unknown exception (code: " + code + ")";
    }

    static int fromHttpStatus(int status) {
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
