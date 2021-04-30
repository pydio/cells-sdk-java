package com.pydio.sdk.core.model;

import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.api.callbacks.ServerResolver;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.security.CertificateTrust;
import com.pydio.sdk.core.security.CertificateTrustManager;
import com.pydio.sdk.core.service.ServerResolution;
import com.pydio.sdk.core.utils.io;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;

/*
 * Wraps a server properties
 */
public class ServerNode implements com.pydio.sdk.api.Node {

    public Map<String, WorkspaceNode> workspaces;
    private String scheme = null;
    private String host = null;
    private int port = 80;
    private String path = null;
    private String version = null;
    private String versionName = null;
    private String iconURL;
    private String welcomeMessage;
    private String label = null;
    private String url = null;
    private String apiURL = null;
    private String originalUrl = null;
    private boolean sslUnverified = false;
    private SSLContext sslContext;
    private Properties properties = null;
    private JSONObject bootConf;
    private JSONObject oidc;
    private byte[][] certificateChain;
    private CertificateTrust.Helper trustHelper;
    private ServerResolver serverResolver;

    public ServerNode() {
    }

    public static ServerNode fromAddress(String address) throws IOException {
        URL url = new URL(address);
        ServerNode node = new ServerNode();
        node.scheme = url.getProtocol();
        node.host = url.getHost();
        node.port = url.getPort();
        node.path = url.getPath();
        node.url = address;
        return node;
    }

    /* Server Node methods */
    public WorkspaceNode getWorkspace(String slug) {
        if (this.workspaces != null && this.workspaces.containsKey(slug)) {
            return this.workspaces.get(slug);
        }
        return null;
    }

    public WorkspaceNode findWorkspaceById(String id) {
        if (id == null) {
            return null;
        }

        if (this.workspaces == null) {
            return null;
        }

        for (WorkspaceNode wn : this.workspaces.values()) {
            if (id.equals(wn.getProperty(SdkNames.WORKSPACE_PROPERTY_ID))) {
                return wn;
            }
        }
        return null;
    }

    public ServerNode init(String url) {
        if (!url.endsWith("/")) {
            url += "/";
        }
        this.url = url;
        URI uri = URI.create(url);
        scheme = uri.getScheme();
        host = uri.getHost();
        path = uri.getPath();
        port = uri.getPort();
        return this;
    }

    public ServerNode setLabel(String label) {
        this.label = label;
        return this;
    }

    public ServerNode setWorkspaces(List<WorkspaceNode> nodes) {
        if (this.workspaces == null) {
            this.workspaces = new HashMap<>();
        } else {
            this.workspaces.clear();
        }

        for (WorkspaceNode wn : nodes) {
            this.workspaces.put(wn.getId(), wn);
        }
        return this;
    }

    // Resolve

    public Error resolve(String address) {
        return resolveRemote(address);
    }

    /* Node methods */

    @Override
    public void setProperties(Properties p) {
        properties = p;
    }

    @Override
    public String getProperty(String key) {
        if (properties == null) return null;
        return properties.getProperty(key);
    }

    @Override
    public void setProperty(String key, String value) {
        if (properties == null) {
            properties = new Properties();
        }
        properties.setProperty(key, value);
    }

    @Override
    public void deleteProperty(String key) {
        if (properties != null && properties.contains(key)) {
            properties.remove(key);
        }
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getType() {
        return com.pydio.sdk.api.Node.TYPE_SERVER;
    }

    @Override
    public String getId() {
        String id = scheme + "://" + host;
        if (port != 80) {
            id = id + ":" + port;
        }
        id = id + path;
        return id;
    }

    @Override
    public String getEncoded() {
        return null;
    }

    @Override
    public String getEncodedHash() {
        return null;
    }

    @Override
    public int compare(com.pydio.sdk.api.Node node) {
        return 0;
    }


    private Error resolveRemote(final String address) {
        originalUrl = address;
        this.url = address;

        if (!address.startsWith("https://") && !address.startsWith("http://")) {
            try {
                this.url = ServerResolution.resolve(address, true);
            } catch (IOException e) {
                e.printStackTrace();
                return new Error(ErrorCodes.bad_uri);
            }
        }

        URL url;
        try {
            url = new URL(this.url);
        } catch (MalformedURLException e) {
            return new Error(ErrorCodes.bad_uri);
        }

        scheme = url.getProtocol();
        host = url.getHost();
        port = url.getPort();
        path = url.getPath();

        int err = downloadBootConf("a/frontend/bootconf");
        if (err == 0) {
            downloadOIDCConfiguration();
            return null;
        }

        if (err != ErrorCodes.unexpected_response) {
            err = downloadBootConf("index.php?get_action=get_boot_conf");
            if (err == 0) {
                //c.onComplete(new Error(SdkNames.ERROR_PYDIO_8_SERVER, "found pydio 8 server", null));
                return null;
            }
        }
        return new Error(err);
    }

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

    private void downloadOIDCConfiguration() {
        InputStream in;
        HttpURLConnection con;

        String apiURL = url();
        if (!apiURL.endsWith("/")) {
            apiURL = apiURL + "/";
        }
        apiURL = apiURL + "oidc/.well-known/openid-configuration";

        if (isSSLUnverified()) {
            try {
                sslContext = SSLContext.getInstance("TLS");
                sslContext.init(null, new TrustManager[]{trustManager()}, null);
            } catch (Exception e) {
                return;
            }
            HttpsURLConnection scon;
            try {
                scon = (HttpsURLConnection) new URL(apiURL).openConnection();
            } catch (IOException e) {
                return;
            }
            scon.setSSLSocketFactory(sslContext.getSocketFactory());
            scon.setHostnameVerifier(getHostnameVerifier());
            con = scon;
        } else {
            try {
                con = (HttpURLConnection) new URL(apiURL).openConnection();
            } catch (IOException e) {
                return;
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
                return;
            }

            if (e instanceof SSLException) {
                e.printStackTrace();
                return;
            }
            return;

        } catch (Exception e) {
            if (e instanceof IllegalArgumentException && e.getMessage().toLowerCase().contains("unreachable")) {
                return;
            }
            return;
        }

        try {
            oidc = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));
        } catch (Exception ignored) {
        }
    }

    // Getters

    private TrustManager trustManager() {
        return new CertificateTrustManager(getTrustHelper());
    }

    public String version() {
        if (version == null) {
            boolean isCells = bootConf.has("backend");
            version = bootConf.getString("ajxpVersion");
            versionName = isCells ? "cells" : "pydio";
        }
        return version;
    }

    public String versionName() {
        if (versionName == null) {
            boolean isCells = bootConf.has("backend");
            version = bootConf.getString("ajxpVersion");
            versionName = isCells ? "cells" : "pydio";
        }
        return versionName;
    }

    public boolean hasLicenseFeatures() {
        return bootConf != null && bootConf.has("license_features");
    }

    private CertificateTrust.Helper getTrustHelper() {
        if (trustHelper == null) {
            return trustHelper = new CertificateTrust.Helper() {
                @Override
                public boolean isServerTrusted(X509Certificate[] chain) {
                    for (X509Certificate c : chain) {
                        for (byte[] trusted : ServerNode.this.certificateChain) {
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

    public boolean isSSLUnverified() {
        return sslUnverified;
    }

    public String host() {
        return host;
    }

    public String scheme() {
        return scheme;
    }

    public int port() {
        return port;
    }

    public String iconURL() {
        return iconURL;
    }

    public String url() {
        if (url != null) return url;
        String path = scheme.toLowerCase() + "://" + host;
        if (port > 0 && port != 80) {
            path += ":" + port;
        }
        path += getPath();
        if (!path.endsWith("/")) {
            return path + "/";
        }
        return url = path;
    }

    public String getOriginalURL() {
        if (originalUrl == null) {
            originalUrl = url();
        }
        return originalUrl;
    }

    public String welcomeMessage() {
        return this.welcomeMessage;
    }

    public String apiURL() {
        if (apiURL != null) {
            return apiURL;
        }

        if (bootConf == null) {
            System.out.println("[ERROR] cannot retrieve API URL before bootconf is enabled.");
            return null;
        }
        apiURL = bootConf.getString("ENDPOINT_REST_API");

        if (!apiURL.startsWith("http")) {
            //System.out.println("[WARNING] API URL does not contain FQDN: "+apiURL);
            //System.out.println("[Debug] Printing stack trace");
            //Thread.dumpStack();
            //System.out.println("[Debug] stack trace end ##############################");
            String apiPath = apiURL.startsWith("/") ? apiURL.substring(1) : apiURL;
            // FIXME ugly fix until we handle the URL cleanly
            String fqdn = url.endsWith("/") ? url : url + "/";
            apiURL = fqdn + apiPath;
        }
        return apiURL;
    }

    public SSLContext getSslContext() {
        if (this.sslContext == null) {
            try {
                this.sslContext = SSLContext.getInstance("TLS");
                this.sslContext.init(null, new TrustManager[]{trustManager()}, null);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        try {
            this.sslContext.getSocketFactory();
        } catch (Exception e) {
            try {
                this.sslContext = SSLContext.getInstance("TLS");
                this.sslContext.init(null, new TrustManager[]{trustManager()}, null);
            } catch (Exception ex) {
                e.printStackTrace();
                return null;
            }
        }
        return this.sslContext;
    }

    public boolean equals(Object o) {
        try {
            return this == o || (o instanceof com.pydio.sdk.api.Node) && ((com.pydio.sdk.api.Node) o).getType() == getType() && getLabel().equals(((com.pydio.sdk.api.Node) o).getLabel()) && getPath().equals(((Node) o).getPath());
        } catch (NullPointerException e) {
            return false;
        }
    }


    public byte[][] getCertificateChain() {
        return this.certificateChain;
    }

    public boolean supportsOauth() {
        return this.oidc != null;
    }

    public JSONObject getOIDCInfo() {
        return this.oidc;
    }

    public HostnameVerifier getHostnameVerifier() {
        return (s, sslSession) -> true;
    }

    public ServerResolver getServerResolver() {
        return this.serverResolver;
    }

    // Setters

    public ServerNode setUnverifiedSSL(boolean unverified) {
        sslUnverified = unverified;
        return this;
    }
}
