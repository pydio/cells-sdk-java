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
 * InstallHeaderMod
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class InstallHeaderMod {
    public static final String SERIALIZED_NAME_ACTION = "Action";
    @SerializedName(SERIALIZED_NAME_ACTION)
    @javax.annotation.Nullable
    private InstallHeaderModAction action = InstallHeaderModAction.APPEND_IF_EXISTS_OR_ADD;

    public static final String SERIALIZED_NAME_APPLY_TO = "ApplyTo";
    @SerializedName(SERIALIZED_NAME_APPLY_TO)
    @javax.annotation.Nullable
    private InstallHeaderModApplyTo applyTo = InstallHeaderModApplyTo.REQUEST;

    public static final String SERIALIZED_NAME_KEY = "Key";
    @SerializedName(SERIALIZED_NAME_KEY)
    @javax.annotation.Nullable
    private String key;

    public static final String SERIALIZED_NAME_VALUE = "Value";
    @SerializedName(SERIALIZED_NAME_VALUE)
    @javax.annotation.Nullable
    private String value;

    public InstallHeaderMod() {
    }

    public InstallHeaderMod action(@javax.annotation.Nullable InstallHeaderModAction action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     *
     * @return action
     */
    @javax.annotation.Nullable
    public InstallHeaderModAction getAction() {
        return action;
    }

    public void setAction(@javax.annotation.Nullable InstallHeaderModAction action) {
        this.action = action;
    }


    public InstallHeaderMod applyTo(@javax.annotation.Nullable InstallHeaderModApplyTo applyTo) {
        this.applyTo = applyTo;
        return this;
    }

    /**
     * Get applyTo
     *
     * @return applyTo
     */
    @javax.annotation.Nullable
    public InstallHeaderModApplyTo getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(@javax.annotation.Nullable InstallHeaderModApplyTo applyTo) {
        this.applyTo = applyTo;
    }


    public InstallHeaderMod key(@javax.annotation.Nullable String key) {
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


    public InstallHeaderMod value(@javax.annotation.Nullable String value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     */
    @javax.annotation.Nullable
    public String getValue() {
        return value;
    }

    public void setValue(@javax.annotation.Nullable String value) {
        this.value = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstallHeaderMod installHeaderMod = (InstallHeaderMod) o;
        return Objects.equals(this.action, installHeaderMod.action) &&
                Objects.equals(this.applyTo, installHeaderMod.applyTo) &&
                Objects.equals(this.key, installHeaderMod.key) &&
                Objects.equals(this.value, installHeaderMod.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, applyTo, key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InstallHeaderMod {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    applyTo: ").append(toIndentedString(applyTo)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
        openapiFields.add("Action");
        openapiFields.add("ApplyTo");
        openapiFields.add("Key");
        openapiFields.add("Value");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to InstallHeaderMod
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!InstallHeaderMod.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in InstallHeaderMod is not found in the empty JSON string", InstallHeaderMod.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!InstallHeaderMod.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InstallHeaderMod` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `Action`
        if (jsonObj.get("Action") != null && !jsonObj.get("Action").isJsonNull()) {
            InstallHeaderModAction.validateJsonElement(jsonObj.get("Action"));
        }
        // validate the optional field `ApplyTo`
        if (jsonObj.get("ApplyTo") != null && !jsonObj.get("ApplyTo").isJsonNull()) {
            InstallHeaderModApplyTo.validateJsonElement(jsonObj.get("ApplyTo"));
        }
        if ((jsonObj.get("Key") != null && !jsonObj.get("Key").isJsonNull()) && !jsonObj.get("Key").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Key").toString()));
        }
        if ((jsonObj.get("Value") != null && !jsonObj.get("Value").isJsonNull()) && !jsonObj.get("Value").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Value` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Value").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!InstallHeaderMod.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'InstallHeaderMod' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<InstallHeaderMod> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(InstallHeaderMod.class));

            return (TypeAdapter<T>) new TypeAdapter<InstallHeaderMod>() {
                @Override
                public void write(JsonWriter out, InstallHeaderMod value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public InstallHeaderMod read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of InstallHeaderMod given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of InstallHeaderMod
     * @throws IOException if the JSON string is invalid with respect to InstallHeaderMod
     */
    public static InstallHeaderMod fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, InstallHeaderMod.class);
    }

    /**
     * Convert an instance of InstallHeaderMod to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

