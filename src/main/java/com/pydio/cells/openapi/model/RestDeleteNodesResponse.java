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
 * RestDeleteNodesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestDeleteNodesResponse {
  public static final String SERIALIZED_NAME_DELETE_JOBS = "DeleteJobs";
  @SerializedName(SERIALIZED_NAME_DELETE_JOBS)
  private List<RestBackgroundJobResult> deleteJobs;

  public RestDeleteNodesResponse() {
  }

  public RestDeleteNodesResponse deleteJobs(List<RestBackgroundJobResult> deleteJobs) {
    
    this.deleteJobs = deleteJobs;
    return this;
  }

  public RestDeleteNodesResponse addDeleteJobsItem(RestBackgroundJobResult deleteJobsItem) {
    if (this.deleteJobs == null) {
      this.deleteJobs = new ArrayList<>();
    }
    this.deleteJobs.add(deleteJobsItem);
    return this;
  }

   /**
   * Get deleteJobs
   * @return deleteJobs
  **/
  @javax.annotation.Nullable

  public List<RestBackgroundJobResult> getDeleteJobs() {
    return deleteJobs;
  }


  public void setDeleteJobs(List<RestBackgroundJobResult> deleteJobs) {
    this.deleteJobs = deleteJobs;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestDeleteNodesResponse restDeleteNodesResponse = (RestDeleteNodesResponse) o;
    return Objects.equals(this.deleteJobs, restDeleteNodesResponse.deleteJobs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteJobs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDeleteNodesResponse {\n");
    sb.append("    deleteJobs: ").append(toIndentedString(deleteJobs)).append("\n");
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
    openapiFields.add("DeleteJobs");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestDeleteNodesResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestDeleteNodesResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestDeleteNodesResponse is not found in the empty JSON string", RestDeleteNodesResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestDeleteNodesResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestDeleteNodesResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("DeleteJobs") != null && !jsonObj.get("DeleteJobs").isJsonNull()) {
        JsonArray jsonArraydeleteJobs = jsonObj.getAsJsonArray("DeleteJobs");
        if (jsonArraydeleteJobs != null) {
          // ensure the json data is an array
          if (!jsonObj.get("DeleteJobs").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `DeleteJobs` to be an array in the JSON string but got `%s`", jsonObj.get("DeleteJobs").toString()));
          }

          // validate the optional field `DeleteJobs` (array)
          for (int i = 0; i < jsonArraydeleteJobs.size(); i++) {
            RestBackgroundJobResult.validateJsonObject(jsonArraydeleteJobs.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestDeleteNodesResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestDeleteNodesResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestDeleteNodesResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestDeleteNodesResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RestDeleteNodesResponse>() {
           @Override
           public void write(JsonWriter out, RestDeleteNodesResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestDeleteNodesResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestDeleteNodesResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestDeleteNodesResponse
  * @throws IOException if the JSON string is invalid with respect to RestDeleteNodesResponse
  */
  public static RestDeleteNodesResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestDeleteNodesResponse.class);
  }

 /**
  * Convert an instance of RestDeleteNodesResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

