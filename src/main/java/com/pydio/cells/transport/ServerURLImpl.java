package com.pydio.cells.transport;

import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.security.CertificateTrust;
import com.pydio.cells.client.security.CertificateTrustManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
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
    private static final HostnameVerifier SKIP_HOSTNAME_VERIFIER = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
    private final URL url;
    // To Manage self-signed servers
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
        // URL url = URI.create(urlString).toURL();
        urlString = urlString.trim().toLowerCase();
        URL url = new URL(urlString);
        switch (url.getPath()) {
            case "/":
            case "":
                url = new URL(url.getProtocol() + "://" + url.getAuthority());
                break;
            default:
                throw new MalformedURLException("unsupported server path, this is not yet implemented in Cells API");
        }

        ServerURLImpl serverURL = new ServerURLImpl(url, skipVerify);
        return serverURL;
    }

    public static ServerURL withSkipverify(ServerURL serverURL) {
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
        return new ServerURLImpl(new URL(url, path), skipVerify);
    }

    @Override
    public URL getURL() {
        return url;
    }

    // TODO finalize self-signed management.

    @Override
    public boolean skipVerify() {
        return skipVerify;
    }

    /* Manage self signed on a URL by URL Basis.
      Thanks to https://stackoverflow.com/questions/19723415/java-overriding-function-to-disable-ssl-certificate-check */

    @Override
    public void ping() throws IOException {
        HttpURLConnection connection = openConnection();
        // 10 secs timeout instead of the default unlimited
        connection.setConnectTimeout(10000);

        try {
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() != 200) {
                throw new IOException("Unvalid response code: " + connection.getResponseCode());
            }
        } catch (ProtocolException pe) {
            throw new RuntimeException("Unvalid protocol GET...", pe);
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unexpected error while initializing SSL context", e);
        } catch (KeyManagementException e) {
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
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unexpected error while initializing SSL context", e);
        } catch (KeyManagementException e) {
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


    /*

    private int downloadBootConf(String apiURLTail) {
        InputStream in = null;
        HttpURLConnection con;

        String apiURL = url();
        boolean addressEndsWithSlash = apiURL.endsWith("/");
        boolean tailStartsWithSlash = apiURLTail.startsWith("/");

        if (addressEndsWithSlash && tailStartsWithSlash) {
            apiURL = apiURL + apiURLTail.substring(1);
        } else if (!addressEndsWithSlash && !tailStartsWithSlash) {
            apiURL = apiURL + "/" + apiURLTail;
        } else {
            apiURL = apiURL + apiURLTail;
        }

        if (isSSLUnverified()) {
            try {
                sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{trustManager()}, null);
            } catch (Exception e) {
                return ErrorCodes.tls_init;
            }
            HttpsURLConnection scon;
            try {
                scon = (HttpsURLConnection) new URL(apiURL).openConnection();
            } catch (IOException e) {
                return ErrorCodes.con_failed;
            }
            scon.setSSLSocketFactory(sslContext.getSocketFactory());
            scon.setHostnameVerifier(getHostnameVerifier());
            con = scon;
        } else {
            try {
                con = (HttpURLConnection) new URL(apiURL).openConnection();
            } catch (IOException e) {
                return ErrorCodes.con_failed;
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            in = con.getInputStream();
            io.pipeRead(in, out);
        } catch (IOException e) {
            if (e instanceof SSLHandshakeException) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    cause = cause.getCause();
                    if (cause instanceof CertPathValidatorException) {
                        CertPathValidatorException ex = (CertPathValidatorException) cause;
                        List<? extends Certificate> certs = ex.getCertPath().getCertificates();

                        int size = certs.size();
                        this.certificateChain = new byte[size][];
                        int i = 0;
                        for (Certificate c : certs) {
                            try {
                                this.certificateChain[i] = c.getEncoded();
                                i++;
                            } catch (CertificateEncodingException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
                return ErrorCodes.ssl_certificate_not_signed;
            }

            if (e instanceof SSLException) {
                e.printStackTrace();
                return ErrorCodes.ssl_error;
            }
            return ErrorCodes.con_failed;

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException && e.getMessage().toLowerCase().contains("unreachable")) {
                return ErrorCodes.unreachable_host;
            }
            return ErrorCodes.con_failed;
        } finally {
            if (in != null) {
                io.close(in);
            }
            io.close(out);
        }

        try {
            bootConf = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));
        } catch (Exception ignored) {
            return ErrorCodes.unexpected_response;
        }

        boolean isCells = bootConf.has("backend");
        version = bootConf.getString("ajxpVersion");
        versionName = isCells ? "cells" : "pydio";

        JSONObject customWordings = bootConf.getJSONObject("customWording");
        label = customWordings.getString("title");
        iconURL = customWordings.getString("icon");

        tailStartsWithSlash = iconURL.startsWith("/");
        if (addressEndsWithSlash && tailStartsWithSlash) {
            iconURL = url() + iconURL;
        } else if (!addressEndsWithSlash && !tailStartsWithSlash) {
            iconURL = url() + "/" + iconURL;
        } else {
            iconURL = url() + iconURL;
        }

        if (customWordings.has("welcomeMessage")) {
            welcomeMessage = customWordings.getString("welcomeMessage");
        }
        return 0;
    }
*/


}