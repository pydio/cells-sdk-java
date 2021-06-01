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
import com.pydio.cells.openapi.model.ListSharedResourcesResponseSharedResource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestListSharedResourcesResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestListSharedResourcesResponse {
  @SerializedName("Resources")
  private List<ListSharedResourcesResponseSharedResource> resources = null;

  @SerializedName("Offset")
  private Integer offset = null;

  @SerializedName("Limit")
  private Integer limit = null;

  @SerializedName("Total")
  private Integer total = null;

  public RestListSharedResourcesResponse resources(List<ListSharedResourcesResponseSharedResource> resources) {
    this.resources = resources;
    return this;
  }

  public RestListSharedResourcesResponse addResourcesItem(ListSharedResourcesResponseSharedResource resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<ListSharedResourcesResponseSharedResource>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

   /**
   * Get resources
   * @return resources
  **/
  @ApiModelProperty(value = "")
  public List<ListSharedResourcesResponseSharedResource> getResources() {
    return resources;
  }

  public void setResources(List<ListSharedResourcesResponseSharedResource> resources) {
    this.resources = resources;
  }

  public RestListSharedResourcesResponse offset(Integer offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")
  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public RestListSharedResourcesResponse limit(Integer limit) {
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

  public RestListSharedResourcesResponse total(Integer total) {
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
    RestListSharedResourcesResponse restListSharedResourcesResponse = (RestListSharedResourcesResponse) o;
    return Objects.equals(this.resources, restListSharedResourcesResponse.resources) &&
        Objects.equals(this.offset, restListSharedResourcesResponse.offset) &&
        Objects.equals(this.limit, restListSharedResourcesResponse.limit) &&
        Objects.equals(this.total, restListSharedResourcesResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resources, offset, limit, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListSharedResourcesResponse {\n");
    
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
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

