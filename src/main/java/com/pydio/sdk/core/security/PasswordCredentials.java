package com.pydio.sdk.core.security;

import com.pydio.sdk.api.Credentials;

public class PasswordCredentials implements Credentials {
    private final String login;
    private final String password;

    public PasswordCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getCaptcha() {
        return null;
    }

    @Override
    public String getSeed() {
        return "-1";
    }
}
