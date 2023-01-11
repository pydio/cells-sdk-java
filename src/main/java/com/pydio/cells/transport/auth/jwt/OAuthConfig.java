package com.pydio.cells.transport.auth.jwt;

import com.pydio.cells.api.SDKException;

import org.json.JSONObject;

public class OAuthConfig {

    private final static String defaultScope = "openid email offline profile pydio";

    public final static String OIDC_WELL_KNOWN_CONFIG_PATH = "/oidc/.well-known/openid-configuration";
    public final static String AUTH_ENDPOINT = "authorization_endpoint";
    public final static String TOKEN_ENDPOINT = "token_endpoint";
    public final static String REVOCATION_ENDPOINT = "revocation_endpoint";
    public final static String SCOPE = "scope";

    // FIXME this is specific for the android client and should not be defined here.
//    public final static String DEFAULT_CLIENT_ID = "cells-mobile";
//    public final static String DEFAULT_CLIENT_SECRET = "";
    public final static String DEFAULT_REDIRECT_URI = "cellsauth://callback";

    public String authorizeEndpoint;
    //    public String clientID;
//    public String clientSecret;
    public String redirectURI;

    public String tokenEndpoint;
    public String revokeEndpoint;
    public String refreshEndpoint;

    public String audience;
    public String scope;
    public String state;

    public String code;

    public static OAuthConfig fromOIDCResponse(String oidcStr) throws SDKException {
        try {
            JSONObject oidcJson = new JSONObject(oidcStr);
            return OAuthConfig.fromJSON(oidcJson);
        } catch (Exception e) {
            throw new SDKException(e);
        }
    }

    private static OAuthConfig fromJSON(JSONObject o) {
        OAuthConfig cfg = new OAuthConfig();

        cfg.authorizeEndpoint = o.getString(AUTH_ENDPOINT);
        cfg.tokenEndpoint = o.getString(TOKEN_ENDPOINT);
        cfg.revokeEndpoint = o.getString(REVOCATION_ENDPOINT);

//        cfg.clientID = DEFAULT_CLIENT_ID;
//        cfg.clientSecret = DEFAULT_CLIENT_SECRET;
        cfg.redirectURI = DEFAULT_REDIRECT_URI;

        cfg.scope = defaultScope;

//        cfg.scope = o.getString(SCOPE);
//        if (cfg.scope == null) {
//            cfg.scope = defaultScope;
//        }

//        // Only used during the OAuth process to avoid attacks.
//        // Not sure it is the best place for this.
//        byte[] bytes = new byte[8];
//        new SecureRandom().nextBytes(bytes);
//        cfg.state = Hex.toString(bytes);

        return cfg;
    }

}
