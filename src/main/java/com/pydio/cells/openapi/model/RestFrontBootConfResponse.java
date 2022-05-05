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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestFrontBootConfResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class RestFrontBootConfResponse {
  public static final String SERIALIZED_NAME_JSON_DATA = "JsonData";
  @SerializedName(SERIALIZED_NAME_JSON_DATA)
  private Map<String, String> jsonData = null;

  public RestFrontBootConfResponse() { 
  }

  public RestFrontBootConfResponse jsonData(Map<String, String> jsonData) {
    
    this.jsonData = jsonData;
    return this;
  }

  public RestFrontBootConfResponse putJsonDataItem(String key, String jsonDataItem) {
    if (this.jsonData == null) {
      this.jsonData = new HashMap<String, String>();
    }
    this.jsonData.put(key, jsonDataItem);
    return this;
  }

   /**
   * Get jsonData
   * @return jsonData
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, String> getJsonData() {
    return jsonData;
  }


  public void setJsonData(Map<String, String> jsonData) {
    this.jsonData = jsonData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestFrontBootConfResponse restFrontBootConfResponse = (RestFrontBootConfResponse) o;
    return Objects.equals(this.jsonData, restFrontBootConfResponse.jsonData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestFrontBootConfResponse {\n");
    sb.append("    jsonData: ").append(toIndentedString(jsonData)).append("\n");
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

}

