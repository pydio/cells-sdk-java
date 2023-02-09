package com.pydio.cells.legacy;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.utils.PathUtils;
import com.pydio.cells.utils.Str;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class P8RequestBuilder {

    private final P8Request request;

    public P8RequestBuilder() {
        request = new P8Request();
    }

    public P8RequestBuilder(P8Request request) {
        this.request = request;
    }

    public static P8RequestBuilder update(P8Request request) {
        return new P8RequestBuilder(request);
    }

    public static P8RequestBuilder getUserData(String user, String binary) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.getBinaryParam)
                .setParam(P8Names.userId, user)
                .setParam(P8Names.binaryId, binary);
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder getSeed() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getSeed).setMethod("GET");
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder login(P8Credentials credentials) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.login).
                setParam(P8Names.loginSeed, credentials.getSeed()).
                setParam(P8Names.userId, credentials.getUsername()).
                setParam(P8Names.password, credentials.getPassword());
        if (credentials.getCaptcha() != null) {
            builder.setParam(P8Names.captchaCode, credentials.getCaptcha());
        }
        return builder.ignoreCookies(true);
    }

    public static P8RequestBuilder logout() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.logout).setMethod("GET");
        return builder;
    }

    public static P8RequestBuilder defaultRegistry() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getXmlRegistry).ignoreCookies(true);
        return builder;
    }

    public static P8RequestBuilder userRegistry() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getXmlRegistry).ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder workspaceRegistry(String wsId) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getXmlRegistry).
                setParam(P8Names.tmpRepositoryId, wsId).
                ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder checkAuthStatus() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.checkAuth).
                setParam(P8Names.filter_value, "8").
                ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder workspaceList() {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getXmlRegistry).
                setParam(P8Names.xPath, P8Names.xPathUserRepositories).
                ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder nodeInfo(String ws, String file) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.ls)
                .setParam(P8Names.options, "al")
                .setParam(P8Names.file, file)
                .setParam(P8Names.tmpRepositoryId, ws)
                .ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder ls(String ws, String dir) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.ls)
                .setParam(P8Names.options, "al")
                .setParam(P8Names.dir, dir)
                .setParam(P8Names.tmpRepositoryId, ws)
                .ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder listBookmarked(String ws, String dir) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.searchByKeyword)
                .setParam(P8Names.options, "al")
                .setParam(P8Names.dir, dir)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.field, P8Names.ajxpBookmarked)
                .ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder unbookmark(String ws, String path) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getBookmarks)
                .setParam(P8Names.bmAction, P8Names.deleteBookmark)
                .setParam(P8Names.bmPath, path)
                .setParam(P8Names.tmpRepositoryId, ws)
                .ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder bookmark(String ws, String path) {
        P8RequestBuilder builder = new P8RequestBuilder();
        builder = builder.setAction(P8Names.getBookmarks)
                .setParam(P8Names.bmAction, P8Names.addBookmark)
                .setParam(P8Names.bmPath, path)
                .setParam(P8Names.tmpRepositoryId, ws)
                .ignoreCookies(false);
        return builder;
    }

    public static P8RequestBuilder search(String path, String query) {
        P8RequestBuilder builder = new P8RequestBuilder();
        String ws = PathUtils.getWorkspace(path);
        if (Str.empty(ws)) {
            builder.setAction(P8Names.multisearch);
        } else {
            builder.setAction(P8Names.search)
                    .setParam(P8Names.tmpRepositoryId, ws);

            String dir = PathUtils.getFile(path);
            if (Str.empty(dir)) {
                builder.setParam(P8Names.dir, dir);
            }
        }
        return builder.setParam(P8Names.query, query).ignoreCookies(false);
    }

    public static P8RequestBuilder upload(String ws, String dir, String name, boolean autoRename, P8RequestBody body) throws IOException {

        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.upload)
                .setParam(P8Names.dir, dir)
                .setParam(P8Names.tmpRepositoryId, ws);
        String urlEncodedName = java.net.URLEncoder.encode(name, "utf-8");
        builder.setParam(P8Names.urlencodedFilename, urlEncodedName)
                .setParam(P8Names.autoRename, String.valueOf(autoRename))
                .setParam(P8Names.xhrUploader, "true")
                .setBody(body);
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder download(String ws, String path) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.download)
                .setParam(P8Names.file, path)
                .setParam(P8Names.tmpRepositoryId, ws);
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder delete(String ws, String[] files) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setParam(P8Names.tmpRepositoryId, ws)
                .setAction(P8Names.delete);

        if (files.length > 1) {
            builder.setParam(P8Names.file, files[0]);
        } else {
            int count = 0;
            for (String file : files) {
                String item = String.format(Locale.ROOT, "file_%d", count);
                builder.setParam(item, file);
                count++;
            }
        }
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder restore(String ws, String[] files) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.restore)
                .setParam(P8Names.tmpRepositoryId, ws);

        int count = 0;
        for (String file : files) {
            builder.setParam(P8Names.file + "_" + count, file);
        }
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder move(String ws, String[] files, String dest) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.move)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.dest, dest);
        int count = 0;
        for (String file : files) {
            builder.setParam(P8Names.file + "_" + count, file);
        }
        return builder.ignoreCookies(false).setParam(P8Names.forceCopyDelete, "true");
    }

    public static P8RequestBuilder rename(String ws, String file, String newFilename) {
        return new P8RequestBuilder()
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .setParam(P8Names.filenameNew, newFilename)
                .setAction(P8Names.rename)
                .ignoreCookies(false);
    }

    public static P8RequestBuilder copy(String ws, String[] files, String dest) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.copy)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.dest, dest);
        int count = 0;
        for (String file : files) {
            builder.setParam(P8Names.file + "_" + count, file);
        }
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder mkdir(String ws, String dir, String name) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.mkdir)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.dir, dir)
                .setParam(P8Names.dirname, name);
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder previewImage(String ws, String file) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.previewDataProxy)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .setParam(P8Names.getThumb, "true");
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder previewPDF(String ws, String file) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.imagickDataProxy)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .setParam(P8Names.getThumb, "true");
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder streamingAudio(String ws, String file) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.audioProxy)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .setParam(P8Names.richPreview, "true");
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder streamingVideo(String ws, String file) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.readVideoData)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file);
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder stats(String ws, String file, boolean withHash) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file);

        if (withHash) {
            builder.setAction(P8Names.stats + "_hash");
        } else {
            builder.setAction(P8Names.stats);
        }
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder changes(String ws, String filter, int seq, boolean flatten) {
        P8RequestBuilder builder = new P8RequestBuilder()
                .setAction(P8Names.changes)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.flatten, String.valueOf(flatten))
                .setParam(P8Names.stream, "true")
                .setParam(P8Names.seqId, String.valueOf(seq));
        if (filter != null) {
            builder.setParam(P8Names.filter, filter);
        } else {
            builder.setParam(P8Names.filter, "/");
        }
        return builder.ignoreCookies(false);
    }

    public static P8RequestBuilder share(String ws, String file, String descripton) {
        File f = new File(file);
        return new P8RequestBuilder()
                .setAction(P8Names.share)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .setParam(P8Names.subAction, P8Names.createMinisite)
                .setParam(P8Names.createGuestUser, "true")
                .setParam(P8Names.workspaceLabel, f.getName())
                .setParam(P8Names.workspaceDescription, descripton)
                .setParam(P8Names.simpleRightDownload, "on")
                .setParam(P8Names.simpleRightRead, "on")
                .ignoreCookies(false);
    }

    public static P8RequestBuilder unShare(String ws, String file) {
        return new P8RequestBuilder()
                .setAction(P8Names.unshare)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .ignoreCookies(false);
    }

    public static P8RequestBuilder shareInfo(String ws, String file) {
        return new P8RequestBuilder()
                .setAction(P8Names.loadSharedElementData)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.merged, "true")
                .setParam(P8Names.file, file)
                .ignoreCookies(false);
    }

    public static P8RequestBuilder restore(String ws, String file) {
        return new P8RequestBuilder()
                .setAction(P8Names.restore)
                .setParam(P8Names.tmpRepositoryId, ws)
                .setParam(P8Names.file, file)
                .ignoreCookies(false);
    }

    public static P8RequestBuilder emptyRecycle(String ws) {
        return new P8RequestBuilder()
                .setAction(P8Names.emptyRecycle)
                .setParam(P8Names.tmpRepositoryId, ws)
                .ignoreCookies(false);
    }

    public static P8RequestBuilder getCaptcha() {
        return new P8RequestBuilder()
                .setAction(P8Names.getCaptcha)
                .ignoreCookies(false);
    }

    public P8RequestBuilder setAction(String action) {
        request.setAction(action);
        return this;
    }

    public P8RequestBuilder setParam(String name, String value) {
        request.setParam(name, value);
        return this;
    }

    public P8RequestBuilder addHeader(String name, String value) {
        request.setHeader(name, value);
        return this;
    }

    public P8RequestBuilder setBody(P8RequestBody body) {
        request.setBody(body);
        return this;
    }

    public P8RequestBuilder setToken(String token) {
        request.setSecureToken(token); // Superstition ?
        setParam(P8Names.secureToken, token);
        return this;
    }

    public P8RequestBuilder ignoreCookies(boolean ignore) {
        request.setIgnoreCookies(ignore);
        return this;
    }

    public P8RequestBuilder setCredentials(Credentials credentials) {
        request.setCredentials(credentials);
        return this;
    }

    public P8RequestBuilder setMethod(String method) {
        request.setMethod(method);
        return this;
    }

    public P8Request getRequest() {
        return request;
    }

}
