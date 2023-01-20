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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * JobsDeleteTasksRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class JobsDeleteTasksRequest {
  public static final String SERIALIZED_NAME_JOB_ID = "JobId";
  @SerializedName(SERIALIZED_NAME_JOB_ID)
  private String jobId;

  public static final String SERIALIZED_NAME_PRUNE_LIMIT = "PruneLimit";
  @SerializedName(SERIALIZED_NAME_PRUNE_LIMIT)
  private Integer pruneLimit;

  public static final String SERIALIZED_NAME_STATUS = "Status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private List<JobsTaskStatus> status = null;

  public static final String SERIALIZED_NAME_TASK_I_D = "TaskID";
  @SerializedName(SERIALIZED_NAME_TASK_I_D)
  private List<String> taskID = null;

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


  public JobsDeleteTasksRequest status(List<JobsTaskStatus> status) {
    
    this.status = status;
    return this;
  }

  public JobsDeleteTasksRequest addStatusItem(JobsTaskStatus statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<>();
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


  public JobsDeleteTasksRequest taskID(List<String> taskID) {
    
    this.taskID = taskID;
    return this;
  }

  public JobsDeleteTasksRequest addTaskIDItem(String taskIDItem) {
    if (this.taskID == null) {
      this.taskID = new ArrayList<>();
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
        Objects.equals(this.pruneLimit, jobsDeleteTasksRequest.pruneLimit) &&
        Objects.equals(this.status, jobsDeleteTasksRequest.status) &&
        Objects.equals(this.taskID, jobsDeleteTasksRequest.taskID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobId, pruneLimit, status, taskID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsDeleteTasksRequest {\n");
    sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
    sb.append("    pruneLimit: ").append(toIndentedString(pruneLimit)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    taskID: ").append(toIndentedString(taskID)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("JobId");
    openapiFields.add("PruneLimit");
    openapiFields.add("Status");
    openapiFields.add("TaskID");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to JobsDeleteTasksRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!JobsDeleteTasksRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JobsDeleteTasksRequest is not found in the empty JSON string", JobsDeleteTasksRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!JobsDeleteTasksRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JobsDeleteTasksRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("JobId") != null && !jsonObj.get("JobId").isJsonNull()) && !jsonObj.get("JobId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `JobId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("JobId").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("Status") != null && !jsonObj.get("Status").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `Status` to be an array in the JSON string but got `%s`", jsonObj.get("Status").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("TaskID") != null && !jsonObj.get("TaskID").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `TaskID` to be an array in the JSON string but got `%s`", jsonObj.get("TaskID").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JobsDeleteTasksRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JobsDeleteTasksRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JobsDeleteTasksRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JobsDeleteTasksRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<JobsDeleteTasksRequest>() {
           @Override
           public void write(JsonWriter out, JobsDeleteTasksRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JobsDeleteTasksRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of JobsDeleteTasksRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of JobsDeleteTasksRequest
  * @throws IOException if the JSON string is invalid with respect to JobsDeleteTasksRequest
  */
  public static JobsDeleteTasksRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JobsDeleteTasksRequest.class);
  }

 /**
  * Convert an instance of JobsDeleteTasksRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

