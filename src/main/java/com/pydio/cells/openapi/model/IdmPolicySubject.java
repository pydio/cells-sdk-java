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
 * IdmPolicySubject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class IdmPolicySubject {
    public static final String SERIALIZED_NAME_COMPILED = "Compiled";
    @SerializedName(SERIALIZED_NAME_COMPILED)
    @javax.annotation.Nullable
    private String compiled;

    public static final String SERIALIZED_NAME_HAS_REGEX = "HasRegex";
    @SerializedName(SERIALIZED_NAME_HAS_REGEX)
    @javax.annotation.Nullable
    private Boolean hasRegex;

    public static final String SERIALIZED_NAME_I_D = "ID";
    @SerializedName(SERIALIZED_NAME_I_D)
    @javax.annotation.Nullable
    private String ID;

    public static final String SERIALIZED_NAME_TEMPLATE = "Template";
    @SerializedName(SERIALIZED_NAME_TEMPLATE)
    @javax.annotation.Nullable
    private String template;

    public IdmPolicySubject() {
    }

    public IdmPolicySubject compiled(@javax.annotation.Nullable String compiled) {
        this.compiled = compiled;
        return this;
    }

    /**
     * Get compiled
     *
     * @return compiled
     */
    @javax.annotation.Nullable
    public String getCompiled() {
        return compiled;
    }

    public void setCompiled(@javax.annotation.Nullable String compiled) {
        this.compiled = compiled;
    }


    public IdmPolicySubject hasRegex(@javax.annotation.Nullable Boolean hasRegex) {
        this.hasRegex = hasRegex;
        return this;
    }

    /**
     * Get hasRegex
     *
     * @return hasRegex
     */
    @javax.annotation.Nullable
    public Boolean getHasRegex() {
        return hasRegex;
    }

    public void setHasRegex(@javax.annotation.Nullable Boolean hasRegex) {
        this.hasRegex = hasRegex;
    }


    public IdmPolicySubject ID(@javax.annotation.Nullable String ID) {
        this.ID = ID;
        return this;
    }

    /**
     * Get ID
     *
     * @return ID
     */
    @javax.annotation.Nullable
    public String getID() {
        return ID;
    }

    public void setID(@javax.annotation.Nullable String ID) {
        this.ID = ID;
    }


    public IdmPolicySubject template(@javax.annotation.Nullable String template) {
        this.template = template;
        return this;
    }

    /**
     * Get template
     *
     * @return template
     */
    @javax.annotation.Nullable
    public String getTemplate() {
        return template;
    }

    public void setTemplate(@javax.annotation.Nullable String template) {
        this.template = template;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmPolicySubject idmPolicySubject = (IdmPolicySubject) o;
        return Objects.equals(this.compiled, idmPolicySubject.compiled) &&
                Objects.equals(this.hasRegex, idmPolicySubject.hasRegex) &&
                Objects.equals(this.ID, idmPolicySubject.ID) &&
                Objects.equals(this.template, idmPolicySubject.template);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compiled, hasRegex, ID, template);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmPolicySubject {\n");
        sb.append("    compiled: ").append(toIndentedString(compiled)).append("\n");
        sb.append("    hasRegex: ").append(toIndentedString(hasRegex)).append("\n");
        sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
        sb.append("    template: ").append(toIndentedString(template)).append("\n");
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
        openapiFields.add("Compiled");
        openapiFields.add("HasRegex");
        openapiFields.add("ID");
        openapiFields.add("Template");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to IdmPolicySubject
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!IdmPolicySubject.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in IdmPolicySubject is not found in the empty JSON string", IdmPolicySubject.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!IdmPolicySubject.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmPolicySubject` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("Compiled") != null && !jsonObj.get("Compiled").isJsonNull()) && !jsonObj.get("Compiled").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Compiled` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Compiled").toString()));
        }
        if ((jsonObj.get("ID") != null && !jsonObj.get("ID").isJsonNull()) && !jsonObj.get("ID").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `ID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ID").toString()));
        }
        if ((jsonObj.get("Template") != null && !jsonObj.get("Template").isJsonNull()) && !jsonObj.get("Template").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Template` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Template").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IdmPolicySubject.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IdmPolicySubject' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdmPolicySubject> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(IdmPolicySubject.class));

            return (TypeAdapter<T>) new TypeAdapter<IdmPolicySubject>() {
                @Override
                public void write(JsonWriter out, IdmPolicySubject value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public IdmPolicySubject read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of IdmPolicySubject given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IdmPolicySubject
     * @throws IOException if the JSON string is invalid with respect to IdmPolicySubject
     */
    public static IdmPolicySubject fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IdmPolicySubject.class);
    }

    /**
     * Convert an instance of IdmPolicySubject to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

