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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * TreeVersioningPolicy
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class TreeVersioningPolicy {
  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_IGNORE_FILES_GREATER_THAN = "IgnoreFilesGreaterThan";
  @SerializedName(SERIALIZED_NAME_IGNORE_FILES_GREATER_THAN)
  private String ignoreFilesGreaterThan;

  public static final String SERIALIZED_NAME_KEEP_PERIODS = "KeepPeriods";
  @SerializedName(SERIALIZED_NAME_KEEP_PERIODS)
  private List<TreeVersioningKeepPeriod> keepPeriods;

  public static final String SERIALIZED_NAME_MAX_SIZE_PER_FILE = "MaxSizePerFile";
  @SerializedName(SERIALIZED_NAME_MAX_SIZE_PER_FILE)
  private String maxSizePerFile;

  public static final String SERIALIZED_NAME_MAX_TOTAL_SIZE = "MaxTotalSize";
  @SerializedName(SERIALIZED_NAME_MAX_TOTAL_SIZE)
  private String maxTotalSize;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_NODE_DELETED_STRATEGY = "NodeDeletedStrategy";
  @SerializedName(SERIALIZED_NAME_NODE_DELETED_STRATEGY)
  private TreeVersioningNodeDeletedStrategy nodeDeletedStrategy = TreeVersioningNodeDeletedStrategy.KEEPALL;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_VERSIONS_DATA_SOURCE_BUCKET = "VersionsDataSourceBucket";
  @SerializedName(SERIALIZED_NAME_VERSIONS_DATA_SOURCE_BUCKET)
  private String versionsDataSourceBucket;

  public static final String SERIALIZED_NAME_VERSIONS_DATA_SOURCE_NAME = "VersionsDataSourceName";
  @SerializedName(SERIALIZED_NAME_VERSIONS_DATA_SOURCE_NAME)
  private String versionsDataSourceName;

  public TreeVersioningPolicy() {
  }

  public TreeVersioningPolicy description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public TreeVersioningPolicy ignoreFilesGreaterThan(String ignoreFilesGreaterThan) {
    
    this.ignoreFilesGreaterThan = ignoreFilesGreaterThan;
    return this;
  }

   /**
   * Get ignoreFilesGreaterThan
   * @return ignoreFilesGreaterThan
  **/
  @javax.annotation.Nullable

  public String getIgnoreFilesGreaterThan() {
    return ignoreFilesGreaterThan;
  }


  public void setIgnoreFilesGreaterThan(String ignoreFilesGreaterThan) {
    this.ignoreFilesGreaterThan = ignoreFilesGreaterThan;
  }


  public TreeVersioningPolicy keepPeriods(List<TreeVersioningKeepPeriod> keepPeriods) {
    
    this.keepPeriods = keepPeriods;
    return this;
  }

  public TreeVersioningPolicy addKeepPeriodsItem(TreeVersioningKeepPeriod keepPeriodsItem) {
    if (this.keepPeriods == null) {
      this.keepPeriods = new ArrayList<>();
    }
    this.keepPeriods.add(keepPeriodsItem);
    return this;
  }

   /**
   * Get keepPeriods
   * @return keepPeriods
  **/
  @javax.annotation.Nullable

  public List<TreeVersioningKeepPeriod> getKeepPeriods() {
    return keepPeriods;
  }


  public void setKeepPeriods(List<TreeVersioningKeepPeriod> keepPeriods) {
    this.keepPeriods = keepPeriods;
  }


  public TreeVersioningPolicy maxSizePerFile(String maxSizePerFile) {
    
    this.maxSizePerFile = maxSizePerFile;
    return this;
  }

   /**
   * Get maxSizePerFile
   * @return maxSizePerFile
  **/
  @javax.annotation.Nullable

  public String getMaxSizePerFile() {
    return maxSizePerFile;
  }


  public void setMaxSizePerFile(String maxSizePerFile) {
    this.maxSizePerFile = maxSizePerFile;
  }


  public TreeVersioningPolicy maxTotalSize(String maxTotalSize) {
    
    this.maxTotalSize = maxTotalSize;
    return this;
  }

   /**
   * Get maxTotalSize
   * @return maxTotalSize
  **/
  @javax.annotation.Nullable

  public String getMaxTotalSize() {
    return maxTotalSize;
  }


  public void setMaxTotalSize(String maxTotalSize) {
    this.maxTotalSize = maxTotalSize;
  }


  public TreeVersioningPolicy name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public TreeVersioningPolicy nodeDeletedStrategy(TreeVersioningNodeDeletedStrategy nodeDeletedStrategy) {
    
    this.nodeDeletedStrategy = nodeDeletedStrategy;
    return this;
  }

   /**
   * Get nodeDeletedStrategy
   * @return nodeDeletedStrategy
  **/
  @javax.annotation.Nullable

  public TreeVersioningNodeDeletedStrategy getNodeDeletedStrategy() {
    return nodeDeletedStrategy;
  }


  public void setNodeDeletedStrategy(TreeVersioningNodeDeletedStrategy nodeDeletedStrategy) {
    this.nodeDeletedStrategy = nodeDeletedStrategy;
  }


  public TreeVersioningPolicy uuid(String uuid) {
    
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nullable

  public String getUuid() {
    return uuid;
  }


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public TreeVersioningPolicy versionsDataSourceBucket(String versionsDataSourceBucket) {
    
    this.versionsDataSourceBucket = versionsDataSourceBucket;
    return this;
  }

   /**
   * Get versionsDataSourceBucket
   * @return versionsDataSourceBucket
  **/
  @javax.annotation.Nullable

  public String getVersionsDataSourceBucket() {
    return versionsDataSourceBucket;
  }


  public void setVersionsDataSourceBucket(String versionsDataSourceBucket) {
    this.versionsDataSourceBucket = versionsDataSourceBucket;
  }


  public TreeVersioningPolicy versionsDataSourceName(String versionsDataSourceName) {
    
    this.versionsDataSourceName = versionsDataSourceName;
    return this;
  }

   /**
   * Get versionsDataSourceName
   * @return versionsDataSourceName
  **/
  @javax.annotation.Nullable

  public String getVersionsDataSourceName() {
    return versionsDataSourceName;
  }


  public void setVersionsDataSourceName(String versionsDataSourceName) {
    this.versionsDataSourceName = versionsDataSourceName;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeVersioningPolicy treeVersioningPolicy = (TreeVersioningPolicy) o;
    return Objects.equals(this.description, treeVersioningPolicy.description) &&
        Objects.equals(this.ignoreFilesGreaterThan, treeVersioningPolicy.ignoreFilesGreaterThan) &&
        Objects.equals(this.keepPeriods, treeVersioningPolicy.keepPeriods) &&
        Objects.equals(this.maxSizePerFile, treeVersioningPolicy.maxSizePerFile) &&
        Objects.equals(this.maxTotalSize, treeVersioningPolicy.maxTotalSize) &&
        Objects.equals(this.name, treeVersioningPolicy.name) &&
        Objects.equals(this.nodeDeletedStrategy, treeVersioningPolicy.nodeDeletedStrategy) &&
        Objects.equals(this.uuid, treeVersioningPolicy.uuid) &&
        Objects.equals(this.versionsDataSourceBucket, treeVersioningPolicy.versionsDataSourceBucket) &&
        Objects.equals(this.versionsDataSourceName, treeVersioningPolicy.versionsDataSourceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, ignoreFilesGreaterThan, keepPeriods, maxSizePerFile, maxTotalSize, name, nodeDeletedStrategy, uuid, versionsDataSourceBucket, versionsDataSourceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeVersioningPolicy {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    ignoreFilesGreaterThan: ").append(toIndentedString(ignoreFilesGreaterThan)).append("\n");
    sb.append("    keepPeriods: ").append(toIndentedString(keepPeriods)).append("\n");
    sb.append("    maxSizePerFile: ").append(toIndentedString(maxSizePerFile)).append("\n");
    sb.append("    maxTotalSize: ").append(toIndentedString(maxTotalSize)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nodeDeletedStrategy: ").append(toIndentedString(nodeDeletedStrategy)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    versionsDataSourceBucket: ").append(toIndentedString(versionsDataSourceBucket)).append("\n");
    sb.append("    versionsDataSourceName: ").append(toIndentedString(versionsDataSourceName)).append("\n");
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
    openapiFields.add("Description");
    openapiFields.add("IgnoreFilesGreaterThan");
    openapiFields.add("KeepPeriods");
    openapiFields.add("MaxSizePerFile");
    openapiFields.add("MaxTotalSize");
    openapiFields.add("Name");
    openapiFields.add("NodeDeletedStrategy");
    openapiFields.add("Uuid");
    openapiFields.add("VersionsDataSourceBucket");
    openapiFields.add("VersionsDataSourceName");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TreeVersioningPolicy
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TreeVersioningPolicy.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TreeVersioningPolicy is not found in the empty JSON string", TreeVersioningPolicy.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TreeVersioningPolicy.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeVersioningPolicy` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("IgnoreFilesGreaterThan") != null && !jsonObj.get("IgnoreFilesGreaterThan").isJsonNull()) && !jsonObj.get("IgnoreFilesGreaterThan").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `IgnoreFilesGreaterThan` to be a primitive type in the JSON string but got `%s`", jsonObj.get("IgnoreFilesGreaterThan").toString()));
      }
      if (jsonObj.get("KeepPeriods") != null && !jsonObj.get("KeepPeriods").isJsonNull()) {
        JsonArray jsonArraykeepPeriods = jsonObj.getAsJsonArray("KeepPeriods");
        if (jsonArraykeepPeriods != null) {
          // ensure the json data is an array
          if (!jsonObj.get("KeepPeriods").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `KeepPeriods` to be an array in the JSON string but got `%s`", jsonObj.get("KeepPeriods").toString()));
          }

          // validate the optional field `KeepPeriods` (array)
          for (int i = 0; i < jsonArraykeepPeriods.size(); i++) {
            TreeVersioningKeepPeriod.validateJsonObject(jsonArraykeepPeriods.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("MaxSizePerFile") != null && !jsonObj.get("MaxSizePerFile").isJsonNull()) && !jsonObj.get("MaxSizePerFile").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MaxSizePerFile` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MaxSizePerFile").toString()));
      }
      if ((jsonObj.get("MaxTotalSize") != null && !jsonObj.get("MaxTotalSize").isJsonNull()) && !jsonObj.get("MaxTotalSize").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MaxTotalSize` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MaxTotalSize").toString()));
      }
      if ((jsonObj.get("Name") != null && !jsonObj.get("Name").isJsonNull()) && !jsonObj.get("Name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Name").toString()));
      }
      if ((jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull()) && !jsonObj.get("Uuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
      }
      if ((jsonObj.get("VersionsDataSourceBucket") != null && !jsonObj.get("VersionsDataSourceBucket").isJsonNull()) && !jsonObj.get("VersionsDataSourceBucket").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `VersionsDataSourceBucket` to be a primitive type in the JSON string but got `%s`", jsonObj.get("VersionsDataSourceBucket").toString()));
      }
      if ((jsonObj.get("VersionsDataSourceName") != null && !jsonObj.get("VersionsDataSourceName").isJsonNull()) && !jsonObj.get("VersionsDataSourceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `VersionsDataSourceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("VersionsDataSourceName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TreeVersioningPolicy.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TreeVersioningPolicy' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TreeVersioningPolicy> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TreeVersioningPolicy.class));

       return (TypeAdapter<T>) new TypeAdapter<TreeVersioningPolicy>() {
           @Override
           public void write(JsonWriter out, TreeVersioningPolicy value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TreeVersioningPolicy read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TreeVersioningPolicy given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TreeVersioningPolicy
  * @throws IOException if the JSON string is invalid with respect to TreeVersioningPolicy
  */
  public static TreeVersioningPolicy fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TreeVersioningPolicy.class);
  }

 /**
  * Convert an instance of TreeVersioningPolicy to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

