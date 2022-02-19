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
import com.pydio.cells.openapi.model.ActivityObject;
import com.pydio.cells.openapi.model.IdmACL;
import com.pydio.cells.openapi.model.IdmRole;
import com.pydio.cells.openapi.model.IdmUser;
import com.pydio.cells.openapi.model.IdmWorkspace;
import com.pydio.cells.openapi.model.JobsActionOutput;
import com.pydio.cells.openapi.model.ObjectDataSource;
import com.pydio.cells.openapi.model.ProtobufAny;
import com.pydio.cells.openapi.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobsActionMessage
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class JobsActionMessage {
  public static final String SERIALIZED_NAME_EVENT = "Event";
  @SerializedName(SERIALIZED_NAME_EVENT)
  private ProtobufAny event;

  public static final String SERIALIZED_NAME_NODES = "Nodes";
  @SerializedName(SERIALIZED_NAME_NODES)
  private List<TreeNode> nodes = null;

  public static final String SERIALIZED_NAME_USERS = "Users";
  @SerializedName(SERIALIZED_NAME_USERS)
  private List<IdmUser> users = null;

  public static final String SERIALIZED_NAME_ROLES = "Roles";
  @SerializedName(SERIALIZED_NAME_ROLES)
  private List<IdmRole> roles = null;

  public static final String SERIALIZED_NAME_WORKSPACES = "Workspaces";
  @SerializedName(SERIALIZED_NAME_WORKSPACES)
  private List<IdmWorkspace> workspaces = null;

  public static final String SERIALIZED_NAME_ACLS = "Acls";
  @SerializedName(SERIALIZED_NAME_ACLS)
  private List<IdmACL> acls = null;

  public static final String SERIALIZED_NAME_ACTIVITIES = "Activities";
  @SerializedName(SERIALIZED_NAME_ACTIVITIES)
  private List<ActivityObject> activities = null;

  public static final String SERIALIZED_NAME_DATA_SOURCES = "DataSources";
  @SerializedName(SERIALIZED_NAME_DATA_SOURCES)
  private List<ObjectDataSource> dataSources = null;

  public static final String SERIALIZED_NAME_OUTPUT_CHAIN = "OutputChain";
  @SerializedName(SERIALIZED_NAME_OUTPUT_CHAIN)
  private List<JobsActionOutput> outputChain = null;

  public JobsActionMessage() { 
  }

  public JobsActionMessage event(ProtobufAny event) {
    
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProtobufAny getEvent() {
    return event;
  }


  public void setEvent(ProtobufAny event) {
    this.event = event;
  }


  public JobsActionMessage nodes(List<TreeNode> nodes) {
    
    this.nodes = nodes;
    return this;
  }

  public JobsActionMessage addNodesItem(TreeNode nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<TreeNode>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

   /**
   * Get nodes
   * @return nodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<TreeNode> getNodes() {
    return nodes;
  }


  public void setNodes(List<TreeNode> nodes) {
    this.nodes = nodes;
  }


  public JobsActionMessage users(List<IdmUser> users) {
    
    this.users = users;
    return this;
  }

  public JobsActionMessage addUsersItem(IdmUser usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<IdmUser>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUser> getUsers() {
    return users;
  }


  public void setUsers(List<IdmUser> users) {
    this.users = users;
  }


  public JobsActionMessage roles(List<IdmRole> roles) {
    
    this.roles = roles;
    return this;
  }

  public JobsActionMessage addRolesItem(IdmRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<IdmRole>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmRole> getRoles() {
    return roles;
  }


  public void setRoles(List<IdmRole> roles) {
    this.roles = roles;
  }


  public JobsActionMessage workspaces(List<IdmWorkspace> workspaces) {
    
    this.workspaces = workspaces;
    return this;
  }

  public JobsActionMessage addWorkspacesItem(IdmWorkspace workspacesItem) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList<IdmWorkspace>();
    }
    this.workspaces.add(workspacesItem);
    return this;
  }

   /**
   * Get workspaces
   * @return workspaces
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmWorkspace> getWorkspaces() {
    return workspaces;
  }


  public void setWorkspaces(List<IdmWorkspace> workspaces) {
    this.workspaces = workspaces;
  }


  public JobsActionMessage acls(List<IdmACL> acls) {
    
    this.acls = acls;
    return this;
  }

  public JobsActionMessage addAclsItem(IdmACL aclsItem) {
    if (this.acls == null) {
      this.acls = new ArrayList<IdmACL>();
    }
    this.acls.add(aclsItem);
    return this;
  }

   /**
   * Get acls
   * @return acls
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmACL> getAcls() {
    return acls;
  }


  public void setAcls(List<IdmACL> acls) {
    this.acls = acls;
  }


  public JobsActionMessage activities(List<ActivityObject> activities) {
    
    this.activities = activities;
    return this;
  }

  public JobsActionMessage addActivitiesItem(ActivityObject activitiesItem) {
    if (this.activities == null) {
      this.activities = new ArrayList<ActivityObject>();
    }
    this.activities.add(activitiesItem);
    return this;
  }

   /**
   * Get activities
   * @return activities
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ActivityObject> getActivities() {
    return activities;
  }


  public void setActivities(List<ActivityObject> activities) {
    this.activities = activities;
  }


  public JobsActionMessage dataSources(List<ObjectDataSource> dataSources) {
    
    this.dataSources = dataSources;
    return this;
  }

  public JobsActionMessage addDataSourcesItem(ObjectDataSource dataSourcesItem) {
    if (this.dataSources == null) {
      this.dataSources = new ArrayList<ObjectDataSource>();
    }
    this.dataSources.add(dataSourcesItem);
    return this;
  }

   /**
   * Get dataSources
   * @return dataSources
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ObjectDataSource> getDataSources() {
    return dataSources;
  }


  public void setDataSources(List<ObjectDataSource> dataSources) {
    this.dataSources = dataSources;
  }


  public JobsActionMessage outputChain(List<JobsActionOutput> outputChain) {
    
    this.outputChain = outputChain;
    return this;
  }

  public JobsActionMessage addOutputChainItem(JobsActionOutput outputChainItem) {
    if (this.outputChain == null) {
      this.outputChain = new ArrayList<JobsActionOutput>();
    }
    this.outputChain.add(outputChainItem);
    return this;
  }

   /**
   * Get outputChain
   * @return outputChain
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<JobsActionOutput> getOutputChain() {
    return outputChain;
  }


  public void setOutputChain(List<JobsActionOutput> outputChain) {
    this.outputChain = outputChain;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsActionMessage jobsActionMessage = (JobsActionMessage) o;
    return Objects.equals(this.event, jobsActionMessage.event) &&
        Objects.equals(this.nodes, jobsActionMessage.nodes) &&
        Objects.equals(this.users, jobsActionMessage.users) &&
        Objects.equals(this.roles, jobsActionMessage.roles) &&
        Objects.equals(this.workspaces, jobsActionMessage.workspaces) &&
        Objects.equals(this.acls, jobsActionMessage.acls) &&
        Objects.equals(this.activities, jobsActionMessage.activities) &&
        Objects.equals(this.dataSources, jobsActionMessage.dataSources) &&
        Objects.equals(this.outputChain, jobsActionMessage.outputChain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, nodes, users, roles, workspaces, acls, activities, dataSources, outputChain);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsActionMessage {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    workspaces: ").append(toIndentedString(workspaces)).append("\n");
    sb.append("    acls: ").append(toIndentedString(acls)).append("\n");
    sb.append("    activities: ").append(toIndentedString(activities)).append("\n");
    sb.append("    dataSources: ").append(toIndentedString(dataSources)).append("\n");
    sb.append("    outputChain: ").append(toIndentedString(outputChain)).append("\n");
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

