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
 * IdmUpdateUserMetaResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class IdmUpdateUserMetaResponse {
  public static final String SERIALIZED_NAME_META_DATAS = "MetaDatas";
  @SerializedName(SERIALIZED_NAME_META_DATAS)
  private List<IdmUserMeta> metaDatas = null;

  public IdmUpdateUserMetaResponse() { 
  }

  public IdmUpdateUserMetaResponse metaDatas(List<IdmUserMeta> metaDatas) {
    
    this.metaDatas = metaDatas;
    return this;
  }

  public IdmUpdateUserMetaResponse addMetaDatasItem(IdmUserMeta metaDatasItem) {
    if (this.metaDatas == null) {
      this.metaDatas = new ArrayList<IdmUserMeta>();
    }
    this.metaDatas.add(metaDatasItem);
    return this;
  }

   /**
   * Get metaDatas
   * @return metaDatas
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUserMeta> getMetaDatas() {
    return metaDatas;
  }


  public void setMetaDatas(List<IdmUserMeta> metaDatas) {
    this.metaDatas = metaDatas;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmUpdateUserMetaResponse idmUpdateUserMetaResponse = (IdmUpdateUserMetaResponse) o;
    return Objects.equals(this.metaDatas, idmUpdateUserMetaResponse.metaDatas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metaDatas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmUpdateUserMetaResponse {\n");
    sb.append("    metaDatas: ").append(toIndentedString(metaDatas)).append("\n");
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

