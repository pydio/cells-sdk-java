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
import com.pydio.sdk.core.api.cells.model.EncryptionKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * EncryptionAdminImportKeyRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class EncryptionAdminImportKeyRequest {
  @SerializedName("Key")
  private EncryptionKey key = null;

  @SerializedName("StrPassword")
  private String strPassword = null;

  @SerializedName("Override")
  private Boolean override = null;

  public EncryptionAdminImportKeyRequest key(EncryptionKey key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")
  public EncryptionKey getKey() {
    return key;
  }

  public void setKey(EncryptionKey key) {
    this.key = key;
  }

  public EncryptionAdminImportKeyRequest strPassword(String strPassword) {
    this.strPassword = strPassword;
    return this;
  }

   /**
   * Get strPassword
   * @return strPassword
  **/
  @ApiModelProperty(value = "")
  public String getStrPassword() {
    return strPassword;
  }

  public void setStrPassword(String strPassword) {
    this.strPassword = strPassword;
  }

  public EncryptionAdminImportKeyRequest override(Boolean override) {
    this.override = override;
    return this;
  }

   /**
   * Get override
   * @return override
  **/
  @ApiModelProperty(value = "")
  public Boolean isOverride() {
    return override;
  }

  public void setOverride(Boolean override) {
    this.override = override;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionAdminImportKeyRequest encryptionAdminImportKeyRequest = (EncryptionAdminImportKeyRequest) o;
    return Objects.equals(this.key, encryptionAdminImportKeyRequest.key) &&
        Objects.equals(this.strPassword, encryptionAdminImportKeyRequest.strPassword) &&
        Objects.equals(this.override, encryptionAdminImportKeyRequest.override);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, strPassword, override);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionAdminImportKeyRequest {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    strPassword: ").append(toIndentedString(strPassword)).append("\n");
    sb.append("    override: ").append(toIndentedString(override)).append("\n");
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

