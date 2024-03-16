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
 * ACL are the basic flags that can be put anywhere in the tree to provide some specific rights to a given role. The context of how they apply can be fine-tuned by workspace.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class IdmACL {
  public static final String SERIALIZED_NAME_ACTION = "Action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private IdmACLAction action;

  public static final String SERIALIZED_NAME_I_D = "ID";
  @SerializedName(SERIALIZED_NAME_I_D)
  private String ID;

  public static final String SERIALIZED_NAME_NODE_I_D = "NodeID";
  @SerializedName(SERIALIZED_NAME_NODE_I_D)
  private String nodeID;

  public static final String SERIALIZED_NAME_ROLE_I_D = "RoleID";
  @SerializedName(SERIALIZED_NAME_ROLE_I_D)
  private String roleID;

  public static final String SERIALIZED_NAME_WORKSPACE_I_D = "WorkspaceID";
  @SerializedName(SERIALIZED_NAME_WORKSPACE_I_D)
  private String workspaceID;

  public IdmACL() {
  }

  public IdmACL action(IdmACLAction action) {
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nullable
  public IdmACLAction getAction() {
    return action;
  }

  public void setAction(IdmACLAction action) {
    this.action = action;
  }


  public IdmACL ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @javax.annotation.Nullable
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }


  public IdmACL nodeID(String nodeID) {
    this.nodeID = nodeID;
    return this;
  }

   /**
   * Get nodeID
   * @return nodeID
  **/
  @javax.annotation.Nullable
  public String getNodeID() {
    return nodeID;
  }

  public void setNodeID(String nodeID) {
    this.nodeID = nodeID;
  }


  public IdmACL roleID(String roleID) {
    this.roleID = roleID;
    return this;
  }

   /**
   * Get roleID
   * @return roleID
  **/
  @javax.annotation.Nullable
  public String getRoleID() {
    return roleID;
  }

  public void setRoleID(String roleID) {
    this.roleID = roleID;
  }


  public IdmACL workspaceID(String workspaceID) {
    this.workspaceID = workspaceID;
    return this;
  }

   /**
   * Get workspaceID
   * @return workspaceID
  **/
  @javax.annotation.Nullable
  public String getWorkspaceID() {
    return workspaceID;
  }

  public void setWorkspaceID(String workspaceID) {
    this.workspaceID = workspaceID;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmACL idmACL = (IdmACL) o;
    return Objects.equals(this.action, idmACL.action) &&
        Objects.equals(this.ID, idmACL.ID) &&
        Objects.equals(this.nodeID, idmACL.nodeID) &&
        Objects.equals(this.roleID, idmACL.roleID) &&
        Objects.equals(this.workspaceID, idmACL.workspaceID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, ID, nodeID, roleID, workspaceID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmACL {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    nodeID: ").append(toIndentedString(nodeID)).append("\n");
    sb.append("    roleID: ").append(toIndentedString(roleID)).append("\n");
    sb.append("    workspaceID: ").append(toIndentedString(workspaceID)).append("\n");
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
    openapiFields.add("Action");
    openapiFields.add("ID");
    openapiFields.add("NodeID");
    openapiFields.add("RoleID");
    openapiFields.add("WorkspaceID");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to IdmACL
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!IdmACL.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdmACL is not found in the empty JSON string", IdmACL.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!IdmACL.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmACL` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // validate the optional field `Action`
      if (jsonObj.get("Action") != null && !jsonObj.get("Action").isJsonNull()) {
        IdmACLAction.validateJsonElement(jsonObj.get("Action"));
      }
      if ((jsonObj.get("ID") != null && !jsonObj.get("ID").isJsonNull()) && !jsonObj.get("ID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ID").toString()));
      }
      if ((jsonObj.get("NodeID") != null && !jsonObj.get("NodeID").isJsonNull()) && !jsonObj.get("NodeID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `NodeID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("NodeID").toString()));
      }
      if ((jsonObj.get("RoleID") != null && !jsonObj.get("RoleID").isJsonNull()) && !jsonObj.get("RoleID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `RoleID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("RoleID").toString()));
      }
      if ((jsonObj.get("WorkspaceID") != null && !jsonObj.get("WorkspaceID").isJsonNull()) && !jsonObj.get("WorkspaceID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `WorkspaceID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("WorkspaceID").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdmACL.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdmACL' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdmACL> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdmACL.class));

       return (TypeAdapter<T>) new TypeAdapter<IdmACL>() {
           @Override
           public void write(JsonWriter out, IdmACL value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdmACL read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdmACL given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdmACL
  * @throws IOException if the JSON string is invalid with respect to IdmACL
  */
  public static IdmACL fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdmACL.class);
  }

 /**
  * Convert an instance of IdmACL to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

