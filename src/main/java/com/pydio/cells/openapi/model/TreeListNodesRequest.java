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
import com.pydio.cells.openapi.model.TreeNode;
import com.pydio.cells.openapi.model.TreeNodeType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TreeListNodesRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class TreeListNodesRequest {
  @SerializedName("Node")
  private TreeNode node = null;

  @SerializedName("Recursive")
  private Boolean recursive = null;

  @SerializedName("Ancestors")
  private Boolean ancestors = null;

  @SerializedName("WithVersions")
  private Boolean withVersions = null;

  @SerializedName("WithCommits")
  private Boolean withCommits = null;

  @SerializedName("Limit")
  private String limit = null;

  @SerializedName("Offset")
  private String offset = null;

  @SerializedName("FilterType")
  private TreeNodeType filterType = null;

  public TreeListNodesRequest node(TreeNode node) {
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @ApiModelProperty(value = "")
  public TreeNode getNode() {
    return node;
  }

  public void setNode(TreeNode node) {
    this.node = node;
  }

  public TreeListNodesRequest recursive(Boolean recursive) {
    this.recursive = recursive;
    return this;
  }

   /**
   * Get recursive
   * @return recursive
  **/
  @ApiModelProperty(value = "")
  public Boolean isRecursive() {
    return recursive;
  }

  public void setRecursive(Boolean recursive) {
    this.recursive = recursive;
  }

  public TreeListNodesRequest ancestors(Boolean ancestors) {
    this.ancestors = ancestors;
    return this;
  }

   /**
   * Get ancestors
   * @return ancestors
  **/
  @ApiModelProperty(value = "")
  public Boolean isAncestors() {
    return ancestors;
  }

  public void setAncestors(Boolean ancestors) {
    this.ancestors = ancestors;
  }

  public TreeListNodesRequest withVersions(Boolean withVersions) {
    this.withVersions = withVersions;
    return this;
  }

   /**
   * Get withVersions
   * @return withVersions
  **/
  @ApiModelProperty(value = "")
  public Boolean isWithVersions() {
    return withVersions;
  }

  public void setWithVersions(Boolean withVersions) {
    this.withVersions = withVersions;
  }

  public TreeListNodesRequest withCommits(Boolean withCommits) {
    this.withCommits = withCommits;
    return this;
  }

   /**
   * Get withCommits
   * @return withCommits
  **/
  @ApiModelProperty(value = "")
  public Boolean isWithCommits() {
    return withCommits;
  }

  public void setWithCommits(Boolean withCommits) {
    this.withCommits = withCommits;
  }

  public TreeListNodesRequest limit(String limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")
  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public TreeListNodesRequest offset(String offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public TreeListNodesRequest filterType(TreeNodeType filterType) {
    this.filterType = filterType;
    return this;
  }

   /**
   * Get filterType
   * @return filterType
  **/
  @ApiModelProperty(value = "")
  public TreeNodeType getFilterType() {
    return filterType;
  }

  public void setFilterType(TreeNodeType filterType) {
    this.filterType = filterType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeListNodesRequest treeListNodesRequest = (TreeListNodesRequest) o;
    return Objects.equals(this.node, treeListNodesRequest.node) &&
        Objects.equals(this.recursive, treeListNodesRequest.recursive) &&
        Objects.equals(this.ancestors, treeListNodesRequest.ancestors) &&
        Objects.equals(this.withVersions, treeListNodesRequest.withVersions) &&
        Objects.equals(this.withCommits, treeListNodesRequest.withCommits) &&
        Objects.equals(this.limit, treeListNodesRequest.limit) &&
        Objects.equals(this.offset, treeListNodesRequest.offset) &&
        Objects.equals(this.filterType, treeListNodesRequest.filterType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(node, recursive, ancestors, withVersions, withCommits, limit, offset, filterType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeListNodesRequest {\n");
    
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
    sb.append("    recursive: ").append(toIndentedString(recursive)).append("\n");
    sb.append("    ancestors: ").append(toIndentedString(ancestors)).append("\n");
    sb.append("    withVersions: ").append(toIndentedString(withVersions)).append("\n");
    sb.append("    withCommits: ").append(toIndentedString(withCommits)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    filterType: ").append(toIndentedString(filterType)).append("\n");
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

