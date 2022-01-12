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

    private final static String META_KEY_IMG_THUMBS = "ImageThumbnails";
    private final static String META_KEY_THUMB_PROCESSING = "Processing";
    private final static String META_KEY_THUMB_DATA = "thumbnails";
    private final static String META_KEY_WS_SHARES = "workspaces_shares";

    /**
     * Simply converts a Cells API TreeNode to our local FileNode object.
     * This is the central point for all tweaks to go on supporting  Pydio8 (and the legacy code).
     */
    public static FileNode toFileNode(TreeNode node) {

        FileNode result = new FileNode();

        // Pre-process Path info
        String uuid = node.getUuid();
        if (uuid == null) {
            return null;
        }
        String treeNodePath = node.getPath();
        String slug = slugFrom(treeNodePath);
        String path = pathFrom(treeNodePath);
        String name = nameFrom(treeNodePath);

        // Retrieve the MetaData and store them unmodified as a JSON object for later use
        Map<String, String> meta = node.getMetaStore();
        result.setProperty(SdkNames.NODE_PROPERTY_META_JSON_ENCODED, new Gson().toJson(meta));

        // Main meta info: UUID, eTag (md5) and modification type
        result.setProperty(SdkNames.NODE_PROPERTY_UUID, uuid);
        result.setProperty(SdkNames.NODE_PROPERTY_ETAG, node.getEtag());
        String mTime = node.getMtime();
        if (mTime != null) {
            result.setProperty(SdkNames.NODE_PROPERTY_MTIME, node.getMtime());
        }

        // Path info
        result.setProperty(SdkNames.NODE_PROPERTY_PATH, path);
        result.setProperty(SdkNames.NODE_PROPERTY_WORKSPACE_SLUG, slug);
        // Why do we have 3 times the same info? TODO: clean
        result.setProperty(SdkNames.NODE_PROPERTY_FILENAME, name);
        result.setProperty(SdkNames.NODE_PROPERTY_TEXT, name);
        result.setProperty(SdkNames.NODE_PROPERTY_LABEL, name);

        // File or Folder
        boolean isFile = node.getType() == TreeNodeType.LEAF;
        result.setProperty(SdkNames.NODE_PROPERTY_IS_FILE, String.valueOf(isFile));

        // Mime based on remote info
        String type;
        if (isFile) {
            // This needs API level 24
            // type = meta.getOrDefault(SdkNames.NODE_PROPERTY_MIME, SdkNames.NODE_MIME_DEFAULT);
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

        // Size
        String sizeStr = node.getSize();
        if (Str.empty(sizeStr)) {
            sizeStr = "0";
        }
        result.setProperty(SdkNames.NODE_PROPERTY_BYTESIZE, sizeStr);

        // Permissions
        result.setProperty(SdkNames.NODE_PROPERTY_FILE_PERMS, String.valueOf(node.getMode()));

        // Share info
        String ws_shares = meta.get(META_KEY_WS_SHARES);
        if (ws_shares != null) {
            result.setProperty(SdkNames.NODE_PROPERTY_SHARED, "true");
            result.setProperty(SdkNames.NODE_PROPERTY_SHARE_INFO, ws_shares);
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

        // Image specific info.
        // TODO check what happens for thumbs that are newly generated via the convert tools
        // typically for office documents, videos and pdf.
        boolean isImage = "true".equals(meta.get("is_image"));
        result.setProperty(SdkNames.NODE_PROPERTY_IS_IMAGE, String.valueOf(isImage));
        if (isImage) {
            result.setProperty(SdkNames.NODE_PROPERTY_IMAGE_WIDTH, meta.get("image_width"));
            result.setProperty(SdkNames.NODE_PROPERTY_IMAGE_HEIGHT, meta.get("image_height"));
            try {

                // TODO rather use GSON to get rid of legacy JSON Object TP
//                Map<String, Object> thumbData = new Gson().fromJson(meta.get(META_KEY_IMG_THUMBS), Map.class);
//                if ("false".equals(thumbData.get(META_KEY_THUMB_PROCESSING))){
//                    Object o = thumbData.get(META_KEY_THUMB_DATA);
//                    if (o != null && o instanceof String){
//
//                    }

                JSONObject imgThumbs = new JSONObject(meta.get(META_KEY_IMG_THUMBS));
                boolean processing = imgThumbs.getBoolean(META_KEY_THUMB_PROCESSING);
                if (!processing) {
                    JSONArray details = imgThumbs.getJSONArray(META_KEY_THUMB_DATA);
                    JSONObject thumbObject = new JSONObject();
                    for (int i = 0; i < details.length(); i++) {
                        JSONObject item = (JSONObject) details.get(i);
                        int size = item.getInt("size");
                        String format = item.getString("format");
                        String thumbName = node.getUuid() + "-" + size + "." + format;
                        thumbObject.put(String.valueOf(size), thumbName);
                    }
                    result.setProperty(SdkNames.NODE_PROPERTY_REMOTE_THUMBS, thumbObject.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
