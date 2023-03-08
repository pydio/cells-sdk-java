package com.pydio.cells.legacy;

import static com.pydio.cells.api.SdkNames.NODE_PROPERTY_WORKSPACE_SLUG;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.utils.Str;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class P8NodeSaxHandler extends DefaultHandler {

    // private final String logTag = "P8NodeSaxHandler";

    // Legacy P8 property names: centralised here to avoid over-loading
    // the main SdkNames reference file.
    // Keys
    private final static String AJXP_WORKSPACE_ID = "repository_id";
    private final static String AJXP_IM_TIME = "ajxp_im_time";
    private final static String AJXP_IMAGE_TYPE = "image_type";
    private final static String AJXP_MIME = "ajxp_mime";
    private final static String AJXP_SHARED = "ajxp_shared";
    private final static String AJXP_FAV = "ajxp_bookmarked";
    // Rather confusing legacy nomenclature, we change this to path and filename in the
    // adapt property method to have a clearer API
    private final static String AJXP_PATH = "filename";
    // Remarkable values
    private final static String AJXP_MIME_RECYCLE = "ajxp_recycle";

    // Instance parameters
    private final NodeHandler mHandler;
    // Manage the fact that LS on p8 does returns the node's workspace slug
    private String parentSlug;
    private Map<String, String> knownWorkspaces;

    // Local variable
    private boolean mInsideTree = false;
    private String mInnerElement = "";
    private Properties p = null;

    public int mParsedCount = 0;
    public boolean mPagination = false;
    public int mPaginationTotalItem;
    public int mPaginationTotalPage;
    public int mPaginationCurrentPage;

    /**
     * This is the main entry point to tweak the parsed properties to have a cleaner model
     * (hopefully without breaking anything) and thus prepare a future migration.
     */
    private void commitProperties() {

        // Effective creation
        FileNode node = new FileNode(); // (FileNode) NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);

        // The slug is not returned by the query
        if (parentSlug != null) {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, parentSlug);
        } else if (knownWorkspaces != null && p.containsKey(AJXP_WORKSPACE_ID) && knownWorkspaces.containsKey(p.getProperty(AJXP_WORKSPACE_ID))) {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, knownWorkspaces.get(p.getProperty(AJXP_WORKSPACE_ID)));
        } else {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, "undefined");
        }

        // Change the legacy "filename" P8 property in Path and extract a filename
        String path = null;
        if (p.containsKey(AJXP_PATH)) {
            path = p.getProperty(AJXP_PATH);
            p.remove(AJXP_PATH);
        }
        if (Str.empty(path)) {
            path = "/";
        }
        p.setProperty(SdkNames.NODE_PROPERTY_PATH, path);

        int index = path.lastIndexOf("/");
        String name = "";
        if (index > -1 && path.length() > index + 1) {
            name = path.substring(path.lastIndexOf("/") + 1);
        }
        p.setProperty(SdkNames.NODE_PROPERTY_FILENAME, name);

        // Best effort to insure we have a usable mime type
        String type = SdkNames.NODE_MIME_FOLDER;
        if ("true".equals(p.getProperty(SdkNames.NODE_PROPERTY_IS_FILE))) {
            if (p.containsKey(AJXP_IMAGE_TYPE)) {
                type = p.getProperty(AJXP_IMAGE_TYPE);
                // TODO improve
                p.setProperty(SdkNames.NODE_PROPERTY_IS_PRE_VIEWABLE, "true");
                p.setProperty(SdkNames.NODE_PROPERTY_HAS_THUMB, "true");
            } else {
                type = SdkNames.NODE_MIME_DEFAULT;
            }
        } else if (p.containsKey(AJXP_MIME)) {
            if (AJXP_MIME_RECYCLE.equals(p.getProperty(AJXP_MIME))) {
                type = SdkNames.NODE_MIME_RECYCLE;
            }
        }
        p.setProperty(SdkNames.NODE_PROPERTY_MIME, type);

        // Migrate old names
        if (p.containsKey(AJXP_SHARED)) {
            p.setProperty(SdkNames.NODE_PROPERTY_SHARED, (String) p.get(AJXP_SHARED));
            p.remove(AJXP_SHARED);
        }
        if (p.containsKey(AJXP_FAV)) {
            p.setProperty(SdkNames.NODE_PROPERTY_BOOKMARK, (String) p.get(AJXP_FAV));
            p.remove(AJXP_FAV);
        }

        // Retrieve the MetaData and store it as properties for later use
        // Also stores a hash of the meta to ease detection of future change
        // (remote meta modification not always triggers a modification of the node's timestamp)
        TreeMap<String, String> metaMap = new TreeMap<>();
        Iterator itr = p.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) itr.next();
            metaMap.put(entry.getKey(), entry.getValue());
        }
        // This timestamp is set at each call: we don't want that as a meta in the persisted node,
        // otherwise the consequent diffs are always not equals
        // Rather skip the prop when doing the diff?
        metaMap.remove(AJXP_IM_TIME);

        StringBuilder builder = new StringBuilder();
        for (String value : metaMap.values()) {
            builder.append(value);
        }
        Properties metaProps = new Properties();
        metaProps.putAll(metaMap);

        node.setProperties(p);
        node.setMeta(metaProps);
        node.setProperty(SdkNames.NODE_PROPERTY_META_HASH, String.valueOf(builder.toString().hashCode()));

        // Pydio does not use an UUID, the path is good enough for now
        // TODO insure we are OK with Cells, should we have to add the slug to the path here?
        String p8Id = node.getWorkspace() + node.getPath();
        node.setProperty(SdkNames.NODE_PROPERTY_UID, p8Id);

        // Forward the unmarshalled clean node to the caller
        mHandler.onNode(node);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("pagination".equals(qName)) {
            mPagination = true;
            mPaginationTotalItem = Integer.parseInt(attributes.getValue("count"));
            mPaginationTotalPage = Integer.parseInt(attributes.getValue("total"));
            mPaginationCurrentPage = Integer.parseInt(attributes.getValue("current"));
        }

        if ("tree".equals(qName)) {
            mInsideTree = true;
            mParsedCount++;
            p = new Properties();
            for (int i = 0; i < attributes.getLength(); i++) {
                p.setProperty(attributes.getLocalName(i), attributes.getValue(i));
            }
            if (mParsedCount == 1) {
                // Simply skip root node
                p = null;
                // TODO smelly code, double check, mRootNode is never used
//                if ("".equals(p.getProperty(AJXP_PATH))) {
//                    p.setProperty(AJXP_PATH, "/");
//                }
//                FileNode mRootNode = (FileNode) NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);
//                p = null;
            }
        }

        if (!mInsideTree) return;

        if ("label".equals(qName.toLowerCase(Locale.ENGLISH)) || "description".equals(qName.toLowerCase(Locale.ENGLISH))) {
            mInnerElement = qName;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (mInsideTree && "tree".equals(qName)) {
            if (p != null) {

                // Prepare model migration from a P8-centered legacy model
                // to a model based on Cells API
                commitProperties();

                p = null;
            }
            mInsideTree = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (mInsideTree && p != null) {
            p.setProperty(mInnerElement, new String(ch, start, length));
        }
    }

    public void endDocument() {
    }

    public P8NodeSaxHandler(String parentSlug, NodeHandler nodeHandler) {
        this.mHandler = nodeHandler;
        this.parentSlug = parentSlug;
    }

    public P8NodeSaxHandler(Map<String, String> knownWorkspaces, NodeHandler nodeHandler) {
        this.mHandler = nodeHandler;
        this.knownWorkspaces = knownWorkspaces;
    }
}
