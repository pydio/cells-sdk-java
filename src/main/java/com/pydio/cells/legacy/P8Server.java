package com.pydio.cells.legacy;

import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class P8Server implements Server {

    public final static String API_PREFIX = "/index.php?";
    public final static String BOOTCONF_PATH = API_PREFIX + "get_action=" + P8Names.GET_BOOT_CONF;
    private String version = null;

    private final ServerURL serverURL;

    private String title;
    private String welcomeMessage;
    private String iconPath;

    public P8Server(ServerURL serverURL) {
        this.serverURL = serverURL;
    }

    @Override
    public Server init() throws SDKException {
        return refresh(true);
    }

    @Override
    public Server refresh(boolean force) throws SDKException {
        if (force || version == null) {
            refreshBootConf();
        }
        return this;
    }

    @Override
    public ServerURL getServerURL() {
        return serverURL;
    }

    @Override
    public String getRemoteType() {
        return SdkNames.TYPE_LEGACY_P8;
    }

    @Override
    public boolean isLegacy() {
        return true;
    }

    @Override
    public boolean supportsOauth() {
        return false;
    }


    public boolean hasLicenseFeatures() {
        return false;
        // TODO reimplement this
        // return bootConf != null && bootConf.has("license_features");
    }

    @Override
    public String getLabel() {
        if (title != null && !"".equals(title)) {
            return title;
        }
        return url();
    }

    @Override
    public String getIconURL() {
        return iconPath;
    }

    @Override
    public String getWelcomeMessage() {
        return this.welcomeMessage;
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

    private void refreshBootConf() throws SDKException {
        HttpURLConnection con = null;
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            con = serverURL.withSpec(BOOTCONF_PATH).openConnection();
            in = con.getInputStream();
            IoHelpers.pipeRead(in, out);

            JSONObject bootConf = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));
            version = bootConf.getString("ajxpVersion");
            if (bootConf.has("customWording")) {
                JSONObject customWordings = bootConf.getJSONObject("customWording");
                title = customWordings.getString("title");
                String tmpPath = customWordings.getString("icon");
                // Paths always start with a leading slash in our world.
                iconPath = tmpPath.startsWith("/") ? tmpPath : "/" + tmpPath;

                if (customWordings.has("welcomeMessage")) {
                    welcomeMessage = customWordings.getString("welcomeMessage");
                }
            }

        } catch (Exception e) {
            throw new SDKException(ErrorCodes.api_error, "Could not get boot configuration at " + getId(), e);
        } finally {
            IoHelpers.closeQuietly(con);
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof P8Server))
            return false;
        return url().equals(((P8Server) obj).url());
    }

    public OAuthConfig getOAuthConfig() {
        throw new RuntimeException("Pydio 8 server does not support OAuth credential flows.");
    }

}
