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
 * TreeReadNodeRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class TreeReadNodeRequest {
    public static final String SERIALIZED_NAME_NODE = "Node";
    @SerializedName(SERIALIZED_NAME_NODE)
    @javax.annotation.Nullable
    private TreeNode node;

    public static final String SERIALIZED_NAME_OBJECT_STATS = "ObjectStats";
    @SerializedName(SERIALIZED_NAME_OBJECT_STATS)
    @javax.annotation.Nullable
    private Boolean objectStats;

    public static final String SERIALIZED_NAME_STAT_FLAGS = "StatFlags";
    @SerializedName(SERIALIZED_NAME_STAT_FLAGS)
    @javax.annotation.Nullable
    private List<Long> statFlags = new ArrayList<>();

    public static final String SERIALIZED_NAME_WITH_COMMITS = "WithCommits";
    @SerializedName(SERIALIZED_NAME_WITH_COMMITS)
    @javax.annotation.Nullable
    private Boolean withCommits;

    public static final String SERIALIZED_NAME_WITH_EXTENDED_STATS = "WithExtendedStats";
    @SerializedName(SERIALIZED_NAME_WITH_EXTENDED_STATS)
    @javax.annotation.Nullable
    private Boolean withExtendedStats;

    public TreeReadNodeRequest() {
    }

    public TreeReadNodeRequest node(@javax.annotation.Nullable TreeNode node) {
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


    public TreeReadNodeRequest objectStats(@javax.annotation.Nullable Boolean objectStats) {
        this.objectStats = objectStats;
        return this;
    }

    /**
     * Get objectStats
     *
     * @return objectStats
     */
    @javax.annotation.Nullable
    public Boolean getObjectStats() {
        return objectStats;
    }

    public void setObjectStats(@javax.annotation.Nullable Boolean objectStats) {
        this.objectStats = objectStats;
    }


    public TreeReadNodeRequest statFlags(@javax.annotation.Nullable List<Long> statFlags) {
        this.statFlags = statFlags;
        return this;
    }

    public TreeReadNodeRequest addStatFlagsItem(Long statFlagsItem) {
        if (this.statFlags == null) {
            this.statFlags = new ArrayList<>();
        }
        this.statFlags.add(statFlagsItem);
        return this;
    }

    /**
     * Get statFlags
     *
     * @return statFlags
     */
    @javax.annotation.Nullable
    public List<Long> getStatFlags() {
        return statFlags;
    }

    public void setStatFlags(@javax.annotation.Nullable List<Long> statFlags) {
        this.statFlags = statFlags;
    }


    public TreeReadNodeRequest withCommits(@javax.annotation.Nullable Boolean withCommits) {
        this.withCommits = withCommits;
        return this;
    }

    /**
     * Get withCommits
     *
     * @return withCommits
     */
    @javax.annotation.Nullable
    public Boolean getWithCommits() {
        return withCommits;
    }

    public void setWithCommits(@javax.annotation.Nullable Boolean withCommits) {
        this.withCommits = withCommits;
    }


    public TreeReadNodeRequest withExtendedStats(@javax.annotation.Nullable Boolean withExtendedStats) {
        this.withExtendedStats = withExtendedStats;
        return this;
    }

    /**
     * Get withExtendedStats
     *
     * @return withExtendedStats
     */
    @javax.annotation.Nullable
    public Boolean getWithExtendedStats() {
        return withExtendedStats;
    }

    public void setWithExtendedStats(@javax.annotation.Nullable Boolean withExtendedStats) {
        this.withExtendedStats = withExtendedStats;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeReadNodeRequest treeReadNodeRequest = (TreeReadNodeRequest) o;
        return Objects.equals(this.node, treeReadNodeRequest.node) &&
                Objects.equals(this.objectStats, treeReadNodeRequest.objectStats) &&
                Objects.equals(this.statFlags, treeReadNodeRequest.statFlags) &&
                Objects.equals(this.withCommits, treeReadNodeRequest.withCommits) &&
                Objects.equals(this.withExtendedStats, treeReadNodeRequest.withExtendedStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, objectStats, statFlags, withCommits, withExtendedStats);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TreeReadNodeRequest {\n");
        sb.append("    node: ").append(toIndentedString(node)).append("\n");
        sb.append("    objectStats: ").append(toIndentedString(objectStats)).append("\n");
        sb.append("    statFlags: ").append(toIndentedString(statFlags)).append("\n");
        sb.append("    withCommits: ").append(toIndentedString(withCommits)).append("\n");
        sb.append("    withExtendedStats: ").append(toIndentedString(withExtendedStats)).append("\n");
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
        openapiFields.add("ObjectStats");
        openapiFields.add("StatFlags");
        openapiFields.add("WithCommits");
        openapiFields.add("WithExtendedStats");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to TreeReadNodeRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!TreeReadNodeRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in TreeReadNodeRequest is not found in the empty JSON string", TreeReadNodeRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!TreeReadNodeRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeReadNodeRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `Node`
        if (jsonObj.get("Node") != null && !jsonObj.get("Node").isJsonNull()) {
            TreeNode.validateJsonElement(jsonObj.get("Node"));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("StatFlags") != null && !jsonObj.get("StatFlags").isJsonNull() && !jsonObj.get("StatFlags").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `StatFlags` to be an array in the JSON string but got `%s`", jsonObj.get("StatFlags").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TreeReadNodeRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TreeReadNodeRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<TreeReadNodeRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(TreeReadNodeRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<TreeReadNodeRequest>() {
                @Override
                public void write(JsonWriter out, TreeReadNodeRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public TreeReadNodeRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of TreeReadNodeRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TreeReadNodeRequest
     * @throws IOException if the JSON string is invalid with respect to TreeReadNodeRequest
     */
    public static TreeReadNodeRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, TreeReadNodeRequest.class);
    }

    /**
     * Convert an instance of TreeReadNodeRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

