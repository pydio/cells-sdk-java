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
 * IdmPolicyCondition
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class IdmPolicyCondition {
    public static final String SERIALIZED_NAME_JSON_OPTIONS = "jsonOptions";
    @SerializedName(SERIALIZED_NAME_JSON_OPTIONS)
    @javax.annotation.Nullable
    private String jsonOptions;

    public static final String SERIALIZED_NAME_TYPE = "type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nullable
    private String type;

    public IdmPolicyCondition() {
    }

    public IdmPolicyCondition jsonOptions(@javax.annotation.Nullable String jsonOptions) {
        this.jsonOptions = jsonOptions;
        return this;
    }

    /**
     * Get jsonOptions
     *
     * @return jsonOptions
     */
    @javax.annotation.Nullable
    public String getJsonOptions() {
        return jsonOptions;
    }

    public void setJsonOptions(@javax.annotation.Nullable String jsonOptions) {
        this.jsonOptions = jsonOptions;
    }


    public IdmPolicyCondition type(@javax.annotation.Nullable String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @javax.annotation.Nullable
    public String getType() {
        return type;
    }

    public void setType(@javax.annotation.Nullable String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmPolicyCondition idmPolicyCondition = (IdmPolicyCondition) o;
        return Objects.equals(this.jsonOptions, idmPolicyCondition.jsonOptions) &&
                Objects.equals(this.type, idmPolicyCondition.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonOptions, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmPolicyCondition {\n");
        sb.append("    jsonOptions: ").append(toIndentedString(jsonOptions)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
        openapiFields.add("jsonOptions");
        openapiFields.add("type");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to IdmPolicyCondition
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!IdmPolicyCondition.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in IdmPolicyCondition is not found in the empty JSON string", IdmPolicyCondition.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!IdmPolicyCondition.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmPolicyCondition` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("jsonOptions") != null && !jsonObj.get("jsonOptions").isJsonNull()) && !jsonObj.get("jsonOptions").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `jsonOptions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("jsonOptions").toString()));
        }
        if ((jsonObj.get("type") != null && !jsonObj.get("type").isJsonNull()) && !jsonObj.get("type").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("type").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IdmPolicyCondition.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IdmPolicyCondition' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdmPolicyCondition> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(IdmPolicyCondition.class));

            return (TypeAdapter<T>) new TypeAdapter<IdmPolicyCondition>() {
                @Override
                public void write(JsonWriter out, IdmPolicyCondition value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public IdmPolicyCondition read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of IdmPolicyCondition given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IdmPolicyCondition
     * @throws IOException if the JSON string is invalid with respect to IdmPolicyCondition
     */
    public static IdmPolicyCondition fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IdmPolicyCondition.class);
    }

    /**
     * Convert an instance of IdmPolicyCondition to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

