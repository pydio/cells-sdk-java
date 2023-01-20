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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * IdmUserSingleQuery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class IdmUserSingleQuery {
  public static final String SERIALIZED_NAME_ATTRIBUTE_ANY_VALUE = "AttributeAnyValue";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTE_ANY_VALUE)
  private Boolean attributeAnyValue;

  public static final String SERIALIZED_NAME_ATTRIBUTE_NAME = "AttributeName";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTE_NAME)
  private String attributeName;

  public static final String SERIALIZED_NAME_ATTRIBUTE_VALUE = "AttributeValue";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTE_VALUE)
  private String attributeValue;

  public static final String SERIALIZED_NAME_CONNECTED_SINCE = "ConnectedSince";
  @SerializedName(SERIALIZED_NAME_CONNECTED_SINCE)
  private String connectedSince;

  public static final String SERIALIZED_NAME_FULL_PATH = "FullPath";
  @SerializedName(SERIALIZED_NAME_FULL_PATH)
  private String fullPath;

  public static final String SERIALIZED_NAME_GROUP_PATH = "GroupPath";
  @SerializedName(SERIALIZED_NAME_GROUP_PATH)
  private String groupPath;

  public static final String SERIALIZED_NAME_HAS_PROFILE = "HasProfile";
  @SerializedName(SERIALIZED_NAME_HAS_PROFILE)
  private String hasProfile;

  public static final String SERIALIZED_NAME_HAS_ROLE = "HasRole";
  @SerializedName(SERIALIZED_NAME_HAS_ROLE)
  private String hasRole;

  public static final String SERIALIZED_NAME_LOGIN = "Login";
  @SerializedName(SERIALIZED_NAME_LOGIN)
  private String login;

  public static final String SERIALIZED_NAME_NODE_TYPE = "NodeType";
  @SerializedName(SERIALIZED_NAME_NODE_TYPE)
  private IdmNodeType nodeType = IdmNodeType.UNKNOWN;

  public static final String SERIALIZED_NAME_PASSWORD = "Password";
  @SerializedName(SERIALIZED_NAME_PASSWORD)
  private String password;

  public static final String SERIALIZED_NAME_RECURSIVE = "Recursive";
  @SerializedName(SERIALIZED_NAME_RECURSIVE)
  private Boolean recursive;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public static final String SERIALIZED_NAME_NOT = "not";
  @SerializedName(SERIALIZED_NAME_NOT)
  private Boolean not;

  public IdmUserSingleQuery() {
  }

  public IdmUserSingleQuery attributeAnyValue(Boolean attributeAnyValue) {
    
    this.attributeAnyValue = attributeAnyValue;
    return this;
  }

   /**
   * Get attributeAnyValue
   * @return attributeAnyValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAttributeAnyValue() {
    return attributeAnyValue;
  }


  public void setAttributeAnyValue(Boolean attributeAnyValue) {
    this.attributeAnyValue = attributeAnyValue;
  }


  public IdmUserSingleQuery attributeName(String attributeName) {
    
    this.attributeName = attributeName;
    return this;
  }

   /**
   * Get attributeName
   * @return attributeName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAttributeName() {
    return attributeName;
  }


  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }


  public IdmUserSingleQuery attributeValue(String attributeValue) {
    
    this.attributeValue = attributeValue;
    return this;
  }

   /**
   * Get attributeValue
   * @return attributeValue
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAttributeValue() {
    return attributeValue;
  }


  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }


  public IdmUserSingleQuery connectedSince(String connectedSince) {
    
    this.connectedSince = connectedSince;
    return this;
  }

   /**
   * Get connectedSince
   * @return connectedSince
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getConnectedSince() {
    return connectedSince;
  }


  public void setConnectedSince(String connectedSince) {
    this.connectedSince = connectedSince;
  }


  public IdmUserSingleQuery fullPath(String fullPath) {
    
    this.fullPath = fullPath;
    return this;
  }

   /**
   * Get fullPath
   * @return fullPath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getFullPath() {
    return fullPath;
  }


  public void setFullPath(String fullPath) {
    this.fullPath = fullPath;
  }


  public IdmUserSingleQuery groupPath(String groupPath) {
    
    this.groupPath = groupPath;
    return this;
  }

   /**
   * Get groupPath
   * @return groupPath
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getGroupPath() {
    return groupPath;
  }


  public void setGroupPath(String groupPath) {
    this.groupPath = groupPath;
  }


  public IdmUserSingleQuery hasProfile(String hasProfile) {
    
    this.hasProfile = hasProfile;
    return this;
  }

   /**
   * Get hasProfile
   * @return hasProfile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getHasProfile() {
    return hasProfile;
  }


  public void setHasProfile(String hasProfile) {
    this.hasProfile = hasProfile;
  }


  public IdmUserSingleQuery hasRole(String hasRole) {
    
    this.hasRole = hasRole;
    return this;
  }

   /**
   * Get hasRole
   * @return hasRole
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getHasRole() {
    return hasRole;
  }


  public void setHasRole(String hasRole) {
    this.hasRole = hasRole;
  }


  public IdmUserSingleQuery login(String login) {
    
    this.login = login;
    return this;
  }

   /**
   * Get login
   * @return login
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLogin() {
    return login;
  }


  public void setLogin(String login) {
    this.login = login;
  }


  public IdmUserSingleQuery nodeType(IdmNodeType nodeType) {
    
    this.nodeType = nodeType;
    return this;
  }

   /**
   * Get nodeType
   * @return nodeType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmNodeType getNodeType() {
    return nodeType;
  }


  public void setNodeType(IdmNodeType nodeType) {
    this.nodeType = nodeType;
  }


  public IdmUserSingleQuery password(String password) {
    
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public IdmUserSingleQuery recursive(Boolean recursive) {
    
    this.recursive = recursive;
    return this;
  }

   /**
   * Get recursive
   * @return recursive
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getRecursive() {
    return recursive;
  }


  public void setRecursive(Boolean recursive) {
    this.recursive = recursive;
  }


  public IdmUserSingleQuery uuid(String uuid) {
    
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUuid() {
    return uuid;
  }


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public IdmUserSingleQuery not(Boolean not) {
    
    this.not = not;
    return this;
  }

   /**
   * Get not
   * @return not
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getNot() {
    return not;
  }


  public void setNot(Boolean not) {
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
    IdmUserSingleQuery idmUserSingleQuery = (IdmUserSingleQuery) o;
    return Objects.equals(this.attributeAnyValue, idmUserSingleQuery.attributeAnyValue) &&
        Objects.equals(this.attributeName, idmUserSingleQuery.attributeName) &&
        Objects.equals(this.attributeValue, idmUserSingleQuery.attributeValue) &&
        Objects.equals(this.connectedSince, idmUserSingleQuery.connectedSince) &&
        Objects.equals(this.fullPath, idmUserSingleQuery.fullPath) &&
        Objects.equals(this.groupPath, idmUserSingleQuery.groupPath) &&
        Objects.equals(this.hasProfile, idmUserSingleQuery.hasProfile) &&
        Objects.equals(this.hasRole, idmUserSingleQuery.hasRole) &&
        Objects.equals(this.login, idmUserSingleQuery.login) &&
        Objects.equals(this.nodeType, idmUserSingleQuery.nodeType) &&
        Objects.equals(this.password, idmUserSingleQuery.password) &&
        Objects.equals(this.recursive, idmUserSingleQuery.recursive) &&
        Objects.equals(this.uuid, idmUserSingleQuery.uuid) &&
        Objects.equals(this.not, idmUserSingleQuery.not);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributeAnyValue, attributeName, attributeValue, connectedSince, fullPath, groupPath, hasProfile, hasRole, login, nodeType, password, recursive, uuid, not);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmUserSingleQuery {\n");
    sb.append("    attributeAnyValue: ").append(toIndentedString(attributeAnyValue)).append("\n");
    sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
    sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
    sb.append("    connectedSince: ").append(toIndentedString(connectedSince)).append("\n");
    sb.append("    fullPath: ").append(toIndentedString(fullPath)).append("\n");
    sb.append("    groupPath: ").append(toIndentedString(groupPath)).append("\n");
    sb.append("    hasProfile: ").append(toIndentedString(hasProfile)).append("\n");
    sb.append("    hasRole: ").append(toIndentedString(hasRole)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    nodeType: ").append(toIndentedString(nodeType)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    recursive: ").append(toIndentedString(recursive)).append("\n");
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
    openapiFields.add("AttributeAnyValue");
    openapiFields.add("AttributeName");
    openapiFields.add("AttributeValue");
    openapiFields.add("ConnectedSince");
    openapiFields.add("FullPath");
    openapiFields.add("GroupPath");
    openapiFields.add("HasProfile");
    openapiFields.add("HasRole");
    openapiFields.add("Login");
    openapiFields.add("NodeType");
    openapiFields.add("Password");
    openapiFields.add("Recursive");
    openapiFields.add("Uuid");
    openapiFields.add("not");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to IdmUserSingleQuery
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!IdmUserSingleQuery.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdmUserSingleQuery is not found in the empty JSON string", IdmUserSingleQuery.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!IdmUserSingleQuery.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmUserSingleQuery` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("AttributeName") != null && !jsonObj.get("AttributeName").isJsonNull()) && !jsonObj.get("AttributeName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AttributeName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AttributeName").toString()));
      }
      if ((jsonObj.get("AttributeValue") != null && !jsonObj.get("AttributeValue").isJsonNull()) && !jsonObj.get("AttributeValue").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `AttributeValue` to be a primitive type in the JSON string but got `%s`", jsonObj.get("AttributeValue").toString()));
      }
      if ((jsonObj.get("ConnectedSince") != null && !jsonObj.get("ConnectedSince").isJsonNull()) && !jsonObj.get("ConnectedSince").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ConnectedSince` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ConnectedSince").toString()));
      }
      if ((jsonObj.get("FullPath") != null && !jsonObj.get("FullPath").isJsonNull()) && !jsonObj.get("FullPath").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `FullPath` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FullPath").toString()));
      }
      if ((jsonObj.get("GroupPath") != null && !jsonObj.get("GroupPath").isJsonNull()) && !jsonObj.get("GroupPath").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `GroupPath` to be a primitive type in the JSON string but got `%s`", jsonObj.get("GroupPath").toString()));
      }
      if ((jsonObj.get("HasProfile") != null && !jsonObj.get("HasProfile").isJsonNull()) && !jsonObj.get("HasProfile").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `HasProfile` to be a primitive type in the JSON string but got `%s`", jsonObj.get("HasProfile").toString()));
      }
      if ((jsonObj.get("HasRole") != null && !jsonObj.get("HasRole").isJsonNull()) && !jsonObj.get("HasRole").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `HasRole` to be a primitive type in the JSON string but got `%s`", jsonObj.get("HasRole").toString()));
      }
      if ((jsonObj.get("Login") != null && !jsonObj.get("Login").isJsonNull()) && !jsonObj.get("Login").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Login` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Login").toString()));
      }
      if ((jsonObj.get("Password") != null && !jsonObj.get("Password").isJsonNull()) && !jsonObj.get("Password").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Password` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Password").toString()));
      }
      if ((jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull()) && !jsonObj.get("Uuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdmUserSingleQuery.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdmUserSingleQuery' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdmUserSingleQuery> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdmUserSingleQuery.class));

       return (TypeAdapter<T>) new TypeAdapter<IdmUserSingleQuery>() {
           @Override
           public void write(JsonWriter out, IdmUserSingleQuery value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdmUserSingleQuery read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdmUserSingleQuery given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdmUserSingleQuery
  * @throws IOException if the JSON string is invalid with respect to IdmUserSingleQuery
  */
  public static IdmUserSingleQuery fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdmUserSingleQuery.class);
  }

 /**
  * Convert an instance of IdmUserSingleQuery to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

