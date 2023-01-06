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
 * InstallTLSCertificate
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class InstallTLSCertificate {
  public static final String SERIALIZED_NAME_CELLS_ROOT_C_A = "CellsRootCA";
  @SerializedName(SERIALIZED_NAME_CELLS_ROOT_C_A)
  private String cellsRootCA;

  public static final String SERIALIZED_NAME_CERT_FILE = "CertFile";
  @SerializedName(SERIALIZED_NAME_CERT_FILE)
  private String certFile;

  public static final String SERIALIZED_NAME_KEY_FILE = "KeyFile";
  @SerializedName(SERIALIZED_NAME_KEY_FILE)
  private String keyFile;

  public InstallTLSCertificate() {
  }

  public InstallTLSCertificate cellsRootCA(String cellsRootCA) {
    
    this.cellsRootCA = cellsRootCA;
    return this;
  }

   /**
   * Get cellsRootCA
   * @return cellsRootCA
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCellsRootCA() {
    return cellsRootCA;
  }


  public void setCellsRootCA(String cellsRootCA) {
    this.cellsRootCA = cellsRootCA;
  }


  public InstallTLSCertificate certFile(String certFile) {
    
    this.certFile = certFile;
    return this;
  }

   /**
   * Get certFile
   * @return certFile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getCertFile() {
    return certFile;
  }


  public void setCertFile(String certFile) {
    this.certFile = certFile;
  }


  public InstallTLSCertificate keyFile(String keyFile) {
    
    this.keyFile = keyFile;
    return this;
  }

   /**
   * Get keyFile
   * @return keyFile
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getKeyFile() {
    return keyFile;
  }


  public void setKeyFile(String keyFile) {
    this.keyFile = keyFile;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallTLSCertificate installTLSCertificate = (InstallTLSCertificate) o;
    return Objects.equals(this.cellsRootCA, installTLSCertificate.cellsRootCA) &&
        Objects.equals(this.certFile, installTLSCertificate.certFile) &&
        Objects.equals(this.keyFile, installTLSCertificate.keyFile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cellsRootCA, certFile, keyFile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallTLSCertificate {\n");
    sb.append("    cellsRootCA: ").append(toIndentedString(cellsRootCA)).append("\n");
    sb.append("    certFile: ").append(toIndentedString(certFile)).append("\n");
    sb.append("    keyFile: ").append(toIndentedString(keyFile)).append("\n");
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
    openapiFields.add("CellsRootCA");
    openapiFields.add("CertFile");
    openapiFields.add("KeyFile");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to InstallTLSCertificate
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!InstallTLSCertificate.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in InstallTLSCertificate is not found in the empty JSON string", InstallTLSCertificate.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!InstallTLSCertificate.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InstallTLSCertificate` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("CellsRootCA") != null && !jsonObj.get("CellsRootCA").isJsonNull()) && !jsonObj.get("CellsRootCA").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CellsRootCA` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CellsRootCA").toString()));
      }
      if ((jsonObj.get("CertFile") != null && !jsonObj.get("CertFile").isJsonNull()) && !jsonObj.get("CertFile").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CertFile` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CertFile").toString()));
      }
      if ((jsonObj.get("KeyFile") != null && !jsonObj.get("KeyFile").isJsonNull()) && !jsonObj.get("KeyFile").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `KeyFile` to be a primitive type in the JSON string but got `%s`", jsonObj.get("KeyFile").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!InstallTLSCertificate.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'InstallTLSCertificate' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<InstallTLSCertificate> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(InstallTLSCertificate.class));

       return (TypeAdapter<T>) new TypeAdapter<InstallTLSCertificate>() {
           @Override
           public void write(JsonWriter out, InstallTLSCertificate value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public InstallTLSCertificate read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of InstallTLSCertificate given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of InstallTLSCertificate
  * @throws IOException if the JSON string is invalid with respect to InstallTLSCertificate
  */
  public static InstallTLSCertificate fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, InstallTLSCertificate.class);
  }

 /**
  * Convert an instance of InstallTLSCertificate to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

