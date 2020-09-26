package com.pydio.sdk.integration;

import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.sync.fs.CellsFs;
import com.pydio.sdk.examples.Credentials;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.pydio.sdk.sync.tree.StateManager;
import com.pydio.sdk.core.CellsClient;

/**
 * Utilitary class to centralise setup of a Cells client for testing purposes.
 */
public class TestClient {

    private ServerNode node;
    private CellsClient cellsClient;
    private CellsFs cellsFs;

    private Path workingDirPath;

    private String serverURL, login, pwd, workspace;

    public void setup(StateManager stateManager) {

        URL url = TestClient.class.getResource("/config.properties");
        workingDirPath = Paths.get(url.getPath()).getParent();

        Properties p = new Properties();
        try (InputStream is = TestClient.class.getResourceAsStream("/config.properties")) {
            p.load(new InputStreamReader(is));
            serverURL = p.getProperty("serverURL");
            login = p.getProperty("login");
            pwd = p.getProperty("pwd");
            workspace = p.getProperty("defaultWorkspace");
        } catch (IOException e) {
            System.out.println("could not retrieve configuration file, cause: ");
            System.out.println(e);
            return;
        }

        node = new ServerNode();
        Error error = node.resolve(serverURL);
        if (error != null) {
            System.out.println("Could not resolve server URL, cause: ");
            System.out.println(error);
        }

        cellsClient = new CellsClient(node);
        cellsClient.setCredentials(new Credentials(login, pwd));
        cellsClient.setSkipOAuthFlag(true);

        cellsFs = new CellsFs("test", cellsClient, workspace, stateManager);

    }

    public ServerNode getServerNode() {
        return node;
    }

    public CellsClient getCellsClient() {
        return cellsClient;
    }

    public String getDefaultWorkspace() {
        return workspace;
    }

    public CellsFs getCellsFs() {
        return cellsFs;
    }

    public Path getWorkingDir() {
        return workingDirPath;
    }

 
}