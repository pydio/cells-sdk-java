package com.pydio.cells.legacy;

import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.callbacks.NodeHandler;
import com.pydio.cells.api.ui.FileNode;
import com.pydio.cells.api.ui.Node;
import com.pydio.cells.client.model.NodeFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Locale;
import java.util.Properties;

public class P8NodeSaxHandler extends DefaultHandler {

    // Legacy P8 properties name, centralised here to avoid overloading
    // the main SdkNames reference file.

    // Keys
    private final static String AJXP_IM_TIME = "ajxp_im_time";
    private final static String AJXP_IMAGE_TYPE = "image_type";
    private final static String AJXP_MIME = "ajxp_mime";

    // Remarkable values
    private final static String AJXP_MIME_RECYCLE = "ajxp_recycle";

    boolean mInsideTree = false;
    String mInnerElement = "";

    public int mParsedCount = 0;
    public boolean mPagination = false;
    public int mPaginationTotalItem;
    public int mPaginationTotalPage;
    public int mPaginationCurrentPage;
    public FileNode mRootNode;

    NodeHandler mHandler;
    Properties p = null;

    /**
     * This is the main entry point to tweak the parsed properties to have a cleaner model
     * (hopefully without breaking anything) and thus prepare a future migration
     */
    private void adaptProperties() {

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
        } else if (p.containsKey(AJXP_MIME)){
            if (AJXP_MIME_RECYCLE.equals(p.getProperty(AJXP_MIME))){
                type = SdkNames.NODE_MIME_RECYCLE;
            }
        }
        p.setProperty(SdkNames.NODE_PROPERTY_MIME, type);
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
                if ("".equals(p.getProperty(SdkNames.NODE_PROPERTY_FILENAME))) {
                    p.setProperty(SdkNames.NODE_PROPERTY_FILENAME, "/");
                }
                mRootNode = (FileNode) NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);
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

                // Prepare model migration from a Legacy P8 centered model
                // to a model based on Cells API
                adaptProperties();

                // TODO check and fix this: the path used as UUID is not OK.
                Node node = NodeFactory.createNode(Node.TYPE_REMOTE_NODE, p);
                if (node != null) {
                    node.setProperty(SdkNames.NODE_PROPERTY_UUID, node.getPath());
                    mHandler.onNode(node);
                }
                p = null;
            }
            mInsideTree = false;
            return;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (mInsideTree && p != null) {
            p.setProperty(mInnerElement, new String(ch, start, length));
        }
    }

    public void endDocument() {
    }

    public P8NodeSaxHandler(NodeHandler nodeHandler) {
        this.mHandler = nodeHandler;
    }
}
