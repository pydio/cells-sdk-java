package com.pydio.cells.legacy;

import com.pydio.cells.api.callbacks.ServerResolver;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

public class Configuration {
    public String endpoint;
    public String userAgent;
    public boolean selfSigned;
    public SSLContext sslContext;
    public HostnameVerifier hostnameVerifier;
    public ServerResolver resolver;
}
