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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ListLogRequest launches a parameterised query in the log repository and streams the results.
 */
@ApiModel(description = "ListLogRequest launches a parameterised query in the log repository and streams the results.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class LogListLogRequest {
  public static final String SERIALIZED_NAME_FORMAT = "Format";
  @SerializedName(SERIALIZED_NAME_FORMAT)
  private ListLogRequestLogFormat format = ListLogRequestLogFormat.JSON;

  public static final String SERIALIZED_NAME_PAGE = "Page";
  @SerializedName(SERIALIZED_NAME_PAGE)
  private Integer page;

  public static final String SERIALIZED_NAME_QUERY = "Query";
  @SerializedName(SERIALIZED_NAME_QUERY)
  private String query;

  public static final String SERIALIZED_NAME_SIZE = "Size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;

  public LogListLogRequest() {
  }

  public LogListLogRequest format(ListLogRequestLogFormat format) {
    
    this.format = format;
    return this;
  }

   /**
   * Get format
   * @return format
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ListLogRequestLogFormat getFormat() {
    return format;
  }


  public void setFormat(ListLogRequestLogFormat format) {
    this.format = format;
  }


  public LogListLogRequest page(Integer page) {
    
    this.page = page;
    return this;
  }

   /**
   * Get page
   * @return page
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPage() {
    return page;
  }


  public void setPage(Integer page) {
    this.page = page;
  }


  public LogListLogRequest query(String query) {
    
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getQuery() {
    return query;
  }


  public void setQuery(String query) {
    this.query = query;
  }


  public LogListLogRequest size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogListLogRequest logListLogRequest = (LogListLogRequest) o;
    return Objects.equals(this.format, logListLogRequest.format) &&
        Objects.equals(this.page, logListLogRequest.page) &&
        Objects.equals(this.query, logListLogRequest.query) &&
        Objects.equals(this.size, logListLogRequest.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(format, page, query, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogListLogRequest {\n");
    sb.append("    format: ").append(toIndentedString(format)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
    openapiFields.add("Format");
    openapiFields.add("Page");
    openapiFields.add("Query");
    openapiFields.add("Size");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to LogListLogRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!LogListLogRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in LogListLogRequest is not found in the empty JSON string", LogListLogRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!LogListLogRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `LogListLogRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Query") != null && !jsonObj.get("Query").isJsonNull()) && !jsonObj.get("Query").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Query` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Query").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!LogListLogRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'LogListLogRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<LogListLogRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(LogListLogRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<LogListLogRequest>() {
           @Override
           public void write(JsonWriter out, LogListLogRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public LogListLogRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of LogListLogRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of LogListLogRequest
  * @throws IOException if the JSON string is invalid with respect to LogListLogRequest
  */
  public static LogListLogRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, LogListLogRequest.class);
  }

 /**
  * Convert an instance of LogListLogRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

