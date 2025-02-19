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
import com.pydio.cells.openapi.model.IdmUserMeta;

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
 * IdmUpdateUserMetaResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class IdmUpdateUserMetaResponse {
    public static final String SERIALIZED_NAME_META_DATAS = "MetaDatas";
    @SerializedName(SERIALIZED_NAME_META_DATAS)
    @javax.annotation.Nullable
    private List<IdmUserMeta> metaDatas = new ArrayList<>();

    public IdmUpdateUserMetaResponse() {
    }

    public IdmUpdateUserMetaResponse metaDatas(@javax.annotation.Nullable List<IdmUserMeta> metaDatas) {
        this.metaDatas = metaDatas;
        return this;
    }

    public IdmUpdateUserMetaResponse addMetaDatasItem(IdmUserMeta metaDatasItem) {
        if (this.metaDatas == null) {
            this.metaDatas = new ArrayList<>();
        }
        this.metaDatas.add(metaDatasItem);
        return this;
    }

    /**
     * Get metaDatas
     *
     * @return metaDatas
     */
    @javax.annotation.Nullable
    public List<IdmUserMeta> getMetaDatas() {
        return metaDatas;
    }

    public void setMetaDatas(@javax.annotation.Nullable List<IdmUserMeta> metaDatas) {
        this.metaDatas = metaDatas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmUpdateUserMetaResponse idmUpdateUserMetaResponse = (IdmUpdateUserMetaResponse) o;
        return Objects.equals(this.metaDatas, idmUpdateUserMetaResponse.metaDatas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaDatas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmUpdateUserMetaResponse {\n");
        sb.append("    metaDatas: ").append(toIndentedString(metaDatas)).append("\n");
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
        openapiFields.add("MetaDatas");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to IdmUpdateUserMetaResponse
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!IdmUpdateUserMetaResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in IdmUpdateUserMetaResponse is not found in the empty JSON string", IdmUpdateUserMetaResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!IdmUpdateUserMetaResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmUpdateUserMetaResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("MetaDatas") != null && !jsonObj.get("MetaDatas").isJsonNull()) {
            JsonArray jsonArraymetaDatas = jsonObj.getAsJsonArray("MetaDatas");
            if (jsonArraymetaDatas != null) {
                // ensure the json data is an array
                if (!jsonObj.get("MetaDatas").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `MetaDatas` to be an array in the JSON string but got `%s`", jsonObj.get("MetaDatas").toString()));
                }

                // validate the optional field `MetaDatas` (array)
                for (int i = 0; i < jsonArraymetaDatas.size(); i++) {
                    IdmUserMeta.validateJsonElement(jsonArraymetaDatas.get(i));
                }
                ;
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IdmUpdateUserMetaResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IdmUpdateUserMetaResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdmUpdateUserMetaResponse> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(IdmUpdateUserMetaResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<IdmUpdateUserMetaResponse>() {
                @Override
                public void write(JsonWriter out, IdmUpdateUserMetaResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public IdmUpdateUserMetaResponse read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of IdmUpdateUserMetaResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IdmUpdateUserMetaResponse
     * @throws IOException if the JSON string is invalid with respect to IdmUpdateUserMetaResponse
     */
    public static IdmUpdateUserMetaResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IdmUpdateUserMetaResponse.class);
    }

    /**
     * Convert an instance of IdmUpdateUserMetaResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

