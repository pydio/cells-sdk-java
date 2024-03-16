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
 * EncryptionImport
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class EncryptionImport {
  public static final String SERIALIZED_NAME_BY = "By";
  @SerializedName(SERIALIZED_NAME_BY)
  private String by;

  public static final String SERIALIZED_NAME_DATE = "Date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private Integer date;

  public EncryptionImport() {
  }

  public EncryptionImport by(String by) {
    this.by = by;
    return this;
  }

   /**
   * Get by
   * @return by
  **/
  @javax.annotation.Nullable
  public String getBy() {
    return by;
  }

  public void setBy(String by) {
    this.by = by;
  }


  public EncryptionImport date(Integer date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @javax.annotation.Nullable
  public Integer getDate() {
    return date;
  }

  public void setDate(Integer date) {
    this.date = date;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionImport encryptionImport = (EncryptionImport) o;
    return Objects.equals(this.by, encryptionImport.by) &&
        Objects.equals(this.date, encryptionImport.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(by, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionImport {\n");
    sb.append("    by: ").append(toIndentedString(by)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
    openapiFields.add("By");
    openapiFields.add("Date");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to EncryptionImport
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!EncryptionImport.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in EncryptionImport is not found in the empty JSON string", EncryptionImport.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!EncryptionImport.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `EncryptionImport` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("By") != null && !jsonObj.get("By").isJsonNull()) && !jsonObj.get("By").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `By` to be a primitive type in the JSON string but got `%s`", jsonObj.get("By").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!EncryptionImport.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'EncryptionImport' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<EncryptionImport> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(EncryptionImport.class));

       return (TypeAdapter<T>) new TypeAdapter<EncryptionImport>() {
           @Override
           public void write(JsonWriter out, EncryptionImport value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public EncryptionImport read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of EncryptionImport given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of EncryptionImport
  * @throws IOException if the JSON string is invalid with respect to EncryptionImport
  */
  public static EncryptionImport fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, EncryptionImport.class);
  }

 /**
  * Convert an instance of EncryptionImport to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

