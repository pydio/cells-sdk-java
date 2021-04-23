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
import com.pydio.sdk.core.api.cells.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestCreateSelectionRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestCreateSelectionRequest {
  @SerializedName("Nodes")
  private List<TreeNode> nodes = null;

  @SerializedName("TargetAction")
  private String targetAction = null;

  @SerializedName("Persist")
  private Boolean persist = null;

  public RestCreateSelectionRequest nodes(List<TreeNode> nodes) {
    this.nodes = nodes;
    return this;
  }

  public RestCreateSelectionRequest addNodesItem(TreeNode nodesItem) {
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

  public RestCreateSelectionRequest targetAction(String targetAction) {
    this.targetAction = targetAction;
    return this;
  }

   /**
   * Get targetAction
   * @return targetAction
  **/
  @ApiModelProperty(value = "")
  public String getTargetAction() {
    return targetAction;
  }

  public void setTargetAction(String targetAction) {
    this.targetAction = targetAction;
  }

  public RestCreateSelectionRequest persist(Boolean persist) {
    this.persist = persist;
    return this;
  }

   /**
   * Get persist
   * @return persist
  **/
  @ApiModelProperty(value = "")
  public Boolean isPersist() {
    return persist;
  }

  public void setPersist(Boolean persist) {
    this.persist = persist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestCreateSelectionRequest restCreateSelectionRequest = (RestCreateSelectionRequest) o;
    return Objects.equals(this.nodes, restCreateSelectionRequest.nodes) &&
        Objects.equals(this.targetAction, restCreateSelectionRequest.targetAction) &&
        Objects.equals(this.persist, restCreateSelectionRequest.persist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodes, targetAction, persist);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCreateSelectionRequest {\n");
    
    sb.append("    nodes: ").append(toIndentedString(nodes)).append("\n");
    sb.append("    targetAction: ").append(toIndentedString(targetAction)).append("\n");
    sb.append("    persist: ").append(toIndentedString(persist)).append("\n");
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

