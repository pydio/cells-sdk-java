package com.pydio.cells.client;

import com.pydio.cells.api.Account;
import com.pydio.cells.api.ServerURL;

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
