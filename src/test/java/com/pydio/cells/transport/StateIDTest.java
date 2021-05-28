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
        StateID stateID = new StateID("doe@gmail.com", "http://doefiles.com:6767", "/common-files/Sample Documents to test.../Broken Names/IMG-20201118-WA0001.jpg");
        String encodedID = stateID.getId();

        // https%3A%2F%2Fandroid21.ci.pyd.io%2Fcommon-files%2FSample+Documents+to+test...%2FBroken+Names%2FIMG-20201118-WA0001.jpg

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals("doe@gmail.com", decodedStateID.getUsername());
        Assert.assertEquals("http://doefiles.com:6767", decodedStateID.getServerUrl());
        Assert.assertEquals("/common-files/Sample Documents to test.../Broken Names/IMG-20201118-WA0001.jpg", decodedStateID.getPath());
        Assert.assertEquals("common-files", decodedStateID.getWorkspace());
        Assert.assertEquals("/Sample Documents to test.../Broken Names/IMG-20201118-WA0001.jpg", decodedStateID.getFile());


        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }




}
