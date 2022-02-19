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
import com.pydio.cells.openapi.model.ListSharedResourcesRequestListShareType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestListSharedResourcesRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestListSharedResourcesRequest {
  public static final String SERIALIZED_NAME_SHARE_TYPE = "ShareType";
  @SerializedName(SERIALIZED_NAME_SHARE_TYPE)
  private ListSharedResourcesRequestListShareType shareType = ListSharedResourcesRequestListShareType.ANY;

  public static final String SERIALIZED_NAME_SUBJECT = "Subject";
  @SerializedName(SERIALIZED_NAME_SUBJECT)
  private String subject;

  public static final String SERIALIZED_NAME_OWNED_BY_SUBJECT = "OwnedBySubject";
  @SerializedName(SERIALIZED_NAME_OWNED_BY_SUBJECT)
  private Boolean ownedBySubject;

  public static final String SERIALIZED_NAME_OFFSET = "Offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private Integer offset;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private Integer limit;

  public RestListSharedResourcesRequest() { 
  }

  public RestListSharedResourcesRequest shareType(ListSharedResourcesRequestListShareType shareType) {
    
    this.shareType = shareType;
    return this;
  }

   /**
   * Get shareType
   * @return shareType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ListSharedResourcesRequestListShareType getShareType() {
    return shareType;
  }


  public void setShareType(ListSharedResourcesRequestListShareType shareType) {
    this.shareType = shareType;
  }


  public RestListSharedResourcesRequest subject(String subject) {
    
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSubject() {
    return subject;
  }


  public void setSubject(String subject) {
    this.subject = subject;
  }


  public RestListSharedResourcesRequest ownedBySubject(Boolean ownedBySubject) {
    
    this.ownedBySubject = ownedBySubject;
    return this;
  }

   /**
   * Get ownedBySubject
   * @return ownedBySubject
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getOwnedBySubject() {
    return ownedBySubject;
  }


  public void setOwnedBySubject(Boolean ownedBySubject) {
    this.ownedBySubject = ownedBySubject;
  }


  public RestListSharedResourcesRequest offset(Integer offset) {
    
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getOffset() {
    return offset;
  }


  public void setOffset(Integer offset) {
    this.offset = offset;
  }


  public RestListSharedResourcesRequest limit(Integer limit) {
    
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLimit() {
    return limit;
  }


  public void setLimit(Integer limit) {
    this.limit = limit;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestListSharedResourcesRequest restListSharedResourcesRequest = (RestListSharedResourcesRequest) o;
    return Objects.equals(this.shareType, restListSharedResourcesRequest.shareType) &&
        Objects.equals(this.subject, restListSharedResourcesRequest.subject) &&
        Objects.equals(this.ownedBySubject, restListSharedResourcesRequest.ownedBySubject) &&
        Objects.equals(this.offset, restListSharedResourcesRequest.offset) &&
        Objects.equals(this.limit, restListSharedResourcesRequest.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shareType, subject, ownedBySubject, offset, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListSharedResourcesRequest {\n");
    sb.append("    shareType: ").append(toIndentedString(shareType)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    ownedBySubject: ").append(toIndentedString(ownedBySubject)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

