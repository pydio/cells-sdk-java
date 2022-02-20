package com.pydio.cells.api;

import java.net.URL;

public interface S3Client {

    // InputStream getThumb(String file) throws SDKException;

    URL getUploadPreSignedURL(String ws, String folder, String name) throws SDKException;

    URL getDownloadPreSignedURL(String ws, String file) throws SDKException;

    URL getStreamingPreSignedURL(String slug, String file, String contentType) throws SDKException;
}