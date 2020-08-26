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
import com.pydio.sdk.core.api.cells.model.JobsActionLog;
import com.pydio.sdk.core.api.cells.model.JobsTaskStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobsTask
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class JobsTask {
  @SerializedName("ID")
  private String ID = null;

  @SerializedName("JobID")
  private String jobID = null;

  @SerializedName("Status")
  private JobsTaskStatus status = null;

  @SerializedName("StatusMessage")
  private String statusMessage = null;

  @SerializedName("TriggerOwner")
  private String triggerOwner = null;

  @SerializedName("StartTime")
  private Integer startTime = null;

  @SerializedName("EndTime")
  private Integer endTime = null;

  @SerializedName("CanStop")
  private Boolean canStop = null;

  @SerializedName("CanPause")
  private Boolean canPause = null;

  @SerializedName("HasProgress")
  private Boolean hasProgress = null;

  @SerializedName("Progress")
  private Float progress = null;

  @SerializedName("ActionsLogs")
  private List<JobsActionLog> actionsLogs = null;

  public JobsTask ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @ApiModelProperty(value = "")
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public JobsTask jobID(String jobID) {
    this.jobID = jobID;
    return this;
  }

   /**
   * Get jobID
   * @return jobID
  **/
  @ApiModelProperty(value = "")
  public String getJobID() {
    return jobID;
  }

  public void setJobID(String jobID) {
    this.jobID = jobID;
  }

  public JobsTask status(JobsTaskStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public JobsTaskStatus getStatus() {
    return status;
  }

  public void setStatus(JobsTaskStatus status) {
    this.status = status;
  }

  public JobsTask statusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
    return this;
  }

   /**
   * Get statusMessage
   * @return statusMessage
  **/
  @ApiModelProperty(value = "")
  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public JobsTask triggerOwner(String triggerOwner) {
    this.triggerOwner = triggerOwner;
    return this;
  }

   /**
   * Get triggerOwner
   * @return triggerOwner
  **/
  @ApiModelProperty(value = "")
  public String getTriggerOwner() {
    return triggerOwner;
  }

  public void setTriggerOwner(String triggerOwner) {
    this.triggerOwner = triggerOwner;
  }

  public JobsTask startTime(Integer startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * Get startTime
   * @return startTime
  **/
  @ApiModelProperty(value = "")
  public Integer getStartTime() {
    return startTime;
  }

  public void setStartTime(Integer startTime) {
    this.startTime = startTime;
  }

  public JobsTask endTime(Integer endTime) {
    this.endTime = endTime;
    return this;
  }

   /**
   * Get endTime
   * @return endTime
  **/
  @ApiModelProperty(value = "")
  public Integer getEndTime() {
    return endTime;
  }

  public void setEndTime(Integer endTime) {
    this.endTime = endTime;
  }

  public JobsTask canStop(Boolean canStop) {
    this.canStop = canStop;
    return this;
  }

   /**
   * Get canStop
   * @return canStop
  **/
  @ApiModelProperty(value = "")
  public Boolean isCanStop() {
    return canStop;
  }

  public void setCanStop(Boolean canStop) {
    this.canStop = canStop;
  }

  public JobsTask canPause(Boolean canPause) {
    this.canPause = canPause;
    return this;
  }

   /**
   * Get canPause
   * @return canPause
  **/
  @ApiModelProperty(value = "")
  public Boolean isCanPause() {
    return canPause;
  }

  public void setCanPause(Boolean canPause) {
    this.canPause = canPause;
  }

  public JobsTask hasProgress(Boolean hasProgress) {
    this.hasProgress = hasProgress;
    return this;
  }

   /**
   * Get hasProgress
   * @return hasProgress
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasProgress() {
    return hasProgress;
  }

  public void setHasProgress(Boolean hasProgress) {
    this.hasProgress = hasProgress;
  }

  public JobsTask progress(Float progress) {
    this.progress = progress;
    return this;
  }

   /**
   * Get progress
   * @return progress
  **/
  @ApiModelProperty(value = "")
  public Float getProgress() {
    return progress;
  }

  public void setProgress(Float progress) {
    this.progress = progress;
  }

  public JobsTask actionsLogs(List<JobsActionLog> actionsLogs) {
    this.actionsLogs = actionsLogs;
    return this;
  }

  public JobsTask addActionsLogsItem(JobsActionLog actionsLogsItem) {
    if (this.actionsLogs == null) {
      this.actionsLogs = new ArrayList<JobsActionLog>();
    }
    this.actionsLogs.add(actionsLogsItem);
    return this;
  }

   /**
   * Get actionsLogs
   * @return actionsLogs
  **/
  @ApiModelProperty(value = "")
  public List<JobsActionLog> getActionsLogs() {
    return actionsLogs;
  }

  public void setActionsLogs(List<JobsActionLog> actionsLogs) {
    this.actionsLogs = actionsLogs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsTask jobsTask = (JobsTask) o;
    return Objects.equals(this.ID, jobsTask.ID) &&
        Objects.equals(this.jobID, jobsTask.jobID) &&
        Objects.equals(this.status, jobsTask.status) &&
        Objects.equals(this.statusMessage, jobsTask.statusMessage) &&
        Objects.equals(this.triggerOwner, jobsTask.triggerOwner) &&
        Objects.equals(this.startTime, jobsTask.startTime) &&
        Objects.equals(this.endTime, jobsTask.endTime) &&
        Objects.equals(this.canStop, jobsTask.canStop) &&
        Objects.equals(this.canPause, jobsTask.canPause) &&
        Objects.equals(this.hasProgress, jobsTask.hasProgress) &&
        Objects.equals(this.progress, jobsTask.progress) &&
        Objects.equals(this.actionsLogs, jobsTask.actionsLogs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, jobID, status, statusMessage, triggerOwner, startTime, endTime, canStop, canPause, hasProgress, progress, actionsLogs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsTask {\n");
    
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    jobID: ").append(toIndentedString(jobID)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusMessage: ").append(toIndentedString(statusMessage)).append("\n");
    sb.append("    triggerOwner: ").append(toIndentedString(triggerOwner)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    canStop: ").append(toIndentedString(canStop)).append("\n");
    sb.append("    canPause: ").append(toIndentedString(canPause)).append("\n");
    sb.append("    hasProgress: ").append(toIndentedString(hasProgress)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    actionsLogs: ").append(toIndentedString(actionsLogs)).append("\n");
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

