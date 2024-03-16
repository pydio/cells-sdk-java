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
import com.google.gson.JsonArray;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * JobsJob
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class JobsJob {
  public static final String SERIALIZED_NAME_ACTIONS = "Actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private List<JobsAction> actions;

  public static final String SERIALIZED_NAME_AUTO_CLEAN = "AutoClean";
  @SerializedName(SERIALIZED_NAME_AUTO_CLEAN)
  private Boolean autoClean;

  public static final String SERIALIZED_NAME_AUTO_RESTART = "AutoRestart";
  @SerializedName(SERIALIZED_NAME_AUTO_RESTART)
  private Boolean autoRestart;

  public static final String SERIALIZED_NAME_AUTO_START = "AutoStart";
  @SerializedName(SERIALIZED_NAME_AUTO_START)
  private Boolean autoStart;

  public static final String SERIALIZED_NAME_CHAT_EVENT_FILTER = "ChatEventFilter";
  @SerializedName(SERIALIZED_NAME_CHAT_EVENT_FILTER)
  private JobsChatEventFilter chatEventFilter;

  public static final String SERIALIZED_NAME_CONTEXT_META_FILTER = "ContextMetaFilter";
  @SerializedName(SERIALIZED_NAME_CONTEXT_META_FILTER)
  private JobsContextMetaFilter contextMetaFilter;

  public static final String SERIALIZED_NAME_CREATED_AT = "CreatedAt";
  @SerializedName(SERIALIZED_NAME_CREATED_AT)
  private Integer createdAt;

  public static final String SERIALIZED_NAME_CUSTOM = "Custom";
  @SerializedName(SERIALIZED_NAME_CUSTOM)
  private Boolean custom;

  public static final String SERIALIZED_NAME_DATA_SOURCE_FILTER = "DataSourceFilter";
  @SerializedName(SERIALIZED_NAME_DATA_SOURCE_FILTER)
  private JobsDataSourceSelector dataSourceFilter;

  public static final String SERIALIZED_NAME_EVENT_NAMES = "EventNames";
  @SerializedName(SERIALIZED_NAME_EVENT_NAMES)
  private List<String> eventNames;

  public static final String SERIALIZED_NAME_HOOKS = "Hooks";
  @SerializedName(SERIALIZED_NAME_HOOKS)
  private List<JobsJobHook> hooks;

  public static final String SERIALIZED_NAME_I_D = "ID";
  @SerializedName(SERIALIZED_NAME_I_D)
  private String ID;

  public static final String SERIALIZED_NAME_IDM_FILTER = "IdmFilter";
  @SerializedName(SERIALIZED_NAME_IDM_FILTER)
  private JobsIdmSelector idmFilter;

  public static final String SERIALIZED_NAME_INACTIVE = "Inactive";
  @SerializedName(SERIALIZED_NAME_INACTIVE)
  private Boolean inactive;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_LANGUAGES = "Languages";
  @SerializedName(SERIALIZED_NAME_LANGUAGES)
  private List<String> languages;

  public static final String SERIALIZED_NAME_MAX_CONCURRENCY = "MaxConcurrency";
  @SerializedName(SERIALIZED_NAME_MAX_CONCURRENCY)
  private Integer maxConcurrency;

  public static final String SERIALIZED_NAME_MERGE_ACTION = "MergeAction";
  @SerializedName(SERIALIZED_NAME_MERGE_ACTION)
  private JobsAction mergeAction;

  public static final String SERIALIZED_NAME_METADATA = "Metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Map<String, String> metadata = new HashMap<>();

  public static final String SERIALIZED_NAME_MODIFIED_AT = "ModifiedAt";
  @SerializedName(SERIALIZED_NAME_MODIFIED_AT)
  private Integer modifiedAt;

  public static final String SERIALIZED_NAME_NODE_EVENT_FILTER = "NodeEventFilter";
  @SerializedName(SERIALIZED_NAME_NODE_EVENT_FILTER)
  private JobsNodesSelector nodeEventFilter;

  public static final String SERIALIZED_NAME_OWNER = "Owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_PARAMETERS = "Parameters";
  @SerializedName(SERIALIZED_NAME_PARAMETERS)
  private List<JobsJobParameter> parameters;

  public static final String SERIALIZED_NAME_RESOURCES_DEPENDENCIES = "ResourcesDependencies";
  @SerializedName(SERIALIZED_NAME_RESOURCES_DEPENDENCIES)
  private List<ProtobufAny> resourcesDependencies;

  public static final String SERIALIZED_NAME_SCHEDULE = "Schedule";
  @SerializedName(SERIALIZED_NAME_SCHEDULE)
  private JobsSchedule schedule;

  public static final String SERIALIZED_NAME_TASKS = "Tasks";
  @SerializedName(SERIALIZED_NAME_TASKS)
  private List<JobsTask> tasks;

  public static final String SERIALIZED_NAME_TASKS_SILENT_UPDATE = "TasksSilentUpdate";
  @SerializedName(SERIALIZED_NAME_TASKS_SILENT_UPDATE)
  private Boolean tasksSilentUpdate;

  public static final String SERIALIZED_NAME_TIMEOUT = "Timeout";
  @SerializedName(SERIALIZED_NAME_TIMEOUT)
  private String timeout;

  public static final String SERIALIZED_NAME_USER_EVENT_FILTER = "UserEventFilter";
  @SerializedName(SERIALIZED_NAME_USER_EVENT_FILTER)
  private JobsUsersSelector userEventFilter;

  public static final String SERIALIZED_NAME_VERSION_META = "VersionMeta";
  @SerializedName(SERIALIZED_NAME_VERSION_META)
  private Map<String, String> versionMeta = new HashMap<>();

  public JobsJob() {
  }

  public JobsJob actions(List<JobsAction> actions) {
    this.actions = actions;
    return this;
  }

  public JobsJob addActionsItem(JobsAction actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<>();
    }
    this.actions.add(actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @javax.annotation.Nullable
  public List<JobsAction> getActions() {
    return actions;
  }

  public void setActions(List<JobsAction> actions) {
    this.actions = actions;
  }


  public JobsJob autoClean(Boolean autoClean) {
    this.autoClean = autoClean;
    return this;
  }

   /**
   * Get autoClean
   * @return autoClean
  **/
  @javax.annotation.Nullable
  public Boolean getAutoClean() {
    return autoClean;
  }

  public void setAutoClean(Boolean autoClean) {
    this.autoClean = autoClean;
  }


  public JobsJob autoRestart(Boolean autoRestart) {
    this.autoRestart = autoRestart;
    return this;
  }

   /**
   * Get autoRestart
   * @return autoRestart
  **/
  @javax.annotation.Nullable
  public Boolean getAutoRestart() {
    return autoRestart;
  }

  public void setAutoRestart(Boolean autoRestart) {
    this.autoRestart = autoRestart;
  }


  public JobsJob autoStart(Boolean autoStart) {
    this.autoStart = autoStart;
    return this;
  }

   /**
   * Get autoStart
   * @return autoStart
  **/
  @javax.annotation.Nullable
  public Boolean getAutoStart() {
    return autoStart;
  }

  public void setAutoStart(Boolean autoStart) {
    this.autoStart = autoStart;
  }


  public JobsJob chatEventFilter(JobsChatEventFilter chatEventFilter) {
    this.chatEventFilter = chatEventFilter;
    return this;
  }

   /**
   * Get chatEventFilter
   * @return chatEventFilter
  **/
  @javax.annotation.Nullable
  public JobsChatEventFilter getChatEventFilter() {
    return chatEventFilter;
  }

  public void setChatEventFilter(JobsChatEventFilter chatEventFilter) {
    this.chatEventFilter = chatEventFilter;
  }


  public JobsJob contextMetaFilter(JobsContextMetaFilter contextMetaFilter) {
    this.contextMetaFilter = contextMetaFilter;
    return this;
  }

   /**
   * Get contextMetaFilter
   * @return contextMetaFilter
  **/
  @javax.annotation.Nullable
  public JobsContextMetaFilter getContextMetaFilter() {
    return contextMetaFilter;
  }

  public void setContextMetaFilter(JobsContextMetaFilter contextMetaFilter) {
    this.contextMetaFilter = contextMetaFilter;
  }


  public JobsJob createdAt(Integer createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  public Integer getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Integer createdAt) {
    this.createdAt = createdAt;
  }


  public JobsJob custom(Boolean custom) {
    this.custom = custom;
    return this;
  }

   /**
   * Get custom
   * @return custom
  **/
  @javax.annotation.Nullable
  public Boolean getCustom() {
    return custom;
  }

  public void setCustom(Boolean custom) {
    this.custom = custom;
  }


  public JobsJob dataSourceFilter(JobsDataSourceSelector dataSourceFilter) {
    this.dataSourceFilter = dataSourceFilter;
    return this;
  }

   /**
   * Get dataSourceFilter
   * @return dataSourceFilter
  **/
  @javax.annotation.Nullable
  public JobsDataSourceSelector getDataSourceFilter() {
    return dataSourceFilter;
  }

  public void setDataSourceFilter(JobsDataSourceSelector dataSourceFilter) {
    this.dataSourceFilter = dataSourceFilter;
  }


  public JobsJob eventNames(List<String> eventNames) {
    this.eventNames = eventNames;
    return this;
  }

  public JobsJob addEventNamesItem(String eventNamesItem) {
    if (this.eventNames == null) {
      this.eventNames = new ArrayList<>();
    }
    this.eventNames.add(eventNamesItem);
    return this;
  }

   /**
   * Get eventNames
   * @return eventNames
  **/
  @javax.annotation.Nullable
  public List<String> getEventNames() {
    return eventNames;
  }

  public void setEventNames(List<String> eventNames) {
    this.eventNames = eventNames;
  }


  public JobsJob hooks(List<JobsJobHook> hooks) {
    this.hooks = hooks;
    return this;
  }

  public JobsJob addHooksItem(JobsJobHook hooksItem) {
    if (this.hooks == null) {
      this.hooks = new ArrayList<>();
    }
    this.hooks.add(hooksItem);
    return this;
  }

   /**
   * Get hooks
   * @return hooks
  **/
  @javax.annotation.Nullable
  public List<JobsJobHook> getHooks() {
    return hooks;
  }

  public void setHooks(List<JobsJobHook> hooks) {
    this.hooks = hooks;
  }


  public JobsJob ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @javax.annotation.Nullable
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }


  public JobsJob idmFilter(JobsIdmSelector idmFilter) {
    this.idmFilter = idmFilter;
    return this;
  }

   /**
   * Get idmFilter
   * @return idmFilter
  **/
  @javax.annotation.Nullable
  public JobsIdmSelector getIdmFilter() {
    return idmFilter;
  }

  public void setIdmFilter(JobsIdmSelector idmFilter) {
    this.idmFilter = idmFilter;
  }


  public JobsJob inactive(Boolean inactive) {
    this.inactive = inactive;
    return this;
  }

   /**
   * Get inactive
   * @return inactive
  **/
  @javax.annotation.Nullable
  public Boolean getInactive() {
    return inactive;
  }

  public void setInactive(Boolean inactive) {
    this.inactive = inactive;
  }


  public JobsJob label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public JobsJob languages(List<String> languages) {
    this.languages = languages;
    return this;
  }

  public JobsJob addLanguagesItem(String languagesItem) {
    if (this.languages == null) {
      this.languages = new ArrayList<>();
    }
    this.languages.add(languagesItem);
    return this;
  }

   /**
   * Get languages
   * @return languages
  **/
  @javax.annotation.Nullable
  public List<String> getLanguages() {
    return languages;
  }

  public void setLanguages(List<String> languages) {
    this.languages = languages;
  }


  public JobsJob maxConcurrency(Integer maxConcurrency) {
    this.maxConcurrency = maxConcurrency;
    return this;
  }

   /**
   * Get maxConcurrency
   * @return maxConcurrency
  **/
  @javax.annotation.Nullable
  public Integer getMaxConcurrency() {
    return maxConcurrency;
  }

  public void setMaxConcurrency(Integer maxConcurrency) {
    this.maxConcurrency = maxConcurrency;
  }


  public JobsJob mergeAction(JobsAction mergeAction) {
    this.mergeAction = mergeAction;
    return this;
  }

   /**
   * Get mergeAction
   * @return mergeAction
  **/
  @javax.annotation.Nullable
  public JobsAction getMergeAction() {
    return mergeAction;
  }

  public void setMergeAction(JobsAction mergeAction) {
    this.mergeAction = mergeAction;
  }


  public JobsJob metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public JobsJob putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Additional user-defined metadata, can be used for icon, documentation, pre-requisites, etc.
   * @return metadata
  **/
  @javax.annotation.Nullable
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public JobsJob modifiedAt(Integer modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

   /**
   * Get modifiedAt
   * @return modifiedAt
  **/
  @javax.annotation.Nullable
  public Integer getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Integer modifiedAt) {
    this.modifiedAt = modifiedAt;
  }


  public JobsJob nodeEventFilter(JobsNodesSelector nodeEventFilter) {
    this.nodeEventFilter = nodeEventFilter;
    return this;
  }

   /**
   * Get nodeEventFilter
   * @return nodeEventFilter
  **/
  @javax.annotation.Nullable
  public JobsNodesSelector getNodeEventFilter() {
    return nodeEventFilter;
  }

  public void setNodeEventFilter(JobsNodesSelector nodeEventFilter) {
    this.nodeEventFilter = nodeEventFilter;
  }


  public JobsJob owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }


  public JobsJob parameters(List<JobsJobParameter> parameters) {
    this.parameters = parameters;
    return this;
  }

  public JobsJob addParametersItem(JobsJobParameter parametersItem) {
    if (this.parameters == null) {
      this.parameters = new ArrayList<>();
    }
    this.parameters.add(parametersItem);
    return this;
  }

   /**
   * Get parameters
   * @return parameters
  **/
  @javax.annotation.Nullable
  public List<JobsJobParameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<JobsJobParameter> parameters) {
    this.parameters = parameters;
  }


  public JobsJob resourcesDependencies(List<ProtobufAny> resourcesDependencies) {
    this.resourcesDependencies = resourcesDependencies;
    return this;
  }

  public JobsJob addResourcesDependenciesItem(ProtobufAny resourcesDependenciesItem) {
    if (this.resourcesDependencies == null) {
      this.resourcesDependencies = new ArrayList<>();
    }
    this.resourcesDependencies.add(resourcesDependenciesItem);
    return this;
  }

   /**
   * Get resourcesDependencies
   * @return resourcesDependencies
  **/
  @javax.annotation.Nullable
  public List<ProtobufAny> getResourcesDependencies() {
    return resourcesDependencies;
  }

  public void setResourcesDependencies(List<ProtobufAny> resourcesDependencies) {
    this.resourcesDependencies = resourcesDependencies;
  }


  public JobsJob schedule(JobsSchedule schedule) {
    this.schedule = schedule;
    return this;
  }

   /**
   * Get schedule
   * @return schedule
  **/
  @javax.annotation.Nullable
  public JobsSchedule getSchedule() {
    return schedule;
  }

  public void setSchedule(JobsSchedule schedule) {
    this.schedule = schedule;
  }


  public JobsJob tasks(List<JobsTask> tasks) {
    this.tasks = tasks;
    return this;
  }

  public JobsJob addTasksItem(JobsTask tasksItem) {
    if (this.tasks == null) {
      this.tasks = new ArrayList<>();
    }
    this.tasks.add(tasksItem);
    return this;
  }

   /**
   * Get tasks
   * @return tasks
  **/
  @javax.annotation.Nullable
  public List<JobsTask> getTasks() {
    return tasks;
  }

  public void setTasks(List<JobsTask> tasks) {
    this.tasks = tasks;
  }


  public JobsJob tasksSilentUpdate(Boolean tasksSilentUpdate) {
    this.tasksSilentUpdate = tasksSilentUpdate;
    return this;
  }

   /**
   * Get tasksSilentUpdate
   * @return tasksSilentUpdate
  **/
  @javax.annotation.Nullable
  public Boolean getTasksSilentUpdate() {
    return tasksSilentUpdate;
  }

  public void setTasksSilentUpdate(Boolean tasksSilentUpdate) {
    this.tasksSilentUpdate = tasksSilentUpdate;
  }


  public JobsJob timeout(String timeout) {
    this.timeout = timeout;
    return this;
  }

   /**
   * Get timeout
   * @return timeout
  **/
  @javax.annotation.Nullable
  public String getTimeout() {
    return timeout;
  }

  public void setTimeout(String timeout) {
    this.timeout = timeout;
  }


  public JobsJob userEventFilter(JobsUsersSelector userEventFilter) {
    this.userEventFilter = userEventFilter;
    return this;
  }

   /**
   * Get userEventFilter
   * @return userEventFilter
  **/
  @javax.annotation.Nullable
  public JobsUsersSelector getUserEventFilter() {
    return userEventFilter;
  }

  public void setUserEventFilter(JobsUsersSelector userEventFilter) {
    this.userEventFilter = userEventFilter;
  }


  public JobsJob versionMeta(Map<String, String> versionMeta) {
    this.versionMeta = versionMeta;
    return this;
  }

  public JobsJob putVersionMetaItem(String key, String versionMetaItem) {
    if (this.versionMeta == null) {
      this.versionMeta = new HashMap<>();
    }
    this.versionMeta.put(key, versionMetaItem);
    return this;
  }

   /**
   * Get versionMeta
   * @return versionMeta
  **/
  @javax.annotation.Nullable
  public Map<String, String> getVersionMeta() {
    return versionMeta;
  }

  public void setVersionMeta(Map<String, String> versionMeta) {
    this.versionMeta = versionMeta;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsJob jobsJob = (JobsJob) o;
    return Objects.equals(this.actions, jobsJob.actions) &&
        Objects.equals(this.autoClean, jobsJob.autoClean) &&
        Objects.equals(this.autoRestart, jobsJob.autoRestart) &&
        Objects.equals(this.autoStart, jobsJob.autoStart) &&
        Objects.equals(this.chatEventFilter, jobsJob.chatEventFilter) &&
        Objects.equals(this.contextMetaFilter, jobsJob.contextMetaFilter) &&
        Objects.equals(this.createdAt, jobsJob.createdAt) &&
        Objects.equals(this.custom, jobsJob.custom) &&
        Objects.equals(this.dataSourceFilter, jobsJob.dataSourceFilter) &&
        Objects.equals(this.eventNames, jobsJob.eventNames) &&
        Objects.equals(this.hooks, jobsJob.hooks) &&
        Objects.equals(this.ID, jobsJob.ID) &&
        Objects.equals(this.idmFilter, jobsJob.idmFilter) &&
        Objects.equals(this.inactive, jobsJob.inactive) &&
        Objects.equals(this.label, jobsJob.label) &&
        Objects.equals(this.languages, jobsJob.languages) &&
        Objects.equals(this.maxConcurrency, jobsJob.maxConcurrency) &&
        Objects.equals(this.mergeAction, jobsJob.mergeAction) &&
        Objects.equals(this.metadata, jobsJob.metadata) &&
        Objects.equals(this.modifiedAt, jobsJob.modifiedAt) &&
        Objects.equals(this.nodeEventFilter, jobsJob.nodeEventFilter) &&
        Objects.equals(this.owner, jobsJob.owner) &&
        Objects.equals(this.parameters, jobsJob.parameters) &&
        Objects.equals(this.resourcesDependencies, jobsJob.resourcesDependencies) &&
        Objects.equals(this.schedule, jobsJob.schedule) &&
        Objects.equals(this.tasks, jobsJob.tasks) &&
        Objects.equals(this.tasksSilentUpdate, jobsJob.tasksSilentUpdate) &&
        Objects.equals(this.timeout, jobsJob.timeout) &&
        Objects.equals(this.userEventFilter, jobsJob.userEventFilter) &&
        Objects.equals(this.versionMeta, jobsJob.versionMeta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actions, autoClean, autoRestart, autoStart, chatEventFilter, contextMetaFilter, createdAt, custom, dataSourceFilter, eventNames, hooks, ID, idmFilter, inactive, label, languages, maxConcurrency, mergeAction, metadata, modifiedAt, nodeEventFilter, owner, parameters, resourcesDependencies, schedule, tasks, tasksSilentUpdate, timeout, userEventFilter, versionMeta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsJob {\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    autoClean: ").append(toIndentedString(autoClean)).append("\n");
    sb.append("    autoRestart: ").append(toIndentedString(autoRestart)).append("\n");
    sb.append("    autoStart: ").append(toIndentedString(autoStart)).append("\n");
    sb.append("    chatEventFilter: ").append(toIndentedString(chatEventFilter)).append("\n");
    sb.append("    contextMetaFilter: ").append(toIndentedString(contextMetaFilter)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    dataSourceFilter: ").append(toIndentedString(dataSourceFilter)).append("\n");
    sb.append("    eventNames: ").append(toIndentedString(eventNames)).append("\n");
    sb.append("    hooks: ").append(toIndentedString(hooks)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    idmFilter: ").append(toIndentedString(idmFilter)).append("\n");
    sb.append("    inactive: ").append(toIndentedString(inactive)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    languages: ").append(toIndentedString(languages)).append("\n");
    sb.append("    maxConcurrency: ").append(toIndentedString(maxConcurrency)).append("\n");
    sb.append("    mergeAction: ").append(toIndentedString(mergeAction)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
    sb.append("    nodeEventFilter: ").append(toIndentedString(nodeEventFilter)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    resourcesDependencies: ").append(toIndentedString(resourcesDependencies)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    tasksSilentUpdate: ").append(toIndentedString(tasksSilentUpdate)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    userEventFilter: ").append(toIndentedString(userEventFilter)).append("\n");
    sb.append("    versionMeta: ").append(toIndentedString(versionMeta)).append("\n");
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
    openapiFields.add("Actions");
    openapiFields.add("AutoClean");
    openapiFields.add("AutoRestart");
    openapiFields.add("AutoStart");
    openapiFields.add("ChatEventFilter");
    openapiFields.add("ContextMetaFilter");
    openapiFields.add("CreatedAt");
    openapiFields.add("Custom");
    openapiFields.add("DataSourceFilter");
    openapiFields.add("EventNames");
    openapiFields.add("Hooks");
    openapiFields.add("ID");
    openapiFields.add("IdmFilter");
    openapiFields.add("Inactive");
    openapiFields.add("Label");
    openapiFields.add("Languages");
    openapiFields.add("MaxConcurrency");
    openapiFields.add("MergeAction");
    openapiFields.add("Metadata");
    openapiFields.add("ModifiedAt");
    openapiFields.add("NodeEventFilter");
    openapiFields.add("Owner");
    openapiFields.add("Parameters");
    openapiFields.add("ResourcesDependencies");
    openapiFields.add("Schedule");
    openapiFields.add("Tasks");
    openapiFields.add("TasksSilentUpdate");
    openapiFields.add("Timeout");
    openapiFields.add("UserEventFilter");
    openapiFields.add("VersionMeta");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to JobsJob
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!JobsJob.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JobsJob is not found in the empty JSON string", JobsJob.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!JobsJob.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JobsJob` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("Actions") != null && !jsonObj.get("Actions").isJsonNull()) {
        JsonArray jsonArrayactions = jsonObj.getAsJsonArray("Actions");
        if (jsonArrayactions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Actions").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Actions` to be an array in the JSON string but got `%s`", jsonObj.get("Actions").toString()));
          }

          // validate the optional field `Actions` (array)
          for (int i = 0; i < jsonArrayactions.size(); i++) {
            JobsAction.validateJsonElement(jsonArrayactions.get(i));
          };
        }
      }
      // validate the optional field `ChatEventFilter`
      if (jsonObj.get("ChatEventFilter") != null && !jsonObj.get("ChatEventFilter").isJsonNull()) {
        JobsChatEventFilter.validateJsonElement(jsonObj.get("ChatEventFilter"));
      }
      // validate the optional field `ContextMetaFilter`
      if (jsonObj.get("ContextMetaFilter") != null && !jsonObj.get("ContextMetaFilter").isJsonNull()) {
        JobsContextMetaFilter.validateJsonElement(jsonObj.get("ContextMetaFilter"));
      }
      // validate the optional field `DataSourceFilter`
      if (jsonObj.get("DataSourceFilter") != null && !jsonObj.get("DataSourceFilter").isJsonNull()) {
        JobsDataSourceSelector.validateJsonElement(jsonObj.get("DataSourceFilter"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("EventNames") != null && !jsonObj.get("EventNames").isJsonNull() && !jsonObj.get("EventNames").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `EventNames` to be an array in the JSON string but got `%s`", jsonObj.get("EventNames").toString()));
      }
      if (jsonObj.get("Hooks") != null && !jsonObj.get("Hooks").isJsonNull()) {
        JsonArray jsonArrayhooks = jsonObj.getAsJsonArray("Hooks");
        if (jsonArrayhooks != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Hooks").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Hooks` to be an array in the JSON string but got `%s`", jsonObj.get("Hooks").toString()));
          }

          // validate the optional field `Hooks` (array)
          for (int i = 0; i < jsonArrayhooks.size(); i++) {
            JobsJobHook.validateJsonElement(jsonArrayhooks.get(i));
          };
        }
      }
      if ((jsonObj.get("ID") != null && !jsonObj.get("ID").isJsonNull()) && !jsonObj.get("ID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ID").toString()));
      }
      // validate the optional field `IdmFilter`
      if (jsonObj.get("IdmFilter") != null && !jsonObj.get("IdmFilter").isJsonNull()) {
        JobsIdmSelector.validateJsonElement(jsonObj.get("IdmFilter"));
      }
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("Languages") != null && !jsonObj.get("Languages").isJsonNull() && !jsonObj.get("Languages").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `Languages` to be an array in the JSON string but got `%s`", jsonObj.get("Languages").toString()));
      }
      // validate the optional field `MergeAction`
      if (jsonObj.get("MergeAction") != null && !jsonObj.get("MergeAction").isJsonNull()) {
        JobsAction.validateJsonElement(jsonObj.get("MergeAction"));
      }
      // validate the optional field `NodeEventFilter`
      if (jsonObj.get("NodeEventFilter") != null && !jsonObj.get("NodeEventFilter").isJsonNull()) {
        JobsNodesSelector.validateJsonElement(jsonObj.get("NodeEventFilter"));
      }
      if ((jsonObj.get("Owner") != null && !jsonObj.get("Owner").isJsonNull()) && !jsonObj.get("Owner").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Owner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Owner").toString()));
      }
      if (jsonObj.get("Parameters") != null && !jsonObj.get("Parameters").isJsonNull()) {
        JsonArray jsonArrayparameters = jsonObj.getAsJsonArray("Parameters");
        if (jsonArrayparameters != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Parameters").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Parameters` to be an array in the JSON string but got `%s`", jsonObj.get("Parameters").toString()));
          }

          // validate the optional field `Parameters` (array)
          for (int i = 0; i < jsonArrayparameters.size(); i++) {
            JobsJobParameter.validateJsonElement(jsonArrayparameters.get(i));
          };
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("ResourcesDependencies") != null && !jsonObj.get("ResourcesDependencies").isJsonNull() && !jsonObj.get("ResourcesDependencies").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `ResourcesDependencies` to be an array in the JSON string but got `%s`", jsonObj.get("ResourcesDependencies").toString()));
      }
      // validate the optional field `Schedule`
      if (jsonObj.get("Schedule") != null && !jsonObj.get("Schedule").isJsonNull()) {
        JobsSchedule.validateJsonElement(jsonObj.get("Schedule"));
      }
      if (jsonObj.get("Tasks") != null && !jsonObj.get("Tasks").isJsonNull()) {
        JsonArray jsonArraytasks = jsonObj.getAsJsonArray("Tasks");
        if (jsonArraytasks != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Tasks").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Tasks` to be an array in the JSON string but got `%s`", jsonObj.get("Tasks").toString()));
          }

          // validate the optional field `Tasks` (array)
          for (int i = 0; i < jsonArraytasks.size(); i++) {
            JobsTask.validateJsonElement(jsonArraytasks.get(i));
          };
        }
      }
      if ((jsonObj.get("Timeout") != null && !jsonObj.get("Timeout").isJsonNull()) && !jsonObj.get("Timeout").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Timeout` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Timeout").toString()));
      }
      // validate the optional field `UserEventFilter`
      if (jsonObj.get("UserEventFilter") != null && !jsonObj.get("UserEventFilter").isJsonNull()) {
        JobsUsersSelector.validateJsonElement(jsonObj.get("UserEventFilter"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JobsJob.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JobsJob' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JobsJob> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JobsJob.class));

       return (TypeAdapter<T>) new TypeAdapter<JobsJob>() {
           @Override
           public void write(JsonWriter out, JobsJob value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JobsJob read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of JobsJob given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of JobsJob
  * @throws IOException if the JSON string is invalid with respect to JobsJob
  */
  public static JobsJob fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JobsJob.class);
  }

 /**
  * Convert an instance of JobsJob to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

