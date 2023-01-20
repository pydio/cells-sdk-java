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
 * RestUserMetaCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-20T11:40:14.306426+01:00[Europe/Berlin]")
public class RestUserMetaCollection {
  public static final String SERIALIZED_NAME_METADATAS = "Metadatas";
  @SerializedName(SERIALIZED_NAME_METADATAS)
  private List<IdmUserMeta> metadatas = null;

  public RestUserMetaCollection() {
  }

  public RestUserMetaCollection metadatas(List<IdmUserMeta> metadatas) {
    
    this.metadatas = metadatas;
    return this;
  }

  public RestUserMetaCollection addMetadatasItem(IdmUserMeta metadatasItem) {
    if (this.metadatas == null) {
      this.metadatas = new ArrayList<>();
    }
    this.metadatas.add(metadatasItem);
    return this;
  }

   /**
   * Get metadatas
   * @return metadatas
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmUserMeta> getMetadatas() {
    return metadatas;
  }


  public void setMetadatas(List<IdmUserMeta> metadatas) {
    this.metadatas = metadatas;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestUserMetaCollection restUserMetaCollection = (RestUserMetaCollection) o;
    return Objects.equals(this.metadatas, restUserMetaCollection.metadatas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadatas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestUserMetaCollection {\n");
    sb.append("    metadatas: ").append(toIndentedString(metadatas)).append("\n");
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
    openapiFields.add("Metadatas");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestUserMetaCollection
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestUserMetaCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestUserMetaCollection is not found in the empty JSON string", RestUserMetaCollection.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestUserMetaCollection.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestUserMetaCollection` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("Metadatas") != null && !jsonObj.get("Metadatas").isJsonNull()) {
        JsonArray jsonArraymetadatas = jsonObj.getAsJsonArray("Metadatas");
        if (jsonArraymetadatas != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Metadatas").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Metadatas` to be an array in the JSON string but got `%s`", jsonObj.get("Metadatas").toString()));
          }

          // validate the optional field `Metadatas` (array)
          for (int i = 0; i < jsonArraymetadatas.size(); i++) {
            IdmUserMeta.validateJsonObject(jsonArraymetadatas.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestUserMetaCollection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestUserMetaCollection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestUserMetaCollection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestUserMetaCollection.class));

       return (TypeAdapter<T>) new TypeAdapter<RestUserMetaCollection>() {
           @Override
           public void write(JsonWriter out, RestUserMetaCollection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestUserMetaCollection read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestUserMetaCollection given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestUserMetaCollection
  * @throws IOException if the JSON string is invalid with respect to RestUserMetaCollection
  */
  public static RestUserMetaCollection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestUserMetaCollection.class);
  }

 /**
  * Convert an instance of RestUserMetaCollection to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

