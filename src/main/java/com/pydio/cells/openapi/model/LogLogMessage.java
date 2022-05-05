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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * LogMessage is the format used to transmit log messages to clients via the REST API.
 */
@ApiModel(description = "LogMessage is the format used to transmit log messages to clients via the REST API.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class LogLogMessage {
  public static final String SERIALIZED_NAME_GROUP_PATH = "GroupPath";
  @SerializedName(SERIALIZED_NAME_GROUP_PATH)
  private String groupPath;

  public static final String SERIALIZED_NAME_HTTP_PROTOCOL = "HttpProtocol";
  @SerializedName(SERIALIZED_NAME_HTTP_PROTOCOL)
  private String httpProtocol;

  public static final String SERIALIZED_NAME_JSON_ZAPS = "JsonZaps";
  @SerializedName(SERIALIZED_NAME_JSON_ZAPS)
  private String jsonZaps;

  public static final String SERIALIZED_NAME_LEVEL = "Level";
  @SerializedName(SERIALIZED_NAME_LEVEL)
  private String level;

  public static final String SERIALIZED_NAME_LOGGER = "Logger";
  @SerializedName(SERIALIZED_NAME_LOGGER)
  private String logger;

  public static final String SERIALIZED_NAME_MSG = "Msg";
  @SerializedName(SERIALIZED_NAME_MSG)
  private String msg;

  public static final String SERIALIZED_NAME_MSG_ID = "MsgId";
  @SerializedName(SERIALIZED_NAME_MSG_ID)
  private String msgId;

  public static final String SERIALIZED_NAME_NODE_PATH = "NodePath";
  @SerializedName(SERIALIZED_NAME_NODE_PATH)
  private String nodePath;

  public static final String SERIALIZED_NAME_NODE_UUID = "NodeUuid";
  @SerializedName(SERIALIZED_NAME_NODE_UUID)
  private String nodeUuid;

  public static final String SERIALIZED_NAME_OPERATION_LABEL = "OperationLabel";
  @SerializedName(SERIALIZED_NAME_OPERATION_LABEL)
  private String operationLabel;

  public static final String SERIALIZED_NAME_OPERATION_UUID = "OperationUuid";
  @SerializedName(SERIALIZED_NAME_OPERATION_UUID)
  private String operationUuid;

  public static final String SERIALIZED_NAME_PROFILE = "Profile";
  @SerializedName(SERIALIZED_NAME_PROFILE)
  private String profile;

  public static final String SERIALIZED_NAME_REMOTE_ADDRESS = "RemoteAddress";
  @SerializedName(SERIALIZED_NAME_REMOTE_ADDRESS)
  private String remoteAddress;

  public static final String SERIALIZED_NAME_ROLE_UUIDS = "RoleUuids";
  @SerializedName(SERIALIZED_NAME_ROLE_UUIDS)
  private List<String> roleUuids = null;

  public static final String SERIALIZED_NAME_SCHEDULER_JOB_UUID = "SchedulerJobUuid";
  @SerializedName(SERIALIZED_NAME_SCHEDULER_JOB_UUID)
  private String schedulerJobUuid;

  public static final String SERIALIZED_NAME_SCHEDULER_TASK_ACTION_PATH = "SchedulerTaskActionPath";
  @SerializedName(SERIALIZED_NAME_SCHEDULER_TASK_ACTION_PATH)
  private String schedulerTaskActionPath;

  public static final String SERIALIZED_NAME_SCHEDULER_TASK_UUID = "SchedulerTaskUuid";
  @SerializedName(SERIALIZED_NAME_SCHEDULER_TASK_UUID)
  private String schedulerTaskUuid;

  public static final String SERIALIZED_NAME_SPAN_PARENT_UUID = "SpanParentUuid";
  @SerializedName(SERIALIZED_NAME_SPAN_PARENT_UUID)
  private String spanParentUuid;

  public static final String SERIALIZED_NAME_SPAN_ROOT_UUID = "SpanRootUuid";
  @SerializedName(SERIALIZED_NAME_SPAN_ROOT_UUID)
  private String spanRootUuid;

  public static final String SERIALIZED_NAME_SPAN_UUID = "SpanUuid";
  @SerializedName(SERIALIZED_NAME_SPAN_UUID)
  private String spanUuid;

  public static final String SERIALIZED_NAME_TS = "Ts";
  @SerializedName(SERIALIZED_NAME_TS)
  private Integer ts;

  public static final String SERIALIZED_NAME_USER_AGENT = "UserAgent";
  @SerializedName(SERIALIZED_NAME_USER_AGENT)
  private String userAgent;

  public static final String SERIALIZED_NAME_USER_NAME = "UserName";
  @SerializedName(SERIALIZED_NAME_USER_NAME)
  private String userName;

  public static final String SERIALIZED_NAME_USER_UUID = "UserUuid";
  @SerializedName(SERIALIZED_NAME_USER_UUID)
  private String userUuid;

  public static final String SERIALIZED_NAME_WS_SCOPE = "WsScope";
  @SerializedName(SERIALIZED_NAME_WS_SCOPE)
  private String wsScope;

  public static final String SERIALIZED_NAME_WS_UUID = "WsUuid";
  @SerializedName(SERIALIZED_NAME_WS_UUID)
  private String wsUuid;

  public LogLogMessage() { 
  }

  public LogLogMessage groupPath(String groupPath) {
    
    this.groupPath = groupPath;
    return this;
  }

   /**
   * Get groupPath
   * @return groupPath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGroupPath() {
    return groupPath;
  }


  public void setGroupPath(String groupPath) {
    this.groupPath = groupPath;
  }


  public LogLogMessage httpProtocol(String httpProtocol) {
    
    this.httpProtocol = httpProtocol;
    return this;
  }

   /**
   * Get httpProtocol
   * @return httpProtocol
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getHttpProtocol() {
    return httpProtocol;
  }


  public void setHttpProtocol(String httpProtocol) {
    this.httpProtocol = httpProtocol;
  }


  public LogLogMessage jsonZaps(String jsonZaps) {
    
    this.jsonZaps = jsonZaps;
    return this;
  }

   /**
   * Get jsonZaps
   * @return jsonZaps
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJsonZaps() {
    return jsonZaps;
  }


  public void setJsonZaps(String jsonZaps) {
    this.jsonZaps = jsonZaps;
  }


  public LogLogMessage level(String level) {
    
    this.level = level;
    return this;
  }

   /**
   * Get level
   * @return level
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLevel() {
    return level;
  }


  public void setLevel(String level) {
    this.level = level;
  }


  public LogLogMessage logger(String logger) {
    
    this.logger = logger;
    return this;
  }

   /**
   * Get logger
   * @return logger
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLogger() {
    return logger;
  }


  public void setLogger(String logger) {
    this.logger = logger;
  }


  public LogLogMessage msg(String msg) {
    
    this.msg = msg;
    return this;
  }

   /**
   * Get msg
   * @return msg
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getMsg() {
    return msg;
  }


  public void setMsg(String msg) {
    this.msg = msg;
  }


  public LogLogMessage msgId(String msgId) {
    
    this.msgId = msgId;
    return this;
  }

   /**
   * Get msgId
   * @return msgId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getMsgId() {
    return msgId;
  }


  public void setMsgId(String msgId) {
    this.msgId = msgId;
  }


  public LogLogMessage nodePath(String nodePath) {
    
    this.nodePath = nodePath;
    return this;
  }

   /**
   * Get nodePath
   * @return nodePath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNodePath() {
    return nodePath;
  }


  public void setNodePath(String nodePath) {
    this.nodePath = nodePath;
  }


  public LogLogMessage nodeUuid(String nodeUuid) {
    
    this.nodeUuid = nodeUuid;
    return this;
  }

   /**
   * Get nodeUuid
   * @return nodeUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getNodeUuid() {
    return nodeUuid;
  }


  public void setNodeUuid(String nodeUuid) {
    this.nodeUuid = nodeUuid;
  }


  public LogLogMessage operationLabel(String operationLabel) {
    
    this.operationLabel = operationLabel;
    return this;
  }

   /**
   * Get operationLabel
   * @return operationLabel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOperationLabel() {
    return operationLabel;
  }


  public void setOperationLabel(String operationLabel) {
    this.operationLabel = operationLabel;
  }


  public LogLogMessage operationUuid(String operationUuid) {
    
    this.operationUuid = operationUuid;
    return this;
  }

   /**
   * Get operationUuid
   * @return operationUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOperationUuid() {
    return operationUuid;
  }


  public void setOperationUuid(String operationUuid) {
    this.operationUuid = operationUuid;
  }


  public LogLogMessage profile(String profile) {
    
    this.profile = profile;
    return this;
  }

   /**
   * Get profile
   * @return profile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getProfile() {
    return profile;
  }


  public void setProfile(String profile) {
    this.profile = profile;
  }


  public LogLogMessage remoteAddress(String remoteAddress) {
    
    this.remoteAddress = remoteAddress;
    return this;
  }

   /**
   * Get remoteAddress
   * @return remoteAddress
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRemoteAddress() {
    return remoteAddress;
  }


  public void setRemoteAddress(String remoteAddress) {
    this.remoteAddress = remoteAddress;
  }


  public LogLogMessage roleUuids(List<String> roleUuids) {
    
    this.roleUuids = roleUuids;
    return this;
  }

  public LogLogMessage addRoleUuidsItem(String roleUuidsItem) {
    if (this.roleUuids == null) {
      this.roleUuids = new ArrayList<String>();
    }
    this.roleUuids.add(roleUuidsItem);
    return this;
  }

   /**
   * Get roleUuids
   * @return roleUuids
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getRoleUuids() {
    return roleUuids;
  }


  public void setRoleUuids(List<String> roleUuids) {
    this.roleUuids = roleUuids;
  }


  public LogLogMessage schedulerJobUuid(String schedulerJobUuid) {
    
    this.schedulerJobUuid = schedulerJobUuid;
    return this;
  }

   /**
   * Get schedulerJobUuid
   * @return schedulerJobUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSchedulerJobUuid() {
    return schedulerJobUuid;
  }


  public void setSchedulerJobUuid(String schedulerJobUuid) {
    this.schedulerJobUuid = schedulerJobUuid;
  }


  public LogLogMessage schedulerTaskActionPath(String schedulerTaskActionPath) {
    
    this.schedulerTaskActionPath = schedulerTaskActionPath;
    return this;
  }

   /**
   * Get schedulerTaskActionPath
   * @return schedulerTaskActionPath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSchedulerTaskActionPath() {
    return schedulerTaskActionPath;
  }


  public void setSchedulerTaskActionPath(String schedulerTaskActionPath) {
    this.schedulerTaskActionPath = schedulerTaskActionPath;
  }


  public LogLogMessage schedulerTaskUuid(String schedulerTaskUuid) {
    
    this.schedulerTaskUuid = schedulerTaskUuid;
    return this;
  }

   /**
   * Get schedulerTaskUuid
   * @return schedulerTaskUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSchedulerTaskUuid() {
    return schedulerTaskUuid;
  }


  public void setSchedulerTaskUuid(String schedulerTaskUuid) {
    this.schedulerTaskUuid = schedulerTaskUuid;
  }


  public LogLogMessage spanParentUuid(String spanParentUuid) {
    
    this.spanParentUuid = spanParentUuid;
    return this;
  }

   /**
   * Get spanParentUuid
   * @return spanParentUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSpanParentUuid() {
    return spanParentUuid;
  }


  public void setSpanParentUuid(String spanParentUuid) {
    this.spanParentUuid = spanParentUuid;
  }


  public LogLogMessage spanRootUuid(String spanRootUuid) {
    
    this.spanRootUuid = spanRootUuid;
    return this;
  }

   /**
   * Get spanRootUuid
   * @return spanRootUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSpanRootUuid() {
    return spanRootUuid;
  }


  public void setSpanRootUuid(String spanRootUuid) {
    this.spanRootUuid = spanRootUuid;
  }


  public LogLogMessage spanUuid(String spanUuid) {
    
    this.spanUuid = spanUuid;
    return this;
  }

   /**
   * Get spanUuid
   * @return spanUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSpanUuid() {
    return spanUuid;
  }


  public void setSpanUuid(String spanUuid) {
    this.spanUuid = spanUuid;
  }


  public LogLogMessage ts(Integer ts) {
    
    this.ts = ts;
    return this;
  }

   /**
   * Get ts
   * @return ts
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTs() {
    return ts;
  }


  public void setTs(Integer ts) {
    this.ts = ts;
  }


  public LogLogMessage userAgent(String userAgent) {
    
    this.userAgent = userAgent;
    return this;
  }

   /**
   * Get userAgent
   * @return userAgent
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUserAgent() {
    return userAgent;
  }


  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }


  public LogLogMessage userName(String userName) {
    
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUserName() {
    return userName;
  }


  public void setUserName(String userName) {
    this.userName = userName;
  }


  public LogLogMessage userUuid(String userUuid) {
    
    this.userUuid = userUuid;
    return this;
  }

   /**
   * Get userUuid
   * @return userUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUserUuid() {
    return userUuid;
  }


  public void setUserUuid(String userUuid) {
    this.userUuid = userUuid;
  }


  public LogLogMessage wsScope(String wsScope) {
    
    this.wsScope = wsScope;
    return this;
  }

   /**
   * Get wsScope
   * @return wsScope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsScope() {
    return wsScope;
  }


  public void setWsScope(String wsScope) {
    this.wsScope = wsScope;
  }


  public LogLogMessage wsUuid(String wsUuid) {
    
    this.wsUuid = wsUuid;
    return this;
  }

   /**
   * Get wsUuid
   * @return wsUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsUuid() {
    return wsUuid;
  }


  public void setWsUuid(String wsUuid) {
    this.wsUuid = wsUuid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LogLogMessage logLogMessage = (LogLogMessage) o;
    return Objects.equals(this.groupPath, logLogMessage.groupPath) &&
        Objects.equals(this.httpProtocol, logLogMessage.httpProtocol) &&
        Objects.equals(this.jsonZaps, logLogMessage.jsonZaps) &&
        Objects.equals(this.level, logLogMessage.level) &&
        Objects.equals(this.logger, logLogMessage.logger) &&
        Objects.equals(this.msg, logLogMessage.msg) &&
        Objects.equals(this.msgId, logLogMessage.msgId) &&
        Objects.equals(this.nodePath, logLogMessage.nodePath) &&
        Objects.equals(this.nodeUuid, logLogMessage.nodeUuid) &&
        Objects.equals(this.operationLabel, logLogMessage.operationLabel) &&
        Objects.equals(this.operationUuid, logLogMessage.operationUuid) &&
        Objects.equals(this.profile, logLogMessage.profile) &&
        Objects.equals(this.remoteAddress, logLogMessage.remoteAddress) &&
        Objects.equals(this.roleUuids, logLogMessage.roleUuids) &&
        Objects.equals(this.schedulerJobUuid, logLogMessage.schedulerJobUuid) &&
        Objects.equals(this.schedulerTaskActionPath, logLogMessage.schedulerTaskActionPath) &&
        Objects.equals(this.schedulerTaskUuid, logLogMessage.schedulerTaskUuid) &&
        Objects.equals(this.spanParentUuid, logLogMessage.spanParentUuid) &&
        Objects.equals(this.spanRootUuid, logLogMessage.spanRootUuid) &&
        Objects.equals(this.spanUuid, logLogMessage.spanUuid) &&
        Objects.equals(this.ts, logLogMessage.ts) &&
        Objects.equals(this.userAgent, logLogMessage.userAgent) &&
        Objects.equals(this.userName, logLogMessage.userName) &&
        Objects.equals(this.userUuid, logLogMessage.userUuid) &&
        Objects.equals(this.wsScope, logLogMessage.wsScope) &&
        Objects.equals(this.wsUuid, logLogMessage.wsUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupPath, httpProtocol, jsonZaps, level, logger, msg, msgId, nodePath, nodeUuid, operationLabel, operationUuid, profile, remoteAddress, roleUuids, schedulerJobUuid, schedulerTaskActionPath, schedulerTaskUuid, spanParentUuid, spanRootUuid, spanUuid, ts, userAgent, userName, userUuid, wsScope, wsUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogLogMessage {\n");
    sb.append("    groupPath: ").append(toIndentedString(groupPath)).append("\n");
    sb.append("    httpProtocol: ").append(toIndentedString(httpProtocol)).append("\n");
    sb.append("    jsonZaps: ").append(toIndentedString(jsonZaps)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    logger: ").append(toIndentedString(logger)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    msgId: ").append(toIndentedString(msgId)).append("\n");
    sb.append("    nodePath: ").append(toIndentedString(nodePath)).append("\n");
    sb.append("    nodeUuid: ").append(toIndentedString(nodeUuid)).append("\n");
    sb.append("    operationLabel: ").append(toIndentedString(operationLabel)).append("\n");
    sb.append("    operationUuid: ").append(toIndentedString(operationUuid)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    remoteAddress: ").append(toIndentedString(remoteAddress)).append("\n");
    sb.append("    roleUuids: ").append(toIndentedString(roleUuids)).append("\n");
    sb.append("    schedulerJobUuid: ").append(toIndentedString(schedulerJobUuid)).append("\n");
    sb.append("    schedulerTaskActionPath: ").append(toIndentedString(schedulerTaskActionPath)).append("\n");
    sb.append("    schedulerTaskUuid: ").append(toIndentedString(schedulerTaskUuid)).append("\n");
    sb.append("    spanParentUuid: ").append(toIndentedString(spanParentUuid)).append("\n");
    sb.append("    spanRootUuid: ").append(toIndentedString(spanRootUuid)).append("\n");
    sb.append("    spanUuid: ").append(toIndentedString(spanUuid)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
    sb.append("    wsScope: ").append(toIndentedString(wsScope)).append("\n");
    sb.append("    wsUuid: ").append(toIndentedString(wsUuid)).append("\n");
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

