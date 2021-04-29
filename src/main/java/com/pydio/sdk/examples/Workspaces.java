package com.pydio.sdk.examples;

import com.pydio.sdk.api.Client;
import com.pydio.sdk.core.ClientFactory;
import com.pydio.sdk.core.common.errors.Error;
import com.pydio.sdk.core.common.errors.SDKException;
import com.pydio.sdk.core.model.ServerNode;

public class Workspaces {

    public static void main(String[] args) {
        ServerNode node = new ServerNode();
        Error error = node.resolve("http://localhost:8080");
        if (error != null) {
            System.out.println(error);
            return;
        }
        Client client = ClientFactory.get(node);
        client.setCredentials(new Credentials("admin", "admin"));
        client.setSkipOAuthFlag(true);
        try {
            client.workspaceList((n) -> System.out.println(n.label()));
        } catch (SDKException e) {
            e.printStackTrace();
        }
    }
}
