package com.pydio.sdk.api;

import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public interface ISession {

    default String getId() {
        return getUser() + "@" + getServer().getServerURL().getId();
    }

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

    void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

    void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getWorkspaceRegistry(String ws) throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    boolean isOffline();


    HttpURLConnection openAnonConnection(String path) throws SDKException, IOException;

    HttpURLConnection openConnection(String path) throws SDKException, IOException;

    Map<String, WorkspaceNode> getCachedWorkspaces();
}
