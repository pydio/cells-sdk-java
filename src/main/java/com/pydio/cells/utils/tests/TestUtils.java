package com.pydio.cells.utils.tests;

import com.pydio.cells.api.Credentials;
import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.Server;
import com.pydio.cells.api.ServerURL;
import com.pydio.cells.api.Transport;
import com.pydio.cells.client.ServerFactory;
import com.pydio.cells.transport.auth.credentials.LegacyPasswordCredentials;
import com.pydio.cells.legacy.P8Credentials;
import com.pydio.cells.transport.ServerURLImpl;

import java.net.MalformedURLException;
import java.util.Random;

/**
 * Exposes various static methods to ease test implementation
 */
public class TestUtils {

    public final static String parentPath = "sdk-tests";
    public final static String OS_MAC = "darwin";
    public final static String OS_LINUX = "linux";

    private final static String SEED_CHARS = "abcdef1234567890";
    private final static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * Create a new transport that is already logged in and ready to use.
     */
    public static Transport getTransport(ServerFactory factory, RemoteServerConfig conf) throws SDKException {
        ServerURL sURL;
        try {
            sURL = ServerURLImpl.fromAddress(conf.serverURL, conf.skipVerify);
        } catch (MalformedURLException mue) {
            throw new SDKException(ErrorCodes.configuration_error, conf.serverURL + " is not a correct URL", mue);
        }
        Server server = factory.register(sURL);
        Credentials credentials;
        if (SdkNames.TYPE_LEGACY_P8.equals(server.getRemoteType())) {
            credentials = new P8Credentials(conf.login, conf.pwd);
        } else {
            credentials = new LegacyPasswordCredentials(conf.login, conf.pwd);
        }
        return factory.registerAccount(sURL, credentials);
    }

    /* Optimistic helper to get a unique string */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(SEED_CHARS.charAt(rand.nextInt(SEED_CHARS.length())));
        }
        return sb.toString();
    }

    public static String getUniquePath() {
        return parentPath + "/" + randomString(6);
    }

//    public static void dummyProcessChanges(StateManager manager, TreeMap<String, Change> changes) {
//
//        for (String currPath : changes.keySet()) {
//            Change currChange = changes.get(currPath);
//            ChangeNode node = currChange.getNode();
//
//            String eTag = node.getMd5();
//            String path = node.getPath();
//            // FIXME: we do not store this info in the change
//            boolean isLeaf = path.lastIndexOf(".") > path.lastIndexOf("/");
//            long size = node.getSize();
//            long lastEdit = node.getmTime();
//
//            switch (currChange.getType()) {
//                case Change.TYPE_CREATE:
//                    TreeNodeInfo ni = new TreeNodeInfo(eTag, path, isLeaf, size, lastEdit);
//                    manager.put(path, ni);
//                    break;
//                case Change.TYPE_DELETE:
//                    manager.remove(path);
//                    break;
//                case Change.TYPE_PATH:
//                    throw new RuntimeException("Unimplemented case: move");
//                case Change.TYPE_CONTENT:
//                    throw new RuntimeException("Unimplemented case: update content");
//                default:
//                    throw new RuntimeException("Unknown change type: " + currChange.getType() + " for path " + currPath
//                            + ". Cannot process.");
//            }
//
//        }
//    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isLinux() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
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
