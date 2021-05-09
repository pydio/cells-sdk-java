package com.pydio.cells.sync.changes;

import com.pydio.cells.api.Change;
import com.pydio.cells.sync.content.ContentLoader;

public class ProcessChangeRequest {
    private Change change;
    private ContentLoader contentLoader;

    public Change getChange() {
        return change;
    }

    public void setChange(Change change) {
        this.change = change;
    }

    public ContentLoader getContentLoader() {
        return contentLoader;
    }

    public void setContentLoader(ContentLoader contentLoader) {
        this.contentLoader = contentLoader;
    }
}
