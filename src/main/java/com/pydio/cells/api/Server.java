package com.pydio.cells.api;

import com.pydio.cells.transport.auth.jwt.OAuthConfig;

import java.net.MalformedURLException;

public interface Server {

    /* Force initialisation of the local Server object, to typically refresh boot configuration */
    Server init() throws SDKException;

    /* Re-run initialisation if necessary or forced */
    Server refresh(boolean force) throws SDKException;

    /* Return the convenient {@code ServerURL} already configured to speak with the server */
    ServerURL getServerURL();

    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }

    /**
     * returns the canonical URL of the server as String for various persistence processes.
     * This should not be used to create another URL object to try to connect to the server
     * or management of self-signed URLs will be skipped.
     */
    default String url() {
        return getServerURL().getId();
    }

    String getRemoteType();

    boolean isLegacy();

    OAuthConfig getOAuthConfig();

    default boolean isSSLUnverified() {
        return getServerURL().skipVerify();
    }

    String getLabel();

//    default String getLabel() {
//        // TODO implement this from boot config
//        return url();
//    }

    String getWelcomeMessage();

    String getVersionName();

    boolean hasLicenseFeatures();

    @Deprecated
    boolean supportsOauth();

    @Deprecated
    String getIconURL();

    @Deprecated
    String getApiURL();
}
