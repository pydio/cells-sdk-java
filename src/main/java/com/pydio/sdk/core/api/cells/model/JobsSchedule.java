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
 * JobsSchedule
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class JobsSchedule {
  @SerializedName("Iso8601Schedule")
  private String iso8601Schedule = null;

  @SerializedName("Iso8601MinDelta")
  private String iso8601MinDelta = null;

  public JobsSchedule iso8601Schedule(String iso8601Schedule) {
    this.iso8601Schedule = iso8601Schedule;
    return this;
  }

   /**
   * ISO 8601 Description of the scheduling for instance \&quot;R2/2015-06-04T19:25:16.828696-07:00/PT4S\&quot; where first part is the number of repetitions (if 0, infinite repetition),  second part the starting date and last part, the duration between 2 occurrences.
   * @return iso8601Schedule
  **/
  @ApiModelProperty(value = "ISO 8601 Description of the scheduling for instance \"R2/2015-06-04T19:25:16.828696-07:00/PT4S\" where first part is the number of repetitions (if 0, infinite repetition),  second part the starting date and last part, the duration between 2 occurrences.")
  public String getIso8601Schedule() {
    return iso8601Schedule;
  }

  public void setIso8601Schedule(String iso8601Schedule) {
    this.iso8601Schedule = iso8601Schedule;
  }

  public JobsSchedule iso8601MinDelta(String iso8601MinDelta) {
    this.iso8601MinDelta = iso8601MinDelta;
    return this;
  }

   /**
   * Get iso8601MinDelta
   * @return iso8601MinDelta
  **/
  @ApiModelProperty(value = "")
  public String getIso8601MinDelta() {
    return iso8601MinDelta;
  }

  public void setIso8601MinDelta(String iso8601MinDelta) {
    this.iso8601MinDelta = iso8601MinDelta;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsSchedule jobsSchedule = (JobsSchedule) o;
    return Objects.equals(this.iso8601Schedule, jobsSchedule.iso8601Schedule) &&
        Objects.equals(this.iso8601MinDelta, jobsSchedule.iso8601MinDelta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iso8601Schedule, iso8601MinDelta);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsSchedule {\n");
    
    sb.append("    iso8601Schedule: ").append(toIndentedString(iso8601Schedule)).append("\n");
    sb.append("    iso8601MinDelta: ").append(toIndentedString(iso8601MinDelta)).append("\n");
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

