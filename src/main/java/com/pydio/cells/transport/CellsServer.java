package com.pydio.cells.transport;

import com.google.gson.Gson;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CellsServer implements Server {

    public final static String logTag = CellsServer.class.getSimpleName();

    public final static String API_PREFIX = "/a";
    public final static String BOOTCONF_PATH = API_PREFIX + "/frontend/bootconf";

    private final ServerURL serverURL;

    private OAuthConfig authConfig;
    private String title;
    private String welcomeMessage;
    private String iconPath;
    private String version = null;
    private boolean hasLicenceFeatures = false;
    private String customPrimaryColor = null;

    // Legacy objects TODO remove
//     private JSONObject bootConf;

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
        return hasLicenceFeatures;
    }

    @Override
    public String getCustomPrimaryColor() {
        return customPrimaryColor;
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
            in = con.getInputStream();
            IoHelpers.pipeRead(in, out);

            String jsonString = new String(out.toByteArray(), StandardCharsets.UTF_8);
            Gson gson = new Gson();
            @SuppressWarnings("unchecked") Map<String, Object> map = gson.fromJson(jsonString, Map.class);

            if (map.containsKey("customWording")) {
                @SuppressWarnings("unchecked") Map<String, Object> customWordings = (Map<String, Object>) map.get("customWording");
                title = (String) customWordings.get("title");
                iconPath = (String) customWordings.get("icon");
                if (customWordings.containsKey("welcomeMessage")) {
                    welcomeMessage = (String) customWordings.get("welcomeMessage");
                }
            }

            // FIXME this is broken. Find where it is used and fix if necessary.
            hasLicenceFeatures = map.containsKey("license_features");

            // TODO factorize this and then remove the JSON old library
            if (map.containsKey("other")) {
                Object oo = map.get("other");
                if (oo instanceof Map) {
                    @SuppressWarnings("unchecked") Map<String, Object> other = (Map<String, Object>) oo;
                    if (other.containsKey("vanity")) {
                        oo = other.get("vanity");
                        if (oo instanceof Map) {
                            @SuppressWarnings("unchecked") Map<String, Object> vanity = (Map<String, Object>) oo;
                            if (vanity.containsKey("palette")) {
                                oo = vanity.get("palette");
                                if (oo instanceof Map) {
                                    @SuppressWarnings("unchecked") Map<String, Object> palette = (Map<String, Object>) oo;
                                    if (palette.containsKey("primary1Color")) {
                                        oo = palette.get("primary1Color");
                                        if (oo instanceof String && Str.notEmpty((String) oo)) {
                                            Log.d(logTag, "Found a color: " + oo);
                                            customPrimaryColor = (String) oo;
                                        }
                                    }
                                }
                            }
                        }
                    }
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
            IoHelpers.pipeRead(in, out);
            String oidcStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
            // Log.d(LOG_TAG, "Retrieved OIDC string: " + oidcStr);
            authConfig = OAuthConfig.fromOIDCResponse(oidcStr);
        } catch (FileNotFoundException e) {
            Log.e(logTag, "Cannot retrieve OIDC configuration at " + e.getMessage());
            e.printStackTrace();
            throw new SDKException(ErrorCodes.server_configuration_issue,
                    "Cannot retrieve OIDC well known file for " + getServerURL().getURL().toString() + ", please check your server config", e);
        } catch (Exception e) {
            Log.e(logTag, "Unexpected error while retrieving OIDC configuration"
                    + ", cause: " + e.getMessage());
            e.printStackTrace();
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
