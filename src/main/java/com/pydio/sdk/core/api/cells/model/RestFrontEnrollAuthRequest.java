/*
 * Pydio Cells Rest API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.pydio.sdk.core.api.cells.model;

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
 * RestFrontEnrollAuthRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class RestFrontEnrollAuthRequest {
  @SerializedName("EnrollType")
  private String enrollType = null;

  @SerializedName("EnrollInfo")
  private Map<String, String> enrollInfo = null;

  public RestFrontEnrollAuthRequest enrollType(String enrollType) {
    this.enrollType = enrollType;
    return this;
  }

   /**
   * Get enrollType
   * @return enrollType
  **/
  @ApiModelProperty(value = "")
  public String getEnrollType() {
    return enrollType;
  }

  public void setEnrollType(String enrollType) {
    this.enrollType = enrollType;
  }

  public RestFrontEnrollAuthRequest enrollInfo(Map<String, String> enrollInfo) {
    this.enrollInfo = enrollInfo;
    return this;
  }

  public RestFrontEnrollAuthRequest putEnrollInfoItem(String key, String enrollInfoItem) {
    if (this.enrollInfo == null) {
      this.enrollInfo = new HashMap<String, String>();
    }
    this.enrollInfo.put(key, enrollInfoItem);
    return this;
  }

   /**
   * Get enrollInfo
   * @return enrollInfo
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getEnrollInfo() {
    return enrollInfo;
  }

  public void setEnrollInfo(Map<String, String> enrollInfo) {
    this.enrollInfo = enrollInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestFrontEnrollAuthRequest restFrontEnrollAuthRequest = (RestFrontEnrollAuthRequest) o;
    return Objects.equals(this.enrollType, restFrontEnrollAuthRequest.enrollType) &&
        Objects.equals(this.enrollInfo, restFrontEnrollAuthRequest.enrollInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enrollType, enrollInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestFrontEnrollAuthRequest {\n");
    
    sb.append("    enrollType: ").append(toIndentedString(enrollType)).append("\n");
    sb.append("    enrollInfo: ").append(toIndentedString(enrollInfo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

