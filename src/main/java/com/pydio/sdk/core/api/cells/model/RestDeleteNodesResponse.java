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
import com.pydio.sdk.core.api.cells.model.RestBackgroundJobResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestDeleteNodesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class RestDeleteNodesResponse {
  @SerializedName("DeleteJobs")
  private List<RestBackgroundJobResult> deleteJobs = null;

  public RestDeleteNodesResponse deleteJobs(List<RestBackgroundJobResult> deleteJobs) {
    this.deleteJobs = deleteJobs;
    return this;
  }

  public RestDeleteNodesResponse addDeleteJobsItem(RestBackgroundJobResult deleteJobsItem) {
    if (this.deleteJobs == null) {
      this.deleteJobs = new ArrayList<RestBackgroundJobResult>();
    }
    this.deleteJobs.add(deleteJobsItem);
    return this;
  }

   /**
   * Get deleteJobs
   * @return deleteJobs
  **/
  @ApiModelProperty(value = "")
  public List<RestBackgroundJobResult> getDeleteJobs() {
    return deleteJobs;
  }

  public void setDeleteJobs(List<RestBackgroundJobResult> deleteJobs) {
    this.deleteJobs = deleteJobs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestDeleteNodesResponse restDeleteNodesResponse = (RestDeleteNodesResponse) o;
    return Objects.equals(this.deleteJobs, restDeleteNodesResponse.deleteJobs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteJobs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDeleteNodesResponse {\n");
    
    sb.append("    deleteJobs: ").append(toIndentedString(deleteJobs)).append("\n");
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

