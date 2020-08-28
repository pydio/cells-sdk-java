package com.pydio.sdk.sync.fs;

import com.pydio.sdk.core.Pydio;
import com.pydio.sdk.core.PydioCells;
import com.pydio.sdk.core.api.cells.model.TreeNode;
import com.pydio.sdk.core.api.cells.model.TreeNodeType;
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
import com.pydio.sdk.sync.content.PydioRemoteFileContent;
import com.pydio.sdk.sync.tree.StateManager;
import com.pydio.sdk.core.model.TreeNodeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.pydio.sdk.core.utils.CellsPath;

public class CellsFs implements Fs, ContentLoader {

    private PydioCells cells;
    private String workspace;
    private String id;
    private StateManager stateManager;

    private final static int MOVE = 1;
    private final static int ADD = 2;
    private final static int DELETE = 3;

    public CellsFs(String id, PydioCells cells, String workspace, StateManager manager) {
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
        // PSEUDO ALGORYTHM TO BEGIN WITH

        // String currPath = "A/B/C";
        // ArrayList<TreeNode> remotes = listRemoteNodesWithOrder("A/B/C");
        // ArrayList<TreeNode> locales = listLocaleNodesWithOrder("A/B/C");

        // for (each child) {
        // case leftName != rightName {
        // case creation
        // case delete
        // }
        // case md5Left != md5Left {

        // }
        // return // same
        // }

        // recursivly(path, path){

        // TreeNode remote = getRemoteState(path)
        // TreeNode local = getLocalState(path)
        // List<change> list = compareStates(remote, local)
        // if (list != empty){
        // mainList = append(List)
        // call(sousPath)
        // } esle{
        // return mainList
        // }
        // }
        GetChangesResponse response = new GetChangesResponse();
        List<String> queue = new ArrayList<>();
        queue.add(request.getPath());

        while (queue.size() > 0) {
            String currentPath = queue.remove(0);

            try {

                TreeNodeInfo local = stateManager.get(currentPath);
                TreeNodeInfo remote = this.cells.statNode(CellsPath.fullPath(workspace, currentPath));
                if (local != null && remote != null && remote.getETag().equals(local.getETag())) {
                    // current node is already cached in local with same ETAG, nothing to do.
                    continue;
                }

                // TreeNode local = this.stateManager.getState(currentPath);
                // TreeNode remote = this.sortedRemoteTree(currentPath);

                List<TreeNodeInfo> localList = null; // this.stateManager.getState(currentPath).children();
                List<TreeNodeInfo> remoteList = this.sortedRemoteChildren(currentPath);

                for (TreeNodeInfo rTree : remoteList) {
                    boolean found = false;
                    for (TreeNodeInfo lTree : localList) {
                        int compResult = rTree.getName().compareTo(lTree.getName());

                        if (compResult == 0) {
                            // label are the same
                            found = true;
                            // TODO ETAG
                            // ETag comparison suits better here
                            if (rTree.getSize() != lTree.getSize() || rTree.getLastEdit() != lTree.getLastEdit()) {
                                if (rTree.isLeaf()) {
                                    String path = currentPath + "/" + rTree.getName();
                                    Change change = new Change();
                                    change.setType(Change.TYPE_CONTENT);
                                    change.setSource(path);
                                    change.setTarget(path);
                                    response.addChange(change);

                                } else {
                                    String dirFullPath = currentPath + "/" + rTree.getName();
                                    queue.add(dirFullPath);
                                }
                            }
                            break;
                        } else if (compResult > 0) {
                            //
                            break;
                        }
                    }

                    if (!found) {
                        String path = currentPath + "/" + rTree.getName();
                        Change change = new Change();
                        change.setType(Change.TYPE_CREATE);
                        change.setTarget(path);
                        response.addChange(change);
                    }
                }
                for (TreeNodeInfo lTree : localList) {
                    boolean found = false;
                    for (TreeNodeInfo rTree : remoteList) {
                        int compResult = lTree.getName().compareTo(rTree.getName());
                        if (compResult == 0) {
                            found = true;
                            break;
                        } else if (compResult > 0) {
                            break;
                        }
                    }

                    if (!found) {
                        String path = currentPath + "/" + lTree.getName();
                        Change change = new Change();
                        change.setType(Change.TYPE_DELETE);
                        change.setSource(path);
                        change.setTarget(path);
                        response.addChange(change);
                    }
                }

            } catch (SDKException e) {
                e.printStackTrace();
                Error error = new Error();
                error.setCode(e.code);
                error.setDetails(e.cause.getMessage());
                response.setError(error);
                return response;
            }
        }
        response.setSuccess(true);
        return response;
    }

    /**
     * Compute a list of changes for a given path within the current implicit
     * workspace
     */
    public TreeMap<String, Change> getRawChanges(String path) throws SDKException {

        // ordered by ETag, Type, Path? to ease flatten.
        TreeMap<String, Change> changes = new TreeMap<>();

        List<String> pathQueue = new ArrayList<>();

        if ("/".equals(path)) {
            // Workspace's root nodes have no ETags, go one level deeper
            pathQueue.addAll(listChildrenPath(workspace));
        } else {
            pathQueue.add(CellsPath.fullPath(workspace, path));
        }

        while (pathQueue.size() > 0) {
            String currPath = pathQueue.remove(0);

            TreeNodeInfo local = stateManager.get(currPath);
            TreeNodeInfo remote = cells.statNode(currPath);
            if (local != null && remote != null && remote.getETag().equals(local.getETag())) {
                // current node is already cached in local with same ETAG, nothing to do.
                continue;
            } else if (remote != null && remote.isLeaf()) { // Happens when with compute change on a full workspace
                if (local == null) {
                    addCreateChange(pathQueue, changes, remote);
                } else {
                    addUpdateChange(pathQueue, changes, remote);
                    // We should rather record a delete and a create we begin to flatten the
                    // changes.
                }
                continue;
            }

            Iterator<TreeNodeInfo> rit = listChildren(currPath).iterator();
            Iterator<TreeNodeInfo> lit = stateManager.getChildren(currPath).iterator();

            local = lit.hasNext() ? lit.next() : null;

            while (rit.hasNext()) {
                remote = rit.next();

                if (local == null) {
                    addCreateChange(pathQueue, changes, remote);
                    continue;
                } else {
                    int order = remote.getName().compareTo(local.getName());

                    // TODO check case when folder name has changed. Same eTag ?

                    while (order > 0 && lit.hasNext()) { // Next local is lexicographically smaller
                        addDeleteChange(pathQueue, changes, local);
                        local = lit.next();
                        order = remote.getName().compareTo(local.getName());
                    }

                    if (order > 0) {
                        // last local was smaller than next remote, no more potential matches for
                        // potential next remotes.
                        local = null;
                    } else if (order == 0) {
                        if (remote.getETag().equals(local.getETag())) {// Found a match, no change to report.
                            local = lit.hasNext() ? lit.next() : null;
                            continue;
                        } else { // Same name different etag
                            addUpdateChange(pathQueue, changes, remote);
                        }
                    } else {
                        addCreateChange(pathQueue, changes, remote);
                        continue;
                    }
                }
            }

            // Delete remaining local nodes that have name greater than the last remote node
            if (local != null) {
                addDeleteChange(pathQueue, changes, local);
            }
            while (lit.hasNext()) {
                local = lit.next();
                addDeleteChange(pathQueue, changes, local);
            }
        }
        return changes;
    }

    private void addCreateChange(List<String> pathQueue, TreeMap<String, Change> changes, TreeNodeInfo remote) {
        Change change = new Change();
        change.setType(Change.TYPE_CREATE);
        change.setTarget("NULL");
        change.setTarget(remote.getPath());

        // Also transmit a change for folders so that the state manager knows he must
        // put the etag
        ChangeNode node = new ChangeNode();
        node.setWorkspace(this.workspace);
        node.setPath(remote.getPath());
        node.setmTime(remote.getLastEdit());
        node.setMd5(remote.getETag());
        if (remote.isLeaf()) {
            node.setSize(remote.getSize());
        } else {
            // Directory created => walk inside to provide a change for each child
            // recursively.
            pathQueue.add(remote.getPath());
        }
        change.setNode(node);
        changes.put(remote.getPath(), change);
    }

    private void addDeleteChange(List<String> pathQueue, TreeMap<String, Change> changes, TreeNodeInfo local) {
        Change change = new Change();
        change.setType(Change.TYPE_DELETE);
        change.setSource(local.getPath());
        change.setTarget("NULL");
        changes.put(local.getPath(), change);
    }

    private void addUpdateChange(List<String> pathQueue, TreeMap<String, Change> changes, TreeNodeInfo remote) {

        // TODO handle corner case when a node at a given path has changed from folder
        // to file or the contrary

        Change change = new Change();
        change.setType(Change.TYPE_CONTENT);
        change.setTarget("NULL");
        change.setTarget(remote.getPath());

        // Also transmit a change for folders so that the state manager knows he must
        // put the ETag
        ChangeNode node = new ChangeNode();
        node.setWorkspace(this.workspace);
        node.setPath(remote.getPath());
        node.setmTime(remote.getLastEdit());
        node.setMd5(remote.getETag());
        if (remote.isLeaf()) {
            node.setSize(remote.getSize());
        } else {
            // Directory created => walk inside to provide a change for each child
            // recursively.
            pathQueue.add(remote.getPath());
        }
        change.setNode(node);
        changes.put(remote.getPath(), change);
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
    public Content getContent(String nodeId) {
        return new PydioRemoteFileContent(cells, workspace, nodeId);
    }

    private List<TreeNodeInfo> sortedRemoteChildren(String path) throws SDKException {
        List<TreeNodeInfo> sortedList = new ArrayList<>();
        TreeMap<String, TreeNodeInfo> sorterContainer = new TreeMap<>();
        this.cells.ls(this.workspace, path, (n) -> {
            TreeNodeInfo t = new TreeNodeInfo();
            t.setPath(n.path());
            t.setETag("");
            t.setSize(Long.parseLong(n.getProperty(Pydio.NODE_PROPERTY_BYTESIZE)));
            // TODO retrieve ETAG from node
            t.setLeaf("true".equals(n.getProperty(Pydio.NODE_PROPERTY_IS_FILE)));
            sorterContainer.put(n.label(), t);
        });
        Set<String> sortedKeys = sorterContainer.keySet();
        for (String key : sortedKeys) {
            sortedList.add(sorterContainer.get(key));
        }
        return sortedList;
    }

    private Set<String> listChildrenPath(String fullPath) throws SDKException {
        TreeMap<String, String> sorterContainer = new TreeMap<>();
        cells.listChildren(fullPath, (n) -> {
            sorterContainer.put(n.getPath(), n.getPath());
        });
        return sorterContainer.keySet();
    }

    private Collection<TreeNodeInfo> listChildren(String fullPath) throws SDKException {
        TreeMap<String, TreeNodeInfo> sorterContainer = new TreeMap<>();
        
        try{
            cells.listChildren(fullPath, (n) -> {
                System.out.println("child: " + n.getPath());
                sorterContainer.put(n.getPath(), PydioCells.toTreeNodeinfo(n));
            });
            return sorterContainer.values(); 
        } catch (SDKException e){
            System.out.println("could not get children: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
