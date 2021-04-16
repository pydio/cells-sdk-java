package com.pydio.sdk.core.auth;

import com.pydio.sdk.core.api.cells.ApiClient;
import com.pydio.sdk.core.api.cells.ApiException;
import com.pydio.sdk.core.api.cells.api.FrontendServiceApi;
import com.pydio.sdk.core.api.cells.model.RestFrontSessionRequest;
import com.pydio.sdk.core.api.cells.model.RestFrontSessionResponse;
import com.pydio.sdk.core.common.errors.Code;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.common.http.HttpClient;
import com.pydio.sdk.core.common.http.HttpRequest;
import com.pydio.sdk.core.common.http.HttpResponse;
import com.pydio.sdk.core.common.http.Method;
import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.security.Credentials;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.Params;
import com.squareup.okhttp.OkHttpClient;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

public class TokenService {

    private static TokenService instance;

    public static void init(Token.Store store) {
        instance = new TokenService();
        instance.store = store;
    }

    public static Token get(ServerNode server, Credentials credentials, boolean skipOAuth) throws SDKException {
        return instance.resolve(server, credentials, skipOAuth);
    }

    private Token.Store store;

    private TokenService() {}

    private synchronized Token resolve(ServerNode server, Credentials credentials, boolean skipOAuth) throws SDKException {
        String subject = String.format("%s@%s", credentials.getLogin(), server.url());
        Token t = this.store.get(subject);

        if (t != null && !t.isExpired()) {
            return t;
        }

        /* if (skipOAuth) {
            throw new SDKException(Code.token_expired, new IOException("no valid token available"));
        } */

        if (server.supportsOauth() && !skipOAuth) {
            if (t != null) {
                return this.refresh(server, t);
            }
            throw new SDKException(Code.no_token_available, new IOException("no valid token available"));
        } else { // Legacy call with credentials
            return this.loginPasswordGetToken(server, credentials);
        }
    }

    private Token refresh(ServerNode server, Token t) throws SDKException {
        Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");
        OauthConfig cfg = OauthConfig.fromJSON(server.getOIDCInfo(), "");

        HttpRequest request = new HttpRequest();
        Params params = Params.create("grant_type", "refresh_token").set("refresh_token", t.refreshToken);
        request.setParams(params);

        Base64 base64 = new Base64();
        String auth = new String(base64.encode((cfg.clientID + ":" + cfg.clientSecret).getBytes()));

        request.setHeaders(Params.create("Authorization", "Basic " + auth));
        request.setEndpoint(cfg.tokenEndpoint);
        request.setMethod(Method.POST);

        HttpResponse response;
        try {
            response = HttpClient.request(request);
        } catch (Exception e) {
            Log.w("Token Service", " token request failed: " + e.getLocalizedMessage());
            throw new SDKException(Code.con_failed);
        }

        String jwt;
        try {
            jwt = response.getString();
        } catch (IOException e) {
            Log.e("Refresh Token Service", "Could not get response string body: " + e.getLocalizedMessage());
            e.printStackTrace();
            throw new SDKException(Code.no_token_available, new IOException("refresh token failed"));
        }

        try {
            t = Token.decodeOauthJWT(jwt);
        } catch (ParseException e) {
            Log.e("Refresh Token Service", "Could not parse refreshed token: " + jwt + ". " + e.getLocalizedMessage());
            throw new SDKException(Code.no_token_available, new IOException("could not decode server response"));
        }

        com.pydio.sdk.core.auth.jwt.JWT parsedIDToken;
        parsedIDToken = com.pydio.sdk.core.auth.jwt.JWT.parse(t.idToken);
        if (parsedIDToken == null) {
            throw new SDKException(Code.no_token_available);
        }

        t.subject = String.format("%s@%s", parsedIDToken.claims.name, server.url());
        t.expiry = System.currentTimeMillis() / 1000 + t.expiry;
        this.store.save(t);
        return t;
    }

    private Token loginPasswordGetToken(ServerNode server, Credentials credentials) throws SDKException {
        String password = credentials.getPassword();
        if (password == null) {
            throw new SDKException(Code.no_token_available, new IOException("no password provided"));
        }

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(server.apiURL());
        if (server.isSSLUnverified()) {
            SSLContext context = server.getSslContext();
            OkHttpClient c = apiClient.getHttpClient();
            c.setSslSocketFactory(context.getSocketFactory());
            c.setHostnameVerifier((s, sslSession) -> server.url().contains(s));
        }

        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setClientTime((int) System.currentTimeMillis());

        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getLogin());
        authInfo.put("password", password);
        authInfo.put("type", "credentials");
        request.authInfo(authInfo);

        FrontendServiceApi api = new FrontendServiceApi(apiClient);
        RestFrontSessionResponse response;
        try {
            response = api.frontSession(request);
        } catch (ApiException e) {
            throw new SDKException(Code.no_token_available, new IOException("no password provided"));
        }

        String subject = String.format("%s@%s", credentials.getLogin(), server.url());

        Token t = new Token();
        t.subject = subject;
        t.value = response.getJWT();
        long expireIn = (long) response.getExpireTime();
        t.expiry = System.currentTimeMillis() / 1000 + expireIn;
        if (this.store != null) {
            this.store.save(t);
        }
        return t;
    }
}
