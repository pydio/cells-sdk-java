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

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.IdmRole;
import com.pydio.cells.openapi.model.ServiceResourcePolicy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pydio.cells.openapi.JSON;

/**
 * UserServicePutRolesBody
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class UserServicePutRolesBody {
    public static final String SERIALIZED_NAME_ATTRIBUTES = "Attributes";
    @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
    @javax.annotation.Nullable
    private Map<String, String> attributes = new HashMap<>();

    public static final String SERIALIZED_NAME_GROUP_LABEL = "GroupLabel";
    @SerializedName(SERIALIZED_NAME_GROUP_LABEL)
    @javax.annotation.Nullable
    private String groupLabel;

    public static final String SERIALIZED_NAME_GROUP_PATH = "GroupPath";
    @SerializedName(SERIALIZED_NAME_GROUP_PATH)
    @javax.annotation.Nullable
    private String groupPath;

    public static final String SERIALIZED_NAME_IS_GROUP = "IsGroup";
    @SerializedName(SERIALIZED_NAME_IS_GROUP)
    @javax.annotation.Nullable
    private Boolean isGroup;

    public static final String SERIALIZED_NAME_LAST_CONNECTED = "LastConnected";
    @SerializedName(SERIALIZED_NAME_LAST_CONNECTED)
    @javax.annotation.Nullable
    private Integer lastConnected;

    public static final String SERIALIZED_NAME_OLD_PASSWORD = "OldPassword";
    @SerializedName(SERIALIZED_NAME_OLD_PASSWORD)
    @javax.annotation.Nullable
    private String oldPassword;

    public static final String SERIALIZED_NAME_PASSWORD = "Password";
    @SerializedName(SERIALIZED_NAME_PASSWORD)
    @javax.annotation.Nullable
    private String password;

    public static final String SERIALIZED_NAME_POLICIES = "Policies";
    @SerializedName(SERIALIZED_NAME_POLICIES)
    @javax.annotation.Nullable
    private List<ServiceResourcePolicy> policies = new ArrayList<>();

    public static final String SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE = "PoliciesContextEditable";
    @SerializedName(SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE)
    @javax.annotation.Nullable
    private Boolean policiesContextEditable;

    public static final String SERIALIZED_NAME_ROLES = "Roles";
    @SerializedName(SERIALIZED_NAME_ROLES)
    @javax.annotation.Nullable
    private List<IdmRole> roles = new ArrayList<>();

    public static final String SERIALIZED_NAME_UUID = "Uuid";
    @SerializedName(SERIALIZED_NAME_UUID)
    @javax.annotation.Nullable
    private String uuid;

    public UserServicePutRolesBody() {
    }

    public UserServicePutRolesBody attributes(@javax.annotation.Nullable Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public UserServicePutRolesBody putAttributesItem(String key, String attributesItem) {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
        }
        this.attributes.put(key, attributesItem);
        return this;
    }

    /**
     * Get attributes
     *
     * @return attributes
     */
    @javax.annotation.Nullable
    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(@javax.annotation.Nullable Map<String, String> attributes) {
        this.attributes = attributes;
    }


    public UserServicePutRolesBody groupLabel(@javax.annotation.Nullable String groupLabel) {
        this.groupLabel = groupLabel;
        return this;
    }

    /**
     * Get groupLabel
     *
     * @return groupLabel
     */
    @javax.annotation.Nullable
    public String getGroupLabel() {
        return groupLabel;
    }

    public void setGroupLabel(@javax.annotation.Nullable String groupLabel) {
        this.groupLabel = groupLabel;
    }


    public UserServicePutRolesBody groupPath(@javax.annotation.Nullable String groupPath) {
        this.groupPath = groupPath;
        return this;
    }

    /**
     * Get groupPath
     *
     * @return groupPath
     */
    @javax.annotation.Nullable
    public String getGroupPath() {
        return groupPath;
    }

    public void setGroupPath(@javax.annotation.Nullable String groupPath) {
        this.groupPath = groupPath;
    }


    public UserServicePutRolesBody isGroup(@javax.annotation.Nullable Boolean isGroup) {
        this.isGroup = isGroup;
        return this;
    }

    /**
     * Get isGroup
     *
     * @return isGroup
     */
    @javax.annotation.Nullable
    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(@javax.annotation.Nullable Boolean isGroup) {
        this.isGroup = isGroup;
    }


    public UserServicePutRolesBody lastConnected(@javax.annotation.Nullable Integer lastConnected) {
        this.lastConnected = lastConnected;
        return this;
    }

    /**
     * Get lastConnected
     *
     * @return lastConnected
     */
    @javax.annotation.Nullable
    public Integer getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(@javax.annotation.Nullable Integer lastConnected) {
        this.lastConnected = lastConnected;
    }


    public UserServicePutRolesBody oldPassword(@javax.annotation.Nullable String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    /**
     * Get oldPassword
     *
     * @return oldPassword
     */
    @javax.annotation.Nullable
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(@javax.annotation.Nullable String oldPassword) {
        this.oldPassword = oldPassword;
    }


    public UserServicePutRolesBody password(@javax.annotation.Nullable String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     */
    @javax.annotation.Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@javax.annotation.Nullable String password) {
        this.password = password;
    }


    public UserServicePutRolesBody policies(@javax.annotation.Nullable List<ServiceResourcePolicy> policies) {
        this.policies = policies;
        return this;
    }

    public UserServicePutRolesBody addPoliciesItem(ServiceResourcePolicy policiesItem) {
        if (this.policies == null) {
            this.policies = new ArrayList<>();
        }
        this.policies.add(policiesItem);
        return this;
    }

    /**
     * Get policies
     *
     * @return policies
     */
    @javax.annotation.Nullable
    public List<ServiceResourcePolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(@javax.annotation.Nullable List<ServiceResourcePolicy> policies) {
        this.policies = policies;
    }


    public UserServicePutRolesBody policiesContextEditable(@javax.annotation.Nullable Boolean policiesContextEditable) {
        this.policiesContextEditable = policiesContextEditable;
        return this;
    }

    /**
     * Context-resolved to quickly check if user is editable or not.
     *
     * @return policiesContextEditable
     */
    @javax.annotation.Nullable
    public Boolean getPoliciesContextEditable() {
        return policiesContextEditable;
    }

    public void setPoliciesContextEditable(@javax.annotation.Nullable Boolean policiesContextEditable) {
        this.policiesContextEditable = policiesContextEditable;
    }


    public UserServicePutRolesBody roles(@javax.annotation.Nullable List<IdmRole> roles) {
        this.roles = roles;
        return this;
    }

    public UserServicePutRolesBody addRolesItem(IdmRole rolesItem) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(rolesItem);
        return this;
    }

    /**
     * Get roles
     *
     * @return roles
     */
    @javax.annotation.Nullable
    public List<IdmRole> getRoles() {
        return roles;
    }

    public void setRoles(@javax.annotation.Nullable List<IdmRole> roles) {
        this.roles = roles;
    }


    public UserServicePutRolesBody uuid(@javax.annotation.Nullable String uuid) {
        this.uuid = uuid;
        return this;
    }

    /**
     * Get uuid
     *
     * @return uuid
     */
    @javax.annotation.Nullable
    public String getUuid() {
        return uuid;
    }

    public void setUuid(@javax.annotation.Nullable String uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserServicePutRolesBody userServicePutRolesBody = (UserServicePutRolesBody) o;
        return Objects.equals(this.attributes, userServicePutRolesBody.attributes) &&
                Objects.equals(this.groupLabel, userServicePutRolesBody.groupLabel) &&
                Objects.equals(this.groupPath, userServicePutRolesBody.groupPath) &&
                Objects.equals(this.isGroup, userServicePutRolesBody.isGroup) &&
                Objects.equals(this.lastConnected, userServicePutRolesBody.lastConnected) &&
                Objects.equals(this.oldPassword, userServicePutRolesBody.oldPassword) &&
                Objects.equals(this.password, userServicePutRolesBody.password) &&
                Objects.equals(this.policies, userServicePutRolesBody.policies) &&
                Objects.equals(this.policiesContextEditable, userServicePutRolesBody.policiesContextEditable) &&
                Objects.equals(this.roles, userServicePutRolesBody.roles) &&
                Objects.equals(this.uuid, userServicePutRolesBody.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributes, groupLabel, groupPath, isGroup, lastConnected, oldPassword, password, policies, policiesContextEditable, roles, uuid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserServicePutRolesBody {\n");
        sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
        sb.append("    groupLabel: ").append(toIndentedString(groupLabel)).append("\n");
        sb.append("    groupPath: ").append(toIndentedString(groupPath)).append("\n");
        sb.append("    isGroup: ").append(toIndentedString(isGroup)).append("\n");
        sb.append("    lastConnected: ").append(toIndentedString(lastConnected)).append("\n");
        sb.append("    oldPassword: ").append(toIndentedString(oldPassword)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
        sb.append("    policiesContextEditable: ").append(toIndentedString(policiesContextEditable)).append("\n");
        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
        openapiFields.add("Attributes");
        openapiFields.add("GroupLabel");
        openapiFields.add("GroupPath");
        openapiFields.add("IsGroup");
        openapiFields.add("LastConnected");
        openapiFields.add("OldPassword");
        openapiFields.add("Password");
        openapiFields.add("Policies");
        openapiFields.add("PoliciesContextEditable");
        openapiFields.add("Roles");
        openapiFields.add("Uuid");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to UserServicePutRolesBody
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!UserServicePutRolesBody.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in UserServicePutRolesBody is not found in the empty JSON string", UserServicePutRolesBody.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!UserServicePutRolesBody.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserServicePutRolesBody` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if ((jsonObj.get("GroupLabel") != null && !jsonObj.get("GroupLabel").isJsonNull()) && !jsonObj.get("GroupLabel").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `GroupLabel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("GroupLabel").toString()));
        }
        if ((jsonObj.get("GroupPath") != null && !jsonObj.get("GroupPath").isJsonNull()) && !jsonObj.get("GroupPath").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `GroupPath` to be a primitive type in the JSON string but got `%s`", jsonObj.get("GroupPath").toString()));
        }
        if ((jsonObj.get("OldPassword") != null && !jsonObj.get("OldPassword").isJsonNull()) && !jsonObj.get("OldPassword").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `OldPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OldPassword").toString()));
        }
        if ((jsonObj.get("Password") != null && !jsonObj.get("Password").isJsonNull()) && !jsonObj.get("Password").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Password` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Password").toString()));
        }
        if (jsonObj.get("Policies") != null && !jsonObj.get("Policies").isJsonNull()) {
            JsonArray jsonArraypolicies = jsonObj.getAsJsonArray("Policies");
            if (jsonArraypolicies != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Policies").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Policies` to be an array in the JSON string but got `%s`", jsonObj.get("Policies").toString()));
                }

                // validate the optional field `Policies` (array)
                for (int i = 0; i < jsonArraypolicies.size(); i++) {
                    ServiceResourcePolicy.validateJsonElement(jsonArraypolicies.get(i));
                }
                ;
            }
        }
        if (jsonObj.get("Roles") != null && !jsonObj.get("Roles").isJsonNull()) {
            JsonArray jsonArrayroles = jsonObj.getAsJsonArray("Roles");
            if (jsonArrayroles != null) {
                // ensure the json data is an array
                if (!jsonObj.get("Roles").isJsonArray()) {
                    throw new IllegalArgumentException(String.format("Expected the field `Roles` to be an array in the JSON string but got `%s`", jsonObj.get("Roles").toString()));
                }

                // validate the optional field `Roles` (array)
                for (int i = 0; i < jsonArrayroles.size(); i++) {
                    IdmRole.validateJsonElement(jsonArrayroles.get(i));
                }
                ;
            }
        }
        if ((jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull()) && !jsonObj.get("Uuid").isJsonPrimitive()) {
            throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!UserServicePutRolesBody.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'UserServicePutRolesBody' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<UserServicePutRolesBody> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(UserServicePutRolesBody.class));

            return (TypeAdapter<T>) new TypeAdapter<UserServicePutRolesBody>() {
                @Override
                public void write(JsonWriter out, UserServicePutRolesBody value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public UserServicePutRolesBody read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of UserServicePutRolesBody given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of UserServicePutRolesBody
     * @throws IOException if the JSON string is invalid with respect to UserServicePutRolesBody
     */
    public static UserServicePutRolesBody fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, UserServicePutRolesBody.class);
    }

    /**
     * Convert an instance of UserServicePutRolesBody to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

