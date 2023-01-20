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
 * EncryptionAdminExportKeyRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class EncryptionAdminExportKeyRequest {
  public static final String SERIALIZED_NAME_KEY_I_D = "KeyID";
  @SerializedName(SERIALIZED_NAME_KEY_I_D)
  private String keyID;

  public static final String SERIALIZED_NAME_STR_PASSWORD = "StrPassword";
  @SerializedName(SERIALIZED_NAME_STR_PASSWORD)
  private String strPassword;

  public EncryptionAdminExportKeyRequest() {
  }

  public EncryptionAdminExportKeyRequest keyID(String keyID) {
    
    this.keyID = keyID;
    return this;
  }

   /**
   * Get keyID
   * @return keyID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getKeyID() {
    return keyID;
  }


  public void setKeyID(String keyID) {
    this.keyID = keyID;
  }


  public EncryptionAdminExportKeyRequest strPassword(String strPassword) {
    
    this.strPassword = strPassword;
    return this;
  }

   /**
   * Get strPassword
   * @return strPassword
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getStrPassword() {
    return strPassword;
  }


  public void setStrPassword(String strPassword) {
    this.strPassword = strPassword;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionAdminExportKeyRequest encryptionAdminExportKeyRequest = (EncryptionAdminExportKeyRequest) o;
    return Objects.equals(this.keyID, encryptionAdminExportKeyRequest.keyID) &&
        Objects.equals(this.strPassword, encryptionAdminExportKeyRequest.strPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyID, strPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionAdminExportKeyRequest {\n");
    sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
    sb.append("    strPassword: ").append(toIndentedString(strPassword)).append("\n");
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
    openapiFields.add("KeyID");
    openapiFields.add("StrPassword");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EncryptionAdminExportKeyRequest
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EncryptionAdminExportKeyRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EncryptionAdminExportKeyRequest is not found in the empty JSON string", EncryptionAdminExportKeyRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EncryptionAdminExportKeyRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EncryptionAdminExportKeyRequest` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("KeyID") != null && !jsonObj.get("KeyID").isJsonNull()) && !jsonObj.get("KeyID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `KeyID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("KeyID").toString()));
      }
      if ((jsonObj.get("StrPassword") != null && !jsonObj.get("StrPassword").isJsonNull()) && !jsonObj.get("StrPassword").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `StrPassword` to be a primitive type in the JSON string but got `%s`", jsonObj.get("StrPassword").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EncryptionAdminExportKeyRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EncryptionAdminExportKeyRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EncryptionAdminExportKeyRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EncryptionAdminExportKeyRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<EncryptionAdminExportKeyRequest>() {
           @Override
           public void write(JsonWriter out, EncryptionAdminExportKeyRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EncryptionAdminExportKeyRequest read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EncryptionAdminExportKeyRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EncryptionAdminExportKeyRequest
  * @throws IOException if the JSON string is invalid with respect to EncryptionAdminExportKeyRequest
  */
  public static EncryptionAdminExportKeyRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EncryptionAdminExportKeyRequest.class);
  }

 /**
  * Convert an instance of EncryptionAdminExportKeyRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

