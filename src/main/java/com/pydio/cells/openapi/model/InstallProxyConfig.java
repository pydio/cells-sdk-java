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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * InstallProxyConfig
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class InstallProxyConfig {
  public static final String SERIALIZED_NAME_BINDS = "Binds";
  @SerializedName(SERIALIZED_NAME_BINDS)
  private List<String> binds;

  public static final String SERIALIZED_NAME_CERTIFICATE = "Certificate";
  @SerializedName(SERIALIZED_NAME_CERTIFICATE)
  private InstallTLSCertificate certificate;

  public static final String SERIALIZED_NAME_LETS_ENCRYPT = "LetsEncrypt";
  @SerializedName(SERIALIZED_NAME_LETS_ENCRYPT)
  private InstallTLSLetsEncrypt letsEncrypt;

  public static final String SERIALIZED_NAME_MAINTENANCE = "Maintenance";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE)
  private Boolean maintenance;

  public static final String SERIALIZED_NAME_MAINTENANCE_CONDITIONS = "MaintenanceConditions";
  @SerializedName(SERIALIZED_NAME_MAINTENANCE_CONDITIONS)
  private List<String> maintenanceConditions;

  public static final String SERIALIZED_NAME_REVERSE_PROXY_U_R_L = "ReverseProxyURL";
  @SerializedName(SERIALIZED_NAME_REVERSE_PROXY_U_R_L)
  private String reverseProxyURL;

  public static final String SERIALIZED_NAME_SS_L_REDIRECT = "SSLRedirect";
  @SerializedName(SERIALIZED_NAME_SS_L_REDIRECT)
  private Boolean ssLRedirect;

  public static final String SERIALIZED_NAME_SELF_SIGNED = "SelfSigned";
  @SerializedName(SERIALIZED_NAME_SELF_SIGNED)
  private InstallTLSSelfSigned selfSigned;

  public InstallProxyConfig() {
  }

  public InstallProxyConfig binds(List<String> binds) {
    this.binds = binds;
    return this;
  }

  public InstallProxyConfig addBindsItem(String bindsItem) {
    if (this.binds == null) {
      this.binds = new ArrayList<>();
    }
    this.binds.add(bindsItem);
    return this;
  }

   /**
   * Get binds
   * @return binds
  **/
  @javax.annotation.Nullable
  public List<String> getBinds() {
    return binds;
  }

  public void setBinds(List<String> binds) {
    this.binds = binds;
  }


  public InstallProxyConfig certificate(InstallTLSCertificate certificate) {
    this.certificate = certificate;
    return this;
  }

   /**
   * Get certificate
   * @return certificate
  **/
  @javax.annotation.Nullable
  public InstallTLSCertificate getCertificate() {
    return certificate;
  }

  public void setCertificate(InstallTLSCertificate certificate) {
    this.certificate = certificate;
  }


  public InstallProxyConfig letsEncrypt(InstallTLSLetsEncrypt letsEncrypt) {
    this.letsEncrypt = letsEncrypt;
    return this;
  }

   /**
   * Get letsEncrypt
   * @return letsEncrypt
  **/
  @javax.annotation.Nullable
  public InstallTLSLetsEncrypt getLetsEncrypt() {
    return letsEncrypt;
  }

  public void setLetsEncrypt(InstallTLSLetsEncrypt letsEncrypt) {
    this.letsEncrypt = letsEncrypt;
  }


  public InstallProxyConfig maintenance(Boolean maintenance) {
    this.maintenance = maintenance;
    return this;
  }

   /**
   * Get maintenance
   * @return maintenance
  **/
  @javax.annotation.Nullable
  public Boolean getMaintenance() {
    return maintenance;
  }

  public void setMaintenance(Boolean maintenance) {
    this.maintenance = maintenance;
  }


  public InstallProxyConfig maintenanceConditions(List<String> maintenanceConditions) {
    this.maintenanceConditions = maintenanceConditions;
    return this;
  }

  public InstallProxyConfig addMaintenanceConditionsItem(String maintenanceConditionsItem) {
    if (this.maintenanceConditions == null) {
      this.maintenanceConditions = new ArrayList<>();
    }
    this.maintenanceConditions.add(maintenanceConditionsItem);
    return this;
  }

   /**
   * Get maintenanceConditions
   * @return maintenanceConditions
  **/
  @javax.annotation.Nullable
  public List<String> getMaintenanceConditions() {
    return maintenanceConditions;
  }

  public void setMaintenanceConditions(List<String> maintenanceConditions) {
    this.maintenanceConditions = maintenanceConditions;
  }


  public InstallProxyConfig reverseProxyURL(String reverseProxyURL) {
    this.reverseProxyURL = reverseProxyURL;
    return this;
  }

   /**
   * Get reverseProxyURL
   * @return reverseProxyURL
  **/
  @javax.annotation.Nullable
  public String getReverseProxyURL() {
    return reverseProxyURL;
  }

  public void setReverseProxyURL(String reverseProxyURL) {
    this.reverseProxyURL = reverseProxyURL;
  }


  public InstallProxyConfig ssLRedirect(Boolean ssLRedirect) {
    this.ssLRedirect = ssLRedirect;
    return this;
  }

   /**
   * Get ssLRedirect
   * @return ssLRedirect
  **/
  @javax.annotation.Nullable
  public Boolean getSsLRedirect() {
    return ssLRedirect;
  }

  public void setSsLRedirect(Boolean ssLRedirect) {
    this.ssLRedirect = ssLRedirect;
  }


  public InstallProxyConfig selfSigned(InstallTLSSelfSigned selfSigned) {
    this.selfSigned = selfSigned;
    return this;
  }

   /**
   * Get selfSigned
   * @return selfSigned
  **/
  @javax.annotation.Nullable
  public InstallTLSSelfSigned getSelfSigned() {
    return selfSigned;
  }

  public void setSelfSigned(InstallTLSSelfSigned selfSigned) {
    this.selfSigned = selfSigned;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstallProxyConfig installProxyConfig = (InstallProxyConfig) o;
    return Objects.equals(this.binds, installProxyConfig.binds) &&
        Objects.equals(this.certificate, installProxyConfig.certificate) &&
        Objects.equals(this.letsEncrypt, installProxyConfig.letsEncrypt) &&
        Objects.equals(this.maintenance, installProxyConfig.maintenance) &&
        Objects.equals(this.maintenanceConditions, installProxyConfig.maintenanceConditions) &&
        Objects.equals(this.reverseProxyURL, installProxyConfig.reverseProxyURL) &&
        Objects.equals(this.ssLRedirect, installProxyConfig.ssLRedirect) &&
        Objects.equals(this.selfSigned, installProxyConfig.selfSigned);
  }

  @Override
  public int hashCode() {
    return Objects.hash(binds, certificate, letsEncrypt, maintenance, maintenanceConditions, reverseProxyURL, ssLRedirect, selfSigned);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstallProxyConfig {\n");
    sb.append("    binds: ").append(toIndentedString(binds)).append("\n");
    sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
    sb.append("    letsEncrypt: ").append(toIndentedString(letsEncrypt)).append("\n");
    sb.append("    maintenance: ").append(toIndentedString(maintenance)).append("\n");
    sb.append("    maintenanceConditions: ").append(toIndentedString(maintenanceConditions)).append("\n");
    sb.append("    reverseProxyURL: ").append(toIndentedString(reverseProxyURL)).append("\n");
    sb.append("    ssLRedirect: ").append(toIndentedString(ssLRedirect)).append("\n");
    sb.append("    selfSigned: ").append(toIndentedString(selfSigned)).append("\n");
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
    openapiFields.add("Binds");
    openapiFields.add("Certificate");
    openapiFields.add("LetsEncrypt");
    openapiFields.add("Maintenance");
    openapiFields.add("MaintenanceConditions");
    openapiFields.add("ReverseProxyURL");
    openapiFields.add("SSLRedirect");
    openapiFields.add("SelfSigned");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to InstallProxyConfig
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!InstallProxyConfig.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in InstallProxyConfig is not found in the empty JSON string", InstallProxyConfig.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!InstallProxyConfig.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `InstallProxyConfig` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("Binds") != null && !jsonObj.get("Binds").isJsonNull() && !jsonObj.get("Binds").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `Binds` to be an array in the JSON string but got `%s`", jsonObj.get("Binds").toString()));
      }
      // validate the optional field `Certificate`
      if (jsonObj.get("Certificate") != null && !jsonObj.get("Certificate").isJsonNull()) {
        InstallTLSCertificate.validateJsonElement(jsonObj.get("Certificate"));
      }
      // validate the optional field `LetsEncrypt`
      if (jsonObj.get("LetsEncrypt") != null && !jsonObj.get("LetsEncrypt").isJsonNull()) {
        InstallTLSLetsEncrypt.validateJsonElement(jsonObj.get("LetsEncrypt"));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("MaintenanceConditions") != null && !jsonObj.get("MaintenanceConditions").isJsonNull() && !jsonObj.get("MaintenanceConditions").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `MaintenanceConditions` to be an array in the JSON string but got `%s`", jsonObj.get("MaintenanceConditions").toString()));
      }
      if ((jsonObj.get("ReverseProxyURL") != null && !jsonObj.get("ReverseProxyURL").isJsonNull()) && !jsonObj.get("ReverseProxyURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ReverseProxyURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ReverseProxyURL").toString()));
      }
      // validate the optional field `SelfSigned`
      if (jsonObj.get("SelfSigned") != null && !jsonObj.get("SelfSigned").isJsonNull()) {
        InstallTLSSelfSigned.validateJsonElement(jsonObj.get("SelfSigned"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!InstallProxyConfig.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'InstallProxyConfig' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<InstallProxyConfig> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(InstallProxyConfig.class));

       return (TypeAdapter<T>) new TypeAdapter<InstallProxyConfig>() {
           @Override
           public void write(JsonWriter out, InstallProxyConfig value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public InstallProxyConfig read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of InstallProxyConfig given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of InstallProxyConfig
  * @throws IOException if the JSON string is invalid with respect to InstallProxyConfig
  */
  public static InstallProxyConfig fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, InstallProxyConfig.class);
  }

 /**
  * Convert an instance of InstallProxyConfig to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

