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
import com.pydio.sdk.core.api.cells.model.IdmWorkspaceSingleQuery;
import com.pydio.sdk.core.api.cells.model.RestResourcePolicyQuery;
import com.pydio.sdk.core.api.cells.model.ServiceOperationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestSearchWorkspaceRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestSearchWorkspaceRequest {
  @SerializedName("Queries")
  private List<IdmWorkspaceSingleQuery> queries = null;

  @SerializedName("ResourcePolicyQuery")
  private RestResourcePolicyQuery resourcePolicyQuery = null;

  @SerializedName("Offset")
  private String offset = null;

  @SerializedName("Limit")
  private String limit = null;

  @SerializedName("GroupBy")
  private Integer groupBy = null;

  @SerializedName("CountOnly")
  private Boolean countOnly = null;

  @SerializedName("Operation")
  private ServiceOperationType operation = null;

  public RestSearchWorkspaceRequest queries(List<IdmWorkspaceSingleQuery> queries) {
    this.queries = queries;
    return this;
  }

  public RestSearchWorkspaceRequest addQueriesItem(IdmWorkspaceSingleQuery queriesItem) {
    if (this.queries == null) {
      this.queries = new ArrayList<IdmWorkspaceSingleQuery>();
    }
    this.queries.add(queriesItem);
    return this;
  }

   /**
   * Get queries
   * @return queries
  **/
  @ApiModelProperty(value = "")
  public List<IdmWorkspaceSingleQuery> getQueries() {
    return queries;
  }

  public void setQueries(List<IdmWorkspaceSingleQuery> queries) {
    this.queries = queries;
  }

  public RestSearchWorkspaceRequest resourcePolicyQuery(RestResourcePolicyQuery resourcePolicyQuery) {
    this.resourcePolicyQuery = resourcePolicyQuery;
    return this;
  }

   /**
   * Get resourcePolicyQuery
   * @return resourcePolicyQuery
  **/
  @ApiModelProperty(value = "")
  public RestResourcePolicyQuery getResourcePolicyQuery() {
    return resourcePolicyQuery;
  }

  public void setResourcePolicyQuery(RestResourcePolicyQuery resourcePolicyQuery) {
    this.resourcePolicyQuery = resourcePolicyQuery;
  }

  public RestSearchWorkspaceRequest offset(String offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @ApiModelProperty(value = "")
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public RestSearchWorkspaceRequest limit(String limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @ApiModelProperty(value = "")
  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public RestSearchWorkspaceRequest groupBy(Integer groupBy) {
    this.groupBy = groupBy;
    return this;
  }

   /**
   * Get groupBy
   * @return groupBy
  **/
  @ApiModelProperty(value = "")
  public Integer getGroupBy() {
    return groupBy;
  }

  public void setGroupBy(Integer groupBy) {
    this.groupBy = groupBy;
  }

  public RestSearchWorkspaceRequest countOnly(Boolean countOnly) {
    this.countOnly = countOnly;
    return this;
  }

   /**
   * Get countOnly
   * @return countOnly
  **/
  @ApiModelProperty(value = "")
  public Boolean isCountOnly() {
    return countOnly;
  }

  public void setCountOnly(Boolean countOnly) {
    this.countOnly = countOnly;
  }

  public RestSearchWorkspaceRequest operation(ServiceOperationType operation) {
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @ApiModelProperty(value = "")
  public ServiceOperationType getOperation() {
    return operation;
  }

  public void setOperation(ServiceOperationType operation) {
    this.operation = operation;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSearchWorkspaceRequest restSearchWorkspaceRequest = (RestSearchWorkspaceRequest) o;
    return Objects.equals(this.queries, restSearchWorkspaceRequest.queries) &&
        Objects.equals(this.resourcePolicyQuery, restSearchWorkspaceRequest.resourcePolicyQuery) &&
        Objects.equals(this.offset, restSearchWorkspaceRequest.offset) &&
        Objects.equals(this.limit, restSearchWorkspaceRequest.limit) &&
        Objects.equals(this.groupBy, restSearchWorkspaceRequest.groupBy) &&
        Objects.equals(this.countOnly, restSearchWorkspaceRequest.countOnly) &&
        Objects.equals(this.operation, restSearchWorkspaceRequest.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queries, resourcePolicyQuery, offset, limit, groupBy, countOnly, operation);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSearchWorkspaceRequest {\n");
    
    sb.append("    queries: ").append(toIndentedString(queries)).append("\n");
    sb.append("    resourcePolicyQuery: ").append(toIndentedString(resourcePolicyQuery)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    groupBy: ").append(toIndentedString(groupBy)).append("\n");
    sb.append("    countOnly: ").append(toIndentedString(countOnly)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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

