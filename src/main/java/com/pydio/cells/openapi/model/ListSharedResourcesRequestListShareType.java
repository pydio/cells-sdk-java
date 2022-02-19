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
 * Gets or Sets ListSharedResourcesRequestListShareType
 */
@JsonAdapter(ListSharedResourcesRequestListShareType.Adapter.class)
public enum ListSharedResourcesRequestListShareType {
  
  ANY("ANY"),
  
  LINKS("LINKS"),
  
  CELLS("CELLS");

  private String value;

  ListSharedResourcesRequestListShareType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ListSharedResourcesRequestListShareType fromValue(String value) {
    for (ListSharedResourcesRequestListShareType b : ListSharedResourcesRequestListShareType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ListSharedResourcesRequestListShareType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ListSharedResourcesRequestListShareType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ListSharedResourcesRequestListShareType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ListSharedResourcesRequestListShareType.fromValue(value);
    }
  }
}

