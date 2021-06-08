package com.pydio.cells.utils.tests;

import com.pydio.cells.utils.Log;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Utilitary class to centralise test configuration retrieval.
 */
public class TestConfiguration {

    private final Map<String, RemoteServerConfig> servers = new HashMap<>();
    private final String defaultServerConfigId = "default-target-server";

    // You must adapt these files to your setup in "src/test/resources" to run the tests
    private final String defaultServerConfigPath = "/" + defaultServerConfigId + ".properties";
    private final String variantFolderPath = "/servers";
    private final Path resourceDirPath;

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
            File f = new File(url.toURI());
            FilenameFilter filter = (f1, name) -> name.endsWith(".properties");

            for (String currName : f.list(filter)) {
                loadOne(currName.substring(0, currName.lastIndexOf('.')), variantFolderPath + "/" + currName);
            }

        } catch (Exception e) {
            Log.e("Initialisation", "Could not load additional server configuration at " + variantFolderPath);
            e.printStackTrace();
        }
    }


    public RemoteServerConfig getServer(String id) {
        return servers.get(id);
    }

    public RemoteServerConfig getDefaultServer() {
        return servers.get(defaultServerConfigId);
    }

    public Map<String, RemoteServerConfig> getDefinedServers() {
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

            RemoteServerConfig currConf = new RemoteServerConfig();
            currConf.serverURL = p.getProperty("serverURL");
            currConf.login = p.getProperty("login");
            currConf.pwd = p.getProperty("pwd");
            currConf.defaultWS = p.getProperty("defaultWorkspace");
            currConf.skipVerify = "true".equals(p.getProperty("skipVerify"));

            servers.put(id, currConf);
        } catch (IOException e) {
            Log.e("Initialisation", "Could not retrieve configuration file, cause: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
