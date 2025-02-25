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

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.ObjectEncryptionMode;
import com.pydio.cells.openapi.model.ObjectStorageType;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pydio.cells.openapi.JSON;

/**
 * ConfigServicePutDataSourceBody
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-02-19T16:47:50.322929+01:00[Europe/Berlin]", comments = "Generator version: 7.11.0")
public class ConfigServicePutDataSourceBody {
    public static final String SERIALIZED_NAME_API_KEY = "ApiKey";
    @SerializedName(SERIALIZED_NAME_API_KEY)
    @javax.annotation.Nullable
    private String apiKey;

    public static final String SERIALIZED_NAME_API_SECRET = "ApiSecret";
    @SerializedName(SERIALIZED_NAME_API_SECRET)
    @javax.annotation.Nullable
    private String apiSecret;

    public static final String SERIALIZED_NAME_CREATION_DATE = "CreationDate";
    @SerializedName(SERIALIZED_NAME_CREATION_DATE)
    @javax.annotation.Nullable
    private Integer creationDate;

    public static final String SERIALIZED_NAME_DISABLED = "Disabled";
    @SerializedName(SERIALIZED_NAME_DISABLED)
    @javax.annotation.Nullable
    private Boolean disabled;

    public static final String SERIALIZED_NAME_ENCRYPTION_KEY = "EncryptionKey";
    @SerializedName(SERIALIZED_NAME_ENCRYPTION_KEY)
    @javax.annotation.Nullable
    private String encryptionKey;

    public static final String SERIALIZED_NAME_ENCRYPTION_MODE = "EncryptionMode";
    @SerializedName(SERIALIZED_NAME_ENCRYPTION_MODE)
    @javax.annotation.Nullable
    private ObjectEncryptionMode encryptionMode = ObjectEncryptionMode.CLEAR;

    public static final String SERIALIZED_NAME_FLAT_STORAGE = "FlatStorage";
    @SerializedName(SERIALIZED_NAME_FLAT_STORAGE)
    @javax.annotation.Nullable
    private Boolean flatStorage;

    public static final String SERIALIZED_NAME_LAST_SYNCHRONIZATION_DATE = "LastSynchronizationDate";
    @SerializedName(SERIALIZED_NAME_LAST_SYNCHRONIZATION_DATE)
    @javax.annotation.Nullable
    private Integer lastSynchronizationDate;

    public static final String SERIALIZED_NAME_OBJECTS_BASE_FOLDER = "ObjectsBaseFolder";
    @SerializedName(SERIALIZED_NAME_OBJECTS_BASE_FOLDER)
    @javax.annotation.Nullable
    private String objectsBaseFolder;

    public static final String SERIALIZED_NAME_OBJECTS_BUCKET = "ObjectsBucket";
    @SerializedName(SERIALIZED_NAME_OBJECTS_BUCKET)
    @javax.annotation.Nullable
    private String objectsBucket;

    public static final String SERIALIZED_NAME_OBJECTS_HOST = "ObjectsHost";
    @SerializedName(SERIALIZED_NAME_OBJECTS_HOST)
    @javax.annotation.Nullable
    private String objectsHost;

    public static final String SERIALIZED_NAME_OBJECTS_PORT = "ObjectsPort";
    @SerializedName(SERIALIZED_NAME_OBJECTS_PORT)
    @javax.annotation.Nullable
    private Integer objectsPort;

    public static final String SERIALIZED_NAME_OBJECTS_SECURE = "ObjectsSecure";
    @SerializedName(SERIALIZED_NAME_OBJECTS_SECURE)
    @javax.annotation.Nullable
    private Boolean objectsSecure;

    public static final String SERIALIZED_NAME_OBJECTS_SERVICE_NAME = "ObjectsServiceName";
    @SerializedName(SERIALIZED_NAME_OBJECTS_SERVICE_NAME)
    @javax.annotation.Nullable
    private String objectsServiceName;

    public static final String SERIALIZED_NAME_PEER_ADDRESS = "PeerAddress";
    @SerializedName(SERIALIZED_NAME_PEER_ADDRESS)
    @javax.annotation.Nullable
    private String peerAddress;

    public static final String SERIALIZED_NAME_SKIP_SYNC_ON_RESTART = "SkipSyncOnRestart";
    @SerializedName(SERIALIZED_NAME_SKIP_SYNC_ON_RESTART)
    @javax.annotation.Nullable
    private Boolean skipSyncOnRestart;

    public static final String SERIALIZED_NAME_STORAGE_CONFIGURATION = "StorageConfiguration";
    @SerializedName(SERIALIZED_NAME_STORAGE_CONFIGURATION)
    @javax.annotation.Nullable
    private Map<String, String> storageConfiguration = new HashMap<>();

    public static final String SERIALIZED_NAME_STORAGE_TYPE = "StorageType";
    @SerializedName(SERIALIZED_NAME_STORAGE_TYPE)
    @javax.annotation.Nullable
    private ObjectStorageType storageType = ObjectStorageType.LOCAL;

    public static final String SERIALIZED_NAME_VERSIONING_POLICY_NAME = "VersioningPolicyName";
    @SerializedName(SERIALIZED_NAME_VERSIONING_POLICY_NAME)
    @javax.annotation.Nullable
    private String versioningPolicyName;

    public static final String SERIALIZED_NAME_WATCH = "Watch";
    @SerializedName(SERIALIZED_NAME_WATCH)
    @javax.annotation.Nullable
    private Boolean watch;

    public ConfigServicePutDataSourceBody() {
    }

    public ConfigServicePutDataSourceBody apiKey(@javax.annotation.Nullable String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Get apiKey
     *
     * @return apiKey
     */
    @javax.annotation.Nullable
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(@javax.annotation.Nullable String apiKey) {
        this.apiKey = apiKey;
    }


    public ConfigServicePutDataSourceBody apiSecret(@javax.annotation.Nullable String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }

    /**
     * Get apiSecret
     *
     * @return apiSecret
     */
    @javax.annotation.Nullable
    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(@javax.annotation.Nullable String apiSecret) {
        this.apiSecret = apiSecret;
    }


    public ConfigServicePutDataSourceBody creationDate(@javax.annotation.Nullable Integer creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * Get creationDate
     *
     * @return creationDate
     */
    @javax.annotation.Nullable
    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(@javax.annotation.Nullable Integer creationDate) {
        this.creationDate = creationDate;
    }


    public ConfigServicePutDataSourceBody disabled(@javax.annotation.Nullable Boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    /**
     * Get disabled
     *
     * @return disabled
     */
    @javax.annotation.Nullable
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(@javax.annotation.Nullable Boolean disabled) {
        this.disabled = disabled;
    }


    public ConfigServicePutDataSourceBody encryptionKey(@javax.annotation.Nullable String encryptionKey) {
        this.encryptionKey = encryptionKey;
        return this;
    }

    /**
     * Get encryptionKey
     *
     * @return encryptionKey
     */
    @javax.annotation.Nullable
    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(@javax.annotation.Nullable String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }


    public ConfigServicePutDataSourceBody encryptionMode(@javax.annotation.Nullable ObjectEncryptionMode encryptionMode) {
        this.encryptionMode = encryptionMode;
        return this;
    }

    /**
     * Get encryptionMode
     *
     * @return encryptionMode
     */
    @javax.annotation.Nullable
    public ObjectEncryptionMode getEncryptionMode() {
        return encryptionMode;
    }

    public void setEncryptionMode(@javax.annotation.Nullable ObjectEncryptionMode encryptionMode) {
        this.encryptionMode = encryptionMode;
    }


    public ConfigServicePutDataSourceBody flatStorage(@javax.annotation.Nullable Boolean flatStorage) {
        this.flatStorage = flatStorage;
        return this;
    }

    /**
     * Get flatStorage
     *
     * @return flatStorage
     */
    @javax.annotation.Nullable
    public Boolean getFlatStorage() {
        return flatStorage;
    }

    public void setFlatStorage(@javax.annotation.Nullable Boolean flatStorage) {
        this.flatStorage = flatStorage;
    }


    public ConfigServicePutDataSourceBody lastSynchronizationDate(@javax.annotation.Nullable Integer lastSynchronizationDate) {
        this.lastSynchronizationDate = lastSynchronizationDate;
        return this;
    }

    /**
     * Get lastSynchronizationDate
     *
     * @return lastSynchronizationDate
     */
    @javax.annotation.Nullable
    public Integer getLastSynchronizationDate() {
        return lastSynchronizationDate;
    }

    public void setLastSynchronizationDate(@javax.annotation.Nullable Integer lastSynchronizationDate) {
        this.lastSynchronizationDate = lastSynchronizationDate;
    }


    public ConfigServicePutDataSourceBody objectsBaseFolder(@javax.annotation.Nullable String objectsBaseFolder) {
        this.objectsBaseFolder = objectsBaseFolder;
        return this;
    }

    /**
     * Get objectsBaseFolder
     *
     * @return objectsBaseFolder
     */
    @javax.annotation.Nullable
    public String getObjectsBaseFolder() {
        return objectsBaseFolder;
    }

    public void setObjectsBaseFolder(@javax.annotation.Nullable String objectsBaseFolder) {
        this.objectsBaseFolder = objectsBaseFolder;
    }


    public ConfigServicePutDataSourceBody objectsBucket(@javax.annotation.Nullable String objectsBucket) {
        this.objectsBucket = objectsBucket;
        return this;
    }

    /**
     * Get objectsBucket
     *
     * @return objectsBucket
     */
    @javax.annotation.Nullable
    public String getObjectsBucket() {
        return objectsBucket;
    }

    public void setObjectsBucket(@javax.annotation.Nullable String objectsBucket) {
        this.objectsBucket = objectsBucket;
    }


    public ConfigServicePutDataSourceBody objectsHost(@javax.annotation.Nullable String objectsHost) {
        this.objectsHost = objectsHost;
        return this;
    }

    /**
     * Get objectsHost
     *
     * @return objectsHost
     */
    @javax.annotation.Nullable
    public String getObjectsHost() {
        return objectsHost;
    }

    public void setObjectsHost(@javax.annotation.Nullable String objectsHost) {
        this.objectsHost = objectsHost;
    }


    public ConfigServicePutDataSourceBody objectsPort(@javax.annotation.Nullable Integer objectsPort) {
        this.objectsPort = objectsPort;
        return this;
    }

    /**
     * Get objectsPort
     *
     * @return objectsPort
     */
    @javax.annotation.Nullable
    public Integer getObjectsPort() {
        return objectsPort;
    }

    public void setObjectsPort(@javax.annotation.Nullable Integer objectsPort) {
        this.objectsPort = objectsPort;
    }


    public ConfigServicePutDataSourceBody objectsSecure(@javax.annotation.Nullable Boolean objectsSecure) {
        this.objectsSecure = objectsSecure;
        return this;
    }

    /**
     * Get objectsSecure
     *
     * @return objectsSecure
     */
    @javax.annotation.Nullable
    public Boolean getObjectsSecure() {
        return objectsSecure;
    }

    public void setObjectsSecure(@javax.annotation.Nullable Boolean objectsSecure) {
        this.objectsSecure = objectsSecure;
    }


    public ConfigServicePutDataSourceBody objectsServiceName(@javax.annotation.Nullable String objectsServiceName) {
        this.objectsServiceName = objectsServiceName;
        return this;
    }

    /**
     * Get objectsServiceName
     *
     * @return objectsServiceName
     */
    @javax.annotation.Nullable
    public String getObjectsServiceName() {
        return objectsServiceName;
    }

    public void setObjectsServiceName(@javax.annotation.Nullable String objectsServiceName) {
        this.objectsServiceName = objectsServiceName;
    }


    public ConfigServicePutDataSourceBody peerAddress(@javax.annotation.Nullable String peerAddress) {
        this.peerAddress = peerAddress;
        return this;
    }

    /**
     * Get peerAddress
     *
     * @return peerAddress
     */
    @javax.annotation.Nullable
    public String getPeerAddress() {
        return peerAddress;
    }

    public void setPeerAddress(@javax.annotation.Nullable String peerAddress) {
        this.peerAddress = peerAddress;
    }


    public ConfigServicePutDataSourceBody skipSyncOnRestart(@javax.annotation.Nullable Boolean skipSyncOnRestart) {
        this.skipSyncOnRestart = skipSyncOnRestart;
        return this;
    }

    /**
     * Get skipSyncOnRestart
     *
     * @return skipSyncOnRestart
     */
    @javax.annotation.Nullable
    public Boolean getSkipSyncOnRestart() {
        return skipSyncOnRestart;
    }

    public void setSkipSyncOnRestart(@javax.annotation.Nullable Boolean skipSyncOnRestart) {
        this.skipSyncOnRestart = skipSyncOnRestart;
    }


    public ConfigServicePutDataSourceBody storageConfiguration(@javax.annotation.Nullable Map<String, String> storageConfiguration) {
        this.storageConfiguration = storageConfiguration;
        return this;
    }

    public ConfigServicePutDataSourceBody putStorageConfigurationItem(String key, String storageConfigurationItem) {
        if (this.storageConfiguration == null) {
            this.storageConfiguration = new HashMap<>();
        }
        this.storageConfiguration.put(key, storageConfigurationItem);
        return this;
    }

    /**
     * Get storageConfiguration
     *
     * @return storageConfiguration
     */
    @javax.annotation.Nullable
    public Map<String, String> getStorageConfiguration() {
        return storageConfiguration;
    }

    public void setStorageConfiguration(@javax.annotation.Nullable Map<String, String> storageConfiguration) {
        this.storageConfiguration = storageConfiguration;
    }


    public ConfigServicePutDataSourceBody storageType(@javax.annotation.Nullable ObjectStorageType storageType) {
        this.storageType = storageType;
        return this;
    }

    /**
     * Get storageType
     *
     * @return storageType
     */
    @javax.annotation.Nullable
    public ObjectStorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(@javax.annotation.Nullable ObjectStorageType storageType) {
        this.storageType = storageType;
    }


    public ConfigServicePutDataSourceBody versioningPolicyName(@javax.annotation.Nullable String versioningPolicyName) {
        this.versioningPolicyName = versioningPolicyName;
        return this;
    }

    /**
     * Get versioningPolicyName
     *
     * @return versioningPolicyName
     */
    @javax.annotation.Nullable
    public String getVersioningPolicyName() {
        return versioningPolicyName;
    }

    public void setVersioningPolicyName(@javax.annotation.Nullable String versioningPolicyName) {
        this.versioningPolicyName = versioningPolicyName;
    }


    public ConfigServicePutDataSourceBody watch(@javax.annotation.Nullable Boolean watch) {
        this.watch = watch;
        return this;
    }

    /**
     * Get watch
     *
     * @return watch
     */
    @javax.annotation.Nullable
    public Boolean getWatch() {
        return watch;
    }

    public void setWatch(@javax.annotation.Nullable Boolean watch) {
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
        ConfigServicePutDataSourceBody configServicePutDataSourceBody = (ConfigServicePutDataSourceBody) o;
        return Objects.equals(this.apiKey, configServicePutDataSourceBody.apiKey) &&
                Objects.equals(this.apiSecret, configServicePutDataSourceBody.apiSecret) &&
                Objects.equals(this.creationDate, configServicePutDataSourceBody.creationDate) &&
                Objects.equals(this.disabled, configServicePutDataSourceBody.disabled) &&
                Objects.equals(this.encryptionKey, configServicePutDataSourceBody.encryptionKey) &&
                Objects.equals(this.encryptionMode, configServicePutDataSourceBody.encryptionMode) &&
                Objects.equals(this.flatStorage, configServicePutDataSourceBody.flatStorage) &&
                Objects.equals(this.lastSynchronizationDate, configServicePutDataSourceBody.lastSynchronizationDate) &&
                Objects.equals(this.objectsBaseFolder, configServicePutDataSourceBody.objectsBaseFolder) &&
                Objects.equals(this.objectsBucket, configServicePutDataSourceBody.objectsBucket) &&
                Objects.equals(this.objectsHost, configServicePutDataSourceBody.objectsHost) &&
                Objects.equals(this.objectsPort, configServicePutDataSourceBody.objectsPort) &&
                Objects.equals(this.objectsSecure, configServicePutDataSourceBody.objectsSecure) &&
                Objects.equals(this.objectsServiceName, configServicePutDataSourceBody.objectsServiceName) &&
                Objects.equals(this.peerAddress, configServicePutDataSourceBody.peerAddress) &&
                Objects.equals(this.skipSyncOnRestart, configServicePutDataSourceBody.skipSyncOnRestart) &&
                Objects.equals(this.storageConfiguration, configServicePutDataSourceBody.storageConfiguration) &&
                Objects.equals(this.storageType, configServicePutDataSourceBody.storageType) &&
                Objects.equals(this.versioningPolicyName, configServicePutDataSourceBody.versioningPolicyName) &&
                Objects.equals(this.watch, configServicePutDataSourceBody.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, apiSecret, creationDate, disabled, encryptionKey, encryptionMode, flatStorage, lastSynchronizationDate, objectsBaseFolder, objectsBucket, objectsHost, objectsPort, objectsSecure, objectsServiceName, peerAddress, skipSyncOnRestart, storageConfiguration, storageType, versioningPolicyName, watch);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConfigServicePutDataSourceBody {\n");
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
     * @throws IOException if the JSON Element is invalid with respect to ConfigServicePutDataSourceBody
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ConfigServicePutDataSourceBody.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in ConfigServicePutDataSourceBody is not found in the empty JSON string", ConfigServicePutDataSourceBody.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ConfigServicePutDataSourceBody.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ConfigServicePutDataSourceBody` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
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
            if (!ConfigServicePutDataSourceBody.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ConfigServicePutDataSourceBody' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ConfigServicePutDataSourceBody> thisAdapter
                    = gson.getDelegateAdapter(this, TypeToken.get(ConfigServicePutDataSourceBody.class));

            return (TypeAdapter<T>) new TypeAdapter<ConfigServicePutDataSourceBody>() {
                @Override
                public void write(JsonWriter out, ConfigServicePutDataSourceBody value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ConfigServicePutDataSourceBody read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }

            }.nullSafe();
        }
    }

    /**
     * Create an instance of ConfigServicePutDataSourceBody given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConfigServicePutDataSourceBody
     * @throws IOException if the JSON string is invalid with respect to ConfigServicePutDataSourceBody
     */
    public static ConfigServicePutDataSourceBody fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ConfigServicePutDataSourceBody.class);
    }

    /**
     * Convert an instance of ConfigServicePutDataSourceBody to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

