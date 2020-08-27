package com.pydio.sdk.sync.fs;

import com.pydio.sdk.core.Pydio;
import com.pydio.sdk.core.PydioCells;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Change;
import com.pydio.sdk.sync.Error;
import com.pydio.sdk.sync.changes.GetChangeRequest;
import com.pydio.sdk.sync.changes.GetChangesResponse;
import com.pydio.sdk.sync.content.Content;
import com.pydio.sdk.sync.content.ContentLoader;
import com.pydio.sdk.sync.changes.ProcessChangeRequest;
import com.pydio.sdk.sync.changes.ProcessChangeResponse;
import com.pydio.sdk.sync.content.PydioRemoteFileContent;
import com.pydio.sdk.sync.tree.StateManager;
import com.pydio.sdk.core.model.BasicTreeNodeInfo;
import com.pydio.sdk.core.model.TreeNodeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class CellsFs implements Fs, ContentLoader {

    private PydioCells cells;
    private String workspace;
    private String id;
    private StateManager stateManager;

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
                TreeNodeInfo remote = this.cells.statNode(workspace, currentPath);

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
            BasicTreeNodeInfo t = new BasicTreeNodeInfo();
            t.setName(n.label());
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
}
