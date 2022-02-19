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
import com.pydio.cells.openapi.model.CtlService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestServiceCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-19T22:47:44.466567+01:00[Europe/Berlin]")
public class RestServiceCollection {
  public static final String SERIALIZED_NAME_SERVICES = "Services";
  @SerializedName(SERIALIZED_NAME_SERVICES)
  private List<CtlService> services = null;

  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public RestServiceCollection() { 
  }

  public RestServiceCollection services(List<CtlService> services) {
    
    this.services = services;
    return this;
  }

  public RestServiceCollection addServicesItem(CtlService servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<CtlService>();
    }
    this.services.add(servicesItem);
    return this;
  }

   /**
   * Get services
   * @return services
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<CtlService> getServices() {
    return services;
  }


  public void setServices(List<CtlService> services) {
    this.services = services;
  }


  public RestServiceCollection total(Integer total) {
    
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
    RestServiceCollection restServiceCollection = (RestServiceCollection) o;
    return Objects.equals(this.services, restServiceCollection.services) &&
        Objects.equals(this.total, restServiceCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestServiceCollection {\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
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

