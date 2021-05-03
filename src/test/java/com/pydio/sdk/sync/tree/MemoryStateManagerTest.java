package com.pydio.sdk.sync.tree;

import java.util.List;

import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.auth.jwt.TokenMemoryStore;
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

 //   @Before
//    public void setupServices() {
//        TokenService.init(new TokenMemoryStore());
//    }

    @Before
    public void setup() {
        manager = new MemoryStateManager();
    }

    @Test
    public void testBasicCrud() {
        manager.put("common-ws/", new TreeNodeInfo("eTag", "common-ws/", false, 0, 0));
        TreeNodeInfo rootInfo = manager.get("common-ws/");
        Assert.assertEquals(rootInfo.getName(), "/");
        Assert.assertEquals(rootInfo.getPath(), "common-ws/");
        Assert.assertEquals(rootInfo.getETag(), "eTag");
        Assert.assertEquals(rootInfo.isLeaf(), false);
    }

    @Test
    public void testGetChildren() {
        
        // Build a simple tree in the state manager 
        manager.put("common-ws/", new TreeNodeInfo("eTag", "common-ws/", false, 0, 0));
        manager.put("common-ws/parent", new TreeNodeInfo("eTag", "common-ws/parent", false, 0, 0));
        manager.put("common-ws/parent/child", new TreeNodeInfo("eTag2", "common-ws/parent/child", false, 0, 0));
        manager.put("common-ws/parent/child/node.txt", new TreeNodeInfo("eTag2", "common-ws/parent/child/node.txt", false, 0, 0));
        manager.put("common-ws/parent/child/greatchild", new TreeNodeInfo("eTag3", "common-ws/parent/child/greatchild", false, 0, 0));
        manager.put("common-ws/parent/childother", new TreeNodeInfo("eTag4", "common-ws/parent/childother", false, 0, 0));
        manager.put("common-ws/parent/child2", new TreeNodeInfo("eTag5", "common-ws/parent/child2", false, 0, 0));
        manager.put("common-ws/parent/child3", new TreeNodeInfo("eTag6", "common-ws/parent/child3", false, 0, 0));

        // Retrieve one node and check setters are ok. 
        TreeNodeInfo nodeInfo = manager.get("common-ws/parent/child");
        Assert.assertEquals(nodeInfo.getName(), "child");
        Assert.assertEquals(nodeInfo.getPath(), "common-ws/parent/child");
        Assert.assertEquals(nodeInfo.getETag(), "eTag2");
        Assert.assertEquals(nodeInfo.isLeaf(), false);

        // Check getChildren  
        List<TreeNodeInfo> children = manager.getChildren("common-ws/parent");
        Assert.assertTrue(children.size() >= 1);
        Assert.assertEquals(5, children.size());
    }

    @After
    public void teardown() {
        manager = null;
    }

}

// browse :
// compare => different
// update ETag state manager
// update Children manager
// add change create ("/parent")

// check children

// compare => different
// update state manager
// add change create ("/parent/child")

// check children children
// crash

// add change create ("/parent/child/node.txt")

// return (changes)
