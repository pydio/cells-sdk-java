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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets jobsCommand
 */
@JsonAdapter(JobsCommand.Adapter.class)
public enum JobsCommand {
  
  NONE("None"),
  
  PAUSE("Pause"),
  
  RESUME("Resume"),
  
  STOP("Stop"),
  
  DELETE("Delete"),
  
  RUNONCE("RunOnce"),
  
  INACTIVE("Inactive"),
  
  ACTIVE("Active");

  private String value;

  JobsCommand(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static JobsCommand fromValue(String text) {
    for (JobsCommand b : JobsCommand.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<JobsCommand> {
    @Override
    public void write(final JsonWriter jsonWriter, final JobsCommand enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public JobsCommand read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return JobsCommand.fromValue(String.valueOf(value));
    }
  }
}

