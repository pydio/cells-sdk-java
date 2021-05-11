package com.pydio.cells.client;

import com.pydio.cells.api.callbacks.PersistentDataManager;

public class ClientData {

    public static String name = "Cells SDK Java";
    public static String platform = "";
    public static String version = "0.1";
    public static String packageID = "";
    public static int versionCode = 1;

    private static PersistentDataManager dataManager;

    public static PersistentDataManager manager(){
        return dataManager;
    }
    public static void setManager(PersistentDataManager m){
        dataManager = m;
    }
}