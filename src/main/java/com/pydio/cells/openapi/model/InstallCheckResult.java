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

/**
 * InstallCheckResult
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class InstallCheckResult {
  public static final String SERIALIZED_NAME_JSON_RESULT = "JsonResult";
  @SerializedName(SERIALIZED_NAME_JSON_RESULT)
  private String jsonResult;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_SUCCESS = "Success";
  @SerializedName(SERIALIZED_NAME_SUCCESS)
  private Boolean success;

  public InstallCheckResult() { 
  }

  public InstallCheckResult jsonResult(String jsonResult) {
    
    this.jsonResult = jsonResult;
    return this;
  }

   /**
   * Get jsonResult
   * @return jsonResult
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJsonResult() {
    return jsonResult;
  }


  public void setJsonResult(String jsonResult) {
    this.jsonResult = jsonResult;
  }


  public InstallCheckResult name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public InstallCheckResult success(Boolean success) {
    
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getSuccess() {
    return success;
  }


  public void setSuccess(Boolean success) {
    this.success = success;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallCheckResult installCheckResult = (InstallCheckResult) o;
    return Objects.equals(this.jsonResult, installCheckResult.jsonResult) &&
        Objects.equals(this.name, installCheckResult.name) &&
        Objects.equals(this.success, installCheckResult.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jsonResult, name, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallCheckResult {\n");
    sb.append("    jsonResult: ").append(toIndentedString(jsonResult)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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

