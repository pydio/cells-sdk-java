package com.pydio.cells.client.auth;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Transport;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.RestFrontSessionResponse;
import com.pydio.cells.transport.CellsTransport;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TokenService {

    private final TokenStore store;

    public TokenService(TokenStore store) {
        this.store = store;
    }

    public Token get(Transport transport, String key) throws SDKException {

        Token token = store.get(key);
        if (token == null) {
            return null;
            // Acceptable at this point.
            // throw new SDKException(ErrorCodes.no_token_available, "Please login first", null);
        }

        if (!token.isExpired()) {
            return token;
        } else {
            token = ((CellsTransport) transport).refreshOAuthToken(token);
            store.save(transport.getId(), token);
        }

        return token;
    }

    public void delete(String key) {
        store.delete(key);
    }

    public void register(String key, Token token) {
        store.save(key, token);
    }


//    public Token loginPasswordGetToken(CellsTransport session, Credentials credentials) throws SDKException {
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


    public Token legacyLogin(CellsTransport transport, Credentials credentials) throws SDKException {

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

        FrontendServiceApi api = new FrontendServiceApi(transport.getApiClient());


        RestFrontSessionResponse response;
        try {
            response = api.frontSession(request);

            Token t = new Token();
            t.subject = transport.getId();
            t.value = response.getJWT();
            t.setExpiry((long) response.getExpireTime());
            store.save(transport.getId(), t);
            return t;
        } catch (ApiException e) {
            throw new SDKException(ErrorCodes.no_token_available, new IOException("login or password incorrect"));
        }
    }
}
