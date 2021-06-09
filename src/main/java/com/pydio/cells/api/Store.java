package com.pydio.cells.api;

import java.util.Map;

public interface Store<T> {

    void put(String id, T obj);

    T get(String id);

    Map<String, T> getAll();

    void remove(String id);
}
