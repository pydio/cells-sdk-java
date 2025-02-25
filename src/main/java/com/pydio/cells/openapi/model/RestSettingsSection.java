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
import com.google.gson.JsonArray;
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
 * RestSettingsSection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestSettingsSection {
    public static final String SERIALIZED_NAME_C_H_I_L_D_R_E_N = "CHILDREN";
    @SerializedName(SERIALIZED_NAME_C_H_I_L_D_R_E_N)
    @javax.annotation.Nullable
    private List<RestSettingsEntry> CHILDREN = new ArrayList<>();

    public static final String SERIALIZED_NAME_D_E_S_C_R_I_P_T_I_O_N = "DESCRIPTION";
    @SerializedName(SERIALIZED_NAME_D_E_S_C_R_I_P_T_I_O_N)
    @javax.annotation.Nullable
    private String DESCRIPTION;

    public static final String SERIALIZED_NAME_KEY = "Key";
    @SerializedName(SERIALIZED_NAME_KEY)
    @javax.annotation.Nullable
    private String key;

    public static final String SERIALIZED_NAME_L_A_B_E_L = "LABEL";
    @SerializedName(SERIALIZED_NAME_L_A_B_E_L)
    @javax.annotation.Nullable
    private String LABEL;

    public RestSettingsSection() {
    }

    public RestSettingsSection CHILDREN(@javax.annotation.Nullable List<RestSettingsEntry> CHILDREN) {
        this.CHILDREN = CHILDREN;
        return this;
    }

    public RestSettingsSection addCHILDRENItem(RestSettingsEntry CHILDRENItem) {
        if (this.CHILDREN == null) {
            this.CHILDREN = new ArrayList<>();
        }
        this.CHILDREN.add(CHILDRENItem);
        return this;
    }

    /**
     * Get CHILDREN
     *
     * @return CHILDREN
     */
    @javax.annotation.Nullable
    public List<RestSettingsEntry> getCHILDREN() {
        return CHILDREN;
    }

    public void setCHILDREN(@javax.annotation.Nullable List<RestSettingsEntry> CHILDREN) {
        this.CHILDREN = CHILDREN;
    }


    public RestSettingsSection DESCRIPTION(@javax.annotation.Nullable String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
        return this;
    }

    /**
     * Get DESCRIPTION
     *
     * @return DESCRIPTION
     */
    @javax.annotation.Nullable
    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(@javax.annotation.Nullable String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }


    public RestSettingsSection key(@javax.annotation.Nullable String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
     *
     * @return key
     */
    @javax.annotation.Nullable
    public String getKey() {
        return key;
    }

    public void setKey(@javax.annotation.Nullable String key) {
        this.key = key;
    }


    public RestSettingsSection LABEL(@javax.annotation.Nullable String LABEL) {
        this.LABEL = LABEL;
        return this;
    }

    /**
     * Get LABEL
     *
     * @return LABEL
     */
    @javax.annotation.Nullable
    public String getLABEL() {
        return LABEL;
    }

    public void setLABEL(@javax.annotation.Nullable String LABEL) {
        this.LABEL = LABEL;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestSettingsSection restSettingsSection = (RestSettingsSection) o;
        return Objects.equals(this.CHILDREN, restSettingsSection.CHILDREN) &&
                Objects.equals(this.DESCRIPTION, restSettingsSection.DESCRIPTION) &&
                Objects.equals(this.key, restSettingsSection.key) &&
                Objects.equals(this.LABEL, restSettingsSection.LABEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CHILDREN, DESCRIPTION, key, LABEL);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestSettingsSection {\n");
        sb.append("    CHILDREN: ").append(toIndentedString(CHILDREN)).append("\n");
        sb.append("    DESCRIPTION: ").append(toIndentedString(DESCRIPTION)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    LABEL: ").append(toIndentedString(LABEL)).append("\n");
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
        openapiFields.add("CHILDREN");
        openapiFields.add("DESCRIPTION");
        openapiFields.add("Key");
        openapiFields.add("LABEL");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestSettingsSection
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestSettingsSection.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestSettingsSection is not found in the empty JSON string", RestSettingsSection.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestSettingsSection.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestSettingsSection` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("CHILDREN") != null && !jsonObj.get("CHILDREN").isJsonNull()) {
            JsonArray jsonArrayCHILDREN = jsonObj.getAsJsonArray("CHILDREN");
            if (jsonArrayCHILDREN != null) {
                // ensure the json data is an array
                if (!jsonObj.get("CHILDREN").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `CHILDREN` to be an array in the JSON string but got `%s`", jsonObj.get("CHILDREN").toString()));
                }

                // validate the optional field `CHILDREN` (array)
                for (int i = 0; i < jsonArrayCHILDREN.size(); i++) {
                    RestSettingsEntry.validateJsonElement(jsonArrayCHILDREN.get(i));
                }
                ;
            }
        }
        if ((jsonObj.get("DESCRIPTION") != null && !jsonObj.get("DESCRIPTION").isJsonNull()) && !jsonObj.get("DESCRIPTION").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `DESCRIPTION` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DESCRIPTION").toString()));
        }
        if ((jsonObj.get("Key") != null && !jsonObj.get("Key").isJsonNull()) && !jsonObj.get("Key").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Key").toString()));
        }
        if ((jsonObj.get("LABEL") != null && !jsonObj.get("LABEL").isJsonNull()) && !jsonObj.get("LABEL").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `LABEL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("LABEL").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestSettingsSection.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestSettingsSection' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestSettingsSection> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestSettingsSection.class));

            return (TypeAdapter<T>) new TypeAdapter<RestSettingsSection>() {
                @Override
                public void write(JsonWriter out, RestSettingsSection value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestSettingsSection read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestSettingsSection given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestSettingsSection
     * @throws IOException if the JSON string is invalid with respect to RestSettingsSection
     */
    public static RestSettingsSection fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestSettingsSection.class);
    }

    /**
     * Convert an instance of RestSettingsSection to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

