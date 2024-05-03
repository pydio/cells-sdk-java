package com.pydio.cells.client;

import com.pydio.cells.api.ServerURL;
import com.pydio.cells.transport.ServerURLImpl;

import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;

public class ServerUrlTest {

    @Test
    public void testCreateURL() throws MalformedURLException {
        ServerURL httpURL = ServerURLImpl.fromAddress("http://localhost:8080/");
        Assert.assertEquals("http", httpURL.getURL().getProtocol());
        Assert.assertEquals("localhost", httpURL.getURL().getHost());
        Assert.assertEquals("localhost:8080", httpURL.getURL().getAuthority());
        Assert.assertEquals("", httpURL.getURL().getPath());

        httpURL = ServerURLImpl.fromAddress("http://localhost:8080/cells");
        Assert.assertEquals("/cells", httpURL.getURL().getPath());

        ServerURL httpsSSURL = ServerURLImpl.fromAddress(" https://localhost:8080");
        Assert.assertEquals("https", httpsSSURL.getURL().getProtocol());
        Assert.assertEquals("localhost", httpsSSURL.getURL().getHost());
        Assert.assertEquals("localhost:8080", httpsSSURL.getURL().getAuthority());
        Assert.assertEquals("", httpsSSURL.getURL().getPath());

        ServerURL p8URL = ServerURLImpl.fromAddress("https://pydio8.example.com/");
        Assert.assertEquals("", p8URL.getURL().getPath());
    }

    @Test
    public void testWrappers() throws MalformedURLException {
        String base = "https://cells.example.com";
        String subPath = "/cells";
        String subSubPath = "/api/list";
        String query = "token=my-token&type=Bearer";
        String spec = subPath.concat("?").concat(query);
        String spec2 = subSubPath.concat("?").concat(query);
        String withPath = base.concat(subPath);

        ServerURL httpURL = ServerURLImpl.fromAddress(base);
        ServerURL wrappedURL = httpURL.withPath(subPath);
        wrappedURL = wrappedURL.withQuery(query);
        Assert.assertEquals(subPath, wrappedURL.getURL().getPath());
        Assert.assertEquals(query, wrappedURL.getURL().getQuery());
        ServerURL wrappedURL2 = httpURL.withSpec(spec);
        Assert.assertEquals(subPath, wrappedURL2.getURL().getPath());
        Assert.assertEquals(query, wrappedURL2.getURL().getQuery());

        httpURL = ServerURLImpl.fromAddress(withPath);
        wrappedURL = httpURL.withQuery(query);
        wrappedURL = wrappedURL.withPath(subSubPath);
        Assert.assertEquals(subPath.concat(subSubPath), wrappedURL.getURL().getPath());
        Assert.assertEquals(query, wrappedURL.getURL().getQuery());
        wrappedURL2 = httpURL.withSpec(spec2);
        Assert.assertEquals(subPath.concat(subSubPath), wrappedURL2.getURL().getPath());
        Assert.assertEquals(query, wrappedURL2.getURL().getQuery());
    }

}
