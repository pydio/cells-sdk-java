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
import com.pydio.cells.openapi.model.RestCell;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * RestPutCellRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestPutCellRequest {
  public static final String SERIALIZED_NAME_CREATE_EMPTY_ROOT = "CreateEmptyRoot";
  @SerializedName(SERIALIZED_NAME_CREATE_EMPTY_ROOT)
  private Boolean createEmptyRoot;

  public static final String SERIALIZED_NAME_ROOM = "Room";
  @SerializedName(SERIALIZED_NAME_ROOM)
  private RestCell room;

  public RestPutCellRequest() { 
  }

  public RestPutCellRequest createEmptyRoot(Boolean createEmptyRoot) {
    
    this.createEmptyRoot = createEmptyRoot;
    return this;
  }

   /**
   * Get createEmptyRoot
   * @return createEmptyRoot
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getCreateEmptyRoot() {
    return createEmptyRoot;
  }


  public void setCreateEmptyRoot(Boolean createEmptyRoot) {
    this.createEmptyRoot = createEmptyRoot;
  }


  public RestPutCellRequest room(RestCell room) {
    
    this.room = room;
    return this;
  }

   /**
   * Get room
   * @return room
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public RestCell getRoom() {
    return room;
  }


  public void setRoom(RestCell room) {
    this.room = room;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestPutCellRequest restPutCellRequest = (RestPutCellRequest) o;
    return Objects.equals(this.createEmptyRoot, restPutCellRequest.createEmptyRoot) &&
        Objects.equals(this.room, restPutCellRequest.room);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createEmptyRoot, room);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPutCellRequest {\n");
    sb.append("    createEmptyRoot: ").append(toIndentedString(createEmptyRoot)).append("\n");
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
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

