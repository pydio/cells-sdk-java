/*
 * Pydio Cells Rest API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0
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
import com.pydio.cells.openapi.model.ActivityOwnerType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ActivitySearchSubscriptionsRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class ActivitySearchSubscriptionsRequest {
  public static final String SERIALIZED_NAME_USER_IDS = "UserIds";
  @SerializedName(SERIALIZED_NAME_USER_IDS)
  private List<String> userIds = null;

  public static final String SERIALIZED_NAME_OBJECT_TYPES = "ObjectTypes";
  @SerializedName(SERIALIZED_NAME_OBJECT_TYPES)
  private List<ActivityOwnerType> objectTypes = null;

  public static final String SERIALIZED_NAME_OBJECT_IDS = "ObjectIds";
  @SerializedName(SERIALIZED_NAME_OBJECT_IDS)
  private List<String> objectIds = null;

  public ActivitySearchSubscriptionsRequest() { 
  }

  public ActivitySearchSubscriptionsRequest userIds(List<String> userIds) {
    
    this.userIds = userIds;
    return this;
  }

  public ActivitySearchSubscriptionsRequest addUserIdsItem(String userIdsItem) {
    if (this.userIds == null) {
      this.userIds = new ArrayList<String>();
    }
    this.userIds.add(userIdsItem);
    return this;
  }

   /**
   * Get userIds
   * @return userIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getUserIds() {
    return userIds;
  }


  public void setUserIds(List<String> userIds) {
    this.userIds = userIds;
  }


  public ActivitySearchSubscriptionsRequest objectTypes(List<ActivityOwnerType> objectTypes) {
    
    this.objectTypes = objectTypes;
    return this;
  }

  public ActivitySearchSubscriptionsRequest addObjectTypesItem(ActivityOwnerType objectTypesItem) {
    if (this.objectTypes == null) {
      this.objectTypes = new ArrayList<ActivityOwnerType>();
    }
    this.objectTypes.add(objectTypesItem);
    return this;
  }

   /**
   * Get objectTypes
   * @return objectTypes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ActivityOwnerType> getObjectTypes() {
    return objectTypes;
  }


  public void setObjectTypes(List<ActivityOwnerType> objectTypes) {
    this.objectTypes = objectTypes;
  }


  public ActivitySearchSubscriptionsRequest objectIds(List<String> objectIds) {
    
    this.objectIds = objectIds;
    return this;
  }

  public ActivitySearchSubscriptionsRequest addObjectIdsItem(String objectIdsItem) {
    if (this.objectIds == null) {
      this.objectIds = new ArrayList<String>();
    }
    this.objectIds.add(objectIdsItem);
    return this;
  }

   /**
   * Get objectIds
   * @return objectIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getObjectIds() {
    return objectIds;
  }


  public void setObjectIds(List<String> objectIds) {
    this.objectIds = objectIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivitySearchSubscriptionsRequest activitySearchSubscriptionsRequest = (ActivitySearchSubscriptionsRequest) o;
    return Objects.equals(this.userIds, activitySearchSubscriptionsRequest.userIds) &&
        Objects.equals(this.objectTypes, activitySearchSubscriptionsRequest.objectTypes) &&
        Objects.equals(this.objectIds, activitySearchSubscriptionsRequest.objectIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userIds, objectTypes, objectIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivitySearchSubscriptionsRequest {\n");
    sb.append("    userIds: ").append(toIndentedString(userIds)).append("\n");
    sb.append("    objectTypes: ").append(toIndentedString(objectTypes)).append("\n");
    sb.append("    objectIds: ").append(toIndentedString(objectIds)).append("\n");
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

