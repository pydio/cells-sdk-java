package com.pydio.cells.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/**
 * Wraps an URL to add convenience methods to ease implementation in a Pydio Context.
 */
public interface ServerURL {

    /**
     * Returns a standard id that has been cleaned and normalized.
     * WARNING: in the case of a legacy remote P8 server, the returned URL might also
     * contain a sub-path, if the server is not exposed on the root of the domain,
     * e.g: https://example.com/pydio.
     */
    default String getId() {
        return getURL().getProtocol() + "://" + getURL().getAuthority() + getURL().getPath();
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
     * If any query was already present, it is conserved.
     *
     * Warning: if our server entry point is under a sub path of the domain (typically for P8),
     * the passed path is appended.
     */
    ServerURL withPath(String path) throws MalformedURLException;

    /**
     * Returns a new instance of the current Server URL object with the passed query.
     *
     * Note that the path is preserved (if any) but this overrides any query
     * that might have been previously set.
     */
    ServerURL withQuery(String query) throws MalformedURLException;

    /**
     * Returns a new instance of the current Server URL object augmented with Path and Query
     * passed via the spec String.
     *
     * Warning: if our server entry point is under a sub path of the domain (typically for P8),
     * the passed path is appended.
     */
    ServerURL withSpec(String spec) throws MalformedURLException;

    HttpURLConnection openConnection() throws IOException;

    void ping() throws IOException, SDKException;

    byte[][] getCertificateChain();

    SSLContext getSSLContext();

    SSLSocketFactory getSslSocketFactory();

    boolean skipVerify();

    String toJson();
}
