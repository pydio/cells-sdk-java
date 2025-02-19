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
 * RestError
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestError {
    public static final String SERIALIZED_NAME_CODE = "Code";
    @SerializedName(SERIALIZED_NAME_CODE)
    @javax.annotation.Nullable
    private String code;

    public static final String SERIALIZED_NAME_DETAIL = "Detail";
    @SerializedName(SERIALIZED_NAME_DETAIL)
    @javax.annotation.Nullable
    private String detail;

    public static final String SERIALIZED_NAME_META = "Meta";
    @SerializedName(SERIALIZED_NAME_META)
    @javax.annotation.Nullable
    private Map<String, String> meta = new HashMap<>();

    public static final String SERIALIZED_NAME_SOURCE = "Source";
    @SerializedName(SERIALIZED_NAME_SOURCE)
    @javax.annotation.Nullable
    private String source;

    public static final String SERIALIZED_NAME_TITLE = "Title";
    @SerializedName(SERIALIZED_NAME_TITLE)
    @javax.annotation.Nullable
    private String title;

    public RestError() {
    }

    public RestError code(@javax.annotation.Nullable String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */
    @javax.annotation.Nullable
    public String getCode() {
        return code;
    }

    public void setCode(@javax.annotation.Nullable String code) {
        this.code = code;
    }


    public RestError detail(@javax.annotation.Nullable String detail) {
        this.detail = detail;
        return this;
    }

    /**
     * Get detail
     *
     * @return detail
     */
    @javax.annotation.Nullable
    public String getDetail() {
        return detail;
    }

    public void setDetail(@javax.annotation.Nullable String detail) {
        this.detail = detail;
    }


    public RestError meta(@javax.annotation.Nullable Map<String, String> meta) {
        this.meta = meta;
        return this;
    }

    public RestError putMetaItem(String key, String metaItem) {
        if (this.meta == null) {
            this.meta = new HashMap<>();
        }
        this.meta.put(key, metaItem);
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @javax.annotation.Nullable
    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(@javax.annotation.Nullable Map<String, String> meta) {
        this.meta = meta;
    }


    public RestError source(@javax.annotation.Nullable String source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     */
    @javax.annotation.Nullable
    public String getSource() {
        return source;
    }

    public void setSource(@javax.annotation.Nullable String source) {
        this.source = source;
    }


    public RestError title(@javax.annotation.Nullable String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     */
    @javax.annotation.Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@javax.annotation.Nullable String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestError restError = (RestError) o;
        return Objects.equals(this.code, restError.code) &&
                Objects.equals(this.detail, restError.detail) &&
                Objects.equals(this.meta, restError.meta) &&
                Objects.equals(this.source, restError.source) &&
                Objects.equals(this.title, restError.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, detail, meta, source, title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestError {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
        openapiFields.add("Code");
        openapiFields.add("Detail");
        openapiFields.add("Meta");
        openapiFields.add("Source");
        openapiFields.add("Title");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestError
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestError.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestError is not found in the empty JSON string", RestError.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestError.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestError` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("Code") != null && !jsonObj.get("Code").isJsonNull()) && !jsonObj.get("Code").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Code` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Code").toString()));
        }
        if ((jsonObj.get("Detail") != null && !jsonObj.get("Detail").isJsonNull()) && !jsonObj.get("Detail").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Detail` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Detail").toString()));
        }
        if ((jsonObj.get("Source") != null && !jsonObj.get("Source").isJsonNull()) && !jsonObj.get("Source").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Source` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Source").toString()));
        }
        if ((jsonObj.get("Title") != null && !jsonObj.get("Title").isJsonNull()) && !jsonObj.get("Title").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Title").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestError.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestError' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestError> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestError.class));

            return (TypeAdapter<T>) new TypeAdapter<RestError>() {
                @Override
                public void write(JsonWriter out, RestError value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestError read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestError given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestError
     * @throws IOException if the JSON string is invalid with respect to RestError
     */
    public static RestError fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestError.class);
    }

    /**
     * Convert an instance of RestError to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

