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
import com.pydio.cells.openapi.model.ActivitySubscription;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestSubscriptionsCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestSubscriptionsCollection {
  public static final String SERIALIZED_NAME_SUBSCRIPTIONS = "subscriptions";
  @SerializedName(SERIALIZED_NAME_SUBSCRIPTIONS)
  private List<ActivitySubscription> subscriptions = null;

  public RestSubscriptionsCollection() { 
  }

  public RestSubscriptionsCollection subscriptions(List<ActivitySubscription> subscriptions) {
    
    this.subscriptions = subscriptions;
    return this;
  }

  public RestSubscriptionsCollection addSubscriptionsItem(ActivitySubscription subscriptionsItem) {
    if (this.subscriptions == null) {
      this.subscriptions = new ArrayList<ActivitySubscription>();
    }
    this.subscriptions.add(subscriptionsItem);
    return this;
  }

   /**
   * Get subscriptions
   * @return subscriptions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ActivitySubscription> getSubscriptions() {
    return subscriptions;
  }


  public void setSubscriptions(List<ActivitySubscription> subscriptions) {
    this.subscriptions = subscriptions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSubscriptionsCollection restSubscriptionsCollection = (RestSubscriptionsCollection) o;
    return Objects.equals(this.subscriptions, restSubscriptionsCollection.subscriptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSubscriptionsCollection {\n");
    sb.append("    subscriptions: ").append(toIndentedString(subscriptions)).append("\n");
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

