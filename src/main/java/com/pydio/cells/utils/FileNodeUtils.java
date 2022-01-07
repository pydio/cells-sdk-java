package com.pydio.cells.utils;

import com.google.gson.Gson;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.openapi.model.TreeNodeType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Map;

public class FileNodeUtils {

    /**
     * Simply convert a Cells API TreeNode to our local FileNode object.
     * This is the central point for all tweaks to go on supporting  Pydio8 (and the legacy code).
     */
    public static FileNode toFileNode(TreeNode node) {

        FileNode result = new FileNode();

        String uuid = node.getUuid();
        if (uuid == null) {
            return null;
        }
        String treeNodePath = node.getPath();

        // Retrieve the MetaData
        Map<String, String> meta = node.getMetaStore();

        String slug = slugFrom(treeNodePath);
        String path = pathFrom(treeNodePath);
        String name = nameFrom(treeNodePath);

        result.setProperty(SdkNames.NODE_PROPERTY_UUID, uuid);
        result.setProperty(SdkNames.NODE_PROPERTY_ETAG, node.getEtag());
        String mTime = node.getMtime();
        if (mTime != null) {
            result.setProperty(SdkNames.NODE_PROPERTY_MTIME, node.getMtime());
        }

        result.setProperty(SdkNames.NODE_PROPERTY_PATH, path);
        result.setProperty(SdkNames.NODE_PROPERTY_WORKSPACE_SLUG, slug);
        result.setProperty(SdkNames.NODE_PROPERTY_FILENAME, name);

        boolean isFile = node.getType() == TreeNodeType.LEAF;
        result.setProperty(SdkNames.NODE_PROPERTY_IS_FILE, String.valueOf(isFile));
        String type;
        if (isFile) {
            if (meta.containsKey(SdkNames.NODE_PROPERTY_MIME)) {
                type = meta.get(SdkNames.NODE_PROPERTY_MIME);
            } else {
                type = SdkNames.NODE_MIME_DEFAULT;
            }
        } else {
            if (SdkNames.RECYCLE_BIN_NAME.equals(name)) {
                type = SdkNames.NODE_MIME_RECYCLE;
            } else {
                type = SdkNames.NODE_MIME_FOLDER;
            }
        }
        result.setProperty(SdkNames.NODE_PROPERTY_MIME, type);

        result.setProperty(SdkNames.NODE_PROPERTY_TEXT, name);
        result.setProperty(SdkNames.NODE_PROPERTY_LABEL, name);

        String sizeStr = node.getSize();
        if (Str.empty(sizeStr)) {
            sizeStr = "0";
        }
        result.setProperty(SdkNames.NODE_PROPERTY_BYTESIZE, sizeStr);
        result.setProperty(SdkNames.NODE_PROPERTY_FILE_PERMS, String.valueOf(node.getMode()));

        String ws_shares = meta.get("workspaces_shares");
        if (ws_shares != null) {
            result.setProperty(SdkNames.NODE_PROPERTY_AJXP_SHARED, "true");
            result.setProperty(SdkNames.NODE_PROPERTY_SHARE_JSON_INFO, ws_shares);
            try {
                JSONArray shareWorkspaces = new JSONArray(ws_shares);
                JSONObject shareWs = (JSONObject) shareWorkspaces.get(0);
                String shareUUID = shareWs.getString("UUID");
                result.setProperty(SdkNames.NODE_PROPERTY_SHARE_UUID, shareUUID);
            } catch (ParseException ignored) {
                // TODO we should not ignore errors...
            }
        }

        String bookmark = meta.get("bookmark");
        if (Str.notEmpty(bookmark)) {
            result.setProperty(SdkNames.NODE_PROPERTY_BOOKMARK, bookmark);
        }

        boolean isImage = "true".equals(meta.get("is_image"));
        result.setProperty(SdkNames.NODE_PROPERTY_IS_IMAGE, String.valueOf(isImage));
        if (isImage) {
            result.setProperty(SdkNames.NODE_PROPERTY_IMAGE_WIDTH, meta.get("image_width"));
            result.setProperty(SdkNames.NODE_PROPERTY_IMAGE_HEIGHT, meta.get("image_height"));
            try {
                JSONObject thumb = new JSONObject(meta.get("ImageThumbnails"));
                boolean processing = thumb.getBoolean("Processing");
                if (!processing) {
                    JSONArray details = thumb.getJSONArray("thumbnails");
                    JSONObject thumbObject = new JSONObject();
                    for (int i = 0; i < details.length(); i++) {
                        JSONObject item = (JSONObject) details.get(i);
                        int size = item.getInt("size");
                        String format = item.getString("format");
                        String thumbPath = "/" + node.getUuid() + "-" + size + "." + format;
                        thumbObject.put(String.valueOf(size), thumbPath);
                    }
                    result.setProperty(SdkNames.NODE_PROPERTY_IMAGE_THUMB_PATHS, thumbObject.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        result.setProperty(SdkNames.NODE_PROPERTY_META_JSON_ENCODED, new JSONObject(meta).toString());

        // TODO but why do we duplicate the info here, why???
        String encoded = new Gson().toJson(node);
        result.setProperty(SdkNames.NODE_PROPERTY_ENCODED, encoded);
        result.setProperty(SdkNames.NODE_PROPERTY_ENCODING, "gson");

        return result;
    }

    public static String getNameFromPath(String path) {
        int index = path.lastIndexOf("/");
        if (index < 0) {
            return path;
        }
        return path.substring(index + 1);
    }

    private static String nameFrom(String treeNodePath) {
        return treeNodePath.substring(treeNodePath.lastIndexOf("/") + 1);
    }

    private static String slugFrom(String treeNodePath) {
        return treeNodePath.substring(0, treeNodePath.indexOf("/"));
    }

    private static String pathFrom(String treeNodePath) {
        String[] parts = treeNodePath.substring(treeNodePath.indexOf("/") + 1).split("/");
        StringBuilder pathBuilder = new StringBuilder();
        for (String part : parts) {
            pathBuilder.append("/").append(part);
        }
        return pathBuilder.toString();
    }

    public static String toTreeNodePath(String ws, String path) {
        return ws + path;
    }
}
