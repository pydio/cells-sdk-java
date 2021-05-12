package com.pydio.cells.client.auth;

import com.google.gson.Gson;
import com.pydio.cells.client.utils.Log;

import org.json.JSONObject;

import java.text.ParseException;

public class Token {

    public String subject;
    public String value;
    public long expirationTime;
    public String refreshToken;
    public String idToken;
    public String scope;
    public String tokenType;

    private long currentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

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
            Log.i("JWT", String.format("Expired since %s seconds", elapsedTimeSinceExpiry));
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

    public static Token decodeOauthJWT(String jwt) throws ParseException {
        Token t = new Token();
        JSONObject jo = new JSONObject(jwt);

        t.value = jo.getString("access_token");
        t.expirationTime = jo.getInt("expires_in");
        t.idToken = jo.getString("id_token");
        t.refreshToken = jo.getString("refresh_token");
        t.scope = jo.getString("scope");
        t.tokenType = jo.getString("token_type");
        return t;
    }

}
