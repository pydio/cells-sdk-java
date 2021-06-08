package com.pydio.cells.utils.tests;

/**
 * Simple object that exposes the basic information to be provided
 * to define a test {@code Session}
 */
public class RemoteServerConfig {

    /* Main account info */
    public String serverURL;
    public boolean skipVerify;
    public String login;

    /* Credentials */
    // Personal Access Token
    public String pat;
    // Simple clear text password (legacy, try to not use)
    public String pwd;

    /* Client preferences */
    public String defaultWS;

}
