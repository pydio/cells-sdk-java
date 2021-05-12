package com.pydio.cells.client.auth;

public interface TokenStore {

    void save(String key, Token t);

    Token get(String key);

    void delete(String key);

}
