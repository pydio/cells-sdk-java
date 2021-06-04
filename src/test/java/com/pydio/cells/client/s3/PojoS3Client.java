package com.pydio.cells.client.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.util.SdkHttpUtils;
import com.pydio.cells.api.S3Client;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.client.S3Names;
import com.pydio.cells.utils.Log;
import com.pydio.cells.transport.CellsTransport;

import java.io.InputStream;
import java.net.URL;

public class PojoS3Client implements S3Client {

    private final static String defaultBucketName = "io";
    private final static String defaultSigningRegion = "us-west-1";
    private final static String defaultGatewaySecret = "gatewaysecret";

    private final CellsTransport transport;
    private final AmazonS3ClientBuilder clientBuilder;

    public PojoS3Client(CellsTransport transport) {
        this.transport = transport;
        clientBuilder = AmazonS3ClientBuilder.standard().withEndpointConfiguration(
                new AmazonS3ClientBuilder.EndpointConfiguration(transport.getServer().url(), defaultSigningRegion));
    }

    public InputStream getThumb(String file) throws SDKException {
        GetObjectRequest request = new GetObjectRequest(defaultBucketName, S3Names.PYDIO_S3_THUMBSTORE_PREFIX + file);
        try {
            return getS3Client().getObject(request).getObjectContent();
        } catch (AmazonS3Exception e) {
            throw new SDKException("could not get S3 file at " + file, e);
        }
    }

    public URL getUploadPreSignedURL(String ws, String folder, String name) throws SDKException {
        String filename = getCleanPath(ws, folder, name);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(defaultBucketName, filename);
        request.setMethod(HttpMethod.PUT);
        request.setContentType(S3Names.S3_CONTENT_TYPE_OCTET_STREAM);
        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.getToken());
        return getS3Client().generatePresignedUrl(request);
    }

    public URL getDownloadPreSignedURL(String ws, String file) throws SDKException {
        String filename = getCleanPath(ws, file);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(defaultBucketName, filename);
        request.setMethod(HttpMethod.GET);
        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.getToken());
        return getS3Client().generatePresignedUrl(request);
    }

    public URL getStreamingPreSignedURL(String slug, String file, String contentType) throws SDKException {
        String filename = getCleanPath(slug, file);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(defaultBucketName, filename);
        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.getToken());
        request.addRequestParameter(S3Names.RESPONSE_CONTENT_TYPE, contentType);
        return getS3Client().generatePresignedUrl(request);
    }

    private String getCleanPath(String slug, String parent, String fileName) {
        return getCleanPath(slug, parent + "/" + fileName);
    }

    private String getCleanPath(String slug, String file){
        String path = slug + file;
        if (path.contains("//")) {
            // This should not happen anymore
            Log.w("Legacy",
                    "Found a double slash in " + path + ", this is most probably a bug. Double check and fix");
            Thread.dumpStack();
            path = path.replace("//", "/");
        }
        return SdkHttpUtils.urlEncode(path, true);
    }

    private AmazonS3 getS3Client() throws SDKException {
        // TODO improve this to enable refresh when necessary
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(transport.getToken(), defaultGatewaySecret);
        return clientBuilder.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
    }
}
