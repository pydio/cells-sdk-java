package com.pydio.sdk.integration;

public class TestClient {
}
/**
 * Utilitary class to centralise setup of a Cells client for testing purposes.
 */
//public class TestClient {
//
//    // You must adapt this file depending on your setup in "src/test/resources" to run the tests
//    private final String confPath = "/default-target-server.properties";
//
//    private ServerNode node;
//    private CellsClient cellsClient;
//    private CellsFs cellsFs;
//
//    private Path workingDirPath;
//
//    private String serverURLStr, login, pwd, workspace;
//
//    public void setup(StateManager stateManager) {
//
//        ServerURL httpsURL;
//
//
//        URL url = TestClient.class.getResource(confPath);
//        workingDirPath = Paths.get(url.getPath()).getParent();
//
//        Properties p = new Properties();
//        try (InputStream is = TestClient.class.getResourceAsStream(confPath)) {
//            p.load(new InputStreamReader(is));
//            serverURLStr = p.getProperty("serverURL");
//            login = p.getProperty("login");
//            pwd = p.getProperty("pwd");
//            workspace = p.getProperty("defaultWorkspace");
//
//        } catch (IOException e) {
//            System.out.println("could not retrieve configuration file, cause: ");
//            System.out.println(e);
//            return;
//        }
//
//        try {
//            httpsURL = ServerURLImpl.fromAddress(serverURLStr);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        // node = new ServerNodeImpl(httpsURL);
////
//        // Error error = node.resolve(serverURLStr);
//        // if (error != null) {
//        //     System.out.println("Could not resolve server URL, cause: ");
//        //     System.out.println(error);
//        // }
////
//        // cellsClient = new CellsClient(node);
//        // cellsClient.setCredentials(new PasswordCredentials(login, pwd));
//        // cellsClient.setSkipOAuthFlag(true);
////
//        // cellsFs = new CellsFs("test", cellsClient, workspace, stateManager);
//        cellsClient = null;
//        cellsFs =null;
//
//    }
//
//    public ServerNode getServerNode() {
//        return node;
//    }
//
//    public CellsClient getCellsClient() {
//        return cellsClient;
//    }
//
//    public String getDefaultWorkspace() {
//        return workspace;
//    }
//
//    public CellsFs getCellsFs() {
//        return cellsFs;
//    }
//
//    public Path getWorkingDir() {
//        return workingDirPath;
//    }
// }
