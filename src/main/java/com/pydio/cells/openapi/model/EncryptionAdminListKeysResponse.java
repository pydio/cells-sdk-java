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

/**
 * EncryptionAdminListKeysResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class EncryptionAdminListKeysResponse {
  public static final String SERIALIZED_NAME_KEYS = "Keys";
  @SerializedName(SERIALIZED_NAME_KEYS)
  private List<EncryptionKey> keys;

  public EncryptionAdminListKeysResponse() {
  }

  public EncryptionAdminListKeysResponse keys(List<EncryptionKey> keys) {
    
    this.keys = keys;
    return this;
  }

  public EncryptionAdminListKeysResponse addKeysItem(EncryptionKey keysItem) {
    if (this.keys == null) {
      this.keys = new ArrayList<>();
    }
    this.keys.add(keysItem);
    return this;
  }

   /**
   * Get keys
   * @return keys
  **/
  @javax.annotation.Nullable

  public List<EncryptionKey> getKeys() {
    return keys;
  }


  public void setKeys(List<EncryptionKey> keys) {
    this.keys = keys;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionAdminListKeysResponse encryptionAdminListKeysResponse = (EncryptionAdminListKeysResponse) o;
    return Objects.equals(this.keys, encryptionAdminListKeysResponse.keys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keys);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionAdminListKeysResponse {\n");
    sb.append("    keys: ").append(toIndentedString(keys)).append("\n");
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
    openapiFields.add("Keys");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to EncryptionAdminListKeysResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!EncryptionAdminListKeysResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EncryptionAdminListKeysResponse is not found in the empty JSON string", EncryptionAdminListKeysResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!EncryptionAdminListKeysResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EncryptionAdminListKeysResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Keys") != null && !jsonObj.get("Keys").isJsonNull()) {
        JsonArray jsonArraykeys = jsonObj.getAsJsonArray("Keys");
        if (jsonArraykeys != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Keys").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Keys` to be an array in the JSON string but got `%s`", jsonObj.get("Keys").toString()));
          }

          // validate the optional field `Keys` (array)
          for (int i = 0; i < jsonArraykeys.size(); i++) {
            EncryptionKey.validateJsonObject(jsonArraykeys.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EncryptionAdminListKeysResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EncryptionAdminListKeysResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EncryptionAdminListKeysResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EncryptionAdminListKeysResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<EncryptionAdminListKeysResponse>() {
           @Override
           public void write(JsonWriter out, EncryptionAdminListKeysResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EncryptionAdminListKeysResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EncryptionAdminListKeysResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EncryptionAdminListKeysResponse
  * @throws IOException if the JSON string is invalid with respect to EncryptionAdminListKeysResponse
  */
  public static EncryptionAdminListKeysResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EncryptionAdminListKeysResponse.class);
  }

 /**
  * Convert an instance of EncryptionAdminListKeysResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

