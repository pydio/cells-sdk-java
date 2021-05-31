package com.pydio.cells.api;

import com.pydio.cells.api.SDKException;

import java.io.InputStream;
import java.net.URL;

public interface S3Client {

    InputStream getThumb(String file) throws SDKException;

    URL getUploadPreSignedURL(String ws, String folder, String name) throws SDKException;

    URL getDownloadPreSignedURL(String ws, String file) throws SDKException;
}