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
 * TreeGeoQuery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class TreeGeoQuery {
    public static final String SERIALIZED_NAME_BOTTOM_RIGHT = "BottomRight";
    @SerializedName(SERIALIZED_NAME_BOTTOM_RIGHT)
    @javax.annotation.Nullable
    private TreeGeoPoint bottomRight;

    public static final String SERIALIZED_NAME_CENTER = "Center";
    @SerializedName(SERIALIZED_NAME_CENTER)
    @javax.annotation.Nullable
    private TreeGeoPoint center;

    public static final String SERIALIZED_NAME_DISTANCE = "Distance";
    @SerializedName(SERIALIZED_NAME_DISTANCE)
    @javax.annotation.Nullable
    private String distance;

    public static final String SERIALIZED_NAME_TOP_LEFT = "TopLeft";
    @SerializedName(SERIALIZED_NAME_TOP_LEFT)
    @javax.annotation.Nullable
    private TreeGeoPoint topLeft;

    public TreeGeoQuery() {
    }

    public TreeGeoQuery bottomRight(@javax.annotation.Nullable TreeGeoPoint bottomRight) {
        this.bottomRight = bottomRight;
        return this;
    }

    /**
     * Get bottomRight
     *
     * @return bottomRight
     */
    @javax.annotation.Nullable
    public TreeGeoPoint getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(@javax.annotation.Nullable TreeGeoPoint bottomRight) {
        this.bottomRight = bottomRight;
    }


    public TreeGeoQuery center(@javax.annotation.Nullable TreeGeoPoint center) {
        this.center = center;
        return this;
    }

    /**
     * Get center
     *
     * @return center
     */
    @javax.annotation.Nullable
    public TreeGeoPoint getCenter() {
        return center;
    }

    public void setCenter(@javax.annotation.Nullable TreeGeoPoint center) {
        this.center = center;
    }


    public TreeGeoQuery distance(@javax.annotation.Nullable String distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Example formats supported: \&quot;5in\&quot; \&quot;5inch\&quot; \&quot;7yd\&quot; \&quot;7yards\&quot; \&quot;9ft\&quot; \&quot;9feet\&quot; \&quot;11km\&quot; \&quot;11kilometers\&quot; \&quot;3nm\&quot; \&quot;3nauticalmiles\&quot; \&quot;13mm\&quot; \&quot;13millimeters\&quot; \&quot;15cm\&quot; \&quot;15centimeters\&quot; \&quot;17mi\&quot; \&quot;17miles\&quot; \&quot;19m\&quot; \&quot;19meters\&quot; If the unit cannot be determined, the entire string is parsed and the unit of meters is assumed.
     *
     * @return distance
     */
    @javax.annotation.Nullable
    public String getDistance() {
        return distance;
    }

    public void setDistance(@javax.annotation.Nullable String distance) {
        this.distance = distance;
    }


    public TreeGeoQuery topLeft(@javax.annotation.Nullable TreeGeoPoint topLeft) {
        this.topLeft = topLeft;
        return this;
    }

    /**
     * Get topLeft
     *
     * @return topLeft
     */
    @javax.annotation.Nullable
    public TreeGeoPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(@javax.annotation.Nullable TreeGeoPoint topLeft) {
        this.topLeft = topLeft;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeGeoQuery treeGeoQuery = (TreeGeoQuery) o;
        return Objects.equals(this.bottomRight, treeGeoQuery.bottomRight) &&
                Objects.equals(this.center, treeGeoQuery.center) &&
                Objects.equals(this.distance, treeGeoQuery.distance) &&
                Objects.equals(this.topLeft, treeGeoQuery.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bottomRight, center, distance, topLeft);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TreeGeoQuery {\n");
        sb.append("    bottomRight: ").append(toIndentedString(bottomRight)).append("\n");
        sb.append("    center: ").append(toIndentedString(center)).append("\n");
        sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
        sb.append("    topLeft: ").append(toIndentedString(topLeft)).append("\n");
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
        openapiFields.add("BottomRight");
        openapiFields.add("Center");
        openapiFields.add("Distance");
        openapiFields.add("TopLeft");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to TreeGeoQuery
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!TreeGeoQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in TreeGeoQuery is not found in the empty JSON string", TreeGeoQuery.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!TreeGeoQuery.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeGeoQuery` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `BottomRight`
        if (jsonObj.get("BottomRight") != null && !jsonObj.get("BottomRight").isJsonNull()) {
            TreeGeoPoint.validateJsonElement(jsonObj.get("BottomRight"));
        }
        // validate the optional field `Center`
        if (jsonObj.get("Center") != null && !jsonObj.get("Center").isJsonNull()) {
            TreeGeoPoint.validateJsonElement(jsonObj.get("Center"));
        }
        if ((jsonObj.get("Distance") != null && !jsonObj.get("Distance").isJsonNull()) && !jsonObj.get("Distance").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Distance` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Distance").toString()));
        }
        // validate the optional field `TopLeft`
        if (jsonObj.get("TopLeft") != null && !jsonObj.get("TopLeft").isJsonNull()) {
            TreeGeoPoint.validateJsonElement(jsonObj.get("TopLeft"));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TreeGeoQuery.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TreeGeoQuery' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<TreeGeoQuery> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(TreeGeoQuery.class));

            return (TypeAdapter<T>) new TypeAdapter<TreeGeoQuery>() {
                @Override
                public void write(JsonWriter out, TreeGeoQuery value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public TreeGeoQuery read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of TreeGeoQuery given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TreeGeoQuery
     * @throws IOException if the JSON string is invalid with respect to TreeGeoQuery
     */
    public static TreeGeoQuery fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, TreeGeoQuery.class);
    }

    /**
     * Convert an instance of TreeGeoQuery to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

