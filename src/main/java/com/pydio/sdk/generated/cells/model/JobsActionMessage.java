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


package com.pydio.sdk.generated.cells.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * JobsActionMessage
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class JobsActionMessage {
  @SerializedName("Event")
  private ProtobufAny event = null;

  @SerializedName("Nodes")
  private List<com.pydio.sdk.generated.cells.model.TreeNode> nodes = null;

  @SerializedName("Users")
  private List<IdmUser> users = null;

  @SerializedName("Roles")
  private List<com.pydio.sdk.generated.cells.model.IdmRole> roles = null;

  @SerializedName("Workspaces")
  private List<com.pydio.sdk.generated.cells.model.IdmWorkspace> workspaces = null;

  @SerializedName("Acls")
  private List<com.pydio.sdk.generated.cells.model.IdmACL> acls = null;

  @SerializedName("Activities")
  private List<ActivityObject> activities = null;

  @SerializedName("OutputChain")
  private List<JobsActionOutput> outputChain = null;

  public JobsActionMessage event(ProtobufAny event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")
  public ProtobufAny getEvent() {
    return event;
  }

  public void setEvent(ProtobufAny event) {
    this.event = event;
  }

  public JobsActionMessage nodes(List<com.pydio.sdk.generated.cells.model.TreeNode> nodes) {
    this.nodes = nodes;
    return this;
  }

  public JobsActionMessage addNodesItem(com.pydio.sdk.generated.cells.model.TreeNode nodesItem) {
    if (this.nodes == null) {
      this.nodes = new ArrayList<com.pydio.sdk.generated.cells.model.TreeNode>();
    }
    this.nodes.add(nodesItem);
    return this;
  }

   /**
   * Get nodes
   * @return nodes
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.TreeNode> getNodes() {
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
  @ApiModelProperty(value = "")
  public List<IdmUser> getUsers() {
    return users;
  }

  public void setUsers(List<IdmUser> users) {
    this.users = users;
  }

  public JobsActionMessage roles(List<com.pydio.sdk.generated.cells.model.IdmRole> roles) {
    this.roles = roles;
    return this;
  }

  public JobsActionMessage addRolesItem(com.pydio.sdk.generated.cells.model.IdmRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<com.pydio.sdk.generated.cells.model.IdmRole>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.IdmRole> getRoles() {
    return roles;
  }

  public void setRoles(List<IdmRole> roles) {
    this.roles = roles;
  }

  public JobsActionMessage workspaces(List<com.pydio.sdk.generated.cells.model.IdmWorkspace> workspaces) {
    this.workspaces = workspaces;
    return this;
  }

  public JobsActionMessage addWorkspacesItem(com.pydio.sdk.generated.cells.model.IdmWorkspace workspacesItem) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList<com.pydio.sdk.generated.cells.model.IdmWorkspace>();
    }
    this.workspaces.add(workspacesItem);
    return this;
  }

   /**
   * Get workspaces
   * @return workspaces
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.IdmWorkspace> getWorkspaces() {
    return workspaces;
  }

  public void setWorkspaces(List<IdmWorkspace> workspaces) {
    this.workspaces = workspaces;
  }

  public JobsActionMessage acls(List<com.pydio.sdk.generated.cells.model.IdmACL> acls) {
    this.acls = acls;
    return this;
  }

  public JobsActionMessage addAclsItem(com.pydio.sdk.generated.cells.model.IdmACL aclsItem) {
    if (this.acls == null) {
      this.acls = new ArrayList<com.pydio.sdk.generated.cells.model.IdmACL>();
    }
    this.acls.add(aclsItem);
    return this;
  }

   /**
   * Get acls
   * @return acls
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.IdmACL> getAcls() {
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
  @ApiModelProperty(value = "")
  public List<ActivityObject> getActivities() {
    return activities;
  }

  public void setActivities(List<ActivityObject> activities) {
    this.activities = activities;
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
  @ApiModelProperty(value = "")
  public List<JobsActionOutput> getOutputChain() {
    return outputChain;
  }

  public void setOutputChain(List<JobsActionOutput> outputChain) {
    this.outputChain = outputChain;
  }


  @Override
  public boolean equals(java.lang.Object o) {
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
        Objects.equals(this.outputChain, jobsActionMessage.outputChain);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, nodes, users, roles, workspaces, acls, activities, outputChain);
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
    sb.append("    outputChain: ").append(toIndentedString(outputChain)).append("\n");
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
