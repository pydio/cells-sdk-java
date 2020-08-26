/*
 * Pydio Cells Rest API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.pydio.sdk.core.api.cells.api;

import com.pydio.sdk.core.api.cells.ApiCallback;
import com.pydio.sdk.core.api.cells.ApiClient;
import com.pydio.sdk.core.api.cells.ApiException;
import com.pydio.sdk.core.api.cells.ApiResponse;
import com.pydio.sdk.core.api.cells.Configuration;
import com.pydio.sdk.core.api.cells.Pair;
import com.pydio.sdk.core.api.cells.ProgressRequestBody;
import com.pydio.sdk.core.api.cells.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.pydio.sdk.core.api.cells.model.IdmUser;
import com.pydio.sdk.core.api.cells.model.RestDeleteResponse;
import com.pydio.sdk.core.api.cells.model.RestSearchUserRequest;
import com.pydio.sdk.core.api.cells.model.RestUsersCollection;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceApi {
    private ApiClient apiClient;

    public UserServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserServiceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deleteUser
     * @param login  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteUserCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/{Login}"
            .replaceAll("\\{" + "Login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteUserValidateBeforeCall(String login, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling deleteUser(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteUserCall(login, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete a user
     * 
     * @param login  (required)
     * @return RestDeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RestDeleteResponse deleteUser(String login) throws ApiException {
        ApiResponse<RestDeleteResponse> resp = deleteUserWithHttpInfo(login);
        return resp.getData();
    }

    /**
     * Delete a user
     * 
     * @param login  (required)
     * @return ApiResponse&lt;RestDeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<RestDeleteResponse> deleteUserWithHttpInfo(String login) throws ApiException {
        com.squareup.okhttp.Call call = deleteUserValidateBeforeCall(login, null, null);
        Type localVarReturnType = new TypeToken<RestDeleteResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Delete a user (asynchronously)
     * 
     * @param login  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteUserAsync(String login, final ApiCallback<RestDeleteResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteUserValidateBeforeCall(login, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RestDeleteResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getUser
     * @param login  (required)
     * @param uuid User unique identifier. (optional)
     * @param groupPath Path to the parent group. (optional)
     * @param password Password can be passed to be updated (but never read back), field is empty for groups. (optional)
     * @param oldPassword OldPassword must be set when a user updates her own password. (optional)
     * @param isGroup Whether this object is a group or a user. (optional)
     * @param groupLabel Label of the group, field is empty for users. (optional)
     * @param policiesContextEditable Context-resolved to quickly check if user is editable or not. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserCall(String login, String uuid, String groupPath, String password, String oldPassword, Boolean isGroup, String groupLabel, Boolean policiesContextEditable, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/user/{Login}"
            .replaceAll("\\{" + "Login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (uuid != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("Uuid", uuid));
        if (groupPath != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("GroupPath", groupPath));
        if (password != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("Password", password));
        if (oldPassword != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("OldPassword", oldPassword));
        if (isGroup != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("IsGroup", isGroup));
        if (groupLabel != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("GroupLabel", groupLabel));
        if (policiesContextEditable != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("PoliciesContextEditable", policiesContextEditable));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getUserValidateBeforeCall(String login, String uuid, String groupPath, String password, String oldPassword, Boolean isGroup, String groupLabel, Boolean policiesContextEditable, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling getUser(Async)");
        }
        

        com.squareup.okhttp.Call call = getUserCall(login, uuid, groupPath, password, oldPassword, isGroup, groupLabel, policiesContextEditable, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get a user by login
     * 
     * @param login  (required)
     * @param uuid User unique identifier. (optional)
     * @param groupPath Path to the parent group. (optional)
     * @param password Password can be passed to be updated (but never read back), field is empty for groups. (optional)
     * @param oldPassword OldPassword must be set when a user updates her own password. (optional)
     * @param isGroup Whether this object is a group or a user. (optional)
     * @param groupLabel Label of the group, field is empty for users. (optional)
     * @param policiesContextEditable Context-resolved to quickly check if user is editable or not. (optional)
     * @return IdmUser
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdmUser getUser(String login, String uuid, String groupPath, String password, String oldPassword, Boolean isGroup, String groupLabel, Boolean policiesContextEditable) throws ApiException {
        ApiResponse<IdmUser> resp = getUserWithHttpInfo(login, uuid, groupPath, password, oldPassword, isGroup, groupLabel, policiesContextEditable);
        return resp.getData();
    }

    /**
     * Get a user by login
     * 
     * @param login  (required)
     * @param uuid User unique identifier. (optional)
     * @param groupPath Path to the parent group. (optional)
     * @param password Password can be passed to be updated (but never read back), field is empty for groups. (optional)
     * @param oldPassword OldPassword must be set when a user updates her own password. (optional)
     * @param isGroup Whether this object is a group or a user. (optional)
     * @param groupLabel Label of the group, field is empty for users. (optional)
     * @param policiesContextEditable Context-resolved to quickly check if user is editable or not. (optional)
     * @return ApiResponse&lt;IdmUser&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdmUser> getUserWithHttpInfo(String login, String uuid, String groupPath, String password, String oldPassword, Boolean isGroup, String groupLabel, Boolean policiesContextEditable) throws ApiException {
        com.squareup.okhttp.Call call = getUserValidateBeforeCall(login, uuid, groupPath, password, oldPassword, isGroup, groupLabel, policiesContextEditable, null, null);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a user by login (asynchronously)
     * 
     * @param login  (required)
     * @param uuid User unique identifier. (optional)
     * @param groupPath Path to the parent group. (optional)
     * @param password Password can be passed to be updated (but never read back), field is empty for groups. (optional)
     * @param oldPassword OldPassword must be set when a user updates her own password. (optional)
     * @param isGroup Whether this object is a group or a user. (optional)
     * @param groupLabel Label of the group, field is empty for users. (optional)
     * @param policiesContextEditable Context-resolved to quickly check if user is editable or not. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserAsync(String login, String uuid, String groupPath, String password, String oldPassword, Boolean isGroup, String groupLabel, Boolean policiesContextEditable, final ApiCallback<IdmUser> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getUserValidateBeforeCall(login, uuid, groupPath, password, oldPassword, isGroup, groupLabel, policiesContextEditable, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putRoles
     * @param login  (required)
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call putRolesCall(String login, IdmUser body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/user/roles/{Login}"
            .replaceAll("\\{" + "Login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putRolesValidateBeforeCall(String login, IdmUser body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling putRoles(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling putRoles(Async)");
        }
        

        com.squareup.okhttp.Call call = putRolesCall(login, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Just save a user roles, without other datas
     * 
     * @param login  (required)
     * @param body  (required)
     * @return IdmUser
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdmUser putRoles(String login, IdmUser body) throws ApiException {
        ApiResponse<IdmUser> resp = putRolesWithHttpInfo(login, body);
        return resp.getData();
    }

    /**
     * Just save a user roles, without other datas
     * 
     * @param login  (required)
     * @param body  (required)
     * @return ApiResponse&lt;IdmUser&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdmUser> putRolesWithHttpInfo(String login, IdmUser body) throws ApiException {
        com.squareup.okhttp.Call call = putRolesValidateBeforeCall(login, body, null, null);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Just save a user roles, without other datas (asynchronously)
     * 
     * @param login  (required)
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putRolesAsync(String login, IdmUser body, final ApiCallback<IdmUser> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putRolesValidateBeforeCall(login, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for putUser
     * @param login  (required)
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call putUserCall(String login, IdmUser body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/user/{Login}"
            .replaceAll("\\{" + "Login" + "\\}", apiClient.escapeString(login.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call putUserValidateBeforeCall(String login, IdmUser body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new ApiException("Missing the required parameter 'login' when calling putUser(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling putUser(Async)");
        }
        

        com.squareup.okhttp.Call call = putUserCall(login, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create or update a user
     * 
     * @param login  (required)
     * @param body  (required)
     * @return IdmUser
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public IdmUser putUser(String login, IdmUser body) throws ApiException {
        ApiResponse<IdmUser> resp = putUserWithHttpInfo(login, body);
        return resp.getData();
    }

    /**
     * Create or update a user
     * 
     * @param login  (required)
     * @param body  (required)
     * @return ApiResponse&lt;IdmUser&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<IdmUser> putUserWithHttpInfo(String login, IdmUser body) throws ApiException {
        com.squareup.okhttp.Call call = putUserValidateBeforeCall(login, body, null, null);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create or update a user (asynchronously)
     * 
     * @param login  (required)
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putUserAsync(String login, IdmUser body, final ApiCallback<IdmUser> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = putUserValidateBeforeCall(login, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<IdmUser>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for searchUsers
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call searchUsersCall(RestSearchUserRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/user";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call searchUsersValidateBeforeCall(RestSearchUserRequest body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling searchUsers(Async)");
        }
        

        com.squareup.okhttp.Call call = searchUsersCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * List/Search users
     * 
     * @param body  (required)
     * @return RestUsersCollection
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public RestUsersCollection searchUsers(RestSearchUserRequest body) throws ApiException {
        ApiResponse<RestUsersCollection> resp = searchUsersWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * List/Search users
     * 
     * @param body  (required)
     * @return ApiResponse&lt;RestUsersCollection&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<RestUsersCollection> searchUsersWithHttpInfo(RestSearchUserRequest body) throws ApiException {
        com.squareup.okhttp.Call call = searchUsersValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<RestUsersCollection>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List/Search users (asynchronously)
     * 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call searchUsersAsync(RestSearchUserRequest body, final ApiCallback<RestUsersCollection> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = searchUsersValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<RestUsersCollection>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
