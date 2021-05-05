package com.pydio.sdk.integration;

import com.pydio.sdk.core.Pydio8;
import com.pydio.sdk.core.PydioCells;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.auth.jwt.TokenMemoryStore;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.examples.Credentials;
import com.pydio.sdk.sync.fs.CellsFs;
import com.pydio.sdk.sync.tree.StateManager;

import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Utilitary class to centralise setup of a Cells client for testing purposes.
 */
public class TestClient {

    private Path workingDirPath;

    private ServerNode node;
    private PydioCells cellsClient;
    private String serverURL, login, pwd, workspace;
    private CellsFs cellsFs;

    private ServerNode p8Node;
    private Pydio8 p8Client;
    private String p8ServerURL, p8Login, p8Pwd, p8DefaultWS;

    @Before
    public void setupServices() {
        TokenService.init(new TokenMemoryStore());
    }

    public void setup(StateManager stateManager) {
        URL url = TestClient.class.getResource("/config.properties");
        workingDirPath = Paths.get(url.getPath()).getParent();

        initCellsClient();
        initP8Client();
    }

    private void initP8Client() {
        System.out.println("... Initialise Pydio 8 client");
        Properties p = new Properties();
        try (InputStream is = TestClient.class.getResourceAsStream("/p8config.properties")) {
            p.load(new InputStreamReader(is));
            p8ServerURL = p.getProperty("serverURL");
            p8Login = p.getProperty("login");
            p8Pwd = p.getProperty("pwd");
            p8DefaultWS = p.getProperty("defaultWorkspace");
            if (p8DefaultWS != null && !"".equals(p8DefaultWS)) {
                p8Node = new ServerNode();
                Error error = p8Node.resolve(p8ServerURL);
                if (error != null) {
                    System.out.println("Could not resolve server URL, cause: ");
                    System.out.println(error);
                }
                p8Client = new Pydio8(p8Node);
                p8Client.setCredentials(new Credentials(p8Login, p8Pwd));

                System.out.println("Pydio 8 server found and initialised");
            }
        } catch (Exception e) {
            System.out.println("could not retrieve Pydio8 configuration file, cause: ");
            System.out.println(e);
            p8Client = null;
        }
    }

    private void initCellsClient() {
        System.out.println("... Initialise Cells client");

        Properties p = new Properties();
        try (InputStream is = TestClient.class.getResourceAsStream("/config.properties")) {
            p.load(new InputStreamReader(is));
            serverURL = p.getProperty("serverURL");
            login = p.getProperty("login");
            pwd = p.getProperty("pwd");
            workspace = p.getProperty("defaultWorkspace");
            if (workspace != null && !"".equals(workspace)) {

                node = new ServerNode();
                Error error = node.resolve(serverURL);
                if (error != null) {
                    System.out.println("Could not resolve server URL, cause: " + error.code);
                }

                cellsClient = new PydioCells(node);
                cellsClient.setCredentials(new Credentials(login, pwd));
                cellsClient.setSkipOAuthFlag(true);

                // cellsFs = new CellsFs("test", cellsClient, workspace, stateManager);
                System.out.println("Cells server found and initialised");
            }
        } catch (Exception e) {
            System.out.println("Could not initialise Cells client, cause: " + e);
            cellsClient = null;
        }
    }


    public PydioCells getCellsClient() {
        return cellsClient;
    }

    public String getCellsDefaultWS() {
        return workspace;
    }


    public Pydio8 getP8Client() {
        return p8Client;
    }

    public String getP8DefaultWS() {
        return p8DefaultWS;
    }

    public CellsFs getCellsFs() {
        return cellsFs;
    }

    public Path getWorkingDir() {
        return workingDirPath;
    }

}