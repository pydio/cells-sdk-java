package com.pydio.sdk.core.model;

import com.pydio.sdk.api.Node;
import com.pydio.sdk.api.nodes.WorkspaceNode;

import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Properties;

public class NodeFactory {

    public static Node createNode(int type, org.w3c.dom.Node xmlNode) {
        Node node = newNode(type);
        Properties p = new Properties();
        if (xmlNode.hasAttributes()) {
            NamedNodeMap map = xmlNode.getAttributes();
            for (int i = 0; i < map.getLength(); i++) {
                Attr at = (Attr) map.item(i);
                String attrName = at.getNodeName();
                String attrValue = at.getNodeValue();
                p.setProperty(attrName, attrValue);
            }
        }
        if (node != null) {
            node.setProperties(p);
        }
        return node;
    }

    public static Node createNode(int type) {
        return newNode(type);
    }

    public static Node createNode(org.w3c.dom.Node xml) {
        String nodeName = xml.getNodeName();
        if ("repo".equals(nodeName)) {
            return createNode(Node.TYPE_WORKSPACE, xml);
        } else if ("tree".equals(nodeName)) {
            return createNode(Node.TYPE_REMOTE_NODE, xml);
        }
        return null;
    }

    public static Node createNode(int type, Properties prop) {
        Node node = newNode(type);
        if (node == null) {
            return null;
        }
        node.setProperties(prop);
        return node;
    }

    private static Node newNode(int type) {
        switch (type) {
            case Node.TYPE_REMOTE_NODE:
                return new FileNodeImpl();
            case Node.TYPE_WORKSPACE:
                return new WorkspaceNode();
            case Node.TYPE_SERVER:
                throw new RuntimeException("Broken after refactoring cannot create server node object without URL ");
                // return new ServerNodeImpl();
            case Node.TYPE_LOCAL_NODE:
                return new ObjectNode();
            default:
                return null;
        }
    }

    public static byte[] serialize(Node node) {
        // FIXME close stream cleanly
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ObjectOutput out = new ObjectOutputStream(bos);
            out.writeObject(node);
            out.close();
            byte[] buf = bos.toByteArray();
            return buf;
        } catch (IOException ioe) {
            return null;
        }
    }

    public static com.pydio.sdk.api.Node deserialize(byte[] buffer) {
        // FIXME close stream cleanly
        try {
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer));
            Object object = in.readObject();
            in.close();
            return (Node) object;
        } catch (ClassNotFoundException cnfe) {
            return null;
        } catch (IOException ioe) {
            return null;
        }
    }
}
