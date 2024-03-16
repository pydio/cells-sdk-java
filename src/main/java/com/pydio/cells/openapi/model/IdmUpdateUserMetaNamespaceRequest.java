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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * IdmUpdateUserMetaNamespaceRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class IdmUpdateUserMetaNamespaceRequest {
  public static final String SERIALIZED_NAME_NAMESPACES = "Namespaces";
  @SerializedName(SERIALIZED_NAME_NAMESPACES)
  private List<IdmUserMetaNamespace> namespaces;

  public static final String SERIALIZED_NAME_OPERATION = "Operation";
  @SerializedName(SERIALIZED_NAME_OPERATION)
  private UpdateUserMetaNamespaceRequestUserMetaNsOp operation = UpdateUserMetaNamespaceRequestUserMetaNsOp.PUT;

  public IdmUpdateUserMetaNamespaceRequest() {
  }

  public IdmUpdateUserMetaNamespaceRequest namespaces(List<IdmUserMetaNamespace> namespaces) {
    this.namespaces = namespaces;
    return this;
  }

  public IdmUpdateUserMetaNamespaceRequest addNamespacesItem(IdmUserMetaNamespace namespacesItem) {
    if (this.namespaces == null) {
      this.namespaces = new ArrayList<>();
    }
    this.namespaces.add(namespacesItem);
    return this;
  }

   /**
   * Get namespaces
   * @return namespaces
  **/
  @javax.annotation.Nullable
  public List<IdmUserMetaNamespace> getNamespaces() {
    return namespaces;
  }

  public void setNamespaces(List<IdmUserMetaNamespace> namespaces) {
    this.namespaces = namespaces;
  }


  public IdmUpdateUserMetaNamespaceRequest operation(UpdateUserMetaNamespaceRequestUserMetaNsOp operation) {
    this.operation = operation;
    return this;
  }

   /**
   * Get operation
   * @return operation
  **/
  @javax.annotation.Nullable
  public UpdateUserMetaNamespaceRequestUserMetaNsOp getOperation() {
    return operation;
  }

  public void setOperation(UpdateUserMetaNamespaceRequestUserMetaNsOp operation) {
    this.operation = operation;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmUpdateUserMetaNamespaceRequest idmUpdateUserMetaNamespaceRequest = (IdmUpdateUserMetaNamespaceRequest) o;
    return Objects.equals(this.namespaces, idmUpdateUserMetaNamespaceRequest.namespaces) &&
        Objects.equals(this.operation, idmUpdateUserMetaNamespaceRequest.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespaces, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmUpdateUserMetaNamespaceRequest {\n");
    sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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
    openapiFields.add("Namespaces");
    openapiFields.add("Operation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to IdmUpdateUserMetaNamespaceRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!IdmUpdateUserMetaNamespaceRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdmUpdateUserMetaNamespaceRequest is not found in the empty JSON string", IdmUpdateUserMetaNamespaceRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!IdmUpdateUserMetaNamespaceRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmUpdateUserMetaNamespaceRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("Namespaces") != null && !jsonObj.get("Namespaces").isJsonNull()) {
        JsonArray jsonArraynamespaces = jsonObj.getAsJsonArray("Namespaces");
        if (jsonArraynamespaces != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Namespaces").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Namespaces` to be an array in the JSON string but got `%s`", jsonObj.get("Namespaces").toString()));
          }

          // validate the optional field `Namespaces` (array)
          for (int i = 0; i < jsonArraynamespaces.size(); i++) {
            IdmUserMetaNamespace.validateJsonElement(jsonArraynamespaces.get(i));
          };
        }
      }
      // validate the optional field `Operation`
      if (jsonObj.get("Operation") != null && !jsonObj.get("Operation").isJsonNull()) {
        UpdateUserMetaNamespaceRequestUserMetaNsOp.validateJsonElement(jsonObj.get("Operation"));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdmUpdateUserMetaNamespaceRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdmUpdateUserMetaNamespaceRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdmUpdateUserMetaNamespaceRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdmUpdateUserMetaNamespaceRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<IdmUpdateUserMetaNamespaceRequest>() {
           @Override
           public void write(JsonWriter out, IdmUpdateUserMetaNamespaceRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdmUpdateUserMetaNamespaceRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdmUpdateUserMetaNamespaceRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdmUpdateUserMetaNamespaceRequest
  * @throws IOException if the JSON string is invalid with respect to IdmUpdateUserMetaNamespaceRequest
  */
  public static IdmUpdateUserMetaNamespaceRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdmUpdateUserMetaNamespaceRequest.class);
  }

 /**
  * Convert an instance of IdmUpdateUserMetaNamespaceRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

