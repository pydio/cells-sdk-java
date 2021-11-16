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
import com.pydio.cells.openapi.model.RestTemplateNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestTemplateNode
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-11-16T07:08:43.163+01:00")
public class RestTemplateNode {
  @SerializedName("IsFile")
  private Boolean isFile = null;

  @SerializedName("BinaryUUUID")
  private String binaryUUUID = null;

  @SerializedName("EmbedPath")
  private String embedPath = null;

  @SerializedName("Children")
  private List<RestTemplateNode> children = null;

  public RestTemplateNode isFile(Boolean isFile) {
    this.isFile = isFile;
    return this;
  }

   /**
   * Get isFile
   * @return isFile
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsFile() {
    return isFile;
  }

  public void setIsFile(Boolean isFile) {
    this.isFile = isFile;
  }

  public RestTemplateNode binaryUUUID(String binaryUUUID) {
    this.binaryUUUID = binaryUUUID;
    return this;
  }

   /**
   * Get binaryUUUID
   * @return binaryUUUID
  **/
  @ApiModelProperty(value = "")
  public String getBinaryUUUID() {
    return binaryUUUID;
  }

  public void setBinaryUUUID(String binaryUUUID) {
    this.binaryUUUID = binaryUUUID;
  }

  public RestTemplateNode embedPath(String embedPath) {
    this.embedPath = embedPath;
    return this;
  }

   /**
   * Get embedPath
   * @return embedPath
  **/
  @ApiModelProperty(value = "")
  public String getEmbedPath() {
    return embedPath;
  }

  public void setEmbedPath(String embedPath) {
    this.embedPath = embedPath;
  }

  public RestTemplateNode children(List<RestTemplateNode> children) {
    this.children = children;
    return this;
  }

  public RestTemplateNode addChildrenItem(RestTemplateNode childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<RestTemplateNode>();
    }
    this.children.add(childrenItem);
    return this;
  }

   /**
   * Get children
   * @return children
  **/
  @ApiModelProperty(value = "")
  public List<RestTemplateNode> getChildren() {
    return children;
  }

  public void setChildren(List<RestTemplateNode> children) {
    this.children = children;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestTemplateNode restTemplateNode = (RestTemplateNode) o;
    return Objects.equals(this.isFile, restTemplateNode.isFile) &&
        Objects.equals(this.binaryUUUID, restTemplateNode.binaryUUUID) &&
        Objects.equals(this.embedPath, restTemplateNode.embedPath) &&
        Objects.equals(this.children, restTemplateNode.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFile, binaryUUUID, embedPath, children);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestTemplateNode {\n");
    
    sb.append("    isFile: ").append(toIndentedString(isFile)).append("\n");
    sb.append("    binaryUUUID: ").append(toIndentedString(binaryUUUID)).append("\n");
    sb.append("    embedPath: ").append(toIndentedString(embedPath)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

