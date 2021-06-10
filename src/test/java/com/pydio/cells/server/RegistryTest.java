package com.pydio.cells.server;

import com.pydio.cells.client.model.DocumentRegistry;
import com.pydio.cells.api.Registry;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class RegistryTest {

    private final static String registryResourcePath = "/samples/registry.xml";

    @Test
    public void testRegistryParsing() throws Exception {

        InputStream registryContent = getClass().getResourceAsStream(registryResourcePath);
        Registry registry = new DocumentRegistry(registryContent);

        // we must have actions and plugins
        Assert.assertNotEquals(0, registry.GetActions().size());
        Assert.assertNotEquals(0, registry.GetPlugins().size());

        // me must not have workspaces
        Assert.assertNotEquals(0, registry.GetWorkspaces().size());
    }
}
