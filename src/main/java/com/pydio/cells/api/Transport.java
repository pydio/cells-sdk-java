package com.pydio.cells.api;

import com.pydio.cells.transport.auth.Token;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public interface Transport {

    String ANONYMOUS_USERNAME = "anon";
    String UNDEFINED_URL = "https://example.com";
    @Deprecated
    String UNDEFINED_STATE = "https%3A%2F%2Fexample.com";

    String getId();

    String getUsername();

    Server getServer();

    String getUserAgent();

    /**
     * Tries to login the server with the passed credentials
     * and stores the resulting token in the local token store.
     *
     * @return
     */
    // Token unlock(Credentials c) throws SDKException;

    Token getTokenFromLegacyCredentials(PasswordCredentials credentials) throws SDKException;
//
//    void logout() throws SDKException;

    boolean isOffline();

    HttpURLConnection openConnection(String path) throws SDKException, IOException;

    HttpURLConnection openAnonConnection(String path) throws SDKException, IOException;

    @Deprecated
    HttpURLConnection withUserAgent(HttpURLConnection con);

//    JSONObject userInfo() throws SDKException;

    InputStream getUserData(String binary) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    // InputStream getWorkspaceRegistry(String ws) throws SDKException;
    // void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;
    // void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

}
