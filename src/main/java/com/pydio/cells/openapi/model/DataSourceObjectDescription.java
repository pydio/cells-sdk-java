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
 * DataSourceObjectDescription
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class DataSourceObjectDescription {
  public static final String SERIALIZED_NAME_API_KEY = "ApiKey";
  @SerializedName(SERIALIZED_NAME_API_KEY)
  private String apiKey;

  public static final String SERIALIZED_NAME_API_SECRET = "ApiSecret";
  @SerializedName(SERIALIZED_NAME_API_SECRET)
  private String apiSecret;

  public static final String SERIALIZED_NAME_CREATION_DATE = "CreationDate";
  @SerializedName(SERIALIZED_NAME_CREATION_DATE)
  private Integer creationDate;

  public static final String SERIALIZED_NAME_DISABLED = "Disabled";
  @SerializedName(SERIALIZED_NAME_DISABLED)
  private Boolean disabled;

  public static final String SERIALIZED_NAME_ENCRYPTION_KEY = "EncryptionKey";
  @SerializedName(SERIALIZED_NAME_ENCRYPTION_KEY)
  private String encryptionKey;

  public static final String SERIALIZED_NAME_ENCRYPTION_MODE = "EncryptionMode";
  @SerializedName(SERIALIZED_NAME_ENCRYPTION_MODE)
  private ObjectEncryptionMode encryptionMode = ObjectEncryptionMode.CLEAR;

  public static final String SERIALIZED_NAME_FLAT_STORAGE = "FlatStorage";
  @SerializedName(SERIALIZED_NAME_FLAT_STORAGE)
  private Boolean flatStorage;

  public static final String SERIALIZED_NAME_LAST_SYNCHRONIZATION_DATE = "LastSynchronizationDate";
  @SerializedName(SERIALIZED_NAME_LAST_SYNCHRONIZATION_DATE)
  private Integer lastSynchronizationDate;

  public static final String SERIALIZED_NAME_OBJECTS_BASE_FOLDER = "ObjectsBaseFolder";
  @SerializedName(SERIALIZED_NAME_OBJECTS_BASE_FOLDER)
  private String objectsBaseFolder;

  public static final String SERIALIZED_NAME_OBJECTS_BUCKET = "ObjectsBucket";
  @SerializedName(SERIALIZED_NAME_OBJECTS_BUCKET)
  private String objectsBucket;

  public static final String SERIALIZED_NAME_OBJECTS_HOST = "ObjectsHost";
  @SerializedName(SERIALIZED_NAME_OBJECTS_HOST)
  private String objectsHost;

  public static final String SERIALIZED_NAME_OBJECTS_PORT = "ObjectsPort";
  @SerializedName(SERIALIZED_NAME_OBJECTS_PORT)
  private Integer objectsPort;

  public static final String SERIALIZED_NAME_OBJECTS_SECURE = "ObjectsSecure";
  @SerializedName(SERIALIZED_NAME_OBJECTS_SECURE)
  private Boolean objectsSecure;

  public static final String SERIALIZED_NAME_OBJECTS_SERVICE_NAME = "ObjectsServiceName";
  @SerializedName(SERIALIZED_NAME_OBJECTS_SERVICE_NAME)
  private String objectsServiceName;

  public static final String SERIALIZED_NAME_PEER_ADDRESS = "PeerAddress";
  @SerializedName(SERIALIZED_NAME_PEER_ADDRESS)
  private String peerAddress;

  public static final String SERIALIZED_NAME_SKIP_SYNC_ON_RESTART = "SkipSyncOnRestart";
  @SerializedName(SERIALIZED_NAME_SKIP_SYNC_ON_RESTART)
  private Boolean skipSyncOnRestart;

  public static final String SERIALIZED_NAME_STORAGE_CONFIGURATION = "StorageConfiguration";
  @SerializedName(SERIALIZED_NAME_STORAGE_CONFIGURATION)
  private Map<String, String> storageConfiguration = new HashMap<>();

  public static final String SERIALIZED_NAME_STORAGE_TYPE = "StorageType";
  @SerializedName(SERIALIZED_NAME_STORAGE_TYPE)
  private ObjectStorageType storageType = ObjectStorageType.LOCAL;

  public static final String SERIALIZED_NAME_VERSIONING_POLICY_NAME = "VersioningPolicyName";
  @SerializedName(SERIALIZED_NAME_VERSIONING_POLICY_NAME)
  private String versioningPolicyName;

  public static final String SERIALIZED_NAME_WATCH = "Watch";
  @SerializedName(SERIALIZED_NAME_WATCH)
  private Boolean watch;

  public DataSourceObjectDescription() {
  }

  public DataSourceObjectDescription apiKey(String apiKey) {
    this.apiKey = apiKey;
    return this;
  }

   /**
   * Get apiKey
   * @return apiKey
  **/
  @javax.annotation.Nullable
  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }


  public DataSourceObjectDescription apiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
    return this;
  }

   /**
   * Get apiSecret
   * @return apiSecret
  **/
  @javax.annotation.Nullable
  public String getApiSecret() {
    return apiSecret;
  }

  public void setApiSecret(String apiSecret) {
    this.apiSecret = apiSecret;
  }


  public DataSourceObjectDescription creationDate(Integer creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @javax.annotation.Nullable
  public Integer getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Integer creationDate) {
    this.creationDate = creationDate;
  }


  public DataSourceObjectDescription disabled(Boolean disabled) {
    this.disabled = disabled;
    return this;
  }

   /**
   * Get disabled
   * @return disabled
  **/
  @javax.annotation.Nullable
  public Boolean getDisabled() {
    return disabled;
  }

  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }


  public DataSourceObjectDescription encryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
    return this;
  }

   /**
   * Get encryptionKey
   * @return encryptionKey
  **/
  @javax.annotation.Nullable
  public String getEncryptionKey() {
    return encryptionKey;
  }

  public void setEncryptionKey(String encryptionKey) {
    this.encryptionKey = encryptionKey;
  }


  public DataSourceObjectDescription encryptionMode(ObjectEncryptionMode encryptionMode) {
    this.encryptionMode = encryptionMode;
    return this;
  }

   /**
   * Get encryptionMode
   * @return encryptionMode
  **/
  @javax.annotation.Nullable
  public ObjectEncryptionMode getEncryptionMode() {
    return encryptionMode;
  }

  public void setEncryptionMode(ObjectEncryptionMode encryptionMode) {
    this.encryptionMode = encryptionMode;
  }


  public DataSourceObjectDescription flatStorage(Boolean flatStorage) {
    this.flatStorage = flatStorage;
    return this;
  }

   /**
   * Get flatStorage
   * @return flatStorage
  **/
  @javax.annotation.Nullable
  public Boolean getFlatStorage() {
    return flatStorage;
  }

  public void setFlatStorage(Boolean flatStorage) {
    this.flatStorage = flatStorage;
  }


  public DataSourceObjectDescription lastSynchronizationDate(Integer lastSynchronizationDate) {
    this.lastSynchronizationDate = lastSynchronizationDate;
    return this;
  }

   /**
   * Get lastSynchronizationDate
   * @return lastSynchronizationDate
  **/
  @javax.annotation.Nullable
  public Integer getLastSynchronizationDate() {
    return lastSynchronizationDate;
  }

  public void setLastSynchronizationDate(Integer lastSynchronizationDate) {
    this.lastSynchronizationDate = lastSynchronizationDate;
  }


  public DataSourceObjectDescription objectsBaseFolder(String objectsBaseFolder) {
    this.objectsBaseFolder = objectsBaseFolder;
    return this;
  }

   /**
   * Get objectsBaseFolder
   * @return objectsBaseFolder
  **/
  @javax.annotation.Nullable
  public String getObjectsBaseFolder() {
    return objectsBaseFolder;
  }

  public void setObjectsBaseFolder(String objectsBaseFolder) {
    this.objectsBaseFolder = objectsBaseFolder;
  }


  public DataSourceObjectDescription objectsBucket(String objectsBucket) {
    this.objectsBucket = objectsBucket;
    return this;
  }

   /**
   * Get objectsBucket
   * @return objectsBucket
  **/
  @javax.annotation.Nullable
  public String getObjectsBucket() {
    return objectsBucket;
  }

  public void setObjectsBucket(String objectsBucket) {
    this.objectsBucket = objectsBucket;
  }


  public DataSourceObjectDescription objectsHost(String objectsHost) {
    this.objectsHost = objectsHost;
    return this;
  }

   /**
   * Get objectsHost
   * @return objectsHost
  **/
  @javax.annotation.Nullable
  public String getObjectsHost() {
    return objectsHost;
  }

  public void setObjectsHost(String objectsHost) {
    this.objectsHost = objectsHost;
  }


  public DataSourceObjectDescription objectsPort(Integer objectsPort) {
    this.objectsPort = objectsPort;
    return this;
  }

   /**
   * Get objectsPort
   * @return objectsPort
  **/
  @javax.annotation.Nullable
  public Integer getObjectsPort() {
    return objectsPort;
  }

  public void setObjectsPort(Integer objectsPort) {
    this.objectsPort = objectsPort;
  }


  public DataSourceObjectDescription objectsSecure(Boolean objectsSecure) {
    this.objectsSecure = objectsSecure;
    return this;
  }

   /**
   * Get objectsSecure
   * @return objectsSecure
  **/
  @javax.annotation.Nullable
  public Boolean getObjectsSecure() {
    return objectsSecure;
  }

  public void setObjectsSecure(Boolean objectsSecure) {
    this.objectsSecure = objectsSecure;
  }


  public DataSourceObjectDescription objectsServiceName(String objectsServiceName) {
    this.objectsServiceName = objectsServiceName;
    return this;
  }

   /**
   * Get objectsServiceName
   * @return objectsServiceName
  **/
  @javax.annotation.Nullable
  public String getObjectsServiceName() {
    return objectsServiceName;
  }

  public void setObjectsServiceName(String objectsServiceName) {
    this.objectsServiceName = objectsServiceName;
  }


  public DataSourceObjectDescription peerAddress(String peerAddress) {
    this.peerAddress = peerAddress;
    return this;
  }

   /**
   * Get peerAddress
   * @return peerAddress
  **/
  @javax.annotation.Nullable
  public String getPeerAddress() {
    return peerAddress;
  }

  public void setPeerAddress(String peerAddress) {
    this.peerAddress = peerAddress;
  }


  public DataSourceObjectDescription skipSyncOnRestart(Boolean skipSyncOnRestart) {
    this.skipSyncOnRestart = skipSyncOnRestart;
    return this;
  }

   /**
   * Get skipSyncOnRestart
   * @return skipSyncOnRestart
  **/
  @javax.annotation.Nullable
  public Boolean getSkipSyncOnRestart() {
    return skipSyncOnRestart;
  }

  public void setSkipSyncOnRestart(Boolean skipSyncOnRestart) {
    this.skipSyncOnRestart = skipSyncOnRestart;
  }


  public DataSourceObjectDescription storageConfiguration(Map<String, String> storageConfiguration) {
    this.storageConfiguration = storageConfiguration;
    return this;
  }

  public DataSourceObjectDescription putStorageConfigurationItem(String key, String storageConfigurationItem) {
    if (this.storageConfiguration == null) {
      this.storageConfiguration = new HashMap<>();
    }
    this.storageConfiguration.put(key, storageConfigurationItem);
    return this;
  }

   /**
   * Get storageConfiguration
   * @return storageConfiguration
  **/
  @javax.annotation.Nullable
  public Map<String, String> getStorageConfiguration() {
    return storageConfiguration;
  }

  public void setStorageConfiguration(Map<String, String> storageConfiguration) {
    this.storageConfiguration = storageConfiguration;
  }


  public DataSourceObjectDescription storageType(ObjectStorageType storageType) {
    this.storageType = storageType;
    return this;
  }

   /**
   * Get storageType
   * @return storageType
  **/
  @javax.annotation.Nullable
  public ObjectStorageType getStorageType() {
    return storageType;
  }

  public void setStorageType(ObjectStorageType storageType) {
    this.storageType = storageType;
  }


  public DataSourceObjectDescription versioningPolicyName(String versioningPolicyName) {
    this.versioningPolicyName = versioningPolicyName;
    return this;
  }

   /**
   * Get versioningPolicyName
   * @return versioningPolicyName
  **/
  @javax.annotation.Nullable
  public String getVersioningPolicyName() {
    return versioningPolicyName;
  }

  public void setVersioningPolicyName(String versioningPolicyName) {
    this.versioningPolicyName = versioningPolicyName;
  }


  public DataSourceObjectDescription watch(Boolean watch) {
    this.watch = watch;
    return this;
  }

   /**
   * Get watch
   * @return watch
  **/
  @javax.annotation.Nullable
  public Boolean getWatch() {
    return watch;
  }

  public void setWatch(Boolean watch) {
    this.watch = watch;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DataSourceObjectDescription dataSourceObjectDescription = (DataSourceObjectDescription) o;
    return Objects.equals(this.apiKey, dataSourceObjectDescription.apiKey) &&
        Objects.equals(this.apiSecret, dataSourceObjectDescription.apiSecret) &&
        Objects.equals(this.creationDate, dataSourceObjectDescription.creationDate) &&
        Objects.equals(this.disabled, dataSourceObjectDescription.disabled) &&
        Objects.equals(this.encryptionKey, dataSourceObjectDescription.encryptionKey) &&
        Objects.equals(this.encryptionMode, dataSourceObjectDescription.encryptionMode) &&
        Objects.equals(this.flatStorage, dataSourceObjectDescription.flatStorage) &&
        Objects.equals(this.lastSynchronizationDate, dataSourceObjectDescription.lastSynchronizationDate) &&
        Objects.equals(this.objectsBaseFolder, dataSourceObjectDescription.objectsBaseFolder) &&
        Objects.equals(this.objectsBucket, dataSourceObjectDescription.objectsBucket) &&
        Objects.equals(this.objectsHost, dataSourceObjectDescription.objectsHost) &&
        Objects.equals(this.objectsPort, dataSourceObjectDescription.objectsPort) &&
        Objects.equals(this.objectsSecure, dataSourceObjectDescription.objectsSecure) &&
        Objects.equals(this.objectsServiceName, dataSourceObjectDescription.objectsServiceName) &&
        Objects.equals(this.peerAddress, dataSourceObjectDescription.peerAddress) &&
        Objects.equals(this.skipSyncOnRestart, dataSourceObjectDescription.skipSyncOnRestart) &&
        Objects.equals(this.storageConfiguration, dataSourceObjectDescription.storageConfiguration) &&
        Objects.equals(this.storageType, dataSourceObjectDescription.storageType) &&
        Objects.equals(this.versioningPolicyName, dataSourceObjectDescription.versioningPolicyName) &&
        Objects.equals(this.watch, dataSourceObjectDescription.watch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(apiKey, apiSecret, creationDate, disabled, encryptionKey, encryptionMode, flatStorage, lastSynchronizationDate, objectsBaseFolder, objectsBucket, objectsHost, objectsPort, objectsSecure, objectsServiceName, peerAddress, skipSyncOnRestart, storageConfiguration, storageType, versioningPolicyName, watch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DataSourceObjectDescription {\n");
    sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
    sb.append("    apiSecret: ").append(toIndentedString(apiSecret)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
    sb.append("    encryptionKey: ").append(toIndentedString(encryptionKey)).append("\n");
    sb.append("    encryptionMode: ").append(toIndentedString(encryptionMode)).append("\n");
    sb.append("    flatStorage: ").append(toIndentedString(flatStorage)).append("\n");
    sb.append("    lastSynchronizationDate: ").append(toIndentedString(lastSynchronizationDate)).append("\n");
    sb.append("    objectsBaseFolder: ").append(toIndentedString(objectsBaseFolder)).append("\n");
    sb.append("    objectsBucket: ").append(toIndentedString(objectsBucket)).append("\n");
    sb.append("    objectsHost: ").append(toIndentedString(objectsHost)).append("\n");
    sb.append("    objectsPort: ").append(toIndentedString(objectsPort)).append("\n");
    sb.append("    objectsSecure: ").append(toIndentedString(objectsSecure)).append("\n");
    sb.append("    objectsServiceName: ").append(toIndentedString(objectsServiceName)).append("\n");
    sb.append("    peerAddress: ").append(toIndentedString(peerAddress)).append("\n");
    sb.append("    skipSyncOnRestart: ").append(toIndentedString(skipSyncOnRestart)).append("\n");
    sb.append("    storageConfiguration: ").append(toIndentedString(storageConfiguration)).append("\n");
    sb.append("    storageType: ").append(toIndentedString(storageType)).append("\n");
    sb.append("    versioningPolicyName: ").append(toIndentedString(versioningPolicyName)).append("\n");
    sb.append("    watch: ").append(toIndentedString(watch)).append("\n");
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
    openapiFields.add("ApiKey");
    openapiFields.add("ApiSecret");
    openapiFields.add("CreationDate");
    openapiFields.add("Disabled");
    openapiFields.add("EncryptionKey");
    openapiFields.add("EncryptionMode");
    openapiFields.add("FlatStorage");
    openapiFields.add("LastSynchronizationDate");
    openapiFields.add("ObjectsBaseFolder");
    openapiFields.add("ObjectsBucket");
    openapiFields.add("ObjectsHost");
    openapiFields.add("ObjectsPort");
    openapiFields.add("ObjectsSecure");
    openapiFields.add("ObjectsServiceName");
    openapiFields.add("PeerAddress");
    openapiFields.add("SkipSyncOnRestart");
    openapiFields.add("StorageConfiguration");
    openapiFields.add("StorageType");
    openapiFields.add("VersioningPolicyName");
    openapiFields.add("Watch");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to DataSourceObjectDescription
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DataSourceObjectDescription.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DataSourceObjectDescription is not found in the empty JSON string", DataSourceObjectDescription.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DataSourceObjectDescription.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DataSourceObjectDescription` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("ApiKey") != null && !jsonObj.get("ApiKey").isJsonNull()) && !jsonObj.get("ApiKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ApiKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ApiKey").toString()));
      }
      if ((jsonObj.get("ApiSecret") != null && !jsonObj.get("ApiSecret").isJsonNull()) && !jsonObj.get("ApiSecret").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ApiSecret` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ApiSecret").toString()));
      }
      if ((jsonObj.get("EncryptionKey") != null && !jsonObj.get("EncryptionKey").isJsonNull()) && !jsonObj.get("EncryptionKey").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `EncryptionKey` to be a primitive type in the JSON string but got `%s`", jsonObj.get("EncryptionKey").toString()));
      }
      // validate the optional field `EncryptionMode`
      if (jsonObj.get("EncryptionMode") != null && !jsonObj.get("EncryptionMode").isJsonNull()) {
        ObjectEncryptionMode.validateJsonElement(jsonObj.get("EncryptionMode"));
      }
      if ((jsonObj.get("ObjectsBaseFolder") != null && !jsonObj.get("ObjectsBaseFolder").isJsonNull()) && !jsonObj.get("ObjectsBaseFolder").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ObjectsBaseFolder` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ObjectsBaseFolder").toString()));
      }
      if ((jsonObj.get("ObjectsBucket") != null && !jsonObj.get("ObjectsBucket").isJsonNull()) && !jsonObj.get("ObjectsBucket").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ObjectsBucket` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ObjectsBucket").toString()));
      }
      if ((jsonObj.get("ObjectsHost") != null && !jsonObj.get("ObjectsHost").isJsonNull()) && !jsonObj.get("ObjectsHost").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ObjectsHost` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ObjectsHost").toString()));
      }
      if ((jsonObj.get("ObjectsServiceName") != null && !jsonObj.get("ObjectsServiceName").isJsonNull()) && !jsonObj.get("ObjectsServiceName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ObjectsServiceName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ObjectsServiceName").toString()));
      }
      if ((jsonObj.get("PeerAddress") != null && !jsonObj.get("PeerAddress").isJsonNull()) && !jsonObj.get("PeerAddress").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `PeerAddress` to be a primitive type in the JSON string but got `%s`", jsonObj.get("PeerAddress").toString()));
      }
      // validate the optional field `StorageType`
      if (jsonObj.get("StorageType") != null && !jsonObj.get("StorageType").isJsonNull()) {
        ObjectStorageType.validateJsonElement(jsonObj.get("StorageType"));
      }
      if ((jsonObj.get("VersioningPolicyName") != null && !jsonObj.get("VersioningPolicyName").isJsonNull()) && !jsonObj.get("VersioningPolicyName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `VersioningPolicyName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("VersioningPolicyName").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DataSourceObjectDescription.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DataSourceObjectDescription' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DataSourceObjectDescription> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DataSourceObjectDescription.class));

       return (TypeAdapter<T>) new TypeAdapter<DataSourceObjectDescription>() {
           @Override
           public void write(JsonWriter out, DataSourceObjectDescription value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DataSourceObjectDescription read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DataSourceObjectDescription given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DataSourceObjectDescription
  * @throws IOException if the JSON string is invalid with respect to DataSourceObjectDescription
  */
  public static DataSourceObjectDescription fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DataSourceObjectDescription.class);
  }

 /**
  * Convert an instance of DataSourceObjectDescription to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

