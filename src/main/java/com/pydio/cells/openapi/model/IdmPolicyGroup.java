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
import com.pydio.cells.openapi.model.IdmPolicy;
import com.pydio.cells.openapi.model.IdmPolicyResourceGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IdmPolicyGroup
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class IdmPolicyGroup {
  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_LAST_UPDATED = "LastUpdated";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATED)
  private Integer lastUpdated;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_OWNER_UUID = "OwnerUuid";
  @SerializedName(SERIALIZED_NAME_OWNER_UUID)
  private String ownerUuid;

  public static final String SERIALIZED_NAME_POLICIES = "Policies";
  @SerializedName(SERIALIZED_NAME_POLICIES)
  private List<IdmPolicy> policies = null;

  public static final String SERIALIZED_NAME_RESOURCE_GROUP = "ResourceGroup";
  @SerializedName(SERIALIZED_NAME_RESOURCE_GROUP)
  private IdmPolicyResourceGroup resourceGroup = IdmPolicyResourceGroup.REST;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public IdmPolicyGroup() { 
  }

  public IdmPolicyGroup description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public IdmPolicyGroup lastUpdated(Integer lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLastUpdated() {
    return lastUpdated;
  }


  public void setLastUpdated(Integer lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public IdmPolicyGroup name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public IdmPolicyGroup ownerUuid(String ownerUuid) {
    
    this.ownerUuid = ownerUuid;
    return this;
  }

   /**
   * Get ownerUuid
   * @return ownerUuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOwnerUuid() {
    return ownerUuid;
  }


  public void setOwnerUuid(String ownerUuid) {
    this.ownerUuid = ownerUuid;
  }


  public IdmPolicyGroup policies(List<IdmPolicy> policies) {
    
    this.policies = policies;
    return this;
  }

  public IdmPolicyGroup addPoliciesItem(IdmPolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<IdmPolicy>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmPolicy> getPolicies() {
    return policies;
  }


  public void setPolicies(List<IdmPolicy> policies) {
    this.policies = policies;
  }


  public IdmPolicyGroup resourceGroup(IdmPolicyResourceGroup resourceGroup) {
    
    this.resourceGroup = resourceGroup;
    return this;
  }

   /**
   * Get resourceGroup
   * @return resourceGroup
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmPolicyResourceGroup getResourceGroup() {
    return resourceGroup;
  }


  public void setResourceGroup(IdmPolicyResourceGroup resourceGroup) {
    this.resourceGroup = resourceGroup;
  }


  public IdmPolicyGroup uuid(String uuid) {
    
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUuid() {
    return uuid;
  }


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmPolicyGroup idmPolicyGroup = (IdmPolicyGroup) o;
    return Objects.equals(this.description, idmPolicyGroup.description) &&
        Objects.equals(this.lastUpdated, idmPolicyGroup.lastUpdated) &&
        Objects.equals(this.name, idmPolicyGroup.name) &&
        Objects.equals(this.ownerUuid, idmPolicyGroup.ownerUuid) &&
        Objects.equals(this.policies, idmPolicyGroup.policies) &&
        Objects.equals(this.resourceGroup, idmPolicyGroup.resourceGroup) &&
        Objects.equals(this.uuid, idmPolicyGroup.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, lastUpdated, name, ownerUuid, policies, resourceGroup, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmPolicyGroup {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerUuid: ").append(toIndentedString(ownerUuid)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
    sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

