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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * RestSettingsEntry
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestSettingsEntry {
  public static final String SERIALIZED_NAME_A_L_I_A_S = "ALIAS";
  @SerializedName(SERIALIZED_NAME_A_L_I_A_S)
  private String ALIAS;

  public static final String SERIALIZED_NAME_ACCESSES = "Accesses";
  @SerializedName(SERIALIZED_NAME_ACCESSES)
  private Map<String, RestSettingsAccess> accesses = new HashMap<>();

  public static final String SERIALIZED_NAME_D_E_S_C_R_I_P_T_I_O_N = "DESCRIPTION";
  @SerializedName(SERIALIZED_NAME_D_E_S_C_R_I_P_T_I_O_N)
  private String DESCRIPTION;

  public static final String SERIALIZED_NAME_FEATURE = "Feature";
  @SerializedName(SERIALIZED_NAME_FEATURE)
  private String feature;

  public static final String SERIALIZED_NAME_KEY = "Key";
  @SerializedName(SERIALIZED_NAME_KEY)
  private String key;

  public static final String SERIALIZED_NAME_L_A_B_E_L = "LABEL";
  @SerializedName(SERIALIZED_NAME_L_A_B_E_L)
  private String LABEL;

  public static final String SERIALIZED_NAME_M_A_N_A_G_E_R = "MANAGER";
  @SerializedName(SERIALIZED_NAME_M_A_N_A_G_E_R)
  private String MANAGER;

  public static final String SERIALIZED_NAME_M_E_T_A_D_A_T_A = "METADATA";
  @SerializedName(SERIALIZED_NAME_M_E_T_A_D_A_T_A)
  private RestSettingsEntryMeta METADATA;

  public RestSettingsEntry() {
  }

  public RestSettingsEntry ALIAS(String ALIAS) {
    
    this.ALIAS = ALIAS;
    return this;
  }

   /**
   * Get ALIAS
   * @return ALIAS
  **/
  @javax.annotation.Nullable

  public String getALIAS() {
    return ALIAS;
  }


  public void setALIAS(String ALIAS) {
    this.ALIAS = ALIAS;
  }


  public RestSettingsEntry accesses(Map<String, RestSettingsAccess> accesses) {
    
    this.accesses = accesses;
    return this;
  }

  public RestSettingsEntry putAccessesItem(String key, RestSettingsAccess accessesItem) {
    if (this.accesses == null) {
      this.accesses = new HashMap<>();
    }
    this.accesses.put(key, accessesItem);
    return this;
  }

   /**
   * Get accesses
   * @return accesses
  **/
  @javax.annotation.Nullable

  public Map<String, RestSettingsAccess> getAccesses() {
    return accesses;
  }


  public void setAccesses(Map<String, RestSettingsAccess> accesses) {
    this.accesses = accesses;
  }


  public RestSettingsEntry DESCRIPTION(String DESCRIPTION) {
    
    this.DESCRIPTION = DESCRIPTION;
    return this;
  }

   /**
   * Get DESCRIPTION
   * @return DESCRIPTION
  **/
  @javax.annotation.Nullable

  public String getDESCRIPTION() {
    return DESCRIPTION;
  }


  public void setDESCRIPTION(String DESCRIPTION) {
    this.DESCRIPTION = DESCRIPTION;
  }


  public RestSettingsEntry feature(String feature) {
    
    this.feature = feature;
    return this;
  }

   /**
   * Get feature
   * @return feature
  **/
  @javax.annotation.Nullable

  public String getFeature() {
    return feature;
  }


  public void setFeature(String feature) {
    this.feature = feature;
  }


  public RestSettingsEntry key(String key) {
    
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nullable

  public String getKey() {
    return key;
  }


  public void setKey(String key) {
    this.key = key;
  }


  public RestSettingsEntry LABEL(String LABEL) {
    
    this.LABEL = LABEL;
    return this;
  }

   /**
   * Get LABEL
   * @return LABEL
  **/
  @javax.annotation.Nullable

  public String getLABEL() {
    return LABEL;
  }


  public void setLABEL(String LABEL) {
    this.LABEL = LABEL;
  }


  public RestSettingsEntry MANAGER(String MANAGER) {
    
    this.MANAGER = MANAGER;
    return this;
  }

   /**
   * Get MANAGER
   * @return MANAGER
  **/
  @javax.annotation.Nullable

  public String getMANAGER() {
    return MANAGER;
  }


  public void setMANAGER(String MANAGER) {
    this.MANAGER = MANAGER;
  }


  public RestSettingsEntry METADATA(RestSettingsEntryMeta METADATA) {
    
    this.METADATA = METADATA;
    return this;
  }

   /**
   * Get METADATA
   * @return METADATA
  **/
  @javax.annotation.Nullable

  public RestSettingsEntryMeta getMETADATA() {
    return METADATA;
  }


  public void setMETADATA(RestSettingsEntryMeta METADATA) {
    this.METADATA = METADATA;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestSettingsEntry restSettingsEntry = (RestSettingsEntry) o;
    return Objects.equals(this.ALIAS, restSettingsEntry.ALIAS) &&
        Objects.equals(this.accesses, restSettingsEntry.accesses) &&
        Objects.equals(this.DESCRIPTION, restSettingsEntry.DESCRIPTION) &&
        Objects.equals(this.feature, restSettingsEntry.feature) &&
        Objects.equals(this.key, restSettingsEntry.key) &&
        Objects.equals(this.LABEL, restSettingsEntry.LABEL) &&
        Objects.equals(this.MANAGER, restSettingsEntry.MANAGER) &&
        Objects.equals(this.METADATA, restSettingsEntry.METADATA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ALIAS, accesses, DESCRIPTION, feature, key, LABEL, MANAGER, METADATA);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSettingsEntry {\n");
    sb.append("    ALIAS: ").append(toIndentedString(ALIAS)).append("\n");
    sb.append("    accesses: ").append(toIndentedString(accesses)).append("\n");
    sb.append("    DESCRIPTION: ").append(toIndentedString(DESCRIPTION)).append("\n");
    sb.append("    feature: ").append(toIndentedString(feature)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    LABEL: ").append(toIndentedString(LABEL)).append("\n");
    sb.append("    MANAGER: ").append(toIndentedString(MANAGER)).append("\n");
    sb.append("    METADATA: ").append(toIndentedString(METADATA)).append("\n");
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
    openapiFields.add("ALIAS");
    openapiFields.add("Accesses");
    openapiFields.add("DESCRIPTION");
    openapiFields.add("Feature");
    openapiFields.add("Key");
    openapiFields.add("LABEL");
    openapiFields.add("MANAGER");
    openapiFields.add("METADATA");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestSettingsEntry
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestSettingsEntry.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestSettingsEntry is not found in the empty JSON string", RestSettingsEntry.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestSettingsEntry.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestSettingsEntry` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("ALIAS") != null && !jsonObj.get("ALIAS").isJsonNull()) && !jsonObj.get("ALIAS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ALIAS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ALIAS").toString()));
      }
      if ((jsonObj.get("DESCRIPTION") != null && !jsonObj.get("DESCRIPTION").isJsonNull()) && !jsonObj.get("DESCRIPTION").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `DESCRIPTION` to be a primitive type in the JSON string but got `%s`", jsonObj.get("DESCRIPTION").toString()));
      }
      if ((jsonObj.get("Feature") != null && !jsonObj.get("Feature").isJsonNull()) && !jsonObj.get("Feature").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Feature` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Feature").toString()));
      }
      if ((jsonObj.get("Key") != null && !jsonObj.get("Key").isJsonNull()) && !jsonObj.get("Key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Key").toString()));
      }
      if ((jsonObj.get("LABEL") != null && !jsonObj.get("LABEL").isJsonNull()) && !jsonObj.get("LABEL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `LABEL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("LABEL").toString()));
      }
      if ((jsonObj.get("MANAGER") != null && !jsonObj.get("MANAGER").isJsonNull()) && !jsonObj.get("MANAGER").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MANAGER` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MANAGER").toString()));
      }
      // validate the optional field `METADATA`
      if (jsonObj.get("METADATA") != null && !jsonObj.get("METADATA").isJsonNull()) {
        RestSettingsEntryMeta.validateJsonObject(jsonObj.getAsJsonObject("METADATA"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestSettingsEntry.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestSettingsEntry' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestSettingsEntry> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestSettingsEntry.class));

       return (TypeAdapter<T>) new TypeAdapter<RestSettingsEntry>() {
           @Override
           public void write(JsonWriter out, RestSettingsEntry value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestSettingsEntry read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestSettingsEntry given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestSettingsEntry
  * @throws IOException if the JSON string is invalid with respect to RestSettingsEntry
  */
  public static RestSettingsEntry fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestSettingsEntry.class);
  }

 /**
  * Convert an instance of RestSettingsEntry to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

