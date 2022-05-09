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
import com.pydio.cells.openapi.model.IdmUserMeta;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestUserMetaCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestUserMetaCollection {
  public static final String SERIALIZED_NAME_METADATAS = "Metadatas";
  @SerializedName(SERIALIZED_NAME_METADATAS)
  private List<IdmUserMeta> metadatas = null;

  public RestUserMetaCollection() { 
  }

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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUserMeta> getMetadatas() {
    return metadatas;
  }


  public void setMetadatas(List<IdmUserMeta> metadatas) {
    this.metadatas = metadatas;
  }


  @Override
  public boolean equals(Object o) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

