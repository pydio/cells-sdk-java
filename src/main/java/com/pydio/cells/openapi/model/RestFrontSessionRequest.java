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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestFrontSessionRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestFrontSessionRequest {
  @SerializedName("ClientTime")
  private Integer clientTime = null;

  @SerializedName("AuthInfo")
  private Map<String, String> authInfo = null;

  @SerializedName("Logout")
  private Boolean logout = null;

  public RestFrontSessionRequest clientTime(Integer clientTime) {
    this.clientTime = clientTime;
    return this;
  }

   /**
   * Get clientTime
   * @return clientTime
  **/
  @ApiModelProperty(value = "")
  public Integer getClientTime() {
    return clientTime;
  }

  public void setClientTime(Integer clientTime) {
    this.clientTime = clientTime;
  }

  public RestFrontSessionRequest authInfo(Map<String, String> authInfo) {
    this.authInfo = authInfo;
    return this;
  }

  public RestFrontSessionRequest putAuthInfoItem(String key, String authInfoItem) {
    if (this.authInfo == null) {
      this.authInfo = new HashMap<String, String>();
    }
    this.authInfo.put(key, authInfoItem);
    return this;
  }

   /**
   * Get authInfo
   * @return authInfo
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getAuthInfo() {
    return authInfo;
  }

  public void setAuthInfo(Map<String, String> authInfo) {
    this.authInfo = authInfo;
  }

  public RestFrontSessionRequest logout(Boolean logout) {
    this.logout = logout;
    return this;
  }

   /**
   * Get logout
   * @return logout
  **/
  @ApiModelProperty(value = "")
  public Boolean isLogout() {
    return logout;
  }

  public void setLogout(Boolean logout) {
    this.logout = logout;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestFrontSessionRequest restFrontSessionRequest = (RestFrontSessionRequest) o;
    return Objects.equals(this.clientTime, restFrontSessionRequest.clientTime) &&
        Objects.equals(this.authInfo, restFrontSessionRequest.authInfo) &&
        Objects.equals(this.logout, restFrontSessionRequest.logout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientTime, authInfo, logout);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestFrontSessionRequest {\n");
    
    sb.append("    clientTime: ").append(toIndentedString(clientTime)).append("\n");
    sb.append("    authInfo: ").append(toIndentedString(authInfo)).append("\n");
    sb.append("    logout: ").append(toIndentedString(logout)).append("\n");
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

