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

import io.swagger.annotations.ApiModelProperty;

/**
 * RestBulkMetaResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestBulkMetaResponse {
  public static final String SERIALIZED_NAME_NODES = "Nodes";
  @SerializedName(SERIALIZED_NAME_NODES)
  private List<TreeNode> nodes = null;

  public static final String SERIALIZED_NAME_PAGINATION = "Pagination";
  @SerializedName(SERIALIZED_NAME_PAGINATION)
  private RestPagination pagination;

  public RestBulkMetaResponse() {
  }

  public RestBulkMetaResponse nodes(List<TreeNode> nodes) {
    
    this.nodes = nodes;
    return this;
  }

  public RestBulkMetaResponse addNodesItem(TreeNode nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

   /**
   * Get nodes
   * @return nodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<TreeNode> getNodes() {
    return nodes;
  }


  public void setNodes(List<TreeNode> nodes) {
    this.nodes = nodes;
  }


  public RestBulkMetaResponse pagination(RestPagination pagination) {
    
    this.pagination = pagination;
    return this;
  }

   /**
   * Get pagination
   * @return pagination
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RestPagination getPagination() {
    return pagination;
  }


  public void setPagination(RestPagination pagination) {
    this.pagination = pagination;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestBulkMetaResponse restBulkMetaResponse = (RestBulkMetaResponse) o;
    return Objects.equals(this.nodes, restBulkMetaResponse.nodes) &&
        Objects.equals(this.pagination, restBulkMetaResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, pagination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestBulkMetaResponse {\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
    openapiFields.add("Pagination");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestBulkMetaResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestBulkMetaResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestBulkMetaResponse is not found in the empty JSON string", RestBulkMetaResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestBulkMetaResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestBulkMetaResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Nodes") != null && !jsonObj.get("Nodes").isJsonNull()) {
        JsonArray jsonArraynodes = jsonObj.getAsJsonArray("Nodes");
        if (jsonArraynodes != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Nodes").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Nodes` to be an array in the JSON string but got `%s`", jsonObj.get("Nodes").toString()));
          }

          // validate the optional field `Nodes` (array)
          for (int i = 0; i < jsonArraynodes.size(); i++) {
            TreeNode.validateJsonObject(jsonArraynodes.get(i).getAsJsonObject());
          };
        }
      }
      // validate the optional field `Pagination`
      if (jsonObj.get("Pagination") != null && !jsonObj.get("Pagination").isJsonNull()) {
        RestPagination.validateJsonObject(jsonObj.getAsJsonObject("Pagination"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestBulkMetaResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestBulkMetaResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestBulkMetaResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestBulkMetaResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RestBulkMetaResponse>() {
           @Override
           public void write(JsonWriter out, RestBulkMetaResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestBulkMetaResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestBulkMetaResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestBulkMetaResponse
  * @throws IOException if the JSON string is invalid with respect to RestBulkMetaResponse
  */
  public static RestBulkMetaResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestBulkMetaResponse.class);
  }

 /**
  * Convert an instance of RestBulkMetaResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

