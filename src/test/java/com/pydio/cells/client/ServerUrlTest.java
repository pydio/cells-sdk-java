package com.pydio.cells.client;

import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.ServerURLImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class ServerUrlTest {

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void testCreateURL() {
        try {
            ServerURL httpURL = ServerURLImpl.fromAddress("http://localhost:8080/");
            Assert.assertEquals("http", httpURL.getURL().getProtocol());
            Assert.assertEquals("localhost", httpURL.getURL().getHost());
            Assert.assertEquals("localhost:8080", httpURL.getURL().getAuthority());
            Assert.assertEquals("", httpURL.getURL().getPath());

            try {
                httpURL = ServerURLImpl.fromAddress("http://localhost:8080/cells");
                Assert.assertTrue(false);
            } catch (MalformedURLException e) {
                // Expected
                Assert.assertNotNull(e);
            }

            ServerURL httpsSSURL = ServerURLImpl.fromAddress(" https://localhost:8080");
            Assert.assertEquals("https", httpsSSURL.getURL().getProtocol());
            Assert.assertEquals("localhost", httpsSSURL.getURL().getHost());
            Assert.assertEquals("localhost:8080", httpsSSURL.getURL().getAuthority());
            Assert.assertEquals("", httpsSSURL.getURL().getPath());

            ServerURL httpsFailURL = ServerURLImpl.fromAddress(" https://localhost:8080 ");
            ServerURL httpsURL = ServerURLImpl.fromAddress("https://cells.example.com ");
            ServerURL p8URL = ServerURLImpl.fromAddress("https://pydio8.example.com/");
            Assert.assertEquals("", p8URL.getURL().getPath());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertNull(e);
        }
    }
}
