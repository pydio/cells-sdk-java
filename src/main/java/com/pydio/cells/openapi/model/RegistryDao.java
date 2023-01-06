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

import io.swagger.annotations.ApiModelProperty;

/**
 * RegistryDao
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class RegistryDao {
  public static final String SERIALIZED_NAME_DRIVER = "driver";
  @SerializedName(SERIALIZED_NAME_DRIVER)
  private String driver;

  public static final String SERIALIZED_NAME_DSN = "dsn";
  @SerializedName(SERIALIZED_NAME_DSN)
  private String dsn;

  public RegistryDao() {
  }

  public RegistryDao driver(String driver) {
    
    this.driver = driver;
    return this;
  }

   /**
   * Get driver
   * @return driver
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDriver() {
    return driver;
  }


  public void setDriver(String driver) {
    this.driver = driver;
  }


  public RegistryDao dsn(String dsn) {
    
    this.dsn = dsn;
    return this;
  }

   /**
   * Get dsn
   * @return dsn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDsn() {
    return dsn;
  }


  public void setDsn(String dsn) {
    this.dsn = dsn;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryDao registryDao = (RegistryDao) o;
    return Objects.equals(this.driver, registryDao.driver) &&
        Objects.equals(this.dsn, registryDao.dsn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driver, dsn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistryDao {\n");
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    dsn: ").append(toIndentedString(dsn)).append("\n");
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
    openapiFields.add("driver");
    openapiFields.add("dsn");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RegistryDao
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RegistryDao.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RegistryDao is not found in the empty JSON string", RegistryDao.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RegistryDao.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RegistryDao` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("driver") != null && !jsonObj.get("driver").isJsonNull()) && !jsonObj.get("driver").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `driver` to be a primitive type in the JSON string but got `%s`", jsonObj.get("driver").toString()));
      }
      if ((jsonObj.get("dsn") != null && !jsonObj.get("dsn").isJsonNull()) && !jsonObj.get("dsn").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `dsn` to be a primitive type in the JSON string but got `%s`", jsonObj.get("dsn").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RegistryDao.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RegistryDao' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RegistryDao> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RegistryDao.class));

       return (TypeAdapter<T>) new TypeAdapter<RegistryDao>() {
           @Override
           public void write(JsonWriter out, RegistryDao value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RegistryDao read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RegistryDao given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RegistryDao
  * @throws IOException if the JSON string is invalid with respect to RegistryDao
  */
  public static RegistryDao fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RegistryDao.class);
  }

 /**
  * Convert an instance of RegistryDao to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

