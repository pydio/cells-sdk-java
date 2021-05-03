package com.pydio.sdk.api;

import java.net.MalformedURLException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public interface Server {

    ServerURL getServerURL();

    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }

    String getApiURL();

    Server init(ISession session) throws SDKException;

    String getRemoteType();

    boolean isLegacy();

    boolean isSSLUnverified();

    String getIconURL();

    String getWelcomeMessage();

    SSLContext getSslContext();

    @Deprecated
    HostnameVerifier getHostnameVerifier();

    @Deprecated
    byte[][] getCertificateChain();

    @Deprecated
    void setUnverifiedSSL(boolean isVerified);

    @Deprecated
    boolean hasLicenseFeatures();

}
