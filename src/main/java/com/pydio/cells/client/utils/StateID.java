package com.pydio.cells.client.utils;

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
        if (path == null || "".equals(path) || "/".equals(path)){
            return null;
        }
        return path.substring(1).split("/")[0];
    }

    public String getId(){
        StringBuilder builder = new StringBuilder();
        builder.append(utf8Encode(username)).append("@");
        StringBuilder urlBuilder = new StringBuilder(serverUrl);
        if (path != null && path.length() > 0 && !"/".equals(path)){
            urlBuilder.append(path);
        }
        builder.append(utf8Encode(urlBuilder.toString()));
        return builder.toString();
    }

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

    // Simple shortcut to encode URLs
    public static String utf8Encode(String value) {
        // TODO this method throws an exception in android context but not in the sdk-java, why ?
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected encoding issue", e);
        }
        //return super.utf8Encode(value);
    }

    // Simple shortcut to decode URLs
    public static String utf8Decode(String value) {
        // TODO this method throws an exception in android context but not in the sdk-java, why ?
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected decoding issue", e);
        }
        //return super.utf8Encode(value);
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(username).append(" @ ");
        builder.append(serverUrl);
        if (path != null && path.length() > 0 && !"/".equals(path)){
            builder.append(path);
        }
        return builder.toString();
    }
}
