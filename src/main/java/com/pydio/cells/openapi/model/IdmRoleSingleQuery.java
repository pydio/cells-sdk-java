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
import java.util.ArrayList;
import java.util.List;

/**
 * RoleSingleQuery is the basic unit for building queries to Roles.
 */
@ApiModel(description = "RoleSingleQuery is the basic unit for building queries to Roles.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class IdmRoleSingleQuery {
  @SerializedName("Uuid")
  private List<String> uuid = null;

  @SerializedName("Label")
  private String label = null;

  @SerializedName("IsTeam")
  private Boolean isTeam = null;

  @SerializedName("IsGroupRole")
  private Boolean isGroupRole = null;

  @SerializedName("IsUserRole")
  private Boolean isUserRole = null;

  @SerializedName("HasAutoApply")
  private Boolean hasAutoApply = null;

  @SerializedName("not")
  private Boolean not = null;

  public IdmRoleSingleQuery uuid(List<String> uuid) {
    this.uuid = uuid;
    return this;
  }

  public IdmRoleSingleQuery addUuidItem(String uuidItem) {
    if (this.uuid == null) {
      this.uuid = new ArrayList<String>();
    }
    this.uuid.add(uuidItem);
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public List<String> getUuid() {
    return uuid;
  }

  public void setUuid(List<String> uuid) {
    this.uuid = uuid;
  }

  public IdmRoleSingleQuery label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public IdmRoleSingleQuery isTeam(Boolean isTeam) {
    this.isTeam = isTeam;
    return this;
  }

   /**
   * Get isTeam
   * @return isTeam
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsTeam() {
    return isTeam;
  }

  public void setIsTeam(Boolean isTeam) {
    this.isTeam = isTeam;
  }

  public IdmRoleSingleQuery isGroupRole(Boolean isGroupRole) {
    this.isGroupRole = isGroupRole;
    return this;
  }

   /**
   * Get isGroupRole
   * @return isGroupRole
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsGroupRole() {
    return isGroupRole;
  }

  public void setIsGroupRole(Boolean isGroupRole) {
    this.isGroupRole = isGroupRole;
  }

  public IdmRoleSingleQuery isUserRole(Boolean isUserRole) {
    this.isUserRole = isUserRole;
    return this;
  }

   /**
   * Get isUserRole
   * @return isUserRole
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsUserRole() {
    return isUserRole;
  }

  public void setIsUserRole(Boolean isUserRole) {
    this.isUserRole = isUserRole;
  }

  public IdmRoleSingleQuery hasAutoApply(Boolean hasAutoApply) {
    this.hasAutoApply = hasAutoApply;
    return this;
  }

   /**
   * Get hasAutoApply
   * @return hasAutoApply
  **/
  @ApiModelProperty(value = "")
  public Boolean isHasAutoApply() {
    return hasAutoApply;
  }

  public void setHasAutoApply(Boolean hasAutoApply) {
    this.hasAutoApply = hasAutoApply;
  }

  public IdmRoleSingleQuery not(Boolean not) {
    this.not = not;
    return this;
  }

   /**
   * Get not
   * @return not
  **/
  @ApiModelProperty(value = "")
  public Boolean isNot() {
    return not;
  }

  public void setNot(Boolean not) {
    this.not = not;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmRoleSingleQuery idmRoleSingleQuery = (IdmRoleSingleQuery) o;
    return Objects.equals(this.uuid, idmRoleSingleQuery.uuid) &&
        Objects.equals(this.label, idmRoleSingleQuery.label) &&
        Objects.equals(this.isTeam, idmRoleSingleQuery.isTeam) &&
        Objects.equals(this.isGroupRole, idmRoleSingleQuery.isGroupRole) &&
        Objects.equals(this.isUserRole, idmRoleSingleQuery.isUserRole) &&
        Objects.equals(this.hasAutoApply, idmRoleSingleQuery.hasAutoApply) &&
        Objects.equals(this.not, idmRoleSingleQuery.not);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, label, isTeam, isGroupRole, isUserRole, hasAutoApply, not);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmRoleSingleQuery {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    isTeam: ").append(toIndentedString(isTeam)).append("\n");
    sb.append("    isGroupRole: ").append(toIndentedString(isGroupRole)).append("\n");
    sb.append("    isUserRole: ").append(toIndentedString(isUserRole)).append("\n");
    sb.append("    hasAutoApply: ").append(toIndentedString(hasAutoApply)).append("\n");
    sb.append("    not: ").append(toIndentedString(not)).append("\n");
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

