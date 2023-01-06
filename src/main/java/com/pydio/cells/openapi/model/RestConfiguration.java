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

import io.swagger.annotations.ApiModelProperty;

/**
 * RestConfiguration
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RestConfiguration {
  public static final String SERIALIZED_NAME_DATA = "Data";
  @SerializedName(SERIALIZED_NAME_DATA)
  private String data;

  public static final String SERIALIZED_NAME_FULL_PATH = "FullPath";
  @SerializedName(SERIALIZED_NAME_FULL_PATH)
  private String fullPath;

  public RestConfiguration() {
  }

  public RestConfiguration data(String data) {
    
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getData() {
    return data;
  }


  public void setData(String data) {
    this.data = data;
  }


  public RestConfiguration fullPath(String fullPath) {
    
    this.fullPath = fullPath;
    return this;
  }

   /**
   * Get fullPath
   * @return fullPath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getFullPath() {
    return fullPath;
  }


  public void setFullPath(String fullPath) {
    this.fullPath = fullPath;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestConfiguration restConfiguration = (RestConfiguration) o;
    return Objects.equals(this.data, restConfiguration.data) &&
        Objects.equals(this.fullPath, restConfiguration.fullPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, fullPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestConfiguration {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    fullPath: ").append(toIndentedString(fullPath)).append("\n");
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
    openapiFields.add("Data");
    openapiFields.add("FullPath");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestConfiguration
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestConfiguration.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestConfiguration is not found in the empty JSON string", RestConfiguration.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestConfiguration.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestConfiguration` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Data") != null && !jsonObj.get("Data").isJsonNull()) && !jsonObj.get("Data").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Data` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Data").toString()));
      }
      if ((jsonObj.get("FullPath") != null && !jsonObj.get("FullPath").isJsonNull()) && !jsonObj.get("FullPath").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `FullPath` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FullPath").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestConfiguration.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestConfiguration' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestConfiguration> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestConfiguration.class));

       return (TypeAdapter<T>) new TypeAdapter<RestConfiguration>() {
           @Override
           public void write(JsonWriter out, RestConfiguration value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestConfiguration read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestConfiguration given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestConfiguration
  * @throws IOException if the JSON string is invalid with respect to RestConfiguration
  */
  public static RestConfiguration fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestConfiguration.class);
  }

 /**
  * Convert an instance of RestConfiguration to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

