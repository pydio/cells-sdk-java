/*
 * Pydio Cells Rest API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.pydio.cells.openapi.api;

import com.pydio.cells.openapi.ApiCallback;
import com.pydio.cells.openapi.ApiClient;
import com.pydio.cells.openapi.ApiException;
import com.pydio.cells.openapi.ApiResponse;
import com.pydio.cells.openapi.Configuration;
import com.pydio.cells.openapi.Pair;
import com.pydio.cells.openapi.ProgressRequestBody;
import com.pydio.cells.openapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.pydio.cells.openapi.model.RestBulkMetaResponse;
import com.pydio.cells.openapi.model.RestGetBulkMetaRequest;
import com.pydio.cells.openapi.model.RestMetaCollection;
import com.pydio.cells.openapi.model.RestMetaNamespaceRequest;
import com.pydio.cells.openapi.model.TreeNode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public MetaServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MetaServiceApi(ApiClient apiClient) {
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
     * Build call for deleteMeta
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteMetaCall(String nodePath, RestMetaNamespaceRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/meta/delete/{NodePath}"
            .replaceAll("\\{" + "NodePath" + "\\}", localVarApiClient.escapeString(nodePath.toString()));

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call deleteMetaValidateBeforeCall(String nodePath, RestMetaNamespaceRequest body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'nodePath' is set
        if (nodePath == null) {
            throw new ApiException("Missing the required parameter 'nodePath' when calling deleteMeta(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling deleteMeta(Async)");
        }
        

        okhttp3.Call localVarCall = deleteMetaCall(nodePath, body, _callback);
        return localVarCall;

    }

    /**
     * Delete metadata of a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return TreeNode
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public TreeNode deleteMeta(String nodePath, RestMetaNamespaceRequest body) throws ApiException {
        ApiResponse<TreeNode> localVarResp = deleteMetaWithHttpInfo(nodePath, body);
        return localVarResp.getData();
    }

    /**
     * Delete metadata of a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return ApiResponse&lt;TreeNode&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TreeNode> deleteMetaWithHttpInfo(String nodePath, RestMetaNamespaceRequest body) throws ApiException {
        okhttp3.Call localVarCall = deleteMetaValidateBeforeCall(nodePath, body, null);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Delete metadata of a given node (asynchronously)
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call deleteMetaAsync(String nodePath, RestMetaNamespaceRequest body, final ApiCallback<TreeNode> _callback) throws ApiException {

        okhttp3.Call localVarCall = deleteMetaValidateBeforeCall(nodePath, body, _callback);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getBulkMeta
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBulkMetaCall(RestGetBulkMetaRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/meta/bulk/get";

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getBulkMetaValidateBeforeCall(RestGetBulkMetaRequest body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getBulkMeta(Async)");
        }
        

        okhttp3.Call localVarCall = getBulkMetaCall(body, _callback);
        return localVarCall;

    }

    /**
     * List meta for a list of nodes, or a full directory using /path/_* syntax
     * 
     * @param body  (required)
     * @return RestBulkMetaResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public RestBulkMetaResponse getBulkMeta(RestGetBulkMetaRequest body) throws ApiException {
        ApiResponse<RestBulkMetaResponse> localVarResp = getBulkMetaWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * List meta for a list of nodes, or a full directory using /path/_* syntax
     * 
     * @param body  (required)
     * @return ApiResponse&lt;RestBulkMetaResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<RestBulkMetaResponse> getBulkMetaWithHttpInfo(RestGetBulkMetaRequest body) throws ApiException {
        okhttp3.Call localVarCall = getBulkMetaValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestBulkMetaResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List meta for a list of nodes, or a full directory using /path/_* syntax (asynchronously)
     * 
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getBulkMetaAsync(RestGetBulkMetaRequest body, final ApiCallback<RestBulkMetaResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = getBulkMetaValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestBulkMetaResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for getMeta
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMetaCall(String nodePath, RestMetaNamespaceRequest body, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/meta/get/{NodePath}"
            .replaceAll("\\{" + "NodePath" + "\\}", localVarApiClient.escapeString(nodePath.toString()));

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getMetaValidateBeforeCall(String nodePath, RestMetaNamespaceRequest body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'nodePath' is set
        if (nodePath == null) {
            throw new ApiException("Missing the required parameter 'nodePath' when calling getMeta(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling getMeta(Async)");
        }
        

        okhttp3.Call localVarCall = getMetaCall(nodePath, body, _callback);
        return localVarCall;

    }

    /**
     * Load metadata for a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return TreeNode
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public TreeNode getMeta(String nodePath, RestMetaNamespaceRequest body) throws ApiException {
        ApiResponse<TreeNode> localVarResp = getMetaWithHttpInfo(nodePath, body);
        return localVarResp.getData();
    }

    /**
     * Load metadata for a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return ApiResponse&lt;TreeNode&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TreeNode> getMetaWithHttpInfo(String nodePath, RestMetaNamespaceRequest body) throws ApiException {
        okhttp3.Call localVarCall = getMetaValidateBeforeCall(nodePath, body, null);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Load metadata for a given node (asynchronously)
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMetaAsync(String nodePath, RestMetaNamespaceRequest body, final ApiCallback<TreeNode> _callback) throws ApiException {

        okhttp3.Call localVarCall = getMetaValidateBeforeCall(nodePath, body, _callback);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for setMeta
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setMetaCall(String nodePath, RestMetaCollection body, final ApiCallback _callback) throws ApiException {
        String basePath = null;

        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/meta/set/{NodePath}"
            .replaceAll("\\{" + "NodePath" + "\\}", localVarApiClient.escapeString(nodePath.toString()));

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

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call setMetaValidateBeforeCall(String nodePath, RestMetaCollection body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'nodePath' is set
        if (nodePath == null) {
            throw new ApiException("Missing the required parameter 'nodePath' when calling setMeta(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling setMeta(Async)");
        }
        

        okhttp3.Call localVarCall = setMetaCall(nodePath, body, _callback);
        return localVarCall;

    }

    /**
     * Update metadata for a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return TreeNode
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public TreeNode setMeta(String nodePath, RestMetaCollection body) throws ApiException {
        ApiResponse<TreeNode> localVarResp = setMetaWithHttpInfo(nodePath, body);
        return localVarResp.getData();
    }

    /**
     * Update metadata for a given node
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @return ApiResponse&lt;TreeNode&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<TreeNode> setMetaWithHttpInfo(String nodePath, RestMetaCollection body) throws ApiException {
        okhttp3.Call localVarCall = setMetaValidateBeforeCall(nodePath, body, null);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Update metadata for a given node (asynchronously)
     * 
     * @param nodePath  (required)
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td>  </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call setMetaAsync(String nodePath, RestMetaCollection body, final ApiCallback<TreeNode> _callback) throws ApiException {

        okhttp3.Call localVarCall = setMetaValidateBeforeCall(nodePath, body, _callback);
        Type localVarReturnType = new TypeToken<TreeNode>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
