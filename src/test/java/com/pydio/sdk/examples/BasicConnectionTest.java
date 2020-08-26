package com.pydio.sdk.examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import com.pydio.sdk.core.model.ServerNode;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Message;

import java.io.ByteArrayInputStream;

public class BasicConnectionTest {

    private String serverURL = "http://localhost:8080";
    private String login = "admin";
    private String pwd = "admin";
    private String workspace = "common-files";

    private ServerNode node;

    @Before
    public void setupThis() {
        System.out.println("... Setting up");

        node = new ServerNode();

        Error error = node.resolve(serverURL);
        if (error != null) {
            System.out.println(error);
            return;
        }

    }

    @Ignore("not yet ready , Please ignore.")
    @Test
    public void method() {

        System.out.println("... Launching test method");

        Client client = ClientFactory.get().Client(node);
        client.setCredentials(new Credentials(login, pwd));
        client.setSkipOAuthFlag(true);

        String targetDir = "/"; // root
        String name = "hello6.txt";

        byte[] content = "Hello Pydio!".getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);

        try {
            Message msg = client.upload(source, content.length, workspace, targetDir, name, true, (progress) -> {
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
    }

    @After
    public void tearThis() {
        // do nothing
    }

}