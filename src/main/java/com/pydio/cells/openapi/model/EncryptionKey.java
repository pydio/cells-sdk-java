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
import com.pydio.cells.openapi.model.EncryptionKeyInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * EncryptionKey
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class EncryptionKey {
  public static final String SERIALIZED_NAME_OWNER = "Owner";
  @SerializedName(SERIALIZED_NAME_OWNER)
  private String owner;

  public static final String SERIALIZED_NAME_I_D = "ID";
  @SerializedName(SERIALIZED_NAME_I_D)
  private String ID;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_CONTENT = "Content";
  @SerializedName(SERIALIZED_NAME_CONTENT)
  private String content;

  public static final String SERIALIZED_NAME_CREATION_DATE = "CreationDate";
  @SerializedName(SERIALIZED_NAME_CREATION_DATE)
  private Integer creationDate;

  public static final String SERIALIZED_NAME_INFO = "Info";
  @SerializedName(SERIALIZED_NAME_INFO)
  private EncryptionKeyInfo info;

  public EncryptionKey() { 
  }

  public EncryptionKey owner(String owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOwner() {
    return owner;
  }


  public void setOwner(String owner) {
    this.owner = owner;
  }


  public EncryptionKey ID(String ID) {
    
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getID() {
    return ID;
  }


  public void setID(String ID) {
    this.ID = ID;
  }


  public EncryptionKey label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public EncryptionKey content(String content) {
    
    this.content = content;
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getContent() {
    return content;
  }


  public void setContent(String content) {
    this.content = content;
  }


  public EncryptionKey creationDate(Integer creationDate) {
    
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getCreationDate() {
    return creationDate;
  }


  public void setCreationDate(Integer creationDate) {
    this.creationDate = creationDate;
  }


  public EncryptionKey info(EncryptionKeyInfo info) {
    
    this.info = info;
    return this;
  }

   /**
   * Get info
   * @return info
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public EncryptionKeyInfo getInfo() {
    return info;
  }


  public void setInfo(EncryptionKeyInfo info) {
    this.info = info;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionKey encryptionKey = (EncryptionKey) o;
    return Objects.equals(this.owner, encryptionKey.owner) &&
        Objects.equals(this.ID, encryptionKey.ID) &&
        Objects.equals(this.label, encryptionKey.label) &&
        Objects.equals(this.content, encryptionKey.content) &&
        Objects.equals(this.creationDate, encryptionKey.creationDate) &&
        Objects.equals(this.info, encryptionKey.info);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, ID, label, content, creationDate, info);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionKey {\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
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

