package com.pydio.sdk.integration;

import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

import com.pydio.sdk.core.model.Change;
import com.pydio.sdk.core.model.ChangeNode;
import com.pydio.sdk.core.model.TreeNodeInfo;
import com.pydio.sdk.sync.tree.StateManager;

/** Exposes various static methods to ease test implementation */
public class TestUtils {

    public final static String parentPath = "sdk-tests";
    public final static String OS_MAC = "darwin";
    public final static String OS_LINUX = "linux";

    private static String OS = System.getProperty("os.name").toLowerCase();

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

}
