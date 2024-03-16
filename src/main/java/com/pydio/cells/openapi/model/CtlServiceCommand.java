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

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets ctlServiceCommand
 */
@JsonAdapter(CtlServiceCommand.Adapter.class)
public enum CtlServiceCommand {
  
  START("START"),
  
  STOP("STOP");

  private String value;

  CtlServiceCommand(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CtlServiceCommand fromValue(String value) {
    for (CtlServiceCommand b : CtlServiceCommand.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<CtlServiceCommand> {
    @Override
    public void write(final JsonWriter jsonWriter, final CtlServiceCommand enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public CtlServiceCommand read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return CtlServiceCommand.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    CtlServiceCommand.fromValue(value);
  }
}

