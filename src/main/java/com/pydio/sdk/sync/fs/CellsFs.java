package com.pydio.sdk.sync.fs;

import com.pydio.sdk.core.CellsClient;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Change;
import com.pydio.sdk.core.model.ChangeNode;
import com.pydio.sdk.sync.Error;
import com.pydio.sdk.sync.changes.GetChangeRequest;
import com.pydio.sdk.sync.changes.GetChangesResponse;
import com.pydio.sdk.sync.content.Content;
import com.pydio.sdk.sync.content.ContentLoader;
import com.pydio.sdk.sync.changes.ProcessChangeRequest;
import com.pydio.sdk.sync.changes.ProcessChangeResponse;
import com.pydio.sdk.sync.content.RemoteFileContent;
import com.pydio.sdk.sync.tree.StateManager;
import com.pydio.sdk.core.model.TreeNodeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import com.pydio.sdk.core.utils.CellsPath;

public class CellsFs implements Fs, ContentLoader {

    private CellsClient cells;
    private String workspace;
    private String id;
    private StateManager stateManager;

    private final static int MOVE = 1;
    private final static int ADD = 2;
    private final static int DELETE = 3;

    public CellsFs(String id, CellsClient cells, String workspace, StateManager manager) {
        this.id = id;
        this.cells = cells;
        this.workspace = workspace;
        this.stateManager = manager;
    }

    @Override
    public String id() {
        return this.id;
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

        TreeMap<String, Change> changes = null;
        GetChangesResponse response = new GetChangesResponse();
        try {
            changes = getRawChanges(request.getPath());
        } catch (SDKException e) {
            e.printStackTrace();
            Error error = new Error();
            error.setCode(e.code);
            error.setDetails(e.cause.getMessage());
            response.setError(error);
            return response;
        }

        // TODO: handle flatten changes

        Iterator<Change> it = changes.descendingMap().values().iterator();
        while (it.hasNext()) {
            response.addChange(it.next());
        }
        response.setSuccess(true);

        return response;
    }

    /**
     * Compute a list of changes for a given path within the current implicit
     * workspace
     */
    public TreeMap<String, Change> getRawChanges(String innerWsPath) throws SDKException {

        String basePath = CellsPath.fullPath(workspace, innerWsPath);

        // ordered by ETag, Type, Path? to ease flatten.
        TreeMap<String, Change> changes = new TreeMap<>();

        List<String> pathQueue = new ArrayList<>();
        if (!isUnchanged(basePath)) {
            pathQueue.add(basePath);
        }

        // TODO Manage case when base path points towards a file

        while (pathQueue.size() > 0) {
            String currPath = pathQueue.remove(0);

            Iterator<TreeNodeInfo> rit = listChildren(currPath).iterator();
            Iterator<TreeNodeInfo> lit = stateManager.getChildren(currPath).iterator();

            TreeNodeInfo local = lit.hasNext() ? lit.next() : null;

            while (rit.hasNext()) {
                TreeNodeInfo remote = rit.next();

                if (local == null) {
                    addPutChange(changes, Change.TYPE_CREATE, remote);
                    if (!remote.isLeaf()) {
                        pathQueue.add(remote.getPath());
                    }
                    continue;
                } else {
                    int order = remote.getName().compareTo(local.getName());

                    // TODO check case when folder name has changed. Same eTag ?

                    while (order > 0 && lit.hasNext()) { // Next local is lexicographically smaller
                        addDeleteChange(changes, local);
                        local = lit.next();
                        order = remote.getName().compareTo(local.getName());
                    }

                    if (order > 0) {
                        // last local is smaller than next remote, no more matches for any next remote
                        local = null;
                    } else if (order == 0) {
                        if (remote.getETag() != null && remote.getETag().equals(local.getETag())) {
                            // Found a match, no change to report.
                            local = lit.hasNext() ? lit.next() : null;
                            continue;
                        } else {
                            // Same name but different Etag => update.
                            // TODO: Handle type switch
                            addPutChange(changes, Change.TYPE_CONTENT, remote);
                            if (!remote.isLeaf()) {
                                pathQueue.add(remote.getPath());
                            }
                        }
                    } else {
                        addPutChange(changes, Change.TYPE_CREATE, remote);
                        if (!remote.isLeaf()) {
                            pathQueue.add(remote.getPath());
                        }
                        continue;
                    }
                }
            }

            // Delete remaining local nodes that have name greater than the last remote node
            if (local != null) {
                addDeleteChange(changes, local);
            }
            while (lit.hasNext()) {
                local = lit.next();
                addDeleteChange(changes, local);
            }
        }
        return changes;
    }

    private void addPutChange(TreeMap<String, Change> changes, String type, TreeNodeInfo remote) {
        // Gather changes for file & folder to insure ETag is stored by the statemanager
        Change change = new Change();
        change.setType(type);
        change.setSource("NULL");
        change.setTarget(remote.getPath());
        ChangeNode node = new ChangeNode();
        node.setWorkspace(this.workspace);
        node.setPath(remote.getPath());
        node.setmTime(remote.getLastEdit());
        node.setMd5(remote.getETag());
        if (remote.isLeaf()) {
            node.setSize(remote.getSize());
        }
        change.setNode(node);
        changes.put(remote.getPath(), change);
    }

    private void addDeleteChange(TreeMap<String, Change> changes, TreeNodeInfo local) {
        Change change = new Change();
        change.setType(Change.TYPE_DELETE);
        change.setSource(local.getPath());
        change.setTarget("NULL");
        changes.put(local.getPath(), change);
    }

    private boolean isUnchanged(String fullPath) throws SDKException {

        TreeNodeInfo remote = cells.statOptionalNode(fullPath);
        TreeNodeInfo local = stateManager.get(fullPath);

        if (local == null && remote == null) {
            return true;
        } else if (remote == null || local == null) {
            return false;
        }

        // We cannot rely on the ETag at root path
        // String remoteEtag = remote.getETag();
        // String localEtag = local.getETag();
        // return (remoteEtag != null) && remoteEtag.equals(localEtag);
        return false;
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
    public Content getContent(String nodeId) {
        return new RemoteFileContent(cells, workspace, nodeId);
    }

    @Override
    public boolean receivesEvents() {
        return false;
    }

    @Override
    public boolean sendsEvents() {
        return true;
    }

    private Collection<TreeNodeInfo> listChildren(String fullPath) throws SDKException {
        TreeMap<String, TreeNodeInfo> sorterContainer = new TreeMap<>();

        cells.listChildren(fullPath, (n) -> {
            sorterContainer.put(n.getPath(), CellsClient.toTreeNodeinfo(n));
        });

        return sorterContainer.values();
    }

}