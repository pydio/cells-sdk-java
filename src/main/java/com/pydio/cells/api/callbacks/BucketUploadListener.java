package com.pydio.cells.api.callbacks;

public interface BucketUploadListener {
    boolean onNext(int count, int total);

    boolean onProgress(String file, long uploaded, long total);
}
