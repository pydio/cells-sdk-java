package com.pydio.sdk.integration;

import com.pydio.sdk.api.Credentials;
import com.pydio.sdk.api.ISession;
import com.pydio.sdk.api.Server;
import com.pydio.sdk.api.ServerURL;
import com.pydio.sdk.core.ServerFactory;
import com.pydio.sdk.core.ServerURLImpl;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.auth.jwt.TokenMemoryStore;
import com.pydio.sdk.core.security.P8Credentials;
import com.pydio.sdk.core.security.PasswordCredentials;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import javax.net.ssl.SSLHandshakeException;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default-target-server.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class BasicConnectionTest {

    private ServerFactory factory;
    private TestConfiguration config;



    @Before
    public void setup() {
        TokenService tokens = new TokenService(new TokenMemoryStore());
        factory = new ServerFactory(tokens);

        config = new TestConfiguration();
    }

    @After
    public void teardown() {
        // do nothing
    }

    @Test
    public void testSimpleList() {
        config.getDefinedServers().forEach((k, v) -> listDefaultWSRoot(k, v));

        // For the time being only P8 upload is implemented in plain Java
        TestConfiguration.ServerConfig p8Conf = config.getServer("p8");
        if (p8Conf != null) {
            basicCRUD("p8", p8Conf);
        }
    }

    private void listDefaultWSRoot(String id, TestConfiguration.ServerConfig conf) {
        try {
            ServerURL sURL = ServerURLImpl.fromAddress(conf.serverURL);
            Server server = factory.register(sURL);
            Credentials credentials;
            if (ServerFactory.TYPE_LEGACY_P8.equals(server.getRemoteType())){
                credentials = new P8Credentials(conf.login,  conf.pwd);
            } else {
                credentials = new PasswordCredentials(conf.login,  conf.pwd);
            }

            ISession session = factory.registerAccount(sURL, credentials);
            session.getClient().ls(conf.defaultWS, "/",
                    null, (node) -> System.out.println(node.getLabel()));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }

    }

    public void basicCRUD(String id, TestConfiguration.ServerConfig conf) {

            String ws = conf.defaultWS;

            //        System.out.println("... Test Upload");
//        String targetDir = "/"; // root
//        String name = "hello6.txt";
//        byte[] content = "Hello Pydio!".getBytes();
//        ByteArrayInputStream source = new ByteArrayInputStream(content);
//        try {
//            Message msg = testClient.getCellsClient().upload(source, content.length, ws, targetDir, name, true, (progress) -> {
//                System.out.printf("\r%d bytes written\n", progress);
//                return false;
//            });
//            if (msg == null)
//                System.out.println("After upload, no message.");
//            else
//                System.out.println("After upload, message: " + msg.message);
//        } catch (SDKException e) {
//            e.printStackTrace();
//        }
//
//        // TODO finish implementing the CRUD and corresponding checks. Typically, for
//        // the time being upload fails silently.
    }


    @Test
    public void testSkipVerify() {
        try {
            Map<String, TestConfiguration.ServerConfig> servers = config.getDefinedServers();
            for (String key : servers.keySet()) {

                TestConfiguration.ServerConfig currConf = servers.get(key);
                if (!currConf.skipVerify){
                    continue;
                }

                // Test Self signed URL
                ServerURL currURL;
                try {
                    currURL = ServerURLImpl.fromAddress(currConf.serverURL);
                    // => Selfsigned: ping fails
                    currURL.ping();
                } catch (Exception e) {
                    Assert.assertTrue(e instanceof SSLHandshakeException);
                    try {
                        currURL = ServerURLImpl.fromAddress(currConf.serverURL, true);
                        currURL.ping();
                    } catch (Exception e2) {
                        Assert.assertNull(e);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }

}