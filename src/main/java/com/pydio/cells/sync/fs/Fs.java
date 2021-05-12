package com.pydio.cells.sync.fs;

import com.pydio.cells.sync.changes.GetChangeRequest;
import com.pydio.cells.sync.changes.GetChangesResponse;
import com.pydio.cells.sync.changes.ProcessChangeRequest;
import com.pydio.cells.sync.changes.ProcessChangeResponse;
import com.pydio.cells.sync.content.ContentLoader;

import java.util.List;

public interface Fs {

    String id();

    List<String> getWatches();

    void addWatch(String path);

    GetChangesResponse getChanges(GetChangeRequest request);

    ProcessChangeResponse processChange(ProcessChangeRequest request);

    ContentLoader getContentLoader();

    boolean receivesEvents();

    boolean sendsEvents();
}
