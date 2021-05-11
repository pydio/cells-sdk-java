package com.pydio.cells.client;

import com.pydio.cells.api.IAccount;
import com.pydio.cells.api.ServerURL;

public class AccountImpl implements IAccount {

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

    @Override
    public String getId() {
        return null;
    }
}
