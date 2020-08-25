package com.pydio.sdk.examples;

import com.pydio.sdk.core.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.ServerNode;

public class Workspaces {


    public static void main(String[] args) {
        ServerNode node = new ServerNode();
        Error error = node.resolve("https://server-address");
        if (error != null) {
            System.out.println(error);
            return;
        }
        Client client = ClientFactory.get().Client(node);
        client.setCredentials(new Credentials("login", "password"));
        try {
            client.workspaceList((n) -> System.out.println(n.label()));
        } catch (SDKException e) {
            e.printStackTrace();
        }
    }
}
