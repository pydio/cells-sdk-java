package com.pydio.sdk.core.auth;

import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.core.CellsSession;
import com.pydio.sdk.core.common.http.HttpClient;
import com.pydio.sdk.core.common.http.HttpRequest;
import com.pydio.sdk.core.common.http.HttpResponse;
import com.pydio.sdk.core.common.http.Method;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.Params;
import com.pydio.sdk.generated.cells.ApiException;
import com.pydio.sdk.generated.cells.api.FrontendServiceApi;
import com.pydio.sdk.generated.cells.model.RestFrontSessionRequest;
import com.pydio.sdk.generated.cells.model.RestFrontSessionResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

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

        com.pydio.sdk.core.auth.jwt.JWT parsedIDToken;
        parsedIDToken = com.pydio.sdk.core.auth.jwt.JWT.parse(t.idToken);
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


    public Token legacyLogin(CellsSession session, Credentials credentials) throws SDKException {

        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getLogin());
        authInfo.put("password",credentials.getPassword());
        authInfo.put("type", "credentials");

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
            store.save(t);

            return t;
        } catch (ApiException e) {
            throw new SDKException(ErrorCodes.no_token_available, new IOException("login or password incorrect"));
        }
    }
}
