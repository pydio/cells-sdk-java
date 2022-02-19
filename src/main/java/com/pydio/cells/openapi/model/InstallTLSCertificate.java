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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * InstallTLSCertificate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class InstallTLSCertificate {
  public static final String SERIALIZED_NAME_CERT_FILE = "CertFile";
  @SerializedName(SERIALIZED_NAME_CERT_FILE)
  private String certFile;

  public static final String SERIALIZED_NAME_KEY_FILE = "KeyFile";
  @SerializedName(SERIALIZED_NAME_KEY_FILE)
  private String keyFile;

  public static final String SERIALIZED_NAME_CELLS_ROOT_C_A = "CellsRootCA";
  @SerializedName(SERIALIZED_NAME_CELLS_ROOT_C_A)
  private String cellsRootCA;

  public InstallTLSCertificate() { 
  }

  public InstallTLSCertificate certFile(String certFile) {
    
    this.certFile = certFile;
    return this;
  }

   /**
   * Get certFile
   * @return certFile
  **/
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCellsRootCA() {
    return cellsRootCA;
  }


  public void setCellsRootCA(String cellsRootCA) {
    this.cellsRootCA = cellsRootCA;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

