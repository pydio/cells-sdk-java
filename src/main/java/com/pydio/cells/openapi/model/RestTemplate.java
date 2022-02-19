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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestTemplate {
  public static final String SERIALIZED_NAME_U_U_I_D = "UUID";
  @SerializedName(SERIALIZED_NAME_U_U_I_D)
  private String UUID;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_NODE = "Node";
  @SerializedName(SERIALIZED_NAME_NODE)
  private RestTemplateNode node;

  public static final String SERIALIZED_NAME_POLICIES = "Policies";
  @SerializedName(SERIALIZED_NAME_POLICIES)
  private List<ServiceResourcePolicy> policies = null;

  public RestTemplate() { 
  }

  public RestTemplate UUID(String UUID) {
    
    this.UUID = UUID;
    return this;
  }

   /**
   * Get UUID
   * @return UUID
  **/
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
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
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ServiceResourcePolicy> getPolicies() {
    return policies;
  }


  public void setPolicies(List<ServiceResourcePolicy> policies) {
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

