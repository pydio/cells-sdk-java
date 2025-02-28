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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * JobsCtrlCommand
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class JobsCtrlCommand {
    public static final String SERIALIZED_NAME_CMD = "Cmd";
    @SerializedName(SERIALIZED_NAME_CMD)
    @javax.annotation.Nullable
    private JobsCommand cmd = JobsCommand.NONE;

    public static final String SERIALIZED_NAME_JOB_ID = "JobId";
    @SerializedName(SERIALIZED_NAME_JOB_ID)
    @javax.annotation.Nullable
    private String jobId;

    public static final String SERIALIZED_NAME_OWNER_ID = "OwnerId";
    @SerializedName(SERIALIZED_NAME_OWNER_ID)
    @javax.annotation.Nullable
    private String ownerId;

    public static final String SERIALIZED_NAME_RUN_PARAMETERS = "RunParameters";
    @SerializedName(SERIALIZED_NAME_RUN_PARAMETERS)
    @javax.annotation.Nullable
    private Map<String, String> runParameters = new HashMap<>();

    public static final String SERIALIZED_NAME_TASK_ID = "TaskId";
    @SerializedName(SERIALIZED_NAME_TASK_ID)
    @javax.annotation.Nullable
    private String taskId;

    public JobsCtrlCommand() {
    }

    public JobsCtrlCommand cmd(@javax.annotation.Nullable JobsCommand cmd) {
        this.cmd = cmd;
        return this;
    }

    /**
     * Get cmd
     *
     * @return cmd
     */
    @javax.annotation.Nullable
    public JobsCommand getCmd() {
        return cmd;
    }

    public void setCmd(@javax.annotation.Nullable JobsCommand cmd) {
        this.cmd = cmd;
    }


    public JobsCtrlCommand jobId(@javax.annotation.Nullable String jobId) {
        this.jobId = jobId;
        return this;
    }

    /**
     * Get jobId
     *
     * @return jobId
     */
    @javax.annotation.Nullable
    public String getJobId() {
        return jobId;
    }

    public void setJobId(@javax.annotation.Nullable String jobId) {
        this.jobId = jobId;
    }


    public JobsCtrlCommand ownerId(@javax.annotation.Nullable String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    /**
     * Get ownerId
     *
     * @return ownerId
     */
    @javax.annotation.Nullable
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@javax.annotation.Nullable String ownerId) {
        this.ownerId = ownerId;
    }


    public JobsCtrlCommand runParameters(@javax.annotation.Nullable Map<String, String> runParameters) {
        this.runParameters = runParameters;
        return this;
    }

    public JobsCtrlCommand putRunParametersItem(String key, String runParametersItem) {
        if (this.runParameters == null) {
            this.runParameters = new HashMap<>();
        }
        this.runParameters.put(key, runParametersItem);
        return this;
    }

    /**
     * Get runParameters
     *
     * @return runParameters
     */
    @javax.annotation.Nullable
    public Map<String, String> getRunParameters() {
        return runParameters;
    }

    public void setRunParameters(@javax.annotation.Nullable Map<String, String> runParameters) {
        this.runParameters = runParameters;
    }


    public JobsCtrlCommand taskId(@javax.annotation.Nullable String taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * Get taskId
     *
     * @return taskId
     */
    @javax.annotation.Nullable
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(@javax.annotation.Nullable String taskId) {
        this.taskId = taskId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobsCtrlCommand jobsCtrlCommand = (JobsCtrlCommand) o;
        return Objects.equals(this.cmd, jobsCtrlCommand.cmd) &&
                Objects.equals(this.jobId, jobsCtrlCommand.jobId) &&
                Objects.equals(this.ownerId, jobsCtrlCommand.ownerId) &&
                Objects.equals(this.runParameters, jobsCtrlCommand.runParameters) &&
                Objects.equals(this.taskId, jobsCtrlCommand.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cmd, jobId, ownerId, runParameters, taskId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JobsCtrlCommand {\n");
        sb.append("    cmd: ").append(toIndentedString(cmd)).append("\n");
        sb.append("    jobId: ").append(toIndentedString(jobId)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
        sb.append("    runParameters: ").append(toIndentedString(runParameters)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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
        openapiFields.add("Cmd");
        openapiFields.add("JobId");
        openapiFields.add("OwnerId");
        openapiFields.add("RunParameters");
        openapiFields.add("TaskId");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to JobsCtrlCommand
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!JobsCtrlCommand.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in JobsCtrlCommand is not found in the empty JSON string", JobsCtrlCommand.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!JobsCtrlCommand.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JobsCtrlCommand` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the optional field `Cmd`
        if (jsonObj.get("Cmd") != null && !jsonObj.get("Cmd").isJsonNull()) {
            JobsCommand.validateJsonElement(jsonObj.get("Cmd"));
        }
        if ((jsonObj.get("JobId") != null && !jsonObj.get("JobId").isJsonNull()) && !jsonObj.get("JobId").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `JobId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("JobId").toString()));
        }
        if ((jsonObj.get("OwnerId") != null && !jsonObj.get("OwnerId").isJsonNull()) && !jsonObj.get("OwnerId").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `OwnerId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OwnerId").toString()));
        }
        if ((jsonObj.get("TaskId") != null && !jsonObj.get("TaskId").isJsonNull()) && !jsonObj.get("TaskId").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `TaskId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("TaskId").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!JobsCtrlCommand.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'JobsCtrlCommand' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<JobsCtrlCommand> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(JobsCtrlCommand.class));

            return (TypeAdapter<T>) new TypeAdapter<JobsCtrlCommand>() {
                @Override
                public void write(JsonWriter out, JobsCtrlCommand value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public JobsCtrlCommand read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of JobsCtrlCommand given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of JobsCtrlCommand
     * @throws IOException if the JSON string is invalid with respect to JobsCtrlCommand
     */
    public static JobsCtrlCommand fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, JobsCtrlCommand.class);
    }

    /**
     * Convert an instance of JobsCtrlCommand to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

