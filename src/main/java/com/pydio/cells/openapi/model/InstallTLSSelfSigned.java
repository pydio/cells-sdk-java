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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * InstallTLSSelfSigned
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class InstallTLSSelfSigned {
    public static final String SERIALIZED_NAME_HOSTNAMES = "Hostnames";
    @SerializedName(SERIALIZED_NAME_HOSTNAMES)
    @javax.annotation.Nullable
    private List<String> hostnames = new ArrayList<>();

    public InstallTLSSelfSigned() {
    }

    public InstallTLSSelfSigned hostnames(@javax.annotation.Nullable List<String> hostnames) {
        this.hostnames = hostnames;
        return this;
    }

    public InstallTLSSelfSigned addHostnamesItem(String hostnamesItem) {
        if (this.hostnames == null) {
            this.hostnames = new ArrayList<>();
        }
        this.hostnames.add(hostnamesItem);
        return this;
    }

    /**
     * Get hostnames
     *
     * @return hostnames
     */
    @javax.annotation.Nullable
    public List<String> getHostnames() {
        return hostnames;
    }

    public void setHostnames(@javax.annotation.Nullable List<String> hostnames) {
        this.hostnames = hostnames;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstallTLSSelfSigned installTLSSelfSigned = (InstallTLSSelfSigned) o;
        return Objects.equals(this.hostnames, installTLSSelfSigned.hostnames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostnames);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstallTLSSelfSigned {\n");
        sb.append("    hostnames: ").append(toIndentedString(hostnames)).append("\n");
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
        openapiFields.add("Hostnames");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to InstallTLSSelfSigned
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!InstallTLSSelfSigned.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in InstallTLSSelfSigned is not found in the empty JSON string", InstallTLSSelfSigned.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!InstallTLSSelfSigned.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InstallTLSSelfSigned` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // ensure the optional json data is an array if present
        if (jsonObj.get("Hostnames") != null && !jsonObj.get("Hostnames").isJsonNull() && !jsonObj.get("Hostnames").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Hostnames` to be an array in the JSON string but got `%s`", jsonObj.get("Hostnames").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!InstallTLSSelfSigned.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'InstallTLSSelfSigned' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<InstallTLSSelfSigned> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(InstallTLSSelfSigned.class));

            return (TypeAdapter<T>) new TypeAdapter<InstallTLSSelfSigned>() {
                @Override
                public void write(JsonWriter out, InstallTLSSelfSigned value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public InstallTLSSelfSigned read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of InstallTLSSelfSigned given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of InstallTLSSelfSigned
     * @throws IOException if the JSON string is invalid with respect to InstallTLSSelfSigned
     */
    public static InstallTLSSelfSigned fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, InstallTLSSelfSigned.class);
    }

    /**
     * Convert an instance of InstallTLSSelfSigned to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

