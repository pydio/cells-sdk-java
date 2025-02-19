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
 * IdmUserMetaNamespace
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class IdmUserMetaNamespace {
    public static final String SERIALIZED_NAME_INDEXABLE = "Indexable";
    @SerializedName(SERIALIZED_NAME_INDEXABLE)
    @javax.annotation.Nullable
    private Boolean indexable;

    public static final String SERIALIZED_NAME_JSON_DEFINITION = "JsonDefinition";
    @SerializedName(SERIALIZED_NAME_JSON_DEFINITION)
    @javax.annotation.Nullable
    private String jsonDefinition;

    public static final String SERIALIZED_NAME_LABEL = "Label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    @javax.annotation.Nullable
    private String label;

    public static final String SERIALIZED_NAME_NAMESPACE = "Namespace";
    @SerializedName(SERIALIZED_NAME_NAMESPACE)
    @javax.annotation.Nullable
    private String namespace;

    public static final String SERIALIZED_NAME_ORDER = "Order";
    @SerializedName(SERIALIZED_NAME_ORDER)
    @javax.annotation.Nullable
    private Integer order;

    public static final String SERIALIZED_NAME_POLICIES = "Policies";
    @SerializedName(SERIALIZED_NAME_POLICIES)
    @javax.annotation.Nullable
    private List<ServiceResourcePolicy> policies = new ArrayList<>();

    public static final String SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE = "PoliciesContextEditable";
    @SerializedName(SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE)
    @javax.annotation.Nullable
    private Boolean policiesContextEditable;

    public IdmUserMetaNamespace() {
    }

    public IdmUserMetaNamespace indexable(@javax.annotation.Nullable Boolean indexable) {
        this.indexable = indexable;
        return this;
    }

    /**
     * Get indexable
     *
     * @return indexable
     */
    @javax.annotation.Nullable
    public Boolean getIndexable() {
        return indexable;
    }

    public void setIndexable(@javax.annotation.Nullable Boolean indexable) {
        this.indexable = indexable;
    }


    public IdmUserMetaNamespace jsonDefinition(@javax.annotation.Nullable String jsonDefinition) {
        this.jsonDefinition = jsonDefinition;
        return this;
    }

    /**
     * Get jsonDefinition
     *
     * @return jsonDefinition
     */
    @javax.annotation.Nullable
    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public void setJsonDefinition(@javax.annotation.Nullable String jsonDefinition) {
        this.jsonDefinition = jsonDefinition;
    }


    public IdmUserMetaNamespace label(@javax.annotation.Nullable String label) {
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


    public IdmUserMetaNamespace namespace(@javax.annotation.Nullable String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get namespace
     *
     * @return namespace
     */
    @javax.annotation.Nullable
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(@javax.annotation.Nullable String namespace) {
        this.namespace = namespace;
    }


    public IdmUserMetaNamespace order(@javax.annotation.Nullable Integer order) {
        this.order = order;
        return this;
    }

    /**
     * Get order
     *
     * @return order
     */
    @javax.annotation.Nullable
    public Integer getOrder() {
        return order;
    }

    public void setOrder(@javax.annotation.Nullable Integer order) {
        this.order = order;
    }


    public IdmUserMetaNamespace policies(@javax.annotation.Nullable List<ServiceResourcePolicy> policies) {
        this.policies = policies;
        return this;
    }

    public IdmUserMetaNamespace addPoliciesItem(ServiceResourcePolicy policiesItem) {
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


    public IdmUserMetaNamespace policiesContextEditable(@javax.annotation.Nullable Boolean policiesContextEditable) {
        this.policiesContextEditable = policiesContextEditable;
        return this;
    }

    /**
     * Get policiesContextEditable
     *
     * @return policiesContextEditable
     */
    @javax.annotation.Nullable
    public Boolean getPoliciesContextEditable() {
        return policiesContextEditable;
    }

    public void setPoliciesContextEditable(@javax.annotation.Nullable Boolean policiesContextEditable) {
        this.policiesContextEditable = policiesContextEditable;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmUserMetaNamespace idmUserMetaNamespace = (IdmUserMetaNamespace) o;
        return Objects.equals(this.indexable, idmUserMetaNamespace.indexable) &&
                Objects.equals(this.jsonDefinition, idmUserMetaNamespace.jsonDefinition) &&
                Objects.equals(this.label, idmUserMetaNamespace.label) &&
                Objects.equals(this.namespace, idmUserMetaNamespace.namespace) &&
                Objects.equals(this.order, idmUserMetaNamespace.order) &&
                Objects.equals(this.policies, idmUserMetaNamespace.policies) &&
                Objects.equals(this.policiesContextEditable, idmUserMetaNamespace.policiesContextEditable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexable, jsonDefinition, label, namespace, order, policies, policiesContextEditable);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmUserMetaNamespace {\n");
        sb.append("    indexable: ").append(toIndentedString(indexable)).append("\n");
        sb.append("    jsonDefinition: ").append(toIndentedString(jsonDefinition)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    policiesContextEditable: ").append(toIndentedString(policiesContextEditable)).append("\n");
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
        openapiFields.add("Indexable");
        openapiFields.add("JsonDefinition");
        openapiFields.add("Label");
        openapiFields.add("Namespace");
        openapiFields.add("Order");
        openapiFields.add("Policies");
        openapiFields.add("PoliciesContextEditable");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to IdmUserMetaNamespace
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!IdmUserMetaNamespace.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in IdmUserMetaNamespace is not found in the empty JSON string", IdmUserMetaNamespace.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!IdmUserMetaNamespace.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmUserMetaNamespace` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("JsonDefinition") != null && !jsonObj.get("JsonDefinition").isJsonNull()) && !jsonObj.get("JsonDefinition").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `JsonDefinition` to be a primitive type in the JSON string but got `%s`", jsonObj.get("JsonDefinition").toString()));
        }
        if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
        }
        if ((jsonObj.get("Namespace") != null && !jsonObj.get("Namespace").isJsonNull()) && !jsonObj.get("Namespace").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Namespace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Namespace").toString()));
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
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IdmUserMetaNamespace.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IdmUserMetaNamespace' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdmUserMetaNamespace> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(IdmUserMetaNamespace.class));

            return (TypeAdapter<T>) new TypeAdapter<IdmUserMetaNamespace>() {
                @Override
                public void write(JsonWriter out, IdmUserMetaNamespace value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public IdmUserMetaNamespace read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of IdmUserMetaNamespace given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IdmUserMetaNamespace
     * @throws IOException if the JSON string is invalid with respect to IdmUserMetaNamespace
     */
    public static IdmUserMetaNamespace fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IdmUserMetaNamespace.class);
    }

    /**
     * Convert an instance of IdmUserMetaNamespace to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

