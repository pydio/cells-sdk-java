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
import com.pydio.cells.openapi.model.IdmRole;
import com.pydio.cells.openapi.model.IdmWorkspace;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestRelationResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class RestRelationResponse {
  @SerializedName("SharedCells")
  private List<IdmWorkspace> sharedCells = null;

  @SerializedName("BelongsToTeams")
  private List<IdmRole> belongsToTeams = null;

  public RestRelationResponse sharedCells(List<IdmWorkspace> sharedCells) {
    this.sharedCells = sharedCells;
    return this;
  }

  public RestRelationResponse addSharedCellsItem(IdmWorkspace sharedCellsItem) {
    if (this.sharedCells == null) {
      this.sharedCells = new ArrayList<IdmWorkspace>();
    }
    this.sharedCells.add(sharedCellsItem);
    return this;
  }

   /**
   * Get sharedCells
   * @return sharedCells
  **/
  @ApiModelProperty(value = "")
  public List<IdmWorkspace> getSharedCells() {
    return sharedCells;
  }

  public void setSharedCells(List<IdmWorkspace> sharedCells) {
    this.sharedCells = sharedCells;
  }

  public RestRelationResponse belongsToTeams(List<IdmRole> belongsToTeams) {
    this.belongsToTeams = belongsToTeams;
    return this;
  }

  public RestRelationResponse addBelongsToTeamsItem(IdmRole belongsToTeamsItem) {
    if (this.belongsToTeams == null) {
      this.belongsToTeams = new ArrayList<IdmRole>();
    }
    this.belongsToTeams.add(belongsToTeamsItem);
    return this;
  }

   /**
   * Get belongsToTeams
   * @return belongsToTeams
  **/
  @ApiModelProperty(value = "")
  public List<IdmRole> getBelongsToTeams() {
    return belongsToTeams;
  }

  public void setBelongsToTeams(List<IdmRole> belongsToTeams) {
    this.belongsToTeams = belongsToTeams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestRelationResponse restRelationResponse = (RestRelationResponse) o;
    return Objects.equals(this.sharedCells, restRelationResponse.sharedCells) &&
        Objects.equals(this.belongsToTeams, restRelationResponse.belongsToTeams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sharedCells, belongsToTeams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRelationResponse {\n");
    
    sb.append("    sharedCells: ").append(toIndentedString(sharedCells)).append("\n");
    sb.append("    belongsToTeams: ").append(toIndentedString(belongsToTeams)).append("\n");
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

