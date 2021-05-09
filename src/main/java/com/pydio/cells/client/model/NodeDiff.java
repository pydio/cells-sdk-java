package com.pydio.cells.client.model;

import com.pydio.cells.api.ui.Node;
import com.pydio.cells.api.SdkNames;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class NodeDiff {

    public ArrayList<Node> deleted = null;
    public ArrayList<Node> added = null;
    public ArrayList<Node> updated = null;

    public static NodeDiff create(Document doc){
        NodeDiff nodeDiff = new NodeDiff();
        org.w3c.dom.Node diff = doc.getElementsByTagName(SdkNames.XML_NODES_DIFF).item(0);

        if(diff != null) {
            for (int i = 0; i < diff.getChildNodes().getLength(); i++) {
                org.w3c.dom.Node child = diff.getChildNodes().item(i);
                String tag = child.getNodeName();

                ArrayList<Node> list = null;

                if (SdkNames.NODE_DIFF_REMOVE.equals(tag)) {
                    list = nodeDiff.deleted;
                } else if (SdkNames.NODE_DIFF_ADD.equals(tag)) {
                    list = nodeDiff.added;
                } else if (SdkNames.NODE_DIFF_UPDATE.equals(tag)) {
                    list = nodeDiff.updated;
                }

                if(list == null){
                    list = new ArrayList<>();
                }

                for (int j = 0; j < child.getChildNodes().getLength(); j++) {
                    org.w3c.dom.Node c = child.getChildNodes().item(j);
                    Node pydNode = NodeFactory.createNode(c);
                    if( pydNode != null){
                        list.add(pydNode);
                    }
                }
            }
        }

        return nodeDiff;
    }
}
