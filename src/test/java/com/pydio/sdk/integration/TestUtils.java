package com.pydio.sdk.integration;

import com.pydio.cells.api.Change;
import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.ISession;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.nodes.ChangeNode;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.client.ServerURLImpl;
import com.pydio.cells.client.model.TreeNodeInfo;
import com.pydio.cells.client.security.P8Credentials;
import com.pydio.cells.client.security.PasswordCredentials;
import com.pydio.cells.sync.tree.StateManager;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

/**
 * Exposes various static methods to ease test implementation
 */
public class TestUtils {

    public final static String parentPath = "sdk-tests";
    public final static String OS_MAC = "darwin";
    public final static String OS_LINUX = "linux";
    private final static String SEED_CHARS = "abcdef1234567890";
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static ISession getSession(ServerFactory factory, TestConfiguration.ServerConfig conf) throws SDKException {
        ServerURL sURL = null;
        try {
            sURL = ServerURLImpl.fromAddress(conf.serverURL);
        } catch (MalformedURLException mue) {
            throw new SDKException(ErrorCodes.configuration_error, conf.serverURL + " is not a correct URL", mue);
        }
        Server server = factory.register(sURL);
        Credentials credentials;
        if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            credentials = new P8Credentials(conf.login, conf.pwd);
        } else {
            credentials = new PasswordCredentials(conf.login, conf.pwd);
        }
        return factory.registerAccount(sURL, credentials);
    }

    // Choose your version: randomString or getRandomPrefix.
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(SEED_CHARS.charAt(rand.nextInt(SEED_CHARS.length())));
        }
        return sb.toString();
    }

    // Only kept for the pattern 
    public static String getRandomPrefix() {
        int inf = 97; // letter 'a'
        int sup = 122; // 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(inf, sup + 1).limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        return generatedString;
    }

    public static String getUniquePath() {
        return parentPath + "/" + getRandomPrefix();
    }

    public static void dummyProcessChanges(StateManager manager, TreeMap<String, Change> changes) {

        Iterator<String> it = changes.keySet().iterator();
        while (it.hasNext()) {
            String currPath = it.next();
            Change currChange = changes.get(currPath);
            ChangeNode node = currChange.getNode();

            String eTag = node.getMd5();
            String path = node.getPath();
            // FIXME: we do not store this info in the change
            boolean isLeaf = path.lastIndexOf(".") > path.lastIndexOf("/");
            long size = node.getSize();
            long lastEdit = node.getmTime();

            switch (currChange.getType()) {
                case Change.TYPE_CREATE:
                    TreeNodeInfo ni = new TreeNodeInfo(eTag, path, isLeaf, size, lastEdit);
                    manager.put(path, ni);
                    break;
                case Change.TYPE_DELETE:
                    manager.remove(path);
                    break;
                case Change.TYPE_PATH:
                    throw new RuntimeException("Unimplemented case: move");
                case Change.TYPE_CONTENT:
                    throw new RuntimeException("Unimplemented case: update content");
                default:
                    throw new RuntimeException("Unknown change type: " + currChange.getType() + " for path " + currPath
                            + ". Cannot process.");
            }

        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isLinux() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }

    public static String getOS() {
        if (isLinux()) {
            return OS_LINUX;
        } else if (isMac()) {
            return OS_MAC;
        } else
            throw new RuntimeException("Unsupported OS");
    }
}
