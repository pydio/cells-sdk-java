package com.pydio.cells.legacy;

import com.pydio.cells.api.PasswordCredentials;

public class P8Credentials implements PasswordCredentials {

    private final String login;
    private final String password;
    private final String captcha;

    public P8Credentials(String login, String password, String captcha) {
        this.login = login;
        this.password = password;
        this.captcha = captcha;
    }

    public P8Credentials(String login, String password) {
        this(login, password, null);
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getCaptcha() {
        return captcha;
    }

    @Deprecated
    public String getSeed() {
        return "-1";
    }

}
