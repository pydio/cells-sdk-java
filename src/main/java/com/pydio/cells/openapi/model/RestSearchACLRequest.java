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
 * RestSearchACLRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestSearchACLRequest {
  public static final String SERIALIZED_NAME_COUNT_ONLY = "CountOnly";
  @SerializedName(SERIALIZED_NAME_COUNT_ONLY)
  private Boolean countOnly;

  public static final String SERIALIZED_NAME_GROUP_BY = "GroupBy";
  @SerializedName(SERIALIZED_NAME_GROUP_BY)
  private Integer groupBy;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private String limit;

  public static final String SERIALIZED_NAME_OFFSET = "Offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private String offset;

  public static final String SERIALIZED_NAME_OPERATION = "Operation";
  @SerializedName(SERIALIZED_NAME_OPERATION)
  private ServiceOperationType operation = ServiceOperationType.OR;

  public static final String SERIALIZED_NAME_QUERIES = "Queries";
  @SerializedName(SERIALIZED_NAME_QUERIES)
  private List<IdmACLSingleQuery> queries;

  public RestSearchACLRequest() {
  }

  public RestSearchACLRequest countOnly(Boolean countOnly) {
    
    this.countOnly = countOnly;
    return this;
  }

   /**
   * Get countOnly
   * @return countOnly
  **/
  @javax.annotation.Nullable

  public Boolean getCountOnly() {
    return countOnly;
  }


  public void setCountOnly(Boolean countOnly) {
    this.countOnly = countOnly;
  }


  public RestSearchACLRequest groupBy(Integer groupBy) {
    
    this.groupBy = groupBy;
    return this;
  }

   /**
   * Get groupBy
   * @return groupBy
  **/
  @javax.annotation.Nullable

  public Integer getGroupBy() {
    return groupBy;
  }


  public void setGroupBy(Integer groupBy) {
    this.groupBy = groupBy;
  }


  public RestSearchACLRequest limit(String limit) {
    
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable

  public String getLimit() {
    return limit;
  }


  public void setLimit(String limit) {
    this.limit = limit;
  }


  public RestSearchACLRequest offset(String offset) {
    
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @javax.annotation.Nullable

  public String getOffset() {
    return offset;
  }


  public void setOffset(String offset) {
    this.offset = offset;
  }


  public RestSearchACLRequest operation(ServiceOperationType operation) {
    
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @javax.annotation.Nullable

  public ServiceOperationType getOperation() {
    return operation;
  }


  public void setOperation(ServiceOperationType operation) {
    this.operation = operation;
  }


  public RestSearchACLRequest queries(List<IdmACLSingleQuery> queries) {
    
    this.queries = queries;
    return this;
  }

  public RestSearchACLRequest addQueriesItem(IdmACLSingleQuery queriesItem) {
    if (this.queries == null) {
      this.queries = new ArrayList<>();
    }
    this.queries.add(queriesItem);
    return this;
  }

   /**
   * Get queries
   * @return queries
  **/
  @javax.annotation.Nullable

  public List<IdmACLSingleQuery> getQueries() {
    return queries;
  }


  public void setQueries(List<IdmACLSingleQuery> queries) {
    this.queries = queries;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSearchACLRequest restSearchACLRequest = (RestSearchACLRequest) o;
    return Objects.equals(this.countOnly, restSearchACLRequest.countOnly) &&
        Objects.equals(this.groupBy, restSearchACLRequest.groupBy) &&
        Objects.equals(this.limit, restSearchACLRequest.limit) &&
        Objects.equals(this.offset, restSearchACLRequest.offset) &&
        Objects.equals(this.operation, restSearchACLRequest.operation) &&
        Objects.equals(this.queries, restSearchACLRequest.queries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countOnly, groupBy, limit, offset, operation, queries);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSearchACLRequest {\n");
    sb.append("    countOnly: ").append(toIndentedString(countOnly)).append("\n");
    sb.append("    groupBy: ").append(toIndentedString(groupBy)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
    sb.append("    queries: ").append(toIndentedString(queries)).append("\n");
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
    openapiFields.add("CountOnly");
    openapiFields.add("GroupBy");
    openapiFields.add("Limit");
    openapiFields.add("Offset");
    openapiFields.add("Operation");
    openapiFields.add("Queries");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestSearchACLRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestSearchACLRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestSearchACLRequest is not found in the empty JSON string", RestSearchACLRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestSearchACLRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestSearchACLRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Limit") != null && !jsonObj.get("Limit").isJsonNull()) && !jsonObj.get("Limit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Limit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Limit").toString()));
      }
      if ((jsonObj.get("Offset") != null && !jsonObj.get("Offset").isJsonNull()) && !jsonObj.get("Offset").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Offset` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Offset").toString()));
      }
      if (jsonObj.get("Queries") != null && !jsonObj.get("Queries").isJsonNull()) {
        JsonArray jsonArrayqueries = jsonObj.getAsJsonArray("Queries");
        if (jsonArrayqueries != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Queries").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Queries` to be an array in the JSON string but got `%s`", jsonObj.get("Queries").toString()));
          }

          // validate the optional field `Queries` (array)
          for (int i = 0; i < jsonArrayqueries.size(); i++) {
            IdmACLSingleQuery.validateJsonObject(jsonArrayqueries.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestSearchACLRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestSearchACLRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestSearchACLRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestSearchACLRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestSearchACLRequest>() {
           @Override
           public void write(JsonWriter out, RestSearchACLRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestSearchACLRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestSearchACLRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestSearchACLRequest
  * @throws IOException if the JSON string is invalid with respect to RestSearchACLRequest
  */
  public static RestSearchACLRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestSearchACLRequest.class);
  }

 /**
  * Convert an instance of RestSearchACLRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

