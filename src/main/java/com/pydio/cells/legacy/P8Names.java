package com.pydio.cells.legacy;

public interface P8Names {

    /* P8 Specific request headers */

    String HEADER_SET_COOKIE = "Set-Cookie";
    String AJXP_SESSION_COOKIE_NAME = "AjaXplorer";

    /* Request Properties */

    String REQ_PROP_COOKIE = "cookie";
    String REQ_PROP_USER_AGENT = "user-agent";
    String REQ_PROP_CONTENT_TYPE = "content-type";
    String REQ_PROP_CONTENT_LENGTH = "content-length";
    String REQ_PROP_TOKEN = "secure_token";

    /* Supported content types */

    String CONTENT_TYPE_OCTET_STREAM = "application/octet-stream";
    String CONTENT_TYPE_URL_ENCODED = "application/x-www-form-urlencoded; charset=utf-8";

    String UPLOAD_MAX_SIZE = "UPLOAD_MAX_SIZE";

    /* Supported Parameters */

    String XML_MESSAGE = "message";
    String COOKIE_KEY = "ajxp_sessid";

    String ajxpBookmarked = "ajxp_bookmarked";
    String xPathUserRepositories = "user/repositories";

    /* Well known XML Tag names to handle the response */

    String TAG_LOGIN_RESULT = "logging_result";

    String subAction = "sub_action";
    String action = "action";
    String bmAction = "bm_action";
    String bmPath = "bm_path";
    String merged = "merged";
    String shareElementType = "element_type";
    String captchaCode = "captcha_code";
    String dirname = "dirname";
    String urlencodedFilename = "urlencoded_filename";
    String options = "options";
    String dir = "dir";
    String file = "file";
    String field = "field";
    String autoRename = "auto_rename";
    String appendToUrlencodedPart = "appendto_urlencoded_part";
    String filenameNew = "filename_new";
    String dest = "dest";
    String forceCopyDelete = "force_copy_delete";
    String xhrUploader = "xhr_uploader";
    String xPath = "xPath";
    String tmpRepositoryId = "tmp_repository_id";
    String secureToken = "secure_token";
    String getThumb = "get_thumb";
    String shareGuestUserPassword = "guest_user_pass";
    String expiration = "expiration";
    String shareDownload = "download_limit";
    String workspaceLabel = "repo_label";
    String workspaceDescription = "repo_description";
    String createGuestUser = "create_guest_user";
    String miniSiteLayout = "minisite_layout";
    String simpleRightRead = "simple_right_read";
    String simpleRightDownload = "simple_right_download";
    String query = "query";
    String binaryId = "binary_id";
    String userId = "userid";
    String seed = "seed";
    String loginSeed = "login_seed";
    String password = "password";
    String getAction = "get_action";
    String seqId = "seq_id";
    String flatten = "flatten";
    String stream = "stream";
    String filter = "filter";
    String richPreview = "rich_preview";

    /* Action Names */

    String ls = "ls";
    String logout = "logout";
    String upload = "upload";
    String download = "download";
    String getCaptcha = "get_captcha";
    String restore = "restore";
    String mkdir = "mkdir";
    String rename = "rename";
    String copy = "copy";
    String move = "move";
    String delete = "delete";
    String createMinisite = "create_minisite";
    String share = "share";
    String search = "search";
    String multisearch = "multisearch";
    String searchByKeyword = "search_by_keyword";
    String getBookmarks = "get_bookmarks";
    String addBookmark = "add_bookmark";
    String deleteBookmark = "delete_bookmark";
    String unshare = "unshare";
    String GET_BOOT_CONF = "get_boot_conf";
    String getSeed = "get_seed";
    String login = "login";
    String getXmlRegistry = "get_xml_registry";
    String ajxpConfPrefix = "ajxp_conf/";
    String previewDataProxy = "preview_data_proxy";
    String imagickDataProxy = "imagick_data_proxy";
    String stats = "stat";
    String changes = "changes";
    String loadSharedElementData = "load_shared_element_data";
    String getBinaryParam = "get_binary_param";
    String readVideoData = "read_video_data";
    String audioProxy = "audio_proxy";
    String emptyRecycle = "empty_recycle";
}
