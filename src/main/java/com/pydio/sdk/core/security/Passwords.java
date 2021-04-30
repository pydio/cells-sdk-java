package com.pydio.sdk.core.security;

import com.pydio.sdk.api.callbacks.PasswordLoader;

public class Passwords {
    public static PasswordLoader Loader;

    public static String load(String url, String login){
        if(Loader == null) return null;
        return Loader.loadPassword(url, login);
    }
}
