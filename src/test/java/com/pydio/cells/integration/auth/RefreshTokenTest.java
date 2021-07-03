package com.pydio.cells.integration.auth;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Store;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.MemoryStore;
import com.pydio.cells.utils.tests.RemoteServerConfig;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestUtils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Debug test class that is not meant to be used in the CICD pipe.
 * <p>
 * Yet, this is useful to locally test and debug token issues
 * First manually retrieve valid token for your target configuration and set the manualToken variable.
 */
public class RefreshTokenTest {

    private static TestClientFactory factory;
    private static TestConfiguration config;
    private static String testRunID;
    private static RemoteServerConfig cellsConf;
    private static Store<Token> tokenStore;

    // Replace this with a valid value for cells-https config to enable the test
    // private final static String manualToken = "Do3SfOj4XOj2oQzMBHsRDGWvOB-wQc9XQlhA-3cqMZI.ydWcj44AazUeR4Cwq1zA0uXL65ykOYNC2L5QRcFQZUo";
    private final static String manualToken = null;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);

        tokenStore = new MemoryStore<>();
        CredentialService credentialService = new CredentialService(tokenStore, new MemoryStore<>());

        factory = new TestClientFactory(credentialService, new MemoryStore<>(), new MemoryStore<>());
        config = TestConfiguration.getDefault();
        cellsConf = config.getServer("cells-https");
    }

    @AfterClass
    public static void teardown() {
        // do nothing
    }

    @Test
    public void testRefreshToken() throws SDKException {
        if (cellsConf == null || manualToken == null) {
            Log.w("Unsupported conf", "No Pydio Cells configuration or no initial token found, skipping");
            return;
        }

        CellsTransport cellsTransport = (CellsTransport) TestUtils.getTransport(factory, cellsConf);
        Token token = tokenStore.get(cellsTransport.getId());
        Token initialDummyToken = new Token();
        initialDummyToken.refreshToken = manualToken;

        cellsTransport.getRefreshedOAuthToken(initialDummyToken);
    }
}
