package com.pydio.cells.client.model;

import com.pydio.cells.api.Registry;
import com.pydio.cells.api.SdkNames;
import com.pydio.cells.api.ui.Plugin;
import com.pydio.cells.api.ui.WorkspaceNode;
import com.pydio.cells.utils.Log;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class DocumentRegistry implements Registry {

    private final static String logTag = "DocumentRegistry";

    private final static String P8_PREFIX = "ajxp_registry";
    private final static String CELLS_PREFIX = "pydio_registry";
    private final static String USER_NODE_NAME = "user";

    private String prefix;
    private boolean isLegacy;

    private Node userNode;

    final protected String ajxpRepositoriesXPath = "/user/repositories";
    final protected String ajxpActionsXPath = "/ajxp_registry/actions";
    final protected String ajxpPluginsXPath = "/ajxp_registry/plugins";
    final protected String pydioRepositoriesXPath = "/pydio_registry/user/repositories";

    private final Document xmlDocument;

    private List<WorkspaceNode> parsedWorkspaces;
    private List<Plugin> parsedPlugins;
    private List<Action> parsedActions;

    public DocumentRegistry(Document xmlDocument) {
        this.xmlDocument = xmlDocument;
        handleRoot();
    }

    public DocumentRegistry(InputStream in) throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        xmlDocument = builder.parse(in);
        // NodeList children = xmlDocument.getChildNodes();
        // for (int i = 0; i < children.getLength(); i++) {
        //     Log.i(logTag, i + ": " + children.item(i).toString());
        // }
        handleRoot();
    }

    private void handleRoot() {
        if (xmlDocument != null && xmlDocument.hasChildNodes()) {
            Node root = xmlDocument.getChildNodes().item(0);
            switch (root.getNodeName()) {
                case P8_PREFIX:
                    prefix = "/" + P8_PREFIX + "/";
                    isLegacy = true;
                    break;
                case CELLS_PREFIX:
                    prefix = "/" + CELLS_PREFIX + "/";
                    isLegacy = false;
                    break;
                default:
                    throw new RuntimeException("Unexpected root: " + root.getNodeName());
            }

            if (root != null && root.hasChildNodes()) {
                NodeList children = root.getChildNodes();
                for (int i = 0; i < children.getLength(); i++) {
                    if (USER_NODE_NAME.equals(children.item(i).getNodeName())) {
                        userNode = children.item(i);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean isLoggedIn() {
        return userNode != null;
    }

    @Override
    public List<WorkspaceNode> getWorkspaces() {
        if (parsedWorkspaces != null) {
            return parsedWorkspaces;
        }
        parsedWorkspaces = parseWorkspaces();
        return parsedWorkspaces;
    }

    private List<WorkspaceNode> parseWorkspaces() {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            List<WorkspaceNode> workspaceNodes = new ArrayList<>();
            NodeList repositoriesNode = (NodeList) xPath.compile(ajxpRepositoriesXPath).evaluate(xmlDocument, XPathConstants.NODESET);
            if (repositoriesNode.getLength() == 0) {
                repositoriesNode = (NodeList) xPath.compile(pydioRepositoriesXPath).evaluate(xmlDocument, XPathConstants.NODESET);
            }
            if (repositoriesNode.getLength() > 0) {
                NodeList repositoriesChildNodes = repositoriesNode.item(0).getChildNodes();
                for (int i = 0; i < repositoriesChildNodes.getLength(); i++) {
                    Node node = repositoriesChildNodes.item(i);
                    String tag = node.getNodeName();
                    if ("repo".equals(tag)) {
                        WorkspaceNode workspaceNode = parseWorkspace(node);
                        workspaceNodes.add(workspaceNode);
                    }
                }
            }
            return workspaceNodes;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private WorkspaceNode parseWorkspace(Node node) {
        NamedNodeMap attrs = node.getAttributes();

        Node id = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ID);
        Node acl = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ACL);
        Node slug = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_SLUG);
        Node owner = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_OWNER);
        Node crossCopy = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_CROSS_COPY);
        Node accessType = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_ACCESS_TYPE);
        Node repositoryType = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_TYPE);
        Node metaSync = attrs.getNamedItem(SdkNames.WORKSPACE_PROPERTY_META_SYNC);

        WorkspaceNode workspaceNode = new WorkspaceNode();

        if (acl != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_ACL, acl.getNodeValue());
        }
        if (id != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_ID, id.getNodeValue());
        }
        if (slug != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_SLUG, slug.getNodeValue());
        }
        if (owner != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_OWNER, owner.getNodeValue());
        }
        if (crossCopy != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_CROSS_COPY, crossCopy.getNodeValue());
        }
        if (accessType != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_ACCESS_TYPE, accessType.getNodeValue());
        }
        if (repositoryType != null) {
            String type = repositoryType.getNodeValue();
            if (isLegacy) { // Tweak when generating the local object to ease implementation of clients
                if ("my-files".equals(workspaceNode.getSlug())) {
                    type = SdkNames.WS_TYPE_PERSONAL;
                } else {
                    type = SdkNames.WS_TYPE_DEFAULT;
                }
                Log.e("DocumentRegistry", "Using document registry for a legacy server");
            }
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_TYPE, type);
        }
        if (metaSync != null) {
            workspaceNode.setProperty(SdkNames.WORKSPACE_PROPERTY_META_SYNC, metaSync.getNodeValue());
        }

        NodeList repoChildren = node.getChildNodes();
        for (int j = 0; j < repoChildren.getLength(); j++) {
            Node repoChildNode = repoChildren.item(j);
            String name = repoChildNode.getNodeName();
            switch (name) {
                case SdkNames.NODE_PROPERTY_LABEL:
                    workspaceNode.setProperty(SdkNames.NODE_PROPERTY_LABEL, repoChildNode.getFirstChild().getNodeValue());
                    break;
                case SdkNames.WORKSPACE_DESCRIPTION:
                    workspaceNode.setProperty(SdkNames.WORKSPACE_DESCRIPTION, repoChildNode.getFirstChild().getNodeValue());
                    break;
            }
        }

        return workspaceNode;
    }

    @Override
    public List<Action> getActions() {
        if (parsedActions != null) {
            return parsedActions;
        }
        return parsedActions = parseActions();
    }

    private List<Action> parseActions() {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            List<Action> actions = new ArrayList<>();

            Node repositoriesNode = (Node) xPath.compile(ajxpActionsXPath).evaluate(xmlDocument, XPathConstants.NODE);

            NodeList repositoriesChildNodes = repositoriesNode.getChildNodes();
            for (int i = 0; i < repositoriesChildNodes.getLength(); i++) {
                Node node = repositoriesChildNodes.item(i);
                final String tag = node.getNodeName();
                if ("action".equals(tag)) {
                    Action action = parseAction(node);
                    actions.add(action);
                }
            }
            return actions;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Action parseAction(Node node) {

        Boolean adminOnly = null,
                noUser = null,
                read = null,
                write = null,
                userLogged = null;

        // todo: add constant in SDKNames instead of hardcoded string
        NamedNodeMap attrs = node.getAttributes();

        boolean dirDefault = false;
        boolean fileDefault = false;
        String name = attrs.getNamedItem("name").getNodeValue();

        Node dirDefaultNode = attrs.getNamedItem("dirDefault");
        Node fileDefaultNode = attrs.getNamedItem("fileDefault");

        if (dirDefaultNode != null) {
            dirDefault = "true".equals(dirDefaultNode.getNodeValue());
        }

        if (fileDefaultNode != null) {
            fileDefault = "true".equals(fileDefaultNode.getNodeValue());
        }

        NodeList actionChildNodes = node.getChildNodes();
        for (int i = 0; i < actionChildNodes.getLength(); i++) {

            Node actionChildNode = node.getFirstChild();
            final String tag = actionChildNode.getNodeName();

            if ("rightsContext".equals(tag)) {
                NamedNodeMap rightsContextAttrs = node.getAttributes();

                Node attrAdminOnly = rightsContextAttrs.getNamedItem("adminOnly");
                if (attrAdminOnly != null) {
                    adminOnly = Boolean.valueOf(attrAdminOnly.getNodeValue());
                }

                Node attrNoUser = rightsContextAttrs.getNamedItem("noUser");
                if (attrNoUser != null) {
                    noUser = Boolean.valueOf(attrNoUser.getNodeValue());
                }

                Node attrRead = rightsContextAttrs.getNamedItem("read");
                if (attrRead != null) {
                    adminOnly = Boolean.valueOf(attrRead.getNodeValue());
                }

                Node attrWrite = rightsContextAttrs.getNamedItem("write");
                if (attrWrite != null) {
                    adminOnly = Boolean.valueOf(attrWrite.getNodeValue());
                }

                Node attrUserLogged = rightsContextAttrs.getNamedItem("userLogged");
                if (attrUserLogged != null) {
                    adminOnly = Boolean.valueOf(attrUserLogged.getNodeValue());
                }

            }
        }
        return new Action(name, dirDefault, fileDefault, write, read, adminOnly, userLogged, noUser);
    }

    @Override
    public List<Plugin> getPlugins() {
        if (parsedPlugins != null) {
            return parsedPlugins;
        }
        return parsedPlugins = parsePlugins();
    }

    private List<Plugin> parsePlugins() {
        XPath xPath = XPathFactory.newInstance().newXPath();
        try {
            List<Plugin> plugins = new ArrayList<>();

            Node pluginsNode = (Node) xPath.compile(ajxpPluginsXPath).evaluate(xmlDocument, XPathConstants.NODE);
            NodeList repositoriesChildNodes = pluginsNode.getChildNodes();
            for (int i = 0; i < repositoriesChildNodes.getLength(); i++) {
                Node node = repositoriesChildNodes.item(i);
                final String tag = node.getNodeName();
                if ("ajxp_plugin".equals(tag) || "plugin".equals(tag)) {
                    Plugin plugin = parsePlugin(node);
                    plugins.add(plugin);
                }
            }
            return plugins;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Plugin parsePlugin(Node node) {
        Properties properties = null;

        NamedNodeMap attrs = node.getAttributes();
        String id = attrs.getNamedItem("id") != null ? attrs.getNamedItem("id").getNodeValue() : "";
        String name = attrs.getNamedItem("name") != null ? attrs.getNamedItem("name").getNodeValue() : "";
        String label = attrs.getNamedItem("label") != null ? attrs.getNamedItem("label").getNodeValue() : "";
        String description = attrs.getNamedItem("description") != null ? attrs.getNamedItem("description").getNodeValue() : "";


        NodeList pluginChildNodes = node.getChildNodes();

        for (int i = 0; i < pluginChildNodes.getLength(); i++) {
            Node pluginChildNode = pluginChildNodes.item(i);
            String tag = pluginChildNode.getNodeName();
            if ("plugin_configs".equals(tag)) {

                properties = parsePluginProperties(pluginChildNode);
                break;
            }
        }

        return new Plugin(id, name, label, description, properties);
    }

    private Properties parsePluginProperties(Node node) {
        Properties properties = new Properties();
        NodeList propertyNodes = node.getChildNodes();
        for (int i = 0; i < propertyNodes.getLength(); i++) {
            Node propertyNode = propertyNodes.item(i);
            String tag = propertyNode.getNodeName();
            if ("property".equals(tag)) {
                String propName = propertyNode.getAttributes().getNamedItem("name").getNodeValue();
                String value = propertyNode.getFirstChild().getNodeValue();
                properties.setProperty(propName, value);
            }
        }
        return properties;
    }
}
