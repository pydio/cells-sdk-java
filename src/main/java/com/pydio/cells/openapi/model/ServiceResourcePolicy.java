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
 * ServiceResourcePolicy
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class ServiceResourcePolicy {
  public static final String SERIALIZED_NAME_ACTION = "Action";
  @SerializedName(SERIALIZED_NAME_ACTION)
  private ServiceResourcePolicyAction action = ServiceResourcePolicyAction.ANY;

  public static final String SERIALIZED_NAME_EFFECT = "Effect";
  @SerializedName(SERIALIZED_NAME_EFFECT)
  private ServiceResourcePolicyPolicyEffect effect = ServiceResourcePolicyPolicyEffect.DENY;

  public static final String SERIALIZED_NAME_JSON_CONDITIONS = "JsonConditions";
  @SerializedName(SERIALIZED_NAME_JSON_CONDITIONS)
  private String jsonConditions;

  public static final String SERIALIZED_NAME_RESOURCE = "Resource";
  @SerializedName(SERIALIZED_NAME_RESOURCE)
  private String resource;

  public static final String SERIALIZED_NAME_SUBJECT = "Subject";
  @SerializedName(SERIALIZED_NAME_SUBJECT)
  private String subject;

  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public ServiceResourcePolicy() {
  }

  public ServiceResourcePolicy action(ServiceResourcePolicyAction action) {
    
    this.action = action;
    return this;
  }

   /**
   * Get action
   * @return action
  **/
  @javax.annotation.Nullable

  public ServiceResourcePolicyAction getAction() {
    return action;
  }


  public void setAction(ServiceResourcePolicyAction action) {
    this.action = action;
  }


  public ServiceResourcePolicy effect(ServiceResourcePolicyPolicyEffect effect) {
    
    this.effect = effect;
    return this;
  }

   /**
   * Get effect
   * @return effect
  **/
  @javax.annotation.Nullable

  public ServiceResourcePolicyPolicyEffect getEffect() {
    return effect;
  }


  public void setEffect(ServiceResourcePolicyPolicyEffect effect) {
    this.effect = effect;
  }


  public ServiceResourcePolicy jsonConditions(String jsonConditions) {
    
    this.jsonConditions = jsonConditions;
    return this;
  }

   /**
   * Get jsonConditions
   * @return jsonConditions
  **/
  @javax.annotation.Nullable

  public String getJsonConditions() {
    return jsonConditions;
  }


  public void setJsonConditions(String jsonConditions) {
    this.jsonConditions = jsonConditions;
  }


  public ServiceResourcePolicy resource(String resource) {
    
    this.resource = resource;
    return this;
  }

   /**
   * Get resource
   * @return resource
  **/
  @javax.annotation.Nullable

  public String getResource() {
    return resource;
  }


  public void setResource(String resource) {
    this.resource = resource;
  }


  public ServiceResourcePolicy subject(String subject) {
    
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @javax.annotation.Nullable

  public String getSubject() {
    return subject;
  }


  public void setSubject(String subject) {
    this.subject = subject;
  }


  public ServiceResourcePolicy id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceResourcePolicy serviceResourcePolicy = (ServiceResourcePolicy) o;
    return Objects.equals(this.action, serviceResourcePolicy.action) &&
        Objects.equals(this.effect, serviceResourcePolicy.effect) &&
        Objects.equals(this.jsonConditions, serviceResourcePolicy.jsonConditions) &&
        Objects.equals(this.resource, serviceResourcePolicy.resource) &&
        Objects.equals(this.subject, serviceResourcePolicy.subject) &&
        Objects.equals(this.id, serviceResourcePolicy.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, effect, jsonConditions, resource, subject, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceResourcePolicy {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    effect: ").append(toIndentedString(effect)).append("\n");
    sb.append("    jsonConditions: ").append(toIndentedString(jsonConditions)).append("\n");
    sb.append("    resource: ").append(toIndentedString(resource)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
    openapiFields.add("Action");
    openapiFields.add("Effect");
    openapiFields.add("JsonConditions");
    openapiFields.add("Resource");
    openapiFields.add("Subject");
    openapiFields.add("id");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ServiceResourcePolicy
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ServiceResourcePolicy.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ServiceResourcePolicy is not found in the empty JSON string", ServiceResourcePolicy.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ServiceResourcePolicy.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ServiceResourcePolicy` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("JsonConditions") != null && !jsonObj.get("JsonConditions").isJsonNull()) && !jsonObj.get("JsonConditions").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `JsonConditions` to be a primitive type in the JSON string but got `%s`", jsonObj.get("JsonConditions").toString()));
      }
      if ((jsonObj.get("Resource") != null && !jsonObj.get("Resource").isJsonNull()) && !jsonObj.get("Resource").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Resource` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Resource").toString()));
      }
      if ((jsonObj.get("Subject") != null && !jsonObj.get("Subject").isJsonNull()) && !jsonObj.get("Subject").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Subject` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Subject").toString()));
      }
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ServiceResourcePolicy.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ServiceResourcePolicy' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ServiceResourcePolicy> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ServiceResourcePolicy.class));

       return (TypeAdapter<T>) new TypeAdapter<ServiceResourcePolicy>() {
           @Override
           public void write(JsonWriter out, ServiceResourcePolicy value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ServiceResourcePolicy read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ServiceResourcePolicy given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ServiceResourcePolicy
  * @throws IOException if the JSON string is invalid with respect to ServiceResourcePolicy
  */
  public static ServiceResourcePolicy fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ServiceResourcePolicy.class);
  }

 /**
  * Convert an instance of ServiceResourcePolicy to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

