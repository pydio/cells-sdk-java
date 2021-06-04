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
 * UpdateApplyUpdateRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class UpdateApplyUpdateRequest {
  @SerializedName("TargetVersion")
  private String targetVersion = null;

  @SerializedName("PackageName")
  private String packageName = null;

  public UpdateApplyUpdateRequest targetVersion(String targetVersion) {
    this.targetVersion = targetVersion;
    return this;
  }

   /**
   * Get targetVersion
   * @return targetVersion
  **/
  @ApiModelProperty(value = "")
  public String getTargetVersion() {
    return targetVersion;
  }

  public void setTargetVersion(String targetVersion) {
    this.targetVersion = targetVersion;
  }

  public UpdateApplyUpdateRequest packageName(String packageName) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateApplyUpdateRequest updateApplyUpdateRequest = (UpdateApplyUpdateRequest) o;
    return Objects.equals(this.targetVersion, updateApplyUpdateRequest.targetVersion) &&
        Objects.equals(this.packageName, updateApplyUpdateRequest.packageName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetVersion, packageName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateApplyUpdateRequest {\n");
    
    sb.append("    targetVersion: ").append(toIndentedString(targetVersion)).append("\n");
    sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
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
