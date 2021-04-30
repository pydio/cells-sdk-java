package com.pydio.sdk.api.callbacks;

public interface PasswordLoader {
    String loadPassword(String url, String login);
}
