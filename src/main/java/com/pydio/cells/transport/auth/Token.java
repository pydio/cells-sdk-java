package com.pydio.cells.transport.auth;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydio.cells.utils.Log;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Map;

public class Token {

    private final static String logTag = "Token";

    // Set by Cells layers to contain the corresponding encoded accountID
    public String subject;
    // value is the real useful token => access_token in OAuth2
    public String value;
    // idToken contains encoded information about current session, typically the claims
    public String idToken;

    public String scope;
    public String tokenType;

    public String refreshToken;
    public long expiresIn;
    public long expirationTime;
    public long refreshingSinceTs;

    public boolean isExpired() {
        if (expirationTime == -1) {
            return false;
        }

        if (value == null) {
            return true;
        }
        if ("".equals(value)) {
            return true;
        }
        long elapsedTimeSinceExpiry = this.currentTimeInSeconds() - this.expirationTime;
        boolean expired = elapsedTimeSinceExpiry > 0;
        if (expired) {
            Log.i(logTag, String.format("Token for %s is expired since %s seconds", subject, elapsedTimeSinceExpiry));
        }
        return expired;
    }

    public static String encode(Token t) {
        Gson gson = new Gson();
        return gson.toJson(t);
    }

    public static Token decode(String json) {
        return new Gson().fromJson(json, Token.class);
    }

    public static Token decodeOAuthJWT(String jwt) throws ParseException {

        Token t = new Token();
        Gson gson = new Gson();
        Type objType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> respMap = gson.fromJson(jwt, objType);

        t.value = (String) respMap.get("access_token");
        t.setExpiry((int) ((double) respMap.get("expires_in")));
        t.scope = (String) respMap.get("scope");
        t.idToken = (String) respMap.get("id_token");
        t.refreshToken = (String) respMap.get("refresh_token");
        t.tokenType = (String) respMap.get("token_type");
        return t;
    }

    public void setExpiry(long expiresIn) {
        if (expiresIn == -1) {
            expirationTime = -1;
            this.expiresIn = -1;
        } else {
            expirationTime = currentTimeInSeconds() + expiresIn;
            this.expiresIn = expiresIn;
        }
    }

    private long currentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

}
