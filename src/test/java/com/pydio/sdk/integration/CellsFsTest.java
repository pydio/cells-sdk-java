package com.pydio.sdk.integration;

import com.pydio.sdk.api.Change;
import com.pydio.sdk.api.SDKException;
import com.pydio.sdk.core.CellsClient;
import com.pydio.sdk.api.nodes.ServerNode;
import com.pydio.sdk.core.auth.TokenService;
import com.pydio.sdk.core.auth.jwt.TokenMemoryStore;
import com.pydio.sdk.core.model.TreeNodeInfo;
import com.pydio.sdk.core.utils.CellsPath;
import com.pydio.sdk.sync.changes.GetChangeRequest;
import com.pydio.sdk.sync.changes.GetChangesResponse;
import com.pydio.sdk.sync.fs.CellsFs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default-target-server.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class CellsFsTest {

    private ServerNode node;
    private CellsClient cellsClient;
    private CellsFs cellsFs;
    private CecWrapper cec;

    private String serverURL, login, pwd, workspace;

    private TokenService tokens;
    private TestConfiguration config;

    @Before
    public void setup() {
        tokens = new TokenService(new TokenMemoryStore());
        config = new TestConfiguration();


//        node = new ServerNodeImpl();
//        Error error = node.resolve(serverURL);
//        if (error != null) {
//            System.out.println("Could not resolve server URL, cause: ");
//            System.out.println(error);
//        }
//
//        cellsClient = new CellsClient(node);
//        cellsClient.setCredentials(new PasswordCredentials(login, pwd));
//        cellsClient.setSkipOAuthFlag(true);
//
//        cellsFs = new CellsFs("test", cellsClient, workspace, new MemoryStateManager());
//
//        // Services
//        TokenService.init(new TokenMemoryStore());
//
//        // CellsClient
//        cec = new CecWrapper();
//        cec.setUpCec();
    }

    @Test
    public void testCecBasic() {
        try {
            cec.callCommand("mkdir", "-p", workspace + "/from-cec-tmp/test");
            cec.callCommand("mkdir", "-p", workspace + "/from-cec-tmp/test2");
            cec.callCommand("ls", workspace + "/from-cec");
            cec.callCommand("rm", "-f", workspace + "/from-cec-tmp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCellsClient() {
        System.out.println("... Test CellsClient");
        try {
            String fp = CellsPath.fullPath(workspace, "parent");
            TreeNodeInfo tni = cellsClient.statNode(fp);

            if (tni != null) {
                System.out.println("Found a node at " + fp);
                System.out.println(tni.getETag());
                System.out.println(tni.getLastEdit());
            }

        } catch (SDKException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetChange() {
        // GetChangeRequest req = new GetChangeRequest();
        // req.setPath("/");
        try {

            System.out.println("... Listing raw changes at root:");
            TreeMap<String, Change> changes = cellsFs.getRawChanges("/");
            for (String key : changes.keySet()) {
                System.out.println(changes.get(key).getType() + " - " + key);
            }

            System.out.println("... Listing raw changes under 'parent' folder:");
            changes = cellsFs.getRawChanges("parent");
            for (String key : changes.keySet()) {
                System.out.println(changes.get(key).getType() + " - " + key);
            }

            System.out.println("... High Level listing of changes at root:");
            GetChangeRequest req = new GetChangeRequest();
            req.setPath("/");
            GetChangesResponse response = cellsFs.getChanges(req);
            Assert.assertTrue(response.isSuccess());

            Iterator<Change> cIt = response.getChanges().iterator();
            while (cIt.hasNext()) {
                Change ch = cIt.next();
                String path = Change.TYPE_CREATE.equals(ch.getType()) || Change.TYPE_CONTENT.equals(ch.getType())
                        ? ch.getTarget()
                        : ch.getSource();
                System.out.println(ch.getType() + " - " + path);
            }

        } catch (SDKException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    @After
    public void teardown() {
        // do nothing
    }

}