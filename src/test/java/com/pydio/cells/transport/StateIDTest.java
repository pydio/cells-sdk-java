package com.pydio.cells.transport;

import com.pydio.cells.api.CustomEncoder;
import com.pydio.cells.utils.JavaCustomEncoder;

import org.junit.Assert;
import org.junit.Test;

/**
 * Basic tests to insure encoding/decoding of states work as expected.
 */
public class StateIDTest {

    @Test
    public void testID() {
        StateID stateID = new StateID("doe@example.com", "https://example.com");
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
    }

    @Test
    public void testIDWithPath() {
        StateID stateID = new StateID("doe@example.com", "http://example.com:6767", "/common-files/Documents/Subfolder");
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals("doe@example.com", decodedStateID.getUsername());
        Assert.assertEquals("http://example.com:6767", decodedStateID.getServerUrl());
        Assert.assertEquals("/common-files/Documents/Subfolder", decodedStateID.getPath());
        Assert.assertEquals("common-files", decodedStateID.getWorkspace());
        Assert.assertEquals("/Documents/Subfolder", decodedStateID.getFile());
        Assert.assertEquals("Subfolder", decodedStateID.getFileName());
        Assert.assertEquals("/Documents", decodedStateID.getParentFile());


        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }

    @Test
    public void testRoots() {
        StateID stateID = new StateID("user", "https://example.com");
        String encodedID = stateID.getId();
        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertNull(decodedStateID.getPath());
        Assert.assertNull(decodedStateID.getFile());
        Assert.assertNull(decodedStateID.getFileName());
        Assert.assertNull(decodedStateID.getParentFile());

        StateID stateID2 = stateID.withPath("/common-files");
        Assert.assertEquals("/common-files", stateID2.getPath());
        Assert.assertEquals("/", stateID2.getFile());
        Assert.assertNull(stateID2.getFileName());
        Assert.assertNull(stateID2.getParentFile());

        StateID stateID3 = stateID.withPath("/common-files/");
        Assert.assertEquals("/common-files/", stateID3.getPath());
        Assert.assertEquals("/", stateID3.getFile());
        Assert.assertNull(stateID3.getFileName());
        Assert.assertNull(stateID3.getParentFile());

        StateID stateID4 = stateID.withPath("/common-files/folder");
        Assert.assertEquals("/common-files/folder", stateID4.getPath());
        Assert.assertEquals("/folder", stateID4.getFile());
        Assert.assertEquals("folder", stateID4.getFileName());
        Assert.assertEquals("/", stateID4.getParentFile());
    }

    @Test
    public void testChild() {
        StateID stateID = new StateID("user", "https://example.com", "/default");
        StateID child = stateID.child("folder");

        Assert.assertEquals("/default/folder", child.getPath());
        Assert.assertEquals("/folder", child.getFile());
        Assert.assertEquals("folder", child.getFileName());

        StateID child2 = child.child("");
        Assert.assertEquals("/default/folder", child2.getPath());
        Assert.assertEquals("/folder", child2.getFile());
        Assert.assertEquals("folder", child2.getFileName());
    }

        @Test
    public void testIDWithSpaceInPath() {
        String slug = "common-files";
        String parPath = "/Sample Documents to test.../Broken Names";
        String name = "Ô my $$… & ¼ !! @ https:breaking.com yeßßß #3.jpg";
        String breakingPath = "/" + slug + parPath + "/" + name;
        StateID stateID = new StateID("doe@example.com", "http://example.com:6767", breakingPath );
        String encodedID = stateID.getId();

        StateID decodedStateID = StateID.fromId(encodedID);

        Assert.assertEquals("doe@example.com", decodedStateID.getUsername());
        Assert.assertEquals("http://example.com:6767", decodedStateID.getServerUrl());
        Assert.assertEquals(breakingPath, decodedStateID.getPath());
        Assert.assertEquals(slug, decodedStateID.getWorkspace());
        Assert.assertEquals(parPath + "/" + name, decodedStateID.getFile());

        Assert.assertEquals(stateID.getUsername(), decodedStateID.getUsername());
        Assert.assertEquals(stateID.getServerUrl(), decodedStateID.getServerUrl());
        Assert.assertEquals(stateID.getFile(), decodedStateID.getFile());
    }

    @Test
    public void testIDWithIncomplete() {

        CustomEncoder encoder = new JavaCustomEncoder();

        String url = "http://example.com:6767";
        StateID stateID = StateID.fromId(encoder.utf8Encode(url));

        Assert.assertNull(stateID.getUsername());
        Assert.assertNull(stateID.getPath());
        Assert.assertEquals(url, stateID.getServerUrl());

        String userName = "john@example.com";
        stateID = StateID.fromId(encoder.utf8Encode(userName).concat("@").concat(encoder.utf8Encode(url)));

        Assert.assertEquals(userName, stateID.getUsername());
        Assert.assertNull(stateID.getPath());
        Assert.assertEquals(url, stateID.getServerUrl());

        //noinspection ConstantConditions
        stateID = StateID.fromId(null);
        Assert.assertNull(stateID);
        stateID = StateID.fromId("");
        Assert.assertNull(stateID);

    }
}
