package com.pydio.cells.transport.auth;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleTokenStore implements TokenStore {

    private final Map<String, Token> secureTokens = new ConcurrentHashMap<>();

    @Override
    public void save(String key, Token t) {
        secureTokens.put(key, t);
    }

    @Override
    public Token get(String key) {
        return secureTokens.get(key);
    }

    @Override
    public void delete(String key) {
        secureTokens.remove(key);
    }

    @Override
    public Map<String, Token> getAll() {
        return secureTokens;
    }


}
