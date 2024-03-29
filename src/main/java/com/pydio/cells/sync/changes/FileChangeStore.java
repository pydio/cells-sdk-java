package com.pydio.cells.sync.changes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydio.cells.api.Change;
import com.pydio.cells.utils.IoHelpers;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TreeMap;

public class FileChangeStore implements ChangeStore {

    private final String filePath;
    private SortedMap<String, Change> changes;

    private final Type classType = new TypeToken<SortedMap<String, Change>>() {
    }.getType();

    public FileChangeStore(String filePath) throws IOException {
        this.filePath = filePath;
        load();
    }

    @Override
    public synchronized void putChanges(List<Change> list) {
        for (Change c : list) {
            String key = String.format(Locale.US, "%s->%s:%d", c.getSourceSide(), c.getTargetSide(), c.getSeq());
            changes.put(key, c);
        }
        try {
            save();
        } catch (IOException ignored) {
        }
    }

    @Override
    public synchronized void deleteChange(Change c) {
        String key = String.format(Locale.US, "%s->%s:%d", c.getSourceSide(), c.getTargetSide(), c.getSeq());
        changes.remove(key);
        try {
            save();
        } catch (IOException ignored) {
        }
    }

    @Override
    public synchronized void putChange(Change c) {
        String key = String.format(Locale.US, "%s->%s:%d", c.getSourceSide(), c.getTargetSide(), c.getSeq());
        changes.put(key, c);
        try {
            save();
        } catch (IOException ignored) {
        }
    }

    @Override
    public synchronized List<Change> getChanges(int count) {
        Iterator it = changes.keySet().iterator();
        ArrayList<Change> result = new ArrayList<>();
        while (it.hasNext() && result.size() < count) {
            String k = (String) it.next();
            Change c = changes.get(k);
            result.add(c);
        }
        return result;
    }

    @Override
    public synchronized int count() {
        return changes.size();
    }

    private void save() throws IOException {
        Gson gson = new Gson();
        String encoded = gson.toJson(changes);
        IoHelpers.writeFile(encoded.getBytes(), this.filePath);
    }

    private void load() throws IOException {
        try {
            byte[] bytes = IoHelpers.readFile(this.filePath);
            Gson gson = new Gson();
            changes = gson.fromJson(new String(bytes), classType);
        } catch (IOException ignored) {
        }
        if (changes == null) {
            changes = new TreeMap<>();
        }
    }
}
