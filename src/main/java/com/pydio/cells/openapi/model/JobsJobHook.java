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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * JobsJobHook
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class JobsJobHook {
  public static final String SERIALIZED_NAME_ALLOW_OVERRIDE_PRESETS = "AllowOverridePresets";
  @SerializedName(SERIALIZED_NAME_ALLOW_OVERRIDE_PRESETS)
  private Boolean allowOverridePresets;

  public static final String SERIALIZED_NAME_API_SLUG = "ApiSlug";
  @SerializedName(SERIALIZED_NAME_API_SLUG)
  private String apiSlug;

  public static final String SERIALIZED_NAME_METADATA = "Metadata";
  @SerializedName(SERIALIZED_NAME_METADATA)
  private Map<String, String> metadata = new HashMap<>();

  public static final String SERIALIZED_NAME_POLICIES = "Policies";
  @SerializedName(SERIALIZED_NAME_POLICIES)
  private List<ServiceResourcePolicy> policies;

  public static final String SERIALIZED_NAME_PRESET_PARAMETERS = "PresetParameters";
  @SerializedName(SERIALIZED_NAME_PRESET_PARAMETERS)
  private Map<String, String> presetParameters = new HashMap<>();

  public JobsJobHook() {
  }

  public JobsJobHook allowOverridePresets(Boolean allowOverridePresets) {
    
    this.allowOverridePresets = allowOverridePresets;
    return this;
  }

   /**
   * Get allowOverridePresets
   * @return allowOverridePresets
  **/
  @javax.annotation.Nullable

  public Boolean getAllowOverridePresets() {
    return allowOverridePresets;
  }


  public void setAllowOverridePresets(Boolean allowOverridePresets) {
    this.allowOverridePresets = allowOverridePresets;
  }


  public JobsJobHook apiSlug(String apiSlug) {
    
    this.apiSlug = apiSlug;
    return this;
  }

   /**
   * Get apiSlug
   * @return apiSlug
  **/
  @javax.annotation.Nullable

  public String getApiSlug() {
    return apiSlug;
  }


  public void setApiSlug(String apiSlug) {
    this.apiSlug = apiSlug;
  }


  public JobsJobHook metadata(Map<String, String> metadata) {
    
    this.metadata = metadata;
    return this;
  }

  public JobsJobHook putMetadataItem(String key, String metadataItem) {
    if (this.metadata == null) {
      this.metadata = new HashMap<>();
    }
    this.metadata.put(key, metadataItem);
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @javax.annotation.Nullable

  public Map<String, String> getMetadata() {
    return metadata;
  }


  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }


  public JobsJobHook policies(List<ServiceResourcePolicy> policies) {
    
    this.policies = policies;
    return this;
  }

  public JobsJobHook addPoliciesItem(ServiceResourcePolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @javax.annotation.Nullable

  public List<ServiceResourcePolicy> getPolicies() {
    return policies;
  }


  public void setPolicies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
  }


  public JobsJobHook presetParameters(Map<String, String> presetParameters) {
    
    this.presetParameters = presetParameters;
    return this;
  }

  public JobsJobHook putPresetParametersItem(String key, String presetParametersItem) {
    if (this.presetParameters == null) {
      this.presetParameters = new HashMap<>();
    }
    this.presetParameters.put(key, presetParametersItem);
    return this;
  }

   /**
   * Get presetParameters
   * @return presetParameters
  **/
  @javax.annotation.Nullable

  public Map<String, String> getPresetParameters() {
    return presetParameters;
  }


  public void setPresetParameters(Map<String, String> presetParameters) {
    this.presetParameters = presetParameters;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobsJobHook jobsJobHook = (JobsJobHook) o;
    return Objects.equals(this.allowOverridePresets, jobsJobHook.allowOverridePresets) &&
        Objects.equals(this.apiSlug, jobsJobHook.apiSlug) &&
        Objects.equals(this.metadata, jobsJobHook.metadata) &&
        Objects.equals(this.policies, jobsJobHook.policies) &&
        Objects.equals(this.presetParameters, jobsJobHook.presetParameters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowOverridePresets, apiSlug, metadata, policies, presetParameters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobsJobHook {\n");
    sb.append("    allowOverridePresets: ").append(toIndentedString(allowOverridePresets)).append("\n");
    sb.append("    apiSlug: ").append(toIndentedString(apiSlug)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
    sb.append("    presetParameters: ").append(toIndentedString(presetParameters)).append("\n");
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
    openapiFields.add("AllowOverridePresets");
    openapiFields.add("ApiSlug");
    openapiFields.add("Metadata");
    openapiFields.add("Policies");
    openapiFields.add("PresetParameters");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to JobsJobHook
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!JobsJobHook.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in JobsJobHook is not found in the empty JSON string", JobsJobHook.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!JobsJobHook.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `JobsJobHook` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("ApiSlug") != null && !jsonObj.get("ApiSlug").isJsonNull()) && !jsonObj.get("ApiSlug").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ApiSlug` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ApiSlug").toString()));
      }
      if (jsonObj.get("Policies") != null && !jsonObj.get("Policies").isJsonNull()) {
        JsonArray jsonArraypolicies = jsonObj.getAsJsonArray("Policies");
        if (jsonArraypolicies != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Policies").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Policies` to be an array in the JSON string but got `%s`", jsonObj.get("Policies").toString()));
          }

          // validate the optional field `Policies` (array)
          for (int i = 0; i < jsonArraypolicies.size(); i++) {
            ServiceResourcePolicy.validateJsonObject(jsonArraypolicies.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!JobsJobHook.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'JobsJobHook' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<JobsJobHook> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(JobsJobHook.class));

       return (TypeAdapter<T>) new TypeAdapter<JobsJobHook>() {
           @Override
           public void write(JsonWriter out, JobsJobHook value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public JobsJobHook read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of JobsJobHook given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of JobsJobHook
  * @throws IOException if the JSON string is invalid with respect to JobsJobHook
  */
  public static JobsJobHook fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, JobsJobHook.class);
  }

 /**
  * Convert an instance of JobsJobHook to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

