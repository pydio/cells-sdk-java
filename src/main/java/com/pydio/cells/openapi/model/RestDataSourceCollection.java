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

import java.util.ArrayList;
import java.util.List;

/**
 * RestDataSourceCollection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestDataSourceCollection {
  @SerializedName("DataSources")
  private List<ObjectDataSource> dataSources = null;

  @SerializedName("Total")
  private Integer total = null;

  public RestDataSourceCollection dataSources(List<ObjectDataSource> dataSources) {
    this.dataSources = dataSources;
    return this;
  }

  public RestDataSourceCollection addDataSourcesItem(ObjectDataSource dataSourcesItem) {
    if (this.dataSources == null) {
      this.dataSources = new ArrayList<ObjectDataSource>();
    }
    this.dataSources.add(dataSourcesItem);
    return this;
  }

   /**
   * Get dataSources
   * @return dataSources
  **/
  @ApiModelProperty(value = "")
  public List<ObjectDataSource> getDataSources() {
    return dataSources;
  }

  public void setDataSources(List<ObjectDataSource> dataSources) {
    this.dataSources = dataSources;
  }

  public RestDataSourceCollection total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestDataSourceCollection restDataSourceCollection = (RestDataSourceCollection) o;
    return Objects.equals(this.dataSources, restDataSourceCollection.dataSources) &&
        Objects.equals(this.total, restDataSourceCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataSources, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDataSourceCollection {\n");
    
    sb.append("    dataSources: ").append(toIndentedString(dataSources)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
