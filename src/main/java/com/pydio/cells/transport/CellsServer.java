package com.pydio.cells.transport;

import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

public class CellsServer implements Server {

    public final static String API_PREFIX = "/a";
    public final static String BOOTCONF_PATH = API_PREFIX + "/frontend/bootconf";

    private final ServerURL serverURL;

    private OAuthConfig authConfig;
    private String title;
    private String welcomeMessage;
    private String iconPath;
    private String version = null;

    // Legacy objects TODO remove
    private JSONObject bootConf;

    public CellsServer(ServerURL serverURL) {
        this.serverURL = serverURL;
    }


    @Override
    public Server init() throws SDKException {
        return refresh(true);
    }

    @Override
    public Server refresh(boolean force) throws SDKException {
        if (force || version == null) {
            downloadBootConf();
            downloadOIDCConfiguration();
        }
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
        return SdkNames.TYPE_CELLS;
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    @Override
    public OAuthConfig getOAuthConfig() {
        return authConfig;
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
        return welcomeMessage;
    }

    @Override
    public String getVersionName() {
        if (version == null) {
            throw new RuntimeException("Trying to retrieve AJXP Version param before the server has been instantiated");
        }
        return version;
    }

    public boolean hasLicenseFeatures() {
        return bootConf != null && bootConf.has("license_features");
    }

    public HttpURLConnection openAnonConnection(String path) throws IOException {
        return newURL(path).openConnection();
    }

    @Deprecated
    @Override
    public boolean supportsOauth() {
        // return authConfig != null;
        return true;
    }

    @Deprecated
    public String getIconPath() {
        return iconPath;
    }

    private void downloadBootConf() throws SDKException {
        HttpURLConnection con = null;
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            con = openAnonConnection(BOOTCONF_PATH);
            //con.setRequestMethod("GET");
            in = con.getInputStream();
            IoHelpers.pipeRead(in, out);

            bootConf = new JSONObject(new String(out.toByteArray(), StandardCharsets.UTF_8));
            version = bootConf.getString("ajxpVersion");
            if (bootConf.has("customWording")) {
                JSONObject customWordings = bootConf.getJSONObject("customWording");
                title = customWordings.getString("title");
                iconPath = customWordings.getString("icon");
                if (customWordings.has("welcomeMessage")) {
                    welcomeMessage = customWordings.getString("welcomeMessage");
                }
            }
        } catch (Exception e) {
            throw new SDKException(ErrorCodes.unexpected_content, "Could not get boot configuration at " + url(), e);
        } finally {
            IoHelpers.closeQuietly(con);
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    private void downloadOIDCConfiguration() throws SDKException {
        HttpURLConnection con = null;
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ServerURL oidcURL = newURL(OAuthConfig.OIDC_WELL_KNOWN_CONFIG_PATH);
            con = oidcURL.openConnection();
            con.setRequestMethod("GET");
            in = con.getInputStream();
            // long totalRead = IoHelpers.pipeRead(in, out);
            IoHelpers.pipeRead(in, out);
            String oidcStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
//            JSONObject oidcJson = new JSONObject(oidcStr);
            authConfig = OAuthConfig.fromOIDCResponse(oidcStr);
        } catch (Exception e) {
            Log.w("Initialisation", "Unexpected error while retrieving OIDC configuration"
                    + ", cause: " + e.getMessage());
            throw SDKException.unexpectedContent(e);
        } finally {
            IoHelpers.closeQuietly(con);
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CellsServer))
            return false;
        return url().equals(((CellsServer) obj).url());
    }

}
