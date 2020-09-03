package com.pydio.sdk.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.Assert;

import com.pydio.sdk.core.PydioCells;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Change;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.sync.tree.MemoryStateManager;
import com.pydio.sdk.sync.tree.StateManager;

import java.io.ByteArrayInputStream;
import java.nio.file.Paths;
import java.util.TreeMap;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/config.properties" file to match your setup.
 * 
 * You can then launch the test with:
 * 
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class GetChangesTest {

    private TestClient testClient;
    private StateManager stateManager;
    private CecWrapper cec;

    @Before
    public void setup() {
        stateManager = new MemoryStateManager();
        testClient = new TestClient();
        testClient.setup(stateManager);

        cec = new CecWrapper();
        cec.setUpCec();
    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testSimpleChange() {

        try {

            String ws = testClient.getDefaultWorkspace();
            final String basePath = testClient.getUniquePath();
            PydioCells client = testClient.getCellsClient();

            // Insure there is nothing at this path
            try {
                client.ls(ws, "/" + basePath, (node) -> System.out.println(node.label()));
                Assert.fail("We expect a not found exception at " + basePath + ". Exiting...");
            } catch (SDKException e) {
                // Expected. Do nothing.
            }

            // Test GetChanges on a non existing folder
            TreeMap<String, Change> changes = testClient.getCellsFs().getRawChanges(basePath);
            Assert.assertEquals(changes.size(), 0);

            // Create a basic tree
            String currPrefix = ws + "/" + basePath + "/test";
            String targetPrefix = "cells://" + currPrefix;
            cec.callCommand("mkdir", "-p", currPrefix);

            String localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo1.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), targetPrefix);
            localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo2.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), targetPrefix);
            localPath = Paths.get(testClient.getWorkingDir().toString(), "images", "Logo3.png").toString();
            cec.callCommand("scp", "-q", localPath.toString(), targetPrefix);

            cec.callCommand("ls", currPrefix);

            changes = testClient.getCellsFs().getRawChanges(basePath);
            Assert.assertTrue(changes.size() == 4);

            // Clean current workspace
            cec.callCommand("rm", "-f", currPrefix);

        } catch (Exception e) {
            Assert.fail("Simple change test throws an error");
            e.printStackTrace();
        } catch (SDKException e) {
            Assert.fail("Simple change test throws an error");
            e.printStackTrace();
        }
    }

    @Ignore("Enable after implementing crud from Java")
    @Test
    public void testBasicCRUD() {

        String ws = testClient.getDefaultWorkspace();
        // Skipped test: CRUD is not yet implemented from Java
        System.out.println("... Test Listing");
        try {
            testClient.getCellsClient().ls(ws, "/", (node) -> System.out.println(node.label()));
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

}