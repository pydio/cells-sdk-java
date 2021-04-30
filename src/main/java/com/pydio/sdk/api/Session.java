package com.pydio.sdk.api;

import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.core.model.ContentValues;

import java.util.Properties;

public class Session implements SdkNames {

    public Properties properties = new Properties();

    public long id;
    public String serverAddress;
    public String name;

    public String displayName;
    public String user;

    public byte[] logo;
    public String legacyId;

    public Session() {
    }

    public Session(ContentValues values) {
        serverAddress = values.getAsString(ADDRESS);
        id = values.getAsLong(SESSION_ID);
        user = values.getAsString(LOGIN);
        displayName = values.getAsString(DISPLAYED_NAME);
        legacyId = user + "@" + serverAddress.replace("://", "+").replace("/", "&");
        name = values.getAsString(SESSION_NAME);
        logo = values.getAsByteArray(LOGO);
        properties = new Properties();
    }

    public ContentValues values() {
        ContentValues values = new ContentValues();
        values.put(ADDRESS, serverAddress);
        values.put(DISPLAYED_NAME, displayName);
        values.put(LOGIN, user);
        values.put(LOGO, logo);
        values.put(SESSION_NAME, name);
        return values;
    }
}
