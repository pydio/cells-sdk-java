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


package com.pydio.sdk.core.api.cells.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.sdk.core.api.cells.model.TreeNodeChangeEvent;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TreeChangeLog
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class TreeChangeLog {
  @SerializedName("Uuid")
  private String uuid = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("MTime")
  private String mtime = null;

  @SerializedName("Size")
  private String size = null;

  @SerializedName("Data")
  private byte[] data = null;

  @SerializedName("OwnerUuid")
  private String ownerUuid = null;

  @SerializedName("Event")
  private TreeNodeChangeEvent event = null;

  public TreeChangeLog uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public TreeChangeLog description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TreeChangeLog mtime(String mtime) {
    this.mtime = mtime;
    return this;
  }

   /**
   * Get mtime
   * @return mtime
  **/
  @ApiModelProperty(value = "")
  public String getMtime() {
    return mtime;
  }

  public void setMtime(String mtime) {
    this.mtime = mtime;
  }

  public TreeChangeLog size(String size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")
  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public TreeChangeLog data(byte[] data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")
  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public TreeChangeLog ownerUuid(String ownerUuid) {
    this.ownerUuid = ownerUuid;
    return this;
  }

   /**
   * Get ownerUuid
   * @return ownerUuid
  **/
  @ApiModelProperty(value = "")
  public String getOwnerUuid() {
    return ownerUuid;
  }

  public void setOwnerUuid(String ownerUuid) {
    this.ownerUuid = ownerUuid;
  }

  public TreeChangeLog event(TreeNodeChangeEvent event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")
  public TreeNodeChangeEvent getEvent() {
    return event;
  }

  public void setEvent(TreeNodeChangeEvent event) {
    this.event = event;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeChangeLog treeChangeLog = (TreeChangeLog) o;
    return Objects.equals(this.uuid, treeChangeLog.uuid) &&
        Objects.equals(this.description, treeChangeLog.description) &&
        Objects.equals(this.mtime, treeChangeLog.mtime) &&
        Objects.equals(this.size, treeChangeLog.size) &&
        Arrays.equals(this.data, treeChangeLog.data) &&
        Objects.equals(this.ownerUuid, treeChangeLog.ownerUuid) &&
        Objects.equals(this.event, treeChangeLog.event);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, description, mtime, size, Arrays.hashCode(data), ownerUuid, event);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeChangeLog {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    mtime: ").append(toIndentedString(mtime)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    ownerUuid: ").append(toIndentedString(ownerUuid)).append("\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
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

