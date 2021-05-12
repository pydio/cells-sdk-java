package com.pydio.cells.client.utils;

import com.pydio.cells.api.callbacks.ServerResolver;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

public class ServerResolution {

    private static final HashMap<String, ServerResolver> resolvers = new HashMap<>();

    public static void register(String scheme, ServerResolver resolver) {
        resolvers.put(scheme, resolver);
    }

    public static void unregister(String scheme) {
        resolvers.remove(scheme);
    }

    public static String resolve(String url, boolean refresh) throws IOException {
        URI uri = URI.create(url);
        String scheme = uri.getScheme();
        String id = url.substring(scheme.length() + 3).replace("/", "");

        if (!resolvers.containsKey(scheme)) {
            throw new IOException("Unable to resolve server " + url);
        }
        return resolvers.get(scheme).resolve(id, refresh);
    }
}
