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

/**
 * RestShareLinkTargetUser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestShareLinkTargetUser {
  @SerializedName("Display")
  private String display = null;

  @SerializedName("DownloadCount")
  private Integer downloadCount = null;

  public RestShareLinkTargetUser display(String display) {
    this.display = display;
    return this;
  }

   /**
   * Get display
   * @return display
  **/
  @ApiModelProperty(value = "")
  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public RestShareLinkTargetUser downloadCount(Integer downloadCount) {
    this.downloadCount = downloadCount;
    return this;
  }

   /**
   * Get downloadCount
   * @return downloadCount
  **/
  @ApiModelProperty(value = "")
  public Integer getDownloadCount() {
    return downloadCount;
  }

  public void setDownloadCount(Integer downloadCount) {
    this.downloadCount = downloadCount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestShareLinkTargetUser restShareLinkTargetUser = (RestShareLinkTargetUser) o;
    return Objects.equals(this.display, restShareLinkTargetUser.display) &&
        Objects.equals(this.downloadCount, restShareLinkTargetUser.downloadCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(display, downloadCount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestShareLinkTargetUser {\n");
    
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    downloadCount: ").append(toIndentedString(downloadCount)).append("\n");
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

