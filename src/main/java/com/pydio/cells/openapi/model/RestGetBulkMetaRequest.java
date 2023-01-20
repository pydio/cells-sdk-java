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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestGetBulkMetaRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestGetBulkMetaRequest {
  public static final String SERIALIZED_NAME_ALL_META_PROVIDERS = "AllMetaProviders";
  @SerializedName(SERIALIZED_NAME_ALL_META_PROVIDERS)
  private Boolean allMetaProviders;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private Integer limit;

  public static final String SERIALIZED_NAME_NODE_PATHS = "NodePaths";
  @SerializedName(SERIALIZED_NAME_NODE_PATHS)
  private List<String> nodePaths = null;

  public static final String SERIALIZED_NAME_OFFSET = "Offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private Integer offset;

  public static final String SERIALIZED_NAME_VERSIONS = "Versions";
  @SerializedName(SERIALIZED_NAME_VERSIONS)
  private Boolean versions;

  public RestGetBulkMetaRequest() {
  }

  public RestGetBulkMetaRequest allMetaProviders(Boolean allMetaProviders) {
    
    this.allMetaProviders = allMetaProviders;
    return this;
  }

   /**
   * Get allMetaProviders
   * @return allMetaProviders
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAllMetaProviders() {
    return allMetaProviders;
  }


  public void setAllMetaProviders(Boolean allMetaProviders) {
    this.allMetaProviders = allMetaProviders;
  }


  public RestGetBulkMetaRequest limit(Integer limit) {
    
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLimit() {
    return limit;
  }


  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  public RestGetBulkMetaRequest nodePaths(List<String> nodePaths) {
    
    this.nodePaths = nodePaths;
    return this;
  }

  public RestGetBulkMetaRequest addNodePathsItem(String nodePathsItem) {
    if (this.nodePaths == null) {
      this.nodePaths = new ArrayList<>();
    }
    this.nodePaths.add(nodePathsItem);
    return this;
  }

   /**
   * Get nodePaths
   * @return nodePaths
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getNodePaths() {
    return nodePaths;
  }


  public void setNodePaths(List<String> nodePaths) {
    this.nodePaths = nodePaths;
  }


  public RestGetBulkMetaRequest offset(Integer offset) {
    
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getOffset() {
    return offset;
  }


  public void setOffset(Integer offset) {
    this.offset = offset;
  }


  public RestGetBulkMetaRequest versions(Boolean versions) {
    
    this.versions = versions;
    return this;
  }

   /**
   * Get versions
   * @return versions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getVersions() {
    return versions;
  }


  public void setVersions(Boolean versions) {
    this.versions = versions;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestGetBulkMetaRequest restGetBulkMetaRequest = (RestGetBulkMetaRequest) o;
    return Objects.equals(this.allMetaProviders, restGetBulkMetaRequest.allMetaProviders) &&
        Objects.equals(this.limit, restGetBulkMetaRequest.limit) &&
        Objects.equals(this.nodePaths, restGetBulkMetaRequest.nodePaths) &&
        Objects.equals(this.offset, restGetBulkMetaRequest.offset) &&
        Objects.equals(this.versions, restGetBulkMetaRequest.versions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allMetaProviders, limit, nodePaths, offset, versions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestGetBulkMetaRequest {\n");
    sb.append("    allMetaProviders: ").append(toIndentedString(allMetaProviders)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    nodePaths: ").append(toIndentedString(nodePaths)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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
    openapiFields.add("AllMetaProviders");
    openapiFields.add("Limit");
    openapiFields.add("NodePaths");
    openapiFields.add("Offset");
    openapiFields.add("Versions");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestGetBulkMetaRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestGetBulkMetaRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestGetBulkMetaRequest is not found in the empty JSON string", RestGetBulkMetaRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestGetBulkMetaRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestGetBulkMetaRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("NodePaths") != null && !jsonObj.get("NodePaths").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `NodePaths` to be an array in the JSON string but got `%s`", jsonObj.get("NodePaths").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestGetBulkMetaRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestGetBulkMetaRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestGetBulkMetaRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestGetBulkMetaRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestGetBulkMetaRequest>() {
           @Override
           public void write(JsonWriter out, RestGetBulkMetaRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestGetBulkMetaRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestGetBulkMetaRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestGetBulkMetaRequest
  * @throws IOException if the JSON string is invalid with respect to RestGetBulkMetaRequest
  */
  public static RestGetBulkMetaRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestGetBulkMetaRequest.class);
  }

 /**
  * Convert an instance of RestGetBulkMetaRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

