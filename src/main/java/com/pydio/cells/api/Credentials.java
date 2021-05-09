package com.pydio.cells.api;

// TODO refactor in Legacy Credentials and LegacyPydioCredentials
public interface Credentials {

    String getLogin();

    @Deprecated
    String getPassword();

    @Deprecated
    String getCaptcha();

    @Deprecated
    String getSeed();
}
