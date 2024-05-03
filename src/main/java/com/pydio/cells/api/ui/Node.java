package com.pydio.cells.api.ui;

import java.io.Serializable;
import java.util.Properties;

public interface Node extends Serializable {

    int TYPE_REMOTE_NODE = 1;
    int TYPE_WORKSPACE = 2;
    int TYPE_SERVER = 3;

//    int TYPE_LOCAL_NODE = 4;
//
//    int TYPE_BOOKMARK = 6;
//    int TYPE_SEARCH = 5;
//    int TYPE_ACTIVITY = 7;
//    int TYPE_SELECTION = 8;
//    int TYPE_OFFLINE = 9;

//    int same = 0;
//    int content = 1;
//    int different = 2;


    void setProperties(Properties p);

    Properties getProperties();

    String getProperty(String key);

    void setProperty(String key, String value);

    int getType();

    String getId();

    String getPath();

    String getName();

    String getLabel();

    int compareTo(Node node);
}
