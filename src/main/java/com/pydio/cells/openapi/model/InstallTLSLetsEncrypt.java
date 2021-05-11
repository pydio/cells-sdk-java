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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * InstallTLSLetsEncrypt
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class InstallTLSLetsEncrypt {
  @SerializedName("Email")
  private String email = null;

  @SerializedName("AcceptEULA")
  private Boolean acceptEULA = null;

  @SerializedName("StagingCA")
  private Boolean stagingCA = null;

  public InstallTLSLetsEncrypt email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InstallTLSLetsEncrypt acceptEULA(Boolean acceptEULA) {
    this.acceptEULA = acceptEULA;
    return this;
  }

   /**
   * Get acceptEULA
   * @return acceptEULA
  **/
  @ApiModelProperty(value = "")
  public Boolean isAcceptEULA() {
    return acceptEULA;
  }

  public void setAcceptEULA(Boolean acceptEULA) {
    this.acceptEULA = acceptEULA;
  }

  public InstallTLSLetsEncrypt stagingCA(Boolean stagingCA) {
    this.stagingCA = stagingCA;
    return this;
  }

   /**
   * Get stagingCA
   * @return stagingCA
  **/
  @ApiModelProperty(value = "")
  public Boolean isStagingCA() {
    return stagingCA;
  }

  public void setStagingCA(Boolean stagingCA) {
    this.stagingCA = stagingCA;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallTLSLetsEncrypt installTLSLetsEncrypt = (InstallTLSLetsEncrypt) o;
    return Objects.equals(this.email, installTLSLetsEncrypt.email) &&
        Objects.equals(this.acceptEULA, installTLSLetsEncrypt.acceptEULA) &&
        Objects.equals(this.stagingCA, installTLSLetsEncrypt.stagingCA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, acceptEULA, stagingCA);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallTLSLetsEncrypt {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    acceptEULA: ").append(toIndentedString(acceptEULA)).append("\n");
    sb.append("    stagingCA: ").append(toIndentedString(stagingCA)).append("\n");
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
