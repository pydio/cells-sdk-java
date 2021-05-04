package com.pydio.sdk.api;

import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.security.cert.X509Certificate;
import java.util.Map;

public interface ISession {

    Server getServerNode();

    Client getClient();

    String getUserAgent();

    void setCredentials(Credentials c);

    void login() throws SDKException;

    void logout() throws SDKException;

    String getUser();

    void setSkipOAuthFlag(boolean skipOAuth);

    InputStream getUserData(String binary) throws SDKException;

    JSONObject userInfo() throws SDKException;

    X509Certificate[] remoteCertificateChain();

    void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

    void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getWorkspaceRegistry(String ws) throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    boolean isOffline();

    HttpURLConnection openAnonConnection(String path) throws SDKException, IOException;

    Map<String, WorkspaceNode> getCachedWorkspaces();
}
