package com.pydio.cells.api;

import com.pydio.cells.transport.auth.jwt.OAuthConfig;

import java.net.MalformedURLException;

public interface Server {

    /**
     * Forces initialisation of the local Server object to typically refresh boot configuration
     */
    Server init() throws SDKException;

    /**
     * Re-runs initialisation if necessary or forced
     */
    Server refresh(boolean force) throws SDKException;

    /**
     * Returns the convenient {@code ServerURL} already configured to communicate with the server
     */
    ServerURL getServerURL();

    /**
     * Returns a ready to use {@code ServerURL} with the passed trailing path.
     */
    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }

    /**
     * Returns the canonical URL of the server as String for various persistence processes.
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
