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
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets activityStreamContext
 */
@JsonAdapter(ActivityStreamContext.Adapter.class)
public enum ActivityStreamContext {
  
  MYFEED("MYFEED"),
  
  USER_ID("USER_ID"),
  
  NODE_ID("NODE_ID");

  private String value;

  ActivityStreamContext(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ActivityStreamContext fromValue(String text) {
    for (ActivityStreamContext b : ActivityStreamContext.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ActivityStreamContext> {
    @Override
    public void write(final JsonWriter jsonWriter, final ActivityStreamContext enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ActivityStreamContext read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ActivityStreamContext.fromValue(String.valueOf(value));
    }
  }
}

