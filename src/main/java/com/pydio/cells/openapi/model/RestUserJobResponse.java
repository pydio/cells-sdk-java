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
 * RestUserJobResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RestUserJobResponse {
  public static final String SERIALIZED_NAME_JOB_UUID = "JobUuid";
  @SerializedName(SERIALIZED_NAME_JOB_UUID)
  private String jobUuid;

  public RestUserJobResponse() {
  }

  public RestUserJobResponse jobUuid(String jobUuid) {
    
    this.jobUuid = jobUuid;
    return this;
  }

   /**
   * Get jobUuid
   * @return jobUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJobUuid() {
    return jobUuid;
  }


  public void setJobUuid(String jobUuid) {
    this.jobUuid = jobUuid;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestUserJobResponse restUserJobResponse = (RestUserJobResponse) o;
    return Objects.equals(this.jobUuid, restUserJobResponse.jobUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUserJobResponse {\n");
    sb.append("    jobUuid: ").append(toIndentedString(jobUuid)).append("\n");
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
    openapiFields.add("JobUuid");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestUserJobResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestUserJobResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestUserJobResponse is not found in the empty JSON string", RestUserJobResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestUserJobResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestUserJobResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("JobUuid") != null && !jsonObj.get("JobUuid").isJsonNull()) && !jsonObj.get("JobUuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `JobUuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("JobUuid").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestUserJobResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestUserJobResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestUserJobResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestUserJobResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RestUserJobResponse>() {
           @Override
           public void write(JsonWriter out, RestUserJobResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestUserJobResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestUserJobResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestUserJobResponse
  * @throws IOException if the JSON string is invalid with respect to RestUserJobResponse
  */
  public static RestUserJobResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestUserJobResponse.class);
  }

 /**
  * Convert an instance of RestUserJobResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

