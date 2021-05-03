package com.pydio.sdk.api.nodes;

import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.ServerURL;
import com.pydio.sdk.api.callbacks.ServerResolver;

import org.json.JSONObject;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/*
 * Wraps a server properties
 */
public interface ServerNode extends Node {

    String TYPE_CELLS = "cells";
    String TYPE_LEGACY_P8 = "pydio";

    ServerURL getServerURL(String path) throws MalformedURLException;

    ServerNode init(String url);

    WorkspaceNode getWorkspace(String slug);

    WorkspaceNode findWorkspaceById(String id);

    ServerNode setWorkspaces(List<WorkspaceNode> nodes);

    Error resolve(String address);

    String getServerType();

    boolean isLegacy();

    boolean isSSLUnverified();

    String host();

    String scheme();

    int port();

    String iconURL();

    String url();

    String getOriginalURL();

    String welcomeMessage();

    String apiURL();

    SSLContext getSslContext();

    Map<String, WorkspaceNode> getWorkspaces();

    @Deprecated
    boolean supportsOauth();

    @Deprecated
    JSONObject getOIDCInfo();

    @Deprecated
    String getVersionName();

    @Deprecated
    boolean hasLicenseFeatures();

    @Deprecated
    HostnameVerifier getHostnameVerifier();

    @Deprecated
    ServerResolver getServerResolver();

    @Deprecated
    byte[][] getCertificateChain();

    @Deprecated
    void setUnverifiedSSL(boolean isVerified);

}
