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
import java.util.ArrayList;
import java.util.List;

/**
 * RoleSingleQuery is the basic unit for building queries to Roles.
 */
@ApiModel(description = "RoleSingleQuery is the basic unit for building queries to Roles.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class IdmRoleSingleQuery {
  public static final String SERIALIZED_NAME_HAS_AUTO_APPLY = "HasAutoApply";
  @SerializedName(SERIALIZED_NAME_HAS_AUTO_APPLY)
  private Boolean hasAutoApply;

  public static final String SERIALIZED_NAME_IS_GROUP_ROLE = "IsGroupRole";
  @SerializedName(SERIALIZED_NAME_IS_GROUP_ROLE)
  private Boolean isGroupRole;

  public static final String SERIALIZED_NAME_IS_TEAM = "IsTeam";
  @SerializedName(SERIALIZED_NAME_IS_TEAM)
  private Boolean isTeam;

  public static final String SERIALIZED_NAME_IS_USER_ROLE = "IsUserRole";
  @SerializedName(SERIALIZED_NAME_IS_USER_ROLE)
  private Boolean isUserRole;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private List<String> uuid = null;

  public static final String SERIALIZED_NAME_NOT = "not";
  @SerializedName(SERIALIZED_NAME_NOT)
  private Boolean not;

  public IdmRoleSingleQuery() { 
  }

  public IdmRoleSingleQuery hasAutoApply(Boolean hasAutoApply) {
    
    this.hasAutoApply = hasAutoApply;
    return this;
  }

   /**
   * Get hasAutoApply
   * @return hasAutoApply
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getHasAutoApply() {
    return hasAutoApply;
  }


  public void setHasAutoApply(Boolean hasAutoApply) {
    this.hasAutoApply = hasAutoApply;
  }


  public IdmRoleSingleQuery isGroupRole(Boolean isGroupRole) {
    
    this.isGroupRole = isGroupRole;
    return this;
  }

   /**
   * Get isGroupRole
   * @return isGroupRole
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsGroupRole() {
    return isGroupRole;
  }


  public void setIsGroupRole(Boolean isGroupRole) {
    this.isGroupRole = isGroupRole;
  }


  public IdmRoleSingleQuery isTeam(Boolean isTeam) {
    
    this.isTeam = isTeam;
    return this;
  }

   /**
   * Get isTeam
   * @return isTeam
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsTeam() {
    return isTeam;
  }


  public void setIsTeam(Boolean isTeam) {
    this.isTeam = isTeam;
  }


  public IdmRoleSingleQuery isUserRole(Boolean isUserRole) {
    
    this.isUserRole = isUserRole;
    return this;
  }

   /**
   * Get isUserRole
   * @return isUserRole
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsUserRole() {
    return isUserRole;
  }


  public void setIsUserRole(Boolean isUserRole) {
    this.isUserRole = isUserRole;
  }


  public IdmRoleSingleQuery label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getUuid() {
    return uuid;
  }


  public void setUuid(List<String> uuid) {
    this.uuid = uuid;
  }


  public IdmRoleSingleQuery not(Boolean not) {
    
    this.not = not;
    return this;
  }

   /**
   * Get not
   * @return not
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getNot() {
    return not;
  }


  public void setNot(Boolean not) {
    this.not = not;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmRoleSingleQuery idmRoleSingleQuery = (IdmRoleSingleQuery) o;
    return Objects.equals(this.hasAutoApply, idmRoleSingleQuery.hasAutoApply) &&
        Objects.equals(this.isGroupRole, idmRoleSingleQuery.isGroupRole) &&
        Objects.equals(this.isTeam, idmRoleSingleQuery.isTeam) &&
        Objects.equals(this.isUserRole, idmRoleSingleQuery.isUserRole) &&
        Objects.equals(this.label, idmRoleSingleQuery.label) &&
        Objects.equals(this.uuid, idmRoleSingleQuery.uuid) &&
        Objects.equals(this.not, idmRoleSingleQuery.not);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hasAutoApply, isGroupRole, isTeam, isUserRole, label, uuid, not);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmRoleSingleQuery {\n");
    sb.append("    hasAutoApply: ").append(toIndentedString(hasAutoApply)).append("\n");
    sb.append("    isGroupRole: ").append(toIndentedString(isGroupRole)).append("\n");
    sb.append("    isTeam: ").append(toIndentedString(isTeam)).append("\n");
    sb.append("    isUserRole: ").append(toIndentedString(isUserRole)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    not: ").append(toIndentedString(not)).append("\n");
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

