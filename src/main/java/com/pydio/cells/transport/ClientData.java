package com.pydio.cells.transport;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.callbacks.PersistentDataManager;

public class ClientData {

    public static String platform = "";
    public static String version = "0.1";
    public static String packageID = "";

    public static String name = "Cells SDK Java";
    private static String clientID = SdkNames.DEFAULT_CLIENT_ID;
    private static String clientSecret = SdkNames.DEFAULT_CLIENT_SECRET;

    public static int versionCode = 1;

    private static PersistentDataManager dataManager;

    public static PersistentDataManager manager() {
        return dataManager;
    }

    public static void setManager(PersistentDataManager m) {
        dataManager = m;
    }

    public static String getClientId(){
        return clientID;
    }

    public static String getClientSecret(){
        return clientSecret;
    }
}