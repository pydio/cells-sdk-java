package com.pydio.cells.utils;

import com.google.gson.Gson;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.client.model.FileNodeImpl;
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.openapi.model.TreeNodeType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Map;

public class FileNodeUtils {

    public static FileNode toFileNode(TreeNode node) {

        String uuid = node.getUuid();
        if (uuid == null) {
            return null;
        }

        FileNode result = new FileNodeImpl();
        String tnPath = node.getPath();
        Map<String, String> meta = node.getMetaStore();

        String slug = slugFromTreeNodePath(tnPath);
        String path = pathFromTreeNodePath(tnPath);
        String name = nameFromTreeNodePath(tnPath);

        result.setProperty(SdkNames.NODE_PROPERTY_ETAG,node.getEtag());
        result.setProperty(SdkNames.NODE_PROPERTY_UUID, node.getUuid());
        result.setProperty(SdkNames.NODE_PROPERTY_WORKSPACE_SLUG, slug);
        result.setProperty(SdkNames.NODE_PROPERTY_PATH, path);
        result.setProperty(SdkNames.NODE_PROPERTY_FILENAME, path);

        result.setProperty(SdkNames.NODE_PROPERTY_TEXT, name);
        result.setProperty(SdkNames.NODE_PROPERTY_LABEL, name);

        boolean isFile = node.getType() == TreeNodeType.LEAF;
        result.setProperty(SdkNames.NODE_PROPERTY_IS_FILE, String.valueOf(isFile));

        result.setProperty(SdkNames.NODE_PROPERTY_META_JSON_ENCODED, new JSONObject(meta).toString());
        String isImage = meta.get("is_image") == null ? "false" : meta.get("is_image");
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
        if (bookmark != null && bookmark.length() > 0) {
            //  TODO why do we need to sanitize this way?
            result.setProperty(SdkNames.NODE_PROPERTY_BOOKMARK, bookmark.replace("\"\"", "\""));
        }

        String nodeSize = node.getSize();
        if (nodeSize == null) {
            if (!isFile) {
                result.setProperty(SdkNames.NODE_PROPERTY_BYTESIZE, "4096");
            }
        } else {
            result.setProperty(SdkNames.NODE_PROPERTY_BYTESIZE, nodeSize);
        }

        result.setProperty(SdkNames.NODE_PROPERTY_FILE_PERMS, String.valueOf(node.getMode()));
        String mtime = node.getMtime();
        if (mtime != null) {
            result.setProperty(SdkNames.NODE_PROPERTY_AJXP_MODIFTIME, node.getMtime());
        }

        result.setProperty(SdkNames.NODE_PROPERTY_IS_IMAGE, isImage);
        if (isImage.equals("true")) {
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

    public static String nameFromTreeNodePath(String path) {
        return path.substring(path.lastIndexOf("/") + 1);
    }

    public static String slugFromTreeNodePath(String path) {
        return path.substring(0, path.indexOf("/"));
    }

    public static String pathFromTreeNodePath(String path) {
        String[] parts = path.substring(path.indexOf("/") + 1).split("/");
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
