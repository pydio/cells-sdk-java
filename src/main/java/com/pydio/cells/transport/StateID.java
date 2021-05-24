package com.pydio.cells.transport;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StateID {

    private final String username;
    private final String serverUrl;
    private final String path;

    public StateID(String username, String serverUrl, String path) {
        this.username = username;
        this.serverUrl = serverUrl;
        this.path = path;
    }

    public StateID(String username, String serverUrl) {
        this.username = username;
        this.serverUrl = serverUrl;
        this.path = null;
    }

    /**
     * Simply creates a StateID object from its *encoded* string representation.
     */
    public static StateID fromId(String stateId) {

        if (stateId == null || stateId.length() == 0) {
            return null;
        }

        // TODO also support missing username ?
        String[] parts = stateId.split("@");
        String username = utf8Decode(parts[0]);
        String encodedUrl = parts[1];

        String serverUrl;
        String path;

        try {
            String urlStr = utf8Decode(encodedUrl);
            URL url = URI.create(urlStr).toURL();
            serverUrl = url.getProtocol() + "://" + url.getAuthority();
            path = url.getPath();
            return new StateID(username, serverUrl, path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves the *encoded* representation of this StateID for serialization.
     */
    public String getId() {
        StringBuilder builder = new StringBuilder();
        builder.append(utf8Encode(username)).append("@");
        StringBuilder urlBuilder = new StringBuilder(serverUrl);
        if (path != null && path.length() > 0 && !"/".equals(path)) {
            urlBuilder.append(path);
        }
        builder.append(utf8Encode(urlBuilder.toString()));
        return builder.toString();
    }

    public String getUsername() {
        return username;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getPath() {
        return path;
    }

    public String getWorkspace() {
        if (path == null || "".equals(path) || "/".equals(path)) {
            return null;
        }
        return path.substring(1).split("/")[0];
    }

    /**
     * Returns the trailing part of the path without the workspace. Always starts with a slash.
     */
    public String getFile() {
        if (path == null || "".equals(path) || "/".equals(path)) {
            return null;
        }
        // TODO: double check and test
        String prefix = "/" + getWorkspace();
        if (path.length() > prefix.length()) {
            return path.substring(prefix.length());
        }
        return null;
    }

    // Not perfect: Might have side effects when switching from plain Java to Android
    // TODO might need to be improved

    private static String utf8Encode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected encoding issue", e);
        }
    }

    private static String utf8Decode(String value) {
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected decoding issue", e);
        }
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(username).append("@");
        builder.append(serverUrl);
        if (path != null && path.length() > 0 && !"/".equals(path)) {
            builder.append(path);
        }
        return builder.toString();
    }
}
