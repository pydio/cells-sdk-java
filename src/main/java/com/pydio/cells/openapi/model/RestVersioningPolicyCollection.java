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
import com.pydio.cells.openapi.model.TreeVersioningPolicy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestVersioningPolicyCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class RestVersioningPolicyCollection {
  public static final String SERIALIZED_NAME_POLICIES = "Policies";
  @SerializedName(SERIALIZED_NAME_POLICIES)
  private List<TreeVersioningPolicy> policies = null;

  public RestVersioningPolicyCollection() { 
  }

  public RestVersioningPolicyCollection policies(List<TreeVersioningPolicy> policies) {
    
    this.policies = policies;
    return this;
  }

  public RestVersioningPolicyCollection addPoliciesItem(TreeVersioningPolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<TreeVersioningPolicy>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<TreeVersioningPolicy> getPolicies() {
    return policies;
  }


  public void setPolicies(List<TreeVersioningPolicy> policies) {
    this.policies = policies;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestVersioningPolicyCollection restVersioningPolicyCollection = (RestVersioningPolicyCollection) o;
    return Objects.equals(this.policies, restVersioningPolicyCollection.policies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policies);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestVersioningPolicyCollection {\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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

