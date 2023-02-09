package com.pydio.cells.api.callbacks;

/**
 * Callback interface to manage long running tasks
 */
public interface ProgressListener {

    /**
     * @param processed is the amount of data that has already been processed (usually a number of bytes).
     * @return a message indicating the cause if the client want to force stop the long running task.
     */
    String onProgress(long processed);
}
