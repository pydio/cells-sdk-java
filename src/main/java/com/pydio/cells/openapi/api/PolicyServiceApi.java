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


import com.pydio.cells.openapi.model.IdmListPolicyGroupsRequest;
import com.pydio.cells.openapi.model.IdmListPolicyGroupsResponse;
import com.pydio.cells.openapi.model.RestError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PolicyServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public PolicyServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PolicyServiceApi(ApiClient apiClient) {
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
     * Build call for listPolicies
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
    public okhttp3.Call listPoliciesCall(IdmListPolicyGroupsRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/policy";

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
    private okhttp3.Call listPoliciesValidateBeforeCall(IdmListPolicyGroupsRequest body, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling listPolicies(Async)");
        }
        

        okhttp3.Call localVarCall = listPoliciesCall(body, _callback);
        return localVarCall;

    }

    /**
     * List all defined security policies
     * 
     * @param body  (required)
     * @return IdmListPolicyGroupsResponse
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
    public IdmListPolicyGroupsResponse listPolicies(IdmListPolicyGroupsRequest body) throws ApiException {
        ApiResponse<IdmListPolicyGroupsResponse> localVarResp = listPoliciesWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * List all defined security policies
     * 
     * @param body  (required)
     * @return ApiResponse&lt;IdmListPolicyGroupsResponse&gt;
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
    public ApiResponse<IdmListPolicyGroupsResponse> listPoliciesWithHttpInfo(IdmListPolicyGroupsRequest body) throws ApiException {
        okhttp3.Call localVarCall = listPoliciesValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<IdmListPolicyGroupsResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all defined security policies (asynchronously)
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
    public okhttp3.Call listPoliciesAsync(IdmListPolicyGroupsRequest body, final ApiCallback<IdmListPolicyGroupsResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = listPoliciesValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<IdmListPolicyGroupsResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
