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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * JobsDeleteTasksResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class JobsDeleteTasksResponse {
  public static final String SERIALIZED_NAME_DELETED = "Deleted";
  @SerializedName(SERIALIZED_NAME_DELETED)
  private List<String> deleted;

  public JobsDeleteTasksResponse() {
  }

  public JobsDeleteTasksResponse deleted(List<String> deleted) {
    
    this.deleted = deleted;
    return this;
  }

  public JobsDeleteTasksResponse addDeletedItem(String deletedItem) {
    if (this.deleted == null) {
      this.deleted = new ArrayList<>();
    }
    this.deleted.add(deletedItem);
    return this;
  }

   /**
   * Get deleted
   * @return deleted
  **/
  @javax.annotation.Nullable

  public List<String> getDeleted() {
    return deleted;
  }


  public void setDeleted(List<String> deleted) {
    this.deleted = deleted;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsDeleteTasksResponse jobsDeleteTasksResponse = (JobsDeleteTasksResponse) o;
    return Objects.equals(this.deleted, jobsDeleteTasksResponse.deleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsDeleteTasksResponse {\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
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
    openapiFields.add("Deleted");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to JobsDeleteTasksResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!JobsDeleteTasksResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JobsDeleteTasksResponse is not found in the empty JSON string", JobsDeleteTasksResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!JobsDeleteTasksResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JobsDeleteTasksResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("Deleted") != null && !jsonObj.get("Deleted").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `Deleted` to be an array in the JSON string but got `%s`", jsonObj.get("Deleted").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JobsDeleteTasksResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JobsDeleteTasksResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JobsDeleteTasksResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JobsDeleteTasksResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<JobsDeleteTasksResponse>() {
           @Override
           public void write(JsonWriter out, JobsDeleteTasksResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JobsDeleteTasksResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of JobsDeleteTasksResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of JobsDeleteTasksResponse
  * @throws IOException if the JSON string is invalid with respect to JobsDeleteTasksResponse
  */
  public static JobsDeleteTasksResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JobsDeleteTasksResponse.class);
  }

 /**
  * Convert an instance of JobsDeleteTasksResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

