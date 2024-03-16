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
 * RestBackgroundJobResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class RestBackgroundJobResult {
  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_NODE_UUID = "NodeUuid";
  @SerializedName(SERIALIZED_NAME_NODE_UUID)
  private String nodeUuid;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public RestBackgroundJobResult() {
  }

  public RestBackgroundJobResult label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public RestBackgroundJobResult nodeUuid(String nodeUuid) {
    this.nodeUuid = nodeUuid;
    return this;
  }

   /**
   * Get nodeUuid
   * @return nodeUuid
  **/
  @javax.annotation.Nullable
  public String getNodeUuid() {
    return nodeUuid;
  }

  public void setNodeUuid(String nodeUuid) {
    this.nodeUuid = nodeUuid;
  }


  public RestBackgroundJobResult uuid(String uuid) {
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



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestBackgroundJobResult restBackgroundJobResult = (RestBackgroundJobResult) o;
    return Objects.equals(this.label, restBackgroundJobResult.label) &&
        Objects.equals(this.nodeUuid, restBackgroundJobResult.nodeUuid) &&
        Objects.equals(this.uuid, restBackgroundJobResult.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, nodeUuid, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestBackgroundJobResult {\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    nodeUuid: ").append(toIndentedString(nodeUuid)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
    openapiFields.add("Label");
    openapiFields.add("NodeUuid");
    openapiFields.add("Uuid");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RestBackgroundJobResult
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RestBackgroundJobResult.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestBackgroundJobResult is not found in the empty JSON string", RestBackgroundJobResult.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RestBackgroundJobResult.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestBackgroundJobResult` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
      if ((jsonObj.get("NodeUuid") != null && !jsonObj.get("NodeUuid").isJsonNull()) && !jsonObj.get("NodeUuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `NodeUuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("NodeUuid").toString()));
      }
      if ((jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull()) && !jsonObj.get("Uuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestBackgroundJobResult.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestBackgroundJobResult' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestBackgroundJobResult> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestBackgroundJobResult.class));

       return (TypeAdapter<T>) new TypeAdapter<RestBackgroundJobResult>() {
           @Override
           public void write(JsonWriter out, RestBackgroundJobResult value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestBackgroundJobResult read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestBackgroundJobResult given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestBackgroundJobResult
  * @throws IOException if the JSON string is invalid with respect to RestBackgroundJobResult
  */
  public static RestBackgroundJobResult fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestBackgroundJobResult.class);
  }

 /**
  * Convert an instance of RestBackgroundJobResult to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

