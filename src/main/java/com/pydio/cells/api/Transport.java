package com.pydio.cells.api;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public interface Transport {

    String getId();

    String getUser();

    Server getServer();

    String getUserAgent();

    @Deprecated
    Client getClient();

    /**
     * This also tries to login the server with the passed credentials.
     */
    void setCredentials(Credentials c) throws SDKException;

    void login() throws SDKException;

    void logout() throws SDKException;

    boolean isOffline();

    HttpURLConnection openConnection(String path) throws SDKException, IOException;

    HttpURLConnection openAnonConnection(String path) throws SDKException, IOException;

    @Deprecated
    HttpURLConnection withUserAgent(HttpURLConnection con);

    JSONObject userInfo() throws SDKException;

    InputStream getUserData(String binary) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    // InputStream getWorkspaceRegistry(String ws) throws SDKException;
    // void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;
    // void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

}
