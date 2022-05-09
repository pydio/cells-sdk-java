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
import com.pydio.cells.openapi.model.IdmWorkspace;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestWorkspaceCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestWorkspaceCollection {
  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public static final String SERIALIZED_NAME_WORKSPACES = "Workspaces";
  @SerializedName(SERIALIZED_NAME_WORKSPACES)
  private List<IdmWorkspace> workspaces = null;

  public RestWorkspaceCollection() { 
  }

  public RestWorkspaceCollection total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }


  public RestWorkspaceCollection workspaces(List<IdmWorkspace> workspaces) {
    
    this.workspaces = workspaces;
    return this;
  }

  public RestWorkspaceCollection addWorkspacesItem(IdmWorkspace workspacesItem) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList<IdmWorkspace>();
    }
    this.workspaces.add(workspacesItem);
    return this;
  }

   /**
   * Get workspaces
   * @return workspaces
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmWorkspace> getWorkspaces() {
    return workspaces;
  }


  public void setWorkspaces(List<IdmWorkspace> workspaces) {
    this.workspaces = workspaces;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestWorkspaceCollection restWorkspaceCollection = (RestWorkspaceCollection) o;
    return Objects.equals(this.total, restWorkspaceCollection.total) &&
        Objects.equals(this.workspaces, restWorkspaceCollection.workspaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(total, workspaces);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestWorkspaceCollection {\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    workspaces: ").append(toIndentedString(workspaces)).append("\n");
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

