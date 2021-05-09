package com.pydio.cells.client.model;

public class Action {

    final public String name;
    final public Boolean dirDefault;
    final public Boolean fileDefault;
    final public Boolean write;
    final public Boolean read;
    final public Boolean adminOnly;
    final public Boolean noUser;
    final public Boolean userLogged;

    public Action(String name, Boolean dirDefault, Boolean fileDefault, Boolean write, Boolean read, Boolean adminOnly, Boolean userLogged, Boolean noUser) {
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
