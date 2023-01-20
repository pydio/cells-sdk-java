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
 * RestRecommendRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestRecommendRequest {
  public static final String SERIALIZED_NAME_CATEGORY = "Category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private String category;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private Integer limit;

  public static final String SERIALIZED_NAME_NEIGHBOR = "Neighbor";
  @SerializedName(SERIALIZED_NAME_NEIGHBOR)
  private String neighbor;

  public static final String SERIALIZED_NAME_SEGMENT = "Segment";
  @SerializedName(SERIALIZED_NAME_SEGMENT)
  private String segment;

  public RestRecommendRequest() {
  }

  public RestRecommendRequest category(String category) {
    
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCategory() {
    return category;
  }


  public void setCategory(String category) {
    this.category = category;
  }


  public RestRecommendRequest limit(Integer limit) {
    
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLimit() {
    return limit;
  }


  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  public RestRecommendRequest neighbor(String neighbor) {
    
    this.neighbor = neighbor;
    return this;
  }

   /**
   * Get neighbor
   * @return neighbor
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNeighbor() {
    return neighbor;
  }


  public void setNeighbor(String neighbor) {
    this.neighbor = neighbor;
  }


  public RestRecommendRequest segment(String segment) {
    
    this.segment = segment;
    return this;
  }

   /**
   * Get segment
   * @return segment
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSegment() {
    return segment;
  }


  public void setSegment(String segment) {
    this.segment = segment;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestRecommendRequest restRecommendRequest = (RestRecommendRequest) o;
    return Objects.equals(this.category, restRecommendRequest.category) &&
        Objects.equals(this.limit, restRecommendRequest.limit) &&
        Objects.equals(this.neighbor, restRecommendRequest.neighbor) &&
        Objects.equals(this.segment, restRecommendRequest.segment);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, limit, neighbor, segment);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRecommendRequest {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    neighbor: ").append(toIndentedString(neighbor)).append("\n");
    sb.append("    segment: ").append(toIndentedString(segment)).append("\n");
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
    openapiFields.add("Category");
    openapiFields.add("Limit");
    openapiFields.add("Neighbor");
    openapiFields.add("Segment");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestRecommendRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestRecommendRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestRecommendRequest is not found in the empty JSON string", RestRecommendRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestRecommendRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestRecommendRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Category") != null && !jsonObj.get("Category").isJsonNull()) && !jsonObj.get("Category").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Category` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Category").toString()));
      }
      if ((jsonObj.get("Neighbor") != null && !jsonObj.get("Neighbor").isJsonNull()) && !jsonObj.get("Neighbor").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Neighbor` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Neighbor").toString()));
      }
      if ((jsonObj.get("Segment") != null && !jsonObj.get("Segment").isJsonNull()) && !jsonObj.get("Segment").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Segment` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Segment").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestRecommendRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestRecommendRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestRecommendRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestRecommendRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestRecommendRequest>() {
           @Override
           public void write(JsonWriter out, RestRecommendRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestRecommendRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestRecommendRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestRecommendRequest
  * @throws IOException if the JSON string is invalid with respect to RestRecommendRequest
  */
  public static RestRecommendRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestRecommendRequest.class);
  }

 /**
  * Convert an instance of RestRecommendRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

