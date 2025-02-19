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
 * TreeReadNodeResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class TreeReadNodeResponse {
    public static final String SERIALIZED_NAME_NODE = "Node";
    @SerializedName(SERIALIZED_NAME_NODE)
    @javax.annotation.Nullable
    private TreeNode node;

    public static final String SERIALIZED_NAME_SUCCESS = "Success";
    @SerializedName(SERIALIZED_NAME_SUCCESS)
    @javax.annotation.Nullable
    private Boolean success;

    public TreeReadNodeResponse() {
    }

    public TreeReadNodeResponse node(@javax.annotation.Nullable TreeNode node) {
        this.node = node;
        return this;
    }

    /**
     * Get node
     *
     * @return node
     */
    @javax.annotation.Nullable
    public TreeNode getNode() {
        return node;
    }

    public void setNode(@javax.annotation.Nullable TreeNode node) {
        this.node = node;
    }


    public TreeReadNodeResponse success(@javax.annotation.Nullable Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * Get success
     *
     * @return success
     */
    @javax.annotation.Nullable
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(@javax.annotation.Nullable Boolean success) {
        this.success = success;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeReadNodeResponse treeReadNodeResponse = (TreeReadNodeResponse) o;
        return Objects.equals(this.node, treeReadNodeResponse.node) &&
                Objects.equals(this.success, treeReadNodeResponse.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, success);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TreeReadNodeResponse {\n");
        sb.append("    node: ").append(toIndentedString(node)).append("\n");
        sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
        openapiFields.add("Node");
        openapiFields.add("Success");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to TreeReadNodeResponse
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!TreeReadNodeResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in TreeReadNodeResponse is not found in the empty JSON string", TreeReadNodeResponse.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!TreeReadNodeResponse.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeReadNodeResponse` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `Node`
        if (jsonObj.get("Node") != null && !jsonObj.get("Node").isJsonNull()) {
            TreeNode.validateJsonElement(jsonObj.get("Node"));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TreeReadNodeResponse.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TreeReadNodeResponse' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<TreeReadNodeResponse> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(TreeReadNodeResponse.class));

            return (TypeAdapter<T>) new TypeAdapter<TreeReadNodeResponse>() {
                @Override
                public void write(JsonWriter out, TreeReadNodeResponse value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public TreeReadNodeResponse read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of TreeReadNodeResponse given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TreeReadNodeResponse
     * @throws IOException if the JSON string is invalid with respect to TreeReadNodeResponse
     */
    public static TreeReadNodeResponse fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, TreeReadNodeResponse.class);
    }

    /**
     * Convert an instance of TreeReadNodeResponse to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

