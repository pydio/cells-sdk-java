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
import com.pydio.cells.openapi.model.ServiceResourcePolicy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestUpdateSharePoliciesRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestUpdateSharePoliciesRequest {
  @SerializedName("Uuid")
  private String uuid = null;

  @SerializedName("Policies")
  private List<ServiceResourcePolicy> policies = null;

  public RestUpdateSharePoliciesRequest uuid(String uuid) {
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @ApiModelProperty(value = "")
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public RestUpdateSharePoliciesRequest policies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
    return this;
  }

  public RestUpdateSharePoliciesRequest addPoliciesItem(ServiceResourcePolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<ServiceResourcePolicy>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @ApiModelProperty(value = "")
  public List<ServiceResourcePolicy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestUpdateSharePoliciesRequest restUpdateSharePoliciesRequest = (RestUpdateSharePoliciesRequest) o;
    return Objects.equals(this.uuid, restUpdateSharePoliciesRequest.uuid) &&
        Objects.equals(this.policies, restUpdateSharePoliciesRequest.policies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, policies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUpdateSharePoliciesRequest {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
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

