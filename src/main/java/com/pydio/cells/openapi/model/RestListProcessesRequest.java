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

/**
 * RestListProcessesRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class RestListProcessesRequest {
  public static final String SERIALIZED_NAME_PEER_ID = "PeerId";
  @SerializedName(SERIALIZED_NAME_PEER_ID)
  private String peerId;

  public static final String SERIALIZED_NAME_SERVICE_NAME = "ServiceName";
  @SerializedName(SERIALIZED_NAME_SERVICE_NAME)
  private String serviceName;

  public RestListProcessesRequest() { 
  }

  public RestListProcessesRequest peerId(String peerId) {
    
    this.peerId = peerId;
    return this;
  }

   /**
   * Get peerId
   * @return peerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPeerId() {
    return peerId;
  }


  public void setPeerId(String peerId) {
    this.peerId = peerId;
  }


  public RestListProcessesRequest serviceName(String serviceName) {
    
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Get serviceName
   * @return serviceName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getServiceName() {
    return serviceName;
  }


  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestListProcessesRequest restListProcessesRequest = (RestListProcessesRequest) o;
    return Objects.equals(this.peerId, restListProcessesRequest.peerId) &&
        Objects.equals(this.serviceName, restListProcessesRequest.serviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(peerId, serviceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListProcessesRequest {\n");
    sb.append("    peerId: ").append(toIndentedString(peerId)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
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

