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
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.FrontendServiceApi;
import com.pydio.cells.openapi.model.RestFrontSessionRequest;
import com.pydio.cells.openapi.model.RestFrontSessionResponse;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.jwt.OAuthConfig;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CellsTransport implements ICellsTransport, SdkNames {

    private final static String logTag = "CellsTransport";
    private final static String registryPath = "/frontend/state";
    private final CustomEncoder encoder;
    private final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
    private final CredentialService credentialService;

    // TODO rather rely on a state ID
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
        return getStateID().getId();
    }

    public StateID getStateID() {
        return new StateID(getUsername(), getServer().getServerURL().getId());
    }

    @Override
    public String getUsername() {
        return username;
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
        userAgent = ClientData.getInstance().userAgent();
        Log.i(logTag, "New Transport instance for " + username + ", user agent is: " + userAgent);
        return userAgent;
    }

    @Override
    public boolean isOffline() {
        Log.w(logTag, "Hard-coded non relevant offline check from ");
        Thread.dumpStack();
        return false;
    }

    public String getAccessToken() throws SDKException {
        Token token = getCheckedToken();
        if (token == null) {
            return null;
        }
        return token.value;
    }

    public Token getToken() throws SDKException {
        return credentialService.get(getId());
    }

    public void requestTokenRefresh() throws SDKException {
        credentialService.requestRefreshToken(getStateID());
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

    public HttpURLConnection openAnonymousApiConnection(String path) throws IOException {
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
        if (getServer().isSSLUnverified()) {
            apiClient = apiClient.setVerifyingSsl(false);
        }
        apiClient.setBasePath(getApiURL(getServer().getServerURL()));
        apiClient.setUserAgent(getUserAgent());
        return apiClient;
    }

    public void tryDownloadingBootConf() throws Exception {
        HttpURLConnection con = null;
        InputStream in = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            con = openConnection(CellsServer.BOOTCONF_PATH);
            in = con.getInputStream();
            IoHelpers.pipeRead(in, out);
        } finally {
            IoHelpers.closeQuietly(con);
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    /**
     * Caller must close the returned stream.
     */
    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        try {
            HttpURLConnection con = openAnonymousApiConnection(registryPath);
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            throw SDKException.conFailed("cannot get registry as anonymous", e);
        }
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        try {
            HttpURLConnection con = openApiConnection(registryPath);
            con.setRequestMethod("GET");
            return con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw SDKException.conFailed("cannot get registry as authenticated user", e);
        }
    }

    @Override
    public Token getTokenFromLegacyCredentials(PasswordCredentials credentials) throws SDKException {
        Map<String, String> authInfo = new HashMap<>();
        authInfo.put("login", credentials.getUsername());
        authInfo.put("password", credentials.getPassword());
        authInfo.put("type", "credentials");
        ClientData cd = ClientData.getInstance();
        authInfo.put("client_id", cd.getClientId());
//        if (Str.notEmpty(cd.getClientSecret())) {
//            // This additional header is only used for "private" clients and not used with
//            // default standard clients that have no client secret
//            String authHeader = "Basic "
//                    + encoder.base64Encode(cd.getClientId() + ":" + cd.getClientSecret());
//            authInfo.put("Authorization", authHeader);
//        }

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
            Integer expireTime = response.getExpireTime();
            if (expireTime != null) {
                t.setExpiry(expireTime.longValue());
            }
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
            Log.i(logTag, "Retrieving token from OAuth2 code");

            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            // Manage Body as URL encoded form
            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "authorization_code");
            authData.put("code", code);
            authData.put("redirect_uri", cfg.redirectURI);

            ClientData cd = ClientData.getInstance();
            authData.put("client_id", cd.getClientId());
            if (Str.notEmpty(cd.getClientSecret())) {
                authData.put("client_secret", cd.getClientSecret());
            }
            // String authHeader = "Basic " + encoder.base64Encode(cd.getClientId() + ":" + cd.getClientSecret());
            addPostData(con, authData, null);

            try { // Real call
                // TODO double check: do we need to explicitly open the connection before getting the stream ?
                con.connect();
                in = con.getInputStream();
            } catch (IOException ioe) {
                throw new IOException("Unable to open connection to ".concat(endpointURI.toString()), ioe);
            }
            out = new ByteArrayOutputStream();
            IoHelpers.pipeRead(in, out);
            String jwtStr = IoHelpers.toUtf8String(out);
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
            Log.d(logTag, String.format("Launching refresh token flow for %s@%s", username, getServer().url()));
            OAuthConfig cfg = server.getOAuthConfig();
            URI endpointURI = URI.create(cfg.tokenEndpoint);
            HttpURLConnection con = openAnonConnection(endpointURI.getPath());

            Map<String, String> authData = new HashMap<>();
            authData.put("grant_type", "refresh_token");
            authData.put("refresh_token", refreshToken);

            ClientData cd = ClientData.getInstance();
            authData.put("client_id", cd.getClientID());
            if (Str.notEmpty(cd.getClientSecret())) {
                authData.put("client_secret", cd.getClientSecret());
            }
            addPostData(con, authData, null);
            in = con.getInputStream();
            out = new ByteArrayOutputStream();
            IoHelpers.pipeRead(in, out);
            String jwtStr = IoHelpers.toUtf8String(out);
            Token newToken = Token.decodeOAuthJWT(jwtStr);
            Log.i(logTag, String.format("Retrieved a refreshed token for %s@%s. New expiration time %s",
                    username, getServer().url(), timeFormatter.format(new Date(newToken.expirationTime * 1000L))));
            return newToken;
        } catch (ParseException e) {
            Log.e(logTag, "Could not parse refreshed token. " + e.getLocalizedMessage());
            throw new SDKException(ErrorCodes.no_token_available, new IOException("could not decode server response"));
        } catch (IOException e) {
            if (e instanceof FileNotFoundException) {
                throw new SDKException(ErrorCodes.refresh_token_not_valid,
                        "FNFE while trying to refresh. It usually means that the refresh token has already been consumed", e);
            } else {
                throw new SDKException.RemoteIOException("Token request failed: " + e.getLocalizedMessage());
            }
        } finally {
            IoHelpers.closeQuietly(in);
            IoHelpers.closeQuietly(out);
        }
    }

    private Token getCheckedToken() throws SDKException {
        Token token = credentialService.get(getId());
        // We check token validity and try to refresh / get it if necessary
        if (token == null) {
            return null;
        } else if (token.isExpired()) {
            // Initiate a refresh token request if non is already running, but do not retrieve a new valid token here.
            credentialService.requestRefreshToken(getStateID());
            throw new SDKException(ErrorCodes.token_expired, "Token expired for " + getStateID() + ", refresh has been requested");
        }
        return token;
    }

    /* Sets body parameters as URL encoded form */
    private void addPostData(HttpURLConnection con, Map<String, String> postData, String authHeader) throws SDKException {
        OutputStream postOut = null;
        try {
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=utf-8");
            if (Str.notEmpty(authHeader)) {
                con.setRequestProperty("Authorization", authHeader);
            }
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, String> entry : postData.entrySet()) {
                if (builder.length() != 0) builder.append('&');
                builder.append(encoder.utf8Encode(entry.getKey()));
                builder.append('=');
                builder.append(encoder.utf8Encode(String.valueOf(entry.getValue())));
            }
            byte[] postDataBytes = encoder.getUTF8Bytes(builder.toString());
            con.setRequestProperty("content-length", String.valueOf(postDataBytes.length));

            postOut = con.getOutputStream();
            postOut.write(postDataBytes);
        } catch (IOException e) {
            throw new SDKException(ErrorCodes.bad_config, e);
        } finally {
            IoHelpers.closeQuietly(postOut);
        }
    }

    private String getApiURL(ServerURL serverURL) {
        try {
            return serverURL.withPath(API_PREFIX).getURL().toString();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Getting API URL for " + serverURL.getId(), e);
        }
    }

    @SuppressWarnings("unused")
    private void debugConnection(HttpURLConnection con) {
        System.out.println("... Debugging " + con.getRequestMethod() + " connection: ");
        Map<String, List<String>> hfs = con.getHeaderFields();
        for (String currHeader : hfs.keySet()) {
            System.out.println("--- " + currHeader);
            int ii = 0;
            for (String val : hfs.get(currHeader)) {
                System.out.println("#" + (++ii) + ": " + val);
            }
        }

        Map<String, List<String>> headers = con.getRequestProperties();
        for (String currHeader : headers.keySet()) {
            System.out.println("--- " + currHeader);
            int ii = 0;
            for (String val : headers.get(currHeader)) {
                System.out.println("#" + (++ii) + ": " + val);
            }
        }
    }
}
