package com.pydio.sdk.sync.tree;

import java.util.List;

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
    public void testBasicCrud() {
        manager.put("/", new BasicTreeNodeInfo("eTag", "/", "/", false, 0, "encoded"));
        TreeNodeInfo rootInfo = manager.get("/");
        Assert.assertEquals(rootInfo.getName(), "/");
        Assert.assertEquals(rootInfo.getPath(), "/");
        Assert.assertEquals(rootInfo.getETag(), "eTag");
        Assert.assertEquals(rootInfo.isLeaf(), false);
    }


    @Test
    public void testGetChildren() {
        manager.put("/", new BasicTreeNodeInfo("eTag", "/", "/", false, 0, "encoded"));
        manager.put("/parent", new BasicTreeNodeInfo("eTag", "/parent", "parent", false, 0, "encoded"));
        manager.put("/parent/child", new BasicTreeNodeInfo("eTag", "/parent/child", "child", false, 0, "encoded"));
        manager.put("/parent/child/greatchild", new BasicTreeNodeInfo("eTag", "/parent/child/greatchild", "greatchild", false, 0, "encoded"));
        manager.put("/parent/childother", new BasicTreeNodeInfo("eTag", "/parent/childother", "childother", false, 0, "encoded"));
        manager.put("/parent/child2", new BasicTreeNodeInfo("eTag", "/parent/child2", "child2", false, 0, "encoded"));
        manager.put("/parent/child3", new BasicTreeNodeInfo("eTag", "/parent/child3", "child3", false, 0, "encoded"));


        TreeNodeInfo nodeInfo = manager.get("/parent/child");
        Assert.assertEquals(nodeInfo.getName(), "child");
        Assert.assertEquals(nodeInfo.getPath(), "/parent/child");
        Assert.assertEquals(nodeInfo.getETag(), "eTag");
        Assert.assertEquals(nodeInfo.isLeaf(), false);

        List<TreeNodeInfo> children = manager.getChildren("/parent");
        Assert.assertTrue(children.size() >= 1);
        Assert.assertEquals(children.size(), 4);
 
    }


    @After
    public void teardown() {
        manager = null;
    }

}
