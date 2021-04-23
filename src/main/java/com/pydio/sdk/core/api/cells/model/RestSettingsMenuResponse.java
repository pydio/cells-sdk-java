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
import com.pydio.sdk.core.api.cells.model.RestSettingsEntryMeta;
import com.pydio.sdk.core.api.cells.model.RestSettingsSection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * RestSettingsMenuResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class RestSettingsMenuResponse {
  @SerializedName("RootMetadata")
  private RestSettingsEntryMeta rootMetadata = null;

  @SerializedName("Sections")
  private List<RestSettingsSection> sections = null;

  public RestSettingsMenuResponse rootMetadata(RestSettingsEntryMeta rootMetadata) {
    this.rootMetadata = rootMetadata;
    return this;
  }

   /**
   * Get rootMetadata
   * @return rootMetadata
  **/
  @ApiModelProperty(value = "")
  public RestSettingsEntryMeta getRootMetadata() {
    return rootMetadata;
  }

  public void setRootMetadata(RestSettingsEntryMeta rootMetadata) {
    this.rootMetadata = rootMetadata;
  }

  public RestSettingsMenuResponse sections(List<RestSettingsSection> sections) {
    this.sections = sections;
    return this;
  }

  public RestSettingsMenuResponse addSectionsItem(RestSettingsSection sectionsItem) {
    if (this.sections == null) {
      this.sections = new ArrayList<RestSettingsSection>();
    }
    this.sections.add(sectionsItem);
    return this;
  }

   /**
   * Get sections
   * @return sections
  **/
  @ApiModelProperty(value = "")
  public List<RestSettingsSection> getSections() {
    return sections;
  }

  public void setSections(List<RestSettingsSection> sections) {
    this.sections = sections;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSettingsMenuResponse restSettingsMenuResponse = (RestSettingsMenuResponse) o;
    return Objects.equals(this.rootMetadata, restSettingsMenuResponse.rootMetadata) &&
        Objects.equals(this.sections, restSettingsMenuResponse.sections);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rootMetadata, sections);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSettingsMenuResponse {\n");
    
    sb.append("    rootMetadata: ").append(toIndentedString(rootMetadata)).append("\n");
    sb.append("    sections: ").append(toIndentedString(sections)).append("\n");
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

