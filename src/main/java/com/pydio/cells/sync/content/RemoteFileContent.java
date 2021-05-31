package com.pydio.cells.sync.content;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.sync.Error;

import java.io.IOException;
import java.io.InputStream;

public class RemoteFileContent implements Content {

    private final Client client;
    private final String ws;
    private final String path;

    private Stats stats;
    private Error error;

    public RemoteFileContent(Client client, String ws, String path) {

        this.client = client;
        this.ws = ws;
        this.path = path;

        try {
            stats = client.stats(ws, path, true);
        } catch (SDKException e) {
            e.printStackTrace();
            this.error = Error.notMounted("");
        }
    }

    @Override
    public Error getError() {
        return error;
    }

    @Override
    public String getMd5() {
        return stats.getHash();
    }

    @Override
    public long getSize() {
        return stats.getSize();
    }

    @Override
    public boolean exists() {
        return stats != null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        String url;
        try {
            url = client.downloadPath(ws, path);
        } catch (SDKException e) {
            e.printStackTrace();
            this.error = Error.notMounted("");
            return null;
        }

        // TODO this must be adapted or removed after refactoring is done.
        // Anyhow the cells java client cannot download yet.
        return null;
//        ServerURL targetURL = session.getServer().getServerURL();
//
//        if(serverURL.skipVerify()) {
//            SSLContext sslContext = serverURL.getSslContext();
//            HttpsURLConnection c = (HttpsURLConnection) new URL(url).openConnection();
//            c.setSSLSocketFactory(sslContext.getSocketFactory());
//            final String serverUrl = server.getServerURL().getURL().toString();
//            c.setHostnameVerifier((s, sslSession) -> serverUrl.contains(s));
//            return c.getInputStream();
//        } else {
//            return new java.net.URL(url).openStream();
//        }
    }
}
