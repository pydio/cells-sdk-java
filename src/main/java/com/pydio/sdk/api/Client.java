package com.pydio.sdk.api;

import com.pydio.sdk.core.common.callback.ChangeHandler;
import com.pydio.sdk.core.common.callback.NodeHandler;
import com.pydio.sdk.core.common.callback.RegistryItemHandler;
import com.pydio.sdk.core.common.callback.TransferProgressListener;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.FileNode;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.model.Stats;
import com.pydio.sdk.core.utils.PageOptions;

import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.cert.X509Certificate;

public interface Client {

    ServerNode getServerNode();

    void setCredentials(Credentials c);

    void setSkipOAuthFlag(boolean skipOAuth);

    String getUser();

    InputStream getUserData(String binary) throws SDKException;

    void login() throws SDKException;

    void logout() throws SDKException;

    JSONObject userInfo() throws SDKException;

    X509Certificate[] remoteCertificateChain();

    void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException;

    void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException;

    void workspaceList(final NodeHandler handler) throws SDKException;

    InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException;

    InputStream getWorkspaceRegistry(String ws) throws SDKException;

    InputStream getServerRegistryAsAuthenticatedUser() throws SDKException;

    FileNode nodeInfo(String ws, String path) throws SDKException;

    PageOptions ls(String ws, String folder, PageOptions options, NodeHandler handler) throws SDKException;

    void search(String ws, String dir, String searched, NodeHandler h) throws SDKException;

    void bookmarks(NodeHandler h) throws SDKException;

    Message upload(InputStream source, long length, String ws, String path, String name, boolean autoRename, final TransferProgressListener progressListener) throws SDKException;

    Message upload(File source, String ws, String path, String name, boolean autoRename, final TransferProgressListener progressListener) throws SDKException;

    String uploadURL(String ws, String folder, String name, boolean autoRename) throws SDKException;

    long download(String ws, String file, OutputStream target, TransferProgressListener progressListener) throws SDKException;

    long download(String ws, String file, File target, TransferProgressListener progressListener) throws SDKException;

    String downloadURL(String ws, String file) throws SDKException;

    Message delete(String ws, String[] files) throws SDKException;

    Message restore(String ws, String[] files) throws SDKException;

    Message move(String ws, String[] files, String dstFolder) throws SDKException;

    Message rename(String ws, String srcFile, String newName) throws SDKException;

    Message copy(String ws, String[] files, String folder) throws SDKException;

    Message bookmark(String ws, String file) throws SDKException;

    Message unbookmark(String ws, String file) throws SDKException;

    Message mkdir(String ws, String parent, String name) throws SDKException;

    InputStream previewData(String ws, String file, int dim) throws SDKException;

    String streamingAudioURL(String ws, String file) throws SDKException;

    String streamingVideoURL(String ws, String file) throws SDKException;

    Stats stats(String ws, String file, boolean withHash) throws SDKException;

    long changes(String ws, String folder, int seq, boolean flatten, ChangeHandler changeHandler) throws SDKException;

    String share(String ws, String file, String ws_label, boolean isFolder, String ws_description, String password, int expiration, int download, boolean canPreview, boolean canDownload) throws SDKException;

    void unshare(String ws, String file) throws SDKException;

    JSONObject shareInfo(String ws, String file) throws SDKException;

    InputStream getCaptcha() throws SDKException;

    JSONObject authenticationInfo() throws SDKException;

    Message emptyRecycleBin(String ws) throws SDKException;
}
