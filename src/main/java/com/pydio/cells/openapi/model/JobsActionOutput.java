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
 * JobsActionOutput
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class JobsActionOutput {
  @SerializedName("Success")
  private Boolean success = null;

  @SerializedName("RawBody")
  private byte[] rawBody = null;

  @SerializedName("StringBody")
  private String stringBody = null;

  @SerializedName("JsonBody")
  private byte[] jsonBody = null;

  @SerializedName("ErrorString")
  private String errorString = null;

  @SerializedName("Ignored")
  private Boolean ignored = null;

  @SerializedName("Time")
  private Integer time = null;

  public JobsActionOutput success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Get success
   * @return success
  **/
  @ApiModelProperty(value = "")
  public Boolean isSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public JobsActionOutput rawBody(byte[] rawBody) {
    this.rawBody = rawBody;
    return this;
  }

   /**
   * Get rawBody
   * @return rawBody
  **/
  @ApiModelProperty(value = "")
  public byte[] getRawBody() {
    return rawBody;
  }

  public void setRawBody(byte[] rawBody) {
    this.rawBody = rawBody;
  }

  public JobsActionOutput stringBody(String stringBody) {
    this.stringBody = stringBody;
    return this;
  }

   /**
   * Get stringBody
   * @return stringBody
  **/
  @ApiModelProperty(value = "")
  public String getStringBody() {
    return stringBody;
  }

  public void setStringBody(String stringBody) {
    this.stringBody = stringBody;
  }

  public JobsActionOutput jsonBody(byte[] jsonBody) {
    this.jsonBody = jsonBody;
    return this;
  }

   /**
   * Get jsonBody
   * @return jsonBody
  **/
  @ApiModelProperty(value = "")
  public byte[] getJsonBody() {
    return jsonBody;
  }

  public void setJsonBody(byte[] jsonBody) {
    this.jsonBody = jsonBody;
  }

  public JobsActionOutput errorString(String errorString) {
    this.errorString = errorString;
    return this;
  }

   /**
   * Get errorString
   * @return errorString
  **/
  @ApiModelProperty(value = "")
  public String getErrorString() {
    return errorString;
  }

  public void setErrorString(String errorString) {
    this.errorString = errorString;
  }

  public JobsActionOutput ignored(Boolean ignored) {
    this.ignored = ignored;
    return this;
  }

   /**
   * Get ignored
   * @return ignored
  **/
  @ApiModelProperty(value = "")
  public Boolean isIgnored() {
    return ignored;
  }

  public void setIgnored(Boolean ignored) {
    this.ignored = ignored;
  }

  public JobsActionOutput time(Integer time) {
    this.time = time;
    return this;
  }

   /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsActionOutput jobsActionOutput = (JobsActionOutput) o;
    return Objects.equals(this.success, jobsActionOutput.success) &&
        Arrays.equals(this.rawBody, jobsActionOutput.rawBody) &&
        Objects.equals(this.stringBody, jobsActionOutput.stringBody) &&
        Arrays.equals(this.jsonBody, jobsActionOutput.jsonBody) &&
        Objects.equals(this.errorString, jobsActionOutput.errorString) &&
        Objects.equals(this.ignored, jobsActionOutput.ignored) &&
        Objects.equals(this.time, jobsActionOutput.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, Arrays.hashCode(rawBody), stringBody, Arrays.hashCode(jsonBody), errorString, ignored, time);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsActionOutput {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    rawBody: ").append(toIndentedString(rawBody)).append("\n");
    sb.append("    stringBody: ").append(toIndentedString(stringBody)).append("\n");
    sb.append("    jsonBody: ").append(toIndentedString(jsonBody)).append("\n");
    sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
    sb.append("    ignored: ").append(toIndentedString(ignored)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

