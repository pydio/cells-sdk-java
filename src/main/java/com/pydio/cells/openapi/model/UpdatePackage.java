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

/**
 * UpdatePackage
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class UpdatePackage {
  public static final String SERIALIZED_NAME_BINARY_ARCH = "BinaryArch";
  @SerializedName(SERIALIZED_NAME_BINARY_ARCH)
  private String binaryArch;

  public static final String SERIALIZED_NAME_BINARY_CHECKSUM = "BinaryChecksum";
  @SerializedName(SERIALIZED_NAME_BINARY_CHECKSUM)
  private String binaryChecksum;

  public static final String SERIALIZED_NAME_BINARY_HASH_TYPE = "BinaryHashType";
  @SerializedName(SERIALIZED_NAME_BINARY_HASH_TYPE)
  private String binaryHashType;

  public static final String SERIALIZED_NAME_BINARY_O_S = "BinaryOS";
  @SerializedName(SERIALIZED_NAME_BINARY_O_S)
  private String binaryOS;

  public static final String SERIALIZED_NAME_BINARY_SIGNATURE = "BinarySignature";
  @SerializedName(SERIALIZED_NAME_BINARY_SIGNATURE)
  private String binarySignature;

  public static final String SERIALIZED_NAME_BINARY_SIZE = "BinarySize";
  @SerializedName(SERIALIZED_NAME_BINARY_SIZE)
  private String binarySize;

  public static final String SERIALIZED_NAME_BINARY_U_R_L = "BinaryURL";
  @SerializedName(SERIALIZED_NAME_BINARY_U_R_L)
  private String binaryURL;

  public static final String SERIALIZED_NAME_CHANGE_LOG = "ChangeLog";
  @SerializedName(SERIALIZED_NAME_CHANGE_LOG)
  private String changeLog;

  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_IS_PATCH = "IsPatch";
  @SerializedName(SERIALIZED_NAME_IS_PATCH)
  private Boolean isPatch;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_LICENSE = "License";
  @SerializedName(SERIALIZED_NAME_LICENSE)
  private String license;

  public static final String SERIALIZED_NAME_PACKAGE_NAME = "PackageName";
  @SerializedName(SERIALIZED_NAME_PACKAGE_NAME)
  private String packageName;

  public static final String SERIALIZED_NAME_PATCH_ALGORITHM = "PatchAlgorithm";
  @SerializedName(SERIALIZED_NAME_PATCH_ALGORITHM)
  private String patchAlgorithm;

  public static final String SERIALIZED_NAME_RELEASE_DATE = "ReleaseDate";
  @SerializedName(SERIALIZED_NAME_RELEASE_DATE)
  private Integer releaseDate;

  public static final String SERIALIZED_NAME_SERVICE_NAME = "ServiceName";
  @SerializedName(SERIALIZED_NAME_SERVICE_NAME)
  private String serviceName;

  public static final String SERIALIZED_NAME_STATUS = "Status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private PackagePackageStatus status = PackagePackageStatus.DRAFT;

  public static final String SERIALIZED_NAME_VERSION = "Version";
  @SerializedName(SERIALIZED_NAME_VERSION)
  private String version;

  public UpdatePackage() {
  }

  public UpdatePackage binaryArch(String binaryArch) {
    
    this.binaryArch = binaryArch;
    return this;
  }

   /**
   * Get binaryArch
   * @return binaryArch
  **/
  @javax.annotation.Nullable

  public String getBinaryArch() {
    return binaryArch;
  }


  public void setBinaryArch(String binaryArch) {
    this.binaryArch = binaryArch;
  }


  public UpdatePackage binaryChecksum(String binaryChecksum) {
    
    this.binaryChecksum = binaryChecksum;
    return this;
  }

   /**
   * Get binaryChecksum
   * @return binaryChecksum
  **/
  @javax.annotation.Nullable

  public String getBinaryChecksum() {
    return binaryChecksum;
  }


  public void setBinaryChecksum(String binaryChecksum) {
    this.binaryChecksum = binaryChecksum;
  }


  public UpdatePackage binaryHashType(String binaryHashType) {
    
    this.binaryHashType = binaryHashType;
    return this;
  }

   /**
   * Get binaryHashType
   * @return binaryHashType
  **/
  @javax.annotation.Nullable

  public String getBinaryHashType() {
    return binaryHashType;
  }


  public void setBinaryHashType(String binaryHashType) {
    this.binaryHashType = binaryHashType;
  }


  public UpdatePackage binaryOS(String binaryOS) {
    
    this.binaryOS = binaryOS;
    return this;
  }

   /**
   * Get binaryOS
   * @return binaryOS
  **/
  @javax.annotation.Nullable

  public String getBinaryOS() {
    return binaryOS;
  }


  public void setBinaryOS(String binaryOS) {
    this.binaryOS = binaryOS;
  }


  public UpdatePackage binarySignature(String binarySignature) {
    
    this.binarySignature = binarySignature;
    return this;
  }

   /**
   * Get binarySignature
   * @return binarySignature
  **/
  @javax.annotation.Nullable

  public String getBinarySignature() {
    return binarySignature;
  }


  public void setBinarySignature(String binarySignature) {
    this.binarySignature = binarySignature;
  }


  public UpdatePackage binarySize(String binarySize) {
    
    this.binarySize = binarySize;
    return this;
  }

   /**
   * Get binarySize
   * @return binarySize
  **/
  @javax.annotation.Nullable

  public String getBinarySize() {
    return binarySize;
  }


  public void setBinarySize(String binarySize) {
    this.binarySize = binarySize;
  }


  public UpdatePackage binaryURL(String binaryURL) {
    
    this.binaryURL = binaryURL;
    return this;
  }

   /**
   * Get binaryURL
   * @return binaryURL
  **/
  @javax.annotation.Nullable

  public String getBinaryURL() {
    return binaryURL;
  }


  public void setBinaryURL(String binaryURL) {
    this.binaryURL = binaryURL;
  }


  public UpdatePackage changeLog(String changeLog) {
    
    this.changeLog = changeLog;
    return this;
  }

   /**
   * Get changeLog
   * @return changeLog
  **/
  @javax.annotation.Nullable

  public String getChangeLog() {
    return changeLog;
  }


  public void setChangeLog(String changeLog) {
    this.changeLog = changeLog;
  }


  public UpdatePackage description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public UpdatePackage isPatch(Boolean isPatch) {
    
    this.isPatch = isPatch;
    return this;
  }

   /**
   * Get isPatch
   * @return isPatch
  **/
  @javax.annotation.Nullable

  public Boolean getIsPatch() {
    return isPatch;
  }


  public void setIsPatch(Boolean isPatch) {
    this.isPatch = isPatch;
  }


  public UpdatePackage label(String label) {
    
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


  public UpdatePackage license(String license) {
    
    this.license = license;
    return this;
  }

   /**
   * Get license
   * @return license
  **/
  @javax.annotation.Nullable

  public String getLicense() {
    return license;
  }


  public void setLicense(String license) {
    this.license = license;
  }


  public UpdatePackage packageName(String packageName) {
    
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


  public UpdatePackage patchAlgorithm(String patchAlgorithm) {
    
    this.patchAlgorithm = patchAlgorithm;
    return this;
  }

   /**
   * Get patchAlgorithm
   * @return patchAlgorithm
  **/
  @javax.annotation.Nullable

  public String getPatchAlgorithm() {
    return patchAlgorithm;
  }


  public void setPatchAlgorithm(String patchAlgorithm) {
    this.patchAlgorithm = patchAlgorithm;
  }


  public UpdatePackage releaseDate(Integer releaseDate) {
    
    this.releaseDate = releaseDate;
    return this;
  }

   /**
   * Get releaseDate
   * @return releaseDate
  **/
  @javax.annotation.Nullable

  public Integer getReleaseDate() {
    return releaseDate;
  }


  public void setReleaseDate(Integer releaseDate) {
    this.releaseDate = releaseDate;
  }


  public UpdatePackage serviceName(String serviceName) {
    
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


  public UpdatePackage status(PackagePackageStatus status) {
    
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nullable

  public PackagePackageStatus getStatus() {
    return status;
  }


  public void setStatus(PackagePackageStatus status) {
    this.status = status;
  }


  public UpdatePackage version(String version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable

  public String getVersion() {
    return version;
  }


  public void setVersion(String version) {
    this.version = version;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdatePackage updatePackage = (UpdatePackage) o;
    return Objects.equals(this.binaryArch, updatePackage.binaryArch) &&
        Objects.equals(this.binaryChecksum, updatePackage.binaryChecksum) &&
        Objects.equals(this.binaryHashType, updatePackage.binaryHashType) &&
        Objects.equals(this.binaryOS, updatePackage.binaryOS) &&
        Objects.equals(this.binarySignature, updatePackage.binarySignature) &&
        Objects.equals(this.binarySize, updatePackage.binarySize) &&
        Objects.equals(this.binaryURL, updatePackage.binaryURL) &&
        Objects.equals(this.changeLog, updatePackage.changeLog) &&
        Objects.equals(this.description, updatePackage.description) &&
        Objects.equals(this.isPatch, updatePackage.isPatch) &&
        Objects.equals(this.label, updatePackage.label) &&
        Objects.equals(this.license, updatePackage.license) &&
        Objects.equals(this.packageName, updatePackage.packageName) &&
        Objects.equals(this.patchAlgorithm, updatePackage.patchAlgorithm) &&
        Objects.equals(this.releaseDate, updatePackage.releaseDate) &&
        Objects.equals(this.serviceName, updatePackage.serviceName) &&
        Objects.equals(this.status, updatePackage.status) &&
        Objects.equals(this.version, updatePackage.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(binaryArch, binaryChecksum, binaryHashType, binaryOS, binarySignature, binarySize, binaryURL, changeLog, description, isPatch, label, license, packageName, patchAlgorithm, releaseDate, serviceName, status, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdatePackage {\n");
    sb.append("    binaryArch: ").append(toIndentedString(binaryArch)).append("\n");
    sb.append("    binaryChecksum: ").append(toIndentedString(binaryChecksum)).append("\n");
    sb.append("    binaryHashType: ").append(toIndentedString(binaryHashType)).append("\n");
    sb.append("    binaryOS: ").append(toIndentedString(binaryOS)).append("\n");
    sb.append("    binarySignature: ").append(toIndentedString(binarySignature)).append("\n");
    sb.append("    binarySize: ").append(toIndentedString(binarySize)).append("\n");
    sb.append("    binaryURL: ").append(toIndentedString(binaryURL)).append("\n");
    sb.append("    changeLog: ").append(toIndentedString(changeLog)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isPatch: ").append(toIndentedString(isPatch)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    license: ").append(toIndentedString(license)).append("\n");
    sb.append("    packageName: ").append(toIndentedString(packageName)).append("\n");
    sb.append("    patchAlgorithm: ").append(toIndentedString(patchAlgorithm)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
    openapiFields.add("BinaryArch");
    openapiFields.add("BinaryChecksum");
    openapiFields.add("BinaryHashType");
    openapiFields.add("BinaryOS");
    openapiFields.add("BinarySignature");
    openapiFields.add("BinarySize");
    openapiFields.add("BinaryURL");
    openapiFields.add("ChangeLog");
    openapiFields.add("Description");
    openapiFields.add("IsPatch");
    openapiFields.add("Label");
    openapiFields.add("License");
    openapiFields.add("PackageName");
    openapiFields.add("PatchAlgorithm");
    openapiFields.add("ReleaseDate");
    openapiFields.add("ServiceName");
    openapiFields.add("Status");
    openapiFields.add("Version");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to UpdatePackage
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!UpdatePackage.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UpdatePackage is not found in the empty JSON string", UpdatePackage.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!UpdatePackage.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UpdatePackage` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("BinaryArch") != null && !jsonObj.get("BinaryArch").isJsonNull()) && !jsonObj.get("BinaryArch").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinaryArch` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinaryArch").toString()));
      }
      if ((jsonObj.get("BinaryChecksum") != null && !jsonObj.get("BinaryChecksum").isJsonNull()) && !jsonObj.get("BinaryChecksum").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinaryChecksum` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinaryChecksum").toString()));
      }
      if ((jsonObj.get("BinaryHashType") != null && !jsonObj.get("BinaryHashType").isJsonNull()) && !jsonObj.get("BinaryHashType").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinaryHashType` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinaryHashType").toString()));
      }
      if ((jsonObj.get("BinaryOS") != null && !jsonObj.get("BinaryOS").isJsonNull()) && !jsonObj.get("BinaryOS").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinaryOS` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinaryOS").toString()));
      }
      if ((jsonObj.get("BinarySignature") != null && !jsonObj.get("BinarySignature").isJsonNull()) && !jsonObj.get("BinarySignature").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinarySignature` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinarySignature").toString()));
      }
      if ((jsonObj.get("BinarySize") != null && !jsonObj.get("BinarySize").isJsonNull()) && !jsonObj.get("BinarySize").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinarySize` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinarySize").toString()));
      }
      if ((jsonObj.get("BinaryURL") != null && !jsonObj.get("BinaryURL").isJsonNull()) && !jsonObj.get("BinaryURL").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BinaryURL` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BinaryURL").toString()));
      }
      if ((jsonObj.get("ChangeLog") != null && !jsonObj.get("ChangeLog").isJsonNull()) && !jsonObj.get("ChangeLog").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ChangeLog` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ChangeLog").toString()));
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
      if ((jsonObj.get("License") != null && !jsonObj.get("License").isJsonNull()) && !jsonObj.get("License").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `License` to be a primitive type in the JSON string but got `%s`", jsonObj.get("License").toString()));
      }
      if ((jsonObj.get("PackageName") != null && !jsonObj.get("PackageName").isJsonNull()) && !jsonObj.get("PackageName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PackageName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PackageName").toString()));
      }
      if ((jsonObj.get("PatchAlgorithm") != null && !jsonObj.get("PatchAlgorithm").isJsonNull()) && !jsonObj.get("PatchAlgorithm").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PatchAlgorithm` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PatchAlgorithm").toString()));
      }
      if ((jsonObj.get("ServiceName") != null && !jsonObj.get("ServiceName").isJsonNull()) && !jsonObj.get("ServiceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ServiceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ServiceName").toString()));
      }
      if ((jsonObj.get("Version") != null && !jsonObj.get("Version").isJsonNull()) && !jsonObj.get("Version").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Version` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Version").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UpdatePackage.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UpdatePackage' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UpdatePackage> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UpdatePackage.class));

       return (TypeAdapter<T>) new TypeAdapter<UpdatePackage>() {
           @Override
           public void write(JsonWriter out, UpdatePackage value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UpdatePackage read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UpdatePackage given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UpdatePackage
  * @throws IOException if the JSON string is invalid with respect to UpdatePackage
  */
  public static UpdatePackage fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UpdatePackage.class);
  }

 /**
  * Convert an instance of UpdatePackage to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

