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
 * EncryptionAdminCreateKeyRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class EncryptionAdminCreateKeyRequest {
  public static final String SERIALIZED_NAME_KEY_I_D = "KeyID";
  @SerializedName(SERIALIZED_NAME_KEY_I_D)
  private String keyID;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public EncryptionAdminCreateKeyRequest() {
  }

  public EncryptionAdminCreateKeyRequest keyID(String keyID) {
    this.keyID = keyID;
    return this;
  }

   /**
   * Get keyID
   * @return keyID
  **/
  @javax.annotation.Nullable
  public String getKeyID() {
    return keyID;
  }

  public void setKeyID(String keyID) {
    this.keyID = keyID;
  }


  public EncryptionAdminCreateKeyRequest label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionAdminCreateKeyRequest encryptionAdminCreateKeyRequest = (EncryptionAdminCreateKeyRequest) o;
    return Objects.equals(this.keyID, encryptionAdminCreateKeyRequest.keyID) &&
        Objects.equals(this.label, encryptionAdminCreateKeyRequest.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyID, label);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionAdminCreateKeyRequest {\n");
    sb.append("    keyID: ").append(toIndentedString(keyID)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
    openapiFields.add("Label");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to EncryptionAdminCreateKeyRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EncryptionAdminCreateKeyRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EncryptionAdminCreateKeyRequest is not found in the empty JSON string", EncryptionAdminCreateKeyRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EncryptionAdminCreateKeyRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EncryptionAdminCreateKeyRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("KeyID") != null && !jsonObj.get("KeyID").isJsonNull()) && !jsonObj.get("KeyID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `KeyID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("KeyID").toString()));
      }
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EncryptionAdminCreateKeyRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EncryptionAdminCreateKeyRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EncryptionAdminCreateKeyRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EncryptionAdminCreateKeyRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<EncryptionAdminCreateKeyRequest>() {
           @Override
           public void write(JsonWriter out, EncryptionAdminCreateKeyRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EncryptionAdminCreateKeyRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EncryptionAdminCreateKeyRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EncryptionAdminCreateKeyRequest
  * @throws IOException if the JSON string is invalid with respect to EncryptionAdminCreateKeyRequest
  */
  public static EncryptionAdminCreateKeyRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EncryptionAdminCreateKeyRequest.class);
  }

 /**
  * Convert an instance of EncryptionAdminCreateKeyRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

