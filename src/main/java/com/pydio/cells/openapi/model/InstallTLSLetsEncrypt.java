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
 * InstallTLSLetsEncrypt
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class InstallTLSLetsEncrypt {
  public static final String SERIALIZED_NAME_ACCEPT_E_U_L_A = "AcceptEULA";
  @SerializedName(SERIALIZED_NAME_ACCEPT_E_U_L_A)
  private Boolean acceptEULA;

  public static final String SERIALIZED_NAME_EMAIL = "Email";
  @SerializedName(SERIALIZED_NAME_EMAIL)
  private String email;

  public static final String SERIALIZED_NAME_STAGING_C_A = "StagingCA";
  @SerializedName(SERIALIZED_NAME_STAGING_C_A)
  private Boolean stagingCA;

  public InstallTLSLetsEncrypt() {
  }

  public InstallTLSLetsEncrypt acceptEULA(Boolean acceptEULA) {
    
    this.acceptEULA = acceptEULA;
    return this;
  }

   /**
   * Get acceptEULA
   * @return acceptEULA
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getAcceptEULA() {
    return acceptEULA;
  }


  public void setAcceptEULA(Boolean acceptEULA) {
    this.acceptEULA = acceptEULA;
  }


  public InstallTLSLetsEncrypt email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public InstallTLSLetsEncrypt stagingCA(Boolean stagingCA) {
    
    this.stagingCA = stagingCA;
    return this;
  }

   /**
   * Get stagingCA
   * @return stagingCA
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getStagingCA() {
    return stagingCA;
  }


  public void setStagingCA(Boolean stagingCA) {
    this.stagingCA = stagingCA;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallTLSLetsEncrypt installTLSLetsEncrypt = (InstallTLSLetsEncrypt) o;
    return Objects.equals(this.acceptEULA, installTLSLetsEncrypt.acceptEULA) &&
        Objects.equals(this.email, installTLSLetsEncrypt.email) &&
        Objects.equals(this.stagingCA, installTLSLetsEncrypt.stagingCA);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptEULA, email, stagingCA);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallTLSLetsEncrypt {\n");
    sb.append("    acceptEULA: ").append(toIndentedString(acceptEULA)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    stagingCA: ").append(toIndentedString(stagingCA)).append("\n");
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
    openapiFields.add("AcceptEULA");
    openapiFields.add("Email");
    openapiFields.add("StagingCA");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to InstallTLSLetsEncrypt
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!InstallTLSLetsEncrypt.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in InstallTLSLetsEncrypt is not found in the empty JSON string", InstallTLSLetsEncrypt.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!InstallTLSLetsEncrypt.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InstallTLSLetsEncrypt` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Email") != null && !jsonObj.get("Email").isJsonNull()) && !jsonObj.get("Email").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Email` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Email").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!InstallTLSLetsEncrypt.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'InstallTLSLetsEncrypt' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<InstallTLSLetsEncrypt> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(InstallTLSLetsEncrypt.class));

       return (TypeAdapter<T>) new TypeAdapter<InstallTLSLetsEncrypt>() {
           @Override
           public void write(JsonWriter out, InstallTLSLetsEncrypt value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public InstallTLSLetsEncrypt read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of InstallTLSLetsEncrypt given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of InstallTLSLetsEncrypt
  * @throws IOException if the JSON string is invalid with respect to InstallTLSLetsEncrypt
  */
  public static InstallTLSLetsEncrypt fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, InstallTLSLetsEncrypt.class);
  }

 /**
  * Convert an instance of InstallTLSLetsEncrypt to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

