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
import com.pydio.cells.openapi.model.ActivityOwnerType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * ActivitySearchSubscriptionsRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class ActivitySearchSubscriptionsRequest {
    public static final String SERIALIZED_NAME_OBJECT_IDS = "ObjectIds";
    @SerializedName(SERIALIZED_NAME_OBJECT_IDS)
    @javax.annotation.Nullable
    private List<String> objectIds = new ArrayList<>();

    public static final String SERIALIZED_NAME_OBJECT_TYPES = "ObjectTypes";
    @SerializedName(SERIALIZED_NAME_OBJECT_TYPES)
    @javax.annotation.Nullable
    private List<ActivityOwnerType> objectTypes = new ArrayList<>();

    public static final String SERIALIZED_NAME_USER_IDS = "UserIds";
    @SerializedName(SERIALIZED_NAME_USER_IDS)
    @javax.annotation.Nullable
    private List<String> userIds = new ArrayList<>();

    public ActivitySearchSubscriptionsRequest() {
    }

    public ActivitySearchSubscriptionsRequest objectIds(@javax.annotation.Nullable List<String> objectIds) {
        this.objectIds = objectIds;
        return this;
    }

    public ActivitySearchSubscriptionsRequest addObjectIdsItem(String objectIdsItem) {
        if (this.objectIds == null) {
            this.objectIds = new ArrayList<>();
        }
        this.objectIds.add(objectIdsItem);
        return this;
    }

    /**
     * Get objectIds
     *
     * @return objectIds
     */
    @javax.annotation.Nullable
    public List<String> getObjectIds() {
        return objectIds;
    }

    public void setObjectIds(@javax.annotation.Nullable List<String> objectIds) {
        this.objectIds = objectIds;
    }


    public ActivitySearchSubscriptionsRequest objectTypes(@javax.annotation.Nullable List<ActivityOwnerType> objectTypes) {
        this.objectTypes = objectTypes;
        return this;
    }

    public ActivitySearchSubscriptionsRequest addObjectTypesItem(ActivityOwnerType objectTypesItem) {
        if (this.objectTypes == null) {
            this.objectTypes = new ArrayList<>();
        }
        this.objectTypes.add(objectTypesItem);
        return this;
    }

    /**
     * Get objectTypes
     *
     * @return objectTypes
     */
    @javax.annotation.Nullable
    public List<ActivityOwnerType> getObjectTypes() {
        return objectTypes;
    }

    public void setObjectTypes(@javax.annotation.Nullable List<ActivityOwnerType> objectTypes) {
        this.objectTypes = objectTypes;
    }


    public ActivitySearchSubscriptionsRequest userIds(@javax.annotation.Nullable List<String> userIds) {
        this.userIds = userIds;
        return this;
    }

    public ActivitySearchSubscriptionsRequest addUserIdsItem(String userIdsItem) {
        if (this.userIds == null) {
            this.userIds = new ArrayList<>();
        }
        this.userIds.add(userIdsItem);
        return this;
    }

    /**
     * Get userIds
     *
     * @return userIds
     */
    @javax.annotation.Nullable
    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(@javax.annotation.Nullable List<String> userIds) {
        this.userIds = userIds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ActivitySearchSubscriptionsRequest activitySearchSubscriptionsRequest = (ActivitySearchSubscriptionsRequest) o;
        return Objects.equals(this.objectIds, activitySearchSubscriptionsRequest.objectIds) &&
                Objects.equals(this.objectTypes, activitySearchSubscriptionsRequest.objectTypes) &&
                Objects.equals(this.userIds, activitySearchSubscriptionsRequest.userIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectIds, objectTypes, userIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ActivitySearchSubscriptionsRequest {\n");
        sb.append("    objectIds: ").append(toIndentedString(objectIds)).append("\n");
        sb.append("    objectTypes: ").append(toIndentedString(objectTypes)).append("\n");
        sb.append("    userIds: ").append(toIndentedString(userIds)).append("\n");
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
        openapiFields.add("ObjectIds");
        openapiFields.add("ObjectTypes");
        openapiFields.add("UserIds");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ActivitySearchSubscriptionsRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ActivitySearchSubscriptionsRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in ActivitySearchSubscriptionsRequest is not found in the empty JSON string", ActivitySearchSubscriptionsRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ActivitySearchSubscriptionsRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ActivitySearchSubscriptionsRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // ensure the optional json data is an array if present
        if (jsonObj.get("ObjectIds") != null && !jsonObj.get("ObjectIds").isJsonNull() && !jsonObj.get("ObjectIds").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `ObjectIds` to be an array in the JSON string but got `%s`", jsonObj.get("ObjectIds").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("ObjectTypes") != null && !jsonObj.get("ObjectTypes").isJsonNull() && !jsonObj.get("ObjectTypes").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `ObjectTypes` to be an array in the JSON string but got `%s`", jsonObj.get("ObjectTypes").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("UserIds") != null && !jsonObj.get("UserIds").isJsonNull() && !jsonObj.get("UserIds").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `UserIds` to be an array in the JSON string but got `%s`", jsonObj.get("UserIds").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ActivitySearchSubscriptionsRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ActivitySearchSubscriptionsRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ActivitySearchSubscriptionsRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(ActivitySearchSubscriptionsRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<ActivitySearchSubscriptionsRequest>() {
                @Override
                public void write(JsonWriter out, ActivitySearchSubscriptionsRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ActivitySearchSubscriptionsRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of ActivitySearchSubscriptionsRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ActivitySearchSubscriptionsRequest
     * @throws IOException if the JSON string is invalid with respect to ActivitySearchSubscriptionsRequest
     */
    public static ActivitySearchSubscriptionsRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ActivitySearchSubscriptionsRequest.class);
    }

    /**
     * Convert an instance of ActivitySearchSubscriptionsRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

