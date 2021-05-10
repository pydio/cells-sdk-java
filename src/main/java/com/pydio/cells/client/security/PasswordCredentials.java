package com.pydio.cells.client.security;

import com.pydio.cells.api.Credentials;

public class PasswordCredentials implements Credentials {
    private final String login;
    private final String password;
    private final String captcha;


    public PasswordCredentials(String login, String password) {
        this.login = login;
        this.password = password;
        captcha = null;
    }

    public PasswordCredentials(String login, String password, String captcha) {
        this.login = login;
        this.password = password;
        this.captcha = captcha;
    }


    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getCaptcha() {
        return captcha;
    }

    @Override
    public String getSeed() {
        return "-1";
    }
}
