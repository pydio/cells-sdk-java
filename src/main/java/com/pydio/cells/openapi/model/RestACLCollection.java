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
 * RestACLCollection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RestACLCollection {
  public static final String SERIALIZED_NAME_AC_LS = "ACLs";
  @SerializedName(SERIALIZED_NAME_AC_LS)
  private List<IdmACL> acLs = null;

  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public RestACLCollection() {
  }

  public RestACLCollection acLs(List<IdmACL> acLs) {
    
    this.acLs = acLs;
    return this;
  }

  public RestACLCollection addAcLsItem(IdmACL acLsItem) {
    if (this.acLs == null) {
      this.acLs = new ArrayList<>();
    }
    this.acLs.add(acLsItem);
    return this;
  }

   /**
   * Get acLs
   * @return acLs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<IdmACL> getAcLs() {
    return acLs;
  }


  public void setAcLs(List<IdmACL> acLs) {
    this.acLs = acLs;
  }


  public RestACLCollection total(Integer total) {
    
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getTotal() {
    return total;
  }


  public void setTotal(Integer total) {
    this.total = total;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestACLCollection restACLCollection = (RestACLCollection) o;
    return Objects.equals(this.acLs, restACLCollection.acLs) &&
        Objects.equals(this.total, restACLCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acLs, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestACLCollection {\n");
    sb.append("    acLs: ").append(toIndentedString(acLs)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
    openapiFields.add("ACLs");
    openapiFields.add("Total");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestACLCollection
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestACLCollection.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestACLCollection is not found in the empty JSON string", RestACLCollection.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestACLCollection.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestACLCollection` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("ACLs") != null && !jsonObj.get("ACLs").isJsonNull()) {
        JsonArray jsonArrayacLs = jsonObj.getAsJsonArray("ACLs");
        if (jsonArrayacLs != null) {
          // ensure the json data is an array
          if (!jsonObj.get("ACLs").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `ACLs` to be an array in the JSON string but got `%s`", jsonObj.get("ACLs").toString()));
          }

          // validate the optional field `ACLs` (array)
          for (int i = 0; i < jsonArrayacLs.size(); i++) {
            IdmACL.validateJsonObject(jsonArrayacLs.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestACLCollection.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestACLCollection' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestACLCollection> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestACLCollection.class));

       return (TypeAdapter<T>) new TypeAdapter<RestACLCollection>() {
           @Override
           public void write(JsonWriter out, RestACLCollection value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestACLCollection read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestACLCollection given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestACLCollection
  * @throws IOException if the JSON string is invalid with respect to RestACLCollection
  */
  public static RestACLCollection fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestACLCollection.class);
  }

 /**
  * Convert an instance of RestACLCollection to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

