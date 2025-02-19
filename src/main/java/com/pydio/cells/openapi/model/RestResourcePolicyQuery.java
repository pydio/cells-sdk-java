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
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RestResourcePolicyQuery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestResourcePolicyQuery {
    public static final String SERIALIZED_NAME_TYPE = "Type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nullable
    private ResourcePolicyQueryQueryType type = ResourcePolicyQueryQueryType.CONTEXT;

    public static final String SERIALIZED_NAME_USER_ID = "UserId";
    @SerializedName(SERIALIZED_NAME_USER_ID)
    @javax.annotation.Nullable
    private String userId;

    public RestResourcePolicyQuery() {
    }

    public RestResourcePolicyQuery type(@javax.annotation.Nullable ResourcePolicyQueryQueryType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @javax.annotation.Nullable
    public ResourcePolicyQueryQueryType getType() {
        return type;
    }

    public void setType(@javax.annotation.Nullable ResourcePolicyQueryQueryType type) {
        this.type = type;
    }


    public RestResourcePolicyQuery userId(@javax.annotation.Nullable String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get userId
     *
     * @return userId
     */
    @javax.annotation.Nullable
    public String getUserId() {
        return userId;
    }

    public void setUserId(@javax.annotation.Nullable String userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestResourcePolicyQuery restResourcePolicyQuery = (RestResourcePolicyQuery) o;
        return Objects.equals(this.type, restResourcePolicyQuery.type) &&
                Objects.equals(this.userId, restResourcePolicyQuery.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestResourcePolicyQuery {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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
        openapiFields.add("Type");
        openapiFields.add("UserId");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestResourcePolicyQuery
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestResourcePolicyQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestResourcePolicyQuery is not found in the empty JSON string", RestResourcePolicyQuery.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestResourcePolicyQuery.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestResourcePolicyQuery` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `Type`
        if (jsonObj.get("Type") != null && !jsonObj.get("Type").isJsonNull()) {
            ResourcePolicyQueryQueryType.validateJsonElement(jsonObj.get("Type"));
        }
        if ((jsonObj.get("UserId") != null && !jsonObj.get("UserId").isJsonNull()) && !jsonObj.get("UserId").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `UserId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UserId").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestResourcePolicyQuery.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestResourcePolicyQuery' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestResourcePolicyQuery> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestResourcePolicyQuery.class));

            return (TypeAdapter<T>) new TypeAdapter<RestResourcePolicyQuery>() {
                @Override
                public void write(JsonWriter out, RestResourcePolicyQuery value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestResourcePolicyQuery read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestResourcePolicyQuery given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestResourcePolicyQuery
     * @throws IOException if the JSON string is invalid with respect to RestResourcePolicyQuery
     */
    public static RestResourcePolicyQuery fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestResourcePolicyQuery.class);
    }

    /**
     * Convert an instance of RestResourcePolicyQuery to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

