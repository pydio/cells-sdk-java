package com.pydio.cells.integration;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Node;
import com.pydio.cells.client.TestSessionFactory;
import com.pydio.cells.transport.auth.SimpleTokenStore;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.transport.ServerURLImpl;
import com.pydio.cells.transport.StateID;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default-target-server.properties" file to match your
 * setup.
 * <p>
 * You can then launch the test with:
 * <p>
 * {@code ./gradlew build -Dtest.profile=integration}
 */
public class BasicConnectionTest {

    private TestSessionFactory factory;
    private TestConfiguration config;
    private String testRunID;

    @Before
    public void setup() {
        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new TestSessionFactory(tokens);
        config = new TestConfiguration();
    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testSimpleCRUD() throws SDKException, IOException {
        Map<String, RemoteServerConfig> servers = config.getDefinedServers();
        for (RemoteServerConfig conf : servers.values()) {
            testWorkspaces(conf);
            basicCRUD(conf);
        }
    }

    private void testWorkspaces(RemoteServerConfig conf) throws SDKException {

        Transport transport = TestUtils.getTransport(factory, conf);

        System.out.println("... Listing workspaces for " + printableId(transport.getId()));
        factory.getClient(transport).workspaceList(new DummyHandler());

        System.out.println("... Listing object for workspace " + conf.defaultWS);
        factory.getClient(transport).ls(conf.defaultWS, "/", null, (node) -> System.out.println(node.getLabel()));
    }

    public void basicCRUD(RemoteServerConfig conf) throws SDKException, IOException {
        // System.out.println("... Testing CRUD for " + printableId(transport.getId()));

        Transport transport = TestUtils.getTransport(factory, conf);
        Client client = factory.getClient(transport);

        // if (!transport.getServer().isLegacy()) {
        // // TODO remove this once upload has been done.
        // Log.w("SKIP", "Could not CRUD for *cells* server at " + conf.serverURL
        // + ": upload with S3 is not yet implemented in plain Java");
        // return;
        // }

        System.out.println("... Testing CRUD for " + printableId(transport.getId()));

        String baseDir = "/";
        final String name = "hello-" + testRunID + ".txt";
        String message = "Hello Pydio! - this is a message from test run #" + testRunID;

        // Upload
        byte[] content = message.getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);
        Message msg = client.upload(source, content.length, conf.defaultWS, baseDir, name, true, (progress) -> {
            System.out.printf("\r%d bytes written\n", progress);
            return false;
        });
        Assert.assertNotNull(msg);
        Assert.assertEquals("SUCCESS", msg.type());

        // Read
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            client.download(conf.defaultWS, baseDir + name, out, null);
            out.flush();
            byte[] byteArray = out.toByteArray();
            String retrievedMsg = new String(byteArray, StandardCharsets.UTF_8);
            System.out.println("Retrieved: " + retrievedMsg);
            Assert.assertEquals(message, retrievedMsg);
        }

        // Update fails in P8
        if (!transport.getServer().isLegacy()) {
            System.out.println("Legacy, for sure ?");

            message += " -- Add with some additional content";
            content = message.getBytes();
            source = new ByteArrayInputStream(content);
            msg = client.upload(source, content.length, conf.defaultWS, baseDir, name, true, (progress) -> {
                System.out.printf("\r%d bytes written\n", progress);
                return false;
            });
            Assert.assertNotNull(msg);
            Assert.assertEquals("SUCCESS", msg.type());

            // Read updated
            String retrievedMsg = "";
            loop: for (int i = 0; i < 10; i++) {
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    client.download(conf.defaultWS, baseDir + name, out, null);
                    out.flush();
                    byte[] byteArray = out.toByteArray();
                    retrievedMsg = new String(byteArray, StandardCharsets.UTF_8);
                    System.out.println("Retrieved: " + retrievedMsg);

                    if (message.equals(retrievedMsg)) {
                        break loop;
                    }
                    Thread.sleep(2000);
                    System.out.println("Wait 2s before retry...");

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            Assert.assertEquals(message, retrievedMsg);

        }

        // Delete
        msg = client.delete(conf.defaultWS, new String[] { "/" + name });
        // Assert.assertNotNull(msg);
        // Assert.assertEquals("EMPTY", msg.type());

        boolean deleted = false;
        loop: for (int i = 0; i < 10; i++) {
            try {

                // Check if uploaded files is still there
                final List<String> founds = new ArrayList<>();
                client.ls(conf.defaultWS, baseDir, null, (node) -> {
                    if (name.equals(node.getLabel()))
                        founds.add(name);
                });
                if (founds.size() == 0) {
                    deleted = true;
                    break loop;
                }
                Thread.sleep(2000);
                System.out.println("Wait 2s before retry...");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Assert.assertTrue(deleted);

        // TODO finish implementing the CRUD and corresponding checks.
    }

    @Test
    public void testSkipVerify() {
        // try {
        Map<String, RemoteServerConfig> servers = config.getDefinedServers();
        for (String key : servers.keySet()) {

            RemoteServerConfig currConf = servers.get(key);
            if (!currConf.skipVerify) {
                continue;
            }

            // Test Self signed URL
            ServerURL currURL;
            try {
                currURL = ServerURLImpl.fromAddress(currConf.serverURL);
                // => Self-signed: ping fails
                currURL.ping();
            } catch (Exception e) {
                Assert.assertTrue(e instanceof SSLHandshakeException);
                try {
                    currURL = ServerURLImpl.fromAddress(currConf.serverURL, true);
                    currURL.ping();
                } catch (Exception e2) {
                    Assert.assertNull(e);
                }
            }
        }
        // } catch (Exception e) {
        // e.printStackTrace();
        // Assert.assertNull(e);
        // }
    }

    private static class DummyHandler implements NodeHandler {

        private int i = 0;

        @Override
        public void onNode(Node node) {
            System.out.println("#" + (++i) + " " + node.getLabel());
            // System.out.println(node.getPath());
        }
    }

    private String printableId(String techId) {
        return StateID.fromId(techId).toString();
    }

}