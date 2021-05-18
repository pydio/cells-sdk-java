package com.pydio.cells.api;

import com.pydio.cells.client.auth.OAuthConfig;

import java.net.MalformedURLException;

public interface Server {

    ServerURL getServerURL();

    Server init() throws SDKException;

    /**
     * returns the canonical URL of the server as String for various persistence processes.
     * This should not be used to create another URL object to try to connect to the server
     * or management of self-signed URLs will be skipped.
     */
    default String url() {
        return getServerURL().getId();
    }

    String getApiURL();

    String getRemoteType();

    boolean isLegacy();

    @Deprecated
    boolean supportsOauth();

    OAuthConfig getOAuthConfig();

    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }

    default boolean isSSLUnverified() {
        return getServerURL().skipVerify();
    }

    default String getLabel() {
        // TODO implement this from boot config
        return url();
    }

    String getIconURL();

    String getWelcomeMessage();

    String getVersionName();

    boolean hasLicenseFeatures();

}
