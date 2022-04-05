package com.pydio.cells.client;

import static com.pydio.cells.utils.FileNodeUtils.toFileNode;

import com.google.gson.Gson;
import com.pydio.cells.api.Client;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.Registry;
import com.pydio.cells.api.S3Client;
import com.pydio.cells.api.S3Names;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.callbacks.ChangeHandler;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.callbacks.ProgressListener;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.PageOptions;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.api.ui.WorkspaceNode;
import com.pydio.cells.client.model.DocumentRegistry;
import com.pydio.cells.client.model.TreeNodeInfo;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.JobsServiceApi;
import com.pydio.cells.openapi.api.SearchServiceApi;
import com.pydio.cells.openapi.api.ShareServiceApi;
import com.pydio.cells.openapi.api.TreeServiceApi;
import com.pydio.cells.openapi.api.UserMetaServiceApi;
import com.pydio.cells.openapi.model.IdmSearchUserMetaRequest;
import com.pydio.cells.openapi.model.IdmUpdateUserMetaRequest;
import com.pydio.cells.openapi.model.IdmUserMeta;
import com.pydio.cells.openapi.model.RestBulkMetaResponse;
import com.pydio.cells.openapi.model.RestCreateNodesRequest;
import com.pydio.cells.openapi.model.RestDeleteNodesRequest;
import com.pydio.cells.openapi.model.RestGetBulkMetaRequest;
import com.pydio.cells.openapi.model.RestHeadNodeResponse;
import com.pydio.cells.openapi.model.RestNodesCollection;
import com.pydio.cells.openapi.model.RestPagination;
import com.pydio.cells.openapi.model.RestPutShareLinkRequest;
import com.pydio.cells.openapi.model.RestRestoreNodesRequest;
import com.pydio.cells.openapi.model.RestSearchResults;
import com.pydio.cells.openapi.model.RestShareLink;
import com.pydio.cells.openapi.model.RestShareLinkAccessType;
import com.pydio.cells.openapi.model.RestUserJobRequest;
import com.pydio.cells.openapi.model.RestUserMetaCollection;
import com.pydio.cells.openapi.model.ServiceResourcePolicy;
import com.pydio.cells.openapi.model.ServiceResourcePolicyAction;
import com.pydio.cells.openapi.model.ServiceResourcePolicyPolicyEffect;
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.openapi.model.TreeNodeType;
import com.pydio.cells.openapi.model.TreeQuery;
import com.pydio.cells.openapi.model.TreeSearchRequest;
import com.pydio.cells.openapi.model.UpdateUserMetaRequestUserMetaOp;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.utils.FileNodeUtils;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

public class CellsClient implements Client, SdkNames {

    private final static String TAG = CellsClient.class.getSimpleName();

    private final CellsTransport transport;
    private final S3Client s3Client;

    public CellsClient(Transport transport, S3Client s3Client) {
        this.transport = (CellsTransport) transport;
        this.s3Client = s3Client;
    }

    @Override
    public Registry getDefaultRegistry() {
        return null;
    }

    @Override
    public Registry getUserRegistry() {
        return null;
    }

    @Override
    public void workspaceList(NodeHandler handler) throws SDKException {

        HttpURLConnection con = null;
        InputStream in = null;
        Registry registry;
        try {
            con = transport.openApiConnection("/frontend/state");
            con.setRequestMethod("GET");
            in = con.getInputStream();
            int responseCode = con.getResponseCode();

            if (responseCode != 200) {
                throw new IOException("could not get registry for " + transport.getId() + "(" + responseCode + "): " + con.getResponseMessage());
            }

            registry = new DocumentRegistry(in);

            if (!registry.isLoggedIn()) {
                // Double check if we are correctly connected
                throw new SDKException(ErrorCodes.no_token_available, "not logged in " + transport.getId() + ", you cannot list workspaces.");
            }

            for (WorkspaceNode node : registry.getWorkspaces()) {
                if (!Arrays.asList(defaultExcludedWorkspaces).contains(node.getAccessType())) {
                    handler.onNode(node);
                }
            }

        } catch (ParserConfigurationException | SAXException e) {
            throw SDKException.unexpectedContent(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conFailed(e);
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(con);
        }
    }

    @Override
    public PageOptions ls(String ws, String path, PageOptions options, NodeHandler handler) throws SDKException {

        RestGetBulkMetaRequest request = new RestGetBulkMetaRequest();
        request.addNodePathsItem(FileNodeUtils.toTreeNodePath(ws, "/".equals(path) ? "/*" : path + "/*"));
        request.setAllMetaProviders(true);
        if (options != null) {
            request.setLimit(options.getLimit());
            request.setOffset(options.getOffset());
        }

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        RestBulkMetaResponse response;

        PageOptions nextPageOptions = new PageOptions();

        try {
            response = api.bulkStatNodes(request);
            RestPagination pagination = response.getPagination();
            if (pagination != null) {
                nextPageOptions.setLimit(pagination.getLimit());
                if (pagination.getNextOffset() != null) {
                    nextPageOptions.setOffset(pagination.getNextOffset());
                } else {
                    nextPageOptions.setOffset(-1);
                }
                nextPageOptions.setTotal(pagination.getTotal());
                nextPageOptions.setCurrentPage(pagination.getCurrentPage());
                nextPageOptions.setTotalPages(pagination.getTotalPages());
            } else {
                List<TreeNode> nodes = response.getNodes();
                if (nodes != null) {
                    int size = nodes.size();
                    nextPageOptions.setLimit(size);
                    nextPageOptions.setTotal(size);
                    nextPageOptions.setCurrentPage(1);
                    nextPageOptions.setTotalPages(1);
                    nextPageOptions.setOffset(0);
                }
            }
        } catch (ApiException e) {
            String msg = "Could not list: " + e.getMessage();
            throw new SDKException(e.getCode(), msg, e);
        }

        List<TreeNode> nodes = response.getNodes();
        if (nodes != null) {
            for (TreeNode node : response.getNodes()) {
                FileNode fileNode;
                try {
                    fileNode = toFileNode(node);
                } catch (NullPointerException ignored) {
                    ignored.printStackTrace();
                    continue;
                }

                if (fileNode != null) {
                    String nodePath = ("/" + node.getPath()).replace("//", "/");
                    if (!nodePath.equals(FileNodeUtils.toTreeNodePath(ws, path)) && !fileNode.getName().startsWith(".")) {
                        handler.onNode(fileNode);
                    }
                }
            }
        }
        return nextPageOptions;
    }

    @Override
    public Message mkdir(String ws, String parent, String name) throws SDKException {
        TreeNode node = new TreeNode();
        node.setPath((ws + parent + "/" + name).replace("//", "/"));
        node.setType(TreeNodeType.COLLECTION);

        RestCreateNodesRequest request = new RestCreateNodesRequest();
        request.recursive(false);
        request.addNodesItem(node);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());

        RestNodesCollection response;
        try {
            response = api.createNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }

        Message msg = new Message();
        List<TreeNode> nodes = response.getChildren();
        node = nodes.get(0);
        FileNode fileNode = toFileNode(node);
        msg.added.add(fileNode);
        return msg;
    }

    @Override
    public FileNode nodeInfo(String ws, String path) throws SDKException {
        TreeNode node = internalStatNode(ws, path);
        if (node != null) {
            return toFileNode(node);
        } else {
            return null;
        }
    }

    @Override
    public void getPreviewData(FileNode node, int dim, OutputStream out) throws SDKException {
        String filename = getThumbFilename(node, dim);
        if (filename == null) {
            throw new SDKException(ErrorCodes.not_found, "No thumbnail is defined for this resource", new IOException());
        }
        // TODO this can vary from one DS to the next in Cells v3+
        download(S3Names.PYDIO_S3_THUMBSTORE_PREFIX, "/" + filename, out, null);
    }

    private String getThumbFilename(FileNode currNode, int dim) throws SDKException {
        String remoteThumbsJson = currNode.getProperty(SdkNames.NODE_PROPERTY_REMOTE_THUMBS);
        if (Str.empty(remoteThumbsJson)) {
            return null;
        }

        Gson gson = new Gson();
        Map<String, String> thumbs = gson.fromJson(remoteThumbsJson, Map.class);
        String thumbPath = null;
        // TODO improve: we rely on the fact that thumbs are ordered by growing size at this point.
        for (Map.Entry<String, String> entry : thumbs.entrySet()) {
            if (thumbPath == null) {
                thumbPath = entry.getValue();
            }
            int size = Integer.parseInt(entry.getKey());
            if (size > 0 && size >= dim) {
                return entry.getValue();
            }
        }
        return thumbPath;
    }

    @Override
    public FileNode getNodeMeta(String ws, String file) throws SDKException {
        RestGetBulkMetaRequest request = new RestGetBulkMetaRequest();
        request.addNodePathsItem(FileNodeUtils.toTreeNodePath(ws, file));
        request.setAllMetaProviders(true);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        RestBulkMetaResponse response;
        try {
            response = api.bulkStatNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }

        try {
            return toFileNode(response.getNodes().get(0));
        } catch (NullPointerException ignored) {
            // TODO finalise error handling
            ignored.printStackTrace();
            return null;
        }
    }

    @Override
    public Stats stats(String ws, String file, boolean withHash) throws SDKException {
        RestGetBulkMetaRequest request = new RestGetBulkMetaRequest();
        request.addNodePathsItem(FileNodeUtils.toTreeNodePath(ws, file));
        request.setAllMetaProviders(true);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        RestBulkMetaResponse response;
        try {
            response = api.bulkStatNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }

        Stats stats = null;
        if (response.getNodes() != null) {
            TreeNode node = response.getNodes().get(0);
            stats = new Stats();
            stats.setHash(node.getEtag());
            if (node.getSize() != null) {
                stats.setSize(Long.parseLong(node.getSize()));
            }
            if (node.getMtime() != null) {
                stats.setmTime(Long.parseLong(node.getMtime()));
            }
        }
        return stats;
    }

    @Override
    public void search(String ws, String dir, String searchedText, NodeHandler h) throws SDKException {
        TreeQuery query = new TreeQuery();
        query.setFileName(searchedText);

        String prefix = ws + dir;
        query.addPathPrefixItem(prefix);

        TreeSearchRequest request = new TreeSearchRequest();
        request.setSize(50);
        request.setQuery(query);

        SearchServiceApi api = new SearchServiceApi(authenticatedClient());
        RestSearchResults results;
        try {
            results = api.nodes(request);
        } catch (ApiException e) {
            throw new SDKException(e);
        }

        List<TreeNode> nodes = results.getResults();
        if (nodes != null) {
            for (TreeNode node : nodes) {
                FileNode fileNode;
                try {
                    fileNode = toFileNode(node);
                } catch (NullPointerException ignored) {
                    continue;
                }

                if (fileNode != null) {
                    h.onNode(fileNode);
                }
            }
        }
    }

    @Override
    public List<FileNode> search(String parentPath, String searchedText, int size) throws SDKException {
        try {
            TreeQuery query = new TreeQuery();
            query.setFileName(searchedText);
            query.addPathPrefixItem(parentPath);
            TreeSearchRequest request = new TreeSearchRequest();
            request.setSize(size);
            request.setQuery(query);
            SearchServiceApi api = new SearchServiceApi(authenticatedClient());
            RestSearchResults results = api.nodes(request);
            List<TreeNode> treeNodes = results.getResults();
            List<FileNode> fileNodes = new ArrayList<>();
            if (treeNodes == null) {
                return fileNodes;
            }
            for (TreeNode node : treeNodes) {
                FileNode fileNode = toFileNode(node);
                if (fileNode != null) {
                    fileNodes.add(fileNode);
                }
            }
            return fileNodes;
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public Message upload(InputStream source, long length, String mime, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException {
        URL presignedURL = s3Client.getUploadPreSignedURL(ws, path, name);
        ServerURL serverUrl;
        try {
            serverUrl = transport.getServer().newURL(presignedURL.getPath()).withQuery(presignedURL.getQuery());
        } catch (MalformedURLException e) { // This should never happen with a pre-signed.
            throw new SDKException(ErrorCodes.internal_error, "Invalid pre-signed path: ".concat(presignedURL.getPath()), e);
        }

        try {
            HttpURLConnection con = transport.withUserAgent(serverUrl.openConnection());
            con.setRequestMethod("PUT");
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/octet-stream");
            con.setFixedLengthStreamingMode(length);
            try (OutputStream out = con.getOutputStream()) {
                IoHelpers.pipeReadWithProgress(source, out, progressListener);
            }
            // TODO implement multi part upload
            Log.d(TAG, "PUT request done with status " + con.getResponseCode());
        } catch (IOException e) {
            throw SDKException.conWriteFailed(e);
        }
        return Message.create(Message.SUCCESS, "SUCCESS");
    }

    @Override
    public Message upload(File source, String mime, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException {
        return upload(source, mime, ws, path, name, progressListener);
    }

    @Deprecated
    @Override
    public String uploadURL(String ws, String folder, String name, boolean autoRename) throws SDKException {
        throw new RuntimeException("Unsupported method for cells client");
    }

    @Override
    public long download(String ws, String file, OutputStream target, ProgressListener progressListener)
            throws SDKException {

        InputStream in = null;
        try {
            URL preSignedURL = s3Client.getDownloadPreSignedURL(ws, file);
            ServerURL serverUrl;
            try {
                serverUrl = transport.getServer().newURL(preSignedURL.getPath()).withQuery(preSignedURL.getQuery());
            } catch (MalformedURLException e) { // This should never happen with a pre-signed.
                throw new SDKException(ErrorCodes.internal_error, "Unvalid presigned path: ".concat(preSignedURL.getPath()), e);
            }

            HttpURLConnection con = transport.withUserAgent(serverUrl.openConnection());
            con.connect();
            in = con.getInputStream();

            if (progressListener == null) {
                return IoHelpers.pipeRead(in, target);
            } else {
                return IoHelpers.pipeReadWithProgress(in, target, progressListener);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conReadFailed(e);
        } finally {
            IoHelpers.closeQuietly(in);
        }
    }

    @Override
    public long download(String ws, String file, File target, ProgressListener progressListener)
            throws SDKException {
        long totalRead = -1;
        SDKException dlException = null;

        try (OutputStream out = new FileOutputStream(target)) {
            totalRead = download(ws, file, out, progressListener);
        } catch (FileNotFoundException e) {
            dlException = SDKException.notFound(e);
        } catch (IOException e) {
            dlException = SDKException.conWriteFailed(e);
        } catch (SDKException e) {
            dlException = new SDKException(ErrorCodes.api_error, "Could not download file " + file + " from " + ws, e);
        } finally {
            if (dlException != null) {
                // Best effort to download non-complete
                try {
                    //noinspection ResultOfMethodCallIgnored
                    target.delete();
                } catch (Exception e) {
                    Log.w("Local", "Could not delete file at " + target + " after failed download");
                }
                throw dlException;
            }
        }
        return totalRead;
    }

    @Override
    public String downloadPath(String ws, String file) throws SDKException {
        return fromURL(s3Client.getDownloadPreSignedURL(ws, file));
    }

    @Override
    public Message copy(String ws, String[] files, String folder) throws SDKException {
        JSONArray nodes = new JSONArray();
        for (String file : files) {
            String path = "/" + ws + file;
            nodes.put(path);
        }

        JSONObject o = new JSONObject();
        o.put("nodes", nodes);
        o.put("target", "/" + ws + folder);
        o.put("targetParent", true);

        RestUserJobRequest request = new RestUserJobRequest();
        request.setJobName("copy");
        request.setJsonParameters(o.toString());

        JobsServiceApi api = new JobsServiceApi(authenticatedClient());
        try {
            api.userCreateJob("copy", request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
        return null;
    }

    @Override
    public Message move(String ws, String[] files, String dstFolder) throws SDKException {
        JSONArray nodes = new JSONArray();
        for (String file : files) {
            String path = "/" + ws + file;
            nodes.put(path);
        }

        JSONObject o = new JSONObject();
        o.put("nodes", nodes);
        o.put("target", "/" + ws + dstFolder);
        o.put("targetParent", true);

        RestUserJobRequest request = new RestUserJobRequest();
        request.setJobName("move");
        request.setJsonParameters(o.toString());

        JobsServiceApi api = new JobsServiceApi(authenticatedClient());
        try {
            api.userCreateJob("move", request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
        return null;
    }

    @Override
    public Message rename(String ws, String srcFile, String newName) throws SDKException {
        RestUserJobRequest request = new RestUserJobRequest();

        JSONArray nodes = new JSONArray();
        String path = FileNodeUtils.toTreeNodePath(ws, srcFile);
        nodes.put(path);

        String parent = new File(srcFile).getParentFile().getPath();
        String dstFile;
        if ("/".equals(parent)) {
            dstFile = parent + newName;
        } else {
            dstFile = parent + "/" + newName;
        }

        JSONObject o = new JSONObject();
        o.put("nodes", nodes);
        o.put("target", FileNodeUtils.toTreeNodePath(ws, dstFile));
        o.put("targetParent", false);

        request.setJobName("move");
        request.setJsonParameters(o.toString());

        JobsServiceApi api = new JobsServiceApi(authenticatedClient());
        try {
            api.userCreateJob("move", request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
        return null;
    }

    @Override
    public Message delete(String ws, String[] files) throws SDKException {
        List<TreeNode> nodes = new ArrayList<>();
        for (String file : files) {
            TreeNode node = new TreeNode();
            node.setPath(FileNodeUtils.toTreeNodePath(ws, file));
            nodes.add(node);
        }

        RestDeleteNodesRequest request = new RestDeleteNodesRequest();
        request.setNodes(nodes);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());

        try {
            api.deleteNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
        return null;
    }

    @Override
    public Message restore(String ws, FileNode[] files) throws SDKException {
        List<TreeNode> nodes = new ArrayList<>();
        for (FileNode file : files) {
            TreeNode node = new TreeNode().uuid(file.getId()).path(file.getPath());
            nodes.add(node);
        }

        RestRestoreNodesRequest request = new RestRestoreNodesRequest();
        request.setNodes(nodes);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());

        try {
            api.restoreNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
        return null;
    }

    @Override
    public Message emptyRecycleBin(String ws) throws SDKException {
        return delete(ws, new String[]{"/recycle_bin"});
    }

    @Override
    public String streamingAudioURL(String slug, String file) throws SDKException {
        return fromURL(s3Client.getStreamingPreSignedURL(slug, file, S3Names.S3_CONTENT_TYPE_MP3));
    }

    @Override
    public String streamingVideoURL(String slug, String file) throws SDKException {
        return fromURL(s3Client.getStreamingPreSignedURL(slug, file, S3Names.S3_CONTENT_TYPE_MP4));
    }

    @Override
    public void getBookmarks(NodeHandler h) throws SDKException {
        //FIXME
        return;

 /*       // TODO double check this. we might miss some info
        RestUserBookmarksRequest request = new RestUserBookmarksRequest();
        UserMetaServiceApi api = new UserMetaServiceApi(authenticatedClient());
        try {
            RestBulkMetaResponse response = api.userBookmarks(request);
            if (response.getNodes() == null) {
                return;
            }

            for (TreeNode node : response.getNodes()) {
                try {
                    FileNode fileNode = toFileNode(node);
                    if (fileNode != null) {
                        List<TreeWorkspaceRelativePath> sources = node.getAppearsIn();
                        if (sources != null) {
                            // FIXME we only retrieve the first "source" node.
                            //  When a node is declared 2 times we skip info about the second source.
                            //  To reproduce, typically favorite a cell that is inside a WS.
                            String path = sources.get(0).getPath();
                            if (Str.empty(path)) {
                                Log.i(TAG, "Got an empty path for: " + fileNode.getPath());
                                path = "/";
                            } else if (!path.startsWith("/")) {
                                path = "/" + path;
                            }
                            fileNode.setProperty(NODE_PROPERTY_PATH, path);
                            fileNode.setProperty(NODE_PROPERTY_FILENAME, FileNodeUtils.getNameFromPath(path));
                            h.onNode(fileNode);
                        }
                    }
                } catch (NullPointerException e) {
                    Log.e(TAG, "Could node create FileNode for " + node.getPath() + ", skipping");
                    e.printStackTrace();
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
 */
    }

    @Override
    public Message bookmark(String slug, String file, boolean isBookmarked) throws SDKException {
        if (isBookmarked) {
            return bookmark(slug, file);
        } else {
            return unbookmark(slug, file);
        }
    }

    @Override
    public Message bookmark(String ws, String file) throws SDKException {
        return bookmark(getNodeUuid(ws, file));
    }

    public Message bookmark(String UUID) throws SDKException {

        UserMetaServiceApi api = new UserMetaServiceApi(authenticatedClient());

        IdmUpdateUserMetaRequest request = new IdmUpdateUserMetaRequest();
        request.setOperation(UpdateUserMetaRequestUserMetaOp.PUT);

        List<IdmUserMeta> metas = new ArrayList<>();

        IdmUserMeta userMeta = new IdmUserMeta();
        userMeta.setNodeUuid(UUID);
        userMeta.setNamespace("bookmark");
        userMeta.setJsonValue("true");

        ServiceResourcePolicy ownerPolicy = newPolicy(UUID, ServiceResourcePolicyAction.OWNER);
        ServiceResourcePolicy readPolicy = newPolicy(UUID, ServiceResourcePolicyAction.READ);
        ServiceResourcePolicy writePolicy = newPolicy(UUID, ServiceResourcePolicyAction.WRITE);
        userMeta.addPoliciesItem(ownerPolicy);
        userMeta.addPoliciesItem(readPolicy);
        userMeta.addPoliciesItem(writePolicy);

        metas.add(userMeta);

        request.setMetaDatas(metas);

        try {
            api.updateUserMeta(request);
            return null;
            // TODO Message Api must be re-implemented...
//            IdmUpdateUserMetaResponse response =
//             return  response.;
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(ErrorCodes.api_error, "could not update bookmark user-meta: " + e.getMessage(), e);
        }

    }

    @Override
    public Message unbookmark(String ws, String nodeId) throws SDKException {

        UserMetaServiceApi api = new UserMetaServiceApi(authenticatedClient());

        IdmSearchUserMetaRequest searchRequest = new IdmSearchUserMetaRequest();
        searchRequest.setNamespace("bookmark");
        searchRequest.addNodeUuidsItem(nodeId);

        try {
            RestUserMetaCollection result = api.searchUserMeta(searchRequest);

            IdmUpdateUserMetaRequest request = new IdmUpdateUserMetaRequest();
            request.setOperation(UpdateUserMetaRequestUserMetaOp.DELETE);
            request.setMetaDatas(result.getMetadatas());

            api.updateUserMeta(request);
            // IdmUpdateUserMetaResponse response = api.updateUserMeta(request);
            return null;
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
    }

    @Override
    public String share(String workspace, String file, String ws_label, boolean isFolder, String ws_description,
                        String password, int expiration, int download, boolean canPreview, boolean canDownload)
            throws SDKException {

        String uuid = getNodeUuid(workspace, file);

        RestPutShareLinkRequest request = new RestPutShareLinkRequest();
        request.createPassword(password);
        request.setCreatePassword(password);
        request.setPasswordEnabled(Boolean.parseBoolean(password));
        RestShareLink sl = new RestShareLink();

        TreeNode n = new TreeNode();
        n.setUuid(uuid);

        List<RestShareLinkAccessType> permissions = new ArrayList<>();
        if (canPreview) {
            permissions.add(RestShareLinkAccessType.PREVIEW);
        }
        if (canDownload) {
            permissions.add(RestShareLinkAccessType.DOWNLOAD);
        }

        List<TreeNode> rootNodes = new ArrayList<>();
        rootNodes.add(n);
        sl.setPoliciesContextEditable(true);

        sl.setPermissions(permissions);
        sl.setRootNodes(rootNodes);
        sl.setPoliciesContextEditable(true);
        sl.setDescription(ws_description);
        sl.setLabel(ws_label);
        sl.setViewTemplateName("pydio_unique_strip");
        request.setShareLink(sl);

        ShareServiceApi api = new ShareServiceApi(authenticatedClient());

        try {
            RestShareLink link = api.putShareLink(request);
            return transport.getServer().url() + link.getLinkUrl();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public String share(String workspace, String file, String ws_label, String ws_description,
                        String password, boolean canPreview, boolean canDownload)
            throws SDKException {

        String uuid = getNodeUuid(workspace, file);

        RestPutShareLinkRequest request = new RestPutShareLinkRequest();
        request.createPassword(password);
        request.setCreatePassword(password);
        request.setPasswordEnabled(Boolean.parseBoolean(password));
        RestShareLink sl = new RestShareLink();

        TreeNode n = new TreeNode();
        n.setUuid(uuid);

        List<RestShareLinkAccessType> permissions = new ArrayList<>();
        if (canPreview) {
            permissions.add(RestShareLinkAccessType.PREVIEW);
        }
        if (canDownload) {
            permissions.add(RestShareLinkAccessType.DOWNLOAD);
        }

        List<TreeNode> rootNodes = new ArrayList<>();
        rootNodes.add(n);
        sl.setPoliciesContextEditable(true);

        sl.setPermissions(permissions);
        sl.setRootNodes(rootNodes);
        sl.setPoliciesContextEditable(true);
        sl.setDescription(ws_description);
        sl.setLabel(ws_label);
        sl.setViewTemplateName("pydio_unique_strip");
        request.setShareLink(sl);

        ShareServiceApi api = new ShareServiceApi(authenticatedClient());

        try {
            RestShareLink link = api.putShareLink(request);
            return transport.getServer().url() + link.getLinkUrl();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public void unshare(String workspace, String file) throws SDKException {
        ShareServiceApi api = new ShareServiceApi(authenticatedClient());
        try {
            api.deleteShareLink(getNodeUuid(workspace, file));
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public String getShareAddress(String ws, String shareID) throws SDKException {
        ShareServiceApi api = new ShareServiceApi(authenticatedClient());
        try {
            RestShareLink link = api.getShareLink(shareID);
            return transport.getServer().url() + link.getLinkUrl();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public boolean isLegacy() {
        return false;
    }

    public static TreeNodeInfo toTreeNodeinfo(TreeNode node) {
        boolean isLeaf = node.getType() == TreeNodeType.LEAF;
        long size = Long.parseLong(node.getSize());
        long lastEdit = Long.parseLong(node.getMtime());
        return new TreeNodeInfo(node.getEtag(), node.getPath(), isLeaf, size, lastEdit);
    }

    public TreeNodeInfo statNode(String fullPath) throws SDKException {
        TreeNode node = internalStatNode(fullPath);
        return node != null ? toTreeNodeinfo(node) : null;
    }

    @Override
    public long changes(String ws, String folder, int seq, boolean flatten, ChangeHandler cp) throws SDKException {
        // RestChangeRequest request = new RestChangeRequest();
        // request.setFlatten(flatten);
        // request.setSeqID(String.valueOf(seq));
        // request.setFilter("/" + ws + folder);

        // this.getJWT();
        // ApiClient client = getApiClient();
        // client.addDefaultHeader("Authorization", "Bearer " + this.bearerValue);
        // ChangeServiceApi api = new ChangeServiceApi(client);
        // RestChangeCollection response;

        // try {
        // response = api.getChanges(String.valueOf(seq), request);
        // } catch (ApiException e) {
        // throw new SDKException(e);
        // }

        // for (TreeSyncChange c : response.getChanges()) {
        // Change change = new Change();
        // change.setSeq(Long.parseLong(c.getSeq()));
        // change.setNodeId(c.getNodeId());
        // change.setType(c.getType().toString());
        // change.setSource(c.getSource());
        // change.setTarget(c.getTarget());

        // ChangeNode node = new ChangeNode();
        // change.setNode(node);

        // node.setSize(Long.parseLong(c.getNode().getBytesize()));
        // node.setMd5(c.getNode().getMd5());
        // node.setPath(c.getNode().getNodePath().replaceFirst("/" + ws, ""));
        // node.setWorkspace(ws);
        // node.setmTime(Long.parseLong(c.getNode().getMtime()));

        // cp.onChange(change);
        // }
        // return Long.parseLong(response.getLastSeqId());
        throw new RuntimeException("This must be reimplemented after API update");
    }


    /**
     * Same as statNode() but rather return null than an {@link SDKException}
     * in case the node is not found
     */
    private TreeNodeInfo statOptionalNode(String fullPath) throws SDKException {
        TreeNode node = null;
        try {
            node = internalStatNode(fullPath);
        } catch (SDKException e) {
            if (e.getCode() != 404) {
                throw e;
            }
        }
        return node != null ? toTreeNodeinfo(node) : null;
    }

    private TreeNode internalStatNode(String ws, String path) throws SDKException {
        return internalStatNode(FileNodeUtils.toTreeNodePath(ws, path));
    }

    private TreeNode internalStatNode(String fullPath) throws SDKException {

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        try {
            return api.headNode(fullPath).getNode();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
        // return toFileNode(response.getNode());
    }

    /**
     * List children of the node at {@code fullPath}. Note that it does nothing if
     * no node is found at {@code fullPath}.
     */
    public void listChildren(String fullPath, TreeNodeHandler handler) throws SDKException {

        RestGetBulkMetaRequest request = new RestGetBulkMetaRequest();
        request.addNodePathsItem(fullPath + "/*");
        request.setAllMetaProviders(true);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        RestBulkMetaResponse response = null;
        try {
            response = api.bulkStatNodes(request);
        } catch (ApiException e) {
            if (e.getCode() != 404) {
                throw new SDKException(e);
            }
        }

        if (response != null && response.getNodes() != null) {
            Iterator<TreeNode> nodes = response.getNodes().iterator();
            while (nodes.hasNext()) {
                handler.onNode(nodes.next());
            }
        }
    }

    public Message mkfile(String ws, String name, String folder) throws SDKException {

        TreeNode node = new TreeNode();
        node.setPath("/" + ws + folder + "/" + name);
        node.setType(TreeNodeType.LEAF);

        RestCreateNodesRequest request = new RestCreateNodesRequest();
        request.recursive(false);
        request.addNodesItem(node);

        TreeServiceApi api = new TreeServiceApi(authenticatedClient());

        RestNodesCollection response;
        try {
            response = api.createNodes(request);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }

        Message msg = new Message();
        msg.added = new ArrayList<>();

        List<TreeNode> nodes = response.getChildren();
        node = nodes.get(0);

        FileNode fileNode = toFileNode(node);
        msg.added.add(fileNode);
        return msg;
    }

    private ServiceResourcePolicy newPolicy(String nodeId, ServiceResourcePolicyAction action) {
        ServiceResourcePolicy policy = new ServiceResourcePolicy();
        policy.setSubject("user:" + transport.getUsername());
        policy.setResource(nodeId);
        policy.setEffect(ServiceResourcePolicyPolicyEffect.ALLOW);
        policy.setAction(action);
        return policy;
    }

    public CellsClient get(Transport transport) {
        return new CellsClient(transport, s3Client);
    }

    /* Transfer methods that use S3 */

    @Deprecated
    private String fromURL(URL url) {
        return url.toString().replace(" ", "%20");
    }

    private Message upload(File f, String mime, String ws, String path, String name, ProgressListener tpl) throws SDKException {
        try (InputStream in = new FileInputStream(f)) {
            return upload(in, f.length(), mime, ws, path, name, true, tpl);
        } catch (FileNotFoundException e) {
            throw SDKException.notFound(e);
        } catch (IOException e) {
            String msg = "Could not upload to ".concat(ws).concat(path).concat("/").concat(name);
            throw new SDKException(ErrorCodes.con_write_failed, msg, e);
        }
    }

    private String getNodeUuid(String ws, String file) throws SDKException {
        TreeServiceApi api = new TreeServiceApi(authenticatedClient());
        try {
            RestHeadNodeResponse response = api.headNode(FileNodeUtils.toTreeNodePath(ws, file));
            TreeNode node = response.getNode();
            return node.getUuid();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    private ApiClient authenticatedClient() throws SDKException {
        return transport.authenticatedClient();
    }

    /**
     * This is necessary until min version is 24: we cannot use the consumer pattern:
     * public void listChildren(String fullPath, Consumer&lt;TreeNode&gt; consumer) throws SDKException {
     * ... consumer.onNode(nodes.next());
     */
    public interface TreeNodeHandler {
        void onNode(TreeNode node);
    }
}
