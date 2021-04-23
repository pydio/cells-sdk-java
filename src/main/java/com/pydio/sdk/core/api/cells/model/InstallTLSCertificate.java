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
 * InstallTLSCertificate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class InstallTLSCertificate {
  @SerializedName("CertFile")
  private String certFile = null;

  @SerializedName("KeyFile")
  private String keyFile = null;

  @SerializedName("CellsRootCA")
  private String cellsRootCA = null;

  public InstallTLSCertificate certFile(String certFile) {
    this.certFile = certFile;
    return this;
  }

   /**
   * Get certFile
   * @return certFile
  **/
  @ApiModelProperty(value = "")
  public String getCertFile() {
    return certFile;
  }

  public void setCertFile(String certFile) {
    this.certFile = certFile;
  }

  public InstallTLSCertificate keyFile(String keyFile) {
    this.keyFile = keyFile;
    return this;
  }

   /**
   * Get keyFile
   * @return keyFile
  **/
  @ApiModelProperty(value = "")
  public String getKeyFile() {
    return keyFile;
  }

  public void setKeyFile(String keyFile) {
    this.keyFile = keyFile;
  }

  public InstallTLSCertificate cellsRootCA(String cellsRootCA) {
    this.cellsRootCA = cellsRootCA;
    return this;
  }

   /**
   * Get cellsRootCA
   * @return cellsRootCA
  **/
  @ApiModelProperty(value = "")
  public String getCellsRootCA() {
    return cellsRootCA;
  }

  public void setCellsRootCA(String cellsRootCA) {
    this.cellsRootCA = cellsRootCA;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallTLSCertificate installTLSCertificate = (InstallTLSCertificate) o;
    return Objects.equals(this.certFile, installTLSCertificate.certFile) &&
        Objects.equals(this.keyFile, installTLSCertificate.keyFile) &&
        Objects.equals(this.cellsRootCA, installTLSCertificate.cellsRootCA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(certFile, keyFile, cellsRootCA);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallTLSCertificate {\n");
    
    sb.append("    certFile: ").append(toIndentedString(certFile)).append("\n");
    sb.append("    keyFile: ").append(toIndentedString(keyFile)).append("\n");
    sb.append("    cellsRootCA: ").append(toIndentedString(cellsRootCA)).append("\n");
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

