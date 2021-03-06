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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UpdateUpdateRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class UpdateUpdateRequest {
  @SerializedName("Channel")
  private String channel = null;

  @SerializedName("PackageName")
  private String packageName = null;

  @SerializedName("CurrentVersion")
  private String currentVersion = null;

  @SerializedName("GOOS")
  private String GOOS = null;

  @SerializedName("GOARCH")
  private String GOARCH = null;

  @SerializedName("ServiceName")
  private String serviceName = null;

  @SerializedName("LicenseInfo")
  private Map<String, String> licenseInfo = null;

  public UpdateUpdateRequest channel(String channel) {
    this.channel = channel;
    return this;
  }

   /**
   * Get channel
   * @return channel
  **/
  @ApiModelProperty(value = "")
  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }

  public UpdateUpdateRequest packageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

   /**
   * Get packageName
   * @return packageName
  **/
  @ApiModelProperty(value = "")
  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public UpdateUpdateRequest currentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return this;
  }

   /**
   * Get currentVersion
   * @return currentVersion
  **/
  @ApiModelProperty(value = "")
  public String getCurrentVersion() {
    return currentVersion;
  }

  public void setCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
  }

  public UpdateUpdateRequest GOOS(String GOOS) {
    this.GOOS = GOOS;
    return this;
  }

   /**
   * Get GOOS
   * @return GOOS
  **/
  @ApiModelProperty(value = "")
  public String getGOOS() {
    return GOOS;
  }

  public void setGOOS(String GOOS) {
    this.GOOS = GOOS;
  }

  public UpdateUpdateRequest GOARCH(String GOARCH) {
    this.GOARCH = GOARCH;
    return this;
  }

   /**
   * Get GOARCH
   * @return GOARCH
  **/
  @ApiModelProperty(value = "")
  public String getGOARCH() {
    return GOARCH;
  }

  public void setGOARCH(String GOARCH) {
    this.GOARCH = GOARCH;
  }

  public UpdateUpdateRequest serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Get serviceName
   * @return serviceName
  **/
  @ApiModelProperty(value = "")
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public UpdateUpdateRequest licenseInfo(Map<String, String> licenseInfo) {
    this.licenseInfo = licenseInfo;
    return this;
  }

  public UpdateUpdateRequest putLicenseInfoItem(String key, String licenseInfoItem) {
    if (this.licenseInfo == null) {
      this.licenseInfo = new HashMap<String, String>();
    }
    this.licenseInfo.put(key, licenseInfoItem);
    return this;
  }

   /**
   * Get licenseInfo
   * @return licenseInfo
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getLicenseInfo() {
    return licenseInfo;
  }

  public void setLicenseInfo(Map<String, String> licenseInfo) {
    this.licenseInfo = licenseInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUpdateRequest updateUpdateRequest = (UpdateUpdateRequest) o;
    return Objects.equals(this.channel, updateUpdateRequest.channel) &&
        Objects.equals(this.packageName, updateUpdateRequest.packageName) &&
        Objects.equals(this.currentVersion, updateUpdateRequest.currentVersion) &&
        Objects.equals(this.GOOS, updateUpdateRequest.GOOS) &&
        Objects.equals(this.GOARCH, updateUpdateRequest.GOARCH) &&
        Objects.equals(this.serviceName, updateUpdateRequest.serviceName) &&
        Objects.equals(this.licenseInfo, updateUpdateRequest.licenseInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, packageName, currentVersion, GOOS, GOARCH, serviceName, licenseInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUpdateRequest {\n");
    
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
    sb.append("    currentVersion: ").append(toIndentedString(currentVersion)).append("\n");
    sb.append("    GOOS: ").append(toIndentedString(GOOS)).append("\n");
    sb.append("    GOARCH: ").append(toIndentedString(GOARCH)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    licenseInfo: ").append(toIndentedString(licenseInfo)).append("\n");
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

