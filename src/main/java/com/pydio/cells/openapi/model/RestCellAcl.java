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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestCellAcl
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestCellAcl {
  public static final String SERIALIZED_NAME_ACTIONS = "Actions";
  @SerializedName(SERIALIZED_NAME_ACTIONS)
  private List<IdmACLAction> actions = null;

  public static final String SERIALIZED_NAME_GROUP = "Group";
  @SerializedName(SERIALIZED_NAME_GROUP)
  private IdmUser group;

  public static final String SERIALIZED_NAME_IS_USER_ROLE = "IsUserRole";
  @SerializedName(SERIALIZED_NAME_IS_USER_ROLE)
  private Boolean isUserRole;

  public static final String SERIALIZED_NAME_ROLE = "Role";
  @SerializedName(SERIALIZED_NAME_ROLE)
  private IdmRole role;

  public static final String SERIALIZED_NAME_ROLE_ID = "RoleId";
  @SerializedName(SERIALIZED_NAME_ROLE_ID)
  private String roleId;

  public static final String SERIALIZED_NAME_USER = "User";
  @SerializedName(SERIALIZED_NAME_USER)
  private IdmUser user;

  public RestCellAcl() {
  }

  public RestCellAcl actions(List<IdmACLAction> actions) {
    
    this.actions = actions;
    return this;
  }

  public RestCellAcl addActionsItem(IdmACLAction actionsItem) {
    if (this.actions == null) {
      this.actions = new ArrayList<>();
    }
    this.actions.add(actionsItem);
    return this;
  }

   /**
   * Get actions
   * @return actions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmACLAction> getActions() {
    return actions;
  }


  public void setActions(List<IdmACLAction> actions) {
    this.actions = actions;
  }


  public RestCellAcl group(IdmUser group) {
    
    this.group = group;
    return this;
  }

   /**
   * Get group
   * @return group
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmUser getGroup() {
    return group;
  }


  public void setGroup(IdmUser group) {
    this.group = group;
  }


  public RestCellAcl isUserRole(Boolean isUserRole) {
    
    this.isUserRole = isUserRole;
    return this;
  }

   /**
   * Get isUserRole
   * @return isUserRole
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getIsUserRole() {
    return isUserRole;
  }


  public void setIsUserRole(Boolean isUserRole) {
    this.isUserRole = isUserRole;
  }


  public RestCellAcl role(IdmRole role) {
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmRole getRole() {
    return role;
  }


  public void setRole(IdmRole role) {
    this.role = role;
  }


  public RestCellAcl roleId(String roleId) {
    
    this.roleId = roleId;
    return this;
  }

   /**
   * Get roleId
   * @return roleId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getRoleId() {
    return roleId;
  }


  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }


  public RestCellAcl user(IdmUser user) {
    
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmUser getUser() {
    return user;
  }


  public void setUser(IdmUser user) {
    this.user = user;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestCellAcl restCellAcl = (RestCellAcl) o;
    return Objects.equals(this.actions, restCellAcl.actions) &&
        Objects.equals(this.group, restCellAcl.group) &&
        Objects.equals(this.isUserRole, restCellAcl.isUserRole) &&
        Objects.equals(this.role, restCellAcl.role) &&
        Objects.equals(this.roleId, restCellAcl.roleId) &&
        Objects.equals(this.user, restCellAcl.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(actions, group, isUserRole, role, roleId, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCellAcl {\n");
    sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    isUserRole: ").append(toIndentedString(isUserRole)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    roleId: ").append(toIndentedString(roleId)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
    openapiFields.add("Actions");
    openapiFields.add("Group");
    openapiFields.add("IsUserRole");
    openapiFields.add("Role");
    openapiFields.add("RoleId");
    openapiFields.add("User");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestCellAcl
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestCellAcl.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestCellAcl is not found in the empty JSON string", RestCellAcl.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestCellAcl.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestCellAcl` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Actions") != null && !jsonObj.get("Actions").isJsonNull()) {
        JsonArray jsonArrayactions = jsonObj.getAsJsonArray("Actions");
        if (jsonArrayactions != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Actions").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Actions` to be an array in the JSON string but got `%s`", jsonObj.get("Actions").toString()));
          }

          // validate the optional field `Actions` (array)
          for (int i = 0; i < jsonArrayactions.size(); i++) {
            IdmACLAction.validateJsonObject(jsonArrayactions.get(i).getAsJsonObject());
          };
        }
      }
      // validate the optional field `Group`
      if (jsonObj.get("Group") != null && !jsonObj.get("Group").isJsonNull()) {
        IdmUser.validateJsonObject(jsonObj.getAsJsonObject("Group"));
      }
      // validate the optional field `Role`
      if (jsonObj.get("Role") != null && !jsonObj.get("Role").isJsonNull()) {
        IdmRole.validateJsonObject(jsonObj.getAsJsonObject("Role"));
      }
      if ((jsonObj.get("RoleId") != null && !jsonObj.get("RoleId").isJsonNull()) && !jsonObj.get("RoleId").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RoleId` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RoleId").toString()));
      }
      // validate the optional field `User`
      if (jsonObj.get("User") != null && !jsonObj.get("User").isJsonNull()) {
        IdmUser.validateJsonObject(jsonObj.getAsJsonObject("User"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestCellAcl.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestCellAcl' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestCellAcl> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestCellAcl.class));

       return (TypeAdapter<T>) new TypeAdapter<RestCellAcl>() {
           @Override
           public void write(JsonWriter out, RestCellAcl value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestCellAcl read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestCellAcl given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestCellAcl
  * @throws IOException if the JSON string is invalid with respect to RestCellAcl
  */
  public static RestCellAcl fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestCellAcl.class);
  }

 /**
  * Convert an instance of RestCellAcl to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

