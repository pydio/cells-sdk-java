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
import com.pydio.cells.openapi.model.JobsCtrlCommand;
import com.pydio.cells.openapi.model.JobsCtrlCommandResponse;
import com.pydio.cells.openapi.model.JobsDeleteTasksRequest;
import com.pydio.cells.openapi.model.JobsDeleteTasksResponse;
import com.pydio.cells.openapi.model.JobsListJobsRequest;
import com.pydio.cells.openapi.model.LogListLogRequest;
import com.pydio.cells.openapi.model.RestLogMessageCollection;
import com.pydio.cells.openapi.model.RestUserJobRequest;
import com.pydio.cells.openapi.model.RestUserJobResponse;
import com.pydio.cells.openapi.model.RestUserJobsCollection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobsServiceApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public JobsServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public JobsServiceApi(ApiClient apiClient) {
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
     * Build call for listTasksLogs
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
    public okhttp3.Call listTasksLogsCall(LogListLogRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/jobs/tasks/logs";

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
    private okhttp3.Call listTasksLogsValidateBeforeCall(LogListLogRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling listTasksLogs(Async)");
        }

        return listTasksLogsCall(body, _callback);

    }

    /**
     * Technical Logs, in Json or CSV format
     * 
     * @param body  (required)
     * @return RestLogMessageCollection
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
    public RestLogMessageCollection listTasksLogs(LogListLogRequest body) throws ApiException {
        ApiResponse<RestLogMessageCollection> localVarResp = listTasksLogsWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Technical Logs, in Json or CSV format
     * 
     * @param body  (required)
     * @return ApiResponse&lt;RestLogMessageCollection&gt;
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
    public ApiResponse<RestLogMessageCollection> listTasksLogsWithHttpInfo(LogListLogRequest body) throws ApiException {
        okhttp3.Call localVarCall = listTasksLogsValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestLogMessageCollection>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Technical Logs, in Json or CSV format (asynchronously)
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
    public okhttp3.Call listTasksLogsAsync(LogListLogRequest body, final ApiCallback<RestLogMessageCollection> _callback) throws ApiException {

        okhttp3.Call localVarCall = listTasksLogsValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestLogMessageCollection>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userControlJob
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
    public okhttp3.Call userControlJobCall(JobsCtrlCommand body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/jobs/user";

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call userControlJobValidateBeforeCall(JobsCtrlCommand body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling userControlJob(Async)");
        }

        return userControlJobCall(body, _callback);

    }

    /**
     * Send Control Commands to one or many jobs / tasks
     * 
     * @param body  (required)
     * @return JobsCtrlCommandResponse
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
    public JobsCtrlCommandResponse userControlJob(JobsCtrlCommand body) throws ApiException {
        ApiResponse<JobsCtrlCommandResponse> localVarResp = userControlJobWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Send Control Commands to one or many jobs / tasks
     * 
     * @param body  (required)
     * @return ApiResponse&lt;JobsCtrlCommandResponse&gt;
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
    public ApiResponse<JobsCtrlCommandResponse> userControlJobWithHttpInfo(JobsCtrlCommand body) throws ApiException {
        okhttp3.Call localVarCall = userControlJobValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<JobsCtrlCommandResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send Control Commands to one or many jobs / tasks (asynchronously)
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
    public okhttp3.Call userControlJobAsync(JobsCtrlCommand body, final ApiCallback<JobsCtrlCommandResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = userControlJobValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<JobsCtrlCommandResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userCreateJob
     * @param jobName Name of the job to create in the user space (required)
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
    public okhttp3.Call userCreateJobCall(String jobName, RestUserJobRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/jobs/user/{JobName}"
            .replace("{" + "JobName" + "}", localVarApiClient.escapeString(jobName.toString()));

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
        return localVarApiClient.buildCall(basePath, localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call userCreateJobValidateBeforeCall(String jobName, RestUserJobRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'jobName' is set
        if (jobName == null) {
            throw new ApiException("Missing the required parameter 'jobName' when calling userCreateJob(Async)");
        }

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling userCreateJob(Async)");
        }

        return userCreateJobCall(jobName, body, _callback);

    }

    /**
     * Create a predefined job to be run directly
     * 
     * @param jobName Name of the job to create in the user space (required)
     * @param body  (required)
     * @return RestUserJobResponse
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
    public RestUserJobResponse userCreateJob(String jobName, RestUserJobRequest body) throws ApiException {
        ApiResponse<RestUserJobResponse> localVarResp = userCreateJobWithHttpInfo(jobName, body);
        return localVarResp.getData();
    }

    /**
     * Create a predefined job to be run directly
     * 
     * @param jobName Name of the job to create in the user space (required)
     * @param body  (required)
     * @return ApiResponse&lt;RestUserJobResponse&gt;
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
    public ApiResponse<RestUserJobResponse> userCreateJobWithHttpInfo(String jobName, RestUserJobRequest body) throws ApiException {
        okhttp3.Call localVarCall = userCreateJobValidateBeforeCall(jobName, body, null);
        Type localVarReturnType = new TypeToken<RestUserJobResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Create a predefined job to be run directly (asynchronously)
     * 
     * @param jobName Name of the job to create in the user space (required)
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
    public okhttp3.Call userCreateJobAsync(String jobName, RestUserJobRequest body, final ApiCallback<RestUserJobResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = userCreateJobValidateBeforeCall(jobName, body, _callback);
        Type localVarReturnType = new TypeToken<RestUserJobResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userDeleteTasks
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
    public okhttp3.Call userDeleteTasksCall(JobsDeleteTasksRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/jobs/tasks/delete";

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
    private okhttp3.Call userDeleteTasksValidateBeforeCall(JobsDeleteTasksRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling userDeleteTasks(Async)");
        }

        return userDeleteTasksCall(body, _callback);

    }

    /**
     * Send a control command to clean tasks on a given job
     * 
     * @param body  (required)
     * @return JobsDeleteTasksResponse
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
    public JobsDeleteTasksResponse userDeleteTasks(JobsDeleteTasksRequest body) throws ApiException {
        ApiResponse<JobsDeleteTasksResponse> localVarResp = userDeleteTasksWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * Send a control command to clean tasks on a given job
     * 
     * @param body  (required)
     * @return ApiResponse&lt;JobsDeleteTasksResponse&gt;
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
    public ApiResponse<JobsDeleteTasksResponse> userDeleteTasksWithHttpInfo(JobsDeleteTasksRequest body) throws ApiException {
        okhttp3.Call localVarCall = userDeleteTasksValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<JobsDeleteTasksResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Send a control command to clean tasks on a given job (asynchronously)
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
    public okhttp3.Call userDeleteTasksAsync(JobsDeleteTasksRequest body, final ApiCallback<JobsDeleteTasksResponse> _callback) throws ApiException {

        okhttp3.Call localVarCall = userDeleteTasksValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<JobsDeleteTasksResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for userListJobs
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
    public okhttp3.Call userListJobsCall(JobsListJobsRequest body, final ApiCallback _callback) throws ApiException {
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
        String localVarPath = "/jobs/user";

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
    private okhttp3.Call userListJobsValidateBeforeCall(JobsListJobsRequest body, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling userListJobs(Async)");
        }

        return userListJobsCall(body, _callback);

    }

    /**
     * List jobs associated with current user
     * 
     * @param body  (required)
     * @return RestUserJobsCollection
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
    public RestUserJobsCollection userListJobs(JobsListJobsRequest body) throws ApiException {
        ApiResponse<RestUserJobsCollection> localVarResp = userListJobsWithHttpInfo(body);
        return localVarResp.getData();
    }

    /**
     * List jobs associated with current user
     * 
     * @param body  (required)
     * @return ApiResponse&lt;RestUserJobsCollection&gt;
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
    public ApiResponse<RestUserJobsCollection> userListJobsWithHttpInfo(JobsListJobsRequest body) throws ApiException {
        okhttp3.Call localVarCall = userListJobsValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<RestUserJobsCollection>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List jobs associated with current user (asynchronously)
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
    public okhttp3.Call userListJobsAsync(JobsListJobsRequest body, final ApiCallback<RestUserJobsCollection> _callback) throws ApiException {

        okhttp3.Call localVarCall = userListJobsValidateBeforeCall(body, _callback);
        Type localVarReturnType = new TypeToken<RestUserJobsCollection>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
