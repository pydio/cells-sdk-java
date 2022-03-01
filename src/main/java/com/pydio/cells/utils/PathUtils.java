package com.pydio.cells.utils;

public class PathUtils {

    public static String getWorkspace(String path) {
        if (path == null || "".equals(path) || "/".equals(path)) {
            return null;
        }
        return path.substring(1).split("/")[0];
    }

    public static String getFile(String path) {
        if (path == null || "".equals(path)) { // || "/".equals(path)) {
            return null;
        }
        String prefix = "/" + getWorkspace(path);
        if (path.length() > prefix.length()) {
            return path.substring(prefix.length());
        } else if (path.length() == prefix.length()) {
            // we only have the workspace, so we consider we are at root of the workspace
            return "/";
        }
        return null;
    }

    public static String getPath(String ws, String file) {
        String path = "/" + ws;
        if (Str.notEmpty(file)) {
            path += file;
        }
        return path;
    }
}
