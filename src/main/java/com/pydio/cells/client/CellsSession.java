package com.pydio.cells.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ICellsSession;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.callbacks.RegistryItemHandler;
import com.pydio.cells.client.auth.Token;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.StateID;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.TreeNode;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Locale;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.pydio.cells.client.CellsServer.API_PREFIX;

public class CellsSession implements ICellsSession, SdkNames {

    private final Server server;

    // TODO final or not ?
    // private final String login;
    private String login;

    private TokenService tokens;
    // FIXME we should avoid to store the credentials in this object
    private Credentials credentials;
    private Boolean skipOAuth = false;
    private String userAgent;


    public CellsSession(Server server, String login) {
        this.server = server;
        this.login = login;
    }

    public void restore(TokenService tokens) throws SDKException {
        this.tokens = tokens;
        server.init();
        // TODO more init
    }

    public String getId() {
        return new StateID(getUser(), getServer().getServerURL().getId()).getId();
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

        userAgent = String.format(Locale.US, "%s-%s/%d", ClientData.name, ClientData.version, ClientData.versionCode);
        if (!ClientData.platform.equals("")) {
            userAgent = ClientData.platform + "/" + userAgent;
        }

        if (!ClientData.packageID.equals("")) {
            userAgent = userAgent + "/" + ClientData.packageID;
        }
        return userAgent;
    }

    @Override
    public boolean isOffline() {
        return false;
    }

    @Override
    public void setCredentials(Credentials credentials) throws SDKException {
        // FIXME
        this.credentials = credentials;
        login = credentials.getLogin();
        login();
    }

    @Override
    public String getUser() {
        return login;
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
        if (tokenStr == null) {
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
            ServerURL serverURL = getServer().getServerURL();
            OkHttpClient c = apiClient.getHttpClient();
            c.setSslSocketFactory(serverURL.getSslSocketFactory());
            final String serverUrl = serverURL.getId();
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

    //   @Override
    //   public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {
//
    //       HttpURLConnection con;
    //       InputStream in;
    //       SAXParserFactory factory = SAXParserFactory.newInstance();
    //       try {
    //           con = openAnonApiConnection("/frontend/state/?ws=" + ws);
    //           con.setRequestMethod("GET");
    //           in = con.getInputStream();
    //           SAXParser parser = factory.newSAXParser();
    //           parser.parse(in, new RegistrySaxHandler(itemHandler));
    //       } catch (Exception e) {
    //           e.printStackTrace();
    //           throw SDKException.unexpectedContent(e);
    //       } finally {
    //           // FIXME handle stream closing
    //           // io.close(in);
    //       }
    //   }


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

    //   @Override
    //   public InputStream getWorkspaceRegistry(String ws) throws SDKException {
    //       HttpURLConnection con;
    //       InputStream in;
    //       try {
    //           con = openApiConnection("/frontend/state/?ws=" + ws);
    //           con.setRequestMethod("GET");
    //           return con.getInputStream();
    //       } catch (IOException e) {
    //           throw SDKException.conFailed(e);
    //       }
    //   }

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
