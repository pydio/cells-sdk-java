package com.pydio.cells.legacy;

import static com.pydio.cells.api.SdkNames.NODE_PROPERTY_WORKSPACE_SLUG;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Node;
import com.pydio.cells.client.model.NodeFactory;
import com.pydio.cells.utils.Log;
import com.pydio.cells.utils.Str;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public class P8NodeSaxHandler extends DefaultHandler {

    private final String logTag = P8NodeSaxHandler.class.getSimpleName();

    // Legacy P8 property names: centralised here to avoid over-loading
    // the main SdkNames reference file.
    // Keys
    private final static String AJXP_WORKSPACE_ID = "repository_id";
    private final static String AJXP_IM_TIME = "ajxp_im_time";
    private final static String AJXP_IMAGE_TYPE = "image_type";
    private final static String AJXP_MIME = "ajxp_mime";
    private final static String AJXP_SHARED = "ajxp_shared";
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
    private void adaptProperties() {

        // The slug is not returned by the query
        if (parentSlug != null) {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, parentSlug);
        } else if (knownWorkspaces != null && p.containsKey(AJXP_WORKSPACE_ID) && knownWorkspaces.containsKey(p.getProperty(AJXP_WORKSPACE_ID))) {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, knownWorkspaces.get(p.getProperty(AJXP_WORKSPACE_ID)));
        } else {
            p.setProperty(NODE_PROPERTY_WORKSPACE_SLUG, "undefined");
        }

        // This timestamp is set at each call: we don't want that as a meta in the persisted node,
        // otherwise the consequent diffs are always not equals
        // Rather skip the prop when doing the diff?
        p.remove(AJXP_IM_TIME);

        // Best effort to insure we have a usable mime type
        String type = SdkNames.NODE_MIME_FOLDER;
        if ("true".equals(p.getProperty(SdkNames.NODE_PROPERTY_IS_FILE))) {
            if (p.containsKey(AJXP_IMAGE_TYPE)) {
                type = p.getProperty(AJXP_IMAGE_TYPE);
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
        String name = "";

        int index = path.lastIndexOf("/");
        if (index > -1 && path.length() > index + 1) {
            name = path.substring(path.lastIndexOf("/") + 1);
        }
        p.setProperty(SdkNames.NODE_PROPERTY_FILENAME, name);
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
                if ("".equals(p.getProperty(AJXP_PATH))) {
                    p.setProperty(AJXP_PATH, "/");
                }
                FileNode mRootNode = (FileNode) NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);
                p = null;
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
                adaptProperties();

                FileNode node = (FileNode) NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);
                if (node != null) {
                    String p8Id = node.getWorkspace() + node.getPath();
                    node.setProperty(SdkNames.NODE_PROPERTY_UID, p8Id);
                    mHandler.onNode(node);
                }
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
