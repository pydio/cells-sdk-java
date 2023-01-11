package com.pydio.cells.api;

/**
 * Generic interface to manage credentials. We only always have a username
 */
public interface Credentials {

    String TYPE_PAT = "PAT";
    String TYPE_JWT = "JWT";
    String TYPE_LEGACY_PASSWORD = "Legacy Password";
    String TYPE_P8 = "P8";

    String getUsername();

    String getType();

    String getEncodedValue();

}
