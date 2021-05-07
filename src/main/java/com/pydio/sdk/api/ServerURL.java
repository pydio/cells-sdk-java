package com.pydio.sdk.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.SSLContext;

/**
 * Wraps an URL to add convenience methods to ease implementation in a Pydio Context.
 */
public interface ServerURL {

    default String getId() {
        return getURL().getProtocol() + "://" + getURL().getAuthority();
    }

    default String idForCredentials() {
        // Was: String serverID = server.url().replace("://", "+").replace("/", "&");
        return getURL().getProtocol() + "+" + getURL().getAuthority();
    }


    /**
     * Returns the underlying URL Object to perform various checks and/or access to its properties.
     * The returned object should not be used for server request to avoid concurrency issues.
     * Rather see ServerURL.withPath()
     */
    URL getURL();

    /**
     * Returns a new instance of the current Server URL object that points to a given path
     * and that is ready to use to connect to the distant server.
     */
    ServerURL withPath(String path) throws MalformedURLException;

    HttpURLConnection openConnection() throws IOException;

    void ping() throws IOException;

    byte[][] getCertificateChain();

    SSLContext getSSLContext();

    boolean skipVerify();
}
