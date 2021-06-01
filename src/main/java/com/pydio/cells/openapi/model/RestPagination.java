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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestPagination
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestPagination {
  @SerializedName("Limit")
  private Integer limit = null;

  @SerializedName("CurrentOffset")
  private Integer currentOffset = null;

  @SerializedName("Total")
  private Integer total = null;

  @SerializedName("CurrentPage")
  private Integer currentPage = null;

  @SerializedName("TotalPages")
  private Integer totalPages = null;

  @SerializedName("NextOffset")
  private Integer nextOffset = null;

  @SerializedName("PrevOffset")
  private Integer prevOffset = null;

  public RestPagination limit(Integer limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")
  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public RestPagination currentOffset(Integer currentOffset) {
    this.currentOffset = currentOffset;
    return this;
  }

   /**
   * Get currentOffset
   * @return currentOffset
  **/
  @ApiModelProperty(value = "")
  public Integer getCurrentOffset() {
    return currentOffset;
  }

  public void setCurrentOffset(Integer currentOffset) {
    this.currentOffset = currentOffset;
  }

  public RestPagination total(Integer total) {
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

  public RestPagination currentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return this;
  }

   /**
   * Get currentPage
   * @return currentPage
  **/
  @ApiModelProperty(value = "")
  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public RestPagination totalPages(Integer totalPages) {
    this.totalPages = totalPages;
    return this;
  }

   /**
   * Get totalPages
   * @return totalPages
  **/
  @ApiModelProperty(value = "")
  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public RestPagination nextOffset(Integer nextOffset) {
    this.nextOffset = nextOffset;
    return this;
  }

   /**
   * Get nextOffset
   * @return nextOffset
  **/
  @ApiModelProperty(value = "")
  public Integer getNextOffset() {
    return nextOffset;
  }

  public void setNextOffset(Integer nextOffset) {
    this.nextOffset = nextOffset;
  }

  public RestPagination prevOffset(Integer prevOffset) {
    this.prevOffset = prevOffset;
    return this;
  }

   /**
   * Get prevOffset
   * @return prevOffset
  **/
  @ApiModelProperty(value = "")
  public Integer getPrevOffset() {
    return prevOffset;
  }

  public void setPrevOffset(Integer prevOffset) {
    this.prevOffset = prevOffset;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestPagination restPagination = (RestPagination) o;
    return Objects.equals(this.limit, restPagination.limit) &&
        Objects.equals(this.currentOffset, restPagination.currentOffset) &&
        Objects.equals(this.total, restPagination.total) &&
        Objects.equals(this.currentPage, restPagination.currentPage) &&
        Objects.equals(this.totalPages, restPagination.totalPages) &&
        Objects.equals(this.nextOffset, restPagination.nextOffset) &&
        Objects.equals(this.prevOffset, restPagination.prevOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, currentOffset, total, currentPage, totalPages, nextOffset, prevOffset);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPagination {\n");
    
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    currentOffset: ").append(toIndentedString(currentOffset)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    currentPage: ").append(toIndentedString(currentPage)).append("\n");
    sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
    sb.append("    nextOffset: ").append(toIndentedString(nextOffset)).append("\n");
    sb.append("    prevOffset: ").append(toIndentedString(prevOffset)).append("\n");
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

