package com.pydio.cells.integration;

import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Node;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.client.auth.SimpleTokenStore;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.client.utils.StateID;
import com.pydio.cells.transport.ServerURLImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default-target-server.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class BasicConnectionTest {

    private ServerFactory factory;
    private TestConfiguration config;
    private String testRunID;

    @Before
    public void setup() {

        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new ServerFactory(tokens);

        config = new TestConfiguration();

    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testSimpleList() {
        config.getDefinedServers().forEach(this::testWorkspaces);
        config.getDefinedServers().forEach(this::basicCRUD);

        // For the time being only P8 upload is implemented in plain Java
//        TestConfiguration.ServerConfig p8Conf = config.getServer("p8");
//        if (p8Conf != null) {
//            basicCRUD("p8", p8Conf);
//        }
    }

    private void testWorkspaces(String id, RemoteServerConfig conf) {
        try {

            Transport session = TestUtils.getTransport(factory, conf);

            System.out.println("... Listing workspaces for " + printableId(session.getId()));
            session.getClient().workspaceList(new DummyHandler());

            System.out.println("... Listing object for workspace " + conf.defaultWS);
            session.getClient().ls(conf.defaultWS, "/",
                    null, (node) -> System.out.println(node.getLabel()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull("Listing of default workspace root failed for " + id + ", cause: " + e.getMessage(), e);
        }
    }

    public void basicCRUD(String id, RemoteServerConfig conf) {
        Transport session = null;
        try {
            session = TestUtils.getTransport(factory, conf);

            if (!session.getServer().isLegacy()) {
                // TODO remove this once upload has been done.
                Log.w("SKIP", "Could not CRUD for *cells* server at " + conf.serverURL
                        + ": upload with S3 is not yet implemented in plain Java");
                return;
            }

            System.out.println("... Testing CRUD for " + printableId(session.getId()));

            String baseDir = "/";
            final String name = "hello-" + testRunID + ".txt";
            String message = "Hello Pydio! - this is a message from test run #" + testRunID;

            // Upload
            byte[] content = message.getBytes();
            ByteArrayInputStream source = new ByteArrayInputStream(content);
            Message msg = session.getClient().upload(source, content.length, conf.defaultWS, baseDir, name, true, (progress) -> {
                System.out.printf("\r%d bytes written\n", progress);
                return false;
            });
            Assert.assertNotNull(msg);
            Assert.assertEquals("SUCCESS", msg.type());

            // Read
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                session.getClient().download(conf.defaultWS, baseDir + name, out, null);
                out.flush();
                byte[] byteArray = out.toByteArray();
                String retrievedMsg = new String(byteArray, StandardCharsets.UTF_8);
                System.out.println("Retrieved: " + retrievedMsg);
                Assert.assertEquals(message, retrievedMsg);
            }

            // Update fails in P8
            if (!session.getServer().isLegacy()) {
                System.out.println("Legacy, for sure ?");

                message += " -- Add with some additional content";
                content = message.getBytes();
                source = new ByteArrayInputStream(content);
                msg = session.getClient().upload(source, content.length, conf.defaultWS, baseDir, name, true, (progress) -> {
                    System.out.printf("\r%d bytes written\n", progress);
                    return false;
                });
                Assert.assertNotNull(msg);
                Assert.assertEquals("SUCCESS", msg.type());

                // Read updated
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    session.getClient().download(conf.defaultWS, baseDir + name, out, null);
                    out.flush();
                    byte[] byteArray = out.toByteArray();
                    String retrievedMsg = new String(byteArray, StandardCharsets.UTF_8);
                    System.out.println("Retrieved: " + retrievedMsg);
                    Assert.assertEquals(message, retrievedMsg);
                }
            }
            // Delete
            msg = session.getClient().delete(conf.defaultWS, new String[]{"/" + name});
            Assert.assertNotNull(msg);
            Assert.assertEquals("EMPTY", msg.type());

            // Check if uploaded files is still there
            final List<String> founds = new ArrayList<>();
            session.getClient().ls(conf.defaultWS, baseDir,
                    null, (node) -> {
                        if (name.equals(node.getLabel())) founds.add(name);
                    });
            Assert.assertEquals(0, founds.size());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull("CRUD failed for " + (session == null ? id : session.getId()) + ": " + e.getMessage(), e);
        }

        // TODO finish implementing the CRUD and corresponding checks. Typically, for
        // the time being upload fails silently.
    }

    @Test
    public void testSkipVerify() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }


    private class DummyHandler implements NodeHandler {

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