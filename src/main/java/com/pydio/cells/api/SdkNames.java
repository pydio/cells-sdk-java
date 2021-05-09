package com.pydio.cells.api;

/** Centralize all string constants for the com.pydio.sdk API */
public interface SdkNames {

    String TYPE_CELLS = "cells";
    String TYPE_LEGACY_P8 = "pydio";

    String XML_MESSAGE = "message";
    String NODE_PROPERTY_UUID = "Uuid";
    String NODE_PROPERTY_ENCODED = "encoded";
    String NODE_PROPERTY_ENCODING = "encoding";
    String NODE_PROPERTY_ENCODED_HASH = "encoded_hash";
    String NODE_PROPERTY_BOOKMARK = "bookmark";
    String NODE_PROPERTY_TYPE = "Type";
    String XML_NODES_DIFF = "nodes_diff";
    String NODE_PROPERTY_ID = "id";
    String NODE_PROPERTY_AJXP_MIME = "ajxp_mime";
    String NODE_PROPERTY_AJXP_SHARED = "ajxp_shared";
    String NODE_PROPERTY_AJXP_BOOKMARKED = "ajxp_bookmarked";
    String NODE_PROPERTY_SHARE_JSON_INFO = "share_json_info";
    String NODE_PROPERTY_SHARE_UUID = "share_Uuid";
    String NODE_PROPERTY_META_JSON_ENCODED = "meta_encoded";
    String NODE_PROPERTY_JSON_ENCODED = "encoded";
    String NODE_PROPERTY_AJXP_MODIFTIME = "ajxp_modiftime";
    String NODE_PROPERTY_BYTESIZE = "bytesize";
    String NODE_PROPERTY_FILE_GROUP = "file_group";
    String NODE_PROPERTY_FILE_OWNER = "file_owner";
    String NODE_PROPERTY_FILE_PERMS = "file_perms";
    String NODE_PROPERTY_FILE_SIZE = "filesize";
    String NODE_PROPERTY_FILENAME = "filename";
    String NODE_PROPERTY_ORIGINAL_PATH = "original_path";
    String NODE_PROPERTY_ICON = "icon";
    String NODE_PROPERTY_IS_FILE = "is_file";
    String NODE_PROPERTY_IS_IMAGE = "is_image";
    String NODE_PROPERTY_SHARE_LINK = "share_link";
    String NODE_PROPERTY_SHARE_LINK_DESCRIPTION = "share_link_description";
    String NODE_PROPERTY_SHARE_LINK_EXPIRED = "share_link_expired";
    String NODE_PROPERTY_META_FIELDS = "meta_fields";
    String NODE_PROPERTY_META_LABELS = "meta_labels";
    String NODE_PROPERTY_META_TYPES = "meta_types";
    String NODE_PROPERTY_MIMESTRING = "mimestring";
    String NODE_PROPERTY_MIMESTRING_ID = "mimestring_id";
    String NODE_PROPERTY_READABLE_DIMENSION = "readable_dimension";
    String NODE_PROPERTY_OPEN_ICON = "openicon";
    String NODE_PROPERTY_REPO_HAS_RECYCLE_BIN = "repo_has_recycle";
    String NODE_PROPERTY_TEXT = "text";
    String NODE_PROPERTY_IMAGE_HEIGHT = "image_height";
    String NODE_PROPERTY_IMAGE_WIDTH = "image_width";
    String NODE_PROPERTY_IMAGE_TYPE = "image_type";
    String NODE_PROPERTY_IMAGE_THUMB_PATHS = "image_thumb_url_prefix";
    String NODE_PROPERTY_LABEL = "label";
    String NODE_PROPERTY_ETAG = "etag";
    String NODE_PROPERTY_WORKSPACE_ID = "workspace_id";
    String NODE_PROPERTY_WORKSPACE_UUID = "workspace_id";
    String NODE_PROPERTY_WORKSPACE_SLUG = "workspace_slug";

    String NODE_PROPERTY_DESCRIPTION = "description";

    String MESSAGE_PROPERTY_TYPE = "type";
    String WORKSPACE_PROPERTY_OWNER = "owner";
    String WORKSPACE_PROPERTY_ID = "id";
    String WORKSPACE_PROPERTY_ACCESS_TYPE = "access_type";
    String WORKSPACE_PROPERTY_CROSS_COPY = "allowCrossRepositoryCopy";
    String WORKSPACE_PROPERTY_META_SYNC = "meta_syncable_REPO_SYNCABLE";
    String WORKSPACE_PROPERTY_SLUG = "repositorySlug";
    String WORKSPACE_PROPERTY_ACL = "acl";
    String WORKSPACE_PROPERTY_REPO_TYPE = "repository_type";
    String WORKSPACE_DESCRIPTION = "description";
    String WORKSPACE_IS_PUBLIC = "is_public";


    String WORKSPACE_ACCESS_TYPE_SHARED = "ajxp_shared";
    String WORKSPACE_ACCESS_TYPE_CONF = "ajxp_conf";
    String WORKSPACE_ACCESS_TYPE_MYSQL = "mysql";
    String WORKSPACE_ACCESS_TYPE_IMAP = "imap";
    String WORKSPACE_ACCESS_TYPE_JSAPI = "jsapi";
    String WORKSPACE_ACCESS_TYPE_USER = "ajxp_user";
    String WORKSPACE_ACCESS_TYPE_HOME = "ajxp_home";
    String WORKSPACE_ACCESS_TYPE_HOMEPAGE = "homepage";
    String WORKSPACE_ACCESS_TYPE_ADMIN = "ajxp_admin";
    String WORKSPACE_ACCESS_TYPE_FS = "fs";
    String WORKSPACE_ACCESS_TYPE_GATEWAY = "gateway";
    String WORKSPACE_ACCESS_TYPE_SETTINGS = "settings";
    String WORKSPACE_ACCESS_TYPE_INBOX = "inbox";

    String NODE_DIFF_ADD = "add";
    String NODE_DIFF_UPDATE = "update";
    String NODE_DIFF_REMOVE = "remove";
    String NODE_PROPERTY_PATH = "path";
    String NODE_WORKSPACE = "workspace";

    String REMOTE_CONFIG_UPLOAD_SIZE = "UPLOAD_MAX_SIZE";
    String LOCAL_CONFIG_BUFFER_SIZE = "buffer_size";
    int LOCAL_CONFIG_BUFFER_SIZE_DEFAULT_VALUE = 2048;


    String COOKIES_USER = "user";
    String COOKIES_PASSWORD = "password";
    String WORKSPACE_ID = "workspace_id";
    String NODE_PATH = "path";
    String FILE_PATH = "file_path";
    String OFFLINE_NODE_HASH = "hash";
    String OFFLINE_NODE_SIZE = "size";
    String OFFLINE_NODE_ENCRYPTED = "encrypted";
    String BOOKMARKS_PATH = "path";
    String PROPERTIES_NAME = "name";
    String PROPERTIES_VALUE = "value";
    String ALIAS = "alias";
    String CERTIFICATE = "certificate";
    String SERVER = "server";
    String SESSION_ID = "session_id";
    String TASK_ID = "task_id";
    String FOLDER_NAME = "folder_name";
    String ADDRESS = "address";
    String NODE_DATA = "node";
    String SERVER_ID = "server_id";
    String LOGIN = "user";
    String DISPLAYED_NAME = "user_display_name";
    String LOGO = "logo";
    String SESSION_NAME = "session_name";
    String REMEMBER_PASSWORD = "remember_password";
    String CHANGE_LOCATION = "location";

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

    int CHANGE_INDEX_SEQ = 0;
    int CHANGE_INDEX_NODE_ID = 1;
    int CHANGE_INDEX_TYPE = 2;
    int CHANGE_INDEX_SOURCE = 3;
    int CHANGE_INDEX_TARGET = 4;
    int CHANGE_INDEX_NODE_BYTESIZE = 5;
    int CHANGE_INDEX_NODE_MD5 = 6;
    int CHANGE_INDEX_NODE_MTIME = 7;
    int CHANGE_INDEX_NODE_PATH = 8;
    int CHANGE_INDEX_NODE_WORKSPACE = 9;

}
