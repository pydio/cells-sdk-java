package com.pydio.sdk.core.model;

public class Action {
    final public String name;
    final public boolean dirDefault;
    final public boolean fileDefault;
    final public boolean write;
    final public boolean read;
    final public boolean adminOnly;
    final public boolean noUser;
    final public boolean userLogged;

    public Action(String name, boolean dirDefault, boolean fileDefault, boolean write, boolean read, boolean adminOnly, boolean userLogged, boolean noUser) {
        this.name = name;
        this.dirDefault = dirDefault;
        this.fileDefault = fileDefault;
        this.write = write;
        this.read = read;
        this.adminOnly = adminOnly;
        this.noUser = noUser;
        this.userLogged = userLogged;
    }
}
