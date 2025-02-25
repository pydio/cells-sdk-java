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
 * TreeQuery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class TreeQuery {
    public static final String SERIALIZED_NAME_CONTENT = "Content";
    @SerializedName(SERIALIZED_NAME_CONTENT)
    @javax.annotation.Nullable
    private String content;

    public static final String SERIALIZED_NAME_DURATION_DATE = "DurationDate";
    @SerializedName(SERIALIZED_NAME_DURATION_DATE)
    @javax.annotation.Nullable
    private String durationDate;

    public static final String SERIALIZED_NAME_ETAG = "ETag";
    @SerializedName(SERIALIZED_NAME_ETAG)
    @javax.annotation.Nullable
    private String etag;

    public static final String SERIALIZED_NAME_EXTENSION = "Extension";
    @SerializedName(SERIALIZED_NAME_EXTENSION)
    @javax.annotation.Nullable
    private String extension;

    public static final String SERIALIZED_NAME_FILE_NAME = "FileName";
    @SerializedName(SERIALIZED_NAME_FILE_NAME)
    @javax.annotation.Nullable
    private String fileName;

    public static final String SERIALIZED_NAME_FILE_NAME_OR_CONTENT = "FileNameOrContent";
    @SerializedName(SERIALIZED_NAME_FILE_NAME_OR_CONTENT)
    @javax.annotation.Nullable
    private String fileNameOrContent;

    public static final String SERIALIZED_NAME_FREE_STRING = "FreeString";
    @SerializedName(SERIALIZED_NAME_FREE_STRING)
    @javax.annotation.Nullable
    private String freeString;

    public static final String SERIALIZED_NAME_GEO_QUERY = "GeoQuery";
    @SerializedName(SERIALIZED_NAME_GEO_QUERY)
    @javax.annotation.Nullable
    private TreeGeoQuery geoQuery;

    public static final String SERIALIZED_NAME_MAX_DATE = "MaxDate";
    @SerializedName(SERIALIZED_NAME_MAX_DATE)
    @javax.annotation.Nullable
    private String maxDate;

    public static final String SERIALIZED_NAME_MAX_SIZE = "MaxSize";
    @SerializedName(SERIALIZED_NAME_MAX_SIZE)
    @javax.annotation.Nullable
    private String maxSize;

    public static final String SERIALIZED_NAME_MIN_DATE = "MinDate";
    @SerializedName(SERIALIZED_NAME_MIN_DATE)
    @javax.annotation.Nullable
    private String minDate;

    public static final String SERIALIZED_NAME_MIN_SIZE = "MinSize";
    @SerializedName(SERIALIZED_NAME_MIN_SIZE)
    @javax.annotation.Nullable
    private String minSize;

    public static final String SERIALIZED_NAME_NOT = "Not";
    @SerializedName(SERIALIZED_NAME_NOT)
    @javax.annotation.Nullable
    private Boolean not;

    public static final String SERIALIZED_NAME_PATH_DEPTH = "PathDepth";
    @SerializedName(SERIALIZED_NAME_PATH_DEPTH)
    @javax.annotation.Nullable
    private Integer pathDepth;

    public static final String SERIALIZED_NAME_PATH_PREFIX = "PathPrefix";
    @SerializedName(SERIALIZED_NAME_PATH_PREFIX)
    @javax.annotation.Nullable
    private List<String> pathPrefix = new ArrayList<>();

    public static final String SERIALIZED_NAME_PATHS = "Paths";
    @SerializedName(SERIALIZED_NAME_PATHS)
    @javax.annotation.Nullable
    private List<String> paths = new ArrayList<>();

    public static final String SERIALIZED_NAME_TYPE = "Type";
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nullable
    private TreeNodeType type = TreeNodeType.UNKNOWN;

    public static final String SERIALIZED_NAME_UU_I_DS = "UUIDs";
    @SerializedName(SERIALIZED_NAME_UU_I_DS)
    @javax.annotation.Nullable
    private List<String> uuIDs = new ArrayList<>();

    public TreeQuery() {
    }

    public TreeQuery content(@javax.annotation.Nullable String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     */
    @javax.annotation.Nullable
    public String getContent() {
        return content;
    }

    public void setContent(@javax.annotation.Nullable String content) {
        this.content = content;
    }


    public TreeQuery durationDate(@javax.annotation.Nullable String durationDate) {
        this.durationDate = durationDate;
        return this;
    }

    /**
     * Get durationDate
     *
     * @return durationDate
     */
    @javax.annotation.Nullable
    public String getDurationDate() {
        return durationDate;
    }

    public void setDurationDate(@javax.annotation.Nullable String durationDate) {
        this.durationDate = durationDate;
    }


    public TreeQuery etag(@javax.annotation.Nullable String etag) {
        this.etag = etag;
        return this;
    }

    /**
     * Get etag
     *
     * @return etag
     */
    @javax.annotation.Nullable
    public String getEtag() {
        return etag;
    }

    public void setEtag(@javax.annotation.Nullable String etag) {
        this.etag = etag;
    }


    public TreeQuery extension(@javax.annotation.Nullable String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * Get extension
     *
     * @return extension
     */
    @javax.annotation.Nullable
    public String getExtension() {
        return extension;
    }

    public void setExtension(@javax.annotation.Nullable String extension) {
        this.extension = extension;
    }


    public TreeQuery fileName(@javax.annotation.Nullable String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Get fileName
     *
     * @return fileName
     */
    @javax.annotation.Nullable
    public String getFileName() {
        return fileName;
    }

    public void setFileName(@javax.annotation.Nullable String fileName) {
        this.fileName = fileName;
    }


    public TreeQuery fileNameOrContent(@javax.annotation.Nullable String fileNameOrContent) {
        this.fileNameOrContent = fileNameOrContent;
        return this;
    }

    /**
     * Get fileNameOrContent
     *
     * @return fileNameOrContent
     */
    @javax.annotation.Nullable
    public String getFileNameOrContent() {
        return fileNameOrContent;
    }

    public void setFileNameOrContent(@javax.annotation.Nullable String fileNameOrContent) {
        this.fileNameOrContent = fileNameOrContent;
    }


    public TreeQuery freeString(@javax.annotation.Nullable String freeString) {
        this.freeString = freeString;
        return this;
    }

    /**
     * Bleve-like search query to search for a specific metadata value. When querying nodes, this will redirect this query to the Search Engine. When filtering an input, this will load an in-memory bleve engine to evaluate the node.  Bleve query string format is a space separated list of &#x60;[+-]key:value&#x60;, where node meta keys must be prepended with \&quot;Meta.\&quot; For Example, for tags: &#x60;+Meta.usermeta-tags:myvalue&#x60;
     *
     * @return freeString
     */
    @javax.annotation.Nullable
    public String getFreeString() {
        return freeString;
    }

    public void setFreeString(@javax.annotation.Nullable String freeString) {
        this.freeString = freeString;
    }


    public TreeQuery geoQuery(@javax.annotation.Nullable TreeGeoQuery geoQuery) {
        this.geoQuery = geoQuery;
        return this;
    }

    /**
     * Get geoQuery
     *
     * @return geoQuery
     */
    @javax.annotation.Nullable
    public TreeGeoQuery getGeoQuery() {
        return geoQuery;
    }

    public void setGeoQuery(@javax.annotation.Nullable TreeGeoQuery geoQuery) {
        this.geoQuery = geoQuery;
    }


    public TreeQuery maxDate(@javax.annotation.Nullable String maxDate) {
        this.maxDate = maxDate;
        return this;
    }

    /**
     * Get maxDate
     *
     * @return maxDate
     */
    @javax.annotation.Nullable
    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(@javax.annotation.Nullable String maxDate) {
        this.maxDate = maxDate;
    }


    public TreeQuery maxSize(@javax.annotation.Nullable String maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    /**
     * Get maxSize
     *
     * @return maxSize
     */
    @javax.annotation.Nullable
    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(@javax.annotation.Nullable String maxSize) {
        this.maxSize = maxSize;
    }


    public TreeQuery minDate(@javax.annotation.Nullable String minDate) {
        this.minDate = minDate;
        return this;
    }

    /**
     * Get minDate
     *
     * @return minDate
     */
    @javax.annotation.Nullable
    public String getMinDate() {
        return minDate;
    }

    public void setMinDate(@javax.annotation.Nullable String minDate) {
        this.minDate = minDate;
    }


    public TreeQuery minSize(@javax.annotation.Nullable String minSize) {
        this.minSize = minSize;
        return this;
    }

    /**
     * Get minSize
     *
     * @return minSize
     */
    @javax.annotation.Nullable
    public String getMinSize() {
        return minSize;
    }

    public void setMinSize(@javax.annotation.Nullable String minSize) {
        this.minSize = minSize;
    }


    public TreeQuery not(@javax.annotation.Nullable Boolean not) {
        this.not = not;
        return this;
    }

    /**
     * Get not
     *
     * @return not
     */
    @javax.annotation.Nullable
    public Boolean getNot() {
        return not;
    }

    public void setNot(@javax.annotation.Nullable Boolean not) {
        this.not = not;
    }


    public TreeQuery pathDepth(@javax.annotation.Nullable Integer pathDepth) {
        this.pathDepth = pathDepth;
        return this;
    }

    /**
     * Get pathDepth
     *
     * @return pathDepth
     */
    @javax.annotation.Nullable
    public Integer getPathDepth() {
        return pathDepth;
    }

    public void setPathDepth(@javax.annotation.Nullable Integer pathDepth) {
        this.pathDepth = pathDepth;
    }


    public TreeQuery pathPrefix(@javax.annotation.Nullable List<String> pathPrefix) {
        this.pathPrefix = pathPrefix;
        return this;
    }

    public TreeQuery addPathPrefixItem(String pathPrefixItem) {
        if (this.pathPrefix == null) {
            this.pathPrefix = new ArrayList<>();
        }
        this.pathPrefix.add(pathPrefixItem);
        return this;
    }

    /**
     * Get pathPrefix
     *
     * @return pathPrefix
     */
    @javax.annotation.Nullable
    public List<String> getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(@javax.annotation.Nullable List<String> pathPrefix) {
        this.pathPrefix = pathPrefix;
    }


    public TreeQuery paths(@javax.annotation.Nullable List<String> paths) {
        this.paths = paths;
        return this;
    }

    public TreeQuery addPathsItem(String pathsItem) {
        if (this.paths == null) {
            this.paths = new ArrayList<>();
        }
        this.paths.add(pathsItem);
        return this;
    }

    /**
     * Get paths
     *
     * @return paths
     */
    @javax.annotation.Nullable
    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(@javax.annotation.Nullable List<String> paths) {
        this.paths = paths;
    }


    public TreeQuery type(@javax.annotation.Nullable TreeNodeType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     */
    @javax.annotation.Nullable
    public TreeNodeType getType() {
        return type;
    }

    public void setType(@javax.annotation.Nullable TreeNodeType type) {
        this.type = type;
    }


    public TreeQuery uuIDs(@javax.annotation.Nullable List<String> uuIDs) {
        this.uuIDs = uuIDs;
        return this;
    }

    public TreeQuery addUuIDsItem(String uuIDsItem) {
        if (this.uuIDs == null) {
            this.uuIDs = new ArrayList<>();
        }
        this.uuIDs.add(uuIDsItem);
        return this;
    }

    /**
     * Get uuIDs
     *
     * @return uuIDs
     */
    @javax.annotation.Nullable
    public List<String> getUuIDs() {
        return uuIDs;
    }

    public void setUuIDs(@javax.annotation.Nullable List<String> uuIDs) {
        this.uuIDs = uuIDs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeQuery treeQuery = (TreeQuery) o;
        return Objects.equals(this.content, treeQuery.content) &&
                Objects.equals(this.durationDate, treeQuery.durationDate) &&
                Objects.equals(this.etag, treeQuery.etag) &&
                Objects.equals(this.extension, treeQuery.extension) &&
                Objects.equals(this.fileName, treeQuery.fileName) &&
                Objects.equals(this.fileNameOrContent, treeQuery.fileNameOrContent) &&
                Objects.equals(this.freeString, treeQuery.freeString) &&
                Objects.equals(this.geoQuery, treeQuery.geoQuery) &&
                Objects.equals(this.maxDate, treeQuery.maxDate) &&
                Objects.equals(this.maxSize, treeQuery.maxSize) &&
                Objects.equals(this.minDate, treeQuery.minDate) &&
                Objects.equals(this.minSize, treeQuery.minSize) &&
                Objects.equals(this.not, treeQuery.not) &&
                Objects.equals(this.pathDepth, treeQuery.pathDepth) &&
                Objects.equals(this.pathPrefix, treeQuery.pathPrefix) &&
                Objects.equals(this.paths, treeQuery.paths) &&
                Objects.equals(this.type, treeQuery.type) &&
                Objects.equals(this.uuIDs, treeQuery.uuIDs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, durationDate, etag, extension, fileName, fileNameOrContent, freeString, geoQuery, maxDate, maxSize, minDate, minSize, not, pathDepth, pathPrefix, paths, type, uuIDs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TreeQuery {\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    durationDate: ").append(toIndentedString(durationDate)).append("\n");
        sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
        sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    fileNameOrContent: ").append(toIndentedString(fileNameOrContent)).append("\n");
        sb.append("    freeString: ").append(toIndentedString(freeString)).append("\n");
        sb.append("    geoQuery: ").append(toIndentedString(geoQuery)).append("\n");
        sb.append("    maxDate: ").append(toIndentedString(maxDate)).append("\n");
        sb.append("    maxSize: ").append(toIndentedString(maxSize)).append("\n");
        sb.append("    minDate: ").append(toIndentedString(minDate)).append("\n");
        sb.append("    minSize: ").append(toIndentedString(minSize)).append("\n");
        sb.append("    not: ").append(toIndentedString(not)).append("\n");
        sb.append("    pathDepth: ").append(toIndentedString(pathDepth)).append("\n");
        sb.append("    pathPrefix: ").append(toIndentedString(pathPrefix)).append("\n");
        sb.append("    paths: ").append(toIndentedString(paths)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    uuIDs: ").append(toIndentedString(uuIDs)).append("\n");
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
        openapiFields.add("Content");
        openapiFields.add("DurationDate");
        openapiFields.add("ETag");
        openapiFields.add("Extension");
        openapiFields.add("FileName");
        openapiFields.add("FileNameOrContent");
        openapiFields.add("FreeString");
        openapiFields.add("GeoQuery");
        openapiFields.add("MaxDate");
        openapiFields.add("MaxSize");
        openapiFields.add("MinDate");
        openapiFields.add("MinSize");
        openapiFields.add("Not");
        openapiFields.add("PathDepth");
        openapiFields.add("PathPrefix");
        openapiFields.add("Paths");
        openapiFields.add("Type");
        openapiFields.add("UUIDs");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to TreeQuery
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!TreeQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in TreeQuery is not found in the empty JSON string", TreeQuery.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!TreeQuery.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeQuery` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("Content") != null && !jsonObj.get("Content").isJsonNull()) && !jsonObj.get("Content").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Content` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Content").toString()));
        }
        if ((jsonObj.get("DurationDate") != null && !jsonObj.get("DurationDate").isJsonNull()) && !jsonObj.get("DurationDate").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `DurationDate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DurationDate").toString()));
        }
        if ((jsonObj.get("ETag") != null && !jsonObj.get("ETag").isJsonNull()) && !jsonObj.get("ETag").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `ETag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ETag").toString()));
        }
        if ((jsonObj.get("Extension") != null && !jsonObj.get("Extension").isJsonNull()) && !jsonObj.get("Extension").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Extension` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Extension").toString()));
        }
        if ((jsonObj.get("FileName") != null && !jsonObj.get("FileName").isJsonNull()) && !jsonObj.get("FileName").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `FileName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FileName").toString()));
        }
        if ((jsonObj.get("FileNameOrContent") != null && !jsonObj.get("FileNameOrContent").isJsonNull()) && !jsonObj.get("FileNameOrContent").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `FileNameOrContent` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FileNameOrContent").toString()));
        }
        if ((jsonObj.get("FreeString") != null && !jsonObj.get("FreeString").isJsonNull()) && !jsonObj.get("FreeString").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `FreeString` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FreeString").toString()));
        }
        // validate the optional field `GeoQuery`
        if (jsonObj.get("GeoQuery") != null && !jsonObj.get("GeoQuery").isJsonNull()) {
            TreeGeoQuery.validateJsonElement(jsonObj.get("GeoQuery"));
        }
        if ((jsonObj.get("MaxDate") != null && !jsonObj.get("MaxDate").isJsonNull()) && !jsonObj.get("MaxDate").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `MaxDate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MaxDate").toString()));
        }
        if ((jsonObj.get("MaxSize") != null && !jsonObj.get("MaxSize").isJsonNull()) && !jsonObj.get("MaxSize").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `MaxSize` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MaxSize").toString()));
        }
        if ((jsonObj.get("MinDate") != null && !jsonObj.get("MinDate").isJsonNull()) && !jsonObj.get("MinDate").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `MinDate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MinDate").toString()));
        }
        if ((jsonObj.get("MinSize") != null && !jsonObj.get("MinSize").isJsonNull()) && !jsonObj.get("MinSize").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `MinSize` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MinSize").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("PathPrefix") != null && !jsonObj.get("PathPrefix").isJsonNull() && !jsonObj.get("PathPrefix").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `PathPrefix` to be an array in the JSON string but got `%s`", jsonObj.get("PathPrefix").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("Paths") != null && !jsonObj.get("Paths").isJsonNull() && !jsonObj.get("Paths").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Paths` to be an array in the JSON string but got `%s`", jsonObj.get("Paths").toString()));
        }
        // validate the optional field `Type`
        if (jsonObj.get("Type") != null && !jsonObj.get("Type").isJsonNull()) {
            TreeNodeType.validateJsonElement(jsonObj.get("Type"));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("UUIDs") != null && !jsonObj.get("UUIDs").isJsonNull() && !jsonObj.get("UUIDs").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `UUIDs` to be an array in the JSON string but got `%s`", jsonObj.get("UUIDs").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!TreeQuery.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'TreeQuery' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<TreeQuery> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(TreeQuery.class));

            return (TypeAdapter<T>) new TypeAdapter<TreeQuery>() {
                @Override
                public void write(JsonWriter out, TreeQuery value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public TreeQuery read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of TreeQuery given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of TreeQuery
     * @throws IOException if the JSON string is invalid with respect to TreeQuery
     */
    public static TreeQuery fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, TreeQuery.class);
    }

    /**
     * Convert an instance of TreeQuery to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

