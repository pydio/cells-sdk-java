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
import com.pydio.cells.openapi.model.RestBackgroundJobResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestRestoreNodesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class RestRestoreNodesResponse {
  @SerializedName("RestoreJobs")
  private List<RestBackgroundJobResult> restoreJobs = null;

  public RestRestoreNodesResponse restoreJobs(List<RestBackgroundJobResult> restoreJobs) {
    this.restoreJobs = restoreJobs;
    return this;
  }

  public RestRestoreNodesResponse addRestoreJobsItem(RestBackgroundJobResult restoreJobsItem) {
    if (this.restoreJobs == null) {
      this.restoreJobs = new ArrayList<RestBackgroundJobResult>();
    }
    this.restoreJobs.add(restoreJobsItem);
    return this;
  }

   /**
   * Get restoreJobs
   * @return restoreJobs
  **/
  @ApiModelProperty(value = "")
  public List<RestBackgroundJobResult> getRestoreJobs() {
    return restoreJobs;
  }

  public void setRestoreJobs(List<RestBackgroundJobResult> restoreJobs) {
    this.restoreJobs = restoreJobs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestRestoreNodesResponse restRestoreNodesResponse = (RestRestoreNodesResponse) o;
    return Objects.equals(this.restoreJobs, restRestoreNodesResponse.restoreJobs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(restoreJobs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRestoreNodesResponse {\n");
    
    sb.append("    restoreJobs: ").append(toIndentedString(restoreJobs)).append("\n");
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

