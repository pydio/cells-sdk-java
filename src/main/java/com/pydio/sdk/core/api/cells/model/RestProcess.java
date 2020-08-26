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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestProcess
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class RestProcess {
  @SerializedName("ID")
  private String ID = null;

  @SerializedName("ParentID")
  private String parentID = null;

  @SerializedName("MetricsPort")
  private Integer metricsPort = null;

  @SerializedName("PeerId")
  private String peerId = null;

  @SerializedName("PeerAddress")
  private String peerAddress = null;

  @SerializedName("StartTag")
  private String startTag = null;

  @SerializedName("Services")
  private List<String> services = null;

  public RestProcess ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @ApiModelProperty(value = "")
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public RestProcess parentID(String parentID) {
    this.parentID = parentID;
    return this;
  }

   /**
   * Get parentID
   * @return parentID
  **/
  @ApiModelProperty(value = "")
  public String getParentID() {
    return parentID;
  }

  public void setParentID(String parentID) {
    this.parentID = parentID;
  }

  public RestProcess metricsPort(Integer metricsPort) {
    this.metricsPort = metricsPort;
    return this;
  }

   /**
   * Get metricsPort
   * @return metricsPort
  **/
  @ApiModelProperty(value = "")
  public Integer getMetricsPort() {
    return metricsPort;
  }

  public void setMetricsPort(Integer metricsPort) {
    this.metricsPort = metricsPort;
  }

  public RestProcess peerId(String peerId) {
    this.peerId = peerId;
    return this;
  }

   /**
   * Get peerId
   * @return peerId
  **/
  @ApiModelProperty(value = "")
  public String getPeerId() {
    return peerId;
  }

  public void setPeerId(String peerId) {
    this.peerId = peerId;
  }

  public RestProcess peerAddress(String peerAddress) {
    this.peerAddress = peerAddress;
    return this;
  }

   /**
   * Get peerAddress
   * @return peerAddress
  **/
  @ApiModelProperty(value = "")
  public String getPeerAddress() {
    return peerAddress;
  }

  public void setPeerAddress(String peerAddress) {
    this.peerAddress = peerAddress;
  }

  public RestProcess startTag(String startTag) {
    this.startTag = startTag;
    return this;
  }

   /**
   * Get startTag
   * @return startTag
  **/
  @ApiModelProperty(value = "")
  public String getStartTag() {
    return startTag;
  }

  public void setStartTag(String startTag) {
    this.startTag = startTag;
  }

  public RestProcess services(List<String> services) {
    this.services = services;
    return this;
  }

  public RestProcess addServicesItem(String servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<String>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @ApiModelProperty(value = "")
  public List<String> getServices() {
    return services;
  }

  public void setServices(List<String> services) {
    this.services = services;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestProcess restProcess = (RestProcess) o;
    return Objects.equals(this.ID, restProcess.ID) &&
        Objects.equals(this.parentID, restProcess.parentID) &&
        Objects.equals(this.metricsPort, restProcess.metricsPort) &&
        Objects.equals(this.peerId, restProcess.peerId) &&
        Objects.equals(this.peerAddress, restProcess.peerAddress) &&
        Objects.equals(this.startTag, restProcess.startTag) &&
        Objects.equals(this.services, restProcess.services);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, parentID, metricsPort, peerId, peerAddress, startTag, services);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestProcess {\n");
    
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    parentID: ").append(toIndentedString(parentID)).append("\n");
    sb.append("    metricsPort: ").append(toIndentedString(metricsPort)).append("\n");
    sb.append("    peerId: ").append(toIndentedString(peerId)).append("\n");
    sb.append("    peerAddress: ").append(toIndentedString(peerAddress)).append("\n");
    sb.append("    startTag: ").append(toIndentedString(startTag)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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

