package com.pydio.sdk.core;

import com.google.gson.Gson;
import com.pydio.sdk.api.Client;
import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.nodes.FileNode;
import com.pydio.sdk.api.Message;
import com.pydio.sdk.api.PageOptions;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.api.Stats;
import com.pydio.sdk.api.nodes.WorkspaceNode;
import com.pydio.sdk.api.callbacks.ChangeHandler;
import com.pydio.sdk.api.callbacks.NodeHandler;
import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.callbacks.TransferProgressListener;
import com.pydio.sdk.core.auth.Token;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.model.TreeNodeInfo;
import com.pydio.sdk.core.model.parser.RegistrySaxHandler;
import com.pydio.sdk.core.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.sdk.core.model.parser.WorkspaceNodeSaxHandler;
import com.pydio.sdk.core.utils.FileNodeUtils;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.io;
import com.pydio.sdk.generated.cells.ApiClient;
import com.pydio.sdk.generated.cells.ApiException;
import com.pydio.sdk.generated.cells.api.FrontendServiceApi;
import com.pydio.sdk.generated.cells.api.JobsServiceApi;
import com.pydio.sdk.generated.cells.api.SearchServiceApi;
import com.pydio.sdk.generated.cells.api.ShareServiceApi;
import com.pydio.sdk.generated.cells.api.TreeServiceApi;
import com.pydio.sdk.generated.cells.api.UserMetaServiceApi;
import com.pydio.sdk.generated.cells.model.IdmSearchUserMetaRequest;
import com.pydio.sdk.generated.cells.model.IdmUpdateUserMetaRequest;
import com.pydio.sdk.generated.cells.model.IdmUserMeta;
import com.pydio.sdk.generated.cells.model.RestBulkMetaResponse;
import com.pydio.sdk.generated.cells.model.RestCreateNodesRequest;
import com.pydio.sdk.generated.cells.model.RestDeleteNodesRequest;
import com.pydio.sdk.generated.cells.model.RestFrontSessionRequest;
import com.pydio.sdk.generated.cells.model.RestGetBulkMetaRequest;
import com.pydio.sdk.generated.cells.model.RestNodesCollection;
import com.pydio.sdk.generated.cells.model.RestPagination;
import com.pydio.sdk.generated.cells.model.RestPutShareLinkRequest;
import com.pydio.sdk.generated.cells.model.RestRestoreNodesRequest;
import com.pydio.sdk.generated.cells.model.RestSearchResults;
import com.pydio.sdk.generated.cells.model.RestShareLink;
import com.pydio.sdk.generated.cells.model.RestShareLinkAccessType;
import com.pydio.sdk.generated.cells.model.RestUserBookmarksRequest;
import com.pydio.sdk.generated.cells.model.RestUserJobRequest;
import com.pydio.sdk.generated.cells.model.RestUserMetaCollection;
import com.pydio.sdk.generated.cells.model.ServiceResourcePolicy;
import com.pydio.sdk.generated.cells.model.ServiceResourcePolicyAction;
import com.pydio.sdk.generated.cells.model.ServiceResourcePolicyPolicyEffect;
import com.pydio.sdk.generated.cells.model.TreeNode;
import com.pydio.sdk.generated.cells.model.TreeNodeType;
import com.pydio.sdk.generated.cells.model.TreeQuery;
import com.pydio.sdk.generated.cells.model.TreeSearchRequest;
import com.pydio.sdk.generated.cells.model.TreeWorkspaceRelativePath;
import com.pydio.sdk.generated.cells.model.UpdateUserMetaRequestUserMetaOp;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class CellsClient implements Client, SdkNames {

    public String URL;
    protected String bearerValue;

    private Credentials credentials;
    private Boolean skipOAuth = false;
    private String userAgent;

    private final ServerNode serverNode;
    private final String apiURL;

    public CellsClient(ServerNode node) {
        this.serverNode = node;
        this.URL = node.url();
        String url = node.apiURL();
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            // ENDPOINT_REST_API property in server boot conf
            url = this.URL + url;
        }
        this.apiURL = url;
    }

    public static TreeNodeInfo toTreeNodeinfo(TreeNode node) {
        boolean isLeaf = node.getType() == TreeNodeType.LEAF;
        long size = Long.parseLong(node.getSize());
        long lastEdit = Long.parseLong(node.getMtime());
        return new TreeNodeInfo(node.getEtag(), node.getPath(), isLeaf, size, lastEdit);
    }

    @Override
    public ServerNode getServerNode() {
        return serverNode;
    }

    @Override
    public void setCredentials(Credentials c) {
        this.credentials = c;
    }

    @Override
    public void setSkipOAuthFlag(boolean skipOAuth) {
        this.skipOAuth = skipOAuth;
    }

    @Override
    public String getUser() {
        return this.credentials.getLogin();
    }

    @Override
    public InputStream getUserData(String binary) {
        return null;
    }

    @Override
    public void login() throws SDKException {
        this.getJWT();
    }

    @Override
    public void logout() throws SDKException {
        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setLogout(true);
        try {
            new FrontendServiceApi(getApiClient()).frontSession(request);
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public JSONObject userInfo() throws SDKException {
        // FIXME really ?
        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setLogout(true);
        return null;
    }

    @Override
    public X509Certificate[] remoteCertificateChain() {
        return new X509Certificate[0];
    }

    @Override
    public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {
        String fullURI = this.URL + "/a/frontend/state/?ws=login";
        URL url = null;
        try {
            url = new URL(fullURI);
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        HttpURLConnection con = null;
        InputStream in = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            in = con.getInputStream();
            try {
                SAXParser parser = factory.newSAXParser();
                parser.parse(in, new ServerGeneralRegistrySaxHandler(itemHandler));
            } catch (Exception e) {
                Log.w("Connection", "could not parse registry request response");
                throw SDKException.unexpectedContent(e);
            }
        } catch (IOException e) {
            Log.w("Connection", "connction error while retrieving registry");
            throw SDKException.conFailed(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) {
                }
            }

            if (con != null) {
                con.disconnect();
            }
        }
    }

    @Override
    public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {

        String fullURI = this.URL + "/a/frontend/state/?ws=" + ws;
        URL url;
        try {
            url = new URL(fullURI);
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        this.getJWT();

        HttpURLConnection con;
        InputStream in;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "Bearer " + this.bearerValue);
            in = con.getInputStream();

        } catch (IOException e) {
            throw SDKException.conFailed(e);
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(in, new RegistrySaxHandler(itemHandler));
        } catch (Exception e) {
            e.printStackTrace();
            throw SDKException.unexpectedContent(e);
        } finally {
            io.close(in);
        }
    }

    @Override
    public void workspaceList(NodeHandler handler) throws SDKException {
        URL url;
        try {
            if (this.URL.endsWith("/")) {
                url = new URL(this.URL + "a/frontend/state");
            } else {
                url = new URL(this.URL + "/a/frontend/state");
            }
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        this.getJWT();
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            throw SDKException.conFailed(e);
        }

        con.setRequestProperty("Authorization", "Bearer " + this.bearerValue);
        InputStream in;
        try {
            in = con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conFailed(e);
        }
        String[] excluded = {WORKSPACE_ACCESS_TYPE_CONF, WORKSPACE_ACCESS_TYPE_SHARED,
                WORKSPACE_ACCESS_TYPE_MYSQL, WORKSPACE_ACCESS_TYPE_IMAP, WORKSPACE_ACCESS_TYPE_JSAPI,
                WORKSPACE_ACCESS_TYPE_USER, WORKSPACE_ACCESS_TYPE_HOME,
                WORKSPACE_ACCESS_TYPE_HOMEPAGE, WORKSPACE_ACCESS_TYPE_SETTINGS,
                WORKSPACE_ACCESS_TYPE_ADMIN, WORKSPACE_ACCESS_TYPE_INBOX,};

        try {
            NodeHandler nh = (n) -> {
                if (!Arrays.asList(excluded).contains(((WorkspaceNode) n).getAccessType())) {
                    handler.onNode(n);
                }
            };
            DefaultHandler saxHandler = new WorkspaceNodeSaxHandler(nh, 0, -1);
            SAXParserFactory.newInstance().newSAXParser().parse(in, saxHandler);
        } catch (Exception e) {
            throw SDKException.unexpectedContent(e);
        }
    }

    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        String fullURI = this.URL + "/a/frontend/state/?ws=login";
        URL url = null;
        try {
            url = new URL(fullURI);
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        HttpURLConnection con = null;
        InputStream in = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            Log.w("Connection", "connction error while retrieving registry");
            throw SDKException.conFailed(e);
        }
    }

    @Override
    public InputStream getWorkspaceRegistry(String ws) throws SDKException {
        String fullURI = this.URL + "/a/frontend/state/?ws=" + ws;
        URL url;
        try {
            url = new URL(fullURI);
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        this.getJWT();

        HttpURLConnection con;
        InputStream in;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            if (!"".equals(this.bearerValue)) {
                con.setRequestProperty("Authorization", "Bearer " + this.bearerValue);
            }
            return con.getInputStream();

        } catch (IOException e) {
            throw SDKException.conFailed(e);
        }
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        URL url;
        try {
            url = new URL(this.URL + "/a/frontend/state");
        } catch (MalformedURLException e) {
            throw SDKException.malFormURI(e);
        }

        this.getJWT();
        HttpURLConnection con;
        try {
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        } catch (IOException e) {
            throw SDKException.conFailed(e);
        }

        con.setRequestProperty("Authorization", "Bearer " + this.bearerValue);
        try {
            return con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conFailed(e);
        }
    }

    @Override
    public FileNode nodeInfo(String ws, String path) throws SDKException {
        TreeNode node = internalStatNode(ws, path);
        if (node != null) {
            return FileNodeUtils.toFileNode(node);
        } else {
            return null;
        }
    }

    public TreeNodeInfo statNode(String fullPath) throws SDKException {
        TreeNode node = internalStatNode(fullPath);
        return node != null ? toTreeNodeinfo(node) : null;
    }

    /**
     * Same as statNode() but rather return null than an {@link SDKException}
     * in case the node is not found
     */
    public TreeNodeInfo statOptionalNode(String fullPath) throws SDKException {
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
                if (pagination.getCurrentOffset() == null) {
                    nextPageOptions.setOffset(0);
                } else {
                    nextPageOptions.setOffset(pagination.getCurrentOffset());
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
            throw new SDKException(e);
        }

        List<TreeNode> nodes = response.getNodes();
        if (nodes != null) {
            for (TreeNode node : response.getNodes()) {
                FileNode fileNode;
                try {
                    fileNode = FileNodeUtils.toFileNode(node);
                } catch (NullPointerException ignored) {
                    continue;
                }

                if (fileNode != null) {
                    String nodePath = ("/" + node.getPath()).replace("//", "/");
                    if (!nodePath.equals(FileNodeUtils.toTreeNodePath(ws, path)) && !fileNode.getLabel().startsWith(".")) {
                        handler.onNode(fileNode);
                    }
                }
            }
        }
        return nextPageOptions;
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
                    fileNode = FileNodeUtils.toFileNode(node);
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
    public void getBookmarks(NodeHandler h) throws SDKException {

        RestUserBookmarksRequest request = new RestUserBookmarksRequest();
        UserMetaServiceApi api = new UserMetaServiceApi(authenticatedClient());
        try {
            RestBulkMetaResponse response = api.userBookmarks(request);
            if (response.getNodes() != null) {
                for (TreeNode node : response.getNodes()) {
                    try {
                        FileNode fileNode = FileNodeUtils.toFileNode(node);
                        if (fileNode != null) {
                            List<TreeWorkspaceRelativePath> sources = node.getAppearsIn();
                            if (sources != null) {
                                // Not very clean: the path to the source of the bookmark has no leading slash
                                // We can tweak here because that's the only location where we use this object.
                                // Also bookmarks can only refer to **one** source
                                String path = "/" + sources.get(0).getPath();
                                fileNode.setProperty(NODE_PROPERTY_PATH, path);
                                fileNode.setProperty(NODE_PROPERTY_FILENAME, FileNodeUtils.getNameFromPath(path));
                                h.onNode(fileNode);
                            }
                        }
                    } catch (NullPointerException e) {
                        Log.e("GET_BOOKMARKS", "Unexpected NPE");
                        e.printStackTrace();
                    }
                }
            }
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
        }
    }

    @Override
    public Message upload(InputStream source, long length, String ws, String path, String name, boolean autoRename,
                          TransferProgressListener progressListener) throws SDKException {
        return null;
    }

    @Override
    public Message upload(File source, String ws, String path, String name, boolean autoRename,
                          TransferProgressListener progressListener) throws SDKException {
        return null;
    }

    @Override
    public String uploadURL(String ws, String folder, String name, boolean autoRename) throws SDKException {
        return null;
    }

    @Override
    public long download(String ws, String file, OutputStream target, TransferProgressListener progressListener)
            throws SDKException {
        return 0;
    }

    @Override
    public long download(String ws, String file, File target, TransferProgressListener progressListener)
            throws SDKException {
        OutputStream out;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw SDKException.notFound(e);
        }

        long downloaded = download(ws, file, out, progressListener);
        io.close(out);
        return downloaded;
    }

    @Override
    public String downloadURL(String ws, String file) throws SDKException {
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
    public Message restore(String ws, String[] files) throws SDKException {
        List<TreeNode> nodes = new ArrayList<>();
        for (String file : files) {
            TreeNode node = new TreeNode();
            node.setPath(FileNodeUtils.toTreeNodePath(ws, file));
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
    public Message bookmark(String ws, String nodeId) throws SDKException {

        UserMetaServiceApi api = new UserMetaServiceApi(authenticatedClient());

        IdmUpdateUserMetaRequest request = new IdmUpdateUserMetaRequest();
        request.setOperation(UpdateUserMetaRequestUserMetaOp.PUT);
        List<IdmUserMeta> metas = new ArrayList<>();
        IdmUserMeta item = new IdmUserMeta();
        item.setNodeUuid(nodeId);
        item.setNamespace("bookmark");
        item.setJsonValue("true");

        ServiceResourcePolicy policy = new ServiceResourcePolicy();
        policy.setAction(ServiceResourcePolicyAction.OWNER);
        policy.setEffect(ServiceResourcePolicyPolicyEffect.ALLOW);
        policy.setResource(nodeId);
        policy.setSubject("user:" + getUser());
        item.addPoliciesItem(policy);
        metas.add(item);

        policy = new ServiceResourcePolicy();
        policy.setAction(ServiceResourcePolicyAction.READ);
        policy.setEffect(ServiceResourcePolicyPolicyEffect.ALLOW);
        policy.setResource(nodeId);
        policy.setSubject("user:" + getUser());
        item.addPoliciesItem(policy);
        metas.add(item);

        policy = new ServiceResourcePolicy();
        policy.setAction(ServiceResourcePolicyAction.WRITE);
        policy.setEffect(ServiceResourcePolicyPolicyEffect.ALLOW);
        policy.setResource(nodeId);
        policy.setSubject("user:" + getUser());
        item.addPoliciesItem(policy);
        metas.add(item);
        request.setMetaDatas(metas);

        try {
            // IdmUpdateUserMetaResponse response =
            api.updateUserMeta(request);
            return null;
        } catch (ApiException e) {
            e.printStackTrace();
            throw new SDKException(e);
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
        /*List<TreeNode> nodes = response.getChildren();
        node = nodes.get(0);
        FileNode fileNode = toFileNode(node);
        msg.added.add(fileNode); */
        return msg;
    }

    // @Override
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

        FileNode fileNode = FileNodeUtils.toFileNode(node);
        msg.added.add(fileNode);
        return msg;
    }

    @Override
    public InputStream previewData(String ws, String file, int dim) throws SDKException {
        return null;
    }

    @Override
    public String streamingAudioURL(String ws, String file) {
        return null;
    }

    @Override
    public String streamingVideoURL(String ws, String file) {
        return null;
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
            stats.setSize(Long.parseLong(node.getSize()));
            stats.setmTime(Long.parseLong(node.getMtime()));
        }
        return stats;
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

    @Override
    public String share(String ws, String uuid, String ws_label, boolean isFolder, String ws_description,
                        String password, int expiration, int download, boolean canPreview, boolean canDownload)
            throws SDKException {

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
            return link.getLinkUrl();
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public void unshare(String ws, String file) throws SDKException {
        ShareServiceApi api = new ShareServiceApi(authenticatedClient());
        try {
            api.deleteShareLink(file);
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public JSONObject shareInfo(String ws, String shareID) throws SDKException {
        ShareServiceApi api = new ShareServiceApi(authenticatedClient());
        try {
            RestShareLink link = api.getShareLink(shareID);
            Gson gs = new Gson();
            String jsonString = gs.toJson(link);
            return new JSONObject(jsonString);
        } catch (ApiException e) {
            throw new SDKException(e);
        } catch (ParseException e) {
            throw SDKException.unexpectedContent(e);
        }
    }

    @Override
    public JSONObject authenticationInfo() {
        return null;
    }

    @Override
    public Message emptyRecycleBin(String ws) throws SDKException {
        return delete(ws, new String[]{"/recycle_bin"});
    }

    @Override
    public InputStream getCaptcha() {
        return null;
    }

    public interface Factory {
    }

    public CellsClient get(ServerNode node) {
        return new CellsClient(node);
    }

    // Local Helpers

    protected String getUserAgent() {
        if (userAgent != null) {
            return userAgent;
        }

        userAgent = String.format(Locale.US, "%s-%s/%d", ApplicationData.name, ApplicationData.version, ApplicationData.versionCode);
        if (!ApplicationData.platform.equals("")) {
            userAgent = ApplicationData.platform + "/" + userAgent;
        }

        if (!ApplicationData.packageID.equals("")) {
            userAgent = userAgent + "/" + ApplicationData.packageID;
        }
        return userAgent;
    }

    private ApiClient getApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(apiURL);
        apiClient.setUserAgent(getUserAgent());

        if (this.serverNode.isSSLUnverified()) {
            SSLContext context = this.serverNode.getSslContext();
            OkHttpClient c = apiClient.getHttpClient();
            c.setSslSocketFactory(context.getSocketFactory());
            c.setHostnameVerifier((s, sslSession) -> URL.contains(s));
        }
        return apiClient;
    }

    private ApiClient authenticatedClient() throws SDKException {

        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(apiURL);
        apiClient.setUserAgent(getUserAgent());

        if (this.serverNode.isSSLUnverified()) {
            SSLContext context = this.serverNode.getSslContext();
            OkHttpClient c = apiClient.getHttpClient();
            c.setSslSocketFactory(context.getSocketFactory());
            c.setHostnameVerifier((s, sslSession) -> URL.contains(s));
        }

        apiClient.addDefaultHeader("Authorization", "Bearer " + getToken());
        return apiClient;
    }


    protected String getToken() throws SDKException {
        // TODO use tokenCache
        Token token = TokenService.get(serverNode, credentials, skipOAuth);
        if (token != null) {
            return token.value;
        } else {
            // TODO throw an exception
            return "";
        }
    }

    protected void getJWT() throws SDKException {
        bearerValue = getToken();
    }

    private static SDKException fromApiException(ApiException e) {
        int code = ErrorCodes.fromHttpStatus(e.getCode());
        return new SDKException(code, e);
    }


    /**
     * This is necessary until min version is 24: we cannot use the consumer pattern:
     * public void listChildren(String fullPath, Consumer<TreeNode> consumer) throws SDKException {
     * ... consumer.onNode(nodes.next());
     */
    public interface TreeNodeHandler {
        void onNode(TreeNode node);
    }


}
