package com.pydio.cells.integration.legacy;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.client.auth.SimpleTokenStore;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.integration.RemoteServerConfig;
import com.pydio.cells.integration.TestConfiguration;
import com.pydio.cells.integration.TestUtils;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;

/**
 * Performs basic tests against a running Pydio 8 instance. You must first adapt
 * the "src/test/resources/servers/p8.properties" file to match your setup.
 * You can then launch the test with:
 * <code>./gradlew test --tests com.pydio.cells.integration.legacy.P8TransportTest -Dtest.profile=integration</code>
 */
public class P8TransportTest {

    private static ServerFactory factory;
    private static TestConfiguration config;
    private static String testRunID;

    // @BeforeClass is executed once for the whole class we do not need to scratch it for each test
    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new ServerFactory(tokens);
        config = new TestConfiguration();
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

            // Post with a stat
            Stats stats = p8Client.stats(p8Conf.defaultWS, "/", false);
            System.out.println("... Stats request succeeded");
            System.out.println("Size: " + stats.getSize());
            System.out.println("Time: " + stats.getmTime());
            System.out.println("Hash: " + stats.getHash());

            // Upload
            String baseDir = "/";
            final String name = "hello-" + testRunID + ".txt";
            String message = "Hello Pydio! - this is a message from test run #" + testRunID;
            byte[] content = message.getBytes();
            ByteArrayInputStream source = new ByteArrayInputStream(content);

            Message msg = factory.getClient(p8Transport).upload(source, content.length, p8Conf.defaultWS, baseDir, name, true, (progress) -> {
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