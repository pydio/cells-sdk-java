package com.pydio.sdk.core;

import com.pydio.sdk.api.Account;
import com.pydio.sdk.api.ServerURL;

public class AccountImpl implements Account {

    private String login;
    private ServerURL serverURL;

    @Override
    public ServerURL getServerURL() {
        return null;
    }

    @Override
    public String getLogin() {
        return null;
    }
}
