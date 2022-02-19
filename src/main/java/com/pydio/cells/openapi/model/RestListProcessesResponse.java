/*
 * Pydio Cells Rest API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0
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
import com.pydio.cells.openapi.model.RestProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestListProcessesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestListProcessesResponse {
  public static final String SERIALIZED_NAME_PROCESSES = "Processes";
  @SerializedName(SERIALIZED_NAME_PROCESSES)
  private List<RestProcess> processes = null;

  public RestListProcessesResponse() { 
  }

  public RestListProcessesResponse processes(List<RestProcess> processes) {
    
    this.processes = processes;
    return this;
  }

  public RestListProcessesResponse addProcessesItem(RestProcess processesItem) {
    if (this.processes == null) {
      this.processes = new ArrayList<RestProcess>();
    }
    this.processes.add(processesItem);
    return this;
  }

   /**
   * Get processes
   * @return processes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<RestProcess> getProcesses() {
    return processes;
  }


  public void setProcesses(List<RestProcess> processes) {
    this.processes = processes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestListProcessesResponse restListProcessesResponse = (RestListProcessesResponse) o;
    return Objects.equals(this.processes, restListProcessesResponse.processes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(processes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListProcessesResponse {\n");
    sb.append("    processes: ").append(toIndentedString(processes)).append("\n");
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

