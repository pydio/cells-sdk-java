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
import com.pydio.cells.openapi.model.RestPagination;
import com.pydio.cells.openapi.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestBulkMetaResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestBulkMetaResponse {
  public static final String SERIALIZED_NAME_NODES = "Nodes";
  @SerializedName(SERIALIZED_NAME_NODES)
  private List<TreeNode> nodes = null;

  public static final String SERIALIZED_NAME_PAGINATION = "Pagination";
  @SerializedName(SERIALIZED_NAME_PAGINATION)
  private RestPagination pagination;

  public RestBulkMetaResponse() { 
  }

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
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RestPagination getPagination() {
    return pagination;
  }


  public void setPagination(RestPagination pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

