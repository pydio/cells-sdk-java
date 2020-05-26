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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets restShareLinkAccessType
 */
@JsonAdapter(RestShareLinkAccessType.Adapter.class)
public enum RestShareLinkAccessType {

    NOACCESS("NoAccess"),

    PREVIEW("Preview"),

    DOWNLOAD("Download"),

    UPLOAD("Upload");

    private String value;

    RestShareLinkAccessType(String value) {
        this.value = value;
    }

    public static RestShareLinkAccessType fromValue(String text) {
        for (RestShareLinkAccessType b : RestShareLinkAccessType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static class Adapter extends TypeAdapter<RestShareLinkAccessType> {
        @Override
        public void write(final JsonWriter jsonWriter, final RestShareLinkAccessType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public RestShareLinkAccessType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return RestShareLinkAccessType.fromValue(String.valueOf(value));
        }
    }
}

