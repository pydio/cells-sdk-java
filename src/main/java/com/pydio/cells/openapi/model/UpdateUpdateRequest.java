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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UpdateUpdateRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class UpdateUpdateRequest {
  public static final String SERIALIZED_NAME_CHANNEL = "Channel";
  @SerializedName(SERIALIZED_NAME_CHANNEL)
  private String channel;

  public static final String SERIALIZED_NAME_CURRENT_VERSION = "CurrentVersion";
  @SerializedName(SERIALIZED_NAME_CURRENT_VERSION)
  private String currentVersion;

  public static final String SERIALIZED_NAME_G_O_A_R_C_H = "GOARCH";
  @SerializedName(SERIALIZED_NAME_G_O_A_R_C_H)
  private String GOARCH;

  public static final String SERIALIZED_NAME_G_O_O_S = "GOOS";
  @SerializedName(SERIALIZED_NAME_G_O_O_S)
  private String GOOS;

  public static final String SERIALIZED_NAME_LICENSE_INFO = "LicenseInfo";
  @SerializedName(SERIALIZED_NAME_LICENSE_INFO)
  private Map<String, String> licenseInfo = null;

  public static final String SERIALIZED_NAME_PACKAGE_NAME = "PackageName";
  @SerializedName(SERIALIZED_NAME_PACKAGE_NAME)
  private String packageName;

  public static final String SERIALIZED_NAME_SERVICE_NAME = "ServiceName";
  @SerializedName(SERIALIZED_NAME_SERVICE_NAME)
  private String serviceName;

  public UpdateUpdateRequest() { 
  }

  public UpdateUpdateRequest channel(String channel) {
    
    this.channel = channel;
    return this;
  }

   /**
   * Get channel
   * @return channel
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getChannel() {
    return channel;
  }


  public void setChannel(String channel) {
    this.channel = channel;
  }


  public UpdateUpdateRequest currentVersion(String currentVersion) {
    
    this.currentVersion = currentVersion;
    return this;
  }

   /**
   * Get currentVersion
   * @return currentVersion
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCurrentVersion() {
    return currentVersion;
  }


  public void setCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
  }


  public UpdateUpdateRequest GOARCH(String GOARCH) {
    
    this.GOARCH = GOARCH;
    return this;
  }

   /**
   * Get GOARCH
   * @return GOARCH
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGOARCH() {
    return GOARCH;
  }


  public void setGOARCH(String GOARCH) {
    this.GOARCH = GOARCH;
  }


  public UpdateUpdateRequest GOOS(String GOOS) {
    
    this.GOOS = GOOS;
    return this;
  }

   /**
   * Get GOOS
   * @return GOOS
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGOOS() {
    return GOOS;
  }


  public void setGOOS(String GOOS) {
    this.GOOS = GOOS;
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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, String> getLicenseInfo() {
    return licenseInfo;
  }


  public void setLicenseInfo(Map<String, String> licenseInfo) {
    this.licenseInfo = licenseInfo;
  }


  public UpdateUpdateRequest packageName(String packageName) {
    
    this.packageName = packageName;
    return this;
  }

   /**
   * Get packageName
   * @return packageName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPackageName() {
    return packageName;
  }


  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }


  public UpdateUpdateRequest serviceName(String serviceName) {
    
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
    UpdateUpdateRequest updateUpdateRequest = (UpdateUpdateRequest) o;
    return Objects.equals(this.channel, updateUpdateRequest.channel) &&
        Objects.equals(this.currentVersion, updateUpdateRequest.currentVersion) &&
        Objects.equals(this.GOARCH, updateUpdateRequest.GOARCH) &&
        Objects.equals(this.GOOS, updateUpdateRequest.GOOS) &&
        Objects.equals(this.licenseInfo, updateUpdateRequest.licenseInfo) &&
        Objects.equals(this.packageName, updateUpdateRequest.packageName) &&
        Objects.equals(this.serviceName, updateUpdateRequest.serviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, currentVersion, GOARCH, GOOS, licenseInfo, packageName, serviceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUpdateRequest {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    currentVersion: ").append(toIndentedString(currentVersion)).append("\n");
    sb.append("    GOARCH: ").append(toIndentedString(GOARCH)).append("\n");
    sb.append("    GOOS: ").append(toIndentedString(GOOS)).append("\n");
    sb.append("    licenseInfo: ").append(toIndentedString(licenseInfo)).append("\n");
    sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
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

