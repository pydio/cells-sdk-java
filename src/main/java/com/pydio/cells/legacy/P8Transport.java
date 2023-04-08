package com.pydio.cells.legacy;

import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ILegacyTransport;
import com.pydio.cells.api.PasswordCredentials;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.ClientData;
import com.pydio.cells.transport.ServerFactory;
import com.pydio.cells.transport.StateID;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.utils.IoHelpers;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class P8Transport implements ILegacyTransport, SdkNames {

    private final String logTag = "P8Transport";
    private final CustomEncoder encoder;
    private final Server server;
    private final String username;

    private final CredentialService credentialService;
    private final CookieManager cookieManager;
    private final byte[] LF = "\r\n".getBytes();
    private final byte[] DLF = "\r\n\r\n".getBytes();
    private String userAgent;
    private int loginFailure;
    private Boolean useCaptcha;

    public P8Transport(CredentialService credentialService, Server server, String username, CustomEncoder encoder) {
        this.server = server;
        this.username = username;
        this.encoder = encoder;

        this.credentialService = credentialService;
        this.cookieManager = new CookieManager();
        loginFailure = 0;
    }

    @Override
    public String getId() {
        return getStateID().getId();
    }

    @Override
    public StateID getStateID() {
        return new StateID(getUsername(), getServer().getServerURL().getId());
    }

    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public boolean isOffline() {
        return Str.empty(username) || ANONYMOUS_USERNAME.equals(username);
        // TODO implement check to see if we have a valid token
    }

    @Override
    public String getUserAgent() {
        if (userAgent != null) {
            return userAgent;
        }
        userAgent = ClientData.getInstance().userAgent();
        Log.i(logTag, "User Agent generated: " + userAgent);
        return userAgent;
    }

    protected P8RequestBuilder withAuth(P8RequestBuilder builder) throws SDKException {
        return builder.setToken(getSecureToken());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean useCaptcha() {
        if (useCaptcha != null) {
            return useCaptcha;
        }

        try {
            useCaptcha = authenticationInfo().withCaptcha;
            return useCaptcha;
        } catch (SDKException se) {
            Log.e(logTag, "Unexpected SDK error while checking if we use Captcha");
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public HttpURLConnection openAnonConnection(String path) throws IOException {
        return server.getServerURL().withSpec(path).openConnection();
    }

    @Override
    public HttpURLConnection openConnection(String path) throws IOException, SDKException {
        path = appendAuth(path);
        return withUserAgent(server.getServerURL().withSpec(path).openConnection());
    }

    public String appendAuth(String path) throws SDKException {
        String suffix =
                P8Names.REQ_PROP_TOKEN +
                        "=" +
                        utf8Encode(getSecureToken());
        return path + "&" + suffix;
    }

    /* Directly get a streamed image that contains the Captcha from the server. */
    @Override
    public InputStream getCaptcha() throws SDKException {
        P8Request request = new P8RequestBuilder().setAction(P8Names.getCaptcha).getRequest();
        P8Response captchaResponse = null;
        try {
            captchaResponse = execute(request);
            return captchaResponse.getInputStream();
        } catch (Exception e) {
            Log.e(logTag, "Unexpected error while getting Captcha");
            throw new SDKException(ErrorCodes.unexpected_response, e);
        }
    }

    public AuthInfo authenticationInfo() throws SDKException {
        try (P8Response seedResponse = execute(P8RequestBuilder.getSeed().getRequest())) {
            String seed = seedResponse.asString();

            AuthInfo ai = new AuthInfo();

            if (!"-1".equals(seed)) {
                seed = seed.trim();
                if (seed.contains("\"seed\":-1") || seed.contains("\"seed\": -1")) {
                    ai.withCaptcha = seed.contains("\"captcha\": true") || seed.contains("\"captcha\":true");
                } else {
                    String contentType = seedResponse.getHeaders("Content-Type").get(0);
                    boolean seemsToBePydio = (contentType != null) && (
                            (contentType.toLowerCase(Locale.ENGLISH).contains("text/plain"))
                                    | (contentType.toLowerCase(Locale.ENGLISH).contains("text/xml"))
                                    | (contentType.toLowerCase(Locale.ENGLISH).contains("text/json"))
                                    | (contentType.toLowerCase(Locale.ENGLISH).contains("application/json")));

                    if (!seemsToBePydio) {
                        throw SDKException.unexpectedContent(new IOException(seed));
                    }
                }
                ai.seed = -1;
            }

//            if (ai.withCaptcha) {
//                o.put(P8Names.captchaCode, true);
//            }
            return ai;
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.defaultRegistry();
        try (P8Response rsp = execute(builder.getRequest())) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.getInputStream();
        }
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.workspaceList().setToken(getSecureToken());
        try (P8Response rsp = execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.getInputStream();
        }
    }

    @Override
    public InputStream getUserData(String binary) throws SDKException {
        P8Request req = P8RequestBuilder.getUserData(username, binary).setToken(getSecureToken()).getRequest();
        try (P8Response rsp = execute(req, this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.getInputStream();
        } catch (Exception ioe) {
            throw new SDKException(ioe);
        }

//        try (P8Response rsp = execute(req)) {
//            final int code = rsp.code();
//            if (code != ErrorCodes.ok) {
//                if (code == ErrorCodes.authentication_required && credentials != null && loginFailure == 0) {
//                    loginFailure++;
//                    login();
//                    return getUserData(binary);
//                }
//                throw new SDKException(code);
//            }
//            return rsp.getInputStream();
//        }
    }

    /* Token Management */

    private String getSecureToken() throws SDKException {
        Token t = getToken();
        if (t == null) {
            return null;
        }
        return t.value;
    }

    private Token getToken() throws SDKException {
        Token t = credentialService.get(getId());
        if (t == null) {
            t = fromPassword();
            if (t != null) {
                credentialService.put(getId(), t);
            }
        }
        return t;
    }

    private Token fromPassword() throws SDKException {
        Log.i(logTag, "No token found for " + getId() + ", about to background login.");
        String pwd = credentialService.getPassword(getId());
        if (Str.notEmpty(pwd)) {
            return login(new P8Credentials(username, pwd));
        }
        return null;
    }

    private P8Request refreshSecureToken(P8Request req) {
        try {
            if (!authenticationInfo().withCaptcha) {
                // We remove the cached token so that the GetSecureToken call
                // will try to retrieve a brand new one with a password
                credentialService.remove(getId());
                return P8RequestBuilder.update(req).setToken(getSecureToken()).getRequest();
            }
        } catch (Exception e) {
            Log.e(logTag, "Cannot refresh secure token from password");
            e.printStackTrace();
        }
        return null;
    }

    private Token fromSecureToken(String username, String secureToken) {
        Token t = new Token();
        t.subject = ServerFactory.accountID(username, server);
        t.value = secureToken;
        t.tokenType = SdkNames.TOKEN_TYPE_P8;
        t.setExpiry(-1);
        return t;
    }

    public void invalidateToken() {
        credentialService.remove(getId());
    }

    @Override
    public Token getTokenFromLegacyCredentials(PasswordCredentials credentials) throws SDKException {
        if (credentials instanceof P8Credentials) {
            return login((P8Credentials) credentials);
        } else {
            throw new SDKException(ErrorCodes.unsupported, credentials.getClass().getCanonicalName() + "credentials are not supported by the P8 transport");
        }
    }

//    @Override
//    public void logout() throws SDKException {
//        String secureToken = getSecureToken();
//        P8Response response = execute(P8RequestBuilder.logout().setSecureToken(secureToken).getRequest());
//        response.close();
//    }

    /**
     * In P8 the auth token is bound to a session cookie: we must retrieve and store both
     * with the provided credentials.
     */
    public Token login(P8Credentials credentials) throws SDKException {

        Token existingToken = credentialService.get(getId());
        if (existingToken != null) {
            return existingToken;
        }

        Log.i(logTag, "Login process for " + getId());
        if (credentials == null) {
            throw new SDKException(ErrorCodes.authentication_required);
        }

        // Clear the cookie store before trying to login
        cookieManager.getCookieStore().removeAll();

        P8RequestBuilder builder = P8RequestBuilder.login(credentials);
        P8Request req = builder.getRequest();
        try (P8Response rsp = execute(req)) {
            final int code = rsp.code();
            if (code != ErrorCodes.ok) {
                rsp.close();
                throw new SDKException(code);
            }

            // Known issue: Pydio8 replies with 2 session cookies upon login.
            // So before storing the cookie, we must insure it is the correct one.
            Document doc = rsp.toXMLDocument();
            List<String> cookieHeaders = rsp.getHeaders(P8Names.HEADER_SET_COOKIE);
            return handleCookie(credentials.getUsername(), doc, cookieHeaders);
        }
    }

    private Token handleCookie(String username, Document doc, List<String> cookieHeaders) throws SDKException {

        // First handle well known error cases
        if (doc == null) {
            throw new SDKException(ErrorCodes.invalid_credentials, new IOException("Request sent an OK response, but could not parse XML body"));
        }
        if (doc.getElementsByTagName(P8Names.TAG_LOGIN_RESULT).getLength() == 0) {
            throw SDKException.unexpectedContent(new IOException("Cannot parse login response: " + doc));
        }

        if (cookieHeaders == null) {
            throw SDKException.unexpectedContent(new IOException("No cookies returned by the login process, aborting"));
        }

        Token token;

        NamedNodeMap attributes = doc.getElementsByTagName(P8Names.TAG_LOGIN_RESULT).item(0).getAttributes();
        String result = attributes.getNamedItem("value").getNodeValue();
        if (result.equals("1")) {
            String secureToken = attributes.getNamedItem(P8Names.secureToken).getNodeValue();
            loginFailure = 0;
            token = fromSecureToken(username, secureToken);

//                        Map<String, List<String>> allHeaders = rsp.getAllHeaders();
//                        for (String currHeader : allHeaders.keySet()) {
//                            System.out.println("--- " + currHeader);
//                            int ii = 0;
//                            for (String val : allHeaders.get(currHeader)) {
//                                System.out.println("#" + (++ii) + ": " + val);
//                            }
//                        }
            // System.out.println("Found " + cookieHeaders.size() + " set-cookie headers");

            boolean alreadyStoredValidCookie = false;
            for (String headers : cookieHeaders) {
                List<HttpCookie> cookies = HttpCookie.parse(headers);
                for (HttpCookie cookie : cookies) {
                    if (P8Names.AJXP_SESSION_COOKIE_NAME.equals(cookie.getName())) {
                        if (!alreadyStoredValidCookie) {
                            cookieManager.getCookieStore().add(URI.create(getId()), cookie);

                            // Perform a call with retrieved token and current session cookie
                            // to insure we have a correct session ID
                            P8RequestBuilder builder = P8RequestBuilder.workspaceList().setToken(secureToken);
                            try (P8Response rsp = execute(builder.getRequest())) {
                                if (rsp.code() == ErrorCodes.ok) {
                                    alreadyStoredValidCookie = true;
                                }
                            }
                        }
                    } else { // also store all other cookies.
                        cookieManager.getCookieStore().add(URI.create(getId()), cookie);
                    }
                }
            }
        } else {
            loginFailure++;
            if (result.equals("-4")) {
                throw new SDKException(
                        ErrorCodes.authentication_with_captcha_required,
                        new IOException("Could not log as ".concat(username).concat("@").concat(getServer().url())));
            }
            throw new SDKException(ErrorCodes.invalid_credentials,
                    new IOException("Could not log as " + username + "@" + getServer().url()));
        }
        return token;
    }

//    @Override
//    public JSONObject userInfo() throws SDKException {
//        return null;
//    }

    public P8Response execute(P8Request request) throws SDKException {
        try {
            switch (request.getMethod()) {
                case "GET":
                    return doGet(request);
                case "POST":
                    return doPost(request);
                case "PUT":
                    return doPut(request);
                default:
                    throw new RuntimeException("Unsupported method type: " + request.getMethod());
            }
        } catch (SDKException se) {
            if (se.getCode() == ErrorCodes.cancelled) { // Expected, cancellation, we forward the error
                throw se;
            } else { // TODO should never happen, swallowing the error for now
                Log.e(logTag, "Unexpected SDKException: " + se.getCode() + " - " + se.getMessage());
                se.printStackTrace();
                return P8Response.error(ErrorCodes.con_failed);
            }
        } catch (IOException ioe) {
            // FIXME temporary
            Log.e(logTag, "IOException while processing request: " + ioe.getMessage());
            ioe.printStackTrace();
            // TODO finer management needed here
            return P8Response.error(ErrorCodes.con_failed);
        }

    }

    public P8Response execute(P8Request request, RetryCallback retry, int retryResponseCode) throws SDKException {
        P8Response response = execute(request);
        if (retryResponseCode == response.code()) { // Usually when credentials ae expired
            // close current response, update the query and tries a second time
            response.close();
            P8Request retryRequest = retry.update(request);
            if (retryRequest != null) {
                response = execute(retryRequest);
            }
        }
        return response;
    }

    @Override
    public HttpURLConnection withUserAgent(HttpURLConnection con) {
        con.setRequestProperty(P8Names.REQ_PROP_USER_AGENT, getUserAgent());
        return con;
    }

    private void withToken(P8Request request, StringBuilder builder) {
        if (request.getSecureToken() != null) {
            andAppendParam(builder, "secure_token", request.getSecureToken());
        }
    }


    /* HTTP Methods */

    private HttpURLConnection withCookies(HttpURLConnection con) {
        List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
        if (cookies.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (HttpCookie cookie : cookies) {
                builder.append(";").append(cookie.toString());
            }
            String cookieStr = builder.substring(1);
            // Log.d(logTag, "Setting cookies: [" + cookieStr + "]");
            con.setRequestProperty(P8Names.REQ_PROP_COOKIE, cookieStr);
        }
        return con;
    }

    private HttpURLConnection withReqProp(HttpURLConnection con, String key, String value) {
        con.setRequestProperty(key, value);
        return con;
    }

    private P8Response doGet(P8Request request) throws IOException {
        StringBuilder builder = new StringBuilder(P8Server.API_PREFIX);
        appendParam(builder, P8Names.getAction, request.getAction());
        withToken(request, builder);

        ServerURL currURL;
        try {
            currURL = server.newURL(builder.toString());
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + builder, mue);
        }

        HttpURLConnection con = withUserAgent(currURL.openConnection());
        con.setRequestMethod("GET");
        return new P8Response(con);
    }

    private P8Response doPost(P8Request request) throws IOException, SDKException {

        // Prepare query
        StringBuilder builder = new StringBuilder(P8Server.API_PREFIX);
        appendParam(builder, P8Names.getAction, request.getAction());
        withToken(request, builder);

        ServerURL currURL;
        try {
            currURL = server.newURL(builder.toString());
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + builder, mue);
        }
        HttpURLConnection con = currURL.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        if (!request.getIgnoreCookies()) {
            withCookies(con);
        }
        withUserAgent(con);

        // Populate Body or Params
        if (request.getBody() != null) {
            populatePostBody(request, con);
        } else {
            // Add Params
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, String> entry : request.getParams().get().entrySet()) {
                if (postData.length() != 0) postData.append('&');
                postData.append(utf8Encode(entry.getKey()));
                postData.append('=');
                postData.append(utf8Encode(String.valueOf(entry.getValue())));
                //postData.append(URLEncoder.encode(String.valueOf(entry.getValue()), UTF_8));
            }
            byte[] postDataBytes = encoder.getUTF8Bytes(postData.toString());

            con.setRequestProperty(P8Names.REQ_PROP_CONTENT_LENGTH, String.valueOf(postDataBytes.length));
            con.setRequestProperty(P8Names.REQ_PROP_CONTENT_TYPE, P8Names.CONTENT_TYPE_URL_ENCODED);

            OutputStream out = con.getOutputStream();
            out.write(postDataBytes);
        }

        return new P8Response(con);
    }

    private P8Response doPut(P8Request request) throws IOException, SDKException {

        // Build effective URL request
        String queryStr = pathFromRequest(request);

        ServerURL currURL;
        try {
            currURL = server.newURL(queryStr);
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + queryStr, mue);
        }

        HttpURLConnection con = currURL.openConnection();
        con.setDoOutput(true);

        con.setRequestMethod("PUT");
        if (!request.getIgnoreCookies()) {
            withCookies(con);
        }
        withReqProp(con, P8Names.REQ_PROP_CONTENT_TYPE, P8Names.CONTENT_TYPE_OCTET_STREAM);
        withUserAgent(con);

        // Handle the response
        OutputStream out = null;
        try {
            out = con.getOutputStream();
            request.getBody().writeTo(out);
        } catch (SDKException se) {
            if (se.getCode() == ErrorCodes.cancelled) {
                Log.e(logTag, "----- Been cancelled");
            }
            throw se;
        } finally {
            IoHelpers.closeQuietly(out);
        }

        return new P8Response(con);
    }

    /**
     * Simply generate the full path (**file** + query) from the passed P8Request
     *
     * @return a string that look like:  {@code /index.php?get_action=action&param1=john&param2=doo}
     */
    protected String pathFromRequest(P8Request request) {

        StringBuilder builder = new StringBuilder(P8Server.API_PREFIX);
        appendParam(builder, P8Names.getAction, request.getAction());

        Iterator<Map.Entry<String, String>> it = request.getParams().get().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            andAppendEncodedParam(builder, entry.getKey(), entry.getValue());
        }

        for (HttpCookie c : cookieManager.getCookieStore().getCookies()) {
            andAppendEncodedParam(builder, P8Names.COOKIE_KEY, c.getValue());
        }

        return builder.toString();
    }

    private void populatePostBody(P8Request request, HttpURLConnection con) throws IOException, SDKException {

        String boundary = "----" + System.currentTimeMillis();
        con.setRequestProperty(P8Names.REQ_PROP_CONTENT_TYPE, "multipart/form-data; boundary=" + boundary);

        try (ByteArrayOutputStream partHeaderBuffer = new ByteArrayOutputStream()) {

            partHeaderBuffer.write(("--" + boundary).getBytes());
            partHeaderBuffer.write(LF);

            Iterator<Map.Entry<String, String>> it = request.getParams().get().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                String name = entry.getKey();
                String value = entry.getValue();
                partHeaderBuffer.write(("Content-Disposition: form-data; name=\"" + utf8Encode(name) + "\"").getBytes());
                partHeaderBuffer.write(LF);
                partHeaderBuffer.write(("Content-Type: text/plain; charset=utf-8").getBytes());
                partHeaderBuffer.write(DLF);
                partHeaderBuffer.write(value.getBytes(StandardCharsets.UTF_8));
                partHeaderBuffer.write(LF);
                partHeaderBuffer.write(("--" + boundary).getBytes());
                partHeaderBuffer.write(LF);
            }

            partHeaderBuffer.write(("Content-Disposition: form-data; name=\"userfile_0\"; filename=" + utf8Encode(request.getBody().getFilename())).getBytes());
            partHeaderBuffer.write(LF);
            partHeaderBuffer.write(("Content-Type: " + request.getBody().getContentType()).getBytes());

            partHeaderBuffer.write(DLF);
            byte[] partHeaderBytes = partHeaderBuffer.toByteArray();
            byte[] lastBoundaryBytes = ("\r\n--" + boundary + "--\r\n").getBytes();

            int rest = partHeaderBytes.length + lastBoundaryBytes.length;
            int contentSupposedBodyLength = (int) (request.getBody().maxChunkSize() - rest);
            int contentBodyActualLength = (int) Math.min(contentSupposedBodyLength, request.getBody().available());
            con.setFixedLengthStreamingMode(contentBodyActualLength + rest);

            OutputStream out = con.getOutputStream();
            out.write(partHeaderBytes);
            request.getBody().writeTo(out, contentBodyActualLength);
            out.write(lastBoundaryBytes);
        }
    }

    /* Local objects */

    private void appendParam(StringBuilder builder, String key, String value) {
        builder.append(key).append("=").append(value);
    }

    /* String manipulation Helpers */

    private void andAppendParam(StringBuilder builder, String key, String value) {
        builder.append("&").append(key).append("=").append(value);
    }

    private void andAppendEncodedParam(StringBuilder builder, String key, String value) {
        builder.append("&").append(key).append("=").append(utf8Encode(value));
    }

    private String utf8Encode(String value) {
        return encoder.utf8Encode(value);
    }


    private static class AuthInfo {
        private int seed = -1;
        private boolean withCaptcha = false;

        AuthInfo() {
        }
    }
}
