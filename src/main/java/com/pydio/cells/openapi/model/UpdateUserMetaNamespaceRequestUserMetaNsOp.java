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
 * Gets or Sets UpdateUserMetaNamespaceRequestUserMetaNsOp
 */
@JsonAdapter(UpdateUserMetaNamespaceRequestUserMetaNsOp.Adapter.class)
public enum UpdateUserMetaNamespaceRequestUserMetaNsOp {

    PUT("PUT"),

    DELETE("DELETE");

    private final String value;

    UpdateUserMetaNamespaceRequestUserMetaNsOp(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static UpdateUserMetaNamespaceRequestUserMetaNsOp fromValue(String value) {
        for (UpdateUserMetaNamespaceRequestUserMetaNsOp b : UpdateUserMetaNamespaceRequestUserMetaNsOp.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<UpdateUserMetaNamespaceRequestUserMetaNsOp> {
        @Override
        public void write(final JsonWriter jsonWriter, final UpdateUserMetaNamespaceRequestUserMetaNsOp enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public UpdateUserMetaNamespaceRequestUserMetaNsOp read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return UpdateUserMetaNamespaceRequestUserMetaNsOp.fromValue(value);
        }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        String value = jsonElement.getAsString();
        UpdateUserMetaNamespaceRequestUserMetaNsOp.fromValue(value);
    }
}

