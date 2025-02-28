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
import com.pydio.cells.openapi.model.RestNodesCollection;
import com.pydio.cells.openapi.model.TreeListNodesRequest;
import com.pydio.cells.openapi.model.TreeReadNodeRequest;
import com.pydio.cells.openapi.model.TreeReadNodeResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminTreeServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public AdminTreeServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AdminTreeServiceApi(ApiClient apiClient) {
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
     * Build call for listAdminTree
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
    public okhttp3.Call listAdminTreeCall(TreeListNodesRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/tree/admin/list";

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
    private okhttp3.Call listAdminTreeValidateBeforeCall(TreeListNodesRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling listAdminTree(Async)");
        }

        return listAdminTreeCall(body, _callback);

    }

    /**
     * List files and folders starting at the root (first level lists the datasources)
     *
     * @param body (required)
     * @return RestNodesCollection
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
    public RestNodesCollection listAdminTree(TreeListNodesRequest body) throws ApiException {
        ApiResponse<RestNodesCollection> localVarResp = listAdminTreeWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * List files and folders starting at the root (first level lists the datasources)
     *
     * @param body (required)
     * @return ApiResponse&lt;RestNodesCollection&gt;
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
    public ApiResponse<RestNodesCollection> listAdminTreeWithHttpInfo(TreeListNodesRequest body) throws ApiException {
        okhttp3.Call localVarCall = listAdminTreeValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestNodesCollection>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List files and folders starting at the root (first level lists the datasources) (asynchronously)
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
    public okhttp3.Call listAdminTreeAsync(TreeListNodesRequest body, final ApiCallback<RestNodesCollection> _callback) throws ApiException {

        okhttp3.Call localVarCall = listAdminTreeValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestNodesCollection>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }

    /**
     * Build call for statAdminTree
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
    public okhttp3.Call statAdminTreeCall(TreeReadNodeRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/tree/admin/stat";

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
    private okhttp3.Call statAdminTreeValidateBeforeCall(TreeReadNodeRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling statAdminTree(Async)");
        }

        return statAdminTreeCall(body, _callback);

    }

    /**
     * Read a node information inside the admin tree
     *
     * @param body (required)
     * @return TreeReadNodeResponse
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
    public TreeReadNodeResponse statAdminTree(TreeReadNodeRequest body) throws ApiException {
        ApiResponse<TreeReadNodeResponse> localVarResp = statAdminTreeWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Read a node information inside the admin tree
     *
     * @param body (required)
     * @return ApiResponse&lt;TreeReadNodeResponse&gt;
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
    public ApiResponse<TreeReadNodeResponse> statAdminTreeWithHttpInfo(TreeReadNodeRequest body) throws ApiException {
        okhttp3.Call localVarCall = statAdminTreeValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<TreeReadNodeResponse>() {
        }.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Read a node information inside the admin tree (asynchronously)
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
    public okhttp3.Call statAdminTreeAsync(TreeReadNodeRequest body, final ApiCallback<TreeReadNodeResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = statAdminTreeValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<TreeReadNodeResponse>() {
        }.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
