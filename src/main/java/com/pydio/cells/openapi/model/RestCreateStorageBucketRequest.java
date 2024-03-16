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
 * RestCreateStorageBucketRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
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
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RestCreateStorageBucketRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RestCreateStorageBucketRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestCreateStorageBucketRequest is not found in the empty JSON string", RestCreateStorageBucketRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RestCreateStorageBucketRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestCreateStorageBucketRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `DataSource`
      if (jsonObj.get("DataSource") != null && !jsonObj.get("DataSource").isJsonNull()) {
        ObjectDataSource.validateJsonElement(jsonObj.get("DataSource"));
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
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
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

