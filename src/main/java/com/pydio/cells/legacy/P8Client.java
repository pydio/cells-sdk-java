package com.pydio.cells.legacy;

import com.pydio.cells.api.Change;
import com.pydio.cells.api.Client;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.Registry;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.callbacks.ChangeHandler;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.callbacks.ProgressListener;
import com.pydio.cells.api.callbacks.RegistryItemHandler;
import com.pydio.cells.api.ui.ChangeNode;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Node;
import com.pydio.cells.api.ui.PageOptions;
import com.pydio.cells.api.ui.Plugin;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.api.ui.WorkspaceNode;
import com.pydio.cells.client.model.DocumentRegistry;
import com.pydio.cells.client.model.NodeDiff;
import com.pydio.cells.client.model.parser.RegistrySaxHandler;
import com.pydio.cells.client.model.parser.TreeNodeSaxHandler;
import com.pydio.cells.client.model.parser.WorkspaceNodeSaxHandler;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class P8Client implements Client, SdkNames {

    private final P8Transport transport;

    public P8Client(Transport transport) {
        this.transport = (P8Transport) transport;
    }

    private P8Request refreshSecureToken(P8Request req) {
        try {
            transport.invalidateToken();

            if (!transport.useCaptcha()) {
                return transport.withAuth(P8RequestBuilder.update(req)).getRequest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Registry getDefaultRegistry() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.defaultRegistry();
        try (P8Response rsp = transport.execute(builder.getRequest())) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document doc = rsp.toXMLDocument();
            return new DocumentRegistry(doc);
        } catch (Exception ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public Registry getUserRegistry() throws SDKException {


        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.userRegistry());
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document doc = rsp.toXMLDocument();
            return new DocumentRegistry(doc);
        } catch (Exception ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public void workspaceList(NodeHandler handler) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.workspaceList());
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }

            // TODO this WorkspaceNodeSaxHandler parser is not reliable.
            final int code = rsp.saxParse(new WorkspaceNodeSaxHandler((n) -> {
                if (!Arrays.asList(defaultExcludedWorkspaces).contains(((WorkspaceNode) n).getAccessType())) {
                    handler.onNode(n);
                }
            }, 0, -1));

            if (code != ErrorCodes.ok) {
                throw new SDKException(code);
            }
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.workspaceRegistry(ws));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            final int code = rsp.saxParse(new RegistrySaxHandler(itemHandler));
            if (code != ErrorCodes.ok) {
                rsp.close();
                throw new SDKException(code);
            }
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public FileNode nodeInfo(String ws, String path) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.nodeInfo(ws, path));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }

            final FileNode[] node = new FileNode[1];
            final int resultCode = rsp.saxParse(new TreeNodeSaxHandler((n) -> node[0] = (FileNode) n));
            if (resultCode != ErrorCodes.ok) {
                throw new SDKException(resultCode);
            }
            node[0].setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
            return node[0];
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }


    // TODO used for debug purposes. remove
    private static class RIH extends RegistryItemHandler {

        public void onPref(String name, String value) {
            System.out.println("OnPref: " + name);
        }

        public void onAction(String action, String read, String write) {
            System.out.println("OnAction: " + action);
        }

        public void onWorkspace(Properties p) {
            System.out.println("OnWS ");

        }

        public void onPlugin(Plugin p) {
            System.out.println("OnPlugin: " + p.getName());
        }
    }


    @Override
    public PageOptions ls(String ws, String folder, PageOptions options, NodeHandler handler) throws SDKException {

/*
        // Dirty hack to debug

        session.downloadWorkspaceRegistry(ws, new RIH());

        System.out.println("After list, fixme");
        return null;
*/
        PageOptions nextOptions = new PageOptions();

        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.ls(ws, folder));
        while (true) {
            try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
//                try (P8Response rsp = session.execute(builder.getRequest(), this::refreshSecureToken, 0)) {
                int code = rsp.code();
                if (code != ErrorCodes.ok) {
                    throw new SDKException(code);
                }

                TreeNodeSaxHandler treeHandler = new TreeNodeSaxHandler((n) -> {
                    n.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
                    handler.onNode(n);
                });
                final int resultCode = rsp.saxParse(treeHandler);
                if (resultCode != ErrorCodes.ok) {
                    throw new SDKException(resultCode);
                }

                if (treeHandler.mPagination) {
                    if (treeHandler.mPaginationTotalPage != treeHandler.mPaginationCurrentPage) {
                        builder.setParam(P8Names.dir, folder + "%23" + (treeHandler.mPaginationCurrentPage + 1));
                    } else {
                        return nextOptions;
                    }
                } else {
                    return nextOptions;
                }
            } catch (IOException ioe) {
                throw new SDKException(ioe);
            }
        }
    }

    @Override
    public void search(String ws, String dir, String searchedText, NodeHandler h) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.search(ws, dir, searchedText));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            int code = rsp.code();
            if (code != ErrorCodes.ok) {
                throw new SDKException(code);
            }

            final int resultCode = rsp.saxParse(new TreeNodeSaxHandler(node -> {
                node.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, ws);
                h.onNode(node);
            }));

            if (resultCode != ErrorCodes.ok) {
                throw new SDKException(resultCode);
            }
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public void getBookmarks(NodeHandler handler) throws SDKException {

        List<WorkspaceNode> workspaceNodes = new ArrayList<>();


        // FIXME rather handle this in the AccountNode Layer.
//        if (session.isOffline()) {
//            workspaceNodes.addAll(session.getCachedWorkspaces().values());
//        } else {
        workspaceList((n) -> workspaceNodes.add((WorkspaceNode) n));
        //       }

        // List<WorkspaceNode> workspaceNodes = new ArrayList<>(serverNode.getWorkspaces().values());
        // if (workspaceNodes.isEmpty()) {
        //     workspaceList((n) -> workspaceNodes.add((WorkspaceNode) n));
        // }

        for (WorkspaceNode wn : workspaceNodes) {
            P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.listBookmarked(wn.getId(), "/"));
            while (true) {
                try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
                    int code = rsp.code();
                    if (code != ErrorCodes.ok) {
                        break;
                        //throw SDKException.fromP8Code(code);
                    }

                    TreeNodeSaxHandler treeHandler = new TreeNodeSaxHandler((n) -> {
                        n.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, wn.getId());
                        handler.onNode(n);
                    });

                    final int resultCode = rsp.saxParse(treeHandler);
                    if (resultCode != ErrorCodes.ok) {
                        //throw SDKException.fromP8Code(resultCode);
                        break;
                    }

                    if (treeHandler.mPagination) {
                        if (!(treeHandler.mPaginationTotalPage == treeHandler.mPaginationCurrentPage)) {
                            builder.setParam(P8Names.dir, "/" + "%23" + (treeHandler.mPaginationCurrentPage + 1));
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (IOException ioe) {
                    throw new SDKException(ioe);
                }
            }
        }
    }

    @Override
    public Message upload(InputStream source, long length, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException {
        stats(ws, path, false);

        long maxChunkSize = 2 * 1024 * 1204; // Default apache in most php init configs

        // TODO reimplement max size support for P8
        // String maxSize = session.getServerNode().getProperty(PropNames.UPLOAD_MAX_SIZE);
        // if (maxSize != null && !"".equals(maxSize)) {
        //     try {
        //         maxChunkSize = Long.parseLong(maxSize);
        //    } catch (Exception ignored) {
        //     }
        //  }

        P8RequestBody cb = new P8RequestBody(source, name, length, maxChunkSize);
        if (progressListener != null) {
            cb.setTransferListener(progressListener);
//            cb.setListener(new P8RequestBody.LocalProgressListener() {
//                @Override
//                public void transferred(long num) throws IOException {
//                    if (progressListener.onProgress(num)) {
//                        throw new IOException("");
//                    }
//                }
//
//                @Override
//                public void partTransferred(int part, int total) throws IOException {
//                    if (total == 0) total = 1;
//                    if (progressListener.onProgress(part * 100 / total)) {
//                        throw new IOException("");
//                    }
//                }
//            });
        }

        P8RequestBuilder builder;
        try {
            builder = transport.withAuth(P8RequestBuilder.upload(ws, path, name, autoRename, cb));
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.encoding(e);
        }

        P8Request req = builder.getRequest();
        P8Response rsp = transport.execute(req, this::refreshSecureToken, ErrorCodes.authentication_required);
        try {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }

            while (rsp.code() == ErrorCodes.ok && !cb.allChunksWritten()) {
                NodeDiff diff = NodeDiff.create(rsp.toXMLDocument());
                if (diff.updated != null && diff.updated.size() > 0) {
                    name = diff.updated.get(0).getLabel();
                } else if (diff.added != null && diff.added.size() > 0) {
                    name = diff.added.get(0).getLabel();
                } else {
                    //todo: stats "name" to get info
                }
                builder.setParam(P8Names.appendToUrlencodedPart, name);
                rsp = transport.execute(builder.getRequest());
            }

            if (rsp.code() != ErrorCodes.ok) {
                return Message.create(Message.ERROR, rsp.asString());
            }

            NodeDiff diff;
            Document doc = rsp.toXMLDocument();
            if (doc != null) {
                diff = NodeDiff.create(doc);
                if (diff.added != null) {
                    Node node = diff.added.get(0);
                    String label = node.getLabel();
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
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        } finally {
            rsp.close();
        }
    }

    @Override
    public Message upload(File source, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException {
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
        // FIXME
        Thread.dumpStack();
        throw new RuntimeException("Reimplement");
//
//        // loadSecureToken();
//        try {
//            P8RequestBuilder builder = null;
//            try {
//                builder = P8RequestBuilder.upload(ws, folder, name, autoRename, null);
//            } catch (IOException e) {
//                e.printStackTrace();TODO
//                throw SDKException.encoding(e);
//            }
//            return session.getURL(builder.getRequest());
//        } catch (ProtocolException | UnknownHostException e) {
//            throw SDKException.malFormURI(e);
//        } catch (UnsupportedEncodingException e) {
//            throw SDKException.encoding(e);
//        }
    }

    @Override
    public long download(String ws, String path, OutputStream target, ProgressListener progressListener) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.download(ws, path));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
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
    public long download(String ws, String file, File target, ProgressListener progressListener) throws SDKException {
        OutputStream out;
        try {
            out = new FileOutputStream(target);
        } catch (FileNotFoundException e) {
            throw SDKException.notFound(e);
        }

        try {
            return download(ws, file, out, progressListener);
        } finally {
            IoHelpers.closeQuietly(out);
        }
    }

    @Override
    public String downloadPath(String ws, String file) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.download(ws, file);
        return transport.pathFromRequest(builder.getRequest());

//
//        try {
//            return session.getURL(builder.getRequest());
//        } catch (ProtocolException | UnknownHostException e) {
//            throw SDKException.malFormURI(e);
//        } catch (UnsupportedEncodingException e) {
//            throw SDKException.encoding(e);
//        }
    }

    @Override
    public Message delete(String ws, String[] files) throws SDKException {
        Message msg = new Message();
        for (String file : files) {
            P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.delete(ws, new String[]{file}));
            try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
                if (rsp.code() != ErrorCodes.ok) {
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
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.restore(ws, files));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message move(String ws, String[] files, String dstFolder) throws SDKException {
        P8RequestBuilder builder = transport.withAuth(P8RequestBuilder.move(ws, files, dstFolder));
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message rename(String ws, String srcFile, String dstFile) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.rename(ws, srcFile, new File(dstFile).getName());
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message copy(String ws, String[] files, String folder) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.copy(ws, files, folder);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message bookmark(String ws, String file) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.bookmark(ws, file);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message unbookmark(String ws, String file) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.unbookmark(ws, file);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public Message mkdir(String ws, String parent, String name) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.mkdir(ws, parent, name);
        builder = transport.withAuth(builder);
        P8Request req = builder.getRequest();
        try (P8Response rsp = transport.execute(req, this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document xml = rsp.toXMLDocument();
            return Message.create(xml);
        }
    }

    @Override
    public InputStream previewData(String ws, String file, int dim) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.previewImage(ws, file);
        builder = transport.withAuth(builder);
        P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required);
        if (rsp.code() != ErrorCodes.ok) {
            rsp.close();
            throw new SDKException(rsp.code());
        }
        return rsp.getInputStream();
    }

    @Deprecated
    @Override
    public String streamingAudioURL(String ws, String file) throws SDKException {
        Thread.dumpStack();
        throw new RuntimeException("Streaming is not supported with Pydio 8 servers.");

//        // loadSecureToken();
//        P8RequestBuilder builder = P8RequestBuilder.streamingAudio(ws, file).setToken(session);
//        try {
//            return session.getURL(builder.getRequest());
//        } catch (ProtocolException | UnknownHostException e) {
//            throw SDKException.malFormURI(e);
//        } catch (UnsupportedEncodingException e) {
//            throw SDKException.encoding(e);
//        }
    }

    @Override
    public String streamingVideoURL(String ws, String file) throws SDKException {
        Thread.dumpStack();
        throw new RuntimeException("Streaming is not supported with Pydio 8 servers.");

//         // loadSecureToken();
//         P8RequestBuilder builder = P8RequestBuilder.streamingVideo(ws, file).setToken(session);
//         try {
//             return session.getURL(builder.getRequest());
//         } catch (ProtocolException | UnknownHostException e) {
//             throw SDKException.malFormURI(e);
//         } catch (UnsupportedEncodingException e) {
//             e.printStackTrace();
//             throw SDKException.encoding(e);
//         }
    }

    @Override
    public Stats stats(String ws, String file, boolean withHash) throws SDKException {
        // loadSecureToken();

        P8RequestBuilder builder = P8RequestBuilder.stats(ws, file, withHash);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            String h = rsp.getHeaders("Content-Type").get(0);
            /*if (!"application/json".equals(h.toLowerCase(Locale.ENGLISH))) {
                throw SDKException.unexpectedContent(new IOException(String.format("wrong response content type: %s", h)));
            } */

            try {

//                String contentStr = rsp.asString();
//                if (contentStr.startsWith("<?xml")){
//                    Document xml = rsp.fromStringToXMLDocument(contentStr);
//                    if (rsp.code() != ErrorCodes.ok) {
//                        throw new SDKException(rsp.code());
//                    }
//                    Message m = Message.create(xml);
//                    throw new SDKException(rsp.code(), new IOException("Unexpected content returned for P8 stats at "+session.getId()));
//                }
//                JSONObject json = new JSONObject(contentStr);

                JSONObject json = new JSONObject(rsp.asString());

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
        P8RequestBuilder builder = P8RequestBuilder.changes(ws, filter, seq, flatten);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }

            String h = rsp.getHeaders("Content-Type").get(0);
            if (!h.toLowerCase(Locale.ENGLISH).contains("application/json")) {
                throw SDKException.unexpectedContent(new IOException(rsp.asString()));
            }

            final long[] lastSeq = new long[1];
            final boolean[] readLastLine = {false};

            int lineCount = rsp.lineByLine("UTF-8", "\\n", (line) -> {
                if (readLastLine[0]) {
                    return;
                }

                if (line.toLowerCase(Locale.ENGLISH).startsWith("last_seq")) {
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
        } catch (IOException e) {
            throw new SDKException(e);
        }
    }

    @Override
    public String share(String ws, String file, String ws_label, boolean isFolder, String ws_description, String password, int expiration, int download, boolean canPreview, boolean canDownload) throws SDKException {
        //  loadSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.share(ws, file, ws_description);
        builder = transport.withAuth(builder);
        if (password != null && !"".equals(password)) {
            builder.setParam(P8Names.shareGuestUserPassword, password);
        }

        if (!canPreview) {
            builder.setParam(P8Names.miniSiteLayout, "ajxp_unique_dl");
        }

        if (!canDownload) {
            builder.setParam(P8Names.miniSiteLayout, "ajxp_unique_strip");
        }

        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.asString();
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public void unshare(String ws, String file) throws SDKException {
        // loadSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.unShare(ws, file);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
        }
    }

    @Override
    public JSONObject shareInfo(String ws, String file) throws SDKException {
        // loadSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.shareInfo(ws, file);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
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
    public boolean isLegacy() {
        return true;
    }

    @Override
    public Message emptyRecycleBin(String ws) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.emptyRecycle(ws);
        builder = transport.withAuth(builder);
        try (P8Response rsp = transport.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            Document doc = rsp.toXMLDocument();
            return null;
        }
    }
}
