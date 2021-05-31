package com.pydio.cells.client.s3;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.Presigner;
import com.amazonaws.auth.Signer;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazonaws.util.Base64;
import com.amazonaws.util.Md5Utils;
import com.amazonaws.util.SdkHttpUtils;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class AmazonS3Client extends com.amazonaws.services.s3.AmazonS3Client {

    private final AWSCredentials credentials;

    AmazonS3Client(AWSCredentials c) {
        super(c);
        this.credentials = c;
    }

    /**
     * Adds the specified parameter to the specified request, if the parameter
     * value is not null.
     *
     * @param request    The request to add the parameter to.
     * @param paramValue The parameter value.
     */
    private static void addParameterIfNotNull(Request<?> request, String paramValue) {
        if (paramValue != null) {
            request.addParameter("versionId", paramValue);
        }
    }

    /**
     * <p>
     * Populates the specified request with the numerous attributes available in
     * <code>SSEWithCustomerKeyRequest</code>.
     * </p>
     *
     * @param request The request to populate with headers to represent all the
     *                options expressed in the
     *                <code>ServerSideEncryptionWithCustomerKeyRequest</code>
     *                object.
     * @param sseKey  The request object for an S3 operation that allows
     *                server-side encryption using customer-provided keys.
     */
    private static void populateSSE_C(Request<?> request, SSECustomerKey sseKey) {
        if (sseKey == null) {
            return;
        }

        addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM,
                sseKey.getAlgorithm());
        addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY,
                sseKey.getKey());
        addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5,
                sseKey.getMd5());
        // Calculate the MD5 hash of the encryption key and fill it in the
        // header, if the user didn't specify it in the metadata
        if (sseKey.getKey() != null
                && sseKey.getMd5() == null) {
            final String encryptionKey_b64 = sseKey.getKey();
            final byte[] encryptionKey = Base64.decode(encryptionKey_b64);
            request.addHeader(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5,
                    Md5Utils.md5AsBase64(encryptionKey));
        }
    }

    /**
     * Adds the specified header to the specified request, if the header value
     * is not null.
     *
     * @param request The request to add the header to.
     * @param header  The header name.
     * @param value   The header value.
     */
    private static void addHeaderIfNotNull(Request<?> request, String header, String value) {
        if (value != null) {
            request.addHeader(header, value);
        }
    }

    /**
     * <p>
     * Adds response headers parameters to the request given, if non-null.
     * </p>
     *
     * @param request         The request to add the response header parameters to.
     * @param responseHeaders The full set of response headers to add, or null
     *                        for none.
     */
    private static void addResponseHeaderParameters(Request<?> request, ResponseHeaderOverrides responseHeaders) {
        if (responseHeaders != null) {
            if (responseHeaders.getCacheControl() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL,
                        responseHeaders.getCacheControl());
            }
            if (responseHeaders.getContentDisposition() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION,
                        responseHeaders.getContentDisposition());
            }
            if (responseHeaders.getContentEncoding() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING,
                        responseHeaders.getContentEncoding());
            }
            if (responseHeaders.getContentLanguage() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE,
                        responseHeaders.getContentLanguage());
            }
            if (responseHeaders.getContentType() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE,
                        responseHeaders.getContentType());
            }
            if (responseHeaders.getExpires() != null) {
                request.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES,
                        responseHeaders.getExpires());
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.amazonaws.services.s3.AmazonS3#generatePresignedUrl(com.amazonaws
     * .services.s3.model.GeneratePresignedUrlRequest)
     */
    @Override
    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
        assertParameterNotNull(generatePresignedUrlRequest,
                "The request parameter must be specified when generating a pre-signed URL");

        final String bucketName = generatePresignedUrlRequest.getBucketName();
        final String key = generatePresignedUrlRequest.getKey();

        assertParameterNotNull(bucketName,
                "The bucket name parameter must be specified when generating a pre-signed URL");
        assertParameterNotNull(generatePresignedUrlRequest.getMethod(),
                "The HTTP method request parameter must be specified when generating a pre-signed URL");

        if (generatePresignedUrlRequest.getExpiration() == null) {
            generatePresignedUrlRequest.setExpiration(
                    new Date(System.currentTimeMillis() + 1000 * 60 * 15));
        }

        final HttpMethodName httpMethod = HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod()
                .toString());

        // If the key starts with a slash character itself, the following method
        // will actually add another slash before the resource path to prevent
        // the HttpClient mistakenly treating the slash as a path delimiter.
        // For presigned request, we need to remember to remove this extra slash
        // before generating the URL.
        final Request<GeneratePresignedUrlRequest> request = createRequest(bucketName, key,
                generatePresignedUrlRequest, httpMethod);

        addParameterIfNotNull(request, generatePresignedUrlRequest.getVersionId());

        if (generatePresignedUrlRequest.isZeroByteContent()) {
            request.setContent(new ByteArrayInputStream(new byte[0]));
        }

        for (final Map.Entry<String, String> entry : generatePresignedUrlRequest.getRequestParameters()
                .entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        if (generatePresignedUrlRequest.getContentType() != null) {
            request.addHeader(Headers.CONTENT_TYPE, generatePresignedUrlRequest.getContentType());
        }

        if (generatePresignedUrlRequest.getContentMd5() != null) {
            request.addHeader(Headers.CONTENT_MD5, generatePresignedUrlRequest.getContentMd5());
        }

        // SSE-C
        populateSSE_C(request, generatePresignedUrlRequest.getSSECustomerKey());
        // SSE
        addHeaderIfNotNull(request, Headers.SERVER_SIDE_ENCRYPTION,
                generatePresignedUrlRequest.getSSEAlgorithm());
        // SSE-KMS
//        addHeaderIfNotNull(request,
//                Headers.SERVER_SIDE_ENCRYPTION_KMS_KEY_ID,
//                generatePresignedUrlRequest.getKmsCmkId());
        addHeaderIfNotNull(request,
                Headers.SERVER_SIDE_ENCRYPTION_AWS_KMS_KEYID,
                generatePresignedUrlRequest.getKmsCmkId());

        // Add custom query parameters
        final Map<String, List<String>> customQueryParameters = generatePresignedUrlRequest.getCustomQueryParameters();
        if (customQueryParameters != null) {
            for (Map.Entry<String, List<String>> e : customQueryParameters.entrySet()) {
                // FIXME
                System.out.println(e.getKey());
                // request.addParameter(e.getKey(), e.getValue().toArray());
            }
        }

        addResponseHeaderParameters(request, generatePresignedUrlRequest.getResponseHeaders());
        final Signer signer = createSigner(request, bucketName, key);
        //client region : us-east-1
        // service : s3
        String resourcePath = SdkHttpUtils.urlDecode(request.getResourcePath());
        Date date = generatePresignedUrlRequest.getExpiration();

        // Here we prevent the path from being encoded twice
        request.setResourcePath(resourcePath);
        if (signer instanceof Presigner) {
            // If we have a signer which knows how to presign requests,
            // delegate directly to it.
            //request.setResourcePath(HttpUtils.urlDecode(request.getResourcePath()));
            ((Presigner) signer).presignRequest(request, credentials, date);
        } else {
            // Otherwise use the default presigning method, which is hardcoded
            // to use QueryStringSigner.
            presignRequest(request, generatePresignedUrlRequest.getMethod(), bucketName, key, date, null);
        }
        // Remove the leading slash (if any) in the resource-path
        return convertRequestToUrl(request);
    }

    private void assertParameterNotNull(Object param, String message) throws AmazonClientException {
        if (param == null) {
            throw new AmazonClientException(message);
        }
    }


    /**
     * Converts the specified request object into a URL, containing all the
     * specified parameters, the specified request endpoint, etc.
     *
     * @param request The request to convert into a URL.
     * @return A new URL representing the specified request.
     * @throws AmazonClientException If the request cannot be converted to a
     *                               well formed URL.
     */
    private URL convertRequestToUrl(Request<?> request) {

        String resourcePath = SdkHttpUtils.urlEncode(request.getResourcePath(), true);

        // Removed the padding "/" that was already added into the request's
        // resource path.
        if (resourcePath.startsWith("/")) {
            resourcePath = resourcePath.substring(1);
        }

        // Some http client libraries (e.g. Apache HttpClient) cannot handle
        // consecutive "/"s between URL authority and path components.
        // So we escape "////..." into "/%2F%2F%2F...", in the same way as how
        // we treat consecutive "/"s in AmazonS3Client#presignRequest(...)
        String urlPath = "/" + resourcePath;
        urlPath = urlPath.replaceAll("(?<=/)/", "%2F");
        StringBuilder urlString = new StringBuilder(request.getEndpoint() + urlPath);

        boolean firstParam = true;
        for (final String param : request.getParameters().keySet()) {
            if (firstParam) {
                urlString.append("?");
                firstParam = false;
            } else {
                urlString.append("&");
            }

//            final String value = request.getParameters().get(param);
//            urlString.append(param).append("=").append(S3HttpUtils.urlEncode(value, false));
            List<String> value = request.getParameters().get(param);
            urlString.append(param).append("=").append(SdkHttpUtils.urlEncode(value.get(0), false));

        }

        try {
            return new URL(urlString.toString());
        } catch (final MalformedURLException e) {
            throw new AmazonClientException(
                    "Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }
}
