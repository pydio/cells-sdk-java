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
 * Gets or Sets installRuleEffect
 */
@JsonAdapter(InstallRuleEffect.Adapter.class)
public enum InstallRuleEffect {

    DENY("DENY"),

    ACCEPT("ACCEPT");

    private final String value;

    InstallRuleEffect(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static InstallRuleEffect fromValue(String value) {
        for (InstallRuleEffect b : InstallRuleEffect.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<InstallRuleEffect> {
        @Override
        public void write(final JsonWriter jsonWriter, final InstallRuleEffect enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public InstallRuleEffect read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return InstallRuleEffect.fromValue(value);
        }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        String value = jsonElement.getAsString();
        InstallRuleEffect.fromValue(value);
    }
}

