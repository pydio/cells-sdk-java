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
import com.pydio.sdk.core.api.cells.model.JobsCommand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JobsCtrlCommand
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class JobsCtrlCommand {
  @SerializedName("Cmd")
  private JobsCommand cmd = null;

  @SerializedName("JobId")
  private String jobId = null;

  @SerializedName("TaskId")
  private String taskId = null;

  @SerializedName("OwnerId")
  private String ownerId = null;

  @SerializedName("RunParameters")
  private Map<String, String> runParameters = null;

  public JobsCtrlCommand cmd(JobsCommand cmd) {
    this.cmd = cmd;
    return this;
  }

   /**
   * Get cmd
   * @return cmd
  **/
  @ApiModelProperty(value = "")
  public JobsCommand getCmd() {
    return cmd;
  }

  public void setCmd(JobsCommand cmd) {
    this.cmd = cmd;
  }

  public JobsCtrlCommand jobId(String jobId) {
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @ApiModelProperty(value = "")
  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public JobsCtrlCommand taskId(String taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * Get taskId
   * @return taskId
  **/
  @ApiModelProperty(value = "")
  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public JobsCtrlCommand ownerId(String ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(value = "")
  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  public JobsCtrlCommand runParameters(Map<String, String> runParameters) {
    this.runParameters = runParameters;
    return this;
  }

  public JobsCtrlCommand putRunParametersItem(String key, String runParametersItem) {
    if (this.runParameters == null) {
      this.runParameters = new HashMap<String, String>();
    }
    this.runParameters.put(key, runParametersItem);
    return this;
  }

   /**
   * Get runParameters
   * @return runParameters
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getRunParameters() {
    return runParameters;
  }

  public void setRunParameters(Map<String, String> runParameters) {
    this.runParameters = runParameters;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsCtrlCommand jobsCtrlCommand = (JobsCtrlCommand) o;
    return Objects.equals(this.cmd, jobsCtrlCommand.cmd) &&
        Objects.equals(this.jobId, jobsCtrlCommand.jobId) &&
        Objects.equals(this.taskId, jobsCtrlCommand.taskId) &&
        Objects.equals(this.ownerId, jobsCtrlCommand.ownerId) &&
        Objects.equals(this.runParameters, jobsCtrlCommand.runParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cmd, jobId, taskId, ownerId, runParameters);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsCtrlCommand {\n");
    
    sb.append("    cmd: ").append(toIndentedString(cmd)).append("\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    runParameters: ").append(toIndentedString(runParameters)).append("\n");
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
