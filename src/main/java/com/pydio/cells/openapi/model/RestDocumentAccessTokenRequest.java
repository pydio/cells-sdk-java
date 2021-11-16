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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestDocumentAccessTokenRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class RestDocumentAccessTokenRequest {
  @SerializedName("Path")
  private String path = null;

  @SerializedName("ClientID")
  private String clientID = null;

  public RestDocumentAccessTokenRequest path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @ApiModelProperty(value = "")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RestDocumentAccessTokenRequest clientID(String clientID) {
    this.clientID = clientID;
    return this;
  }

   /**
   * Get clientID
   * @return clientID
  **/
  @ApiModelProperty(value = "")
  public String getClientID() {
    return clientID;
  }

  public void setClientID(String clientID) {
    this.clientID = clientID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestDocumentAccessTokenRequest restDocumentAccessTokenRequest = (RestDocumentAccessTokenRequest) o;
    return Objects.equals(this.path, restDocumentAccessTokenRequest.path) &&
        Objects.equals(this.clientID, restDocumentAccessTokenRequest.clientID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, clientID);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDocumentAccessTokenRequest {\n");
    
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    clientID: ").append(toIndentedString(clientID)).append("\n");
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

