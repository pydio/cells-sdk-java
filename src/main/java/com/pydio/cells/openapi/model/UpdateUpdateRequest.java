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
import java.util.Objects;
import java.util.Set;

/**
 * UpdateUpdateRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class UpdateUpdateRequest {
  public static final String SERIALIZED_NAME_CHANNEL = "Channel";
  @SerializedName(SERIALIZED_NAME_CHANNEL)
  private String channel;

  public static final String SERIALIZED_NAME_CURRENT_VERSION = "CurrentVersion";
  @SerializedName(SERIALIZED_NAME_CURRENT_VERSION)
  private String currentVersion;

  public static final String SERIALIZED_NAME_G_O_A_R_C_H = "GOARCH";
  @SerializedName(SERIALIZED_NAME_G_O_A_R_C_H)
  private String GOARCH;

  public static final String SERIALIZED_NAME_G_O_O_S = "GOOS";
  @SerializedName(SERIALIZED_NAME_G_O_O_S)
  private String GOOS;

  public static final String SERIALIZED_NAME_LICENSE_INFO = "LicenseInfo";
  @SerializedName(SERIALIZED_NAME_LICENSE_INFO)
  private Map<String, String> licenseInfo = new HashMap<>();

  public static final String SERIALIZED_NAME_PACKAGE_NAME = "PackageName";
  @SerializedName(SERIALIZED_NAME_PACKAGE_NAME)
  private String packageName;

  public static final String SERIALIZED_NAME_SERVICE_NAME = "ServiceName";
  @SerializedName(SERIALIZED_NAME_SERVICE_NAME)
  private String serviceName;

  public UpdateUpdateRequest() {
  }

  public UpdateUpdateRequest channel(String channel) {
    this.channel = channel;
    return this;
  }

   /**
   * Get channel
   * @return channel
  **/
  @javax.annotation.Nullable
  public String getChannel() {
    return channel;
  }

  public void setChannel(String channel) {
    this.channel = channel;
  }


  public UpdateUpdateRequest currentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
    return this;
  }

   /**
   * Get currentVersion
   * @return currentVersion
  **/
  @javax.annotation.Nullable
  public String getCurrentVersion() {
    return currentVersion;
  }

  public void setCurrentVersion(String currentVersion) {
    this.currentVersion = currentVersion;
  }


  public UpdateUpdateRequest GOARCH(String GOARCH) {
    this.GOARCH = GOARCH;
    return this;
  }

   /**
   * Get GOARCH
   * @return GOARCH
  **/
  @javax.annotation.Nullable
  public String getGOARCH() {
    return GOARCH;
  }

  public void setGOARCH(String GOARCH) {
    this.GOARCH = GOARCH;
  }


  public UpdateUpdateRequest GOOS(String GOOS) {
    this.GOOS = GOOS;
    return this;
  }

   /**
   * Get GOOS
   * @return GOOS
  **/
  @javax.annotation.Nullable
  public String getGOOS() {
    return GOOS;
  }

  public void setGOOS(String GOOS) {
    this.GOOS = GOOS;
  }


  public UpdateUpdateRequest licenseInfo(Map<String, String> licenseInfo) {
    this.licenseInfo = licenseInfo;
    return this;
  }

  public UpdateUpdateRequest putLicenseInfoItem(String key, String licenseInfoItem) {
    if (this.licenseInfo == null) {
      this.licenseInfo = new HashMap<>();
    }
    this.licenseInfo.put(key, licenseInfoItem);
    return this;
  }

   /**
   * Get licenseInfo
   * @return licenseInfo
  **/
  @javax.annotation.Nullable
  public Map<String, String> getLicenseInfo() {
    return licenseInfo;
  }

  public void setLicenseInfo(Map<String, String> licenseInfo) {
    this.licenseInfo = licenseInfo;
  }


  public UpdateUpdateRequest packageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

   /**
   * Get packageName
   * @return packageName
  **/
  @javax.annotation.Nullable
  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }


  public UpdateUpdateRequest serviceName(String serviceName) {
    this.serviceName = serviceName;
    return this;
  }

   /**
   * Get serviceName
   * @return serviceName
  **/
  @javax.annotation.Nullable
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUpdateRequest updateUpdateRequest = (UpdateUpdateRequest) o;
    return Objects.equals(this.channel, updateUpdateRequest.channel) &&
        Objects.equals(this.currentVersion, updateUpdateRequest.currentVersion) &&
        Objects.equals(this.GOARCH, updateUpdateRequest.GOARCH) &&
        Objects.equals(this.GOOS, updateUpdateRequest.GOOS) &&
        Objects.equals(this.licenseInfo, updateUpdateRequest.licenseInfo) &&
        Objects.equals(this.packageName, updateUpdateRequest.packageName) &&
        Objects.equals(this.serviceName, updateUpdateRequest.serviceName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(channel, currentVersion, GOARCH, GOOS, licenseInfo, packageName, serviceName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUpdateRequest {\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    currentVersion: ").append(toIndentedString(currentVersion)).append("\n");
    sb.append("    GOARCH: ").append(toIndentedString(GOARCH)).append("\n");
    sb.append("    GOOS: ").append(toIndentedString(GOOS)).append("\n");
    sb.append("    licenseInfo: ").append(toIndentedString(licenseInfo)).append("\n");
    sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
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
    openapiFields.add("Channel");
    openapiFields.add("CurrentVersion");
    openapiFields.add("GOARCH");
    openapiFields.add("GOOS");
    openapiFields.add("LicenseInfo");
    openapiFields.add("PackageName");
    openapiFields.add("ServiceName");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UpdateUpdateRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UpdateUpdateRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdateUpdateRequest is not found in the empty JSON string", UpdateUpdateRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UpdateUpdateRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdateUpdateRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("Channel") != null && !jsonObj.get("Channel").isJsonNull()) && !jsonObj.get("Channel").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Channel` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Channel").toString()));
      }
      if ((jsonObj.get("CurrentVersion") != null && !jsonObj.get("CurrentVersion").isJsonNull()) && !jsonObj.get("CurrentVersion").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `CurrentVersion` to be a primitive type in the JSON string but got `%s`", jsonObj.get("CurrentVersion").toString()));
      }
      if ((jsonObj.get("GOARCH") != null && !jsonObj.get("GOARCH").isJsonNull()) && !jsonObj.get("GOARCH").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `GOARCH` to be a primitive type in the JSON string but got `%s`", jsonObj.get("GOARCH").toString()));
      }
      if ((jsonObj.get("GOOS") != null && !jsonObj.get("GOOS").isJsonNull()) && !jsonObj.get("GOOS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `GOOS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("GOOS").toString()));
      }
      if ((jsonObj.get("PackageName") != null && !jsonObj.get("PackageName").isJsonNull()) && !jsonObj.get("PackageName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PackageName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PackageName").toString()));
      }
      if ((jsonObj.get("ServiceName") != null && !jsonObj.get("ServiceName").isJsonNull()) && !jsonObj.get("ServiceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ServiceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ServiceName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdateUpdateRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdateUpdateRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdateUpdateRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdateUpdateRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdateUpdateRequest>() {
           @Override
           public void write(JsonWriter out, UpdateUpdateRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdateUpdateRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdateUpdateRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdateUpdateRequest
  * @throws IOException if the JSON string is invalid with respect to UpdateUpdateRequest
  */
  public static UpdateUpdateRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdateUpdateRequest.class);
  }

 /**
  * Convert an instance of UpdateUpdateRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

