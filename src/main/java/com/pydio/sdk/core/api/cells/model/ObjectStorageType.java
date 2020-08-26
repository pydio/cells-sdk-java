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

  public static ObjectStorageType fromValue(String text) {
    for (ObjectStorageType b : ObjectStorageType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ObjectStorageType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ObjectStorageType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ObjectStorageType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ObjectStorageType.fromValue(String.valueOf(value));
    }
  }
}

