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
 * RegistryListRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RegistryListRequest {
  public static final String SERIALIZED_NAME_ADJACENTS_OPTIONS = "adjacentsOptions";
  @SerializedName(SERIALIZED_NAME_ADJACENTS_OPTIONS)
  private RegistryOptions adjacentsOptions;

  public static final String SERIALIZED_NAME_OPTIONS = "options";
  @SerializedName(SERIALIZED_NAME_OPTIONS)
  private RegistryOptions options;

  public RegistryListRequest() {
  }

  public RegistryListRequest adjacentsOptions(RegistryOptions adjacentsOptions) {
    
    this.adjacentsOptions = adjacentsOptions;
    return this;
  }

   /**
   * Get adjacentsOptions
   * @return adjacentsOptions
  **/
  @javax.annotation.Nullable

  public RegistryOptions getAdjacentsOptions() {
    return adjacentsOptions;
  }


  public void setAdjacentsOptions(RegistryOptions adjacentsOptions) {
    this.adjacentsOptions = adjacentsOptions;
  }


  public RegistryListRequest options(RegistryOptions options) {
    
    this.options = options;
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @javax.annotation.Nullable

  public RegistryOptions getOptions() {
    return options;
  }


  public void setOptions(RegistryOptions options) {
    this.options = options;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryListRequest registryListRequest = (RegistryListRequest) o;
    return Objects.equals(this.adjacentsOptions, registryListRequest.adjacentsOptions) &&
        Objects.equals(this.options, registryListRequest.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adjacentsOptions, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistryListRequest {\n");
    sb.append("    adjacentsOptions: ").append(toIndentedString(adjacentsOptions)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
    openapiFields.add("adjacentsOptions");
    openapiFields.add("options");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RegistryListRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RegistryListRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RegistryListRequest is not found in the empty JSON string", RegistryListRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RegistryListRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RegistryListRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `adjacentsOptions`
      if (jsonObj.get("adjacentsOptions") != null && !jsonObj.get("adjacentsOptions").isJsonNull()) {
        RegistryOptions.validateJsonObject(jsonObj.getAsJsonObject("adjacentsOptions"));
      }
      // validate the optional field `options`
      if (jsonObj.get("options") != null && !jsonObj.get("options").isJsonNull()) {
        RegistryOptions.validateJsonObject(jsonObj.getAsJsonObject("options"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RegistryListRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RegistryListRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RegistryListRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RegistryListRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RegistryListRequest>() {
           @Override
           public void write(JsonWriter out, RegistryListRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RegistryListRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RegistryListRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RegistryListRequest
  * @throws IOException if the JSON string is invalid with respect to RegistryListRequest
  */
  public static RegistryListRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RegistryListRequest.class);
  }

 /**
  * Convert an instance of RegistryListRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

