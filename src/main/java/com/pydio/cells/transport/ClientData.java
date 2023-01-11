package com.pydio.cells.transport;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.utils.Str;

import java.util.Locale;

public class ClientData {

    public final static String DEFAULT_APP_LABEL = "Cells Java SDK";
    public final static String DEFAULT_APP_NAME = "CellsJavaSDK";

    private static final Integer lock = Integer.valueOf(0);

    private Long buildTimestamp = 0L;
    private String platform = "";
    private String version = "0.1";
    private String packageID = "";

    private String name = DEFAULT_APP_NAME;
    private String label = DEFAULT_APP_LABEL;
    private String clientID = SdkNames.DEFAULT_CLIENT_ID;
    private String clientSecret = SdkNames.DEFAULT_CLIENT_SECRET;

    private long versionCode = 1;

    private static ClientData instance;

    public static ClientData getInstance() {
        synchronized (lock) {
            if (instance != null) {
                return instance;
            }
            instance = new ClientData();
            return instance;
        }
    }

    public static void updateInstance(ClientData clientData) {
        synchronized (lock) {
            instance = clientData;
        }
    }

    public String userAgent() {
        String userAgent = String.format(Locale.US, "%s-%s/%d", getName(), getVersion(), getVersionCode());
        if (Str.notEmpty(getPlatform())) {
            userAgent = getPlatform() + "/" + userAgent;
        }
        if (Str.notEmpty(getPackageID())) {
            userAgent = userAgent + "/" + getPackageID();
        }
        return userAgent;
    }

    public Long getBuildTimestamp() {
        return buildTimestamp;
    }

    public void setBuildTimestamp(Long buildTimestamp) {
        this.buildTimestamp = buildTimestamp;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(long versionCode) {
        this.versionCode = versionCode;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientID;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
