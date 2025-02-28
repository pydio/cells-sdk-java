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
 * RestTemplate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestTemplate {
    public static final String SERIALIZED_NAME_EDITABLE = "Editable";
    @SerializedName(SERIALIZED_NAME_EDITABLE)
    @javax.annotation.Nullable
    private Boolean editable;

    public static final String SERIALIZED_NAME_LABEL = "Label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    @javax.annotation.Nullable
    private String label;

    public static final String SERIALIZED_NAME_NODE = "Node";
    @SerializedName(SERIALIZED_NAME_NODE)
    @javax.annotation.Nullable
    private RestTemplateNode node;

    public static final String SERIALIZED_NAME_POLICIES = "Policies";
    @SerializedName(SERIALIZED_NAME_POLICIES)
    @javax.annotation.Nullable
    private List<ServiceResourcePolicy> policies = new ArrayList<>();

    public static final String SERIALIZED_NAME_U_U_I_D = "UUID";
    @SerializedName(SERIALIZED_NAME_U_U_I_D)
    @javax.annotation.Nullable
    private String UUID;

    public RestTemplate() {
    }

    public RestTemplate editable(@javax.annotation.Nullable Boolean editable) {
        this.editable = editable;
        return this;
    }

    /**
     * Get editable
     *
     * @return editable
     */
    @javax.annotation.Nullable
    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(@javax.annotation.Nullable Boolean editable) {
        this.editable = editable;
    }


    public RestTemplate label(@javax.annotation.Nullable String label) {
        this.label = label;
        return this;
    }

    /**
     * Get label
     *
     * @return label
     */
    @javax.annotation.Nullable
    public String getLabel() {
        return label;
    }

    public void setLabel(@javax.annotation.Nullable String label) {
        this.label = label;
    }


    public RestTemplate node(@javax.annotation.Nullable RestTemplateNode node) {
        this.node = node;
        return this;
    }

    /**
     * Get node
     *
     * @return node
     */
    @javax.annotation.Nullable
    public RestTemplateNode getNode() {
        return node;
    }

    public void setNode(@javax.annotation.Nullable RestTemplateNode node) {
        this.node = node;
    }


    public RestTemplate policies(@javax.annotation.Nullable List<ServiceResourcePolicy> policies) {
        this.policies = policies;
        return this;
    }

    public RestTemplate addPoliciesItem(ServiceResourcePolicy policiesItem) {
        if (this.policies == null) {
            this.policies = new ArrayList<>();
        }
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * Get policies
     *
     * @return policies
     */
    @javax.annotation.Nullable
    public List<ServiceResourcePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(@javax.annotation.Nullable List<ServiceResourcePolicy> policies) {
        this.policies = policies;
    }


    public RestTemplate UUID(@javax.annotation.Nullable String UUID) {
        this.UUID = UUID;
        return this;
    }

    /**
     * Get UUID
     *
     * @return UUID
     */
    @javax.annotation.Nullable
    public String getUUID() {
        return UUID;
    }

    public void setUUID(@javax.annotation.Nullable String UUID) {
        this.UUID = UUID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestTemplate restTemplate = (RestTemplate) o;
        return Objects.equals(this.editable, restTemplate.editable) &&
                Objects.equals(this.label, restTemplate.label) &&
                Objects.equals(this.node, restTemplate.node) &&
                Objects.equals(this.policies, restTemplate.policies) &&
                Objects.equals(this.UUID, restTemplate.UUID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editable, label, node, policies, UUID);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestTemplate {\n");
        sb.append("    editable: ").append(toIndentedString(editable)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    node: ").append(toIndentedString(node)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    UUID: ").append(toIndentedString(UUID)).append("\n");
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
        openapiFields.add("Editable");
        openapiFields.add("Label");
        openapiFields.add("Node");
        openapiFields.add("Policies");
        openapiFields.add("UUID");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestTemplate
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestTemplate.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestTemplate is not found in the empty JSON string", RestTemplate.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestTemplate.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestTemplate` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
        }
        // validate the optional field `Node`
        if (jsonObj.get("Node") != null && !jsonObj.get("Node").isJsonNull()) {
            RestTemplateNode.validateJsonElement(jsonObj.get("Node"));
        }
        if (jsonObj.get("Policies") != null && !jsonObj.get("Policies").isJsonNull()) {
            JsonArray jsonArraypolicies = jsonObj.getAsJsonArray("Policies");
            if (jsonArraypolicies != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Policies").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Policies` to be an array in the JSON string but got `%s`", jsonObj.get("Policies").toString()));
                }

                // validate the optional field `Policies` (array)
                for (int i = 0; i < jsonArraypolicies.size(); i++) {
                    ServiceResourcePolicy.validateJsonElement(jsonArraypolicies.get(i));
                }
                ;
            }
        }
        if ((jsonObj.get("UUID") != null && !jsonObj.get("UUID").isJsonNull()) && !jsonObj.get("UUID").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `UUID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UUID").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestTemplate.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestTemplate' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestTemplate> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestTemplate.class));

            return (TypeAdapter<T>) new TypeAdapter<RestTemplate>() {
                @Override
                public void write(JsonWriter out, RestTemplate value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestTemplate read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestTemplate given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestTemplate
     * @throws IOException if the JSON string is invalid with respect to RestTemplate
     */
    public static RestTemplate fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestTemplate.class);
    }

    /**
     * Convert an instance of RestTemplate to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

