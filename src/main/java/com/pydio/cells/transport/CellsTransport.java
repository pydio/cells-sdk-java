package com.pydio.cells.transport;

import static com.pydio.cells.transport.CellsServer.API_PREFIX;

import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ICellsTransport;
import com.pydio.cells.api.PasswordCredentials;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.callbacks.RegistryItemHandler;
import com.pydio.cells.client.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.RestFrontSessionResponse;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.credentials.LegacyPasswordCredentials;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;
import com.squareup.okhttp.OkHttpClient;

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

public class CellsTransport implements ICellsTransport, SdkNames {

    private final CustomEncoder encoder;

    private final CredentialService credentialService;
    private final String username;
    private final Server server;

    private String userAgent;

    public CellsTransport(CredentialService credentialService, String username, Server server, CustomEncoder encoder) {
        this.credentialService = credentialService;
        this.username = username;
        this.server = server;
        this.encoder = encoder;
    }

    public static CellsTransport asAnonymous(Server server, CustomEncoder encoder) {
        return new CellsTransport(null, ANONYMOUS_USERNAME, server, encoder);
    }

    public String getId() {
        return new StateID(getUsername(), getServer().getServerURL().getId()).getId();
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

        ClientData clientData = ClientData.getInstance();
        userAgent = String.format(Locale.US, "%s-%s/%d",
                clientData.getName(), clientData.getVersion(), clientData.getVersionCode());
        if (Str.notEmpty(clientData.getPlatform())) {
            userAgent = clientData.getPlatform() + "/" + userAgent;
        }
        if (Str.notEmpty(clientData.getPackageID())) {
            userAgent = userAgent + "/" + clientData.getPackageID();
        }
        Log.i("CellsTransport", "############### User Agent generated: " + userAgent);
        return userAgent;
    }

    @Override
    public boolean isOffline() {
        return false;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getAccessToken() throws SDKException {
        Token token = getToken();
        if (token == null) {
            return null;
        }
        return token.value;
    }

    private Token getToken() throws SDKException {

        Token token = credentialService.get(getId());
        String password;

        // We check token validity and try to refresh / get it if necessary
        if (token == null) {
            // Check if we have a password for this transport
            password = credentialService.getPassword(getId());
            if (Str.empty(password)) {
                return null;
            }
            token = getTokenFromLegacyCredentials(new LegacyPasswordCredentials(getUsername(), password));
            credentialService.put(getId(), token);
            return token;

        } else if (token.isExpired()) {

            if (Str.notEmpty(token.refreshToken)) {
                String refreshToken = token.refreshToken;
                // FIXME insure we can access the network before invalidating the refresh token
                // FIXME: we first delete the refresh token in our store: it can be used only once.
                token.refreshToken = null;
                credentialService.put(getId(), token);
                Token newToken = getRefreshedOAuthToken(refreshToken);
                credentialService.put(getId(), newToken);
                return newToken;
            } else if (Str.notEmpty((password = credentialService.getPassword(getId())))) {
                token = getTokenFromLegacyCredentials(new LegacyPasswordCredentials(getUsername(), password));
                credentialService.put(getId(), token);
                return token;
            } else {
                // Expired token and we have no procedure to refresh it, we delete the token
                credentialService.remove(getId());
            }
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
        String accessToken = getAccessToken();
        if (Str.empty(accessToken)) {
            throw new SDKException(ErrorCodes.no_token_available);
        }
        apiClient.addDefaultHeader("Authorization", "Bearer " + accessToken);
        return apiClient;
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

    @Override
    public Token getTokenFromLegacyCredentials(PasswordCredentials credentials) throws SDKException {
        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getUsername());
        authInfo.put("password", credentials.getPassword());
        authInfo.put("type", "credentials");
        ClientData cd = ClientData.getInstance();
        String authHeader = "Basic "
                + encoder.base64Encode(cd.getClientId() + ":" + cd.getClientSecret());
        authInfo.put("Authorization", authHeader);

        RestFrontSessionRequest request = new RestFrontSessionRequest();
        request.setClientTime((int) System.currentTimeMillis());
        request.authInfo(authInfo);

        FrontendServiceApi api = new FrontendServiceApi(getApiClient());

        RestFrontSessionResponse response;
        try {
            response = api.frontSession(request);

            Token t = new Token();
            t.subject = ServerFactory.accountID(credentials.getUsername(), server);
            t.value = response.getJWT();
            t.setExpiry((long) response.getExpireTime());
            return t;
        } catch (ApiException e) {
            throw new SDKException(ErrorCodes.no_token_available, new IOException("login or password incorrect"));
        }
    }

    // TODO better management of exceptions.
    public Token getTokenFromCode(String code, CustomEncoder encoder) throws Exception {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            Log.i("SDK/LOGIN", "Retrieving token from OAuth2 code");

            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            // Manage Body as URL encoded form
            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "authorization_code");
            authData.put("code", code);
            authData.put("redirect_uri", cfg.redirectURI);

            // Either this or the 2 lines after are useless.
            ClientData cd = ClientData.getInstance();
            authData.put("client_id", cd.getClientId());
            authData.put("client_secret", cd.getClientSecret());

            String authHeader = "Basic " + encoder.base64Encode(cd.getClientId() + ":" + cd.getClientSecret());
            addPostData(con, authData, authHeader);

            try { // Real call
                // TODO double check: do we need to explicitly open the connection before getting the stream ?
                con.connect();
                in = con.getInputStream();
            } catch (IOException ioe) {
                throw new IOException("Unable to open connection to ".concat(endpointURI.toString()), ioe);
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

    public Token getRefreshedOAuthToken(String refreshToken) throws SDKException {
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            Log.i("Refresh Token Service", System.currentTimeMillis() + ": refreshing token");

            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "refresh_token");
            authData.put("refresh_token", refreshToken);

            ClientData cd = ClientData.getInstance();
            authData.put("client_id", cd.getClientID());
//            String secret = Str.empty(ClientData.getClientSecret()) ? "whatever" : ClientData.getClientSecret();
//            authData.put("client_secret", secret);
            authData.put("client_secret", cd.getClientSecret());

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

    /* Sets body parameters as URL encoded form */
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

}
