package com.pydio.cells.legacy;

import com.pydio.cells.api.S3Client;
import com.pydio.cells.api.SDKException;

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
    public InputStream getThumb(String file) throws SDKException {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getUploadPreSignedURL(String ws, String folder, String name) throws SDKException {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getDownloadPreSignedURL(String ws, String file) throws SDKException {
        throw new RuntimeException("Unsupported call");
    }

    @Override
    public URL getStreamingPreSignedURL(String slug, String file, String contentType) throws SDKException {
        throw new RuntimeException("Unsupported call");
    }

}
