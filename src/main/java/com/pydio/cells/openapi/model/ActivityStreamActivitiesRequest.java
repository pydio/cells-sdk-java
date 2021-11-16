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
import com.pydio.cells.openapi.model.ActivityStreamContext;
import com.pydio.cells.openapi.model.ActivitySummaryPointOfView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ActivityStreamActivitiesRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class ActivityStreamActivitiesRequest {
  @SerializedName("Context")
  private ActivityStreamContext context = null;

  @SerializedName("ContextData")
  private String contextData = null;

  @SerializedName("StreamFilter")
  private String streamFilter = null;

  @SerializedName("BoxName")
  private String boxName = null;

  @SerializedName("UnreadCountOnly")
  private Boolean unreadCountOnly = null;

  @SerializedName("Offset")
  private String offset = null;

  @SerializedName("Limit")
  private String limit = null;

  @SerializedName("AsDigest")
  private Boolean asDigest = null;

  @SerializedName("PointOfView")
  private ActivitySummaryPointOfView pointOfView = null;

  @SerializedName("Language")
  private String language = null;

  public ActivityStreamActivitiesRequest context(ActivityStreamContext context) {
    this.context = context;
    return this;
  }

   /**
   * Get context
   * @return context
  **/
  @ApiModelProperty(value = "")
  public ActivityStreamContext getContext() {
    return context;
  }

  public void setContext(ActivityStreamContext context) {
    this.context = context;
  }

  public ActivityStreamActivitiesRequest contextData(String contextData) {
    this.contextData = contextData;
    return this;
  }

   /**
   * Get contextData
   * @return contextData
  **/
  @ApiModelProperty(value = "")
  public String getContextData() {
    return contextData;
  }

  public void setContextData(String contextData) {
    this.contextData = contextData;
  }

  public ActivityStreamActivitiesRequest streamFilter(String streamFilter) {
    this.streamFilter = streamFilter;
    return this;
  }

   /**
   * Get streamFilter
   * @return streamFilter
  **/
  @ApiModelProperty(value = "")
  public String getStreamFilter() {
    return streamFilter;
  }

  public void setStreamFilter(String streamFilter) {
    this.streamFilter = streamFilter;
  }

  public ActivityStreamActivitiesRequest boxName(String boxName) {
    this.boxName = boxName;
    return this;
  }

   /**
   * Get boxName
   * @return boxName
  **/
  @ApiModelProperty(value = "")
  public String getBoxName() {
    return boxName;
  }

  public void setBoxName(String boxName) {
    this.boxName = boxName;
  }

  public ActivityStreamActivitiesRequest unreadCountOnly(Boolean unreadCountOnly) {
    this.unreadCountOnly = unreadCountOnly;
    return this;
  }

   /**
   * Get unreadCountOnly
   * @return unreadCountOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean isUnreadCountOnly() {
    return unreadCountOnly;
  }

  public void setUnreadCountOnly(Boolean unreadCountOnly) {
    this.unreadCountOnly = unreadCountOnly;
  }

  public ActivityStreamActivitiesRequest offset(String offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public ActivityStreamActivitiesRequest limit(String limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")
  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public ActivityStreamActivitiesRequest asDigest(Boolean asDigest) {
    this.asDigest = asDigest;
    return this;
  }

   /**
   * Get asDigest
   * @return asDigest
  **/
  @ApiModelProperty(value = "")
  public Boolean isAsDigest() {
    return asDigest;
  }

  public void setAsDigest(Boolean asDigest) {
    this.asDigest = asDigest;
  }

  public ActivityStreamActivitiesRequest pointOfView(ActivitySummaryPointOfView pointOfView) {
    this.pointOfView = pointOfView;
    return this;
  }

   /**
   * Get pointOfView
   * @return pointOfView
  **/
  @ApiModelProperty(value = "")
  public ActivitySummaryPointOfView getPointOfView() {
    return pointOfView;
  }

  public void setPointOfView(ActivitySummaryPointOfView pointOfView) {
    this.pointOfView = pointOfView;
  }

  public ActivityStreamActivitiesRequest language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Provide language information for building the human-readable strings.
   * @return language
  **/
  @ApiModelProperty(value = "Provide language information for building the human-readable strings.")
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityStreamActivitiesRequest activityStreamActivitiesRequest = (ActivityStreamActivitiesRequest) o;
    return Objects.equals(this.context, activityStreamActivitiesRequest.context) &&
        Objects.equals(this.contextData, activityStreamActivitiesRequest.contextData) &&
        Objects.equals(this.streamFilter, activityStreamActivitiesRequest.streamFilter) &&
        Objects.equals(this.boxName, activityStreamActivitiesRequest.boxName) &&
        Objects.equals(this.unreadCountOnly, activityStreamActivitiesRequest.unreadCountOnly) &&
        Objects.equals(this.offset, activityStreamActivitiesRequest.offset) &&
        Objects.equals(this.limit, activityStreamActivitiesRequest.limit) &&
        Objects.equals(this.asDigest, activityStreamActivitiesRequest.asDigest) &&
        Objects.equals(this.pointOfView, activityStreamActivitiesRequest.pointOfView) &&
        Objects.equals(this.language, activityStreamActivitiesRequest.language);
  }

  @Override
  public int hashCode() {
    return Objects.hash(context, contextData, streamFilter, boxName, unreadCountOnly, offset, limit, asDigest, pointOfView, language);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityStreamActivitiesRequest {\n");
    
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    contextData: ").append(toIndentedString(contextData)).append("\n");
    sb.append("    streamFilter: ").append(toIndentedString(streamFilter)).append("\n");
    sb.append("    boxName: ").append(toIndentedString(boxName)).append("\n");
    sb.append("    unreadCountOnly: ").append(toIndentedString(unreadCountOnly)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    asDigest: ").append(toIndentedString(asDigest)).append("\n");
    sb.append("    pointOfView: ").append(toIndentedString(pointOfView)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
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

