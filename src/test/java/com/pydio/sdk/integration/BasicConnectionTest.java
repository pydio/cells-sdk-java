package com.pydio.sdk.integration;

import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.auth.jwt.TokenMemoryStore;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.sync.tree.MemoryStateManager;
import com.pydio.sdk.sync.tree.StateManager;

import java.io.ByteArrayInputStream;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/config.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class BasicConnectionTest {

    private TestClient testClient;
    private StateManager stateManager;

    @Before
    public void setupServices() {
        TokenService.init(new TokenMemoryStore());
    }

    @Before
    public void setup() {
        stateManager = new MemoryStateManager();
        testClient = new TestClient();
        testClient.setup(stateManager);
    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testSimpleList() {
        try {
            if (testClient.getCellsClient() != null){
                System.out.println("... Test Cells Listing");
                String ws = testClient.getCellsDefaultWS();
                testClient.getCellsClient().ls(ws, "/",
                        null, (node) -> System.out.println(node.label()));
            }

            if (testClient.getP8Client() != null){
                System.out.println("... Test Pydio 8 Listing");
                String ws = testClient.getP8DefaultWS();
                testClient.getP8Client().ls(ws, "/",
                        null, (node) -> System.out.println(node.label()));
            }

        } catch (SDKException e) {
            e.printStackTrace();
        }
    }

    @Ignore("Enable after implementing crud from Java")
    @Test
    public void testBasicCRUD() {

        String ws = testClient.getCellsDefaultWS();
        // Skipped test: CRUD is not yet implemented from Java
        System.out.println("... Test Listing");
        try {
            testClient.getCellsClient().ls(ws, "/",
                    null, (node) -> System.out.println(node.label()));
        } catch (SDKException e) {
            e.printStackTrace();
        }

        System.out.println("... Test Upload");
        String targetDir = "/"; // root
        String name = "hello6.txt";
        byte[] content = "Hello Pydio!".getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);
        try {
            Message msg = testClient.getCellsClient().upload(source, content.length, ws, targetDir, name, true, (progress) -> {
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

}