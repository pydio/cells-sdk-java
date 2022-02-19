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
import com.pydio.cells.openapi.model.JobsTaskStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobsDeleteTasksRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class JobsDeleteTasksRequest {
  public static final String SERIALIZED_NAME_JOB_ID = "JobId";
  @SerializedName(SERIALIZED_NAME_JOB_ID)
  private String jobId;

  public static final String SERIALIZED_NAME_TASK_I_D = "TaskID";
  @SerializedName(SERIALIZED_NAME_TASK_I_D)
  private List<String> taskID = null;

  public static final String SERIALIZED_NAME_STATUS = "Status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private List<JobsTaskStatus> status = null;

  public static final String SERIALIZED_NAME_PRUNE_LIMIT = "PruneLimit";
  @SerializedName(SERIALIZED_NAME_PRUNE_LIMIT)
  private Integer pruneLimit;

  public JobsDeleteTasksRequest() { 
  }

  public JobsDeleteTasksRequest jobId(String jobId) {
    
    this.jobId = jobId;
    return this;
  }

   /**
   * Get jobId
   * @return jobId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJobId() {
    return jobId;
  }


  public void setJobId(String jobId) {
    this.jobId = jobId;
  }


  public JobsDeleteTasksRequest taskID(List<String> taskID) {
    
    this.taskID = taskID;
    return this;
  }

  public JobsDeleteTasksRequest addTaskIDItem(String taskIDItem) {
    if (this.taskID == null) {
      this.taskID = new ArrayList<String>();
    }
    this.taskID.add(taskIDItem);
    return this;
  }

   /**
   * Get taskID
   * @return taskID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getTaskID() {
    return taskID;
  }


  public void setTaskID(List<String> taskID) {
    this.taskID = taskID;
  }


  public JobsDeleteTasksRequest status(List<JobsTaskStatus> status) {
    
    this.status = status;
    return this;
  }

  public JobsDeleteTasksRequest addStatusItem(JobsTaskStatus statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<JobsTaskStatus>();
    }
    this.status.add(statusItem);
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<JobsTaskStatus> getStatus() {
    return status;
  }


  public void setStatus(List<JobsTaskStatus> status) {
    this.status = status;
  }


  public JobsDeleteTasksRequest pruneLimit(Integer pruneLimit) {
    
    this.pruneLimit = pruneLimit;
    return this;
  }

   /**
   * Get pruneLimit
   * @return pruneLimit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getPruneLimit() {
    return pruneLimit;
  }


  public void setPruneLimit(Integer pruneLimit) {
    this.pruneLimit = pruneLimit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsDeleteTasksRequest jobsDeleteTasksRequest = (JobsDeleteTasksRequest) o;
    return Objects.equals(this.jobId, jobsDeleteTasksRequest.jobId) &&
        Objects.equals(this.taskID, jobsDeleteTasksRequest.taskID) &&
        Objects.equals(this.status, jobsDeleteTasksRequest.status) &&
        Objects.equals(this.pruneLimit, jobsDeleteTasksRequest.pruneLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, taskID, status, pruneLimit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsDeleteTasksRequest {\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    taskID: ").append(toIndentedString(taskID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    pruneLimit: ").append(toIndentedString(pruneLimit)).append("\n");
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

