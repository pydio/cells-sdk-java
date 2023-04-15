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
 * RestLogMessageCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestLogMessageCollection {
  public static final String SERIALIZED_NAME_LOGS = "Logs";
  @SerializedName(SERIALIZED_NAME_LOGS)
  private List<LogLogMessage> logs;

  public RestLogMessageCollection() {
  }

  public RestLogMessageCollection logs(List<LogLogMessage> logs) {
    
    this.logs = logs;
    return this;
  }

  public RestLogMessageCollection addLogsItem(LogLogMessage logsItem) {
    if (this.logs == null) {
      this.logs = new ArrayList<>();
    }
    this.logs.add(logsItem);
    return this;
  }

   /**
   * Get logs
   * @return logs
  **/
  @javax.annotation.Nullable

  public List<LogLogMessage> getLogs() {
    return logs;
  }


  public void setLogs(List<LogLogMessage> logs) {
    this.logs = logs;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestLogMessageCollection restLogMessageCollection = (RestLogMessageCollection) o;
    return Objects.equals(this.logs, restLogMessageCollection.logs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestLogMessageCollection {\n");
    sb.append("    logs: ").append(toIndentedString(logs)).append("\n");
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
    openapiFields.add("Logs");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestLogMessageCollection
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestLogMessageCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestLogMessageCollection is not found in the empty JSON string", RestLogMessageCollection.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestLogMessageCollection.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestLogMessageCollection` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Logs") != null && !jsonObj.get("Logs").isJsonNull()) {
        JsonArray jsonArraylogs = jsonObj.getAsJsonArray("Logs");
        if (jsonArraylogs != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Logs").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Logs` to be an array in the JSON string but got `%s`", jsonObj.get("Logs").toString()));
          }

          // validate the optional field `Logs` (array)
          for (int i = 0; i < jsonArraylogs.size(); i++) {
            LogLogMessage.validateJsonObject(jsonArraylogs.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestLogMessageCollection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestLogMessageCollection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestLogMessageCollection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestLogMessageCollection.class));

       return (TypeAdapter<T>) new TypeAdapter<RestLogMessageCollection>() {
           @Override
           public void write(JsonWriter out, RestLogMessageCollection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestLogMessageCollection read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestLogMessageCollection given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestLogMessageCollection
  * @throws IOException if the JSON string is invalid with respect to RestLogMessageCollection
  */
  public static RestLogMessageCollection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestLogMessageCollection.class);
  }

 /**
  * Convert an instance of RestLogMessageCollection to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

