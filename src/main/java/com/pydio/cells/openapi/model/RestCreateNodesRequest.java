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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestCreateNodesRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestCreateNodesRequest {
  @SerializedName("Nodes")
  private List<TreeNode> nodes = null;

  @SerializedName("Recursive")
  private Boolean recursive = null;

  @SerializedName("TemplateUUID")
  private String templateUUID = null;

  public RestCreateNodesRequest nodes(List<TreeNode> nodes) {
    this.nodes = nodes;
    return this;
  }

  public RestCreateNodesRequest addNodesItem(TreeNode nodesItem) {
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

  public RestCreateNodesRequest recursive(Boolean recursive) {
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

  public RestCreateNodesRequest templateUUID(String templateUUID) {
    this.templateUUID = templateUUID;
    return this;
  }

   /**
   * Get templateUUID
   * @return templateUUID
  **/
  @ApiModelProperty(value = "")
  public String getTemplateUUID() {
    return templateUUID;
  }

  public void setTemplateUUID(String templateUUID) {
    this.templateUUID = templateUUID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestCreateNodesRequest restCreateNodesRequest = (RestCreateNodesRequest) o;
    return Objects.equals(this.nodes, restCreateNodesRequest.nodes) &&
        Objects.equals(this.recursive, restCreateNodesRequest.recursive) &&
        Objects.equals(this.templateUUID, restCreateNodesRequest.templateUUID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, recursive, templateUUID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCreateNodesRequest {\n");
    
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    recursive: ").append(toIndentedString(recursive)).append("\n");
    sb.append("    templateUUID: ").append(toIndentedString(templateUUID)).append("\n");
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

