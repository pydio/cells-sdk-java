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
import com.pydio.sdk.core.api.cells.model.ServiceResourcePolicyQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IdmSearchUserMetaRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class IdmSearchUserMetaRequest {
  @SerializedName("MetaUuids")
  private List<String> metaUuids = null;

  @SerializedName("NodeUuids")
  private List<String> nodeUuids = null;

  @SerializedName("Namespace")
  private String namespace = null;

  @SerializedName("ResourceSubjectOwner")
  private String resourceSubjectOwner = null;

  @SerializedName("ResourceQuery")
  private ServiceResourcePolicyQuery resourceQuery = null;

  public IdmSearchUserMetaRequest metaUuids(List<String> metaUuids) {
    this.metaUuids = metaUuids;
    return this;
  }

  public IdmSearchUserMetaRequest addMetaUuidsItem(String metaUuidsItem) {
    if (this.metaUuids == null) {
      this.metaUuids = new ArrayList<String>();
    }
    this.metaUuids.add(metaUuidsItem);
    return this;
  }

   /**
   * Get metaUuids
   * @return metaUuids
  **/
  @ApiModelProperty(value = "")
  public List<String> getMetaUuids() {
    return metaUuids;
  }

  public void setMetaUuids(List<String> metaUuids) {
    this.metaUuids = metaUuids;
  }

  public IdmSearchUserMetaRequest nodeUuids(List<String> nodeUuids) {
    this.nodeUuids = nodeUuids;
    return this;
  }

  public IdmSearchUserMetaRequest addNodeUuidsItem(String nodeUuidsItem) {
    if (this.nodeUuids == null) {
      this.nodeUuids = new ArrayList<String>();
    }
    this.nodeUuids.add(nodeUuidsItem);
    return this;
  }

   /**
   * Get nodeUuids
   * @return nodeUuids
  **/
  @ApiModelProperty(value = "")
  public List<String> getNodeUuids() {
    return nodeUuids;
  }

  public void setNodeUuids(List<String> nodeUuids) {
    this.nodeUuids = nodeUuids;
  }

  public IdmSearchUserMetaRequest namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Get namespace
   * @return namespace
  **/
  @ApiModelProperty(value = "")
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public IdmSearchUserMetaRequest resourceSubjectOwner(String resourceSubjectOwner) {
    this.resourceSubjectOwner = resourceSubjectOwner;
    return this;
  }

   /**
   * Get resourceSubjectOwner
   * @return resourceSubjectOwner
  **/
  @ApiModelProperty(value = "")
  public String getResourceSubjectOwner() {
    return resourceSubjectOwner;
  }

  public void setResourceSubjectOwner(String resourceSubjectOwner) {
    this.resourceSubjectOwner = resourceSubjectOwner;
  }

  public IdmSearchUserMetaRequest resourceQuery(ServiceResourcePolicyQuery resourceQuery) {
    this.resourceQuery = resourceQuery;
    return this;
  }

   /**
   * Get resourceQuery
   * @return resourceQuery
  **/
  @ApiModelProperty(value = "")
  public ServiceResourcePolicyQuery getResourceQuery() {
    return resourceQuery;
  }

  public void setResourceQuery(ServiceResourcePolicyQuery resourceQuery) {
    this.resourceQuery = resourceQuery;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmSearchUserMetaRequest idmSearchUserMetaRequest = (IdmSearchUserMetaRequest) o;
    return Objects.equals(this.metaUuids, idmSearchUserMetaRequest.metaUuids) &&
        Objects.equals(this.nodeUuids, idmSearchUserMetaRequest.nodeUuids) &&
        Objects.equals(this.namespace, idmSearchUserMetaRequest.namespace) &&
        Objects.equals(this.resourceSubjectOwner, idmSearchUserMetaRequest.resourceSubjectOwner) &&
        Objects.equals(this.resourceQuery, idmSearchUserMetaRequest.resourceQuery);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metaUuids, nodeUuids, namespace, resourceSubjectOwner, resourceQuery);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmSearchUserMetaRequest {\n");
    
    sb.append("    metaUuids: ").append(toIndentedString(metaUuids)).append("\n");
    sb.append("    nodeUuids: ").append(toIndentedString(nodeUuids)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    resourceSubjectOwner: ").append(toIndentedString(resourceSubjectOwner)).append("\n");
    sb.append("    resourceQuery: ").append(toIndentedString(resourceQuery)).append("\n");
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

