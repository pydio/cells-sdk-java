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
 * RestCreateStorageBucketRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestCreateStorageBucketRequest {
  public static final String SERIALIZED_NAME_DATA_SOURCE = "DataSource";
  @SerializedName(SERIALIZED_NAME_DATA_SOURCE)
  private ObjectDataSource dataSource;

  public RestCreateStorageBucketRequest() {
  }

  public RestCreateStorageBucketRequest dataSource(ObjectDataSource dataSource) {
    
    this.dataSource = dataSource;
    return this;
  }

   /**
   * Get dataSource
   * @return dataSource
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ObjectDataSource getDataSource() {
    return dataSource;
  }


  public void setDataSource(ObjectDataSource dataSource) {
    this.dataSource = dataSource;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestCreateStorageBucketRequest restCreateStorageBucketRequest = (RestCreateStorageBucketRequest) o;
    return Objects.equals(this.dataSource, restCreateStorageBucketRequest.dataSource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCreateStorageBucketRequest {\n");
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
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
    openapiFields.add("DataSource");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestCreateStorageBucketRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestCreateStorageBucketRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestCreateStorageBucketRequest is not found in the empty JSON string", RestCreateStorageBucketRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestCreateStorageBucketRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestCreateStorageBucketRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // validate the optional field `DataSource`
      if (jsonObj.get("DataSource") != null && !jsonObj.get("DataSource").isJsonNull()) {
        ObjectDataSource.validateJsonObject(jsonObj.getAsJsonObject("DataSource"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestCreateStorageBucketRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestCreateStorageBucketRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestCreateStorageBucketRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestCreateStorageBucketRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestCreateStorageBucketRequest>() {
           @Override
           public void write(JsonWriter out, RestCreateStorageBucketRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestCreateStorageBucketRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestCreateStorageBucketRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestCreateStorageBucketRequest
  * @throws IOException if the JSON string is invalid with respect to RestCreateStorageBucketRequest
  */
  public static RestCreateStorageBucketRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestCreateStorageBucketRequest.class);
  }

 /**
  * Convert an instance of RestCreateStorageBucketRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

