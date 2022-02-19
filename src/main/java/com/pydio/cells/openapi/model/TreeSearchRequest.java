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
import com.pydio.cells.openapi.model.TreeQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TreeSearchRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class TreeSearchRequest {
  public static final String SERIALIZED_NAME_QUERY = "Query";
  @SerializedName(SERIALIZED_NAME_QUERY)
  private TreeQuery query;

  public static final String SERIALIZED_NAME_SIZE = "Size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private Integer size;

  public static final String SERIALIZED_NAME_FROM = "From";
  @SerializedName(SERIALIZED_NAME_FROM)
  private Integer from;

  public static final String SERIALIZED_NAME_DETAILS = "Details";
  @SerializedName(SERIALIZED_NAME_DETAILS)
  private Boolean details;

  public TreeSearchRequest() { 
  }

  public TreeSearchRequest query(TreeQuery query) {
    
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public TreeQuery getQuery() {
    return query;
  }


  public void setQuery(TreeQuery query) {
    this.query = query;
  }


  public TreeSearchRequest size(Integer size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getSize() {
    return size;
  }


  public void setSize(Integer size) {
    this.size = size;
  }


  public TreeSearchRequest from(Integer from) {
    
    this.from = from;
    return this;
  }

   /**
   * Get from
   * @return from
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getFrom() {
    return from;
  }


  public void setFrom(Integer from) {
    this.from = from;
  }


  public TreeSearchRequest details(Boolean details) {
    
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getDetails() {
    return details;
  }


  public void setDetails(Boolean details) {
    this.details = details;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeSearchRequest treeSearchRequest = (TreeSearchRequest) o;
    return Objects.equals(this.query, treeSearchRequest.query) &&
        Objects.equals(this.size, treeSearchRequest.size) &&
        Objects.equals(this.from, treeSearchRequest.from) &&
        Objects.equals(this.details, treeSearchRequest.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(query, size, from, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeSearchRequest {\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

