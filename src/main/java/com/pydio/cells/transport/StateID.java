package com.pydio.cells.transport;

import com.pydio.cells.utils.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StateID {

    private final String username;
    private final String serverUrl;
    private final String path;

    public StateID(String serverUrl) {
        this.username = null;
        this.serverUrl = serverUrl;
        this.path = null;
    }

    public StateID(String username, String serverUrl) {
        this.username = username;
        this.serverUrl = serverUrl;
        this.path = null;
    }

    public StateID(String username, String serverUrl, String path) {
        this.username = username;
        this.serverUrl = serverUrl;
        this.path = path;
    }

    /**
     * Simply creates a StateID object from its *encoded* string representation.
     * <p>
     * Supported combination are
     * - ServerURL only
     * - Username@ServerURL
     * - Username@ServerURL@Path
     * <p>
     * It is not very robust for the time being.
     */
    public static StateID fromId(String stateId) {

        if (stateId == null || stateId.length() == 0) {
            return null;
        }

        String username = null;
        String host;
        String path = null;

        String[] parts = stateId.split("@");
        switch (parts.length) {
            case 1:
                host = utf8Decode(parts[0]);
                break;
            case 2:
                username = utf8Decode(parts[0]);
                host = utf8Decode(parts[1]);
                break;
            case 3:
                username = utf8Decode(parts[0]);
                host = utf8Decode(parts[1]);
                path = utf8Decode(parts[2]);
                break;
            default:
                Log.e("PARSE", "Could not create State from ID: " + stateId);
                return null;
        }

        return new StateID(username, host, path);
    }

    /**
     * Retrieves the *encoded* representation of this StateID for serialization.
     */
    public String getId() {
        StringBuilder builder = new StringBuilder();
        if (username != null) {
            builder.append(utf8Encode(username)).append("@");
        }
        builder.append(utf8Encode(serverUrl));
        if (path != null && path.length() > 0 && !"/".equals(path)) {
            builder.append("@").append(utf8Encode(path));
        }
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
        String prefix = "/" + getWorkspace();
        if (path.length() > prefix.length()) {
            return path.substring(prefix.length());
        }
        return null;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (username != null) {
            builder.append(username).append("@");
        }
        builder.append(serverUrl);
        if (path != null && path.length() > 0 && !"/".equals(path)) {
            builder.append(path);
        }
        return builder.toString();
    }

    // Not perfect: Might have side effects when switching from plain Java to Android
    // TODO find a elegant way to rather inject the CustomEncoder

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
}
