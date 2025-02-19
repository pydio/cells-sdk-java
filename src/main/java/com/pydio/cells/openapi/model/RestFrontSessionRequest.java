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


package com.pydio.cells.openapi.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RestFrontSessionRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestFrontSessionRequest {
    public static final String SERIALIZED_NAME_AUTH_INFO = "AuthInfo";
    @SerializedName(SERIALIZED_NAME_AUTH_INFO)
    @javax.annotation.Nullable
    private Map<String, String> authInfo = new HashMap<>();

    public static final String SERIALIZED_NAME_CLIENT_TIME = "ClientTime";
    @SerializedName(SERIALIZED_NAME_CLIENT_TIME)
    @javax.annotation.Nullable
    private Integer clientTime;

    public static final String SERIALIZED_NAME_LOGOUT = "Logout";
    @SerializedName(SERIALIZED_NAME_LOGOUT)
    @javax.annotation.Nullable
    private Boolean logout;

    public RestFrontSessionRequest() {
    }

    public RestFrontSessionRequest authInfo(@javax.annotation.Nullable Map<String, String> authInfo) {
        this.authInfo = authInfo;
        return this;
    }

    public RestFrontSessionRequest putAuthInfoItem(String key, String authInfoItem) {
        if (this.authInfo == null) {
            this.authInfo = new HashMap<>();
        }
        this.authInfo.put(key, authInfoItem);
        return this;
    }

    /**
     * Get authInfo
     *
     * @return authInfo
     */
    @javax.annotation.Nullable
    public Map<String, String> getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(@javax.annotation.Nullable Map<String, String> authInfo) {
        this.authInfo = authInfo;
    }


    public RestFrontSessionRequest clientTime(@javax.annotation.Nullable Integer clientTime) {
        this.clientTime = clientTime;
        return this;
    }

    /**
     * Get clientTime
     *
     * @return clientTime
     */
    @javax.annotation.Nullable
    public Integer getClientTime() {
        return clientTime;
    }

    public void setClientTime(@javax.annotation.Nullable Integer clientTime) {
        this.clientTime = clientTime;
    }


    public RestFrontSessionRequest logout(@javax.annotation.Nullable Boolean logout) {
        this.logout = logout;
        return this;
    }

    /**
     * Get logout
     *
     * @return logout
     */
    @javax.annotation.Nullable
    public Boolean getLogout() {
        return logout;
    }

    public void setLogout(@javax.annotation.Nullable Boolean logout) {
        this.logout = logout;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestFrontSessionRequest restFrontSessionRequest = (RestFrontSessionRequest) o;
        return Objects.equals(this.authInfo, restFrontSessionRequest.authInfo) &&
                Objects.equals(this.clientTime, restFrontSessionRequest.clientTime) &&
                Objects.equals(this.logout, restFrontSessionRequest.logout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authInfo, clientTime, logout);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestFrontSessionRequest {\n");
        sb.append("    authInfo: ").append(toIndentedString(authInfo)).append("\n");
        sb.append("    clientTime: ").append(toIndentedString(clientTime)).append("\n");
        sb.append("    logout: ").append(toIndentedString(logout)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("AuthInfo");
        openapiFields.add("ClientTime");
        openapiFields.add("Logout");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestFrontSessionRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestFrontSessionRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestFrontSessionRequest is not found in the empty JSON string", RestFrontSessionRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestFrontSessionRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestFrontSessionRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestFrontSessionRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestFrontSessionRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestFrontSessionRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestFrontSessionRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<RestFrontSessionRequest>() {
                @Override
                public void write(JsonWriter out, RestFrontSessionRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestFrontSessionRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestFrontSessionRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestFrontSessionRequest
     * @throws IOException if the JSON string is invalid with respect to RestFrontSessionRequest
     */
    public static RestFrontSessionRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestFrontSessionRequest.class);
    }

    /**
     * Convert an instance of RestFrontSessionRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

