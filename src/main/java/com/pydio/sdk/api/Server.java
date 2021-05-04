package com.pydio.sdk.api;

import java.net.MalformedURLException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public interface Server {

    ServerURL getServerURL();

    Server init(ISession session) throws SDKException;

    String getApiURL();

    String getRemoteType();

    boolean isLegacy();

    default ServerURL newURL(String path) throws MalformedURLException {
        return getServerURL().withPath(path);
    }


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
