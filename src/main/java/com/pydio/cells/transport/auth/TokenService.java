package com.pydio.cells.transport.auth;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Transport;
import com.pydio.cells.transport.CellsTransport;

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
            token = ((CellsTransport) transport).getRefreshedOAuthToken(token);
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

    public Map<String, Token> getAllTokens() {
        return store.getAll();
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



}
