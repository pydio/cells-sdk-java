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
import com.pydio.cells.openapi.model.RegistryOptions;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RegistryListRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class RegistryListRequest {
  public static final String SERIALIZED_NAME_ADJACENTS_OPTIONS = "adjacentsOptions";
  @SerializedName(SERIALIZED_NAME_ADJACENTS_OPTIONS)
  private RegistryOptions adjacentsOptions;

  public static final String SERIALIZED_NAME_OPTIONS = "options";
  @SerializedName(SERIALIZED_NAME_OPTIONS)
  private RegistryOptions options;

  public RegistryListRequest() { 
  }

  public RegistryListRequest adjacentsOptions(RegistryOptions adjacentsOptions) {
    
    this.adjacentsOptions = adjacentsOptions;
    return this;
  }

   /**
   * Get adjacentsOptions
   * @return adjacentsOptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RegistryOptions getAdjacentsOptions() {
    return adjacentsOptions;
  }


  public void setAdjacentsOptions(RegistryOptions adjacentsOptions) {
    this.adjacentsOptions = adjacentsOptions;
  }


  public RegistryListRequest options(RegistryOptions options) {
    
    this.options = options;
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RegistryOptions getOptions() {
    return options;
  }


  public void setOptions(RegistryOptions options) {
    this.options = options;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryListRequest registryListRequest = (RegistryListRequest) o;
    return Objects.equals(this.adjacentsOptions, registryListRequest.adjacentsOptions) &&
        Objects.equals(this.options, registryListRequest.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adjacentsOptions, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistryListRequest {\n");
    sb.append("    adjacentsOptions: ").append(toIndentedString(adjacentsOptions)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

