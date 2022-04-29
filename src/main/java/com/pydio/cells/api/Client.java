package com.pydio.cells.api;

import com.pydio.cells.api.callbacks.ChangeHandler;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.callbacks.ProgressListener;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.PageOptions;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.transport.StateID;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface Client {

    boolean isLegacy();

    Registry getDefaultRegistry() throws SDKException;

    Registry getUserRegistry() throws SDKException;

    void workspaceList(NodeHandler handler) throws SDKException;

    Message mkdir(String ws, String parent, String name) throws SDKException;

    PageOptions ls(String ws, String folder, PageOptions options, NodeHandler handler) throws SDKException;

    FileNode nodeInfo(String ws, String path) throws SDKException;

    /**
     * Temporary test before cleaning this part of the code
     * while testing both P8 and Cells
     */
    @Deprecated
    FileNode getNodeMeta(String ws, String file) throws SDKException;

    Stats stats(String ws, String file, boolean withHash) throws SDKException;

    /**
     * @param node
     * @param parentFolder must be writable for current process
     * @param dim
     * @return the filename if a thumbnail has been correctly downloaded or generated or null otherwise
     * @throws SDKException
     */
    public String getThumbnail(StateID stateID, FileNode node, File parentFolder, int dim) throws SDKException;

    List<FileNode> search(String parentPath, String searchedText, int size) throws SDKException;

    @Deprecated
    void search(String ws, String dir, String searched, NodeHandler h) throws SDKException;

    Message copy(String ws, String[] files, String folder) throws SDKException;

    Message move(String ws, String[] files, String dstFolder) throws SDKException;

    Message rename(String ws, String srcFile, String newName) throws SDKException;

    Message delete(String ws, String[] files) throws SDKException;

    Message restore(String ws, FileNode[] files) throws SDKException;

    Message emptyRecycleBin(String ws) throws SDKException;

    Message upload(InputStream source, long length, String mime, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException;

    Message upload(File source, String mime, String ws, String path, String name, boolean autoRename, ProgressListener progressListener) throws SDKException;

    String uploadURL(String ws, String folder, String name, boolean autoRename) throws SDKException;

    long download(String ws, String file, OutputStream target, ProgressListener progressListener) throws SDKException;

    long download(String ws, String file, File target, ProgressListener progressListener) throws SDKException;

    String downloadPath(String ws, String file) throws SDKException;

    String streamingAudioURL(String ws, String file) throws SDKException;

    String streamingVideoURL(String ws, String file) throws SDKException;

    void getBookmarks(NodeHandler h) throws SDKException;

    Message bookmark(String workspace, String file, boolean isBookmarked) throws SDKException;

    // Rather use bookmark(slug, path, isBookmarked)
    @Deprecated
    Message bookmark(String ws, String file) throws SDKException;

    // Rather use bookmark(slug, path, isBookmarked)
    @Deprecated
    Message unbookmark(String ws, String file) throws SDKException;

    String share(String workspace, String file, String link_label,
                 String link_description, String password,
                 boolean canPreview, boolean canDownload)
            throws SDKException;

    @Deprecated
    String share(String ws, String file, String ws_label, boolean isFolder, String ws_description, String password, int expiration, int download, boolean canPreview, boolean canDownload) throws SDKException;

    void unshare(String workspace, String file) throws SDKException;

    String getShareAddress(String ws, String file) throws SDKException;

    long changes(String ws, String folder, int seq, boolean flatten, ChangeHandler changeHandler) throws SDKException;
}
