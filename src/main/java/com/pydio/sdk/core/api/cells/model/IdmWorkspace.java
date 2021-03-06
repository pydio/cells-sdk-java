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
import com.pydio.sdk.core.api.cells.model.IdmWorkspaceScope;
import com.pydio.sdk.core.api.cells.model.ServiceResourcePolicy;
import com.pydio.sdk.core.api.cells.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A Workspace is composed of a set of nodes UUIDs and is used to provide accesses to the tree via ACLs.
 */
@ApiModel(description = "A Workspace is composed of a set of nodes UUIDs and is used to provide accesses to the tree via ACLs.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class IdmWorkspace {
  @SerializedName("UUID")
  private String UUID = null;

  @SerializedName("Label")
  private String label = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Slug")
  private String slug = null;

  @SerializedName("Scope")
  private IdmWorkspaceScope scope = null;

  @SerializedName("LastUpdated")
  private Integer lastUpdated = null;

  @SerializedName("Policies")
  private List<ServiceResourcePolicy> policies = null;

  @SerializedName("Attributes")
  private String attributes = null;

  @SerializedName("RootUUIDs")
  private List<String> rootUUIDs = null;

  @SerializedName("RootNodes")
  private Map<String, TreeNode> rootNodes = null;

  @SerializedName("PoliciesContextEditable")
  private Boolean policiesContextEditable = null;

  public IdmWorkspace UUID(String UUID) {
    this.UUID = UUID;
    return this;
  }

   /**
   * Get UUID
   * @return UUID
  **/
  @ApiModelProperty(value = "")
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public IdmWorkspace label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public IdmWorkspace description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public IdmWorkspace slug(String slug) {
    this.slug = slug;
    return this;
  }

   /**
   * Get slug
   * @return slug
  **/
  @ApiModelProperty(value = "")
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public IdmWorkspace scope(IdmWorkspaceScope scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @ApiModelProperty(value = "")
  public IdmWorkspaceScope getScope() {
    return scope;
  }

  public void setScope(IdmWorkspaceScope scope) {
    this.scope = scope;
  }

  public IdmWorkspace lastUpdated(Integer lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @ApiModelProperty(value = "")
  public Integer getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Integer lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public IdmWorkspace policies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
    return this;
  }

  public IdmWorkspace addPoliciesItem(ServiceResourcePolicy policiesItem) {
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

  public IdmWorkspace attributes(String attributes) {
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @ApiModelProperty(value = "")
  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public IdmWorkspace rootUUIDs(List<String> rootUUIDs) {
    this.rootUUIDs = rootUUIDs;
    return this;
  }

  public IdmWorkspace addRootUUIDsItem(String rootUUIDsItem) {
    if (this.rootUUIDs == null) {
      this.rootUUIDs = new ArrayList<String>();
    }
    this.rootUUIDs.add(rootUUIDsItem);
    return this;
  }

   /**
   * Get rootUUIDs
   * @return rootUUIDs
  **/
  @ApiModelProperty(value = "")
  public List<String> getRootUUIDs() {
    return rootUUIDs;
  }

  public void setRootUUIDs(List<String> rootUUIDs) {
    this.rootUUIDs = rootUUIDs;
  }

  public IdmWorkspace rootNodes(Map<String, TreeNode> rootNodes) {
    this.rootNodes = rootNodes;
    return this;
  }

  public IdmWorkspace putRootNodesItem(String key, TreeNode rootNodesItem) {
    if (this.rootNodes == null) {
      this.rootNodes = new HashMap<String, TreeNode>();
    }
    this.rootNodes.put(key, rootNodesItem);
    return this;
  }

   /**
   * Get rootNodes
   * @return rootNodes
  **/
  @ApiModelProperty(value = "")
  public Map<String, TreeNode> getRootNodes() {
    return rootNodes;
  }

  public void setRootNodes(Map<String, TreeNode> rootNodes) {
    this.rootNodes = rootNodes;
  }

  public IdmWorkspace policiesContextEditable(Boolean policiesContextEditable) {
    this.policiesContextEditable = policiesContextEditable;
    return this;
  }

   /**
   * Get policiesContextEditable
   * @return policiesContextEditable
  **/
  @ApiModelProperty(value = "")
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
    IdmWorkspace idmWorkspace = (IdmWorkspace) o;
    return Objects.equals(this.UUID, idmWorkspace.UUID) &&
        Objects.equals(this.label, idmWorkspace.label) &&
        Objects.equals(this.description, idmWorkspace.description) &&
        Objects.equals(this.slug, idmWorkspace.slug) &&
        Objects.equals(this.scope, idmWorkspace.scope) &&
        Objects.equals(this.lastUpdated, idmWorkspace.lastUpdated) &&
        Objects.equals(this.policies, idmWorkspace.policies) &&
        Objects.equals(this.attributes, idmWorkspace.attributes) &&
        Objects.equals(this.rootUUIDs, idmWorkspace.rootUUIDs) &&
        Objects.equals(this.rootNodes, idmWorkspace.rootNodes) &&
        Objects.equals(this.policiesContextEditable, idmWorkspace.policiesContextEditable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(UUID, label, description, slug, scope, lastUpdated, policies, attributes, rootUUIDs, rootNodes, policiesContextEditable);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmWorkspace {\n");
    
    sb.append("    UUID: ").append(toIndentedString(UUID)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    rootUUIDs: ").append(toIndentedString(rootUUIDs)).append("\n");
    sb.append("    rootNodes: ").append(toIndentedString(rootNodes)).append("\n");
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

