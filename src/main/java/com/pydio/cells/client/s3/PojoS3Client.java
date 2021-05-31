package com.pydio.cells.client.s3;

public class PojoS3Client {}

//import com.amazonaws.HttpMethod;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.AmazonS3Exception;
//import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
//import com.amazonaws.services.s3.model.GetObjectRequest;
//import com.pydio.cells.api.S3Client;
//import com.pydio.cells.api.SDKException;
//import com.pydio.cells.client.S3Names;
//import com.pydio.cells.client.utils.Log;
//import com.pydio.cells.transport.CellsTransport;
//
//import java.io.InputStream;
//import java.net.URL;
//
//public class PojoS3Client implements S3Client {
//
//    private final CellsTransport transport;
//
//    public PojoS3Client(CellsTransport transport) {
//        this.transport = transport;
//    }
//
//    public InputStream getThumb(String file) throws SDKException {
//        GetObjectRequest request = new GetObjectRequest(defaultBucketName(), S3Names.PYDIO_S3_THUMBSTORE_PREFIX + file);
//        AmazonS3 s3 = new AmazonS3Client(defaultAWSCreds());
//        s3.setEndpoint(transport.getServer().url());
//        try {
//            return s3.getObject(request).getObjectContent();
//        } catch (AmazonS3Exception e) {
//            throw new SDKException("could not get S3 file at " + file, e);
//        }
//    }
//
//    public URL getUploadPreSignedURL(String ws, String folder, String name) throws SDKException {
//        String cleanPath = String.format("%s/%s", folder, name);
//        String filename = String.format("%s%s", ws, cleanPath).replace("//", "/");
//        filename = transport.getEncoder().utf8Encode(filename);
//
//        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest("io", filename);
//        request.setMethod(HttpMethod.PUT);
//        request.setContentType(S3Names.S3_CONTENT_TYPE_OCTET_STREAM);
//        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.getToken());
//
//        AmazonS3 s3 = new AmazonS3Client(defaultAWSCreds());
//        s3.setEndpoint(transport.getServer().url());
//        return s3.generatePresignedUrl(request);
//    }
//
//    public URL getDownloadPreSignedURL(String ws, String file) throws SDKException {
//        String filename = ws + file;
//
//        if (filename.contains("//")) {
//            // This should not happen anymore
//            Log.w("Legacy", "Found a double slash in " + filename + ", this is mot probably a bug. Double check and fix");
//            Thread.dumpStack();
//            filename = transport.getEncoder().utf8Encode(filename.replace("//", "/"));
//        }
//
//        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(defaultBucketName(), filename);
//        request.setMethod(HttpMethod.GET);
//        request.addRequestParameter(S3Names.S3_TOKEN_KEY, transport.getToken());
//
//        AmazonS3 s3 = new AmazonS3Client(defaultAWSCreds());
//        s3.setEndpoint(transport.getServer().url());
//        return s3.generatePresignedUrl(request);
//    }
//
//    private AWSCredentials defaultAWSCreds() throws SDKException {
//        return new BasicAWSCredentials(transport.getToken(), "gatewaysecret");
//    }
//
//    private String defaultBucketName() {
//        return "io";
//    }
//}
