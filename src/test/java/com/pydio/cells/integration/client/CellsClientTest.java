package com.pydio.cells.integration.client;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Message;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.client.SessionFactory;
import com.pydio.cells.client.TestSessionFactory;
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

public class CellsClientTest {

    private static TestSessionFactory factory;
    private static TestConfiguration config;
    private static String testRunID;
    private static RemoteServerConfig cellsConf;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new TestSessionFactory(tokens);
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
        Client client = factory.getClient(cellsTransport);

        // Upload
        String baseDir = "/";
        String fileName = "hello-" + testRunID + ".txt";
        String file = baseDir + fileName;

        String message = "Hello Pydio! - this is a message from test run #" + testRunID;
        byte[] content = message.getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);

        Message msg = client.upload(source, content.length, cellsConf.defaultWS, baseDir, fileName, true, (progress) -> {
            System.out.printf("\r%d bytes written\n", progress);
            return false;
        });
        Assert.assertNotNull(msg);
        Assert.assertEquals("SUCCESS", msg.type());

        // Post with a stat
        FileNode node = client.nodeInfo(cellsConf.defaultWS, file);
        String uuid = node.getProperty(SdkNames.NODE_PROPERTY_UUID);
        String nodePath = node.getProperty(SdkNames.NODE_PROPERTY_PATH);
        System.out.println("... Stats request succeeded");
        System.out.println("UUID: " + uuid);
        System.out.println("Path: " + nodePath);

        // Bookmark file
        Message bookmarkMessage = client.bookmark(cellsConf.defaultWS, uuid);
    }

}
