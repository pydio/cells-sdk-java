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
 * RestRolesCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestRolesCollection {
  public static final String SERIALIZED_NAME_ROLES = "Roles";
  @SerializedName(SERIALIZED_NAME_ROLES)
  private List<IdmRole> roles = null;

  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public RestRolesCollection() {
  }

  public RestRolesCollection roles(List<IdmRole> roles) {
    
    this.roles = roles;
    return this;
  }

  public RestRolesCollection addRolesItem(IdmRole rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmRole> getRoles() {
    return roles;
  }


  public void setRoles(List<IdmRole> roles) {
    this.roles = roles;
  }


  public RestRolesCollection total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
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
    RestRolesCollection restRolesCollection = (RestRolesCollection) o;
    return Objects.equals(this.roles, restRolesCollection.roles) &&
        Objects.equals(this.total, restRolesCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roles, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRolesCollection {\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
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
    openapiFields.add("Roles");
    openapiFields.add("Total");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestRolesCollection
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestRolesCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestRolesCollection is not found in the empty JSON string", RestRolesCollection.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestRolesCollection.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestRolesCollection` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
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
            IdmRole.validateJsonObject(jsonArrayroles.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestRolesCollection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestRolesCollection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestRolesCollection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestRolesCollection.class));

       return (TypeAdapter<T>) new TypeAdapter<RestRolesCollection>() {
           @Override
           public void write(JsonWriter out, RestRolesCollection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestRolesCollection read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestRolesCollection given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestRolesCollection
  * @throws IOException if the JSON string is invalid with respect to RestRolesCollection
  */
  public static RestRolesCollection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestRolesCollection.class);
  }

 /**
  * Convert an instance of RestRolesCollection to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

