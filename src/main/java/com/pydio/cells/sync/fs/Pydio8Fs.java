package com.pydio.cells.sync.fs;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ui.ChangeNode;
import com.pydio.cells.legacy.P8Client;
import com.pydio.cells.sync.Error;
import com.pydio.cells.sync.changes.GetChangeRequest;
import com.pydio.cells.sync.changes.GetChangesResponse;
import com.pydio.cells.sync.changes.ProcessChangeRequest;
import com.pydio.cells.sync.changes.ProcessChangeResponse;
import com.pydio.cells.sync.content.Content;
import com.pydio.cells.sync.content.ContentLoader;

import java.util.ArrayList;
import java.util.List;

public class Pydio8Fs implements Fs, ContentLoader {

    private final P8Client client;
    private final String workspace;
    private final String id;

    public Pydio8Fs(String id, P8Client p8Client, String workspace) {
        this.id = id;
        this.client = p8Client;
        this.workspace = workspace;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public List<String> getWatches() {
        return new ArrayList<>();
    }

    @Override
    public void addWatch(String path) {
    }

    @Override
    public GetChangesResponse getChanges(GetChangeRequest request) {
        GetChangesResponse response = new GetChangesResponse();
        try {
            int reqSeq = (int) request.getSeq();
            long seq = client.changes(workspace, request.getPath(), reqSeq, reqSeq == 0, (c) -> {
                c.setSourceSide(id());
                c.setTargetSide(request.getSide());

                if (!request.getPath().equals("/")) {
                    if (!c.getSource().equals("NULL")) {
                        c.setSource(request.getPath() + c.getSource());
                    }

                    if (!c.getTarget().equals("NULL")) {
                        c.setTarget(request.getPath() + c.getTarget());
                    }

                    ChangeNode node = c.getNode();
                    if (node != null && !"NULL".equals(node.getPath())) {
                        String p = node.getPath();
                        if (p == null) {
                            node.setPath(request.getPath());
                        } else {
                            node.setPath(request.getPath() + p);
                        }
                    }
                }
                response.addChange(c);
            });
            response.setLastSeq(seq);
        } catch (SDKException e) {
            e.printStackTrace();
            response.setError(Error.notMounted(""));
        }
        return response;
    }

    @Override
    public ProcessChangeResponse processChange(ProcessChangeRequest request) {
        return null;
    }

    @Override
    public ContentLoader getContentLoader() {
        return this;
    }

    @Override
    public boolean receivesEvents() {
        return false;
    }

    @Override
    public boolean sendsEvents() {
        return true;
    }

    @Override
    public Content getContent(String path) {

        // FIXME adapt after refactoring
        throw new RuntimeException("Broken after refactoring");

        // return new RemoteFileContent(client, workspace, path);
    }
}
