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
import com.pydio.cells.openapi.model.IdmPolicyGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IdmListPolicyGroupsResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class IdmListPolicyGroupsResponse {
  public static final String SERIALIZED_NAME_POLICY_GROUPS = "PolicyGroups";
  @SerializedName(SERIALIZED_NAME_POLICY_GROUPS)
  private List<IdmPolicyGroup> policyGroups = null;

  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public IdmListPolicyGroupsResponse() { 
  }

  public IdmListPolicyGroupsResponse policyGroups(List<IdmPolicyGroup> policyGroups) {
    
    this.policyGroups = policyGroups;
    return this;
  }

  public IdmListPolicyGroupsResponse addPolicyGroupsItem(IdmPolicyGroup policyGroupsItem) {
    if (this.policyGroups == null) {
      this.policyGroups = new ArrayList<IdmPolicyGroup>();
    }
    this.policyGroups.add(policyGroupsItem);
    return this;
  }

   /**
   * Get policyGroups
   * @return policyGroups
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmPolicyGroup> getPolicyGroups() {
    return policyGroups;
  }


  public void setPolicyGroups(List<IdmPolicyGroup> policyGroups) {
    this.policyGroups = policyGroups;
  }


  public IdmListPolicyGroupsResponse total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmListPolicyGroupsResponse idmListPolicyGroupsResponse = (IdmListPolicyGroupsResponse) o;
    return Objects.equals(this.policyGroups, idmListPolicyGroupsResponse.policyGroups) &&
        Objects.equals(this.total, idmListPolicyGroupsResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyGroups, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmListPolicyGroupsResponse {\n");
    sb.append("    policyGroups: ").append(toIndentedString(policyGroups)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

