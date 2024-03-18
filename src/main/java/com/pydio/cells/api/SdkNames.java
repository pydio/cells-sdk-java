package com.pydio.cells.api;

/**
 * Centralize all string constants for the com.pydio.sdk API
 */
public interface SdkNames {

    /* CONSTANTS */

    String TYPE_CELLS = "cells";
    String TYPE_LEGACY_P8 = "pydio";

    // Well known Pydio specific Mime Types
    String NODE_MIME_WS_ROOT = "pydio/workspace-root";
    String NODE_MIME_FOLDER = "pydio/nodes-list";
    String NODE_MIME_RECYCLE = "pydio/recycle";
    String NODE_MIME_DEFAULT = "application/octet-stream";
    String NODE_MIME_DEFAULT2 = "binary/octet-stream";

    // Workspaces types
    String WS_TYPE_PERSONAL = "workspace-personal";
    String WS_TYPE_CELL = "cell";
    String WS_TYPE_DEFAULT = "workspace";

    String RECYCLE_BIN_NAME = "recycle_bin";

    // Auth Management
//    String TOKEN_TYPE_BEARER = "bearer";
    String TOKEN_TYPE_P8 = "pydio8";

    String DEFAULT_CLIENT_ID = "cells-client";
    String DEFAULT_CLIENT_SECRET = "";

    /* PROPERTY KEYS */

    // Node (file and folder) properties
    String NODE_PROPERTY_PATH = "path";
    String NODE_PROPERTY_FILENAME = "filename";
    String NODE_PROPERTY_BYTESIZE = "bytesize";
    String NODE_PROPERTY_MIME = "mime";
    String NODE_PROPERTY_MTIME = "ajxp_modiftime";
    String NODE_PROPERTY_TEXT = "text";

    String NODE_PROPERTY_IS_FILE = "is_file";
    String NODE_PROPERTY_IS_IMAGE = "is_image";
    String NODE_PROPERTY_HAS_THUMB = "has_thumb";
    String NODE_PROPERTY_IS_PRE_VIEWABLE = "is_pre_viewable";

    //    String NODE_PROPERTY_REMOTE_THUMBS = "remote_thumbs";
    String NODE_PROPERTY_IMG_EXIF_ORIENTATION = "image_exif_orientation";

    String NODE_PROPERTY_FILE_PERMS = "file_perms";
    String NODE_PROPERTY_IMAGE_HEIGHT = "image_height";
    String NODE_PROPERTY_IMAGE_WIDTH = "image_width";
    String NODE_PROPERTY_LABEL = "label";
    String NODE_PROPERTY_ETAG = "etag";

    String NODE_PROPERTY_WORKSPACE_SLUG = "workspace_slug";

    String NODE_PROPERTY_BOOKMARK = "bookmark";
    String NODE_PROPERTY_SHARED = "shared";
    String NODE_PROPERTY_SHARE_LINK = "share_link";
    String META_KEY_WS_SHARES = "workspaces_shares";

    String NODE_PROPERTY_META_HASH = "meta_hash";

    String META_KEY_IMG_THUMBS = "ImageThumbnails";

    // TODO Clean legacy properties below
    // These 2 should rather be lower cased - necessitate a migration of the cache
    String NODE_PROPERTY_UID = "Uuid";
    String NODE_PROPERTY_SHARE_UUID = "share_Uuid";
    //    String NODE_PROPERTY_UUID = "uuid";
    //    String NODE_PROPERTY_SHARE_UUID = "share_uuid";

    String WORKSPACE_PROPERTY_ID = "id";
    String WORKSPACE_DESCRIPTION = "description";
    String WORKSPACE_PROPERTY_SLUG = "repositorySlug";
    String WORKSPACE_PROPERTY_LABEL = "label";

    String WORKSPACE_PROPERTY_TYPE = "repository_type";
    String WORKSPACE_PROPERTY_ACCESS_TYPE = "access_type";
    String WORKSPACE_PROPERTY_OWNER = "owner";
    String WORKSPACE_PROPERTY_CROSS_COPY = "allowCrossRepositoryCopy";
    String WORKSPACE_PROPERTY_META_SYNC = "meta_syncable_REPO_SYNCABLE";
    String WORKSPACE_PROPERTY_ACL = "acl";
    String WORKSPACE_IS_PUBLIC = "is_public";


    // Cells
    String WORKSPACE_ACCESS_TYPE_DIRECTORY = "directory";
    //  Pydio 8 specific
    String WORKSPACE_ACCESS_TYPE_SHARED = "ajxp_shared";
    String WORKSPACE_ACCESS_TYPE_CONF = "ajxp_conf";
    String WORKSPACE_ACCESS_TYPE_MYSQL = "mysql";
    String WORKSPACE_ACCESS_TYPE_IMAP = "imap";
    String WORKSPACE_ACCESS_TYPE_JSAPI = "jsapi";
    String WORKSPACE_ACCESS_TYPE_USER = "ajxp_user";
    String WORKSPACE_ACCESS_TYPE_HOME = "ajxp_home";
    String WORKSPACE_ACCESS_TYPE_HOMEPAGE = "homepage";
    String WORKSPACE_ACCESS_TYPE_ADMIN = "ajxp_admin";
    String WORKSPACE_ACCESS_TYPE_SETTINGS = "settings";
    String WORKSPACE_ACCESS_TYPE_INBOX = "inbox";

    String NODE_DIFF_ADD = "add";
    String NODE_DIFF_UPDATE = "update";
    String NODE_DIFF_REMOVE = "remove";

    String XML_MESSAGE = "message";
    String XML_NODES_DIFF = "nodes_diff";

    String MESSAGE_PROPERTY_TYPE = "type";

    int LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE = 2048;

    String ADDRESS = "address";
    String ALIAS = "alias";
    String SERVER = "server";

    String CHANGE_NODE_ID = "node_id";
    String CHANGE_SEQ = "seq";
    String CHANGE_TYPE = "type";
    String CHANGE_SOURCE = "source";
    String CHANGE_TARGET = "target";
    String CHANGE_NODE_BYTESIZE = "bytesize";
    String CHANGE_NODE_MD5 = "md5";
    String CHANGE_NODE_MTIME = "mtime";
    String CHANGE_NODE_PATH = "node_path";
    String CHANGE_NODE_WORKSPACE = "repository_identifier";
    String CHANGE_NODE = "node";

    String[] defaultExcludedWorkspaces = {
            WORKSPACE_ACCESS_TYPE_DIRECTORY,
            WORKSPACE_ACCESS_TYPE_CONF,
            WORKSPACE_ACCESS_TYPE_SHARED,
            WORKSPACE_ACCESS_TYPE_MYSQL,
            WORKSPACE_ACCESS_TYPE_IMAP,
            WORKSPACE_ACCESS_TYPE_JSAPI,
            WORKSPACE_ACCESS_TYPE_USER,
            WORKSPACE_ACCESS_TYPE_HOME,
            WORKSPACE_ACCESS_TYPE_HOMEPAGE,
            WORKSPACE_ACCESS_TYPE_SETTINGS,
            WORKSPACE_ACCESS_TYPE_ADMIN,
            WORKSPACE_ACCESS_TYPE_INBOX,
    };
}
