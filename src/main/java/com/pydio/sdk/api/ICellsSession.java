package com.pydio.sdk.api;

import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.api.nodes.WorkspaceNode;
import com.pydio.sdk.core.auth.Token;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.security.cert.X509Certificate;
import java.util.Map;

public interface ICellsSession extends ISession {

    HttpURLConnection withAuth(HttpURLConnection con) throws SDKException;

    HttpURLConnection openConnection(String path) throws SDKException, MalformedURLException;

    HttpURLConnection openAnonConnection(String path) throws SDKException, MalformedURLException;

    // Token getToken() throws SDKException;

}
