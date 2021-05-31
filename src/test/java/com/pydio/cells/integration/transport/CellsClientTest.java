package com.pydio.cells.integration.transport;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.SessionFactory;
import com.pydio.cells.client.auth.SimpleTokenStore;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.integration.RemoteServerConfig;
import com.pydio.cells.integration.TestConfiguration;
import com.pydio.cells.integration.TestUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellsClientTest {

    private static SessionFactory factory;
    private static TestConfiguration config;
    private static String testRunID;
    private static RemoteServerConfig cellsConf;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new SessionFactory(tokens);
        config = new TestConfiguration();
        cellsConf = config.getServer("cells-https");

    }

    @AfterClass
    public static void teardown() {
        // do nothing
    }

    @Test
    public void testBookmark() throws Exception {

        if (cellsConf == null) {
            Log.w("Unsupported conf", "No Pydio Cells configuration found, skipping");
            return;
        }

        Transport cellsTransport = TestUtils.getTransport(factory, cellsConf);
        Client cellsClient = factory.getClient(cellsTransport);

//            // Post with a stat
//            Stats stats = cellsClient.stats(p8Conf.defaultWS, "/", false);
//            System.out.println("... Stats request succeeded");
//            System.out.println("Size: " + stats.getSize());
//            System.out.println("Time: " + stats.getmTime());
//            System.out.println("Hash: " + stats.getHash());
//
//            // Upload
//            String baseDir = "/";
//            final String name = "hello-" + testRunID + ".txt";
//            String message = "Hello Pydio! - this is a message from test run #" + testRunID;
//            byte[] content = message.getBytes();
//            ByteArrayInputStream source = new ByteArrayInputStream(content);
//
//            Message msg = factory.getClient(cellsTransport).upload(source, content.length, p8Conf.defaultWS, baseDir, name, true, (progress) -> {
//                System.out.printf("\r%d bytes written\n", progress);
//                return false;
//            });
//            Assert.assertNotNull(msg);
//            Assert.assertEquals("SUCCESS", msg.type());


    }

}
