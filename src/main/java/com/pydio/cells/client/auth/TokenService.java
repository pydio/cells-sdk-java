package com.pydio.cells.client.auth;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.CellsSession;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.client.common.http.HttpClient;
import com.pydio.cells.client.common.http.HttpRequest;
import com.pydio.cells.client.common.http.HttpResponse;
import com.pydio.cells.client.common.http.Method;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.Params;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.RestFrontSessionResponse;
import com.squareup.okhttp.OkHttpClient;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

public class TokenService {

    private final Token.Store store;

    public TokenService(Token.Store store) {
        this.store = store;
    }

    public Token get(CellsSession session, String login, String address) throws SDKException {
        String subject = String.format("%s@%s", login, address);

        Token t = store.get(subject);
        if (t == null) {
            throw new SDKException(ErrorCodes.no_token_available, "Please login first", null);
        }

        if (!t.isExpired()) {
            return t;
        } else {
            t = refresh(session, t, login, address);
            store.save(t);
        }

        return t;
    }

    public void register(Token token) throws SDKException {
        store.save(token);
    }


    // TODO rather move this in the ISession class
    private Token refresh(CellsSession session, Token t, String login, String address) throws SDKException {
        Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");

        HttpRequest request = new HttpRequest();
        Params params = Params.create("grant_type", "refresh_token").set("refresh_token", t.refreshToken);
        request.setParams(params);

        // Legacy deprecated refresh method
        // Base64 base64 = new Base64();
        // String auth = new String(base64.encode((cfg.clientID + ":" + cfg.clientSecret).getBytes()));
        // request.setHeaders(Params.create("Authorization", "Basic " + auth));

        request.setEndpoint(session.getServer().getOAuthConfig().tokenEndpoint);
        request.setMethod(Method.POST);

        HttpResponse response;
        try {
            response = HttpClient.request(request);
        } catch (Exception e) {
            Log.w("Token Service", " token request failed: " + e.getLocalizedMessage());
            throw new SDKException(ErrorCodes.con_failed);
        }

        String jwt;
        try {
            jwt = response.getString();
        } catch (IOException e) {
            Log.e("Refresh Token Service", "Could not get response string body: " + e.getLocalizedMessage());
            e.printStackTrace();
            throw new SDKException(ErrorCodes.no_token_available, new IOException("refresh token failed"));
        }

        try {
            t = Token.decodeOauthJWT(jwt);
        } catch (ParseException e) {
            Log.e("Refresh Token Service", "Could not parse refreshed token: " + jwt + ". " + e.getLocalizedMessage());
            throw new SDKException(ErrorCodes.no_token_available, new IOException("could not decode server response"));
        }

        com.pydio.cells.client.auth.jwt.JWT parsedIDToken;
        parsedIDToken = com.pydio.cells.client.auth.jwt.JWT.parse(t.idToken);
        if (parsedIDToken == null) {
            throw new SDKException(ErrorCodes.no_token_available);
        }

        t.subject = String.format("%s@%s", parsedIDToken.claims.name, address);
        t.expiry = System.currentTimeMillis() / 1000 + t.expiry;
        if (store != null) {
            store.save(t);
        }
        return t;
    }

//    public Token loginPasswordGetToken(CellsSession session, Credentials credentials) throws SDKException {
//        String password = credentials.getPassword();
//        if (password == null) {
//            throw new SDKException(ErrorCodes.no_token_available, new IOException("no password provided"));
//        }
//
//        ApiClient apiClient = new ApiClient();
//        apiClient.setBasePath(session.getServer().url() + "/a");
//        ServerURL sURL = session.getServer().getServerURL();
//        if (sURL.skipVerify()) {
//            apiClient.setVerifyingSsl(false);
//            OkHttpClient c = apiClient.getHttpClient();
//            c.setSslSocketFactory(sURL.getSslSocketFactory());
//            c.setHostnameVerifier((s, sslSession) -> sURL.getId().contains(s));
//        }
//
//        RestFrontSessionRequest request = new RestFrontSessionRequest();
//        request.setClientTime((int) System.currentTimeMillis());
//
//        Map<String, String> authInfo = new HashMap<>();
//        authInfo.put("login", credentials.getLogin());
//        authInfo.put("password", password);
//        authInfo.put("type", "credentials");
//        request.authInfo(authInfo);
//
//        FrontendServiceApi api = new FrontendServiceApi(apiClient);
//        RestFrontSessionResponse response;
//        try {
//            response = api.frontSession(request);
//        } catch (ApiException e) {
//            throw new SDKException(ErrorCodes.no_token_available, new IOException("Could not login", e));
//        }
//
//        String subject = ServerFactory.accountID(credentials.getLogin(), sURL);
//
//        Token t = new Token();
//        t.subject = subject;
//        t.value = response.getJWT();
//        long expireIn = (long) response.getExpireTime();
//        t.expiry = System.currentTimeMillis() / 1000 + expireIn;
//        if (this.store != null) {
//            this.store.save(t);
//        }
//        return t;
//    }


    public Token legacyLogin(CellsSession session, Credentials credentials) throws SDKException {

        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getLogin());
        authInfo.put("password", credentials.getPassword());
        authInfo.put("type", "credentials");

        // Hack to support legacy credential flow
        Base64 base64 = new Base64();
        String clientID = "cells-mobile";
        String clientSecret = "";
        String auth = new String(base64.encode((clientID + ":" + clientSecret).getBytes()));
        authInfo.put("Authorization", "Basic " + auth);


        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setClientTime((int) System.currentTimeMillis());
        request.authInfo(authInfo);

        FrontendServiceApi api = new FrontendServiceApi(session.getApiClient());


        RestFrontSessionResponse response;
        try {
            response = api.frontSession(request);

            Token t = new Token();
            String subject = String.format("%s@%s", credentials.getLogin(), session.getServer().getServerURL().getId());
            t.subject = subject;
            t.value = response.getJWT();
            long expireIn = (long) response.getExpireTime();
            t.expiry = System.currentTimeMillis() / 1000 + expireIn;

            // FIXME why shouldn't we provide an ID here ?
            store.save(t);

            return t;
        } catch (ApiException e) {
            throw new SDKException(ErrorCodes.no_token_available, new IOException("login or password incorrect"));
        }
    }
}
