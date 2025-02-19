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

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pydio.cells.openapi.JSON;

/**
 * RestDocumentAccessTokenRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestDocumentAccessTokenRequest {
    public static final String SERIALIZED_NAME_CLIENT_I_D = "ClientID";
    @SerializedName(SERIALIZED_NAME_CLIENT_I_D)
    @javax.annotation.Nullable
    private String clientID;

    public static final String SERIALIZED_NAME_PATH = "Path";
    @SerializedName(SERIALIZED_NAME_PATH)
    @javax.annotation.Nullable
    private String path;

    public RestDocumentAccessTokenRequest() {
    }

    public RestDocumentAccessTokenRequest clientID(@javax.annotation.Nullable String clientID) {
        this.clientID = clientID;
        return this;
    }

    /**
     * Get clientID
     *
     * @return clientID
     */
    @javax.annotation.Nullable
    public String getClientID() {
        return clientID;
    }

    public void setClientID(@javax.annotation.Nullable String clientID) {
        this.clientID = clientID;
    }


    public RestDocumentAccessTokenRequest path(@javax.annotation.Nullable String path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     */
    @javax.annotation.Nullable
    public String getPath() {
        return path;
    }

    public void setPath(@javax.annotation.Nullable String path) {
        this.path = path;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestDocumentAccessTokenRequest restDocumentAccessTokenRequest = (RestDocumentAccessTokenRequest) o;
        return Objects.equals(this.clientID, restDocumentAccessTokenRequest.clientID) &&
                Objects.equals(this.path, restDocumentAccessTokenRequest.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDocumentAccessTokenRequest {\n");
        sb.append("    clientID: ").append(toIndentedString(clientID)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
        openapiFields.add("ClientID");
        openapiFields.add("Path");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestDocumentAccessTokenRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestDocumentAccessTokenRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestDocumentAccessTokenRequest is not found in the empty JSON string", RestDocumentAccessTokenRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestDocumentAccessTokenRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestDocumentAccessTokenRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("ClientID") != null && !jsonObj.get("ClientID").isJsonNull()) && !jsonObj.get("ClientID").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `ClientID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ClientID").toString()));
        }
        if ((jsonObj.get("Path") != null && !jsonObj.get("Path").isJsonNull()) && !jsonObj.get("Path").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Path` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Path").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestDocumentAccessTokenRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestDocumentAccessTokenRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestDocumentAccessTokenRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestDocumentAccessTokenRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<RestDocumentAccessTokenRequest>() {
                @Override
                public void write(JsonWriter out, RestDocumentAccessTokenRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestDocumentAccessTokenRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestDocumentAccessTokenRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestDocumentAccessTokenRequest
     * @throws IOException if the JSON string is invalid with respect to RestDocumentAccessTokenRequest
     */
    public static RestDocumentAccessTokenRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestDocumentAccessTokenRequest.class);
    }

    /**
     * Convert an instance of RestDocumentAccessTokenRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

