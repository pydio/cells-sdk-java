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
 * RestDeleteResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class RestDeleteResponse {
  public static final String SERIALIZED_NAME_NUM_ROWS = "NumRows";
  @SerializedName(SERIALIZED_NAME_NUM_ROWS)
  private String numRows;

  public static final String SERIALIZED_NAME_SUCCESS = "Success";
  @SerializedName(SERIALIZED_NAME_SUCCESS)
  private Boolean success;

  public RestDeleteResponse() { 
  }

  public RestDeleteResponse numRows(String numRows) {
    
    this.numRows = numRows;
    return this;
  }

   /**
   * Get numRows
   * @return numRows
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNumRows() {
    return numRows;
  }


  public void setNumRows(String numRows) {
    this.numRows = numRows;
  }


  public RestDeleteResponse success(Boolean success) {
    
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
    RestDeleteResponse restDeleteResponse = (RestDeleteResponse) o;
    return Objects.equals(this.numRows, restDeleteResponse.numRows) &&
        Objects.equals(this.success, restDeleteResponse.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numRows, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDeleteResponse {\n");
    sb.append("    numRows: ").append(toIndentedString(numRows)).append("\n");
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

