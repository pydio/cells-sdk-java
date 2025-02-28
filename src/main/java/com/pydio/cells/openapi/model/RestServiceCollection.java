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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RestServiceCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestServiceCollection {
    public static final String SERIALIZED_NAME_SERVICES = "Services";
    @SerializedName(SERIALIZED_NAME_SERVICES)
    @javax.annotation.Nullable
    private List<CtlService> services = new ArrayList<>();

    public static final String SERIALIZED_NAME_TOTAL = "Total";
    @SerializedName(SERIALIZED_NAME_TOTAL)
    @javax.annotation.Nullable
    private Integer total;

    public RestServiceCollection() {
    }

    public RestServiceCollection services(@javax.annotation.Nullable List<CtlService> services) {
        this.services = services;
        return this;
    }

    public RestServiceCollection addServicesItem(CtlService servicesItem) {
        if (this.services == null) {
            this.services = new ArrayList<>();
        }
        this.services.add(servicesItem);
        return this;
    }

    /**
     * Get services
     *
     * @return services
     */
    @javax.annotation.Nullable
    public List<CtlService> getServices() {
        return services;
    }

    public void setServices(@javax.annotation.Nullable List<CtlService> services) {
        this.services = services;
    }


    public RestServiceCollection total(@javax.annotation.Nullable Integer total) {
        this.total = total;
        return this;
    }

    /**
     * Get total
     *
     * @return total
     */
    @javax.annotation.Nullable
    public Integer getTotal() {
        return total;
    }

    public void setTotal(@javax.annotation.Nullable Integer total) {
        this.total = total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestServiceCollection restServiceCollection = (RestServiceCollection) o;
        return Objects.equals(this.services, restServiceCollection.services) &&
                Objects.equals(this.total, restServiceCollection.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services, total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestServiceCollection {\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("Services");
        openapiFields.add("Total");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestServiceCollection
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestServiceCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestServiceCollection is not found in the empty JSON string", RestServiceCollection.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestServiceCollection.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestServiceCollection` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (jsonObj.get("Services") != null && !jsonObj.get("Services").isJsonNull()) {
            JsonArray jsonArrayservices = jsonObj.getAsJsonArray("Services");
            if (jsonArrayservices != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Services").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Services` to be an array in the JSON string but got `%s`", jsonObj.get("Services").toString()));
                }

                // validate the optional field `Services` (array)
                for (int i = 0; i < jsonArrayservices.size(); i++) {
                    CtlService.validateJsonElement(jsonArrayservices.get(i));
                }
                ;
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestServiceCollection.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestServiceCollection' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestServiceCollection> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestServiceCollection.class));

            return (TypeAdapter<T>) new TypeAdapter<RestServiceCollection>() {
                @Override
                public void write(JsonWriter out, RestServiceCollection value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestServiceCollection read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestServiceCollection given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestServiceCollection
     * @throws IOException if the JSON string is invalid with respect to RestServiceCollection
     */
    public static RestServiceCollection fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestServiceCollection.class);
    }

    /**
     * Convert an instance of RestServiceCollection to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

