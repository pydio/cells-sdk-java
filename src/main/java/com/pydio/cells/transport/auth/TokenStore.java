package com.pydio.cells.transport.auth;

import java.util.Map;

public interface TokenStore {

    void save(String key, Token t);

    Token get(String key);

    void delete(String key);

    Map<String, Token> getAll();

}
