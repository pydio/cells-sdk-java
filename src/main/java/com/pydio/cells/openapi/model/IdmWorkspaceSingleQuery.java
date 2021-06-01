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
import com.pydio.cells.openapi.model.IdmWorkspaceScope;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * IdmWorkspaceSingleQuery
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-06-01T06:29:01.792+02:00")
public class IdmWorkspaceSingleQuery {
  @SerializedName("uuid")
  private String uuid = null;

  @SerializedName("label")
  private String label = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("slug")
  private String slug = null;

  @SerializedName("scope")
  private IdmWorkspaceScope scope = null;

  @SerializedName("LastUpdated")
  private String lastUpdated = null;

  @SerializedName("HasAttribute")
  private String hasAttribute = null;

  @SerializedName("AttributeName")
  private String attributeName = null;

  @SerializedName("AttributeValue")
  private String attributeValue = null;

  @SerializedName("not")
  private Boolean not = null;

  public IdmWorkspaceSingleQuery uuid(String uuid) {
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

  public IdmWorkspaceSingleQuery label(String label) {
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

  public IdmWorkspaceSingleQuery description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public IdmWorkspaceSingleQuery slug(String slug) {
    this.slug = slug;
    return this;
  }

   /**
   * Get slug
   * @return slug
  **/
  @ApiModelProperty(value = "")
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public IdmWorkspaceSingleQuery scope(IdmWorkspaceScope scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @ApiModelProperty(value = "")
  public IdmWorkspaceScope getScope() {
    return scope;
  }

  public void setScope(IdmWorkspaceScope scope) {
    this.scope = scope;
  }

  public IdmWorkspaceSingleQuery lastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @ApiModelProperty(value = "")
  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public IdmWorkspaceSingleQuery hasAttribute(String hasAttribute) {
    this.hasAttribute = hasAttribute;
    return this;
  }

   /**
   * Get hasAttribute
   * @return hasAttribute
  **/
  @ApiModelProperty(value = "")
  public String getHasAttribute() {
    return hasAttribute;
  }

  public void setHasAttribute(String hasAttribute) {
    this.hasAttribute = hasAttribute;
  }

  public IdmWorkspaceSingleQuery attributeName(String attributeName) {
    this.attributeName = attributeName;
    return this;
  }

   /**
   * Get attributeName
   * @return attributeName
  **/
  @ApiModelProperty(value = "")
  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public IdmWorkspaceSingleQuery attributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
    return this;
  }

   /**
   * Get attributeValue
   * @return attributeValue
  **/
  @ApiModelProperty(value = "")
  public String getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }

  public IdmWorkspaceSingleQuery not(Boolean not) {
    this.not = not;
    return this;
  }

   /**
   * Get not
   * @return not
  **/
  @ApiModelProperty(value = "")
  public Boolean isNot() {
    return not;
  }

  public void setNot(Boolean not) {
    this.not = not;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmWorkspaceSingleQuery idmWorkspaceSingleQuery = (IdmWorkspaceSingleQuery) o;
    return Objects.equals(this.uuid, idmWorkspaceSingleQuery.uuid) &&
        Objects.equals(this.label, idmWorkspaceSingleQuery.label) &&
        Objects.equals(this.description, idmWorkspaceSingleQuery.description) &&
        Objects.equals(this.slug, idmWorkspaceSingleQuery.slug) &&
        Objects.equals(this.scope, idmWorkspaceSingleQuery.scope) &&
        Objects.equals(this.lastUpdated, idmWorkspaceSingleQuery.lastUpdated) &&
        Objects.equals(this.hasAttribute, idmWorkspaceSingleQuery.hasAttribute) &&
        Objects.equals(this.attributeName, idmWorkspaceSingleQuery.attributeName) &&
        Objects.equals(this.attributeValue, idmWorkspaceSingleQuery.attributeValue) &&
        Objects.equals(this.not, idmWorkspaceSingleQuery.not);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid, label, description, slug, scope, lastUpdated, hasAttribute, attributeName, attributeValue, not);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmWorkspaceSingleQuery {\n");
    
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    hasAttribute: ").append(toIndentedString(hasAttribute)).append("\n");
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
    sb.append("    not: ").append(toIndentedString(not)).append("\n");
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

