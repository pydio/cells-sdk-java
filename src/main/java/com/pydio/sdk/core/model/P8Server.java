package com.pydio.sdk.core.model;

import com.pydio.sdk.api.IServerFactory;
import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.ServerURL;
import com.pydio.sdk.core.CellsSession;
import com.pydio.sdk.core.P8Session;
import com.pydio.sdk.core.security.CertificateTrust;
import com.pydio.sdk.core.security.CertificateTrustManager;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.io;
import com.pydio.sdk.generated.p8.consts.ActionNames;
import com.pydio.sdk.generated.p8.consts.P8Names;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class P8Server implements Server {

    public final static String API_PREFIX = "/index.php?";
    public final static String BOOTCONF_PATH = API_PREFIX + "get_action=" + ActionNames.GET_BOOT_CONF;

    private String serverType = IServerFactory.TYPE_LEGACY_P8;
    private String version = null;

    private final ServerURL serverURL;
    private String apiPath = null;

    private String title;
    private String welcomeMessage;
    private String iconPath;


    // Legacy objects TODO remove
    private boolean sslUnverified = false;
    private SSLContext sslContext;
    private Properties properties = null;
    private JSONObject bootConf;
    private JSONObject oidc;
    private byte[][] certificateChain;
    private CertificateTrust.Helper trustHelper;


    // private JSONObject bootConf;

    public P8Server(ServerURL serverURL) {
        this.serverURL = serverURL;
    }

    public static P8Server fromServerURL(ServerURL serverURL) {
        return new P8Server(serverURL);
    }

    @Override
    public Server init(ISession session) throws SDKException {
        refreshBootConf((P8Session) session);
        return null;
    }

    // Local shortcut
    private String getId() {
        return serverURL.getId();
    }

    @Override
    public ServerURL getServerURL() {
        return serverURL;
    }

    @Override
    public String getApiURL() {
        return getId();
        // try {
        //     return serverURL.withPath(API_PREFIX).getURL().toString();
        // } catch (MalformedURLException e) {
        //     throw new RuntimeException("Getting API URL for " + getId(), e);
        // }
    }


    @Override
    public String getRemoteType() {
        return serverType;
    }

    public P8Server init(String url) {

        return this;
    }

    public String getServerType() {
        return serverType;
    }

    @Override
    public boolean isLegacy() {
        return true;
    }

    /* Node methods */

    private void refreshBootConf(ISession session) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = null;
        HttpURLConnection con;

        try {
            con = session.openAnonConnection(BOOTCONF_PATH);
            in = con.getInputStream();
            io.pipeRead(in, out);
            JSONObject bootConf = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));

            version = bootConf.getString("ajxpVersion");
            JSONObject customWordings = bootConf.getJSONObject("customWording");
            title = customWordings.getString("title");
            iconPath = customWordings.getString("icon");
            if (customWordings.has("welcomeMessage")) {
                welcomeMessage = customWordings.getString("welcomeMessage");
            }
        } catch (Exception e) {
            // TODO handle error
            Log.w("Unimplemented", "Error while retrieving bootconf for " + getId());
            e.printStackTrace();
        }
    }


    // Getters

    private TrustManager trustManager() {
        return new CertificateTrustManager(getTrustHelper());
    }

    public String version() {
        if (version == null) {
            throw new RuntimeException("Trying to retrieve AJXP Version param before the server has been instantiated");
        }
        return version;
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
                        for (byte[] trusted : P8Server.this.certificateChain) {
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


    public String getIconPath() {
        return iconPath;
    }

    public String welcomeMessage() {
        return this.welcomeMessage;
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

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || !(obj instanceof P8Server))
            return false;

        return getId().equals(((P8Server) obj).getServerURL().getId());
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


    @Override
    public String getIconURL() {
        return null;
    }

    @Override
    public String getWelcomeMessage() {
        return null;
    }

    // Setters

    public void setUnverifiedSSL(boolean unverified) {
        sslUnverified = unverified;
    }
}
