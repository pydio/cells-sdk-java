package com.pydio.sdk.sync.tree;

import java.util.List;
import java.util.TreeMap;

import com.pydio.sdk.core.model.BasicTreeNodeInfo;
import com.pydio.sdk.core.model.TreeNodeInfo;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Wraps a TreeMap to simply store the full tree in memory. Children are
 * computed based on the passed path.
 */
public class MemoryStateManagerTest {

    private StateManager manager;

    @Before
    public void setup() {
        manager = new MemoryStateManager();
    }

    @Test
    public void testCrud() {
        manager.put("/", new BasicTreeNodeInfo("eTag", "/", "/", false, 0, "encoded"));
        TreeNodeInfo rootInfo = manager.get("/");
        Assert.assertEquals(rootInfo.getName(), "/");
        Assert.assertEquals(rootInfo.getPath(), "/");
        Assert.assertEquals(rootInfo.getETag(), "eTag");
        Assert.assertEquals(rootInfo.isLeaf(), false);
    }

    @After
    public void teardown() {
        manager = null;
    }

}
