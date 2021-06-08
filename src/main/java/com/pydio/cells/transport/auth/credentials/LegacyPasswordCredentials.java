package com.pydio.cells.transport.auth.credentials;

import com.pydio.cells.api.PasswordCredentials;

public class LegacyPasswordCredentials implements PasswordCredentials {

    private final String login;
    private final String password;

    public LegacyPasswordCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
