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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TreeWorkspaceRelativePath
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class TreeWorkspaceRelativePath {
  public static final String SERIALIZED_NAME_PATH = "Path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path;

  public static final String SERIALIZED_NAME_WS_LABEL = "WsLabel";
  @SerializedName(SERIALIZED_NAME_WS_LABEL)
  private String wsLabel;

  public static final String SERIALIZED_NAME_WS_SCOPE = "WsScope";
  @SerializedName(SERIALIZED_NAME_WS_SCOPE)
  private String wsScope;

  public static final String SERIALIZED_NAME_WS_SLUG = "WsSlug";
  @SerializedName(SERIALIZED_NAME_WS_SLUG)
  private String wsSlug;

  public static final String SERIALIZED_NAME_WS_UUID = "WsUuid";
  @SerializedName(SERIALIZED_NAME_WS_UUID)
  private String wsUuid;

  public TreeWorkspaceRelativePath() { 
  }

  public TreeWorkspaceRelativePath path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public TreeWorkspaceRelativePath wsLabel(String wsLabel) {
    
    this.wsLabel = wsLabel;
    return this;
  }

   /**
   * Get wsLabel
   * @return wsLabel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsLabel() {
    return wsLabel;
  }


  public void setWsLabel(String wsLabel) {
    this.wsLabel = wsLabel;
  }


  public TreeWorkspaceRelativePath wsScope(String wsScope) {
    
    this.wsScope = wsScope;
    return this;
  }

   /**
   * Get wsScope
   * @return wsScope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsScope() {
    return wsScope;
  }


  public void setWsScope(String wsScope) {
    this.wsScope = wsScope;
  }


  public TreeWorkspaceRelativePath wsSlug(String wsSlug) {
    
    this.wsSlug = wsSlug;
    return this;
  }

   /**
   * Get wsSlug
   * @return wsSlug
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsSlug() {
    return wsSlug;
  }


  public void setWsSlug(String wsSlug) {
    this.wsSlug = wsSlug;
  }


  public TreeWorkspaceRelativePath wsUuid(String wsUuid) {
    
    this.wsUuid = wsUuid;
    return this;
  }

   /**
   * Get wsUuid
   * @return wsUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getWsUuid() {
    return wsUuid;
  }


  public void setWsUuid(String wsUuid) {
    this.wsUuid = wsUuid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeWorkspaceRelativePath treeWorkspaceRelativePath = (TreeWorkspaceRelativePath) o;
    return Objects.equals(this.path, treeWorkspaceRelativePath.path) &&
        Objects.equals(this.wsLabel, treeWorkspaceRelativePath.wsLabel) &&
        Objects.equals(this.wsScope, treeWorkspaceRelativePath.wsScope) &&
        Objects.equals(this.wsSlug, treeWorkspaceRelativePath.wsSlug) &&
        Objects.equals(this.wsUuid, treeWorkspaceRelativePath.wsUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, wsLabel, wsScope, wsSlug, wsUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeWorkspaceRelativePath {\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    wsLabel: ").append(toIndentedString(wsLabel)).append("\n");
    sb.append("    wsScope: ").append(toIndentedString(wsScope)).append("\n");
    sb.append("    wsSlug: ").append(toIndentedString(wsSlug)).append("\n");
    sb.append("    wsUuid: ").append(toIndentedString(wsUuid)).append("\n");
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

