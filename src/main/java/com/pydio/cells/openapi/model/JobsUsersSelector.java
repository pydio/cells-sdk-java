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
import com.pydio.cells.openapi.model.IdmUser;
import com.pydio.cells.openapi.model.ServiceQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobsUsersSelector
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class JobsUsersSelector {
  public static final String SERIALIZED_NAME_ALL = "All";
  @SerializedName(SERIALIZED_NAME_ALL)
  private Boolean all;

  public static final String SERIALIZED_NAME_USERS = "Users";
  @SerializedName(SERIALIZED_NAME_USERS)
  private List<IdmUser> users = null;

  public static final String SERIALIZED_NAME_QUERY = "Query";
  @SerializedName(SERIALIZED_NAME_QUERY)
  private ServiceQuery query;

  public static final String SERIALIZED_NAME_COLLECT = "Collect";
  @SerializedName(SERIALIZED_NAME_COLLECT)
  private Boolean collect;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public JobsUsersSelector() { 
  }

  public JobsUsersSelector all(Boolean all) {
    
    this.all = all;
    return this;
  }

   /**
   * Get all
   * @return all
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAll() {
    return all;
  }


  public void setAll(Boolean all) {
    this.all = all;
  }


  public JobsUsersSelector users(List<IdmUser> users) {
    
    this.users = users;
    return this;
  }

  public JobsUsersSelector addUsersItem(IdmUser usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<IdmUser>();
    }
    this.users.add(usersItem);
    return this;
  }

   /**
   * Get users
   * @return users
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUser> getUsers() {
    return users;
  }


  public void setUsers(List<IdmUser> users) {
    this.users = users;
  }


  public JobsUsersSelector query(ServiceQuery query) {
    
    this.query = query;
    return this;
  }

   /**
   * Get query
   * @return query
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ServiceQuery getQuery() {
    return query;
  }


  public void setQuery(ServiceQuery query) {
    this.query = query;
  }


  public JobsUsersSelector collect(Boolean collect) {
    
    this.collect = collect;
    return this;
  }

   /**
   * Get collect
   * @return collect
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getCollect() {
    return collect;
  }


  public void setCollect(Boolean collect) {
    this.collect = collect;
  }


  public JobsUsersSelector label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public JobsUsersSelector description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsUsersSelector jobsUsersSelector = (JobsUsersSelector) o;
    return Objects.equals(this.all, jobsUsersSelector.all) &&
        Objects.equals(this.users, jobsUsersSelector.users) &&
        Objects.equals(this.query, jobsUsersSelector.query) &&
        Objects.equals(this.collect, jobsUsersSelector.collect) &&
        Objects.equals(this.label, jobsUsersSelector.label) &&
        Objects.equals(this.description, jobsUsersSelector.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(all, users, query, collect, label, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsUsersSelector {\n");
    sb.append("    all: ").append(toIndentedString(all)).append("\n");
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    collect: ").append(toIndentedString(collect)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

