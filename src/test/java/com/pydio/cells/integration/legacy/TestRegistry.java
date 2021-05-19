package com.pydio.cells.integration.legacy;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.client.auth.SimpleTokenStore;
import com.pydio.cells.client.auth.TokenService;
import com.pydio.cells.client.model.Registry;
import com.pydio.cells.client.utils.Log;
import com.pydio.cells.integration.RemoteServerConfig;
import com.pydio.cells.integration.TestConfiguration;
import com.pydio.cells.integration.TestUtils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Registry can be downloaded whether the request is authenticated or not.
 *
 * When requesting the registry without authentication the server responds with what we call the
 * default registry info. The default registry info are actions and plugins. There are more info
 * but currently only plugins and actions are useful.
 *
 *
 * When requesting the registry with authentication data the server responds with user info in
 * addition of the default registry info. These additional info are the preferences of the user
 * and workspaces/cells they have access to
 *
 *
 * The approach for this test is to request the registry from both unauthenticated and authenticated
 * states and check if plugins and actions are available. When authenticated we check
 * if there are workspaces that reflects what is on the server side.
 *
 * There is a lot more things that can be tested about the registry but what is described above is
 * ok as a baseline test
 */
public class TestRegistry {

    private static ServerFactory factory;
    private static TestConfiguration config;
    private static String testRunID;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        TokenService tokens = new TokenService(new SimpleTokenStore());
        factory = new ServerFactory(tokens);
        config = new TestConfiguration();
    }

    @Test
    public void testDefaultRegistry() {
        // TODO move this in the setup

        RemoteServerConfig p8Conf = config.getServer("p8");
        if (p8Conf == null) {
            Log.w("Unsupported conf", "No Pydio 8 compatible configuration found, skipping");
            return;
        }

        try {
            Transport p8Transport = TestUtils.getTransport(factory, p8Conf);
            Client p8Client = factory.getClient(p8Transport);

            Registry registry = p8Client.getRegistry();

            // we must have actions and plugins
            Assert.assertNotEquals(0, registry.GetActions().size());
            Assert.assertNotEquals(0, registry.GetPlugins().size());

            // me must not have workspaces
            Assert.assertEquals(0, registry.GetWorkspaces().size());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }

    @Test
    public void testAuthenticatedUserRegistry() {
        // TODO move this in the setup

        RemoteServerConfig p8Conf = config.getServer("p8");
        if (p8Conf == null) {
            Log.w("Unsupported conf", "No Pydio 8 compatible configuration found, skipping");
            return;
        }

        try {
            Transport p8Transport = TestUtils.getTransport(factory, p8Conf);
            Client p8Client = factory.getClient(p8Transport);

            // trick to force authentication
            p8Client.stats(p8Conf.defaultWS, "/", false);

            Registry registry = p8Client.getRegistry();

            // we must have actions and plugins
            Assert.assertNotEquals(0, registry.GetActions().size());
            Assert.assertNotEquals(0, registry.GetPlugins().size());

            // me must not have workspaces
            Assert.assertNotEquals(0, registry.GetWorkspaces().size());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }
}
