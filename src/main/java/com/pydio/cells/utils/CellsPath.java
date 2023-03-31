package com.pydio.cells.utils;

/**
 * Provides shortcuts for methods that are widely used when manipulating nodes
 * and their path in a Pydio Cells context.
 * <p>
 * Note: we talk here about tree node path: that are typically "common-files/folder/file.jpg"
 * in the below code, we assume path are valid:
 * - they never start with a /
 * - workspace is always provided
 */
public class CellsPath {

    public static String fullPath(String workspace, String path) {
        StringBuilder sb = new StringBuilder(workspace);
        if ("/".equals(path)) {
            return sb.toString();
        } else {
            sb.append("/").append(path);
            return sb.toString();
        }
    }

    public static String getWorkspace(String fullPath) {
        String[] parts = fullPath.split("/");
        return parts[0];
    }

    public static String nameFromFullPath(String fullPath) {
        String[] parts = fullPath.split("/");
        if (parts.length == 1) {
            return "/";
        } else {
            return parts[parts.length - 1];
        }
    }

}
