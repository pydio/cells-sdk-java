package com.pydio.cells.transport;

import org.junit.Assert;
import org.junit.Test;

/**
 * Basic tests to insure encoding / decoding of states works as expected
 */
public class StateIDTest {

    @Test
    public void testID() {
        StateID stateID = new StateID("doe@gmail.com", "https://doefiles.com");
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
    }

    @Test
    public void testIDWithPath() {
        StateID stateID = new StateID("doe@gmail.com", "http://doefiles.com:6767", "/common-files/Documents/Subfolder");
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals("doe@gmail.com", decodedStateID.getUsername());
        Assert.assertEquals("http://doefiles.com:6767", decodedStateID.getServerUrl());
        Assert.assertEquals("/common-files/Documents/Subfolder", decodedStateID.getPath());
        Assert.assertEquals("common-files", decodedStateID.getWorkspace());
        Assert.assertEquals("/Documents/Subfolder", decodedStateID.getFile());


        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }

    @Test
    public void testIDWithSpaceInPath() {
        String slug = "common-files";
        String parPath = "/Sample Documents to test.../Broken Names";
        String name = "Ô my $$… & ¼ !! @ https:breaking.com yeßßß #3.jpg";
        String breakingPath = "/" + slug + parPath + "/" + name;
        StateID stateID = new StateID("doe@gmail.com", "http://doefiles.com:6767", breakingPath );
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals("doe@gmail.com", decodedStateID.getUsername());
        Assert.assertEquals("http://doefiles.com:6767", decodedStateID.getServerUrl());
        Assert.assertEquals(breakingPath, decodedStateID.getPath());
        Assert.assertEquals(slug, decodedStateID.getWorkspace());
        Assert.assertEquals(parPath + "/" + name, decodedStateID.getFile());

        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }




}
