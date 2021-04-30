package com.pydio.sdk.core;

import com.pydio.sdk.api.ServerURL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ServerUrlTest {

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Ignore("Skipping tests on SSL Variants: we do not have various servers with various conf all the time, manually enable them when useful")
    @Test
    public void testSSLVariants() {
        try {
            // ServerURL httpURL = ServerURLImpl.fromAddress("http://localhost:8080", false, true);
            // ServerURL httpsSSURL = ServerURLImpl.fromAddress("https://localhost:8080", true, true);
            // ServerURL httpsFailURL = ServerURLImpl.fromAddress("https://localhost:8080", false, true);
            ServerURL httpsURL = ServerURLImpl.fromAddress("https://cells.example.com", false, true);
            ServerURL p8URL = ServerURLImpl.fromAddress("https://pydio8.example.com", false, true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }


    @Test
    public void testCreateURL() {
        try {
            ServerURL httpURL = ServerURLImpl.fromAddress("http://localhost:8080", false, false);
            ServerURL httpsSSURL = ServerURLImpl.fromAddress("https://localhost:8080", true, false);
            ServerURL httpsFailURL = ServerURLImpl.fromAddress("https://localhost:8080", false, false);
            ServerURL httpsURL = ServerURLImpl.fromAddress("https://cells.example.com", false, false);
            ServerURL p8URL = ServerURLImpl.fromAddress("https://pydio8.example.com", false, false);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }
}
