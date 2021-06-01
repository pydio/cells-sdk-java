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
import com.pydio.cells.openapi.model.CtlPeer;
import com.pydio.cells.openapi.model.CtlServiceStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CtlService
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class CtlService {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Version")
  private String version = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Tag")
  private String tag = null;

  @SerializedName("Controllable")
  private Boolean controllable = null;

  @SerializedName("Status")
  private CtlServiceStatus status = null;

  @SerializedName("RunningPeers")
  private List<CtlPeer> runningPeers = null;

  public CtlService name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CtlService version(String version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public CtlService description(String description) {
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

  public CtlService tag(String tag) {
    this.tag = tag;
    return this;
  }

   /**
   * Get tag
   * @return tag
  **/
  @ApiModelProperty(value = "")
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public CtlService controllable(Boolean controllable) {
    this.controllable = controllable;
    return this;
  }

   /**
   * Get controllable
   * @return controllable
  **/
  @ApiModelProperty(value = "")
  public Boolean isControllable() {
    return controllable;
  }

  public void setControllable(Boolean controllable) {
    this.controllable = controllable;
  }

  public CtlService status(CtlServiceStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public CtlServiceStatus getStatus() {
    return status;
  }

  public void setStatus(CtlServiceStatus status) {
    this.status = status;
  }

  public CtlService runningPeers(List<CtlPeer> runningPeers) {
    this.runningPeers = runningPeers;
    return this;
  }

  public CtlService addRunningPeersItem(CtlPeer runningPeersItem) {
    if (this.runningPeers == null) {
      this.runningPeers = new ArrayList<CtlPeer>();
    }
    this.runningPeers.add(runningPeersItem);
    return this;
  }

   /**
   * Get runningPeers
   * @return runningPeers
  **/
  @ApiModelProperty(value = "")
  public List<CtlPeer> getRunningPeers() {
    return runningPeers;
  }

  public void setRunningPeers(List<CtlPeer> runningPeers) {
    this.runningPeers = runningPeers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CtlService ctlService = (CtlService) o;
    return Objects.equals(this.name, ctlService.name) &&
        Objects.equals(this.version, ctlService.version) &&
        Objects.equals(this.description, ctlService.description) &&
        Objects.equals(this.tag, ctlService.tag) &&
        Objects.equals(this.controllable, ctlService.controllable) &&
        Objects.equals(this.status, ctlService.status) &&
        Objects.equals(this.runningPeers, ctlService.runningPeers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, version, description, tag, controllable, status, runningPeers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CtlService {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
    sb.append("    controllable: ").append(toIndentedString(controllable)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    runningPeers: ").append(toIndentedString(runningPeers)).append("\n");
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

