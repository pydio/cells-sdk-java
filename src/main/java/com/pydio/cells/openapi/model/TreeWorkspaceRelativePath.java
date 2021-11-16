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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TreeWorkspaceRelativePath
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class TreeWorkspaceRelativePath {
  @SerializedName("WsUuid")
  private String wsUuid = null;

  @SerializedName("WsLabel")
  private String wsLabel = null;

  @SerializedName("Path")
  private String path = null;

  @SerializedName("WsSlug")
  private String wsSlug = null;

  @SerializedName("WsScope")
  private String wsScope = null;

  public TreeWorkspaceRelativePath wsUuid(String wsUuid) {
    this.wsUuid = wsUuid;
    return this;
  }

   /**
   * Get wsUuid
   * @return wsUuid
  **/
  @ApiModelProperty(value = "")
  public String getWsUuid() {
    return wsUuid;
  }

  public void setWsUuid(String wsUuid) {
    this.wsUuid = wsUuid;
  }

  public TreeWorkspaceRelativePath wsLabel(String wsLabel) {
    this.wsLabel = wsLabel;
    return this;
  }

   /**
   * Get wsLabel
   * @return wsLabel
  **/
  @ApiModelProperty(value = "")
  public String getWsLabel() {
    return wsLabel;
  }

  public void setWsLabel(String wsLabel) {
    this.wsLabel = wsLabel;
  }

  public TreeWorkspaceRelativePath path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public TreeWorkspaceRelativePath wsSlug(String wsSlug) {
    this.wsSlug = wsSlug;
    return this;
  }

   /**
   * Get wsSlug
   * @return wsSlug
  **/
  @ApiModelProperty(value = "")
  public String getWsSlug() {
    return wsSlug;
  }

  public void setWsSlug(String wsSlug) {
    this.wsSlug = wsSlug;
  }

  public TreeWorkspaceRelativePath wsScope(String wsScope) {
    this.wsScope = wsScope;
    return this;
  }

   /**
   * Get wsScope
   * @return wsScope
  **/
  @ApiModelProperty(value = "")
  public String getWsScope() {
    return wsScope;
  }

  public void setWsScope(String wsScope) {
    this.wsScope = wsScope;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeWorkspaceRelativePath treeWorkspaceRelativePath = (TreeWorkspaceRelativePath) o;
    return Objects.equals(this.wsUuid, treeWorkspaceRelativePath.wsUuid) &&
        Objects.equals(this.wsLabel, treeWorkspaceRelativePath.wsLabel) &&
        Objects.equals(this.path, treeWorkspaceRelativePath.path) &&
        Objects.equals(this.wsSlug, treeWorkspaceRelativePath.wsSlug) &&
        Objects.equals(this.wsScope, treeWorkspaceRelativePath.wsScope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(wsUuid, wsLabel, path, wsSlug, wsScope);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeWorkspaceRelativePath {\n");
    
    sb.append("    wsUuid: ").append(toIndentedString(wsUuid)).append("\n");
    sb.append("    wsLabel: ").append(toIndentedString(wsLabel)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    wsSlug: ").append(toIndentedString(wsSlug)).append("\n");
    sb.append("    wsScope: ").append(toIndentedString(wsScope)).append("\n");
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

