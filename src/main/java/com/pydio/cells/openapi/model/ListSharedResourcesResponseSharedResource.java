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
 * ListSharedResourcesResponseSharedResource
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class ListSharedResourcesResponseSharedResource {
  public static final String SERIALIZED_NAME_CELLS = "Cells";
  @SerializedName(SERIALIZED_NAME_CELLS)
  private List<RestCell> cells;

  public static final String SERIALIZED_NAME_LINK = "Link";
  @SerializedName(SERIALIZED_NAME_LINK)
  private RestShareLink link;

  public static final String SERIALIZED_NAME_NODE = "Node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private TreeNode node;

  public ListSharedResourcesResponseSharedResource() {
  }

  public ListSharedResourcesResponseSharedResource cells(List<RestCell> cells) {
    this.cells = cells;
    return this;
  }

  public ListSharedResourcesResponseSharedResource addCellsItem(RestCell cellsItem) {
    if (this.cells == null) {
      this.cells = new ArrayList<>();
    }
    this.cells.add(cellsItem);
    return this;
  }

   /**
   * Get cells
   * @return cells
  **/
  @javax.annotation.Nullable
  public List<RestCell> getCells() {
    return cells;
  }

  public void setCells(List<RestCell> cells) {
    this.cells = cells;
  }


  public ListSharedResourcesResponseSharedResource link(RestShareLink link) {
    this.link = link;
    return this;
  }

   /**
   * Get link
   * @return link
  **/
  @javax.annotation.Nullable
  public RestShareLink getLink() {
    return link;
  }

  public void setLink(RestShareLink link) {
    this.link = link;
  }


  public ListSharedResourcesResponseSharedResource node(TreeNode node) {
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @javax.annotation.Nullable
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
    ListSharedResourcesResponseSharedResource listSharedResourcesResponseSharedResource = (ListSharedResourcesResponseSharedResource) o;
    return Objects.equals(this.cells, listSharedResourcesResponseSharedResource.cells) &&
        Objects.equals(this.link, listSharedResourcesResponseSharedResource.link) &&
        Objects.equals(this.node, listSharedResourcesResponseSharedResource.node);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cells, link, node);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListSharedResourcesResponseSharedResource {\n");
    sb.append("    cells: ").append(toIndentedString(cells)).append("\n");
    sb.append("    link: ").append(toIndentedString(link)).append("\n");
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
    openapiFields.add("Cells");
    openapiFields.add("Link");
    openapiFields.add("Node");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ListSharedResourcesResponseSharedResource
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ListSharedResourcesResponseSharedResource.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ListSharedResourcesResponseSharedResource is not found in the empty JSON string", ListSharedResourcesResponseSharedResource.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ListSharedResourcesResponseSharedResource.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ListSharedResourcesResponseSharedResource` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("Cells") != null && !jsonObj.get("Cells").isJsonNull()) {
        JsonArray jsonArraycells = jsonObj.getAsJsonArray("Cells");
        if (jsonArraycells != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Cells").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Cells` to be an array in the JSON string but got `%s`", jsonObj.get("Cells").toString()));
          }

          // validate the optional field `Cells` (array)
          for (int i = 0; i < jsonArraycells.size(); i++) {
            RestCell.validateJsonElement(jsonArraycells.get(i));
          };
        }
      }
      // validate the optional field `Link`
      if (jsonObj.get("Link") != null && !jsonObj.get("Link").isJsonNull()) {
        RestShareLink.validateJsonElement(jsonObj.get("Link"));
      }
      // validate the optional field `Node`
      if (jsonObj.get("Node") != null && !jsonObj.get("Node").isJsonNull()) {
        TreeNode.validateJsonElement(jsonObj.get("Node"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ListSharedResourcesResponseSharedResource.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ListSharedResourcesResponseSharedResource' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ListSharedResourcesResponseSharedResource> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ListSharedResourcesResponseSharedResource.class));

       return (TypeAdapter<T>) new TypeAdapter<ListSharedResourcesResponseSharedResource>() {
           @Override
           public void write(JsonWriter out, ListSharedResourcesResponseSharedResource value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ListSharedResourcesResponseSharedResource read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ListSharedResourcesResponseSharedResource given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ListSharedResourcesResponseSharedResource
  * @throws IOException if the JSON string is invalid with respect to ListSharedResourcesResponseSharedResource
  */
  public static ListSharedResourcesResponseSharedResource fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ListSharedResourcesResponseSharedResource.class);
  }

 /**
  * Convert an instance of ListSharedResourcesResponseSharedResource to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

