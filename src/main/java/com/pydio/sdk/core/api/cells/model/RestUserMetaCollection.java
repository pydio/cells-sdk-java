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
import com.pydio.sdk.core.api.cells.model.IdmUserMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestUserMetaCollection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestUserMetaCollection {
  @SerializedName("Metadatas")
  private List<IdmUserMeta> metadatas = null;

  public RestUserMetaCollection metadatas(List<IdmUserMeta> metadatas) {
    this.metadatas = metadatas;
    return this;
  }

  public RestUserMetaCollection addMetadatasItem(IdmUserMeta metadatasItem) {
    if (this.metadatas == null) {
      this.metadatas = new ArrayList<IdmUserMeta>();
    }
    this.metadatas.add(metadatasItem);
    return this;
  }

   /**
   * Get metadatas
   * @return metadatas
  **/
  @ApiModelProperty(value = "")
  public List<IdmUserMeta> getMetadatas() {
    return metadatas;
  }

  public void setMetadatas(List<IdmUserMeta> metadatas) {
    this.metadatas = metadatas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestUserMetaCollection restUserMetaCollection = (RestUserMetaCollection) o;
    return Objects.equals(this.metadatas, restUserMetaCollection.metadatas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadatas);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUserMetaCollection {\n");
    
    sb.append("    metadatas: ").append(toIndentedString(metadatas)).append("\n");
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

