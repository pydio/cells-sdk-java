package com.pydio.cells.transport;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StateIDTest {

    @Before
    public void setup() {}

    @After
    public void teardown() {}

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
        StateID stateID = new StateID("doe@gmail.com", "https://doefiles.com", "/common-files/Documents");
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }
}
