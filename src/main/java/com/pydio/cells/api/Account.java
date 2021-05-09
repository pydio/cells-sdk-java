package com.pydio.cells.api;

public interface Account {

    ServerURL getServerURL();
    String getLogin();

    default String getId(){
        return getLogin()+"@"+getServerURL().getId();
    }

    default String getCleanId(){
        // TODO 
        return getLogin()+"@"+getServerURL().getId();
    }

}
