package com.pydio.cells.client.auth;

import com.pydio.cells.client.utils.Hex;

import org.json.JSONObject;

import java.security.SecureRandom;

public class OAuthConfig {

    public final static String OIDC_WELL_KNOWN_CONFIG_PATH = "/oidc/.well-known/openid-configuration";
    public final static String TOKEN_ENDPOINT = "token_endpoint";
    public final static String AUTH_ENDPOINT = "authorization_endpoint";
    public final static String REVOCATION_ENDPOINT = "revocation_endpoint";

    // FIXME this is specific for the android client and should not be defined here.
    public final static String DEFAULT_CLIENT_ID = "cells-mobile";
    public final static String DEFAULT_CLIENT_SECRET = "";
    public final static String DEFAULT_REDIRECT_URI = "cellsauth://callback";

    public String authorizeEndpoint;
    public String clientID;
    public String clientSecret;
    public String redirectURI;

    public String tokenEndpoint;
    public String revokeEndpoint;
    public String refreshEndpoint;

    public String audience;
    public String scope;
    public String state;

    public String code;

    public static OAuthConfig fromJSON(JSONObject o, String scope) {
        OAuthConfig cfg = new OAuthConfig();

        cfg.tokenEndpoint = o.getString(TOKEN_ENDPOINT);
        cfg.authorizeEndpoint = o.getString(AUTH_ENDPOINT);
        cfg.revokeEndpoint = o.getString(REVOCATION_ENDPOINT);

        cfg.clientID = DEFAULT_CLIENT_ID;
        cfg.clientSecret = DEFAULT_CLIENT_SECRET;
        cfg.redirectURI = DEFAULT_REDIRECT_URI;
        cfg.scope = scope;

        byte[] bytes = new byte[8];
        new SecureRandom().nextBytes(bytes);
        cfg.state = Hex.toString(bytes);

        return cfg;
    }

    public static OAuthConfig fromJSON(JSONObject o) {
        return fromJSON(o, "openid email offline profile pydio");
    }
}
