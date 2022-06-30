package com.pydio.cells.integration.legacy;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.api.ui.WorkspaceNode;
import com.pydio.cells.client.ClientFactory;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.tests.RemoteServerConfig;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestUtils;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Performs basic tests against a running Pydio 8 instance. You must first adapt
 * the "src/test/resources/servers/p8.properties" file to match your setup.
 * You can then launch the test with:
 * <code>./gradlew test --tests com.pydio.cells.integration.legacy.P8TransportTest -Dtest.profile=integration</code>
 */
public class P8TransportTest {

    private static ClientFactory factory;
    private static TestConfiguration config;
    private static String testRunID;

    // @BeforeClass is executed once for the whole class we do not need to scratch it for each test
    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        factory = new TestClientFactory();
        config = TestConfiguration.getDefault();
    }

    @AfterClass
    public static void teardown() {
        // do nothing
    }

    @Test
    public void testMethods() {
        // TODO move this in the setup
        RemoteServerConfig p8Conf = config.getServer("p8");
        if (p8Conf == null) {
            Log.w("Unsupported conf", "No Pydio 8 compatible configuration found, skipping");
            return;
        }

        try {
            Transport p8Transport = TestUtils.getTransport(factory, p8Conf);
            Client p8Client = factory.getClient(p8Transport);

            // Try to list workspaces
            AtomicBoolean hasWs = new AtomicBoolean(false);
            AtomicBoolean foundDefault = new AtomicBoolean(false);

            p8Client.workspaceList(node -> {
                if (node instanceof WorkspaceNode) {
                    WorkspaceNode wn = (WorkspaceNode) node;
                    hasWs.set(true);
                    if (p8Conf.defaultWS.equals(wn.getSlug())) {
                        foundDefault.set(true);
                    }
                    System.out.printf("\r %s - %s \n", wn.getName(), wn.getSlug());
                } else {
                    Assert.fail(node.getName() + " is not a workspace node, this should not happen: " + node.getClass().getSimpleName());
                }
            });
            Assert.assertTrue(hasWs.get());
            Assert.assertTrue("default not found. Expected: " + p8Conf.defaultWS, foundDefault.get());

            // Test HTTP POST with a stat
            Stats stats = p8Client.stats(p8Conf.defaultWS, "/", false);
            System.out.println("... Stats request succeeded");
            System.out.println("Size: " + stats.getSize());
            System.out.println("Time: " + stats.getmTime());
            System.out.println("Hash: " + stats.getHash());

            // Upload
            String baseDir = "/";
            final String name = "hello-" + testRunID + ".txt";
            String message = "Hello Pydio! - this is a message from test SdkJava Test - Run #" + testRunID + "\n";
            message += "Current user agent: " + p8Transport.getUserAgent() + "\n";

            byte[] content = message.getBytes();
            ByteArrayInputStream source = new ByteArrayInputStream(content);

            // System.out.println("\n\n\n\n\n\n ############### ");

            Message msg = factory.getClient(p8Transport)
                    .upload(
                            source,
                            content.length,
                            "text/plain",
                            p8Conf.defaultWS, baseDir, name, true, (progress) -> {
                                System.out.printf("\r%d bytes written\n", progress);
                                return false;
                            });
            Assert.assertNotNull(msg);
            Assert.assertEquals("SUCCESS", msg.type());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }
}
