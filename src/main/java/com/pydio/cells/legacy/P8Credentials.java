package com.pydio.cells.legacy;

import com.pydio.cells.api.Credentials;

public class P8Credentials implements Credentials {
    private final String login;
    private final String password;

    public P8Credentials(String login, String password) {
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
