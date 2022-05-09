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
import com.pydio.cells.openapi.model.IdmUserMetaNamespace;
import com.pydio.cells.openapi.model.UpdateUserMetaNamespaceRequestUserMetaNsOp;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * IdmUpdateUserMetaNamespaceRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class IdmUpdateUserMetaNamespaceRequest {
  public static final String SERIALIZED_NAME_NAMESPACES = "Namespaces";
  @SerializedName(SERIALIZED_NAME_NAMESPACES)
  private List<IdmUserMetaNamespace> namespaces = null;

  public static final String SERIALIZED_NAME_OPERATION = "Operation";
  @SerializedName(SERIALIZED_NAME_OPERATION)
  private UpdateUserMetaNamespaceRequestUserMetaNsOp operation = UpdateUserMetaNamespaceRequestUserMetaNsOp.PUT;

  public IdmUpdateUserMetaNamespaceRequest() { 
  }

  public IdmUpdateUserMetaNamespaceRequest namespaces(List<IdmUserMetaNamespace> namespaces) {
    
    this.namespaces = namespaces;
    return this;
  }

  public IdmUpdateUserMetaNamespaceRequest addNamespacesItem(IdmUserMetaNamespace namespacesItem) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList<IdmUserMetaNamespace>();
    }
    this.namespaces.add(namespacesItem);
    return this;
  }

   /**
   * Get namespaces
   * @return namespaces
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUserMetaNamespace> getNamespaces() {
    return namespaces;
  }


  public void setNamespaces(List<IdmUserMetaNamespace> namespaces) {
    this.namespaces = namespaces;
  }


  public IdmUpdateUserMetaNamespaceRequest operation(UpdateUserMetaNamespaceRequestUserMetaNsOp operation) {
    
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public UpdateUserMetaNamespaceRequestUserMetaNsOp getOperation() {
    return operation;
  }


  public void setOperation(UpdateUserMetaNamespaceRequestUserMetaNsOp operation) {
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
    IdmUpdateUserMetaNamespaceRequest idmUpdateUserMetaNamespaceRequest = (IdmUpdateUserMetaNamespaceRequest) o;
    return Objects.equals(this.namespaces, idmUpdateUserMetaNamespaceRequest.namespaces) &&
        Objects.equals(this.operation, idmUpdateUserMetaNamespaceRequest.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespaces, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmUpdateUserMetaNamespaceRequest {\n");
    sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
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

