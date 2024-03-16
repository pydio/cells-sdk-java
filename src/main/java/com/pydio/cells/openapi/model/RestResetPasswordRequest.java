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
 * RestResetPasswordRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class RestResetPasswordRequest {
  public static final String SERIALIZED_NAME_NEW_PASSWORD = "NewPassword";
  @SerializedName(SERIALIZED_NAME_NEW_PASSWORD)
  private String newPassword;

  public static final String SERIALIZED_NAME_RESET_PASSWORD_TOKEN = "ResetPasswordToken";
  @SerializedName(SERIALIZED_NAME_RESET_PASSWORD_TOKEN)
  private String resetPasswordToken;

  public static final String SERIALIZED_NAME_USER_LOGIN = "UserLogin";
  @SerializedName(SERIALIZED_NAME_USER_LOGIN)
  private String userLogin;

  public RestResetPasswordRequest() {
  }

  public RestResetPasswordRequest newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

   /**
   * Get newPassword
   * @return newPassword
  **/
  @javax.annotation.Nullable
  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }


  public RestResetPasswordRequest resetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
    return this;
  }

   /**
   * Get resetPasswordToken
   * @return resetPasswordToken
  **/
  @javax.annotation.Nullable
  public String getResetPasswordToken() {
    return resetPasswordToken;
  }

  public void setResetPasswordToken(String resetPasswordToken) {
    this.resetPasswordToken = resetPasswordToken;
  }


  public RestResetPasswordRequest userLogin(String userLogin) {
    this.userLogin = userLogin;
    return this;
  }

   /**
   * Get userLogin
   * @return userLogin
  **/
  @javax.annotation.Nullable
  public String getUserLogin() {
    return userLogin;
  }

  public void setUserLogin(String userLogin) {
    this.userLogin = userLogin;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestResetPasswordRequest restResetPasswordRequest = (RestResetPasswordRequest) o;
    return Objects.equals(this.newPassword, restResetPasswordRequest.newPassword) &&
        Objects.equals(this.resetPasswordToken, restResetPasswordRequest.resetPasswordToken) &&
        Objects.equals(this.userLogin, restResetPasswordRequest.userLogin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newPassword, resetPasswordToken, userLogin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestResetPasswordRequest {\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
    sb.append("    resetPasswordToken: ").append(toIndentedString(resetPasswordToken)).append("\n");
    sb.append("    userLogin: ").append(toIndentedString(userLogin)).append("\n");
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
    openapiFields.add("NewPassword");
    openapiFields.add("ResetPasswordToken");
    openapiFields.add("UserLogin");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RestResetPasswordRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RestResetPasswordRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestResetPasswordRequest is not found in the empty JSON string", RestResetPasswordRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RestResetPasswordRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestResetPasswordRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("NewPassword") != null && !jsonObj.get("NewPassword").isJsonNull()) && !jsonObj.get("NewPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `NewPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("NewPassword").toString()));
      }
      if ((jsonObj.get("ResetPasswordToken") != null && !jsonObj.get("ResetPasswordToken").isJsonNull()) && !jsonObj.get("ResetPasswordToken").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ResetPasswordToken` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ResetPasswordToken").toString()));
      }
      if ((jsonObj.get("UserLogin") != null && !jsonObj.get("UserLogin").isJsonNull()) && !jsonObj.get("UserLogin").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UserLogin` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UserLogin").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestResetPasswordRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestResetPasswordRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestResetPasswordRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestResetPasswordRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<RestResetPasswordRequest>() {
           @Override
           public void write(JsonWriter out, RestResetPasswordRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestResetPasswordRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestResetPasswordRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestResetPasswordRequest
  * @throws IOException if the JSON string is invalid with respect to RestResetPasswordRequest
  */
  public static RestResetPasswordRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestResetPasswordRequest.class);
  }

 /**
  * Convert an instance of RestResetPasswordRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

