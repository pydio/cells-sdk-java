package com.pydio.cells.transport;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.auth.OauthConfig;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.io;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

public class CellsServer implements Server {

    public final static String API_PREFIX = "/a";
    public final static String OIDC_WELLKNOWN_PATH = "/oidc/.well-known/openid-configuration";
    public final static String BOOTCONF_PATH = API_PREFIX + "/frontend/bootconf";

    private String serverType = SdkNames.TYPE_CELLS;
    private String version = null;
    private String versionName = null;

    private final ServerURL serverURL;
    private String apiPath = null;

    private String title;
    private String welcomeMessage;
    private String iconPath;

    // Legacy objects TODO remove
    private JSONObject bootConf;
    private OauthConfig oidc;

    public CellsServer(ServerURL serverURL) {
        this.serverURL = serverURL;
    }

    public static CellsServer fromServerURL(ServerURL serverURL) {
        return new CellsServer(serverURL);
    }

    public CellsServer init(String url) {
        return this;
    }

    @Override
    public Server init() throws SDKException {
        refreshBootConf();
        downloadOIDCConfiguration();
        return this;
    }

    @Override
    public ServerURL getServerURL() {
        return serverURL;
    }

    @Override
    public String getApiURL() {
        try {
            return serverURL.withPath(API_PREFIX).getURL().toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Getting API URL for " + url(), e);
        }
    }

    @Override
    public String getRemoteType() {
        return serverType;
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    /* Node methods */

    public HttpURLConnection openAnonConnection(String path) throws SDKException, IOException {
        return newURL(path).openConnection();
    }

    private void refreshBootConf() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = null;
        HttpURLConnection con;

        try {
            con = openAnonConnection(BOOTCONF_PATH);
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
            Log.w("Unimplemented", "Error while retrieving bootconf for " + url());
            e.printStackTrace();
        }
    }

    private void downloadOIDCConfiguration() throws SDKException {
        HttpURLConnection con;
        InputStream in;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            con = newURL(OIDC_WELLKNOWN_PATH).openConnection();
            con.setRequestMethod("GET");
            in = con.getInputStream();
            io.pipeRead(in, out);
            JSONObject oidcJson = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));
            oidc = OauthConfig.fromJSON(oidcJson, "");
        } catch (Exception e) {
            // TODO manage errors

            Log.w("Connection", "connection error while OIDC conf");
            throw SDKException.unexpectedContent(e);
        }
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

    @Override
    public String getIconURL() {
        return null;
    }

    @Override
    public String getWelcomeMessage() {
        return null;
    }

    @Override
    public String getVersionName() {
        return null;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String welcomeMessage() {
        return this.welcomeMessage;
    }

    public boolean supportsOauth() {
        return this.oidc != null;
    }

    @Override
    public OauthConfig getOAuthConfig() {
        return this.oidc;
    }

//    public void setUnverifiedSSL(boolean unverified) {
//        sslUnverified = unverified;
//    }
//
//    public SSLContext getSslContext() {
//        if (this.sslContext == null) {
//            try {
//                this.sslContext = SSLContext.getInstance("TLS");
//                this.sslContext.init(null, new TrustManager[]{trustManager()}, null);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        try {
//            this.sslContext.getSocketFactory();
//        } catch (Exception e) {
//            try {
//                this.sslContext = SSLContext.getInstance("TLS");
//                this.sslContext.init(null, new TrustManager[]{trustManager()}, null);
//            } catch (Exception ex) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        return this.sslContext;
//    }
//
//    public byte[][] getCertificateChain() {
//        return this.certificateChain;
//    }
//
//    public HostnameVerifier getHostnameVerifier() {
//        return (s, sslSession) -> true;
//    }

    /*  Local helpers */

//    private TrustManager trustManager() {
//        return new CertificateTrustManager(getTrustHelper());
//    }

//    private String getId() {
//        return serverURL.getId();
//    }

//    private CertificateTrust.Helper getTrustHelper() {
//        if (trustHelper == null) {
//            return trustHelper = new CertificateTrust.Helper() {
//                @Override
//                public boolean isServerTrusted(X509Certificate[] chain) {
//                    for (X509Certificate c : chain) {
//                        for (byte[] trusted : CellsServer.this.certificateChain) {
//                            try {
//                                c.checkValidity();
//                                MessageDigest hash = MessageDigest.getInstance("MD5");
//                                byte[] c1 = hash.digest(trusted);
//                                byte[] c2 = hash.digest(c.getEncoded());
//                                if (Arrays.equals(c1, c2)) {
//                                    return true;
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    return false;
//                }
//
//                @Override
//                public X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//            };
//        }
//        return trustHelper;
//    }


    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || !(obj instanceof CellsServer))
            return false;

        return url().equals(((CellsServer) obj).url());
    }

}
