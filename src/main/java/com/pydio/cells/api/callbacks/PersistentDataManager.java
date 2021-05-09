package com.pydio.cells.api.callbacks;

import com.pydio.cells.api.Change;
import com.pydio.cells.api.nodes.ServerNode;
import com.pydio.cells.api.Session;

import java.security.cert.X509Certificate;

public interface PersistentDataManager {

    X509Certificate getCertificate(String alias);
    void addCertificate(String alias, X509Certificate cert);

    void saveServer(ServerNode node);
    ServerNode serverFromAddress(String address);
    ServerNode[] servers();

    void setPreference(String key, String value);
    void unsetPreference(String key);
    String getPreference();

    Session[] sessions();
    Session getSession(long id);
    void deleteSession(long id);
    void saveSession(Session s);
    void setSessionFolder(long session, String path);

    void saveChange(Change change);
    Change[] changes(long task);
    void delete(Change c);
    void deleteChanges(long task);
}
