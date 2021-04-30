package com.pydio.sdk.examples;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.api.Error;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.core.model.ServerNodeImpl;

public class Workspaces {

    public static void main(String[] args) {
        ServerNode node = new ServerNodeImpl();
        Error error = node.resolve("http://localhost:8080");
        if (error != null) {
            System.out.println(error);
            return;
        }
        Client client = ClientFactory.get(node);
        client.setCredentials(new Credentials("admin", "admin"));
        client.setSkipOAuthFlag(true);
        try {
            client.workspaceList((n) -> System.out.println(n.getLabel()));
        } catch (SDKException e) {
            e.printStackTrace();
        }
    }
}
