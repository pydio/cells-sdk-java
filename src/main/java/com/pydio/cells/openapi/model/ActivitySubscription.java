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
import com.pydio.cells.openapi.model.ActivityOwnerType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ActivitySubscription
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class ActivitySubscription {
  public static final String SERIALIZED_NAME_EVENTS = "Events";
  @SerializedName(SERIALIZED_NAME_EVENTS)
  private List<String> events = null;

  public static final String SERIALIZED_NAME_OBJECT_ID = "ObjectId";
  @SerializedName(SERIALIZED_NAME_OBJECT_ID)
  private String objectId;

  public static final String SERIALIZED_NAME_OBJECT_TYPE = "ObjectType";
  @SerializedName(SERIALIZED_NAME_OBJECT_TYPE)
  private ActivityOwnerType objectType = ActivityOwnerType.NODE;

  public static final String SERIALIZED_NAME_USER_ID = "UserId";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private String userId;

  public ActivitySubscription() { 
  }

  public ActivitySubscription events(List<String> events) {
    
    this.events = events;
    return this;
  }

  public ActivitySubscription addEventsItem(String eventsItem) {
    if (this.events == null) {
      this.events = new ArrayList<String>();
    }
    this.events.add(eventsItem);
    return this;
  }

   /**
   * Get events
   * @return events
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getEvents() {
    return events;
  }


  public void setEvents(List<String> events) {
    this.events = events;
  }


  public ActivitySubscription objectId(String objectId) {
    
    this.objectId = objectId;
    return this;
  }

   /**
   * Get objectId
   * @return objectId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getObjectId() {
    return objectId;
  }


  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }


  public ActivitySubscription objectType(ActivityOwnerType objectType) {
    
    this.objectType = objectType;
    return this;
  }

   /**
   * Get objectType
   * @return objectType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ActivityOwnerType getObjectType() {
    return objectType;
  }


  public void setObjectType(ActivityOwnerType objectType) {
    this.objectType = objectType;
  }


  public ActivitySubscription userId(String userId) {
    
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUserId() {
    return userId;
  }


  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivitySubscription activitySubscription = (ActivitySubscription) o;
    return Objects.equals(this.events, activitySubscription.events) &&
        Objects.equals(this.objectId, activitySubscription.objectId) &&
        Objects.equals(this.objectType, activitySubscription.objectType) &&
        Objects.equals(this.userId, activitySubscription.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(events, objectId, objectType, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivitySubscription {\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectType: ").append(toIndentedString(objectType)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

