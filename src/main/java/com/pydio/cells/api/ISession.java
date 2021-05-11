package com.pydio.cells.api;

import com.pydio.cells.client.utils.StateID;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public interface ISession {

    String getId();

    Server getServer();

    Client getClient();

    String getUserAgent();

    /** This also tries to login the server with the passed credentials. */
    void setCredentials(Credentials c) throws SDKException;

    void login() throws SDKException;

    void logout() throws SDKException;

    String getUser();

    InputStream getUserData(String binary) throws SDKException;

    JSONObject userInfo() throws SDKException;

    // InputStream getWorkspaceRegistry(String ws) throws SDKException;
//
    // void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;
//
    // void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    boolean isOffline();

    HttpURLConnection openAnonConnection(String path) throws SDKException, IOException;

    HttpURLConnection openConnection(String path) throws SDKException, IOException;

}
