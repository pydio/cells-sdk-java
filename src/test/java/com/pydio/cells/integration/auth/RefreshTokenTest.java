package com.pydio.cells.integration.auth;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.client.TestSessionFactory;
import com.pydio.cells.integration.RemoteServerConfig;
import com.pydio.cells.integration.TestConfiguration;
import com.pydio.cells.integration.TestUtils;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.auth.SimpleTokenStore;
import com.pydio.cells.transport.auth.Token;
import com.pydio.cells.transport.auth.TokenService;
import com.pydio.cells.transport.auth.TokenStore;
import com.pydio.cells.utils.Log;

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

    private static TestSessionFactory factory;
    private static TestConfiguration config;
    private static String testRunID;
    private static RemoteServerConfig cellsConf;
    private static TokenStore tokenStore;

    // Replace this with a valid value for cells-https config to enable the test
    // private final static String manualToken = "Do3SfOj4XOj2oQzMBHsRDGWvOB-wQc9XQlhA-3cqMZI.ydWcj44AazUeR4Cwq1zA0uXL65ykOYNC2L5QRcFQZUo";
    private final static String manualToken = null;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);

        tokenStore = new SimpleTokenStore();
        factory = new TestSessionFactory(new TokenService(tokenStore));
        config = new TestConfiguration();
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

        cellsTransport.refreshOAuthToken(initialDummyToken);
    }
}
