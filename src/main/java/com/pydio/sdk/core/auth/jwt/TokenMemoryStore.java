package com.pydio.sdk.core.auth.jwt;

import com.pydio.sdk.core.auth.Token;

import java.util.HashMap;
import java.util.Map;

public class TokenMemoryStore implements Token.Store {

    final Map map = new HashMap();

    @Override
    public void save(Token t) {
        map.put(t.subject, t);
    }

    @Override
    public Token get(String subject) {
        Object o =  map.get(subject);
        if (o != null) {
            return (Token) o;
        }
        return null;
    }

    @Override
    public void delete(String subject) {
        map.remove(subject);
    }
}
