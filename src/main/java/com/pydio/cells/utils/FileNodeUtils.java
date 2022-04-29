package com.pydio.cells.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.openapi.model.TreeNodeType;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Simply converts a Cells API TreeNode to our local FileNode object.
 * This is the central point for all tweaks to go on supporting  Pydio8 (and the legacy code).
 */
public class FileNodeUtils {

    private final static String logTag = FileNodeUtils.class.getSimpleName();

    public static FileNode toFileNode(TreeNode treeNode) {
        FileNode fileNode = new FileNode();

        // Pre-process Path info
        String uuid = treeNode.getUuid();
        if (uuid == null) {
            return null;
        }
        String treeNodePath = treeNode.getPath();
        //Log.d(TAG, "Managing path for: " + treeNodePath);
        String slug = slugFrom(treeNodePath);
        String path = pathFrom(treeNodePath);
        String name = nameFrom(treeNodePath);

        Map<String, String> meta = treeNode.getMetaStore();
        // Retrieve the MetaData and store it as properties for later use
        Properties metaProps = new Properties();
        metaProps.putAll(meta);
        fileNode.setMeta(metaProps);
        // Also stores a hash of the meta to ease detection of future change
        // (remote meta modification not always triggers a modification of the node's timestamp)
        TreeMap<String, String> sorted = new TreeMap<>(meta);
        StringBuilder builder = new StringBuilder();
        for (String value : sorted.values()) { // we can't use recent Java to support android 21 platform
            // FIXME: workspace shares are returned in a random **changing** order
            //  that modifies the hash almost at each call...
            builder.append(value);
        }
        fileNode.setProperty(SdkNames.NODE_PROPERTY_META_HASH, String.valueOf(builder.toString().hashCode()));

        // Main meta info: UUID, eTag (md5) and modification type
        fileNode.setProperty(SdkNames.NODE_PROPERTY_UID, uuid);
        if (Str.notEmpty(treeNode.getEtag())) {
            fileNode.setProperty(SdkNames.NODE_PROPERTY_ETAG, treeNode.getEtag());
        }
        String mTime = treeNode.getMtime();
        if (mTime != null) {
            fileNode.setProperty(SdkNames.NODE_PROPERTY_MTIME, treeNode.getMtime());
        }

        // Path info
        fileNode.setProperty(SdkNames.NODE_PROPERTY_WORKSPACE_SLUG, slug);
        fileNode.setProperty(SdkNames.NODE_PROPERTY_PATH, path);
        fileNode.setProperty(SdkNames.NODE_PROPERTY_FILENAME, name);
        // Why do we have 3 times the same info? TODO: clean
//        result.setProperty(SdkNames.NODE_PROPERTY_TEXT, name);
//        result.setProperty(SdkNames.NODE_PROPERTY_LABEL, name);

        // File or Folder
        boolean isFile = treeNode.getType() == TreeNodeType.LEAF;
        fileNode.setProperty(SdkNames.NODE_PROPERTY_IS_FILE, String.valueOf(isFile));

        // Mime based on remote info
        String type;
        if (isFile) {
            // This needs API level 24
            // type = meta.getOrDefault(SdkNames.NODE_PROPERTY_MIME, SdkNames.NODE_MIME_DEFAULT);
            if (meta.containsKey(SdkNames.NODE_PROPERTY_MIME)) {
                type = meta.get(SdkNames.NODE_PROPERTY_MIME);
                // TODO not very elegant. Sometimes at this point the mime type has leading
                //  and trailing unnecessary double quotes.
                if (type.length() > 2 && type.startsWith("\"") && type.endsWith("\"")) {
                    // Log.e(logTag, "Found a Mime Type: [" + type + "]");
                    type = type.substring(1, type.length() - 1);
                    Log.d(logTag, "Updated Mime Type: [" + type + "]");
                }
            } else {
                // Log.e(logTag, "No mime found for " + path);
                // TODO rather leave this at null?
                type = SdkNames.NODE_MIME_DEFAULT;
            }
        } else {
            if (SdkNames.RECYCLE_BIN_NAME.equals(name)) {
                type = SdkNames.NODE_MIME_RECYCLE;
            } else if ("/".equals(path)) {
                type = SdkNames.NODE_MIME_WS_ROOT;
            } else {
                type = SdkNames.NODE_MIME_FOLDER;
            }
        }
        fileNode.setProperty(SdkNames.NODE_PROPERTY_MIME, type);

        // Size
        String sizeStr = treeNode.getSize();
        if (Str.empty(sizeStr)) {
            sizeStr = "0";
        }
        fileNode.setProperty(SdkNames.NODE_PROPERTY_BYTESIZE, sizeStr);

        // Permissions
        fileNode.setProperty(SdkNames.NODE_PROPERTY_FILE_PERMS, String.valueOf(treeNode.getMode()));

        // Share info
        String wsSharesStr = meta.get(SdkNames.META_KEY_WS_SHARES);
        if (wsSharesStr != null) {
            Gson gson = new Gson();
            Type objType = new TypeToken<Map<String, Object>[]>() {
            }.getType();
            Map<String, Object>[] shares = gson.fromJson(wsSharesStr, objType);

            for (Map<String, Object> currShare : shares) {
                // Filter out cells (scope = 2) at this point
                if (currShare.containsKey("Scope") && ((double) currShare.get("Scope")) == 3) {
                    fileNode.setProperty(SdkNames.NODE_PROPERTY_SHARED, "true");
                    fileNode.setProperty(SdkNames.NODE_PROPERTY_SHARE_UUID, ((String) currShare.get("UUID")));
                    break;
                }
            }
        }

        String bookmark = meta.get("bookmark");
        if (Str.notEmpty(bookmark)) {
            fileNode.setProperty(SdkNames.NODE_PROPERTY_BOOKMARK, bookmark);
        }

        // Image specific info.
        // TODO check what happens for thumbs that are newly generated via the convert tools
        // typically for office documents, videos and pdf.
        boolean isImage = "true".equals(meta.get("is_image"));
        fileNode.setProperty(SdkNames.NODE_PROPERTY_IS_IMAGE, String.valueOf(isImage));
        if (isImage) {
            fileNode.setProperty(SdkNames.NODE_PROPERTY_IMAGE_WIDTH, meta.get("image_width"));
            fileNode.setProperty(SdkNames.NODE_PROPERTY_IMAGE_HEIGHT, meta.get("image_height"));
        }

        return fileNode;
    }

    // TODO double check. Smelling code.
    public static String getNameFromPath(String path) {
        int index = path.lastIndexOf("/");
        if (index <= 0) {
            return path;
        }
        return path.substring(index + 1);
    }

    private static String nameFrom(String treeNodePath) {
        int index = treeNodePath.indexOf("/");
        if (index == -1) {
            return "/";
        } else {
            return treeNodePath.substring(treeNodePath.lastIndexOf("/") + 1);
        }
    }

    private static String slugFrom(String treeNodePath) {
        int index = treeNodePath.indexOf("/");
        if (index == -1) {
            return treeNodePath;
        } else {
            return treeNodePath.substring(0, index);
        }
    }

    private static String pathFrom(String treeNodePath) {
        int index = treeNodePath.indexOf("/");
        if (index == -1) {
            return "/";
        } else {
            String[] parts = treeNodePath.substring(index + 1).split("/");
            StringBuilder pathBuilder = new StringBuilder();
            for (String part : parts) {
                pathBuilder.append("/").append(part);
            }
            return pathBuilder.toString();
        }
    }

    public static String toTreeNodePath(String ws, String path) {
        return ws + path;
    }
}
