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
import com.pydio.cells.openapi.model.UpdateApplyUpdateRequest;
import com.pydio.cells.openapi.model.UpdateApplyUpdateResponse;
import com.pydio.cells.openapi.model.UpdateUpdateRequest;
import com.pydio.cells.openapi.model.UpdateUpdateResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpdateServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public UpdateServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UpdateServiceApi(ApiClient apiClient) {
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
     * Build call for applyUpdate
     * @param targetVersion Version of the target binary (required)
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call applyUpdateCall(String targetVersion, UpdateApplyUpdateRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/update/{TargetVersion}"
            .replace("{" + "TargetVersion" + "}", localVarApiClient.escapeString(targetVersion.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PATCH", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call applyUpdateValidateBeforeCall(String targetVersion, UpdateApplyUpdateRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'targetVersion' is set
        if (targetVersion == null) {
            throw new ApiException("Missing the required parameter 'targetVersion' when calling applyUpdate(Async)");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling applyUpdate(Async)");
        }

        return applyUpdateCall(targetVersion, body, _callback);

    }

    /**
     * Apply an update to a given version
     * 
     * @param targetVersion Version of the target binary (required)
     * @param body  (required)
     * @return UpdateApplyUpdateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public UpdateApplyUpdateResponse applyUpdate(String targetVersion, UpdateApplyUpdateRequest body) throws ApiException {
        ApiResponse<UpdateApplyUpdateResponse> localVarResp = applyUpdateWithHttpInfo(targetVersion, body);
        return localVarResp.getData();
    }

    /**
     * Apply an update to a given version
     * 
     * @param targetVersion Version of the target binary (required)
     * @param body  (required)
     * @return ApiResponse&lt;UpdateApplyUpdateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UpdateApplyUpdateResponse> applyUpdateWithHttpInfo(String targetVersion, UpdateApplyUpdateRequest body) throws ApiException {
        okhttp3.Call localVarCall = applyUpdateValidateBeforeCall(targetVersion, body, null);
        Type localVarReturnType = new TypeToken<UpdateApplyUpdateResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Apply an update to a given version (asynchronously)
     * 
     * @param targetVersion Version of the target binary (required)
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call applyUpdateAsync(String targetVersion, UpdateApplyUpdateRequest body, final ApiCallback<UpdateApplyUpdateResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = applyUpdateValidateBeforeCall(targetVersion, body, _callback);
        Type localVarReturnType = new TypeToken<UpdateApplyUpdateResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for updateRequired
     * @param body  (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRequiredCall(UpdateUpdateRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/update";

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
    private okhttp3.Call updateRequiredValidateBeforeCall(UpdateUpdateRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateRequired(Async)");
        }

        return updateRequiredCall(body, _callback);

    }

    /**
     * Check the remote server to see if there are available binaries
     * 
     * @param body  (required)
     * @return UpdateUpdateResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public UpdateUpdateResponse updateRequired(UpdateUpdateRequest body) throws ApiException {
        ApiResponse<UpdateUpdateResponse> localVarResp = updateRequiredWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Check the remote server to see if there are available binaries
     * 
     * @param body  (required)
     * @return ApiResponse&lt;UpdateUpdateResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<UpdateUpdateResponse> updateRequiredWithHttpInfo(UpdateUpdateRequest body) throws ApiException {
        okhttp3.Call localVarCall = updateRequiredValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<UpdateUpdateResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Check the remote server to see if there are available binaries (asynchronously)
     * 
     * @param body  (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> A successful response. </td><td>  -  </td></tr>
        <tr><td> 401 </td><td> User is not authenticated </td><td>  -  </td></tr>
        <tr><td> 403 </td><td> User has no permission to access this particular resource </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Resource does not exist in the system </td><td>  -  </td></tr>
        <tr><td> 500 </td><td> An internal error occurred in the backend </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call updateRequiredAsync(UpdateUpdateRequest body, final ApiCallback<UpdateUpdateResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = updateRequiredValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<UpdateUpdateResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
