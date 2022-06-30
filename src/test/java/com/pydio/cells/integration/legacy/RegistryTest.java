package com.pydio.cells.integration.legacy;

import com.pydio.cells.api.Client;
import com.pydio.cells.api.Registry;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.ClientFactory;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.tests.RemoteServerConfig;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestUtils;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Registry can be downloaded whether the request is authenticated or not.
 * <p>
 * When requesting the registry with no authentication, the server responds with
 * default registry info, that mainly are (for what we use) actions and plugins.
 * <p>
 * <p>
 * When requesting with valid authentication data, the server also sends user info back.in
 * These additional info are the preferences of the user and workspaces/cells they have access to.
 * <p>
 * <p>
 * The approach for this test is to request the registry from both unauthenticated and authenticated
 * states and check if plugins and actions are available. When authenticated we check
 * if there are workspaces that reflects what is on the server side.
 * <p>
 * There is a lot more things that can be tested about the registry but what is described above is
 * enough for now.
 */
public class RegistryTest {

    private static ClientFactory factory;
    private static TestConfiguration config;
    private static String testRunID;

    @BeforeClass
    public static void setup() {
        testRunID = TestUtils.randomString(4);
        factory = new TestClientFactory();
        config = TestConfiguration.getDefault();
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

            Registry registry = p8Client.getDefaultRegistry();

            // we must have actions and plugins
            Assert.assertNotEquals(0, registry.getActions().size());
            Assert.assertNotEquals(0, registry.getPlugins().size());

            // we should not have workspaces
            Assert.assertEquals(0, registry.getWorkspaces().size());

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

            Registry registry = p8Client.getUserRegistry();

            // we must have actions and plugins
            Assert.assertNotEquals(0, registry.getActions().size());
            Assert.assertNotEquals(0, registry.getPlugins().size());

            // me must not have workspaces
            Assert.assertNotEquals(0, registry.getWorkspaces().size());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }
}
