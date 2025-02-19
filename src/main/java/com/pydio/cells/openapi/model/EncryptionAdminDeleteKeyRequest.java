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
 * EncryptionAdminDeleteKeyRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class EncryptionAdminDeleteKeyRequest {
    public static final String SERIALIZED_NAME_KEY_I_D = "KeyID";
    @SerializedName(SERIALIZED_NAME_KEY_I_D)
    @javax.annotation.Nullable
    private String keyID;

    public EncryptionAdminDeleteKeyRequest() {
    }

    public EncryptionAdminDeleteKeyRequest keyID(@javax.annotation.Nullable String keyID) {
        this.keyID = keyID;
        return this;
    }

    /**
     * Get keyID
     *
     * @return keyID
     */
    @javax.annotation.Nullable
    public String getKeyID() {
        return keyID;
    }

    public void setKeyID(@javax.annotation.Nullable String keyID) {
        this.keyID = keyID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EncryptionAdminDeleteKeyRequest encryptionAdminDeleteKeyRequest = (EncryptionAdminDeleteKeyRequest) o;
        return Objects.equals(this.keyID, encryptionAdminDeleteKeyRequest.keyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EncryptionAdminDeleteKeyRequest {\n");
        sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
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
        openapiFields.add("KeyID");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to EncryptionAdminDeleteKeyRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!EncryptionAdminDeleteKeyRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in EncryptionAdminDeleteKeyRequest is not found in the empty JSON string", EncryptionAdminDeleteKeyRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!EncryptionAdminDeleteKeyRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EncryptionAdminDeleteKeyRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("KeyID") != null && !jsonObj.get("KeyID").isJsonNull()) && !jsonObj.get("KeyID").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `KeyID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("KeyID").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!EncryptionAdminDeleteKeyRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'EncryptionAdminDeleteKeyRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<EncryptionAdminDeleteKeyRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(EncryptionAdminDeleteKeyRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<EncryptionAdminDeleteKeyRequest>() {
                @Override
                public void write(JsonWriter out, EncryptionAdminDeleteKeyRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public EncryptionAdminDeleteKeyRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of EncryptionAdminDeleteKeyRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of EncryptionAdminDeleteKeyRequest
     * @throws IOException if the JSON string is invalid with respect to EncryptionAdminDeleteKeyRequest
     */
    public static EncryptionAdminDeleteKeyRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, EncryptionAdminDeleteKeyRequest.class);
    }

    /**
     * Convert an instance of EncryptionAdminDeleteKeyRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

