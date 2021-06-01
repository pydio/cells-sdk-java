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


package com.pydio.cells.openapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.IdmRole;
import com.pydio.cells.openapi.model.ServiceResourcePolicy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IdmUser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class IdmUser {
  @SerializedName("Uuid")
  private String uuid = null;

  @SerializedName("GroupPath")
  private String groupPath = null;

  @SerializedName("Attributes")
  private Map<String, String> attributes = null;

  @SerializedName("Roles")
  private List<IdmRole> roles = null;

  @SerializedName("Login")
  private String login = null;

  @SerializedName("Password")
  private String password = null;

  @SerializedName("OldPassword")
  private String oldPassword = null;

  @SerializedName("IsGroup")
  private Boolean isGroup = null;

  @SerializedName("GroupLabel")
  private String groupLabel = null;

  @SerializedName("LastConnected")
  private Integer lastConnected = null;

  @SerializedName("Policies")
  private List<ServiceResourcePolicy> policies = null;

  @SerializedName("PoliciesContextEditable")
  private Boolean policiesContextEditable = null;

  public IdmUser uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public IdmUser groupPath(String groupPath) {
    this.groupPath = groupPath;
    return this;
  }

   /**
   * Get groupPath
   * @return groupPath
  **/
  @ApiModelProperty(value = "")
  public String getGroupPath() {
    return groupPath;
  }

  public void setGroupPath(String groupPath) {
    this.groupPath = groupPath;
  }

  public IdmUser attributes(Map<String, String> attributes) {
    this.attributes = attributes;
    return this;
  }

  public IdmUser putAttributesItem(String key, String attributesItem) {
    if (this.attributes == null) {
      this.attributes = new HashMap<String, String>();
    }
    this.attributes.put(key, attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, String> attributes) {
    this.attributes = attributes;
  }

  public IdmUser roles(List<IdmRole> roles) {
    this.roles = roles;
    return this;
  }

  public IdmUser addRolesItem(IdmRole rolesItem) {
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
  @ApiModelProperty(value = "")
  public List<IdmRole> getRoles() {
    return roles;
  }

  public void setRoles(List<IdmRole> roles) {
    this.roles = roles;
  }

  public IdmUser login(String login) {
    this.login = login;
    return this;
  }

   /**
   * Get login
   * @return login
  **/
  @ApiModelProperty(value = "")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public IdmUser password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public IdmUser oldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
    return this;
  }

   /**
   * Get oldPassword
   * @return oldPassword
  **/
  @ApiModelProperty(value = "")
  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public IdmUser isGroup(Boolean isGroup) {
    this.isGroup = isGroup;
    return this;
  }

   /**
   * Get isGroup
   * @return isGroup
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsGroup() {
    return isGroup;
  }

  public void setIsGroup(Boolean isGroup) {
    this.isGroup = isGroup;
  }

  public IdmUser groupLabel(String groupLabel) {
    this.groupLabel = groupLabel;
    return this;
  }

   /**
   * Get groupLabel
   * @return groupLabel
  **/
  @ApiModelProperty(value = "")
  public String getGroupLabel() {
    return groupLabel;
  }

  public void setGroupLabel(String groupLabel) {
    this.groupLabel = groupLabel;
  }

  public IdmUser lastConnected(Integer lastConnected) {
    this.lastConnected = lastConnected;
    return this;
  }

   /**
   * Get lastConnected
   * @return lastConnected
  **/
  @ApiModelProperty(value = "")
  public Integer getLastConnected() {
    return lastConnected;
  }

  public void setLastConnected(Integer lastConnected) {
    this.lastConnected = lastConnected;
  }

  public IdmUser policies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
    return this;
  }

  public IdmUser addPoliciesItem(ServiceResourcePolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<ServiceResourcePolicy>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @ApiModelProperty(value = "")
  public List<ServiceResourcePolicy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
  }

  public IdmUser policiesContextEditable(Boolean policiesContextEditable) {
    this.policiesContextEditable = policiesContextEditable;
    return this;
  }

   /**
   * Context-resolved to quickly check if user is editable or not.
   * @return policiesContextEditable
  **/
  @ApiModelProperty(value = "Context-resolved to quickly check if user is editable or not.")
  public Boolean isPoliciesContextEditable() {
    return policiesContextEditable;
  }

  public void setPoliciesContextEditable(Boolean policiesContextEditable) {
    this.policiesContextEditable = policiesContextEditable;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmUser idmUser = (IdmUser) o;
    return Objects.equals(this.uuid, idmUser.uuid) &&
        Objects.equals(this.groupPath, idmUser.groupPath) &&
        Objects.equals(this.attributes, idmUser.attributes) &&
        Objects.equals(this.roles, idmUser.roles) &&
        Objects.equals(this.login, idmUser.login) &&
        Objects.equals(this.password, idmUser.password) &&
        Objects.equals(this.oldPassword, idmUser.oldPassword) &&
        Objects.equals(this.isGroup, idmUser.isGroup) &&
        Objects.equals(this.groupLabel, idmUser.groupLabel) &&
        Objects.equals(this.lastConnected, idmUser.lastConnected) &&
        Objects.equals(this.policies, idmUser.policies) &&
        Objects.equals(this.policiesContextEditable, idmUser.policiesContextEditable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, groupPath, attributes, roles, login, password, oldPassword, isGroup, groupLabel, lastConnected, policies, policiesContextEditable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmUser {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    groupPath: ").append(toIndentedString(groupPath)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    oldPassword: ").append(toIndentedString(oldPassword)).append("\n");
    sb.append("    isGroup: ").append(toIndentedString(isGroup)).append("\n");
    sb.append("    groupLabel: ").append(toIndentedString(groupLabel)).append("\n");
    sb.append("    lastConnected: ").append(toIndentedString(lastConnected)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
    sb.append("    policiesContextEditable: ").append(toIndentedString(policiesContextEditable)).append("\n");
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

