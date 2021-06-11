package com.pydio.cells.integration.sync;

import com.pydio.cells.api.Change;
import com.pydio.cells.api.Client;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Transport;
import com.pydio.cells.api.ui.Stats;
import com.pydio.cells.sync.changes.GetChangeRequest;
import com.pydio.cells.sync.changes.GetChangesResponse;
import com.pydio.cells.sync.fs.CellsFs;
import com.pydio.cells.utils.CellsPath;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.tests.CecWrapper;
import com.pydio.cells.utils.tests.RemoteServerConfig;
import com.pydio.cells.utils.tests.TestClientFactory;
import com.pydio.cells.utils.tests.TestConfiguration;
import com.pydio.cells.utils.tests.TestUtils;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Performs basic tests against a running Cells instance. You must first adapt
 * the "src/test/resources/default.properties" file to match your setup.
 * <p>
 * You can then launch the test with:
 *
 * <code>./gradlew build -Dtest.profile=integration</code>
 */
public class CellsFsTest {

    private TestClientFactory factory;
    private String testRunID;
    private RemoteServerConfig cellsConf;
    private String workspace;

    private static CellsFs cellsFs;
    private static CecWrapper cec;

    private final String currConfId = "cells-https";

    @Before
    public void setup() throws IOException {
        testRunID = TestUtils.randomString(4);
        factory = new TestClientFactory();
        cellsConf = TestConfiguration.getDefault().getServer(currConfId);
        if (cellsConf == null){
            return;
        }
        workspace = cellsConf.defaultWS;

        try {
            String fileName = "prepare-cec.sh";
            ClassLoader classLoader = getClass().getClassLoader();
            URL scriptURL = classLoader.getResource(fileName);
            if (scriptURL == null) {
                throw new IOException("Could not find script to prepare the cec command");
            }
            Path parent = Path.of(scriptURL.toURI()).getParent();
            Path props = Path.of(parent.toString(), "accounts", currConfId + ".properties");
            cec = new CecWrapper();
            cec.setUpCec(scriptURL.getPath(), parent.toString(), props.toString());

        } catch (URISyntaxException e) { // Should not happen...
            throw new IOException("Could create URI from retrieved URL");
        }

//        basePath = Paths.get(url.getPath()).getParent().toString();
//        cecCmd = Paths.get(basePath, "cells-client").toString();

    }

    @AfterClass
    public static void teardown() {
        // do nothing
    }

    @Test
    public void testCecBasic() throws Exception {
        if (cellsConf == null){
            return;
        }

        cec.callCommand("mkdir", "-p", workspace + "/from-cec-tmp/test");
        cec.callCommand("mkdir", "-p", workspace + "/from-cec-tmp/test2");
        cec.callCommand("ls", workspace + "/from-cec");
        cec.callCommand("rm", "-f", workspace + "/from-cec-tmp");
    }

    @Test
    public void testCellsClient() throws SDKException {
        if (cellsConf == null) {
            Log.w("Unsupported conf", "No Pydio Cells configuration found, skipping");
            return;
        }

        Transport cellsTransport = TestUtils.getTransport(factory, cellsConf);
        Client client = factory.getClient(cellsTransport);


        String fp = CellsPath.fullPath(workspace, "parent");
        Stats stats = client.stats(workspace, "/", false);

        if (stats != null) {
            System.out.println("Found a node at " + fp);
            System.out.println(stats.getmTime());
            System.out.println(stats.getHash());
        }

    }

    @Ignore
    @Test
    public void testGetChange() throws SDKException {
        // GetChangeRequest req = new GetChangeRequest();
        // req.setPath("/");

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

    }

}