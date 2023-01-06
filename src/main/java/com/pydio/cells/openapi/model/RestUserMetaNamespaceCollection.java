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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestUserMetaNamespaceCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RestUserMetaNamespaceCollection {
  public static final String SERIALIZED_NAME_NAMESPACES = "Namespaces";
  @SerializedName(SERIALIZED_NAME_NAMESPACES)
  private List<IdmUserMetaNamespace> namespaces = null;

  public RestUserMetaNamespaceCollection() {
  }

  public RestUserMetaNamespaceCollection namespaces(List<IdmUserMetaNamespace> namespaces) {
    
    this.namespaces = namespaces;
    return this;
  }

  public RestUserMetaNamespaceCollection addNamespacesItem(IdmUserMetaNamespace namespacesItem) {
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
  @ApiModelProperty(value = "")

  public List<IdmUserMetaNamespace> getNamespaces() {
    return namespaces;
  }


  public void setNamespaces(List<IdmUserMetaNamespace> namespaces) {
    this.namespaces = namespaces;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestUserMetaNamespaceCollection restUserMetaNamespaceCollection = (RestUserMetaNamespaceCollection) o;
    return Objects.equals(this.namespaces, restUserMetaNamespaceCollection.namespaces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespaces);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUserMetaNamespaceCollection {\n");
    sb.append("    namespaces: ").append(toIndentedString(namespaces)).append("\n");
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

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestUserMetaNamespaceCollection
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestUserMetaNamespaceCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestUserMetaNamespaceCollection is not found in the empty JSON string", RestUserMetaNamespaceCollection.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestUserMetaNamespaceCollection.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestUserMetaNamespaceCollection` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Namespaces") != null && !jsonObj.get("Namespaces").isJsonNull()) {
        JsonArray jsonArraynamespaces = jsonObj.getAsJsonArray("Namespaces");
        if (jsonArraynamespaces != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Namespaces").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Namespaces` to be an array in the JSON string but got `%s`", jsonObj.get("Namespaces").toString()));
          }

          // validate the optional field `Namespaces` (array)
          for (int i = 0; i < jsonArraynamespaces.size(); i++) {
            IdmUserMetaNamespace.validateJsonObject(jsonArraynamespaces.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestUserMetaNamespaceCollection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestUserMetaNamespaceCollection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestUserMetaNamespaceCollection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestUserMetaNamespaceCollection.class));

       return (TypeAdapter<T>) new TypeAdapter<RestUserMetaNamespaceCollection>() {
           @Override
           public void write(JsonWriter out, RestUserMetaNamespaceCollection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestUserMetaNamespaceCollection read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestUserMetaNamespaceCollection given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestUserMetaNamespaceCollection
  * @throws IOException if the JSON string is invalid with respect to RestUserMetaNamespaceCollection
  */
  public static RestUserMetaNamespaceCollection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestUserMetaNamespaceCollection.class);
  }

 /**
  * Convert an instance of RestUserMetaNamespaceCollection to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

