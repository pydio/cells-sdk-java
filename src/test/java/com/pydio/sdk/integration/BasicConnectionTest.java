package com.pydio.sdk.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.examples.Credentials;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/config.properties" file to match your setup.
 * 
 * You can then launch the test with:
 * 
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class BasicConnectionTest {

    private ServerNode node;
    private Client cellsClient;

    private String serverURL, login, pwd, workspace;

    @Before
    public void setup() {

        Properties p = new Properties();
        try (InputStream is = BasicConnectionTest.class.getResourceAsStream("/config.properties")) {
            p.load(new InputStreamReader(is));
            serverURL = p.getProperty("serverURL");
            login = p.getProperty("login");
            pwd = p.getProperty("pwd");
            workspace = p.getProperty("defaultWorkspace");
        } catch (IOException e) {
            System.out.println("could not retrieve configuration file, cause: ");
            System.out.println(e);
            return;
        }


        node = new ServerNode();
        Error error = node.resolve(serverURL);
        if (error != null) {
            System.out.println("Could not resolve server URL, cause: ");
            System.out.println(error);
        }

        cellsClient = ClientFactory.get().Client(node);
        cellsClient.setCredentials(new Credentials(login, pwd));
        cellsClient.setSkipOAuthFlag(true);
    }

    // @Ignore("not yet ready , Please ignore.")
    @Test
    public void testBasicCRUD() {

        System.out.println("... Test Listing");
        try {
            cellsClient.ls(workspace, "/", (node) -> System.out.println(node.label()));
        } catch (SDKException e) {
            e.printStackTrace();
        }

        System.out.println("... Test Upload");
        String targetDir = "/"; // root
        String name = "hello6.txt";
        byte[] content = "Hello Pydio!".getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);
        try {
            Message msg = cellsClient.upload(source, content.length, workspace, targetDir, name, true, (progress) -> {
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

    @After
    public void teardown() {
        // do nothing
    }

}