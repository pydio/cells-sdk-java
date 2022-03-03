package com.pydio.cells.integration.legacy;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.ServerFactory;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.tests.RemoteServerConfig;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.transport.ServerURLImpl;
import com.pydio.cells.legacy.P8Credentials;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.Map;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class P8SpecificTest {

    private ServerFactory factory;
    private TestConfiguration config;
    // private String testRunID;

    @Before
    public void setup() {
        //testRunID = TestUtils.randomString(4);
        factory = new TestClientFactory();
        config = TestConfiguration.getDefault();
    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testCaptcha() throws SDKException {
        Map<String, RemoteServerConfig> servers = config.getDefinedServers();

        RemoteServerConfig p8Conf = null;
        ServerURL p8URL = null;
        for (RemoteServerConfig conf : servers.values()) {
            try {
                ServerURL serverURL = ServerURLImpl.fromAddress(conf.serverURL, conf.skipVerify);
                String type = factory.checkServer(serverURL);
                if (SdkNames.TYPE_LEGACY_P8.equals(type)) {
                    p8Conf = conf;
                    p8URL = serverURL;
                    break;
                }
            } catch (MalformedURLException sde) {
                Log.w("Bad Config", "could not check " + conf.serverURL + ", cause: " + sde.getMessage());
            }
        }

        if (p8URL == null) {
            Log.w("Bad Config", "No Pydio 8 server found in test config, could not test captcha.");
            return;
        }

        if (true) {
            Log.w("Bad Config", "We cannot test captcha until we have a mean to create user to trash automatically.");
            return;
        }

        try {
            // First log with correct password to reduce useless noise
            String accountId = ServerFactory.accountID(p8Conf.username, p8URL);
            Credentials credentials = new P8Credentials(p8Conf.username, p8Conf.pwd);
            factory.registerAccountCredentials(credentials, p8URL);
            factory.unregisterAccount(accountId);

            Credentials wrongCreds = new P8Credentials(p8Conf.username, "not a correct password");

            // Log a few times with un-correct password until we are requested with a captcha
            boolean needCaptcha = false;
            for (int i = 0; i < 5; i++) {
                try {
                    factory.registerAccountCredentials(wrongCreds, p8URL);
                } catch (SDKException e) {
                    if (e.getCode() == ErrorCodes.authentication_with_captcha_required) {
                        // Reached the limit we can go on with the test
                        needCaptcha = true;
                        break;
                    } else if (e.getCode() == ErrorCodes.invalid_credentials) {
                        // expected => try another time
                    } else throw e;
                }
            }

            Assert.assertTrue(needCaptcha);

//            P8Transport anonSession = new P8Transport(new P8Server(p8URL), "anon", new JavaCustomEncoder());
//            InputStream in = anonSession.getCaptcha();


        } catch (SDKException sde) {
            // TODO manage having a standard logger here
            System.out.println("Warning: could not login to " + p8Conf.serverURL + ", cause: " + sde.getMessage());
        }
    }

}