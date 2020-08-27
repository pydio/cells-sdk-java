package com.pydio.sdk.core;

import com.pydio.sdk.core.model.ServerNode;

import java.util.HashMap;
import java.util.Map;

public abstract class ClientFactory {

    final static Integer lock = 1;
    private static ClientFactory defaultFactory;

    private static Map<String, ClientFactory> namedFactories = new HashMap<>();

    public static void register(String name, ClientFactory f) {
        synchronized (lock) {
            namedFactories.put(name, f);
        }
    }

    public static ClientFactory named(String name) {
        synchronized (lock) {
            if (namedFactories.containsKey(name)) {
                return namedFactories.get(name);
            }
            return namedFactories.get("default");
        }
    }

    public static void register(ClientFactory f) {
        synchronized (lock) {
            defaultFactory = f;
        }
    }

    public static ClientFactory get() {
        synchronized (lock) {
            if (defaultFactory == null) {
                defaultFactory = new DefaultClientFactory();
            }
            return defaultFactory;
        }
    }

    public abstract Client Client(ServerNode node);
}
