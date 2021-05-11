package com.pydio.cells.api.ui;

/**
 * Represents the simplified result of a stat request to the server at a given path,
 * only keeping useful information
 */
public class Stats {

    private String hash;
    private long size;
    private long mTime;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }
}
