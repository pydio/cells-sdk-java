package com.pydio.cells.transport;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.security.CertificateTrust;
import com.pydio.cells.client.security.CertificateTrustManager;
import com.pydio.cells.utils.Str;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ServerURLImpl implements ServerURL {

    private static final TrustManager[] SKIP_VERIFY_TRUST_MANAGER = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
    };
    private static final HostnameVerifier SKIP_HOSTNAME_VERIFIER = (hostname, session) -> true;

    private final URL url;

    // Self-signed servers management
    private final boolean skipVerify;
    private byte[][] certificateChain;
    private SSLContext sslContext;
    private CertificateTrust.Helper trustHelper;
    private SSLSocketFactory sslSocketFactory = null;

    private ServerURLImpl(URL url, boolean skipVerify) {
        this.url = url;
        this.skipVerify = skipVerify;
    }

    public static ServerURL fromAddress(String urlString, boolean skipVerify) throws MalformedURLException {
        urlString = urlString.trim().toLowerCase(Locale.ENGLISH);
        URL url = new URL(urlString);

        switch (url.getPath()) {
            case "/":
            case "":
                url = new URL(url.getProtocol().concat("://").concat(url.getAuthority()));
                break;
            default:
                // This works for P8 only. We do not support Cells server on a sub-path of a domain.
                String path = url.getPath().trim();
                if (path.endsWith("/")) {
                    path = path.substring(0, path.length() - 1);
                }

                // Double check the protocol to avoid NPE when handling old servers migration
                String protocol = url.getProtocol() == null ? "https" : url.getProtocol();
                String authority = url.getAuthority();
                if (authority == null) {
                    throw new MalformedURLException("Cannot create a server URL without authority for " + urlString);
                }

                url = new URL(protocol.concat("://").concat(url.getAuthority()).concat(path));
        }

        return new ServerURLImpl(url, skipVerify);
    }

    public static ServerURL withSkipVerify(ServerURL serverURL) {
        try {
            return new ServerURLImpl(new URL(serverURL.getId()), true);
        } catch (MalformedURLException ignore) {
        } // OK at this point
        return null;
    }

    public static ServerURL fromAddress(String urlString) throws MalformedURLException {
        return fromAddress(urlString, false);
    }

    @Override
    public HttpURLConnection openConnection() throws IOException {

        HttpURLConnection connection = null;
        if ("http".equals(url.getProtocol())) {
            connection = (HttpURLConnection) url.openConnection();
        } else if ("https".equals(url.getProtocol())) {
            connection = (HttpsURLConnection) url.openConnection();
            if (skipVerify) {
                setAcceptAllVerifier((HttpsURLConnection) connection);
            }
        }
        return connection;
    }

    @Override
    public ServerURL withPath(String path) throws MalformedURLException {
        // String host = url.getProtocol().concat("://").concat(url.getAuthority());
        StringBuilder specBuilder = new StringBuilder();
        if (Str.notEmpty(url.getPath())) {
            specBuilder.append(url.getPath());
        }
        URL verifyPassedURL = new URL(url, path);
        specBuilder.append(verifyPassedURL.getPath());
        if (Str.notEmpty(url.getQuery())) {
            specBuilder.append("?").append(url.getQuery());
        }
        return new ServerURLImpl(new URL(url, specBuilder.toString()), skipVerify);
    }

    @Override
    public ServerURL withQuery(String query) throws MalformedURLException {
        if (Str.empty(query)) {
            return this;
        }
        String spec = "/";
        if (Str.notEmpty(url.getPath())) {
            spec = url.getPath();
        }
        spec = spec.concat("?").concat(query);
        return new ServerURLImpl(new URL(url, spec), skipVerify);
    }

    @Override
    public ServerURL withSpec(String spec) throws MalformedURLException {
        StringBuilder specBuilder = new StringBuilder();
        if (Str.notEmpty(url.getPath())) {
            specBuilder.append(url.getPath());
        }
        URL verifyPassedURL = new URL(url, spec);
        if (Str.notEmpty(verifyPassedURL.getPath())) {
            specBuilder.append(verifyPassedURL.getPath());
        }
        if (Str.notEmpty(verifyPassedURL.getQuery())) {
            specBuilder.append("?").append(verifyPassedURL.getQuery());
        }
        return new ServerURLImpl(new URL(url, specBuilder.toString()), skipVerify);
    }

    @Override
    public URL getURL() {
        return url;
    }

    @Override
    public String toJson() {
        return (new Gson()).toJson(this);
    }

    public static ServerURL fromJson(String jsonString) {
        try {
            // TODO Dirty tweak until we finalize implementation of self-signed certificates
            // We Assume the passed json is correctly formatted
            Type type = new TypeToken<Map<String, Object>>() {
            }.getType();
            Map<String, Object> props = new Gson().fromJson(jsonString, type);
            return ServerURLImpl.fromAddress(props.get("url").toString(), Boolean.parseBoolean(props.get("skipVerify").toString()));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Unable to decode JSON string: " + jsonString, e);
        }
    }

    // TODO finalize self-signed management.

    @Override
    public boolean skipVerify() {
        return skipVerify;
    }

    /* Manage self signed on a URL by URL Basis.
      Thanks to https://stackoverflow.com/questions/19723415/java-overriding-function-to-disable-ssl-certificate-check */

    @Override
    public void ping() throws SDKException, IOException {
        HttpURLConnection connection = openConnection();
        // 10 secs timeout instead of the default unlimited
        connection.setConnectTimeout(10000);

        try {
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if (code != 200) {
                throw new SDKException(code, "Could not reach " + url.getHost() + ": " + connection.getResponseMessage());
            }
        } catch (ProtocolException pe) { // Might not happen very often...
            throw new RuntimeException("Invalid GET request", pe);
        }
    }

    @Override
    public byte[][] getCertificateChain() {
        return certificateChain;
    }

    @Override
    public SSLContext getSSLContext() {
        if (sslContext == null) {
            try {
                sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{trustManager()}, null);
                sslContext.getSocketFactory();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

//        try {
//            sslContext.getSocketFactory();
//        } catch (Exception e) {
//            try {
//                sslContext = SSLContext.getInstance("TLS");
//                sslContext.init(null, new TrustManager[]{trustManager()}, null);
//            } catch (Exception ex) {
//                e.printStackTrace();
//                return null;
//            }
//        }

        return sslContext;
    }

    // TODO tweak until we rework the self signed.
    public SSLSocketFactory getSslSocketFactory() {
        try {
            if (null == sslSocketFactory) {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, SKIP_VERIFY_TRUST_MANAGER, new java.security.SecureRandom());
                sslSocketFactory = sc.getSocketFactory();
            }
            return sslSocketFactory;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException("Unexpected error while initializing SSL context", e);
        }
    }

    private void setAcceptAllVerifier(HttpsURLConnection connection) {
        try {
            // Create the socket factory.
            // Reusing the same socket factory allows sockets to be reused, supporting persistent connections.
            if (null == sslSocketFactory) {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, SKIP_VERIFY_TRUST_MANAGER, new java.security.SecureRandom());
                sslSocketFactory = sc.getSocketFactory();
            }
            connection.setSSLSocketFactory(sslSocketFactory);

            // Since we may be using a cert with a different name, we need to ignore the hostname as well.
            connection.setHostnameVerifier(SKIP_HOSTNAME_VERIFIER);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException("Unexpected error while initializing SSL context", e);
        }
    }

    private TrustManager trustManager() {
        return new CertificateTrustManager(getTrustHelper());
    }

    private CertificateTrust.Helper getTrustHelper() {
        if (trustHelper == null) {
            return trustHelper = new CertificateTrust.Helper() {
                @Override
                public boolean isServerTrusted(X509Certificate[] chain) {
                    for (X509Certificate c : chain) {
                        for (byte[] trusted : ServerURLImpl.this.certificateChain) {
                            try {
                                c.checkValidity();
                                MessageDigest hash = MessageDigest.getInstance("MD5");
                                byte[] c1 = hash.digest(trusted);
                                byte[] c2 = hash.digest(c.getEncoded());
                                if (Arrays.equals(c1, c2)) {
                                    return true;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return false;
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
        }
        return trustHelper;
    }
}
