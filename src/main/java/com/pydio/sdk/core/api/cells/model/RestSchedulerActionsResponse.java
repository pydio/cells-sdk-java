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
import com.pydio.sdk.core.api.cells.model.RestActionDescription;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RestSchedulerActionsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestSchedulerActionsResponse {
  @SerializedName("Actions")
  private Map<String, RestActionDescription> actions = null;

  public RestSchedulerActionsResponse actions(Map<String, RestActionDescription> actions) {
    this.actions = actions;
    return this;
  }

  public RestSchedulerActionsResponse putActionsItem(String key, RestActionDescription actionsItem) {
    if (this.actions == null) {
      this.actions = new HashMap<String, RestActionDescription>();
    }
    this.actions.put(key, actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @ApiModelProperty(value = "")
  public Map<String, RestActionDescription> getActions() {
    return actions;
  }

  public void setActions(Map<String, RestActionDescription> actions) {
    this.actions = actions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSchedulerActionsResponse restSchedulerActionsResponse = (RestSchedulerActionsResponse) o;
    return Objects.equals(this.actions, restSchedulerActionsResponse.actions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSchedulerActionsResponse {\n");
    
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
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

