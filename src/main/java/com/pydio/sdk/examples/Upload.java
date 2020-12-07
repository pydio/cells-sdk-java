package com.pydio.sdk.examples;

import com.pydio.sdk.core.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.Message;
import com.pydio.sdk.core.model.ServerNode;

import java.io.ByteArrayInputStream;

public class Upload {

    private static final String serverURL = "http://localhost:8080";
    private static final String login = "admin";
    private static final String pwd = "admin";
    private static final String workspace = "common-files";

    public static void main(String[] args) {
        ServerNode node = new ServerNode();
        Error error = node.resolve(serverURL);
        if (error != null) {
            System.out.println(error);
            return;
        }

        Client client = ClientFactory.get(node);
        client.setCredentials(new Credentials(login, pwd));
        client.setSkipOAuthFlag(true);


        String targetDir = "/"; // root
        String name = "hello.txt";

        byte[] content = "Hello Pydio!".getBytes();
        ByteArrayInputStream source = new ByteArrayInputStream(content);

        try {
            Message msg = client.upload(source, content.length, workspace, targetDir, name, true, (progress) -> {
                System.out.printf("\r%d bytes written\n", progress);
                return false;
            });
            System.out.println("After upload, message: "+msg.message);

        } catch (SDKException e) {
            e.printStackTrace();
        }
    }
}
