/*
 * Pydio Cells Rest API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 4.0
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.pydio.cells.openapi.api;

import com.google.gson.reflect.TypeToken;
import com.pydio.cells.openapi.ApiCallback;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.ApiResponse;
import com.pydio.cells.openapi.Configuration;
import com.pydio.cells.openapi.Pair;
import com.pydio.cells.openapi.model.RestDocumentAccessTokenRequest;
import com.pydio.cells.openapi.model.RestDocumentAccessTokenResponse;
import com.pydio.cells.openapi.model.RestResetPasswordRequest;
import com.pydio.cells.openapi.model.RestResetPasswordResponse;
import com.pydio.cells.openapi.model.RestResetPasswordTokenResponse;
import com.pydio.cells.openapi.model.RestRevokeRequest;
import com.pydio.cells.openapi.model.RestRevokeResponse;
import com.pydio.cells.openapi.model.TokenServiceResetPasswordTokenBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public TokenServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TokenServiceApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for generateDocumentAccessToken
     *
     * @param body      (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call generateDocumentAccessTokenCall(RestDocumentAccessTokenRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[]{};

        // Determine Base Path to Use
        if (localCustomBaseUrl != null) {
            basePath = localCustomBaseUrl;
        } else if (localBasePaths.length > 0) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/auth/token/document";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[]{};
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call generateDocumentAccessTokenValidateBeforeCall(RestDocumentAccessTokenRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling generateDocumentAccessToken(Async)");
        }

        return generateDocumentAccessTokenCall(body, _callback);

    }

    /**
     * Generate a temporary access token for a specific document for the current user
     *
     * @param body (required)
     * @return RestDocumentAccessTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public RestDocumentAccessTokenResponse generateDocumentAccessToken(RestDocumentAccessTokenRequest body) throws ApiException {
        ApiResponse<RestDocumentAccessTokenResponse> localVarResp = generateDocumentAccessTokenWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Generate a temporary access token for a specific document for the current user
     *
     * @param body (required)
     * @return ApiResponse&lt;RestDocumentAccessTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public ApiResponse<RestDocumentAccessTokenResponse> generateDocumentAccessTokenWithHttpInfo(RestDocumentAccessTokenRequest body) throws ApiException {
        okhttp3.Call localVarCall = generateDocumentAccessTokenValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestDocumentAccessTokenResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Generate a temporary access token for a specific document for the current user (asynchronously)
     *
     * @param body      (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call generateDocumentAccessTokenAsync(RestDocumentAccessTokenRequest body, final ApiCallback<RestDocumentAccessTokenResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = generateDocumentAccessTokenValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestDocumentAccessTokenResponse>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for resetPassword
     *
     * @param body      (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call resetPasswordCall(RestResetPasswordRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[]{};

        // Determine Base Path to Use
        if (localCustomBaseUrl != null) {
            basePath = localCustomBaseUrl;
        } else if (localBasePaths.length > 0) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/auth/reset-password";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[]{};
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call resetPasswordValidateBeforeCall(RestResetPasswordRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling resetPassword(Async)");
        }

        return resetPasswordCall(body, _callback);

    }

    /**
     * Finish up the reset password process by providing the unique token
     *
     * @param body (required)
     * @return RestResetPasswordResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public RestResetPasswordResponse resetPassword(RestResetPasswordRequest body) throws ApiException {
        ApiResponse<RestResetPasswordResponse> localVarResp = resetPasswordWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Finish up the reset password process by providing the unique token
     *
     * @param body (required)
     * @return ApiResponse&lt;RestResetPasswordResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public ApiResponse<RestResetPasswordResponse> resetPasswordWithHttpInfo(RestResetPasswordRequest body) throws ApiException {
        okhttp3.Call localVarCall = resetPasswordValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestResetPasswordResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Finish up the reset password process by providing the unique token (asynchronously)
     *
     * @param body      (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call resetPasswordAsync(RestResetPasswordRequest body, final ApiCallback<RestResetPasswordResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = resetPasswordValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestResetPasswordResponse>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for resetPasswordToken
     *
     * @param userLogin Start a ResetPassword workflow for this user (required)
     * @param body      (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call resetPasswordTokenCall(String userLogin, TokenServiceResetPasswordTokenBody body, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[]{};

        // Determine Base Path to Use
        if (localCustomBaseUrl != null) {
            basePath = localCustomBaseUrl;
        } else if (localBasePaths.length > 0) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/auth/reset-password-token/{UserLogin}"
                .replace("{" + "UserLogin" + "}", localVarApiClient.escapeString(userLogin));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[]{};
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call resetPasswordTokenValidateBeforeCall(String userLogin, TokenServiceResetPasswordTokenBody body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userLogin' is set
        if (userLogin == null) {
            throw new ApiException("Missing the required parameter 'userLogin' when calling resetPasswordToken(Async)");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling resetPasswordToken(Async)");
        }

        return resetPasswordTokenCall(userLogin, body, _callback);

    }

    /**
     * Generate a unique token for the reset password process
     *
     * @param userLogin Start a ResetPassword workflow for this user (required)
     * @param body      (required)
     * @return RestResetPasswordTokenResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public RestResetPasswordTokenResponse resetPasswordToken(String userLogin, TokenServiceResetPasswordTokenBody body) throws ApiException {
        ApiResponse<RestResetPasswordTokenResponse> localVarResp = resetPasswordTokenWithHttpInfo(userLogin, body);
        return localVarResp.getData();
    }

    /**
     * Generate a unique token for the reset password process
     *
     * @param userLogin Start a ResetPassword workflow for this user (required)
     * @param body      (required)
     * @return ApiResponse&lt;RestResetPasswordTokenResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public ApiResponse<RestResetPasswordTokenResponse> resetPasswordTokenWithHttpInfo(String userLogin, TokenServiceResetPasswordTokenBody body) throws ApiException {
        okhttp3.Call localVarCall = resetPasswordTokenValidateBeforeCall(userLogin, body, null);
        Type localVarReturnType = new TypeToken<RestResetPasswordTokenResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Generate a unique token for the reset password process (asynchronously)
     *
     * @param userLogin Start a ResetPassword workflow for this user (required)
     * @param body      (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call resetPasswordTokenAsync(String userLogin, TokenServiceResetPasswordTokenBody body, final ApiCallback<RestResetPasswordTokenResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = resetPasswordTokenValidateBeforeCall(userLogin, body, _callback);
        Type localVarReturnType = new TypeToken<RestResetPasswordTokenResponse>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for revoke
     *
     * @param body      (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call revokeCall(RestRevokeRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[]{};

        // Determine Base Path to Use
        if (localCustomBaseUrl != null) {
            basePath = localCustomBaseUrl;
        } else if (localBasePaths.length > 0) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/auth/token/revoke";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
                "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
                "application/json"
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[]{};
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call revokeValidateBeforeCall(RestRevokeRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling revoke(Async)");
        }

        return revokeCall(body, _callback);

    }

    /**
     * Revoke a JWT token
     *
     * @param body (required)
     * @return RestRevokeResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public RestRevokeResponse revoke(RestRevokeRequest body) throws ApiException {
        ApiResponse<RestRevokeResponse> localVarResp = revokeWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Revoke a JWT token
     *
     * @param body (required)
     * @return ApiResponse&lt;RestRevokeResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public ApiResponse<RestRevokeResponse> revokeWithHttpInfo(RestRevokeRequest body) throws ApiException {
        okhttp3.Call localVarCall = revokeValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestRevokeResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Revoke a JWT token (asynchronously)
     *
     * @param body      (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details <table border="1">
     * <caption>Response Details</caption>
     * <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
     * <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
     * <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
     * <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
     * <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
     * <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     * </table>
     */
    public okhttp3.Call revokeAsync(RestRevokeRequest body, final ApiCallback<RestRevokeResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = revokeValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestRevokeResponse>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
