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
 * RestCreateNodesRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestCreateNodesRequest {
  public static final String SERIALIZED_NAME_NODES = "Nodes";
  @SerializedName(SERIALIZED_NAME_NODES)
  private List<TreeNode> nodes;

  public static final String SERIALIZED_NAME_RECURSIVE = "Recursive";
  @SerializedName(SERIALIZED_NAME_RECURSIVE)
  private Boolean recursive;

  public static final String SERIALIZED_NAME_TEMPLATE_U_U_I_D = "TemplateUUID";
  @SerializedName(SERIALIZED_NAME_TEMPLATE_U_U_I_D)
  private String templateUUID;

  public RestCreateNodesRequest() {
  }

  public RestCreateNodesRequest nodes(List<TreeNode> nodes) {
    
    this.nodes = nodes;
    return this;
  }

  public RestCreateNodesRequest addNodesItem(TreeNode nodesItem) {
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

  public List<TreeNode> getNodes() {
    return nodes;
  }


  public void setNodes(List<TreeNode> nodes) {
    this.nodes = nodes;
  }


  public RestCreateNodesRequest recursive(Boolean recursive) {
    
    this.recursive = recursive;
    return this;
  }

   /**
   * Get recursive
   * @return recursive
  **/
  @javax.annotation.Nullable

  public Boolean getRecursive() {
    return recursive;
  }


  public void setRecursive(Boolean recursive) {
    this.recursive = recursive;
  }


  public RestCreateNodesRequest templateUUID(String templateUUID) {
    
    this.templateUUID = templateUUID;
    return this;
  }

   /**
   * Get templateUUID
   * @return templateUUID
  **/
  @javax.annotation.Nullable

  public String getTemplateUUID() {
    return templateUUID;
  }


  public void setTemplateUUID(String templateUUID) {
    this.templateUUID = templateUUID;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestCreateNodesRequest restCreateNodesRequest = (RestCreateNodesRequest) o;
    return Objects.equals(this.nodes, restCreateNodesRequest.nodes) &&
        Objects.equals(this.recursive, restCreateNodesRequest.recursive) &&
        Objects.equals(this.templateUUID, restCreateNodesRequest.templateUUID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, recursive, templateUUID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCreateNodesRequest {\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    recursive: ").append(toIndentedString(recursive)).append("\n");
    sb.append("    templateUUID: ").append(toIndentedString(templateUUID)).append("\n");
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
    openapiFields.add("Recursive");
    openapiFields.add("TemplateUUID");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestCreateNodesRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestCreateNodesRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestCreateNodesRequest is not found in the empty JSON string", RestCreateNodesRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestCreateNodesRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestCreateNodesRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
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
      if ((jsonObj.get("TemplateUUID") != null && !jsonObj.get("TemplateUUID").isJsonNull()) && !jsonObj.get("TemplateUUID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `TemplateUUID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TemplateUUID").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestCreateNodesRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestCreateNodesRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestCreateNodesRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestCreateNodesRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestCreateNodesRequest>() {
           @Override
           public void write(JsonWriter out, RestCreateNodesRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestCreateNodesRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestCreateNodesRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestCreateNodesRequest
  * @throws IOException if the JSON string is invalid with respect to RestCreateNodesRequest
  */
  public static RestCreateNodesRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestCreateNodesRequest.class);
  }

 /**
  * Convert an instance of RestCreateNodesRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

