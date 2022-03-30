package com.pydio.cells.client.model;

@Deprecated
public class BookmarkNode {
}

//extends AbstractNode {
//
//import com.pydio.cells.api.ui.AbstractNode;
//import com.pydio.cells.api.ui.Node;
//
//import java.util.Properties;
//
//public class BookmarkNode extends AbstractNode {
//
//    private final String label;
//    private Properties properties;
//
//    public BookmarkNode(String label) {
//        this.label = label;
//        this.properties = new Properties();
//    }
//
//    @Override
//    public int getType() {
//        return TYPE_BOOKMARK;
//    }
//
//    @Override
//    public String getId() {
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return label;
//    }
//
//    @Override
//    public String getPath() {
//        return "/";
//    }
//
//
//    @Override
//    public int compareTo(Node node) {
//        // TODO implement
//        if (node == null) {
//            return -1;
//        }
//
//        return label.compareTo(node.getName());
//    }
//}
