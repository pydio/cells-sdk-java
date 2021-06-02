package com.pydio.cells.integration.auth;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.client.TestSessionFactory;
import com.pydio.cells.client.auth.SimpleTokenStore;
import com.pydio.cells.client.auth.Token;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.auth.TokenStore;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.integration.RemoteServerConfig;
import com.pydio.cells.integration.TestConfiguration;
import com.pydio.cells.integration.TestUtils;
import com.pydio.cells.transport.CellsTransport;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class RefreshTokenTest {

    private static TestSessionFactory factory;
    private static TestConfiguration config;
    private static String testRunID;
    private static RemoteServerConfig cellsConf;
    private static TokenStore tokenStore;

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
    public void testRefreshToken() {
        if (cellsConf == null) {
            Log.w("Unsupported conf", "No Pydio Cells configuration found, skipping");
            return;
        }

        CellsTransport cellsTransport;
        try {
            cellsTransport = (CellsTransport) TestUtils.getTransport(factory, cellsConf);
        } catch (SDKException e) {
            e.printStackTrace();
            Assert.fail();
            return;
        }

        Token token = tokenStore.get(cellsTransport.getId());

        try {
            cellsTransport.refreshOAuthToken(token);
        } catch (SDKException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
