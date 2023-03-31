package com.pydio.cells.transport.auth.jwt;

import com.google.gson.Gson;
import com.pydio.cells.api.SDKException;

import java.util.Map;

public class OAuthConfig {

    private final static String defaultScope = "openid email offline profile pydio";

    public final static String DEFAULT_REDIRECT_URI = "cellsauth://callback";
    public final static String OIDC_WELL_KNOWN_CONFIG_PATH = "/oidc/.well-known/openid-configuration";
    public final static String AUTH_ENDPOINT = "authorization_endpoint";
    public final static String TOKEN_ENDPOINT = "token_endpoint";
    public final static String REVOCATION_ENDPOINT = "revocation_endpoint";
    // public final static String SCOPE = "scope";

    public String authorizeEndpoint;
    public String redirectURI;
    public String tokenEndpoint;
    public String revokeEndpoint;
//     public String refreshEndpoint;

    public String audience;
    public String scope;

    public String state;
    public String code;

    public static OAuthConfig fromOIDCResponse(String oidcStr) throws SDKException {
        try {
            return OAuthConfig.fromJsonString(oidcStr);
        } catch (Exception e) {
            throw new SDKException("Could not parse OIDC response", e);
        }
    }

    private static OAuthConfig fromJsonString(String oidcStr) {
        OAuthConfig cfg = new OAuthConfig();
        Gson gson = new Gson();
        @SuppressWarnings("unchecked") Map<String, Object> map = gson.fromJson(oidcStr, Map.class);
        cfg.authorizeEndpoint = (String) map.get(AUTH_ENDPOINT);
        cfg.tokenEndpoint = (String) map.get(TOKEN_ENDPOINT);
        cfg.revokeEndpoint = (String) map.get(REVOCATION_ENDPOINT);
        return cfg;
    }

    private OAuthConfig() {
        this.redirectURI = DEFAULT_REDIRECT_URI;
        this.scope = defaultScope;
    }

//    private static OAuthConfig fromJSON(JSONObject o) {
//        OAuthConfig cfg = new OAuthConfig();
//
//        cfg.authorizeEndpoint = o.getString(AUTH_ENDPOINT);
//        cfg.tokenEndpoint = o.getString(TOKEN_ENDPOINT);
//        cfg.revokeEndpoint = o.getString(REVOCATION_ENDPOINT);
//
//        cfg.redirectURI = DEFAULT_REDIRECT_URI;
//
//        cfg.scope = defaultScope;
//        return cfg;
//    }
}
