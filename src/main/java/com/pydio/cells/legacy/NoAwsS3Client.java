package com.pydio.cells.legacy;

import com.pydio.cells.api.S3Client;

import java.io.InputStream;
import java.net.URL;

/**
 * Temporary workaround the issue of AWS dependencies to provide
 * a reasonable default when working in a P8 only setup.
 */
public class NoAwsS3Client implements S3Client {

    public NoAwsS3Client() {
    }

    @Override
    public InputStream getThumb(String file) {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getUploadPreSignedURL(String ws, String folder, String name) {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getDownloadPreSignedURL(String ws, String file) {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getStreamingPreSignedURL(String slug, String file, String contentType) {
        throw new RuntimeException("Unsupported call");
    }

}
