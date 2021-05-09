package com.pydio.cells.client.auth.jwt;

import com.pydio.cells.client.auth.Token;

import java.util.HashMap;

/** Optimistic simple implementation of the Token store mainly for testing purposes */
public class TokenMemoryStore implements Token.Store {

    final HashMap<String, Token> map = new HashMap<String, Token>();

    @Override
    public void save(Token t) {
        save(t.subject, t);
    }

    @Override
    public void save(String subject, Token t) {
        map.put(subject, t);
    }

    @Override
    public Token get(String subject) {
        return map.get(subject);
    }

    @Override
    public void delete(String subject) {
        map.remove(subject);
    }
}
