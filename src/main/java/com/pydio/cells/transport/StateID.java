package com.pydio.cells.transport;

import com.pydio.cells.api.Transport;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.PathUtils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Central object to ease manipulation of remote nodes by defining a unique ID
 * that relies on:
 * - the username for the current session
 * - the full URL of the distant server
 * - a path to a given node (including its containing workspace)
 */
public class StateID {

    //    private final static String version = System.getProperty("java.version");
    public static final StateID NONE = new StateID(Transport.UNDEFINED_URL);
    private final static String logTag = "StateID";

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
     * Supported combinations are:
     * - ServerURL only
     * - Username@ServerURL
     * - Username@ServerURL@Path
     */
    public static StateID fromId(String stateId) {

        if (stateId == null || stateId.isEmpty()) {
            return null;
        }

        String username = null;
        String host;
        String path = null;

        try {
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
                    Log.e(logTag, "Could not create State from ID: " + stateId);
                    return null;
            }

            return new StateID(username, host, path);
        } catch (IllegalArgumentException iae) {
            Log.e(logTag, "Could not decode [" + stateId + "] - cause:" + iae);
            iae.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves the *encoded* representation of the *account* part of this StateID for serialization.
     */
    public String getAccountId() {
        StringBuilder builder = new StringBuilder();
        if (username != null) {
            builder.append(utf8Encode(username)).append("@");
        }
        builder.append(utf8Encode(serverUrl));
        return builder.toString();
    }


    /**
     * Retrieves the *encoded* representation of this StateID for serialization.
     */
    public String getId() {
        StringBuilder builder = new StringBuilder(getAccountId());
        if (path != null && !path.isEmpty() && !"/".equals(path)) {
            builder.append("@").append(utf8Encode(path));
        }
        return builder.toString();
    }

    /* Simply retrieves the account part of a state as a StateID object */
    public StateID account() {
        return fromId(getAccountId());
    }

    /* Simply retrieves the containing workspace of a state as a StateID object */
    public StateID workspace() {
        if (getSlug() == null) {
            return null;
        }
        return withPath("/" + getSlug());
    }

    public String getUsername() {
        return username;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * Best effort to provide a short host name from the URL. If the current url values raises
     * a malformed URL exception, we return the initial value.
     */
    public String getServerHost() {
        try {
            URL url = URI.create(getServerUrl()).toURL();
            return url.getHost();
        } catch (MalformedURLException e) {
            return serverUrl;
        }
    }

    public String getPath() {
        return path;
    }

    public String getSlug() {
        return PathUtils.getWorkspace(path);
    }

    /**
     * Returns the trailing part of the path without the workspace. Always starts with a slash.
     */
    public String getFile() {
        return PathUtils.getFile(path);
    }

    public String getFileName() {
        String file = getFile();
        if (file == null || "/".equals(file)) {
            return null;
        }
        return file.substring(file.lastIndexOf("/") + 1);
    }

    /* HELPER METHODS */

    /**
     * Creates a copy of this state ID and sets the passed path.
     * Warning: we assume parent StateID's username **and** serverUrl are already set.
     *
     * @param path a path including the workspace
     * @return a valid StateID pointing to this path within the account defined by this username
     * and server URL
     */
    public StateID withPath(String path) {
        return new StateID(username, serverUrl, path);
    }

    /**
     * Creates a copy of this state ID and sets the passed path.
     * <p>
     * Warning:
     * - we assume parent StateID's username **and** serverUrl are already set.
     * - passing null, an empty string or "/", we return this.
     * - passing a file name that contains a slash raises a runtime exception
     *
     * @return a valid StateID for a child of the current workspace or folder.
     */
    public StateID child(String fileName) {
        if (fileName == null || fileName.isEmpty() || "/".equals(fileName)) {
            return this;
        }

        if (fileName.contains("/")) {
            throw new RuntimeException("wrong filename: [" + fileName + "], inner slash are forbidden");
        }

        String newPath;
        if (getPath() == null) {
            Log.w(logTag, "Getting " + fileName + " child for " + this + ", path is null");
            newPath = "/" + fileName;
        } else if (getPath().endsWith("/")) {
            newPath = getPath() + fileName;
        } else {
            newPath = getPath() + "/" + fileName;
        }

        return new StateID(username, serverUrl, newPath);
    }

    public StateID parent() {
        if (getParentPath() == null) {
            // Corner case: parent of a workspace or a cell is the corresponding account
            return new StateID(username, serverUrl);
        }
        return new StateID(username, serverUrl, getParentPath());
    }

    /**
     * Rather use parent() to handle nicely corner cases
     */
    @Deprecated
    public StateID parentFolder() {
        if (getParentFile() == null) {
            // Corner case: parent of a workspace or a cell is the corresponding account
            return new StateID(username, serverUrl);
        }
        return new StateID(username, serverUrl, "/" + getSlug() + getParentFile());
    }

    public Boolean isWorkspaceRoot() {
        if (getPath() == null) {
            return false;
        }
        return getPath().equals("/" + getSlug());
    }

    public String getParentPath() {
        String path = getPath();
        if (path == null || "/".equals(path)) {
            return null;
        }
        String parentPath = path.substring(0, path.lastIndexOf("/"));
        if (parentPath.isEmpty()) {
            return null;
        }
        return parentPath;
    }

    public String getParentFile() {
        String file = getFile();
        if (file == null || "/".equals(file)) {
            return null;
        }
        String parentFile = file.substring(0, file.lastIndexOf("/"));
        if (parentFile.isEmpty()) {
            parentFile = "/";
        }
        return parentFile;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (username != null) {
            builder.append(username).append("@");
        }
        builder.append(serverUrl);
        if (path != null && !path.isEmpty() && !"/".equals(path)) {
            builder.append(path);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StateID) || getId() == null)
            return false;
        return getId().equals(((StateID) other).getId());
    }

    @Override
    public int hashCode() {
        if (getId() == null)
            return "null".hashCode();
        return getId().hashCode();
    }

    // TODO find a elegant way to rather inject the CustomEncoder.
    //   Not perfect: Might have side effects when switching from plain Java to Android
    // TODO this should also be private or protected
    @SuppressWarnings({"NewApi"})
    public static String utf8Encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                return URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                return value;
            }
        }
    }

    @SuppressWarnings("NewApi")
    public static String utf8Decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                return URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                return value;
            }
        }
    }
}
