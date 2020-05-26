package com.pydio.sdk.core.common.callback;

public interface BucketUploadListener {
    boolean onNext(int count, int total);
    boolean onProgress(String file, long uploaded, long total);
}
