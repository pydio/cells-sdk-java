package com.pydio.sdk.api;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wraps an URL to add convenience methods to ease implementation
 */
public interface ServerURL {

    default String getId() {
        return getURL().getProtocol() + "://" + getURL().getAuthority();
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

    void ping() throws Exception;

    HttpURLConnection openConnection() throws SDKException;
}
