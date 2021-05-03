package com.pydio.sdk.core;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.ILegacySession;
import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.SdkNames;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.callbacks.RegistryItemHandler;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.api.nodes.WorkspaceNode;
import com.pydio.sdk.core.model.parser.RegistrySaxHandler;
import com.pydio.sdk.core.model.parser.ServerGeneralRegistrySaxHandler;
import com.pydio.sdk.generated.p8.Configuration;
import com.pydio.sdk.generated.p8.P8Request;
import com.pydio.sdk.generated.p8.P8RequestBuilder;
import com.pydio.sdk.generated.p8.P8Response;
import com.pydio.sdk.generated.p8.consts.Action;
import com.pydio.sdk.generated.p8.consts.Param;

import org.json.JSONObject;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jdk.internal.net.http.common.Log;

public class P8Session implements ILegacySession, SdkNames {

    private final static Map<String, String> secureTokens = new ConcurrentHashMap<>();
    private final static Map<String, CookieManager> cookieManagers = new ConcurrentHashMap<>();

    private final Server server;
    private final com.pydio.sdk.generated.p8.P8Client p8;
    private Credentials credentials;
    private int loginFailure;

    public P8Session(Server server) {
        this.server = server;
        loginFailure = 0;

        p8 = new com.pydio.sdk.generated.p8.P8Client(this);
    }


    @Override
    public Server getServerNode() {
        return server;
    }

    @Override
    public Client getClient() {
        return new CellsClient(this);
    }

    private P8Request refreshSecureToken(P8Request req) {
        try {
            JSONObject info = authenticationInfo();
            if (!info.has(Param.captchaCode)) {
                login();
                String secureToken = getSecureToken();
                return P8RequestBuilder.update(req).setSecureToken(secureToken).getRequest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getToken() throws SDKException {
        String secureToken = getSecureToken();
        if (null == secureToken || "".equals(secureToken)) {
            login();
            secureToken = getSecureToken();
        }
        return  secureToken;
    }

    @Override
    public boolean isOffline() {
        // TODO implement
        return false;
    }

    @Override
    public Map<String, WorkspaceNode> getCachedWorkspaces() {
        // TODO implement
        return null;
    }

    @Override
    public boolean useCaptcha() {
        try {
            JSONObject info = authenticationInfo();
            return info.has(Param.captchaCode);
        } catch (SDKException se){
            Log.logError("FIXME: Unexpected SDK error while checking if we use Captcha", se);
            se.printStackTrace();
        }
        return  false;
    }



    //private void loadSecureToken() throws SDKException {
    //    String secureToken = getSecureToken();
    //    if (null == secureToken || "".equals(secureToken)) {
    //        login();
    //    }
    //}

    private void saveSecureToken(String secureToken) {
        String id = credentials.getLogin() + "@" + server.getServerURL().getId();
        secureTokens.put(id, secureToken);
    }

    private String getSecureToken() {
        String id = credentials.getLogin() + "@" + server.getServerURL().getId();
        return secureTokens.get(id);
    }

    private CookieManager getCookieManager() {
        String id = credentials.getLogin() + "@" + server.getServerURL().getId();
        CookieManager cm = cookieManagers.get(id);
        if (cm == null) {
            cm = new CookieManager();
            cookieManagers.put(id, cm);
        }
        return cm;
    }

    @Override
    public String getUserAgent() {
        return null;
    }

    @Override
    public void setCredentials(Credentials c) {
        this.credentials = c;
        CookieManager cookieManager = getCookieManager();
        p8.setCookieManager(cookieManager);
    }

    @Override
    public void setSkipOAuthFlag(boolean skipOAuth) {

    }

    @Override
    public String getUser() {
        return this.credentials.getLogin();
    }

    @Override
    public InputStream getUserData(String binary) throws SDKException {
        String secureToken = getSecureToken();
        P8Request req = P8RequestBuilder.getUserData(credentials.getLogin(), binary).setSecureToken(secureToken).getRequest();
        try (P8Response rsp = p8.execute(req)) {
            final int code = rsp.code();
            if (code != ErrorCodes.ok) {
                if (code == ErrorCodes.authentication_required && credentials != null && loginFailure == 0) {
                    loginFailure++;
                    login();
                    return getUserData(binary);
                }
                throw new SDKException(code);
            }
            return rsp.getContent();
        }
    }

    @Override
    public void login() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.login(credentials);
        P8Request req = builder.getRequest();

        try (P8Response rsp = p8.execute(req)) {
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
                        String secureToken = doc.getElementsByTagName("logging_result").item(0).getAttributes().getNamedItem(Param.secureToken).getNodeValue();
                        this.saveSecureToken(secureToken);
                        loginFailure = 0;
                    } else {
                        loginFailure++;
                        if (result.equals("-4")) {
                            rsp.close();
                            throw new SDKException(ErrorCodes.authentication_with_captcha_required);
                        }
                        rsp.close();
                        throw new SDKException(ErrorCodes.authentication_required);
                    }
                } else {
                    rsp.close();
                    throw SDKException.unexpectedContent(new IOException(doc.toString()));
                }
            } else {
                rsp.close();
                throw new SDKException(ErrorCodes.authentication_required);
            }
        }
    }

    @Override
    public void logout() {
        String secureToken = getSecureToken();
        P8Response response = p8.execute(P8RequestBuilder.logout().setSecureToken(secureToken).getRequest());
        response.close();
    }

    @Override
    public JSONObject userInfo() throws SDKException {
        return null;
    }

    @Override
    public X509Certificate[] remoteCertificateChain() {
        return new X509Certificate[0];
    }

    @Override
    public void downloadServerRegistry(RegistryItemHandler itemHandler) throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
        try (P8Response rsp = p8.execute(builder.getRequest())) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            final int code = rsp.saxParse(new ServerGeneralRegistrySaxHandler(itemHandler));
            if (code != ErrorCodes.ok) {
                throw new SDKException(code);
            }
        }
    }

    @Override
    public void downloadWorkspaceRegistry(String ws, RegistryItemHandler itemHandler) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(secureToken);
        try (P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required)) {
            if (rsp.code() != ErrorCodes.ok) {
                throw new SDKException(rsp.code());
            }
            final int code = rsp.saxParse(new RegistrySaxHandler(itemHandler));
            if (code != ErrorCodes.ok) {
                rsp.close();
                throw new SDKException(code);
            }
        }
    }

    @Override
    public InputStream getServerRegistryAsNonAuthenticatedUser() throws SDKException {
        P8RequestBuilder builder = P8RequestBuilder.serverRegistry();
        P8Response rsp = p8.execute(builder.getRequest());
        if (rsp.code() != ErrorCodes.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public InputStream getWorkspaceRegistry(String ws) throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceRegistry(ws).setSecureToken(secureToken);
        P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required);
        if (rsp.code() != ErrorCodes.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public InputStream getServerRegistryAsAuthenticatedUser() throws SDKException {
        String secureToken = getSecureToken();
        P8RequestBuilder builder = P8RequestBuilder.workspaceList().setSecureToken(secureToken);
        P8Response rsp = p8.execute(builder.getRequest(), this::refreshSecureToken, ErrorCodes.authentication_required);
        if (rsp.code() != ErrorCodes.ok) {
            throw new SDKException(rsp.code());
        }
        return rsp.getContent();
    }

    @Override
    public InputStream getCaptcha() {
        P8Request request = new P8RequestBuilder().setAction(Action.getCaptcha).getRequest();
        return p8.execute(request).getContent();
    }

    @Override
    public JSONObject authenticationInfo() throws SDKException {
        try (P8Response seedResponse = p8.execute(P8RequestBuilder.getSeed().getRequest())) {
            String seed = seedResponse.toString();
            JSONObject o = new JSONObject();

            boolean withCaptcha = false;

            if (!"-1".equals(seed)) {
                seed = seed.trim();
                if (seed.contains("\"seed\":-1") || seed.contains("\"seed\": -1")) {
                    withCaptcha = seed.contains("\"captcha\": true") || seed.contains("\"captcha\":true");
                    o.put(Param.seed, "-1");

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
                    o.put(Param.seed, "-1");
                }
            }

            if (withCaptcha) {
                o.put(Param.captchaCode, true);
            }
            return o;
        }
    }

}
