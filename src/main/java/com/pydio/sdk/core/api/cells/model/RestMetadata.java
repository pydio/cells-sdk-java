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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestMetadata
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-08-26T11:16:15.623+02:00")



public class RestMetadata {
  @SerializedName("Namespace")
  private String namespace = null;

  @SerializedName("JsonMeta")
  private String jsonMeta = null;

  public RestMetadata namespace(String namespace) {
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

  public RestMetadata jsonMeta(String jsonMeta) {
    this.jsonMeta = jsonMeta;
    return this;
  }

   /**
   * Get jsonMeta
   * @return jsonMeta
  **/
  @ApiModelProperty(value = "")
  public String getJsonMeta() {
    return jsonMeta;
  }

  public void setJsonMeta(String jsonMeta) {
    this.jsonMeta = jsonMeta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestMetadata restMetadata = (RestMetadata) o;
    return Objects.equals(this.namespace, restMetadata.namespace) &&
        Objects.equals(this.jsonMeta, restMetadata.jsonMeta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, jsonMeta);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMetadata {\n");
    
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    jsonMeta: ").append(toIndentedString(jsonMeta)).append("\n");
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

