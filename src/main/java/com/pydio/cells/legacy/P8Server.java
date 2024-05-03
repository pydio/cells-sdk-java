package com.pydio.cells.legacy;

import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

public class P8Server implements Server {

    private final String logTag = "P8Server";

    public final static String API_PREFIX = "/index.php?";
    public final static String BOOT_CONF_PATH = API_PREFIX + "get_action=" + P8Names.GET_BOOT_CONF;
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

    @Override
    public String getCustomPrimaryColor() {
        // TODO implement this for P8 also ?
        return null;
    }

    @Override
    public String getLabel() {
        if (title != null && !title.isEmpty()) {
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

    public String version() {
        if (version == null) {
            throw new RuntimeException("Trying to retrieve AJXP Version param before the server has been instantiated");
        }
        return version;
    }

    @Override
    public String getVersionName() {
        return version();
    }

    // Local shortcut
    private String getId() {
        return serverURL.getId();
    }

    private void refreshBootConf() throws SDKException {
        // Log.e(logTag, "Starting boot conf refresh process");
        HttpURLConnection con = null;
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            con = serverURL.withSpec(BOOT_CONF_PATH).openConnection();
            in = con.getInputStream();
            long read = IoHelpers.pipeRead(in, out);

            if (read < 1) {
                throw new SDKException(ErrorCodes.api_error, "Could not get boot configuration at " + serverURL);
            }

            Map<String, Object> respMap = IoHelpers.fromJsonByteArray(out);

            version = (String) respMap.get("ajxpVersion");
            if (respMap.containsKey("customWording") && respMap.get("customWording") instanceof Map) {
                Map<String, Object> wordingMap = (Map<String, Object>) respMap.get("customWording");
                title = (String) wordingMap.get("title");
                String tmpPath = (String) wordingMap.get("icon");
                // Paths always start with a leading slash in our world.
                iconPath = tmpPath.startsWith("/") ? tmpPath : "/" + tmpPath;

                if (wordingMap.containsKey("welcomeMessage")) {
                    welcomeMessage = (String) wordingMap.get("welcomeMessage");
                }
            }
        } catch (Exception e) {
            Log.e(logTag, "Could not get boot configuration at " + getId());
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
        Log.e(logTag, "Trying to retrieve an OAuth config on a P8 Server");
        throw new RuntimeException("Pydio 8 server does not support OAuth credential flows.");
    }
}
