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
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RestPutShareLinkRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class RestPutShareLinkRequest {
    public static final String SERIALIZED_NAME_CREATE_PASSWORD = "CreatePassword";
    @SerializedName(SERIALIZED_NAME_CREATE_PASSWORD)
    @javax.annotation.Nullable
    private String createPassword;

    public static final String SERIALIZED_NAME_PASSWORD_ENABLED = "PasswordEnabled";
    @SerializedName(SERIALIZED_NAME_PASSWORD_ENABLED)
    @javax.annotation.Nullable
    private Boolean passwordEnabled;

    public static final String SERIALIZED_NAME_SHARE_LINK = "ShareLink";
    @SerializedName(SERIALIZED_NAME_SHARE_LINK)
    @javax.annotation.Nullable
    private RestShareLink shareLink;

    public static final String SERIALIZED_NAME_UPDATE_CUSTOM_HASH = "UpdateCustomHash";
    @SerializedName(SERIALIZED_NAME_UPDATE_CUSTOM_HASH)
    @javax.annotation.Nullable
    private String updateCustomHash;

    public static final String SERIALIZED_NAME_UPDATE_PASSWORD = "UpdatePassword";
    @SerializedName(SERIALIZED_NAME_UPDATE_PASSWORD)
    @javax.annotation.Nullable
    private String updatePassword;

    public RestPutShareLinkRequest() {
    }

    public RestPutShareLinkRequest createPassword(@javax.annotation.Nullable String createPassword) {
        this.createPassword = createPassword;
        return this;
    }

    /**
     * Get createPassword
     *
     * @return createPassword
     */
    @javax.annotation.Nullable
    public String getCreatePassword() {
        return createPassword;
    }

    public void setCreatePassword(@javax.annotation.Nullable String createPassword) {
        this.createPassword = createPassword;
    }


    public RestPutShareLinkRequest passwordEnabled(@javax.annotation.Nullable Boolean passwordEnabled) {
        this.passwordEnabled = passwordEnabled;
        return this;
    }

    /**
     * Get passwordEnabled
     *
     * @return passwordEnabled
     */
    @javax.annotation.Nullable
    public Boolean getPasswordEnabled() {
        return passwordEnabled;
    }

    public void setPasswordEnabled(@javax.annotation.Nullable Boolean passwordEnabled) {
        this.passwordEnabled = passwordEnabled;
    }


    public RestPutShareLinkRequest shareLink(@javax.annotation.Nullable RestShareLink shareLink) {
        this.shareLink = shareLink;
        return this;
    }

    /**
     * Get shareLink
     *
     * @return shareLink
     */
    @javax.annotation.Nullable
    public RestShareLink getShareLink() {
        return shareLink;
    }

    public void setShareLink(@javax.annotation.Nullable RestShareLink shareLink) {
        this.shareLink = shareLink;
    }


    public RestPutShareLinkRequest updateCustomHash(@javax.annotation.Nullable String updateCustomHash) {
        this.updateCustomHash = updateCustomHash;
        return this;
    }

    /**
     * Get updateCustomHash
     *
     * @return updateCustomHash
     */
    @javax.annotation.Nullable
    public String getUpdateCustomHash() {
        return updateCustomHash;
    }

    public void setUpdateCustomHash(@javax.annotation.Nullable String updateCustomHash) {
        this.updateCustomHash = updateCustomHash;
    }


    public RestPutShareLinkRequest updatePassword(@javax.annotation.Nullable String updatePassword) {
        this.updatePassword = updatePassword;
        return this;
    }

    /**
     * Get updatePassword
     *
     * @return updatePassword
     */
    @javax.annotation.Nullable
    public String getUpdatePassword() {
        return updatePassword;
    }

    public void setUpdatePassword(@javax.annotation.Nullable String updatePassword) {
        this.updatePassword = updatePassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestPutShareLinkRequest restPutShareLinkRequest = (RestPutShareLinkRequest) o;
        return Objects.equals(this.createPassword, restPutShareLinkRequest.createPassword) &&
                Objects.equals(this.passwordEnabled, restPutShareLinkRequest.passwordEnabled) &&
                Objects.equals(this.shareLink, restPutShareLinkRequest.shareLink) &&
                Objects.equals(this.updateCustomHash, restPutShareLinkRequest.updateCustomHash) &&
                Objects.equals(this.updatePassword, restPutShareLinkRequest.updatePassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createPassword, passwordEnabled, shareLink, updateCustomHash, updatePassword);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPutShareLinkRequest {\n");
        sb.append("    createPassword: ").append(toIndentedString(createPassword)).append("\n");
        sb.append("    passwordEnabled: ").append(toIndentedString(passwordEnabled)).append("\n");
        sb.append("    shareLink: ").append(toIndentedString(shareLink)).append("\n");
        sb.append("    updateCustomHash: ").append(toIndentedString(updateCustomHash)).append("\n");
        sb.append("    updatePassword: ").append(toIndentedString(updatePassword)).append("\n");
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
        openapiFields.add("CreatePassword");
        openapiFields.add("PasswordEnabled");
        openapiFields.add("ShareLink");
        openapiFields.add("UpdateCustomHash");
        openapiFields.add("UpdatePassword");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RestPutShareLinkRequest
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RestPutShareLinkRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RestPutShareLinkRequest is not found in the empty JSON string", RestPutShareLinkRequest.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RestPutShareLinkRequest.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestPutShareLinkRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("CreatePassword") != null && !jsonObj.get("CreatePassword").isJsonNull()) && !jsonObj.get("CreatePassword").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `CreatePassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CreatePassword").toString()));
        }
        // validate the optional field `ShareLink`
        if (jsonObj.get("ShareLink") != null && !jsonObj.get("ShareLink").isJsonNull()) {
            RestShareLink.validateJsonElement(jsonObj.get("ShareLink"));
        }
        if ((jsonObj.get("UpdateCustomHash") != null && !jsonObj.get("UpdateCustomHash").isJsonNull()) && !jsonObj.get("UpdateCustomHash").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `UpdateCustomHash` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UpdateCustomHash").toString()));
        }
        if ((jsonObj.get("UpdatePassword") != null && !jsonObj.get("UpdatePassword").isJsonNull()) && !jsonObj.get("UpdatePassword").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `UpdatePassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UpdatePassword").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RestPutShareLinkRequest.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RestPutShareLinkRequest' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RestPutShareLinkRequest> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(RestPutShareLinkRequest.class));

            return (TypeAdapter<T>) new TypeAdapter<RestPutShareLinkRequest>() {
                @Override
                public void write(JsonWriter out, RestPutShareLinkRequest value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RestPutShareLinkRequest read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of RestPutShareLinkRequest given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RestPutShareLinkRequest
     * @throws IOException if the JSON string is invalid with respect to RestPutShareLinkRequest
     */
    public static RestPutShareLinkRequest fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RestPutShareLinkRequest.class);
    }

    /**
     * Convert an instance of RestPutShareLinkRequest to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

