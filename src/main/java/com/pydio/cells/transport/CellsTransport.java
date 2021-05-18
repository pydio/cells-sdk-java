package com.pydio.cells.transport;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ICellsTransport;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.callbacks.RegistryItemHandler;
import com.pydio.cells.client.CellsClient;
import com.pydio.cells.client.ClientData;
import com.pydio.cells.client.auth.OAuthConfig;
import com.pydio.cells.client.auth.Token;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.common.http.HttpClient;
import com.pydio.cells.client.common.http.HttpRequest;
import com.pydio.cells.client.common.http.HttpResponse;
import com.pydio.cells.client.encoding.CustomEncoder;
import com.pydio.cells.client.encoding.JavaCustomEncoder;
import com.pydio.cells.client.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.cells.client.utils.IoHelpers;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.Params;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.TreeNode;
import com.squareup.okhttp.OkHttpClient;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.pydio.cells.transport.CellsServer.API_PREFIX;

public class CellsTransport implements ICellsTransport, SdkNames {

    private final Server server;

    // TODO final or not ?
    // private final String login;
    private String login;

    private TokenService tokens;
    // FIXME we should avoid to store the credentials in this object
    private Credentials credentials;
    private final Boolean skipOAuth = false;
    private String userAgent;

    protected final CustomEncoder encoder;

    public CellsTransport(String login, Server server, CustomEncoder encoder) {
        this.login = login;
        this.server = server;
        this.encoder = encoder;
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

    @Deprecated
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

    public HttpURLConnection openApiConnection(String path) throws SDKException, IOException {
        return withAuth(server.newURL(API_PREFIX + path).openConnection());
    }

    public HttpURLConnection openAnonApiConnection(String path) throws SDKException, IOException {
        return server.newURL(API_PREFIX + path).openConnection();
    }

    public ApiClient authenticatedClient() throws SDKException {
        ApiClient apiClient = getApiClient();
        apiClient.addDefaultHeader("Authorization", "Bearer " + getToken());
        return apiClient;
    }

    public String getToken() throws SDKException {
        Token t = tokens.get(this, getId());
        return t.value;
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


    public String getTokenFromCode(String state, String code) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        OAuthConfig cfg = server.getOAuthConfig();

        try {
            // For reference see:  https://auth0.com/docs/flows/call-your-api-using-the-authorization-code-flow
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            // Manage Body as URL encoded form
            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "authorization_code");
            // TODO make this dynamic
            authData.put("client_id", "cells-mobile");
            authData.put("client_secret", "");
            authData.put("code", code);
            authData.put("redirect_uri", cfg.redirectURI);
            addPostData(con, authData);

            // Real call
            in = con.getInputStream();
            out = new ByteArrayOutputStream();
            IoHelpers.pipeRead(in, out);
            String jwtStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
            return jwtStr;
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

//    private Token refresh(Token t) throws SDKException {
//        Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");
//
//        HttpRequest request = new HttpRequest();
//        Params params = Params.create("grant_type", "refresh_token").set("refresh_token", t.refreshToken);
//        request.setParams(params);
//
//        OAuthConfig cfg = server.getOAuthConfig();
//
//        // String auth = JavaCustomEncoder.base64Encode(cfg.clientID + ":" + cfg.clientSecret);
//
//        Base64 base64 = new Base64();
//        String auth = new String(base64.encode((cfg.clientID + ":" + cfg.clientSecret).getBytes()));
//
//        request.setHeaders(Params.create("Authorization", "Basic " + auth));
//        request.setEndpoint(cfg.tokenEndpoint);
//        request.setMethod("POST");
//
//        HttpResponse response;
//        try {
//            response = HttpClient.request(request);
//        } catch (Exception e) {
//            Log.w("Token Service", " token request failed: " + e.getLocalizedMessage());
//            throw new SDKException(ErrorCodes.con_failed);
//        }
//
//        String jwt;
//        try {
//            jwt = response.getString();
//        } catch (IOException e) {
//            Log.e("Refresh Token Service", "Could not get response string body: " + e.getLocalizedMessage());
//            e.printStackTrace();
//            throw new SDKException(ErrorCodes.no_token_available, new IOException("refresh token failed"));
//        }
//
////        try {
////            t = Token.decodeOAuthJWT(jwt);
////        } catch (ParseException e) {
////            Log.e("Refresh Token Service", "Could not parse refreshed token: " + jwt + ". " + e.getLocalizedMessage());
////            throw new SDKException(ErrorCodes.no_token_available, new IOException("could not decode server response"));
////        }
////
////        JWT parsedIDToken;
////        parsedIDToken = com.pydio.sdk.core.auth.jwt.JWT.parse(t.idToken);
////        if (parsedIDToken == null) {
////            throw new SDKException(Code.no_token_available);
////        }
////
////        t.subject = String.format("%s@%s", parsedIDToken.claims.name, server.url());
////        t.expiry = System.currentTimeMillis() / 1000 + t.expiry;
////        this.store.save(t);
////        return t;
//        return null;
//    }

    public Token refreshOAuthToken(Token t) throws SDKException {
        InputStream in = null;
        ByteArrayOutputStream out = null;

        try {

            // Token tmpt = refresh(t);
            Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");
            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            con.setRequestMethod("POST");
            con.setDoOutput(true);

            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "refresh_token");
            authData.put("refresh_token", t.refreshToken);
            // TODO make this dynamic
            authData.put("client_id", "cells-mobile");
            authData.put("client_secret", "");
            addPostData(con, authData);

            // Real call
            in = con.getInputStream();
            out = new ByteArrayOutputStream();
            long totalRead = IoHelpers.pipeRead(in, out);
            String jwtStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
            return Token.decodeOAuthJWT(jwtStr);
        } catch (ParseException e) {
            Log.e("Refresh Token Service", "Could not parse refreshed token. " + e.getLocalizedMessage());
            throw new SDKException(ErrorCodes.no_token_available, new IOException("could not decode server response"));
        } catch (Exception e) {
            Log.w("Token Service", " token request failed: " + e.getLocalizedMessage());
            e.printStackTrace();
            throw new SDKException(ErrorCodes.con_failed, e);
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    /* Simply pass body parameters as URL encoded form */
    private void addPostData(HttpURLConnection con, Map<String, String> postData) throws SDKException {

        try {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (builder.length() != 0) builder.append('&');
                builder.append(encoder.utf8Encode(entry.getKey()));
                builder.append('=');
                builder.append(encoder.utf8Encode(String.valueOf(entry.getValue())));
            }
            byte[] postDataBytes = encoder.getUTF8Bytes(builder.toString());

            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            OutputStream postOut = con.getOutputStream();
            postOut.write(postDataBytes);
        } catch (IOException e) {
            throw new SDKException(ErrorCodes.bad_config, e);
        }
    }

    private void debugConnection(HttpURLConnection con) {
        System.out.println(con.getRequestMethod());

        Map<String, List<String>> hfs = con.getHeaderFields();
        for (String currHeader : hfs.keySet()) {
            System.out.println("--- " + currHeader);
            int ii = 0;
            for (String val : hfs.get(currHeader)) {
                System.out.println("#" + (++ii) + ": " + val);
            }
        }

        Map<String, List<String>> hprops = con.getRequestProperties();
        for (String currHeader : hprops.keySet()) {
            System.out.println("--- " + currHeader);
            int ii = 0;
            for (String val : hprops.get(currHeader)) {
                System.out.println("#" + (++ii) + ": " + val);
            }
        }
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
