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
import com.pydio.cells.openapi.model.NodeChangeEventEventType;
import com.pydio.cells.openapi.model.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TreeNodeChangeEvent
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class TreeNodeChangeEvent {
  @SerializedName("Type")
  private NodeChangeEventEventType type = null;

  @SerializedName("Source")
  private TreeNode source = null;

  @SerializedName("Target")
  private TreeNode target = null;

  @SerializedName("Metadata")
  private Map<String, String> metadata = null;

  @SerializedName("Silent")
  private Boolean silent = null;

  @SerializedName("Optimistic")
  private Boolean optimistic = null;

  public TreeNodeChangeEvent type(NodeChangeEventEventType type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  public NodeChangeEventEventType getType() {
    return type;
  }

  public void setType(NodeChangeEventEventType type) {
    this.type = type;
  }

  public TreeNodeChangeEvent source(TreeNode source) {
    this.source = source;
    return this;
  }

   /**
   * Get source
   * @return source
  **/
  @ApiModelProperty(value = "")
  public TreeNode getSource() {
    return source;
  }

  public void setSource(TreeNode source) {
    this.source = source;
  }

  public TreeNodeChangeEvent target(TreeNode target) {
    this.target = target;
    return this;
  }

   /**
   * Get target
   * @return target
  **/
  @ApiModelProperty(value = "")
  public TreeNode getTarget() {
    return target;
  }

  public void setTarget(TreeNode target) {
    this.target = target;
  }

  public TreeNodeChangeEvent metadata(Map<String, String> metadata) {
    this.metadata = metadata;
    return this;
  }

  public TreeNodeChangeEvent putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<String, String>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  public TreeNodeChangeEvent silent(Boolean silent) {
    this.silent = silent;
    return this;
  }

   /**
   * Get silent
   * @return silent
  **/
  @ApiModelProperty(value = "")
  public Boolean isSilent() {
    return silent;
  }

  public void setSilent(Boolean silent) {
    this.silent = silent;
  }

  public TreeNodeChangeEvent optimistic(Boolean optimistic) {
    this.optimistic = optimistic;
    return this;
  }

   /**
   * Get optimistic
   * @return optimistic
  **/
  @ApiModelProperty(value = "")
  public Boolean isOptimistic() {
    return optimistic;
  }

  public void setOptimistic(Boolean optimistic) {
    this.optimistic = optimistic;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeNodeChangeEvent treeNodeChangeEvent = (TreeNodeChangeEvent) o;
    return Objects.equals(this.type, treeNodeChangeEvent.type) &&
        Objects.equals(this.source, treeNodeChangeEvent.source) &&
        Objects.equals(this.target, treeNodeChangeEvent.target) &&
        Objects.equals(this.metadata, treeNodeChangeEvent.metadata) &&
        Objects.equals(this.silent, treeNodeChangeEvent.silent) &&
        Objects.equals(this.optimistic, treeNodeChangeEvent.optimistic);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, source, target, metadata, silent, optimistic);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeNodeChangeEvent {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    silent: ").append(toIndentedString(silent)).append("\n");
    sb.append("    optimistic: ").append(toIndentedString(optimistic)).append("\n");
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

