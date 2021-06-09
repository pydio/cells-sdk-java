package com.pydio.cells.transport;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ICellsTransport;
import com.pydio.cells.api.PasswordCredentials;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.callbacks.RegistryItemHandler;
import com.pydio.cells.client.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.RestFrontSessionResponse;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.squareup.okhttp.OkHttpClient;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import static com.pydio.cells.transport.CellsServer.API_PREFIX;

public class CellsTransport implements ICellsTransport, SdkNames {

    private final CustomEncoder encoder;

    private final Store<Token> tokenStore;
    private final String login;
    private final Server server;

    private String userAgent;

    public CellsTransport(Store<Token> tokenStore, String login, Server server, CustomEncoder encoder) {
        this.tokenStore = tokenStore;
        this.login = login;
        this.server = server;
        this.encoder = encoder;
    }

    public static CellsTransport asAnonymous(Server server, CustomEncoder encoder) {
        return new CellsTransport(null, ANONYMOUS_USERNAME, server, encoder);
    }

    public Token unlock(Credentials credentials) throws SDKException {
        if (credentials instanceof  PasswordCredentials){
            return legacyLogin((PasswordCredentials) credentials);
        } else {
            throw new SDKException("Unsupported credential type: "+ credentials.getClass().getCanonicalName());
        }
    }

    public Token legacyLogin(PasswordCredentials credentials) throws SDKException {
        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getLogin());
        authInfo.put("password", credentials.getPassword());
        authInfo.put("type", "credentials");
        String authHeader = "Basic " + encoder.base64Encode(ClientData.getClientId() + ":" + ClientData.getClientSecret());
        authInfo.put("Authorization", authHeader);

        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setClientTime((int) System.currentTimeMillis());
        request.authInfo(authInfo);

        FrontendServiceApi api = new FrontendServiceApi(getApiClient());

        RestFrontSessionResponse response;
        try {
            response = api.frontSession(request);

            Token t = new Token();
            t.subject = ServerFactory.accountID(credentials.getLogin(), server);
            t.value = response.getJWT();
            t.setExpiry((long) response.getExpireTime());
            tokenStore.put(t.subject, t);
            return t;
        } catch (ApiException e) {
            throw new SDKException(ErrorCodes.no_token_available, new IOException("login or password incorrect"));
        }
    }

//    public void restore(TokenService tokens) throws SDKException {
//        this.tokens = tokens;
//        server.refresh(false);
//        // TODO more init
//    }

    public String getId() {
        return new StateID(getUser(), getServer().getServerURL().getId()).getId();
    }

    @Override
    public Server getServer() {
        return server;
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
    public String getUser() {
        return login;
    }

    public String getAccessToken() throws SDKException {

        Token token = getToken();
        if (token == null) {
            return null;
        }

        return token.value;
    }

    private Token getToken() throws SDKException {

        Token token = tokenStore.get(getId());
        if (token == null) {
            return null;
        }

        if (token.isExpired()) {
            token = refreshOAuthToken(token);
            tokenStore.put(getId(), token);
        }

        return token;
    }

    @Override
    public InputStream getUserData(String binary) {
        // FIXME  implement
        return null;
    }

    @Override
    public HttpURLConnection withAuth(HttpURLConnection con) throws SDKException {
        con.setRequestProperty("Authorization", "Bearer " + getAccessToken());
        return con;
    }

    @Override
    public HttpURLConnection withUserAgent(HttpURLConnection con) {
        con.setRequestProperty("User-Agent", getUserAgent());
        return con;
    }

    @Override
    public HttpURLConnection openConnection(String path) throws SDKException, IOException {
        return withAuth(withUserAgent(server.newURL(path).openConnection()));
    }

    @Override
    public HttpURLConnection openAnonConnection(String path) throws IOException {
        return withUserAgent(server.newURL(path).openConnection());
    }

    public HttpURLConnection openApiConnection(String path) throws SDKException, IOException {
        return withAuth(withUserAgent(server.newURL(API_PREFIX + path).openConnection()));
    }

    public HttpURLConnection openAnonApiConnection(String path) throws IOException {
        return withUserAgent(server.newURL(API_PREFIX + path).openConnection());
    }

    public ApiClient authenticatedClient() throws SDKException {
        ApiClient apiClient = getApiClient();
        apiClient.addDefaultHeader("Authorization", "Bearer " + getAccessToken());
        return apiClient;
    }

//    @Override
//    public void login() throws SDKException {
//        getAccessToken();
//    }

//    @Override
//    public void logout() throws SDKException {
//        RestFrontSessionRequest request = new RestFrontSessionRequest();
//        request.setLogout(true);
//        try {
//            new FrontendServiceApi(getApiClient()).frontSession(request);
//        } catch (ApiException e) {
//            throw new SDKException(e);
//        }
//    }

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

    public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {
        HttpURLConnection con = null;
        InputStream in = null;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            con = openAnonApiConnection("/frontend/state");
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
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(con);
        }
    }

    /**
     * Caller must close the returned stream.
     */
    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        try {
            HttpURLConnection con = openAnonApiConnection("/frontend/state");
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            Log.w("Connection", "connection error while retrieving registry");
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

    // TODO better management of exceptions.
    public Token getTokenFromCode(CustomEncoder encoder, String code, String state) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            Log.i("Login", "Retrieving token from OAuth2 code");

            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            // Manage Body as URL encoded form
            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "authorization_code");
            authData.put("code", code);
            authData.put("redirect_uri", cfg.redirectURI);

            // Either this or the 2 lines after are useless.
            authData.put("client_id", ClientData.getClientId());
            authData.put("client_secret", ClientData.getClientSecret());

            String authHeader = "Basic " + encoder.base64Encode(ClientData.getClientId() + ":" + ClientData.getClientSecret());
            addPostData(con, authData, authHeader);

            // TODO double check: do we need to explicitly open the connection before gettinng the stream ?
            try { // Real call
                System.out.println(con.getResponseCode());
                in = con.getInputStream();
            } catch (IOException ioe) {
                System.out.println(con.getResponseCode());
                System.out.println(con.getResponseMessage());
                throw ioe;
            }
            out = new ByteArrayOutputStream();
            IoHelpers.pipeRead(in, out);
            String jwtStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
            return Token.decodeOAuthJWT(jwtStr);
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    public Token refreshOAuthToken(Token t) throws SDKException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");

            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "refresh_token");
            authData.put("refresh_token", t.refreshToken);
            authData.put("client_id", ClientData.getClientId());
            // String secret = "".equals(ClientData.getClientSecret()) ? "whatever" : ClientData.getClientSecret();
            authData.put("client_secret", ClientData.getClientSecret());
            addPostData(con, authData, null);

            // Real call
            in = con.getInputStream();
            out = new ByteArrayOutputStream();
            IoHelpers.pipeRead(in, out);
            String jwtStr = new String(out.toByteArray(), StandardCharsets.UTF_8);
            return Token.decodeOAuthJWT(jwtStr);
        } catch (ParseException e) {
            Log.e("Token Service", "Could not parse refreshed token. " + e.getLocalizedMessage());
            throw new SDKException(ErrorCodes.no_token_available, new IOException("could not decode server response"));
        } catch (IOException e) {
            Log.w("Token Service", " token request failed: " + e.getLocalizedMessage());
            e.printStackTrace();
            throw new SDKException(ErrorCodes.con_failed, e);
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    /* Simply pass body parameters as URL encoded form */
    private void addPostData(HttpURLConnection con, Map<String, String> postData, String authHeader) throws SDKException {
        try {
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (builder.length() != 0) builder.append('&');
                builder.append(encoder.utf8Encode(entry.getKey()));
                builder.append('=');
                builder.append(encoder.utf8Encode(String.valueOf(entry.getValue())));
            }
            byte[] postDataBytes = encoder.getUTF8Bytes(builder.toString());


            if (authHeader != null && !"".equals(authHeader)) {
                con.setRequestProperty("Authorization", authHeader);
            }
            con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=utf-8");
            con.setRequestProperty("content-length", String.valueOf(postDataBytes.length));
            OutputStream postOut = con.getOutputStream();
            postOut.write(postDataBytes);
        } catch (IOException e) {
            throw new SDKException(ErrorCodes.bad_config, e);
        }
    }

    @SuppressWarnings("unused")
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

    @Override
    public JSONObject userInfo() throws SDKException {
        // FIXME really ?
        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setLogout(true);
        return null;
    }

//    @Override
//    @Deprecated
//    public void setCredentials(Credentials credentials) throws SDKException {
//        // This should not be used by a Cells transport
//        throw new SDKException("Directly setting credentials on a Cells transport is prohibited");
//    }

//    public CustomEncoder getEncoder() {
//        return encoder;
//    }


//    private static SDKException fromApiException(ApiException e) {
//        int code = ErrorCodes.fromHttpStatus(e.getCode());
//        return new SDKException(code, e);
//    }
//
//
//    /**
//     * This is necessary until min version is 24: we cannot use the consumer pattern:
//     * public void listChildren(String fullPath, Consumer<TreeNode> consumer) throws SDKException {
//     * ... consumer.onNode(nodes.next());
//     */
//    public interface TreeNodeHandler {
//        void onNode(TreeNode node);
//    }

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
////        IdToken parsedIDToken;
////        parsedIDToken = com.pydio.sdk.core.auth.jwt.IdToken.parse(t.idToken);
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
    //           // io.close(in);
    //       }
    //   }


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


}
