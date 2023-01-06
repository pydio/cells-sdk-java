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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets objectStorageType
 */
@JsonAdapter(ObjectStorageType.Adapter.class)
public enum ObjectStorageType {
  
  LOCAL("LOCAL"),
  
  S3("S3"),
  
  SMB("SMB"),
  
  CELLS("CELLS"),
  
  AZURE("AZURE"),
  
  GCS("GCS"),
  
  B2("B2"),
  
  MANTA("MANTA"),
  
  SIA("SIA");

  private String value;

  ObjectStorageType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ObjectStorageType fromValue(String value) {
    for (ObjectStorageType b : ObjectStorageType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<ObjectStorageType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ObjectStorageType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ObjectStorageType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ObjectStorageType.fromValue(value);
    }
  }
}

