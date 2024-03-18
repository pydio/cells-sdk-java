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
 * Gets or Sets PackagePackageStatus
 */
@JsonAdapter(PackagePackageStatus.Adapter.class)
public enum PackagePackageStatus {

    DRAFT("Draft"),

    PENDING("Pending"),

    RELEASED("Released");

    private final String value;

    PackagePackageStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static PackagePackageStatus fromValue(String value) {
        for (PackagePackageStatus b : PackagePackageStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<PackagePackageStatus> {
        @Override
        public void write(final JsonWriter jsonWriter, final PackagePackageStatus enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public PackagePackageStatus read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return PackagePackageStatus.fromValue(value);
        }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        String value = jsonElement.getAsString();
        PackagePackageStatus.fromValue(value);
    }
}

