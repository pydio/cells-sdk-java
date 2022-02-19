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
 * Gets or Sets ListLogRequestLogFormat
 */
@JsonAdapter(ListLogRequestLogFormat.Adapter.class)
public enum ListLogRequestLogFormat {
  
  JSON("JSON"),
  
  CSV("CSV"),
  
  XLSX("XLSX");

  private String value;

  ListLogRequestLogFormat(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ListLogRequestLogFormat fromValue(String value) {
    for (ListLogRequestLogFormat b : ListLogRequestLogFormat.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ListLogRequestLogFormat> {
    @Override
    public void write(final JsonWriter jsonWriter, final ListLogRequestLogFormat enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ListLogRequestLogFormat read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ListLogRequestLogFormat.fromValue(value);
    }
  }
}

