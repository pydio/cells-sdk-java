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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets jobsDataSourceSelectorType
 */
@JsonAdapter(JobsDataSourceSelectorType.Adapter.class)
public enum JobsDataSourceSelectorType {
  
  DATASOURCE("DataSource"),
  
  OBJECT("Object");

  private String value;

  JobsDataSourceSelectorType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static JobsDataSourceSelectorType fromValue(String value) {
    for (JobsDataSourceSelectorType b : JobsDataSourceSelectorType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<JobsDataSourceSelectorType> {
    @Override
    public void write(final JsonWriter jsonWriter, final JobsDataSourceSelectorType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public JobsDataSourceSelectorType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return JobsDataSourceSelectorType.fromValue(value);
    }
  }
}

