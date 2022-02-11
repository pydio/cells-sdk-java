package com.pydio.cells.transport.auth;

import com.google.gson.Gson;
import com.pydio.cells.utils.Log;

import org.json.JSONObject;

import java.text.ParseException;

public class Token {

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
    private long expirationTime;

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
            Log.i("IdToken", String.format("Expired since %s seconds", elapsedTimeSinceExpiry));
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
        try {
            Token t = new Token();
            JSONObject jo = new JSONObject(jwt);
            t.value = jo.getString("access_token");
            t.setExpiry(jo.getInt("expires_in"));
            t.scope = jo.getString("scope");
            t.idToken = jo.getString("id_token");
            t.refreshToken = jo.getString("refresh_token");
            t.tokenType = jo.getString("token_type");
            return t;
        } catch (Exception jse) {
            jse.printStackTrace();
            throw new ParseException("Could not decode token " + jwt, 0);
        }
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
