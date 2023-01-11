package com.pydio.cells.transport.auth.credentials;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.transport.auth.Token;

public class JWTCredentials implements Credentials {

    private final String username;
    private final Token token;

    public JWTCredentials(String username, Token token) {
        this.username = username;
        this.token = token;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getType() {
        return TYPE_JWT;
    }

    @Override
    public String getEncodedValue() {
        return token.toString();
    }

    public Token getToken() {
        return token;
    }
}
