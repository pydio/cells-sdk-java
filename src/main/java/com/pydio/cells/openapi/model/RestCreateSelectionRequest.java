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
import com.pydio.cells.openapi.model.TreeNode;

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
 * RestCreateSelectionRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestCreateSelectionRequest {
    public static final String SERIALIZED_NAME_NODES = "Nodes";
    @SerializedName(SERIALIZED_NAME_NODES)
    @javax.annotation.Nullable
    private List<TreeNode> nodes = new ArrayList<>();

    public static final String SERIALIZED_NAME_PERSIST = "Persist";
    @SerializedName(SERIALIZED_NAME_PERSIST)
    @javax.annotation.Nullable
    private Boolean persist;

    public static final String SERIALIZED_NAME_TARGET_ACTION = "TargetAction";
    @SerializedName(SERIALIZED_NAME_TARGET_ACTION)
    @javax.annotation.Nullable
    private String targetAction;

    public RestCreateSelectionRequest() {
    }

    public RestCreateSelectionRequest nodes(@javax.annotation.Nullable List<TreeNode> nodes) {
        this.nodes = nodes;
        return this;
    }

    public RestCreateSelectionRequest addNodesItem(TreeNode nodesItem) {
        if (this.nodes == null) {
            this.nodes = new ArrayList<>();
        }
        this.nodes.add(nodesItem);
        return this;
    }

    /**
     * Get nodes
     *
     * @return nodes
     */
    @javax.annotation.Nullable
    public List<TreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(@javax.annotation.Nullable List<TreeNode> nodes) {
        this.nodes = nodes;
    }


    public RestCreateSelectionRequest persist(@javax.annotation.Nullable Boolean persist) {
        this.persist = persist;
        return this;
    }

    /**
     * Get persist
     *
     * @return persist
     */
    @javax.annotation.Nullable
    public Boolean getPersist() {
        return persist;
    }

    public void setPersist(@javax.annotation.Nullable Boolean persist) {
        this.persist = persist;
    }


    public RestCreateSelectionRequest targetAction(@javax.annotation.Nullable String targetAction) {
        this.targetAction = targetAction;
        return this;
    }

    /**
     * Get targetAction
     *
     * @return targetAction
     */
    @javax.annotation.Nullable
    public String getTargetAction() {
        return targetAction;
    }

    public void setTargetAction(@javax.annotation.Nullable String targetAction) {
        this.targetAction = targetAction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestCreateSelectionRequest restCreateSelectionRequest = (RestCreateSelectionRequest) o;
        return Objects.equals(this.nodes, restCreateSelectionRequest.nodes) &&
                Objects.equals(this.persist, restCreateSelectionRequest.persist) &&
                Objects.equals(this.targetAction, restCreateSelectionRequest.targetAction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, persist, targetAction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCreateSelectionRequest {\n");
        sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
        sb.append("    persist: ").append(toIndentedString(persist)).append("\n");
        sb.append("    targetAction: ").append(toIndentedString(targetAction)).append("\n");
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
        openapiFields.add("Nodes");
        openapiFields.add("Persist");
        openapiFields.add("TargetAction");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestCreateSelectionRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestCreateSelectionRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestCreateSelectionRequest is not found in the empty JSON string", RestCreateSelectionRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestCreateSelectionRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestCreateSelectionRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("Nodes") != null && !jsonObj.get("Nodes").isJsonNull()) {
            JsonArray jsonArraynodes = jsonObj.getAsJsonArray("Nodes");
            if (jsonArraynodes != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Nodes").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Nodes` to be an array in the JSON string but got `%s`", jsonObj.get("Nodes").toString()));
                }

                // validate the optional field `Nodes` (array)
                for (int i = 0; i < jsonArraynodes.size(); i++) {
                    TreeNode.validateJsonElement(jsonArraynodes.get(i));
                }
                ;
            }
        }
        if ((jsonObj.get("TargetAction") != null && !jsonObj.get("TargetAction").isJsonNull()) && !jsonObj.get("TargetAction").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `TargetAction` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TargetAction").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestCreateSelectionRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestCreateSelectionRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestCreateSelectionRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestCreateSelectionRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<RestCreateSelectionRequest>() {
                @Override
                public void write(JsonWriter out, RestCreateSelectionRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestCreateSelectionRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestCreateSelectionRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestCreateSelectionRequest
     * @throws IOException if the JSON string is invalid with respect to RestCreateSelectionRequest
     */
    public static RestCreateSelectionRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestCreateSelectionRequest.class);
    }

    /**
     * Convert an instance of RestCreateSelectionRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

