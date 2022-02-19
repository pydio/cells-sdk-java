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
import com.pydio.cells.openapi.model.AuthToken;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestFrontSessionResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestFrontSessionResponse {
  public static final String SERIALIZED_NAME_J_W_T = "JWT";
  @SerializedName(SERIALIZED_NAME_J_W_T)
  private String JWT;

  public static final String SERIALIZED_NAME_EXPIRE_TIME = "ExpireTime";
  @SerializedName(SERIALIZED_NAME_EXPIRE_TIME)
  private Integer expireTime;

  public static final String SERIALIZED_NAME_TRIGGER = "Trigger";
  @SerializedName(SERIALIZED_NAME_TRIGGER)
  private String trigger;

  public static final String SERIALIZED_NAME_TRIGGER_INFO = "TriggerInfo";
  @SerializedName(SERIALIZED_NAME_TRIGGER_INFO)
  private Map<String, String> triggerInfo = null;

  public static final String SERIALIZED_NAME_TOKEN = "Token";
  @SerializedName(SERIALIZED_NAME_TOKEN)
  private AuthToken token;

  public static final String SERIALIZED_NAME_REDIRECT_TO = "RedirectTo";
  @SerializedName(SERIALIZED_NAME_REDIRECT_TO)
  private String redirectTo;

  public static final String SERIALIZED_NAME_ERROR = "Error";
  @SerializedName(SERIALIZED_NAME_ERROR)
  private String error;

  public RestFrontSessionResponse() { 
  }

  public RestFrontSessionResponse JWT(String JWT) {
    
    this.JWT = JWT;
    return this;
  }

   /**
   * Get JWT
   * @return JWT
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getJWT() {
    return JWT;
  }


  public void setJWT(String JWT) {
    this.JWT = JWT;
  }


  public RestFrontSessionResponse expireTime(Integer expireTime) {
    
    this.expireTime = expireTime;
    return this;
  }

   /**
   * Get expireTime
   * @return expireTime
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getExpireTime() {
    return expireTime;
  }


  public void setExpireTime(Integer expireTime) {
    this.expireTime = expireTime;
  }


  public RestFrontSessionResponse trigger(String trigger) {
    
    this.trigger = trigger;
    return this;
  }

   /**
   * Get trigger
   * @return trigger
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getTrigger() {
    return trigger;
  }


  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }


  public RestFrontSessionResponse triggerInfo(Map<String, String> triggerInfo) {
    
    this.triggerInfo = triggerInfo;
    return this;
  }

  public RestFrontSessionResponse putTriggerInfoItem(String key, String triggerInfoItem) {
    if (this.triggerInfo == null) {
      this.triggerInfo = new HashMap<String, String>();
    }
    this.triggerInfo.put(key, triggerInfoItem);
    return this;
  }

   /**
   * Get triggerInfo
   * @return triggerInfo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, String> getTriggerInfo() {
    return triggerInfo;
  }


  public void setTriggerInfo(Map<String, String> triggerInfo) {
    this.triggerInfo = triggerInfo;
  }


  public RestFrontSessionResponse token(AuthToken token) {
    
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public AuthToken getToken() {
    return token;
  }


  public void setToken(AuthToken token) {
    this.token = token;
  }


  public RestFrontSessionResponse redirectTo(String redirectTo) {
    
    this.redirectTo = redirectTo;
    return this;
  }

   /**
   * Get redirectTo
   * @return redirectTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRedirectTo() {
    return redirectTo;
  }


  public void setRedirectTo(String redirectTo) {
    this.redirectTo = redirectTo;
  }


  public RestFrontSessionResponse error(String error) {
    
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getError() {
    return error;
  }


  public void setError(String error) {
    this.error = error;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestFrontSessionResponse restFrontSessionResponse = (RestFrontSessionResponse) o;
    return Objects.equals(this.JWT, restFrontSessionResponse.JWT) &&
        Objects.equals(this.expireTime, restFrontSessionResponse.expireTime) &&
        Objects.equals(this.trigger, restFrontSessionResponse.trigger) &&
        Objects.equals(this.triggerInfo, restFrontSessionResponse.triggerInfo) &&
        Objects.equals(this.token, restFrontSessionResponse.token) &&
        Objects.equals(this.redirectTo, restFrontSessionResponse.redirectTo) &&
        Objects.equals(this.error, restFrontSessionResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(JWT, expireTime, trigger, triggerInfo, token, redirectTo, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestFrontSessionResponse {\n");
    sb.append("    JWT: ").append(toIndentedString(JWT)).append("\n");
    sb.append("    expireTime: ").append(toIndentedString(expireTime)).append("\n");
    sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
    sb.append("    triggerInfo: ").append(toIndentedString(triggerInfo)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    redirectTo: ").append(toIndentedString(redirectTo)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

