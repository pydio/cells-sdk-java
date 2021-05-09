package com.pydio.sdk.integration;

import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.auth.jwt.TokenMemoryStore;
import org.junit.After;
import org.junit.Before;

import com.pydio.cells.sync.tree.StateManager;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default-target-server.properties" file to match your setup.
 * 
 * You can then launch the test with:
 * 
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class GetChangesTest {

    private TestClient testClient;
    private StateManager stateManager;
    private CecWrapper cec;

    private TokenService tokens;
    private TestConfiguration config;

    @Before
    public void setup() {
        tokens = new TokenService(new TokenMemoryStore());
        config = new TestConfiguration();

        cec = new CecWrapper();
        cec.setUpCec();
    }

    @After
    public void teardown() {
        // do nothing
    }

    /*

    FIXME This must be completely adapted after refactoring
    @Ignore
    @Test
    public void testSimpleChange() {

        TestConfiguration.ServerConfig conf = config.getDefaultServer();

        try {
            ServerURL sURL = ServerURLImpl.fromAddress(conf.serverURL);
            ISession session = config.openSession(tokens, sURL, conf.login, conf.pwd);

            String ws = conf.defaultWS;
            final String basePath = TestUtils.getUniquePath();
            CellsClient client = (CellsClient)session.getClient();

            // Insure there is nothing at this path
            try {
                client.ls(ws, "/" + basePath, null, (node) -> System.out.println(node.getLabel()));
                Assert.fail("We expect a not found exception at " + basePath + ". Exiting...");
            } catch (SDKException e) {
                // Expected. Do nothing.
            }

            // Test GetChanges on a non existing folder
            TreeMap<String, Change> changes = testClient.getCellsFs().getRawChanges(basePath);
            Assert.assertEquals(changes.size(), 0);

            // Create a basic tree
            String basePrefix = ws + "/" + basePath + "/test";
            String fullPrefix = "cells://" + basePrefix;
            cec.callCommand("mkdir", "-p", basePrefix);

            String localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo1.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), fullPrefix);
            localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo2.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), fullPrefix);
            localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo3.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), fullPrefix);

            cec.callCommand("ls", basePrefix);

            System.out.println("In tests simple change B4 getting the changes");

            changes = testClient.getCellsFs().getRawChanges(basePath);

            System.out.println("... Retrieved " + changes.size() + " changes");

            Assert.assertTrue(changes.size() == 4);
            Assert.assertTrue(changes.get(changes.firstKey()).getType() == Change.TYPE_CREATE);

            // Stores in state manager
            TestUtils.dummyProcessChanges(stateManager, changes);

            // Insure the changes have been correctly stored and the next occurence of the
            // method returns no change
            changes = testClient.getCellsFs().getRawChanges(basePath);
            Assert.assertTrue(changes.size() == 0);

            // Delete one node and insure the change is detected
            cec.callCommand("rm", "-f", basePrefix + "/Logo1.png");
            changes = testClient.getCellsFs().getRawChanges(basePath);
            Assert.assertTrue(changes.size() == 2); //
            Assert.assertTrue(changes.get(basePrefix + "/Logo1.png") != null);
            Assert.assertTrue(changes.get(basePrefix + "/Logo1.png").getType() == Change.TYPE_DELETE);
            TestUtils.dummyProcessChanges(stateManager, changes);

            // TODO: implement move of a file, of a folder and update of a file

            // Clean current workspace
            cec.callCommand("rm", "-f", basePrefix);

        } catch (Exception e) {
            System.out.println("Simple change test as failed with an exception: ");
            e.printStackTrace();
            System.out.println("==========================");
            Assert.fail("Simple change test failed. See stack above");
        }
    }

    @Ignore("Enable after implementing crud from Java")
    @Test
    public void testBasicCRUD() {

        String ws = testClient.getDefaultWorkspace();
        // Skipped test: CRUD is not yet implemented from Java
        System.out.println("... Test Listing");
        try {
            testClient.getCellsClient().ls(ws, "/", null, (node) -> System.out.println(node.getLabel()));
        } catch (SDKException e) {
            e.printStackTrace();
        }

        System.out.println("... Test Upload");
        String targetDir = "/"; // root
        String name = "hello6.txt";
        byte[] content = "Hello Pydio!".getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);
        try {
            Message msg = testClient.getCellsClient().upload(source, content.length, ws, targetDir, name, true,
                    (progress) -> {
                        System.out.printf("\r%d bytes written\n", progress);
                        return false;
                    });
            if (msg == null)
                System.out.println("After upload, no message.");
            else
                System.out.println("After upload, message: " + msg.message);
        } catch (SDKException e) {
            e.printStackTrace();
        }

        // TODO finish implementing the CRUD and corresponding checks. Typically, for
        // the time being upload fails silently.
    }

    */

}