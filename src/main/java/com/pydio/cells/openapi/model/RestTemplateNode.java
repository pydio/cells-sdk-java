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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestTemplateNode
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RestTemplateNode {
  public static final String SERIALIZED_NAME_CHILDREN = "Children";
  @SerializedName(SERIALIZED_NAME_CHILDREN)
  private Map<String, TreeNode> children = null;

  public static final String SERIALIZED_NAME_NODE = "Node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private TreeNode node;

  public RestTemplateNode() {
  }

  public RestTemplateNode children(Map<String, TreeNode> children) {
    
    this.children = children;
    return this;
  }

  public RestTemplateNode putChildrenItem(String key, TreeNode childrenItem) {
    if (this.children == null) {
      this.children = new HashMap<>();
    }
    this.children.put(key, childrenItem);
    return this;
  }

   /**
   * Get children
   * @return children
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, TreeNode> getChildren() {
    return children;
  }


  public void setChildren(Map<String, TreeNode> children) {
    this.children = children;
  }


  public RestTemplateNode node(TreeNode node) {
    
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TreeNode getNode() {
    return node;
  }


  public void setNode(TreeNode node) {
    this.node = node;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestTemplateNode restTemplateNode = (RestTemplateNode) o;
    return Objects.equals(this.children, restTemplateNode.children) &&
        Objects.equals(this.node, restTemplateNode.node);
  }

  @Override
  public int hashCode() {
    return Objects.hash(children, node);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestTemplateNode {\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
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
    openapiFields.add("Node");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestTemplateNode
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestTemplateNode.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestTemplateNode is not found in the empty JSON string", RestTemplateNode.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestTemplateNode.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestTemplateNode` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `Node`
      if (jsonObj.get("Node") != null && !jsonObj.get("Node").isJsonNull()) {
        TreeNode.validateJsonObject(jsonObj.getAsJsonObject("Node"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestTemplateNode.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestTemplateNode' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestTemplateNode> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestTemplateNode.class));

       return (TypeAdapter<T>) new TypeAdapter<RestTemplateNode>() {
           @Override
           public void write(JsonWriter out, RestTemplateNode value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestTemplateNode read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestTemplateNode given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestTemplateNode
  * @throws IOException if the JSON string is invalid with respect to RestTemplateNode
  */
  public static RestTemplateNode fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestTemplateNode.class);
  }

 /**
  * Convert an instance of RestTemplateNode to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

