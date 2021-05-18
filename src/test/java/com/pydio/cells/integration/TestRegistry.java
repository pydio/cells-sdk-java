package com.pydio.cells.integration;

import org.junit.Test;

/**
 * Registry can be downloaded whether the request is authenticated or not.
 *
 * When requesting the registry without authentication the server responds with what we call the
 * default registry info. The default registry info are actions and plugins. There are more info
 * but currently only plugins and actions are useful.
 *
 *
 * When requesting the registry with authentication data the server responds with user info in
 * addition of the default registry info. These additional info are the preferences of the user
 * and workspaces/cells they have access to
 *
 *
 * The approach for this test is to request the registry from both unauthenticated and authenticated
 * states and check if plugins and actions are available. When authenticated we check
 * if there are workspaces that reflects what is on the server side.
 */
public class TestRegistry {

    public void setup() {}

    @Test
    public void testDefaultRegistry() {}

    @Test
    public void testAuthenticatedUserRegistry() {}
}
