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


package com.pydio.cells.openapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.ObjectDataSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestListStorageBucketsRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestListStorageBucketsRequest {
  @SerializedName("DataSource")
  private ObjectDataSource dataSource = null;

  @SerializedName("BucketsRegexp")
  private String bucketsRegexp = null;

  public RestListStorageBucketsRequest dataSource(ObjectDataSource dataSource) {
    this.dataSource = dataSource;
    return this;
  }

   /**
   * Get dataSource
   * @return dataSource
  **/
  @ApiModelProperty(value = "")
  public ObjectDataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(ObjectDataSource dataSource) {
    this.dataSource = dataSource;
  }

  public RestListStorageBucketsRequest bucketsRegexp(String bucketsRegexp) {
    this.bucketsRegexp = bucketsRegexp;
    return this;
  }

   /**
   * Get bucketsRegexp
   * @return bucketsRegexp
  **/
  @ApiModelProperty(value = "")
  public String getBucketsRegexp() {
    return bucketsRegexp;
  }

  public void setBucketsRegexp(String bucketsRegexp) {
    this.bucketsRegexp = bucketsRegexp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestListStorageBucketsRequest restListStorageBucketsRequest = (RestListStorageBucketsRequest) o;
    return Objects.equals(this.dataSource, restListStorageBucketsRequest.dataSource) &&
        Objects.equals(this.bucketsRegexp, restListStorageBucketsRequest.bucketsRegexp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSource, bucketsRegexp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListStorageBucketsRequest {\n");
    
    sb.append("    dataSource: ").append(toIndentedString(dataSource)).append("\n");
    sb.append("    bucketsRegexp: ").append(toIndentedString(bucketsRegexp)).append("\n");
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
