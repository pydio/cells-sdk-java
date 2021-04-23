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
import com.pydio.sdk.core.api.cells.model.RestPagination;
import com.pydio.sdk.core.api.cells.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestBulkMetaResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestBulkMetaResponse {
  @SerializedName("Nodes")
  private List<TreeNode> nodes = null;

  @SerializedName("Pagination")
  private RestPagination pagination = null;

  public RestBulkMetaResponse nodes(List<TreeNode> nodes) {
    this.nodes = nodes;
    return this;
  }

  public RestBulkMetaResponse addNodesItem(TreeNode nodesItem) {
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
  @ApiModelProperty(value = "")
  public List<TreeNode> getNodes() {
    return nodes;
  }

  public void setNodes(List<TreeNode> nodes) {
    this.nodes = nodes;
  }

  public RestBulkMetaResponse pagination(RestPagination pagination) {
    this.pagination = pagination;
    return this;
  }

   /**
   * Get pagination
   * @return pagination
  **/
  @ApiModelProperty(value = "")
  public RestPagination getPagination() {
    return pagination;
  }

  public void setPagination(RestPagination pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestBulkMetaResponse restBulkMetaResponse = (RestBulkMetaResponse) o;
    return Objects.equals(this.nodes, restBulkMetaResponse.nodes) &&
        Objects.equals(this.pagination, restBulkMetaResponse.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, pagination);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestBulkMetaResponse {\n");
    
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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

