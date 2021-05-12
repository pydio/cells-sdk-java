package com.pydio.cells.client.model;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

public class ResolutionServer extends ServerNodeImpl {

    public static final String EXPIRATION_DATE = "expiration";

    private final String name;
    private String resolvedUrl;
    private final String clientID;

    public Properties mVanity;
    public Properties mSupport;
    public Properties[] mEndpoints;
    public ByteArrayOutputStream mImage;

    public ResolutionServer(String id, String resolverName) {
        // FIXME this does not work yet (but was also broken before refactoring)
        super(null);
        clientID = id;
        name = resolverName;
    }

    @Override
    public String url() {
        return resolvedUrl;
    }

    public boolean urlExpired() {
        String expiration = getProperty("expiration");
        if (expiration == null) {
        }
        return false;
    }

    public String resolverName() {
        return name;
    }

    public String clientID() {
        return clientID;
    }

    public void setResolvedUrl(String url) {
        resolvedUrl = url;
    }
}
