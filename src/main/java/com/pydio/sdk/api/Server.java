package com.pydio.sdk.api;

import com.pydio.sdk.core.auth.OauthConfig;

import java.net.MalformedURLException;

public interface Server {

    ServerURL getServerURL();

    Server init(ISession session) throws SDKException;

    /**
     * returns the canonical URL of the server as String for various persistence processes.
     * This should not be used to create another URL object to try to connect to the server
     * => it will by-pass management of self-signed URLs.
     */
    default String url() {
        return getServerURL().getId();
    }

    String getApiURL();

    String getRemoteType();

    boolean isLegacy();

    @Deprecated
    boolean supportsOauth();

    OauthConfig getOAuthConfig();

    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }

    default boolean isSSLUnverified() {
        return getServerURL().skipVerify();
    }

    String getIconURL();

    String getWelcomeMessage();

    String getVersionName();

    boolean hasLicenseFeatures();

}
