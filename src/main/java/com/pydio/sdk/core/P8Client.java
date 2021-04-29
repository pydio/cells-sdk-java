package com.pydio.sdk.core;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.generated.p8.Configuration;
import com.pydio.sdk.generated.p8.P8Request;
import com.pydio.sdk.generated.p8.P8RequestBuilder;
import com.pydio.sdk.generated.p8.P8Response;
import com.pydio.sdk.generated.p8.consts.Action;
import com.pydio.sdk.generated.p8.consts.Param;
import com.pydio.sdk.core.common.callback.ChangeHandler;
import com.pydio.sdk.core.common.callback.NodeHandler;
import com.pydio.sdk.core.common.callback.RegistryItemHandler;
import com.pydio.sdk.core.common.callback.TransferProgressListener;
import com.pydio.sdk.core.common.errors.Code;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.common.http.ContentBody;
import com.pydio.sdk.core.model.Change;
import com.pydio.sdk.core.model.ChangeNode;
import com.pydio.sdk.core.model.FileNode;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.api.Node;
import com.pydio.sdk.core.model.NodeDiff;
import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.model.Stats;
import com.pydio.sdk.core.model.WorkspaceNode;
import com.pydio.sdk.core.model.parser.RegistrySaxHandler;
import com.pydio.sdk.core.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.sdk.core.model.parser.TreeNodeSaxHandler;
import com.pydio.sdk.core.model.parser.WorkspaceNodeSaxHandler;
import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.core.server.Prop;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.PageOptions;
import com.pydio.sdk.core.utils.io;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.ProtocolException;
import java.rmi.UnknownHostException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class P8Client implements Client, SdkNames {

    private final static Map<String, String> secureTokens = new ConcurrentHashMap<>();
    private final static Map<String, CookieManager> cookieManagers = new ConcurrentHashMap<>();

    private final ServerNode serverNode;
    private final com.pydio.sdk.generated.p8.P8Client p8;
    private Credentials credentials;
    private int loginFailure;

    public P8Client(ServerNode node) {
        this.serverNode = node;
        loginFailure = 0;

        Configuration config = new Configuration();
        config.endpoint = serverNode.url();
        config.resolver = serverNode.getServerResolver();
        if (config.selfSigned = serverNode.isSSLUnverified()) {
            config.sslContext = serverNode.getSslContext();
            config.hostnameVerifier = serverNode.getHostnameVerifier();
        }
        p8 = new com.pydio.sdk.generated.p8.P8Client(config);
    }

    private P8Request refreshSecureToken(P8Request req) {
        try {
            JSONObject info = authenticationInfo();
            if (!info.has(Param.captchaCode)) {
                login();
                String secureToken = getSecureToken();
                return P8RequestBuilder.update(req).setSecureToken(secureToken).getRequest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void loadSecureToken() throws SDKException {
        String secureToken = getSecureToken();
        if (null == secureToken || "".equals(secureToken)) {
            login();
        }
    }

    private void saveSecureToken(String secureToken) {
        String id = this.credentials.getLogin() + "@" + this.serverNode.url();
        secureTokens.put(id, secureToken);
    }

    private String getSecureToken() {
        String id = this.credentials.getLogin() + "@" + this.serverNode.url();
        return secureTokens.get(id);
    }

    private CookieManager getCookieManager() {
        String id = this.credentials.getLogin() + "@" + this.serverNode.url();
        CookieManager cm = cookieManagers.get(id);
        if (cm == null) {
            cm = new CookieManager();
            cookieManagers.put(id, cm);
        }
        return cm;
    }

    @Override
    public ServerNode getServerNode() {
        return serverNode;
    }

    @Override
    public void setCredentials(Credentials c) {
        this.credentials = c;
        CookieManager cookieManager = getCookieManager();
        p8.setCookieManager(cookieManager);
    }

    @Override
    public void setSkipOAuthFlag(boolean skipOAuth) {

    }

    @Override
    public String getUser() {
        return this.credentials.getLogin();
    }

    @Override
    public InputStream getUserData(String binary) throws SDKException {
        String secureToken = getSecureToken();
        P8Request req = P8RequestBuilder.getUserData(credentials.getLogin(), binary).setSecureToken(secureToken).getRequest();
        try (P8Response rsp = p8.execute(req)) {
            final int code = rsp.code();
            if (code != Code.ok) {
                if (code == Code.authentication_required && credentials != null && loginFailure == 0) {
                    loginFailure++;
                    login();
                    return getUserData(binary);
                }
                throw new SDKException(code);
            }
            return rsp.getContent();
        }
    }

    @Override
    public void login() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.login(credentials);
        P8Request req = builder.getRequest();

        try (P8Response rsp = p8.execute(req)) {
            final int code = rsp.code();
            if (code != Code.ok) {
                rsp.close();
                throw new SDKException(code);
            }

            Document doc = rsp.toXMLDocument();
            if (doc != null) {
                if (doc.getElementsByTagName("logging_result").getLength() > 0) {
                    String result = doc.getElementsByTagName("logging_result").item(0).getAttributes().getNamedItem("value").getNodeValue();
                    if (result.equals("1")) {
                        String secureToken = doc.getElementsByTagName("logging_result").item(0).getAttributes().getNamedItem(Param.secureToken).getNodeValue();
                        this.saveSecureToken(secureToken);
                        loginFailure = 0;
                    } else {
                        loginFailure++;
                        if (result.equals("-4")) {
                            rsp.close();
                            throw new SDKException(Code.authentication_with_captcha_required);
                        }
                        rsp.close();
                        throw new SDKException(Code.authentication_required);
                    }
                } else {
                    rsp.close();
                    throw SDKException.unexpectedContent(new IOException(doc.toString()));
                }
            } else {
                rsp.close();
                throw new SDKException(Code.authentication_required);
            }
        }
    }

    @Override
    public void logout() {
        String secureToken = getSecureToken();
        P8Response response = p8.execute(P8RequestBuilder.logout().setSecureToken(secureToken).getRequest());
        response.close();
    }

    @Override
    public JSONObject userInfo() throws SDKException {
        return null;
    }

    @Override
    public X509Certificate[] remoteCertificateChain() {
        return new X509Certificate[0];
    }

    @Override
    public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
        try (P8Response rsp = p8.execute(builder.getRequest())) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            final int code = rsp.saxParse(new ServerGeneralRegistrySaxHandler(itemHandler));
            if (code != Code.ok) {
                throw new SDKException(code);
            }
        }
    }

    @Override
    public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            final int code = rsp.saxParse(new RegistrySaxHandler(itemHandler));
            if (code != Code.ok) {
                rsp.close();
                throw new SDKException(code);
            }
        }
    }

    @Override
    public void workspaceList(NodeHandler handler) throws SDKException {
        String[] excluded = {
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

        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceList().setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }

            final int code = rsp.saxParse(new WorkspaceNodeSaxHandler((n) -> {
                if (!Arrays.asList(excluded).contains(((WorkspaceNode) n).getAccessType())) {
                    handler.onNode(n);
                }
            }, 0, -1));

            if (code != Code.ok) {
                throw new SDKException(code);
            }
        }
    }

    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
        P8Response rsp = p8.execute(builder.getRequest());
        if (rsp.code() != Code.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public InputStream getWorkspaceRegistry(String ws) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(secureToken);
        P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required);
        if (rsp.code() != Code.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceList().setSecureToken(secureToken);
        P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required);
        if (rsp.code() != Code.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public FileNode nodeInfo(String ws, String path) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.nodeInfo(ws, path).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }

            final FileNode[] node = new FileNode[1];
            final int resultCode = rsp.saxParse(new TreeNodeSaxHandler((n) -> node[0] = (FileNode) n));
            if (resultCode != Code.ok) {
                throw new SDKException(resultCode);
            }
            node[0].setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
            return node[0];
        }
    }

    @Override
    public PageOptions ls(String ws, String folder, PageOptions options, NodeHandler handler) throws SDKException {
        PageOptions nextOptions = new PageOptions();

        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.ls(ws, folder).setSecureToken(secureToken);
        while (true) {
            try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
                int code = rsp.code();
                if (code != Code.ok) {
                    throw new SDKException(code);
                }

                TreeNodeSaxHandler treeHandler = new TreeNodeSaxHandler((n) -> {
                    n.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
                    handler.onNode(n);
                });
                final int resultCode = rsp.saxParse(treeHandler);
                if (resultCode != Code.ok) {
                    throw new SDKException(resultCode);
                }

                if (treeHandler.mPagination) {
                    if (treeHandler.mPaginationTotalPage != treeHandler.mPaginationCurrentPage) {
                        builder.setParam(Param.dir, folder + "%23" + (treeHandler.mPaginationCurrentPage + 1));
                    } else {
                        return nextOptions;
                    }
                } else {
                    return nextOptions;
                }
            }
        }
    }

    @Override
    public void search(String ws, String dir, String searchedText, NodeHandler h) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.search(ws, dir, searchedText).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            int code = rsp.code();
            if (code != Code.ok) {
                throw new SDKException(code);
            }

            final int resultCode = rsp.saxParse(new TreeNodeSaxHandler(node -> {
                node.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
                h.onNode(node);
            }));

            if (resultCode != Code.ok) {
                throw new SDKException(resultCode);
            }
        }
    }

    @Override
    public void bookmarks(NodeHandler handler) throws SDKException {
        String secureToken = getSecureToken();
        List<WorkspaceNode> workspaceNodes = new ArrayList<>(serverNode.workspaces.values());
        if (workspaceNodes.isEmpty()) {
            workspaceList((n) -> workspaceNodes.add((WorkspaceNode) n));
        }

        for (WorkspaceNode wn : workspaceNodes) {
            P8RequestBuilder builder = P8RequestBuilder.listBookmarked(wn.id(), "/").setSecureToken(secureToken);
            while (true) {
                try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
                    int code = rsp.code();
                    if (code != Code.ok) {
                        break;
                        //throw SDKException.fromP8Code(code);
                    }

                    TreeNodeSaxHandler treeHandler = new TreeNodeSaxHandler((n) -> {
                        n.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, wn.id());
                        handler.onNode(n);
                    });

                    final int resultCode = rsp.saxParse(treeHandler);
                    if (resultCode != Code.ok) {
                        //throw SDKException.fromP8Code(resultCode);
                        break;
                    }

                    if (treeHandler.mPagination) {
                        if (!(treeHandler.mPaginationTotalPage == treeHandler.mPaginationCurrentPage)) {
                            builder.setParam(Param.dir, "/" + "%23" + (treeHandler.mPaginationCurrentPage + 1));
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    @Override
    public Message upload(InputStream source, long length, String ws, String path, String name, boolean autoRename, TransferProgressListener progressListener) throws SDKException {
        stats(ws, path, false);

        long maxChunkSize = 2 * 1024 * 1204; // Default apache in most php init configs
        String maxSize = this.serverNode.getProperty(Prop.uploadMaxSize);
        if (maxSize != null && !"".equals(maxSize)) {
            try {
                maxChunkSize = Long.parseLong(maxSize);
            } catch (Exception ignored) {
            }
        }

        ContentBody cb = new ContentBody(source, name, length, maxChunkSize);
        if (progressListener != null) {
            cb.setListener(new ContentBody.ProgressListener() {
                @Override
                public void transferred(long num) throws IOException {
                    if (progressListener.onProgress(num)) {
                        throw new IOException("");
                    }
                }

                @Override
                public void partTransferred(int part, int total) throws IOException {
                    if (total == 0) total = 1;
                    if (progressListener.onProgress(part * 100 / total)) {
                        throw new IOException("");
                    }
                }
            });
        }

        P8RequestBuilder builder;
        try {
            String secureToken = getSecureToken();
            builder = P8RequestBuilder.upload(ws, path, name, autoRename, cb).setSecureToken(secureToken);
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.encoding(e);
        }

        P8Request req = builder.getRequest();
        P8Response rsp = p8.execute(req, this::refreshSecureToken, Code.authentication_required);
        try {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }

            while (rsp.code() == Code.ok && !cb.allChunksWritten()) {
                NodeDiff diff = NodeDiff.create(rsp.toXMLDocument());
                if (diff.updated != null && diff.updated.size() > 0) {
                    name = diff.updated.get(0).label();
                } else if (diff.added != null && diff.added.size() > 0) {
                    name = diff.added.get(0).label();
                } else {
                    //todo: stats "name" to get info
                }
                builder.setParam(Param.appendToUrlencodedPart, name);
                rsp = p8.execute(builder.getRequest());
            }

            if (rsp.code() != Code.ok) {
                return Message.create(Message.ERROR, rsp.toString());
            }

            NodeDiff diff;
            Document doc = rsp.toXMLDocument();
            if (doc != null) {
                diff = NodeDiff.create(doc);
                if (diff.added != null) {
                    Node node = diff.added.get(0);
                    String label = node.label();
                    if (!label.equals(cb.getFilename())) {
                        cb.setFilename(label);
                    }

                    Message msg = Message.create(Message.SUCCESS, "");
                    msg.added = diff.added;
                    msg.updated = diff.updated;
                    msg.deleted = diff.deleted;
                    return msg;
                }
            }


            FileNode info = nodeInfo(ws, path + "/" + name);

            Message msg = Message.create(Message.SUCCESS, "");
            if (msg.added == null) {
                msg.added = new ArrayList<>();
            }
            msg.added.add(info);
            return msg;
        } finally {
            rsp.close();
        }
    }

    @Override
    public Message upload(File source, String ws, String path, String name, boolean autoRename, TransferProgressListener progressListener) throws SDKException {
        Message msg = null;
        try (FileInputStream in = new FileInputStream(source)) {
            msg = upload(in, source.length(), ws, path, name, autoRename, progressListener);
        } catch (FileNotFoundException e) {
            throw SDKException.notFound(e);
        } catch (IOException e) {
            Log.w("IOException", "could not close reader on file at: " + source.getAbsolutePath());
        }
        return msg;
    }

    @Override
    public String uploadURL(String ws, String folder, String name, boolean autoRename) throws SDKException {
        loadSecureToken();
        try {
            P8RequestBuilder builder = null;
            try {
                builder = P8RequestBuilder.upload(ws, folder, name, autoRename, null);
            } catch (IOException e) {
                e.printStackTrace();
                throw SDKException.encoding(e);
            }
            return p8.getURL(builder.getRequest());
        } catch (ProtocolException | UnknownHostException e) {
            throw SDKException.malFormURI(e);
        } catch (UnsupportedEncodingException e) {
            throw SDKException.encoding(e);
        }
    }

    @Override
    public long download(String ws, String path, OutputStream target, TransferProgressListener progressListener) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.download(ws, path).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }

            try {
                return rsp.write(target, progressListener);
            } catch (IOException e) {
                throw SDKException.conReadFailed(e);
            }
        }
    }

    @Override
    public long download(String ws, String file, File target, TransferProgressListener progressListener) throws SDKException {
        OutputStream out;
        try {
            out = new FileOutputStream(target);
        } catch (FileNotFoundException e) {
            throw SDKException.notFound(e);
        }

        try {
            return download(ws, file, out, progressListener);
        } finally {
            io.close(out);
        }
    }

    @Override
    public String downloadURL(String ws, String file) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.download(ws, file).setSecureToken(secureToken);
        try {
            return p8.getURL(builder.getRequest());
        } catch (ProtocolException | UnknownHostException e) {
            throw SDKException.malFormURI(e);
        } catch (UnsupportedEncodingException e) {
            throw SDKException.encoding(e);
        }
    }

    @Override
    public Message delete(String ws, String[] files) throws SDKException {
        Message msg = new Message();
        for (String file : files) {
            String secureToken = getSecureToken();
            P8RequestBuilder builder = P8RequestBuilder.delete(ws, new String[]{file}).setSecureToken(secureToken);
            try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
                if (rsp.code() != Code.ok) {
                    throw new SDKException(rsp.code());
                }
                Document xml = rsp.toXMLDocument();
                Message onDeleteMessage = Message.create(xml);
                msg.deleted.addAll(onDeleteMessage.deleted);
                msg.updated.addAll(onDeleteMessage.updated);
                msg.added.addAll(onDeleteMessage.added);
            }
        }
        return msg;
    }

    @Override
    public Message restore(String ws, String[] files) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.restore(ws, files).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message move(String ws, String[] files, String dstFolder) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.move(ws, files, dstFolder).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message rename(String ws, String srcFile, String dstFile) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.rename(ws, srcFile, new File(dstFile).getName()).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message copy(String ws, String[] files, String folder) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.copy(ws, files, folder).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message bookmark(String ws, String file) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.bookmark(ws, file).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message unbookmark(String ws, String file) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.unbookmark(ws, file).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message mkdir(String ws, String parent, String name) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.mkdir(ws, parent, name).setSecureToken(secureToken);
        P8Request req = builder.getRequest();
        try (P8Response rsp = p8.execute(req, this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public InputStream previewData(String ws, String file, int dim) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.previewImage(ws, file, dim).setSecureToken(secureToken);
        P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required);
        if (rsp.code() != Code.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public String streamingAudioURL(String ws, String file) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.streamingAudio(ws, file).setSecureToken(secureToken);
        try {
            return p8.getURL(builder.getRequest());
        } catch (ProtocolException | UnknownHostException e) {
            throw SDKException.malFormURI(e);
        } catch (UnsupportedEncodingException e) {
            throw SDKException.encoding(e);
        }
    }

    @Override
    public String streamingVideoURL(String ws, String file) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();

        P8RequestBuilder builder = P8RequestBuilder.streamingVideo(ws, file).setSecureToken(secureToken);
        try {
            return p8.getURL(builder.getRequest());
        } catch (ProtocolException | UnknownHostException e) {
            throw SDKException.malFormURI(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw SDKException.encoding(e);
        }
    }

    @Override
    public Stats stats(String ws, String file, boolean withHash) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();

        P8RequestBuilder builder = P8RequestBuilder.stats(ws, file, withHash).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            String h = rsp.getHeaders("Content-Type").get(0);
            /*if (!"application/json".equals(h.toLowerCase())) {
                throw SDKException.unexpectedContent(new IOException(String.format("wrong response content type: %s", h)));
            } */

            try {
                JSONObject json = new JSONObject(rsp.toString());
                if (!json.has("hash") && !json.has("mtime") && !json.has("size")) {
                    return null;
                }

                Stats stats = new Stats();
                if (withHash) {
                    stats.setHash(json.getString("hash"));
                }
                stats.setmTime(json.getLong("mtime"));
                stats.setSize(json.getLong("size"));
                return stats;
            } catch (Exception e) {
                throw SDKException.unexpectedContent(e);
            }
        }
    }

    @Override
    public long changes(String ws, String filter, int seq, boolean flatten, ChangeHandler handler) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.changes(ws, filter, seq, flatten).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }

            String h = rsp.getHeaders("Content-Type").get(0);
            if (!h.toLowerCase().contains("application/json")) {
                throw SDKException.unexpectedContent(new IOException(rsp.toString()));
            }

            final long[] lastSeq = new long[1];
            final boolean[] readLastLine = {false};

            int lineCount = rsp.lineByLine("UTF-8", "\\n", (line) -> {
                if (readLastLine[0]) {
                    return;
                }

                if (line.toLowerCase().startsWith("last_seq")) {
                    readLastLine[0] = true;
                    lastSeq[0] = Integer.parseInt(line.split(":")[1]);
                    return;
                }

                JSONObject json;

                try {
                    json = new JSONObject(line);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }


                lastSeq[0] = Math.max(lastSeq[0], json.getLong(CHANGE_SEQ));
                Change change = new Change();

                change.setSeq(json.getLong(CHANGE_SEQ));
                change.setNodeId(json.getString(CHANGE_NODE_ID));
                change.setType(json.getString(CHANGE_TYPE));
                change.setSource(json.getString(CHANGE_SOURCE));
                change.setTarget(json.getString(CHANGE_TARGET));

                ChangeNode node = new ChangeNode();
                change.setNode(node);
                try {
                    node.setSize(json.getJSONObject(CHANGE_NODE).getLong(CHANGE_NODE_BYTESIZE));
                } catch (Exception ignore) {
                }
                try {
                    node.setMd5(json.getJSONObject(CHANGE_NODE).getString(CHANGE_NODE_MD5));
                } catch (Exception ignore) {
                }
                try {
                    node.setmTime(json.getJSONObject(CHANGE_NODE).getLong(CHANGE_NODE_MTIME));
                } catch (Exception ignore) {
                }
                try {
                    node.setPath(json.getJSONObject(CHANGE_NODE).getString(CHANGE_NODE_PATH));
                } catch (Exception ignore) {
                }
                node.setWorkspace(json.getJSONObject(CHANGE_NODE).getString(CHANGE_NODE_WORKSPACE));

                handler.onChange(change);
            });

            if (lineCount == 0 && seq == 0) {
                Change change = new Change();
                change.setSeq(seq);
                change.setNodeId("");
                change.setSource("");

                ChangeNode node = new ChangeNode();
                change.setNode(node);
                node.setWorkspace(ws);

                Stats stats = stats(ws, filter, true);
                if (stats == null) {
                    change.setType(Change.TYPE_DELETE);
                    change.setTarget("NULL");
                } else {
                    if ("directory".equals(stats.getHash())) {
                        return seq;
                    }
                    change.setType(Change.TYPE_CONTENT);
                    change.setTarget("");
                    node.setSize(stats.getSize());
                    node.setMd5(stats.getHash());
                    node.setmTime(stats.getmTime());
                    node.setPath("");
                }

                handler.onChange(change);
                return seq;
            }
            return Math.max(seq, lastSeq[0]);
        }
    }

    @Override
    public String share(String ws, String file, String ws_label, boolean isFolder, String ws_description, String password, int expiration, int download, boolean canPreview, boolean canDownload) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();

        P8RequestBuilder builder = P8RequestBuilder.share(ws, file, ws_description).setSecureToken(secureToken);
        if (password != null && !"".equals(password)) {
            builder.setParam(Param.shareGuestUserPassword, password);
        }

        if (!canPreview) {
            builder.setParam(Param.miniSiteLayout, "ajxp_unique_dl");
        }

        if (!canDownload) {
            builder.setParam(Param.miniSiteLayout, "ajxp_unique_strip");
        }

        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.toString();
        }
    }

    @Override
    public void unshare(String ws, String file) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.unShare(ws, file).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
        }
    }

    @Override
    public JSONObject shareInfo(String ws, String file) throws SDKException {
        loadSecureToken();
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.shareInfo(ws, file).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            try {
                return rsp.toJSON();
            } catch (Exception e) {
                throw SDKException.unexpectedContent(e);
            }
        }
    }

    @Override
    public InputStream getCaptcha() {
        P8Request request = new P8RequestBuilder().setAction(Action.getCaptcha).getRequest();
        return p8.execute(request).getContent();
    }

    @Override
    public JSONObject authenticationInfo() throws SDKException {
        try (P8Response seedResponse = p8.execute(P8RequestBuilder.getSeed().getRequest())) {
            String seed = seedResponse.toString();
            JSONObject o = new JSONObject();

            boolean withCaptcha = false;

            if (!"-1".equals(seed)) {
                seed = seed.trim();
                if (seed.contains("\"seed\":-1") || seed.contains("\"seed\": -1")) {
                    withCaptcha = seed.contains("\"captcha\": true") || seed.contains("\"captcha\":true");
                    o.put(Param.seed, "-1");

                } else {
                    String contentType = seedResponse.getHeaders("Content-Type").get(0);
                    boolean seemsToBePydio = (contentType != null) && (
                            (contentType.toLowerCase().contains("text/plain"))
                                    | (contentType.toLowerCase().contains("text/xml"))
                                    | (contentType.toLowerCase().contains("text/json"))
                                    | (contentType.toLowerCase().contains("application/json")));

                    if (!seemsToBePydio) {
                        throw SDKException.unexpectedContent(new IOException(seed));
                    }
                    o.put(Param.seed, "-1");
                }
            }

            if (withCaptcha) {
                o.put(Param.captchaCode, true);
            }
            return o;
        }
    }

    @Override
    public Message emptyRecycleBin(String ws) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.emptyRecycle(ws).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, Code.authentication_required)) {
            if (rsp.code() != Code.ok) {
                throw new SDKException(rsp.code());
            }
            Document doc = rsp.toXMLDocument();
            return null;
        }
    }
}
