package com.pydio.sdk.core.security;

import com.pydio.sdk.api.callbacks.PasswordLoader;

public class Passwords {
    public static PasswordLoader loader;

    public static String load(String url, String login) {
        if (loader == null) return null;
        return loader.loadPassword(url, login);
    }

}
