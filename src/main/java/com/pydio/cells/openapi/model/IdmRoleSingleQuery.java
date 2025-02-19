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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RoleSingleQuery is the basic unit for building queries to Roles.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class IdmRoleSingleQuery {
    public static final String SERIALIZED_NAME_HAS_AUTO_APPLY = "HasAutoApply";
    @SerializedName(SERIALIZED_NAME_HAS_AUTO_APPLY)
    @javax.annotation.Nullable
    private Boolean hasAutoApply;

    public static final String SERIALIZED_NAME_IS_GROUP_ROLE = "IsGroupRole";
    @SerializedName(SERIALIZED_NAME_IS_GROUP_ROLE)
    @javax.annotation.Nullable
    private Boolean isGroupRole;

    public static final String SERIALIZED_NAME_IS_TEAM = "IsTeam";
    @SerializedName(SERIALIZED_NAME_IS_TEAM)
    @javax.annotation.Nullable
    private Boolean isTeam;

    public static final String SERIALIZED_NAME_IS_USER_ROLE = "IsUserRole";
    @SerializedName(SERIALIZED_NAME_IS_USER_ROLE)
    @javax.annotation.Nullable
    private Boolean isUserRole;

    public static final String SERIALIZED_NAME_LABEL = "Label";
    @SerializedName(SERIALIZED_NAME_LABEL)
    @javax.annotation.Nullable
    private String label;

    public static final String SERIALIZED_NAME_UUID = "Uuid";
    @SerializedName(SERIALIZED_NAME_UUID)
    @javax.annotation.Nullable
    private List<String> uuid = new ArrayList<>();

    public static final String SERIALIZED_NAME_NOT = "not";
    @SerializedName(SERIALIZED_NAME_NOT)
    @javax.annotation.Nullable
    private Boolean not;

    public IdmRoleSingleQuery() {
    }

    public IdmRoleSingleQuery hasAutoApply(@javax.annotation.Nullable Boolean hasAutoApply) {
        this.hasAutoApply = hasAutoApply;
        return this;
    }

    /**
     * Get hasAutoApply
     *
     * @return hasAutoApply
     */
    @javax.annotation.Nullable
    public Boolean getHasAutoApply() {
        return hasAutoApply;
    }

    public void setHasAutoApply(@javax.annotation.Nullable Boolean hasAutoApply) {
        this.hasAutoApply = hasAutoApply;
    }


    public IdmRoleSingleQuery isGroupRole(@javax.annotation.Nullable Boolean isGroupRole) {
        this.isGroupRole = isGroupRole;
        return this;
    }

    /**
     * Get isGroupRole
     *
     * @return isGroupRole
     */
    @javax.annotation.Nullable
    public Boolean getIsGroupRole() {
        return isGroupRole;
    }

    public void setIsGroupRole(@javax.annotation.Nullable Boolean isGroupRole) {
        this.isGroupRole = isGroupRole;
    }


    public IdmRoleSingleQuery isTeam(@javax.annotation.Nullable Boolean isTeam) {
        this.isTeam = isTeam;
        return this;
    }

    /**
     * Get isTeam
     *
     * @return isTeam
     */
    @javax.annotation.Nullable
    public Boolean getIsTeam() {
        return isTeam;
    }

    public void setIsTeam(@javax.annotation.Nullable Boolean isTeam) {
        this.isTeam = isTeam;
    }


    public IdmRoleSingleQuery isUserRole(@javax.annotation.Nullable Boolean isUserRole) {
        this.isUserRole = isUserRole;
        return this;
    }

    /**
     * Get isUserRole
     *
     * @return isUserRole
     */
    @javax.annotation.Nullable
    public Boolean getIsUserRole() {
        return isUserRole;
    }

    public void setIsUserRole(@javax.annotation.Nullable Boolean isUserRole) {
        this.isUserRole = isUserRole;
    }


    public IdmRoleSingleQuery label(@javax.annotation.Nullable String label) {
        this.label = label;
        return this;
    }

    /**
     * Get label
     *
     * @return label
     */
    @javax.annotation.Nullable
    public String getLabel() {
        return label;
    }

    public void setLabel(@javax.annotation.Nullable String label) {
        this.label = label;
    }


    public IdmRoleSingleQuery uuid(@javax.annotation.Nullable List<String> uuid) {
        this.uuid = uuid;
        return this;
    }

    public IdmRoleSingleQuery addUuidItem(String uuidItem) {
        if (this.uuid == null) {
            this.uuid = new ArrayList<>();
        }
        this.uuid.add(uuidItem);
        return this;
    }

    /**
     * Get uuid
     *
     * @return uuid
     */
    @javax.annotation.Nullable
    public List<String> getUuid() {
        return uuid;
    }

    public void setUuid(@javax.annotation.Nullable List<String> uuid) {
        this.uuid = uuid;
    }


    public IdmRoleSingleQuery not(@javax.annotation.Nullable Boolean not) {
        this.not = not;
        return this;
    }

    /**
     * Get not
     *
     * @return not
     */
    @javax.annotation.Nullable
    public Boolean getNot() {
        return not;
    }

    public void setNot(@javax.annotation.Nullable Boolean not) {
        this.not = not;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdmRoleSingleQuery idmRoleSingleQuery = (IdmRoleSingleQuery) o;
        return Objects.equals(this.hasAutoApply, idmRoleSingleQuery.hasAutoApply) &&
                Objects.equals(this.isGroupRole, idmRoleSingleQuery.isGroupRole) &&
                Objects.equals(this.isTeam, idmRoleSingleQuery.isTeam) &&
                Objects.equals(this.isUserRole, idmRoleSingleQuery.isUserRole) &&
                Objects.equals(this.label, idmRoleSingleQuery.label) &&
                Objects.equals(this.uuid, idmRoleSingleQuery.uuid) &&
                Objects.equals(this.not, idmRoleSingleQuery.not);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasAutoApply, isGroupRole, isTeam, isUserRole, label, uuid, not);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdmRoleSingleQuery {\n");
        sb.append("    hasAutoApply: ").append(toIndentedString(hasAutoApply)).append("\n");
        sb.append("    isGroupRole: ").append(toIndentedString(isGroupRole)).append("\n");
        sb.append("    isTeam: ").append(toIndentedString(isTeam)).append("\n");
        sb.append("    isUserRole: ").append(toIndentedString(isUserRole)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    not: ").append(toIndentedString(not)).append("\n");
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
        openapiFields.add("HasAutoApply");
        openapiFields.add("IsGroupRole");
        openapiFields.add("IsTeam");
        openapiFields.add("IsUserRole");
        openapiFields.add("Label");
        openapiFields.add("Uuid");
        openapiFields.add("not");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to IdmRoleSingleQuery
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!IdmRoleSingleQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in IdmRoleSingleQuery is not found in the empty JSON string", IdmRoleSingleQuery.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!IdmRoleSingleQuery.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmRoleSingleQuery` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
        }
        // ensure the optional json data is an array if present
        if (jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull() && !jsonObj.get("Uuid").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be an array in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!IdmRoleSingleQuery.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'IdmRoleSingleQuery' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<IdmRoleSingleQuery> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(IdmRoleSingleQuery.class));

            return (TypeAdapter<T>) new TypeAdapter<IdmRoleSingleQuery>() {
                @Override
                public void write(JsonWriter out, IdmRoleSingleQuery value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public IdmRoleSingleQuery read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of IdmRoleSingleQuery given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of IdmRoleSingleQuery
     * @throws IOException if the JSON string is invalid with respect to IdmRoleSingleQuery
     */
    public static IdmRoleSingleQuery fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, IdmRoleSingleQuery.class);
    }

    /**
     * Convert an instance of IdmRoleSingleQuery to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

