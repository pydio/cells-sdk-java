package com.pydio.sdk.core;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.ICellsSession;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.WorkspaceNode;
import com.pydio.sdk.core.auth.OauthConfig;
import com.pydio.sdk.core.auth.Token;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.model.CellsServer;
import com.pydio.sdk.core.model.parser.RegistrySaxHandler;
import com.pydio.sdk.core.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.sdk.core.utils.Log;
import com.pydio.sdk.core.utils.io;
import com.pydio.sdk.generated.cells.ApiClient;
import com.pydio.sdk.generated.cells.ApiException;
import com.pydio.sdk.generated.cells.api.FrontendServiceApi;
import com.pydio.sdk.generated.cells.model.RestFrontSessionRequest;
import com.pydio.sdk.generated.cells.model.TreeNode;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.pydio.sdk.core.model.CellsServer.API_PREFIX;

public class CellsSession implements ICellsSession, SdkNames {

    private final Server server;
    private final String login;

    private TokenService tokens;
    private Credentials credentials;
    private Boolean skipOAuth = false;
    private String userAgent;


    public CellsSession(Server server, String login) {
        this.server = server;
        this.login = login;
    }

    public void restore(TokenService tokens) throws SDKException {
        this.tokens = tokens;
        server.init(this);
        // TODO more init
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public Client getClient() {
        return new CellsClient(this);
    }

    @Override
    public String getUserAgent() {
        if (userAgent != null) {
            return userAgent;
        }

        userAgent = String.format(Locale.US, "%s-%s/%d", ApplicationData.name, ApplicationData.version, ApplicationData.versionCode);
        if (!ApplicationData.platform.equals("")) {
            userAgent = ApplicationData.platform + "/" + userAgent;
        }

        if (!ApplicationData.packageID.equals("")) {
            userAgent = userAgent + "/" + ApplicationData.packageID;
        }
        return userAgent;
    }

    @Override
    public boolean isOffline() {
        return false;
    }

    @Override
    public Map<String, WorkspaceNode> getCachedWorkspaces() {
        return null;
    }


    @Override
    public void setCredentials(Credentials c) {
        this.credentials = c;
    }

    @Override
    public String getUser() {
        return this.credentials.getLogin();
    }

    @Override
    public InputStream getUserData(String binary) {
        // FIXME  implement
        return null;
    }

    @Override
    public HttpURLConnection withAuth(HttpURLConnection con) throws SDKException {
        con.setRequestProperty("Authorization", "Bearer " + getToken());
        return con;
    }

    @Override
    public HttpURLConnection openConnection(String path) throws SDKException, IOException {
        return withAuth(server.newURL(path).openConnection());
    }

    @Override
    public HttpURLConnection openAnonConnection(String path) throws SDKException, IOException {
        return server.newURL(path).openConnection();
    }

    public HttpURLConnection openApiConnection(String path) throws SDKException, MalformedURLException, IOException {
        return withAuth(server.newURL(API_PREFIX + path).openConnection());
    }

    public HttpURLConnection openAnonApiConnection(String path) throws SDKException, MalformedURLException, IOException {
        return server.newURL(API_PREFIX + path).openConnection();
    }

    public ApiClient authenticatedClient() throws SDKException {
        ApiClient apiClient = getApiClient();
        apiClient.addDefaultHeader("Authorization", "Bearer " + getToken());
        return apiClient;
    }

    public String getToken() throws SDKException {
        Token t = tokens.get(this, login, server.getServerURL().getId());
        String tokenStr = t.idToken;
        // FIXME
        if (tokenStr == null){
            tokenStr = t.value;
        }
        return tokenStr;
    }


    @Override
    public void login() throws SDKException {
        getToken();
    }

    @Override
    public void logout() throws SDKException {
        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setLogout(true);
        try {
            new FrontendServiceApi(getApiClient()).frontSession(request);
        } catch (ApiException e) {
            throw new SDKException(e);
        }
    }

    public ApiClient getApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(getServer().getApiURL());
        apiClient.setUserAgent(getUserAgent());

        if (getServer().isSSLUnverified()) {
            SSLContext context = getServer().getServerURL().getSSLContext();
            OkHttpClient c = apiClient.getHttpClient();
            c.setSslSocketFactory(context.getSocketFactory());
            final String serverUrl = getServer().getServerURL().getURL().toString();
            c.setHostnameVerifier((s, sslSession) -> serverUrl.contains(s));
        }
        return apiClient;
    }

    @Override
    public JSONObject userInfo() throws SDKException {
        // FIXME really ?
        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setLogout(true);
        return null;
    }

    @Override
    public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {

        HttpURLConnection con = null;
        InputStream in = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            con = openAnonApiConnection("/frontend/state/?ws=login");
            con.setRequestMethod("GET");
            in = con.getInputStream();

            try {
                SAXParser parser = factory.newSAXParser();
                parser.parse(in, new ServerGeneralRegistrySaxHandler(itemHandler));
            } catch (Exception e) {
                Log.w("Connection", "could not parse registry request response");
                throw SDKException.unexpectedContent(e);
            }
        } catch (IOException e) {
            Log.w("Connection", "connection error while retrieving registry");
            throw SDKException.conFailed(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignore) {
                }
            }

            if (con != null) {
                con.disconnect();
            }
        }
    }

    @Override
    public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {

        HttpURLConnection con;
        InputStream in;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            con = openAnonApiConnection("/frontend/state/?ws=" + ws);
            con.setRequestMethod("GET");
            in = con.getInputStream();
            SAXParser parser = factory.newSAXParser();
            parser.parse(in, new RegistrySaxHandler(itemHandler));
        } catch (Exception e) {
            e.printStackTrace();
            throw SDKException.unexpectedContent(e);
        } finally {
            // FIXME handle stream closing
            // io.close(in);
        }
    }


    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        HttpURLConnection con;
        InputStream in;
        try {
            con = openAnonApiConnection("/frontend/state/?ws=login");
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            Log.w("Connection", "connection error while retrieving registry");
            throw SDKException.conFailed(e);
        }
    }

    @Override
    public InputStream getWorkspaceRegistry(String ws) throws SDKException {
        HttpURLConnection con;
        InputStream in;
        try {
            con = openApiConnection("/frontend/state/?ws=" + ws);
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            throw SDKException.conFailed(e);
        }
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        try {
            HttpURLConnection con = openApiConnection("/frontend/state");
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conFailed(e);
        }
    }



    private static SDKException fromApiException(ApiException e) {
        int code = ErrorCodes.fromHttpStatus(e.getCode());
        return new SDKException(code, e);
    }

    /**
     * This is necessary until min version is 24: we cannot use the consumer pattern:
     * public void listChildren(String fullPath, Consumer<TreeNode> consumer) throws SDKException {
     * ... consumer.onNode(nodes.next());
     */
    public interface TreeNodeHandler {
        void onNode(TreeNode node);
    }
}
