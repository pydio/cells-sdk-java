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
 * RestNodesCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestNodesCollection {
    public static final String SERIALIZED_NAME_CHILDREN = "Children";
    @SerializedName(SERIALIZED_NAME_CHILDREN)
    @javax.annotation.Nullable
    private List<TreeNode> children = new ArrayList<>();

    public static final String SERIALIZED_NAME_PARENT = "Parent";
    @SerializedName(SERIALIZED_NAME_PARENT)
    @javax.annotation.Nullable
    private TreeNode parent;

    public RestNodesCollection() {
    }

    public RestNodesCollection children(@javax.annotation.Nullable List<TreeNode> children) {
        this.children = children;
        return this;
    }

    public RestNodesCollection addChildrenItem(TreeNode childrenItem) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(childrenItem);
        return this;
    }

    /**
     * Get children
     *
     * @return children
     */
    @javax.annotation.Nullable
    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(@javax.annotation.Nullable List<TreeNode> children) {
        this.children = children;
    }


    public RestNodesCollection parent(@javax.annotation.Nullable TreeNode parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Get parent
     *
     * @return parent
     */
    @javax.annotation.Nullable
    public TreeNode getParent() {
        return parent;
    }

    public void setParent(@javax.annotation.Nullable TreeNode parent) {
        this.parent = parent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestNodesCollection restNodesCollection = (RestNodesCollection) o;
        return Objects.equals(this.children, restNodesCollection.children) &&
                Objects.equals(this.parent, restNodesCollection.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestNodesCollection {\n");
        sb.append("    children: ").append(toIndentedString(children)).append("\n");
        sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
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
        openapiFields.add("Children");
        openapiFields.add("Parent");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestNodesCollection
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestNodesCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestNodesCollection is not found in the empty JSON string", RestNodesCollection.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestNodesCollection.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestNodesCollection` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("Children") != null && !jsonObj.get("Children").isJsonNull()) {
            JsonArray jsonArraychildren = jsonObj.getAsJsonArray("Children");
            if (jsonArraychildren != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Children").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Children` to be an array in the JSON string but got `%s`", jsonObj.get("Children").toString()));
                }

                // validate the optional field `Children` (array)
                for (int i = 0; i < jsonArraychildren.size(); i++) {
                    TreeNode.validateJsonElement(jsonArraychildren.get(i));
                }
                ;
            }
        }
        // validate the optional field `Parent`
        if (jsonObj.get("Parent") != null && !jsonObj.get("Parent").isJsonNull()) {
            TreeNode.validateJsonElement(jsonObj.get("Parent"));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestNodesCollection.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestNodesCollection' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestNodesCollection> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestNodesCollection.class));

            return (TypeAdapter<T>) new TypeAdapter<RestNodesCollection>() {
                @Override
                public void write(JsonWriter out, RestNodesCollection value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestNodesCollection read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestNodesCollection given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestNodesCollection
     * @throws IOException if the JSON string is invalid with respect to RestNodesCollection
     */
    public static RestNodesCollection fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestNodesCollection.class);
    }

    /**
     * Convert an instance of RestNodesCollection to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

