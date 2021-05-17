package com.pydio.cells.legacy;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.auth.OAuthConfig;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.io;
import com.pydio.cells.legacy.consts.ActionNames;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class P8Server implements Server {

    public final static String API_PREFIX = "/index.php?";
    public final static String BOOTCONF_PATH = API_PREFIX + "get_action=" + ActionNames.GET_BOOT_CONF;
    private final String serverType = SdkNames.TYPE_LEGACY_P8;
    private String version = null;

    private final ServerURL serverURL;
    private final String apiPath = null;

    private String title;
    private String welcomeMessage;
    private String iconPath;

    public P8Server(ServerURL serverURL) {
        this.serverURL = serverURL;
    }

    public static P8Server fromServerURL(ServerURL serverURL) {
        return new P8Server(serverURL);
    }

    @Override
    public Server init() throws SDKException {
        refreshBootConf();
        return this;
    }

    @Override
    public ServerURL getServerURL() {
        return serverURL;
    }

    @Override
    public String getApiURL() {
        // FIXME should not be used for P8
        return url();
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

    @Override
    public boolean isLegacy() {
        return true;
    }

    @Override
    public boolean supportsOauth() {
        return false;
    }

    // Getters

    public String version() {
        if (version == null) {
            throw new RuntimeException("Trying to retrieve AJXP Version param before the server has been instantiated");
        }
        return version;
    }

    public String versionName() {
        // FIXME clean this
        return version();
    }

    public boolean hasLicenseFeatures() {
        return false;
        // TODO reimplement this
        // return bootConf != null && bootConf.has("license_features");
    }

    @Override
    public String getIconURL() {
        System.out.println("#### Retrieveing ICON URL");
        return iconPath;
    }

    public String getIconPath() {
        return iconPath;
    }

    @Override
    public String getLabel() {
        return title;
    }

    @Override
    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    @Override
    public String getVersionName() {
        return null;
    }


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


    // Local shortcut
    private String getId() {
        return serverURL.getId();
    }


    private HttpURLConnection openAnonConnection(String path) throws SDKException, IOException {
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

            // Paths always start with a leading slash in our world.
            String tmpPath = customWordings.getString("icon");
            iconPath = tmpPath.startsWith("/") ? tmpPath : "/" + tmpPath;

            if (customWordings.has("welcomeMessage")) {
                welcomeMessage = customWordings.getString("welcomeMessage");
            }
        } catch (Exception e) {
            // TODO handle error
            Log.w("Unimplemented", "Error while retrieving bootconf for " + getId());
            e.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof P8Server))
            return false;
        return url().equals(((P8Server) obj).url());
    }

    public OAuthConfig getOAuthConfig() {
        throw new RuntimeException("Pydio 8 server does not support OAuth credential flows.");
    }

}
