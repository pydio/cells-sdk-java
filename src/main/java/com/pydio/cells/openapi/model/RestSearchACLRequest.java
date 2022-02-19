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
import com.pydio.cells.openapi.model.IdmACLSingleQuery;
import com.pydio.cells.openapi.model.ServiceOperationType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestSearchACLRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestSearchACLRequest {
  public static final String SERIALIZED_NAME_QUERIES = "Queries";
  @SerializedName(SERIALIZED_NAME_QUERIES)
  private List<IdmACLSingleQuery> queries = null;

  public static final String SERIALIZED_NAME_OFFSET = "Offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private String offset;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private String limit;

  public static final String SERIALIZED_NAME_GROUP_BY = "GroupBy";
  @SerializedName(SERIALIZED_NAME_GROUP_BY)
  private Integer groupBy;

  public static final String SERIALIZED_NAME_COUNT_ONLY = "CountOnly";
  @SerializedName(SERIALIZED_NAME_COUNT_ONLY)
  private Boolean countOnly;

  public static final String SERIALIZED_NAME_OPERATION = "Operation";
  @SerializedName(SERIALIZED_NAME_OPERATION)
  private ServiceOperationType operation = ServiceOperationType.OR;

  public RestSearchACLRequest() { 
  }

  public RestSearchACLRequest queries(List<IdmACLSingleQuery> queries) {
    
    this.queries = queries;
    return this;
  }

  public RestSearchACLRequest addQueriesItem(IdmACLSingleQuery queriesItem) {
    if (this.queries == null) {
      this.queries = new ArrayList<IdmACLSingleQuery>();
    }
    this.queries.add(queriesItem);
    return this;
  }

   /**
   * Get queries
   * @return queries
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmACLSingleQuery> getQueries() {
    return queries;
  }


  public void setQueries(List<IdmACLSingleQuery> queries) {
    this.queries = queries;
  }


  public RestSearchACLRequest offset(String offset) {
    
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getOffset() {
    return offset;
  }


  public void setOffset(String offset) {
    this.offset = offset;
  }


  public RestSearchACLRequest limit(String limit) {
    
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLimit() {
    return limit;
  }


  public void setLimit(String limit) {
    this.limit = limit;
  }


  public RestSearchACLRequest groupBy(Integer groupBy) {
    
    this.groupBy = groupBy;
    return this;
  }

   /**
   * Get groupBy
   * @return groupBy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getGroupBy() {
    return groupBy;
  }


  public void setGroupBy(Integer groupBy) {
    this.groupBy = groupBy;
  }


  public RestSearchACLRequest countOnly(Boolean countOnly) {
    
    this.countOnly = countOnly;
    return this;
  }

   /**
   * Get countOnly
   * @return countOnly
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getCountOnly() {
    return countOnly;
  }


  public void setCountOnly(Boolean countOnly) {
    this.countOnly = countOnly;
  }


  public RestSearchACLRequest operation(ServiceOperationType operation) {
    
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ServiceOperationType getOperation() {
    return operation;
  }


  public void setOperation(ServiceOperationType operation) {
    this.operation = operation;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSearchACLRequest restSearchACLRequest = (RestSearchACLRequest) o;
    return Objects.equals(this.queries, restSearchACLRequest.queries) &&
        Objects.equals(this.offset, restSearchACLRequest.offset) &&
        Objects.equals(this.limit, restSearchACLRequest.limit) &&
        Objects.equals(this.groupBy, restSearchACLRequest.groupBy) &&
        Objects.equals(this.countOnly, restSearchACLRequest.countOnly) &&
        Objects.equals(this.operation, restSearchACLRequest.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queries, offset, limit, groupBy, countOnly, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSearchACLRequest {\n");
    sb.append("    queries: ").append(toIndentedString(queries)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

