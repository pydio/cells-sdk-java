package com.pydio.cells.server;

import com.pydio.cells.client.model.DocumentRegistry;
import com.pydio.cells.api.Registry;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

public class RegistryTest {

    final String registryResourcePath = "/registry.xml";

    @Test
    public void testRegistryParsing() {
        InputStream registryContent = getClass().getResourceAsStream(registryResourcePath);

        Registry registry;

        try {
            registry = new DocumentRegistry(registryContent);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            Assert.fail();
            return;
        }

        // we must have actions and plugins
        Assert.assertNotEquals(0, registry.GetActions().size());
        Assert.assertNotEquals(0, registry.GetPlugins().size());

        // me must not have workspaces
        Assert.assertNotEquals(0, registry.GetWorkspaces().size());
    }
}
