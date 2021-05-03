package com.pydio.sdk.integration;

import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.ServerURL;
import com.pydio.sdk.core.CellsSession;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.model.CellsServer;
import com.pydio.sdk.core.security.PasswordCredentials;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Utilitary class to centralise test configuration retrieval.
 */
public class TestConfiguration {

    protected class ServerConfig {
        public String serverURL;
        public String login;
        public String pwd;
        public String defaultWS;
        public boolean skipVerify;
    }

    private Map<String, ServerConfig> servers = new HashMap<>();
    private final String defaultServerConfigId = "default-target-server";

    // You must adapt these files to your setup in "src/test/resources" to run the tests
    private final String defaultServerConfigPath = "/" + defaultServerConfigId + ".properties";

    private final String variantFolderPath = "/servers";

    final private Path resourceDirPath;

    private String serverURLStr, login, pwd, workspace;

    public TestConfiguration() {
        URL url = TestConfiguration.class.getResource(defaultServerConfigPath);
        resourceDirPath = Paths.get(url.getPath()).getParent();
        setup();
    }

    public void setup() {

        // Load default
        loadOne("default", defaultServerConfigPath);

        // Also loads all servers that are not explicitly skipped in servers subfolder
        try {
            URL url = TestConfiguration.class.getResource(variantFolderPath);
            List<String> paths;
            File f = new File(url.toURI());
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File f, String name) {
                    return name.endsWith(".properties");
                }
            };

            for (String currName : f.list(filter)) {
                loadOne(currName.substring(0, currName.lastIndexOf('.')), variantFolderPath + "/" + currName);
            }

        } catch (Exception e) {
            System.out.println("could not load additional server confs at " + variantFolderPath);
            System.out.println(e);
        }
    }

    // TODO refactorize and finalize this
    public ISession openSession(TokenService tokenService, ServerURL serverURL, String login, String pwd) throws SDKException {
        Server backend = new CellsServer(serverURL);
        CellsSession session = new CellsSession(backend, login);
        session.restore(tokenService);
        tokenService.legacyLogin(session, new PasswordCredentials(login, pwd));
        return session;
    }

    public ServerConfig getServer(String id) {
        return servers.get(id);
    }

    public ServerConfig getDefaultServer() {
        return servers.get(defaultServerConfigId);
    }

    public Map<String, ServerConfig> getDefinedServers() {
        return servers;
    }

    public Path getWorkingDir() {
        return resourceDirPath;
    }

    /* Local helpers */

    private void loadOne(String id, String path) {
        Properties p = new Properties();
        try (InputStream is = TestConfiguration.class.getResourceAsStream(path)) {
            p.load(new InputStreamReader(is));

            if ("true".equals(p.getProperty("skipServer"))) {
                return;
            }

            ServerConfig currConf = new ServerConfig();
            currConf.serverURL = p.getProperty("serverURL");
            currConf.login = p.getProperty("login");
            currConf.pwd = p.getProperty("pwd");
            currConf.defaultWS = p.getProperty("defaultWorkspace");
            currConf.skipVerify = "true".equals(p.getProperty("skipVerify"));

            servers.put(id, currConf);
        } catch (IOException e) {
            System.out.println("could not retrieve configuration file, cause: ");
            System.out.println(e);
            return;
        }
    }

}
