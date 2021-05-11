package com.pydio.cells.legacy;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ILegacySession;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.client.ClientData;
import com.pydio.cells.client.auth.Token;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.utils.StateID;
import com.pydio.cells.legacy.consts.ActionNames;
import com.pydio.cells.legacy.consts.P8Names;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.pydio.cells.client.utils.StateID.utf8Encode;

public class P8Session implements ILegacySession, SdkNames {

    private TokenService tokens;
    // private final Map<String, CookieManager> cookieManagers = new ConcurrentHashMap<>();

    private final Server server;
    private final String username;

    private CookieManager cookieManager;

    private Credentials credentials;
    private int loginFailure;

    private Boolean useCaptcha;

    public P8Session(Server server, String username, CookieManager manager) {
        this.server = server;
        this.username = username;
        cookieManager = manager;
        loginFailure = 0;
    }

    public P8Session(Server server, String username) {
        this(server, username, new CookieManager());
    }

    public P8Session(Server server, Credentials c) throws SDKException {
        this(server, c.getLogin(), new CookieManager());
        if (c instanceof Credentials) {
            this.credentials = c;
        } else
            throw new RuntimeException("Unsupported P8 credential " + credentials.getClass().toString() + " for Pydio 8 server: " + server.getServerURL().getId());
    }

    @Deprecated
    public void setCredentials(Credentials c) {
        if (c instanceof Credentials) {
            this.credentials = c;
        } else
            throw new RuntimeException("Unsupported P8 credential " + credentials.getClass().toString() + " for Pydio 8 server: " + server.getServerURL().getId());
    }

    public void restore(TokenService tokens) throws SDKException {
        this.tokens = tokens;
        server.init();

        // P8 token never expire so it is much easier and good enough for legacy
        // to retrieve auth info and login at this point
        // and then always rely on the objects that are stored in memory.
        useCaptcha();
        login();

        // TODO more init
    }


    public String getId() {
        return new StateID(getUser(), getServer().getServerURL().getId()).getId();
    }

    public void setCookieManager(CookieManager man) {
        cookieManager = man;
    }


    @Override
    public Server getServer() {
        return server;
    }

    @Override
    public Client getClient() {
        return new P8Client(this);
    }

    @Override
    public boolean isOffline() {
        // TODO implement
        return false;
    }

    @Override
    public String getUserAgent() {
        // FIXME do we want to be able to override the default string ?
        // if (this.config.userAgent != null) {
        //     con.setRequestProperty("User-Agent", this.config.userAgent);
        // } else {
        return "Pydio-Native-" + ClientData.name + " " + ClientData.version + "." + ClientData.versionCode;
    }

    @Override
    public String getToken() throws SDKException {
        String secureToken = getSecureToken();
        if (null == secureToken || "".equals(secureToken)) {
            login();
            secureToken = getSecureToken();
        }
        return secureToken;
    }

    @Override
    public String getUser() {
        return username;
    }

    @Override
    public boolean useCaptcha() {
        if (useCaptcha != null) {
            return useCaptcha.booleanValue();
        }

        try {
            JSONObject info = authenticationInfo();
            useCaptcha = Boolean.valueOf(info.has(P8Names.captchaCode));
            return useCaptcha.booleanValue();
        } catch (SDKException se) {
            System.out.println("FIXME: Unexpected SDK error while checking if we use Captcha");
            se.printStackTrace();
        }
        return false;
    }


    @Override
    public HttpURLConnection openAnonConnection(String path) throws IOException {
        return server.newURL(path).openConnection();
    }


    @Override
    public HttpURLConnection openConnection(String path) throws IOException, SDKException {
        path = appendAuth(path);
        return withUserAgent(server.newURL(path).openConnection());
    }

    public String appendAuth(String path) throws SDKException {
        StringBuilder builder = new StringBuilder(path);
        builder.append("&");
        builder.append(P8Names.REQ_PROP_TOKEN);
        builder.append("=");
        builder.append(utf8Encode(getSecureToken()));
        return builder.toString();
    }

    /* Retrieved from server */

    @Override
    public InputStream getCaptcha() throws SDKException {
        P8Request request = new P8RequestBuilder().setAction(ActionNames.getCaptcha).getRequest();
        try (P8Response captchaResponse = execute(request)) {
            return captchaResponse.getInputStream();
        }
    }

    @Override
    public JSONObject authenticationInfo() throws SDKException {
        try (P8Response seedResponse = execute(P8RequestBuilder.getSeed().getRequest())) {
            String seed = seedResponse.asString();
            JSONObject o = new JSONObject();

            boolean withCaptcha = false;

            if (!"-1".equals(seed)) {
                seed = seed.trim();
                if (seed.contains("\"seed\":-1") || seed.contains("\"seed\": -1")) {
                    withCaptcha = seed.contains("\"captcha\": true") || seed.contains("\"captcha\":true");
                    o.put(P8Names.seed, "-1");
                } else {
                    String contentType = seedResponse.getHeaders("Content-Type").get(0);
                    boolean seemsToBePydio = (contentType != null) && (
                            (contentType.toLowerCase().contains("text/plain"))
                                    | (contentType.toLowerCase().contains("text/xml"))
                                    | (contentType.toLowerCase().contains("text/json"))
                                    | (contentType.toLowerCase().contains("application/json")));

                    if (!seemsToBePydio) {
                        throw SDKException.unexpectedContent(new IOException(seed));
                    }
                    o.put(P8Names.seed, "-1");
                }
            }

            if (withCaptcha) {
                o.put(P8Names.captchaCode, true);
            }
            return o;
        } catch (IOException ioe) {
            throw new SDKException(ioe);
        }
    }

    //  @Override
    //  public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {
    //      P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
    //      try (P8Response rsp = execute(builder.getRequest())) {
    //          if (rsp.code() != ErrorCodes.ok) {
    //              throw new SDKException(rsp.code());
    //          }
    //          final int code = rsp.saxParse(new ServerGeneralRegistrySaxHandler(itemHandler));
    //          if (code != ErrorCodes.ok) {
    //              throw new SDKException(code);
    //          }
    //      } catch (IOException ioe) {
    //          throw new SDKException(ioe);
    //      }
//
    //  }

    //   @Override
    //   public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {
    //       P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(getToken());
    //       try (P8Response rsp = execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
    //           if (rsp.code() != ErrorCodes.ok) {
    //               throw new SDKException(rsp.code());
    //           }
    //           final int code = rsp.saxParse(new RegistrySaxHandler(itemHandler));
    //           if (code != ErrorCodes.ok) {
    //               rsp.close();
    //               throw new SDKException(code);
    //           }
    //       } catch (IOException ioe) {
    //           throw new SDKException(ioe);
    //       }
    //   }

    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
        try (P8Response rsp = execute(builder.getRequest())) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.getInputStream();
        }
    }

//     @Override
//     public InputStream getWorkspaceRegistry(String ws) throws SDKException {
//         String secureToken = getSecureToken();
//         P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(secureToken);
//         try (P8Response rsp = execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
//             if (rsp.code() != ErrorCodes.ok) {
//                 throw new SDKException(rsp.code());
//             }
//             return rsp.getInputStream();
//         }
//     }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.workspaceList().setSecureToken(getSecureToken());
        try (P8Response rsp = execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            return rsp.getInputStream();
        }
    }

    @Override
    public InputStream getUserData(String binary) throws SDKException {
        P8Request req = P8RequestBuilder.getUserData(credentials.getLogin(), binary).setSecureToken(getSecureToken()).getRequest();
        try (P8Response rsp = execute(req)) {
            final int code = rsp.code();
            if (code != ErrorCodes.ok) {
                if (code == ErrorCodes.authentication_required && credentials != null && loginFailure == 0) {
                    loginFailure++;
                    login();
                    return getUserData(binary);
                }
                throw new SDKException(code);
            }
            return rsp.getInputStream();
        }
    }

    @Override
    public void login() throws SDKException {

        // FIXME not very clean.
        // In P8 token never expires, so we only need to login once.
        Token existingToken = tokens.get(this, getId());

        if (existingToken != null) {
            return;
        }
//        if (existingToken != null && !"".equals(existingToken))
//            return;

        if (credentials == null) {
            throw new SDKException(ErrorCodes.authentication_required);
        }

        P8RequestBuilder builder = P8RequestBuilder.login(credentials);
        P8Request req = builder.getRequest();

        try (P8Response rsp = execute(req)) {
            final int code = rsp.code();
            if (code != ErrorCodes.ok) {
                rsp.close();
                throw new SDKException(code);
            }

            Document doc = rsp.toXMLDocument();
            if (doc != null) {
                if (doc.getElementsByTagName("logging_result").getLength() > 0) {
                    String result = doc.getElementsByTagName("logging_result").item(0).getAttributes().getNamedItem("value").getNodeValue();
                    if (result.equals("1")) {
                        String secureToken = doc.getElementsByTagName("logging_result").item(0).getAttributes().getNamedItem(P8Names.secureToken).getNodeValue();
                        saveSecureToken(secureToken);
                        loginFailure = 0;
                    } else {
                        loginFailure++;
                        if (result.equals("-4")) {
                            throw new SDKException(ErrorCodes.authentication_with_captcha_required);
                        }
                        throw new SDKException(ErrorCodes.invalid_credentials,
                                new IOException("Could not log as " + credentials.getLogin() + "@" + getServer().url()));
                    }
                } else {
                    throw SDKException.unexpectedContent(new IOException("Cannot parse login response: " + doc.toString()));
                }
            } else {
                throw new SDKException(ErrorCodes.invalid_credentials);
            }
        }
    }

    @Override
    public void logout() throws SDKException {
        String secureToken = getSecureToken();
        P8Response response = execute(P8RequestBuilder.logout().setSecureToken(secureToken).getRequest());
        response.close();
    }

    @Override
    public JSONObject userInfo() throws SDKException {
        return null;
    }

    public P8Response execute(P8Request request) {

        try {
            switch (request.getMethod()) {
                case Method.get:
                    return doGet(request);
                case Method.post:
                    return doPost(request);
                case Method.put:
                    return doPut(request);
                default:
                    throw new RuntimeException("Unsupported method type: " + request.getMethod());
            }
        } catch (IOException ioe) {
            // FIXME temporary
            System.out.println("#######   Could not execute " + ioe.getMessage());
            ioe.printStackTrace();
            // TODO finer management needed here
            return P8Response.error(ErrorCodes.con_failed);
        }

    }

    public P8Response execute(P8Request request, RetryCallback retry, int code) {
        P8Response response = execute(request);
        final int c = response.code();
        if (c == code) {
            response.close();
            P8Request retryRequest = retry.update(request);
            if (retryRequest != null) {
                response = execute(retryRequest);
            }
        }
        return response;
    }

    /* HTTP Methods */

    private P8Response doGet(P8Request request) throws IOException {

        StringBuilder builder = new StringBuilder(P8Server.API_PREFIX);
        appendParam(builder, P8Names.getAction, request.getAction());

        ServerURL currURL = null;
        try {
            currURL = server.newURL(builder.toString());
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + builder.toString(), mue);
        }

        HttpURLConnection con = currURL.openConnection();
        withUserAgent(con);

        // c.setSSLSocketFactory(config.sslContext.getSocketFactory());
        // c.setHostnameVerifier(config.hostnameVerifier);

        con.setRequestMethod("GET");
        P8Response response = new P8Response(con);
        storeReturnedSetCookies(con.getHeaderFields());

        return response;
    }

    private P8Response doPost(P8Request request) throws IOException {

        // Prepare query
        StringBuilder builder = new StringBuilder(P8Server.API_PREFIX);
        appendParam(builder, P8Names.getAction, request.getAction());

        ServerURL currURL = null;
        try {
            currURL = server.newURL(builder.toString());
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + builder.toString(), mue);
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
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            con.setRequestProperty(P8Names.REQ_PROP_CONTENT_LENGTH, String.valueOf(postDataBytes.length));
            con.setRequestProperty(P8Names.REQ_PROP_CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");

            OutputStream out = con.getOutputStream();
            out.write(postDataBytes);
        }

        P8Response response = new P8Response(con);
        storeReturnedSetCookies(con.getHeaderFields());
        return response;
    }

    private P8Response doPut(P8Request request) throws IOException {

        // Build effective URL request
        String queryStr = pathFromRequest(request);

        ServerURL currURL = null;
        try {
            currURL = server.newURL(queryStr);
        } catch (MalformedURLException mue) {
            throw new RuntimeException("Unexpected Malformed URL for path: " + queryStr, mue);
        }

        HttpURLConnection con = currURL.openConnection();
        con.setDoOutput(true);

        // TODO remove: useless, or we will get an exception here
        if (con == null) {
            return P8Response.error(ErrorCodes.con_failed);
        }

        con.setRequestMethod("PUT");
        if (!request.getIgnoreCookies()) {
            withCookies(con);
        }
        withReqProp(con, P8Names.REQ_PROP_CONTENT_TYPE, P8Names.CONTENT_TYPE_OCTET_STREAM);
        withUserAgent(con);

        // Handle the response
        OutputStream out = con.getOutputStream();
        storeReturnedSetCookies(con.getHeaderFields());
        request.getBody().writeTo(out);
        P8Response response = new P8Response(con);

        return response;
    }

    /**
     * Simply generate the full path (**file** + query) from the passed P8Request
     *
     * @return a string that look like:  "/index.php?get_action=action&param1=john&param2=doo"
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

    private final byte[] LF = "\r\n".getBytes();
    private final byte[] DLF = "\r\n\r\n".getBytes();

    private void populatePostBody(P8Request request, HttpURLConnection con) throws IOException {

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
                partHeaderBuffer.write(value.getBytes("UTF-8"));
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


    private HttpURLConnection withCookies(HttpURLConnection con) {
        List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
        if (cookies.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (HttpCookie cookie : cookies) {
                builder.append(";").append(cookie.toString());
            }
            con.setRequestProperty(P8Names.REQ_PROP_COOKIE, builder.substring(1));
        }
        return con;
    }

    private HttpURLConnection withUserAgent(HttpURLConnection con) {
        con.setRequestProperty(P8Names.REQ_PROP_USER_AGENT, getUserAgent());
        return con;
    }

    private HttpURLConnection withReqProp(HttpURLConnection con, String key, String value) {
        con.setRequestProperty(key, value);
        return con;
    }

    private void storeReturnedSetCookies(Map<String, List<String>> headerFields) {
        List<String> cookiesHeader = headerFields.get(P8Names.HEADER_SET_COOKIE);
        if (cookiesHeader != null) {
            for (String cookie : cookiesHeader) {
                List<HttpCookie> cs = HttpCookie.parse(cookie);
                for (HttpCookie hc : cs) {
                    cookieManager.getCookieStore().add(null, hc);
                }
            }
        }
    }

    /**
     * Token Management
     */

    private P8Request refreshSecureToken(P8Request req) {
        try {
            JSONObject info = authenticationInfo();
            if (!info.has(P8Names.captchaCode)) {
                login();
                String secureToken = getSecureToken();
                return P8RequestBuilder.update(req).setSecureToken(secureToken).getRequest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveSecureToken(String secureToken) {
        Token t = new Token();
        t.subject = getId();
        t.value = secureToken;
        t.expirationTime = -1;
        tokens.register(getId(), t);
    }

    private String getSecureToken() throws SDKException {
        String id = getId();
        Token t = tokens.get(this, id);

        if (t == null) {
            System.out.println("No token found for " + id + ", about to background login.");
            login();
            t = tokens.get(this, id);
        }

        return t.value;
    }

    /* String manipulation Helpers */

//    private String getTokenId() {
//        String tokenID = secureTokens.get(getId());
//        if (tokenID != null && !"".equals(tokenID)){
//            return tokenID;
//        }
//
//        if (credentials != null){
//
//        }
//        return credentials.getLogin() + "@" + server.getServerURL().getId();
//    }

    private StringBuilder appendParam(StringBuilder builder, String key, String value) {
        builder.append(key).append("=").append(value);
        return builder;
    }

    private StringBuilder andAppendParam(StringBuilder builder, String key, String value) {
        builder.append("&").append(key).append("=").append(value);
        return builder;
    }

    private StringBuilder appendEncodedParam(StringBuilder builder, String key, String value) {
        builder.append(key).append("=").append(utf8Encode(value));
        return builder;
    }

    private StringBuilder andAppendEncodedParam(StringBuilder builder, String key, String value) {
        builder.append("&").append(key).append("=").append(utf8Encode(value));
        return builder;
    }

}
