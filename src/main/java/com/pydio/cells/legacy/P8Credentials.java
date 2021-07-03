package com.pydio.cells.legacy;

import com.pydio.cells.api.PasswordCredentials;

public class P8Credentials implements PasswordCredentials {

    private final String login;
    private final String password;
    private final String captcha;

    public P8Credentials(String login, String password) {
        this(login, password, null);
    }

    public P8Credentials(String login, String password, String captcha) {
        this.login = login;
        this.password = password;
        this.captcha = captcha;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getType() {
        return TYPE_P8;
    }

    @Override
    public String getEncodedValue() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public String getSeed() {
        return "-1";
    }

}
