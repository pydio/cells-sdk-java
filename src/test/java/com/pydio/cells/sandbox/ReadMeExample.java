package com.pydio.cells.sandbox;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.api.TreeServiceApi;
import com.pydio.cells.openapi.model.RestBulkMetaResponse;
import com.pydio.cells.openapi.model.RestGetBulkMetaRequest;
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.ServerURLImpl;
import com.pydio.cells.transport.auth.credentials.LegacyPasswordCredentials;
import com.pydio.cells.utils.tests.TestClientFactory;

import org.junit.Ignore;
import org.junit.Test;

import java.net.MalformedURLException;

public class ReadMeExample {


    @Ignore
    @Test
    public void forTheReadMe() throws MalformedURLException, SDKException, ApiException {

        TestClientFactory factory = new TestClientFactory();
        ServerURL serverURL = ServerURLImpl.fromAddress("https://localhost:8080", true);
        Credentials credentials = new LegacyPasswordCredentials("user", "password");

        String accountID = factory.registerAccountCredentials(serverURL, credentials);
        Transport transport = factory.getTransport(accountID);

        /* Use the simplified client*/
        Client client = factory.getClient(transport);
        client.mkdir("common-files", "/parent", "child");

        /* Directly use the generated API (Cells only) */
        // Authentication is auto-magically handled by the transport
        // as long as it has been previously registered
        ApiClient apiClient = ((CellsTransport) transport).authenticatedClient();
        TreeServiceApi api = new TreeServiceApi(apiClient);
        // Build the request
        RestGetBulkMetaRequest request = new RestGetBulkMetaRequest();
        request.addNodePathsItem("common-files/parent/child");
        request.setAllMetaProviders(true);
        // Performs the request and handle result
        RestBulkMetaResponse response = api.bulkStatNodes(request);
        TreeNode node = response.getNodes().get(0);
    }

}
