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
import com.pydio.cells.openapi.model.RestTemplateNode;
import com.pydio.cells.openapi.model.ServiceResourcePolicy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestTemplate
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class RestTemplate {
  @SerializedName("UUID")
  private String UUID = null;

  @SerializedName("Label")
  private String label = null;

  @SerializedName("Node")
  private RestTemplateNode node = null;

  @SerializedName("Policies")
  private List<ServiceResourcePolicy> policies = null;

  public RestTemplate UUID(String UUID) {
    this.UUID = UUID;
    return this;
  }

   /**
   * Get UUID
   * @return UUID
  **/
  @ApiModelProperty(value = "")
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public RestTemplate label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @ApiModelProperty(value = "")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public RestTemplate node(RestTemplateNode node) {
    this.node = node;
    return this;
  }

   /**
   * Get node
   * @return node
  **/
  @ApiModelProperty(value = "")
  public RestTemplateNode getNode() {
    return node;
  }

  public void setNode(RestTemplateNode node) {
    this.node = node;
  }

  public RestTemplate policies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
    return this;
  }

  public RestTemplate addPoliciesItem(ServiceResourcePolicy policiesItem) {
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
    RestTemplate restTemplate = (RestTemplate) o;
    return Objects.equals(this.UUID, restTemplate.UUID) &&
        Objects.equals(this.label, restTemplate.label) &&
        Objects.equals(this.node, restTemplate.node) &&
        Objects.equals(this.policies, restTemplate.policies);
  }

  @Override
  public int hashCode() {
    return Objects.hash(UUID, label, node, policies);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestTemplate {\n");
    
    sb.append("    UUID: ").append(toIndentedString(UUID)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    node: ").append(toIndentedString(node)).append("\n");
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
