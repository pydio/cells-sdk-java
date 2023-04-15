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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * TreeWorkspaceRelativePath
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class TreeWorkspaceRelativePath {
  public static final String SERIALIZED_NAME_PATH = "Path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path;

  public static final String SERIALIZED_NAME_WS_LABEL = "WsLabel";
  @SerializedName(SERIALIZED_NAME_WS_LABEL)
  private String wsLabel;

  public static final String SERIALIZED_NAME_WS_SCOPE = "WsScope";
  @SerializedName(SERIALIZED_NAME_WS_SCOPE)
  private String wsScope;

  public static final String SERIALIZED_NAME_WS_SLUG = "WsSlug";
  @SerializedName(SERIALIZED_NAME_WS_SLUG)
  private String wsSlug;

  public static final String SERIALIZED_NAME_WS_UUID = "WsUuid";
  @SerializedName(SERIALIZED_NAME_WS_UUID)
  private String wsUuid;

  public TreeWorkspaceRelativePath() {
  }

  public TreeWorkspaceRelativePath path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public TreeWorkspaceRelativePath wsLabel(String wsLabel) {
    
    this.wsLabel = wsLabel;
    return this;
  }

   /**
   * Get wsLabel
   * @return wsLabel
  **/
  @javax.annotation.Nullable

  public String getWsLabel() {
    return wsLabel;
  }


  public void setWsLabel(String wsLabel) {
    this.wsLabel = wsLabel;
  }


  public TreeWorkspaceRelativePath wsScope(String wsScope) {
    
    this.wsScope = wsScope;
    return this;
  }

   /**
   * Get wsScope
   * @return wsScope
  **/
  @javax.annotation.Nullable

  public String getWsScope() {
    return wsScope;
  }


  public void setWsScope(String wsScope) {
    this.wsScope = wsScope;
  }


  public TreeWorkspaceRelativePath wsSlug(String wsSlug) {
    
    this.wsSlug = wsSlug;
    return this;
  }

   /**
   * Get wsSlug
   * @return wsSlug
  **/
  @javax.annotation.Nullable

  public String getWsSlug() {
    return wsSlug;
  }


  public void setWsSlug(String wsSlug) {
    this.wsSlug = wsSlug;
  }


  public TreeWorkspaceRelativePath wsUuid(String wsUuid) {
    
    this.wsUuid = wsUuid;
    return this;
  }

   /**
   * Get wsUuid
   * @return wsUuid
  **/
  @javax.annotation.Nullable

  public String getWsUuid() {
    return wsUuid;
  }


  public void setWsUuid(String wsUuid) {
    this.wsUuid = wsUuid;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeWorkspaceRelativePath treeWorkspaceRelativePath = (TreeWorkspaceRelativePath) o;
    return Objects.equals(this.path, treeWorkspaceRelativePath.path) &&
        Objects.equals(this.wsLabel, treeWorkspaceRelativePath.wsLabel) &&
        Objects.equals(this.wsScope, treeWorkspaceRelativePath.wsScope) &&
        Objects.equals(this.wsSlug, treeWorkspaceRelativePath.wsSlug) &&
        Objects.equals(this.wsUuid, treeWorkspaceRelativePath.wsUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, wsLabel, wsScope, wsSlug, wsUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeWorkspaceRelativePath {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    wsLabel: ").append(toIndentedString(wsLabel)).append("\n");
    sb.append("    wsScope: ").append(toIndentedString(wsScope)).append("\n");
    sb.append("    wsSlug: ").append(toIndentedString(wsSlug)).append("\n");
    sb.append("    wsUuid: ").append(toIndentedString(wsUuid)).append("\n");
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
    openapiFields.add("Path");
    openapiFields.add("WsLabel");
    openapiFields.add("WsScope");
    openapiFields.add("WsSlug");
    openapiFields.add("WsUuid");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TreeWorkspaceRelativePath
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TreeWorkspaceRelativePath.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TreeWorkspaceRelativePath is not found in the empty JSON string", TreeWorkspaceRelativePath.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TreeWorkspaceRelativePath.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeWorkspaceRelativePath` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Path") != null && !jsonObj.get("Path").isJsonNull()) && !jsonObj.get("Path").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Path` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Path").toString()));
      }
      if ((jsonObj.get("WsLabel") != null && !jsonObj.get("WsLabel").isJsonNull()) && !jsonObj.get("WsLabel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WsLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WsLabel").toString()));
      }
      if ((jsonObj.get("WsScope") != null && !jsonObj.get("WsScope").isJsonNull()) && !jsonObj.get("WsScope").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WsScope` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WsScope").toString()));
      }
      if ((jsonObj.get("WsSlug") != null && !jsonObj.get("WsSlug").isJsonNull()) && !jsonObj.get("WsSlug").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WsSlug` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WsSlug").toString()));
      }
      if ((jsonObj.get("WsUuid") != null && !jsonObj.get("WsUuid").isJsonNull()) && !jsonObj.get("WsUuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WsUuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WsUuid").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TreeWorkspaceRelativePath.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TreeWorkspaceRelativePath' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TreeWorkspaceRelativePath> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TreeWorkspaceRelativePath.class));

       return (TypeAdapter<T>) new TypeAdapter<TreeWorkspaceRelativePath>() {
           @Override
           public void write(JsonWriter out, TreeWorkspaceRelativePath value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TreeWorkspaceRelativePath read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TreeWorkspaceRelativePath given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TreeWorkspaceRelativePath
  * @throws IOException if the JSON string is invalid with respect to TreeWorkspaceRelativePath
  */
  public static TreeWorkspaceRelativePath fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TreeWorkspaceRelativePath.class);
  }

 /**
  * Convert an instance of TreeWorkspaceRelativePath to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

