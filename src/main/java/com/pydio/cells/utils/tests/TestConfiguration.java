package com.pydio.cells.utils.tests;

import com.pydio.cells.utils.Log;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Simply retrieve test sessions from properties files that are in user-defined folders.
 * By default in the resources folder of the calling class.
 */
public class TestConfiguration {

    // You must adapt these files to your setup in "src/test/resources"
    // to use the default configuration
    private static final String defaultServerConfigId = "default";
    private static final String accountFolder = "/accounts";

    private final Map<String, RemoteServerConfig> accounts = new HashMap<>();

    public static TestConfiguration getDefault() {

        URL url = TestConfiguration.class.getResource(accountFolder);
        return new TestConfiguration(url);
    }


    public TestConfiguration() {

    }

    public TestConfiguration(URL localURL) {

        try {
            File f = new File(localURL.toURI());
            FilenameFilter filter = (f1, name) -> name.endsWith(".properties");
            for (String currName : f.list(filter)) {
                loadOne(currName.substring(0, currName.lastIndexOf('.')), accountFolder + "/" + currName);
            }
        } catch (Exception e) {
            Log.e("Initialisation", "Could not load server configuration at " + accountFolder);
            e.printStackTrace();
        }
    }

    public RemoteServerConfig getServer(String id) {
        return accounts.get(id);
    }

    public RemoteServerConfig getDefaultServer() {
        return accounts.get(defaultServerConfigId);
    }

    public Map<String, RemoteServerConfig> getDefinedServers() {
        return accounts;
    }

    // public Path getWorkingDir() {
//        return resourceDirPath;
//    }

    /* Local helpers */

    private void loadOne(String id, String path) {
        try (InputStream is = TestConfiguration.class.getResourceAsStream(path)) {
            loadOne(id, is);
        } catch (IOException e) {
            Log.e("Initialisation", "Could not retrieve configuration file, cause: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadOne(String id, InputStream inputStream) throws IOException {
        Properties p = new Properties();
        p.load(new InputStreamReader(inputStream));
        if ("true".equals(p.getProperty("skipServer"))) {
            return;
        }

        RemoteServerConfig currConf = new RemoteServerConfig();
        currConf.serverURL = p.getProperty("serverURL");
        currConf.username = p.getProperty("username");
        currConf.pwd = p.getProperty("pwd");
        currConf.pat = p.getProperty("pat");
        currConf.defaultWS = p.getProperty("defaultWorkspace");
        currConf.skipVerify = "true".equals(p.getProperty("skipVerify"));

        accounts.put(id, currConf);
    }

}
