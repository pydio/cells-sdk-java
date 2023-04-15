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

/**
 * RestRelationResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestRelationResponse {
  public static final String SERIALIZED_NAME_BELONGS_TO_TEAMS = "BelongsToTeams";
  @SerializedName(SERIALIZED_NAME_BELONGS_TO_TEAMS)
  private List<IdmRole> belongsToTeams;

  public static final String SERIALIZED_NAME_SHARED_CELLS = "SharedCells";
  @SerializedName(SERIALIZED_NAME_SHARED_CELLS)
  private List<IdmWorkspace> sharedCells;

  public RestRelationResponse() {
  }

  public RestRelationResponse belongsToTeams(List<IdmRole> belongsToTeams) {
    
    this.belongsToTeams = belongsToTeams;
    return this;
  }

  public RestRelationResponse addBelongsToTeamsItem(IdmRole belongsToTeamsItem) {
    if (this.belongsToTeams == null) {
      this.belongsToTeams = new ArrayList<>();
    }
    this.belongsToTeams.add(belongsToTeamsItem);
    return this;
  }

   /**
   * Get belongsToTeams
   * @return belongsToTeams
  **/
  @javax.annotation.Nullable

  public List<IdmRole> getBelongsToTeams() {
    return belongsToTeams;
  }


  public void setBelongsToTeams(List<IdmRole> belongsToTeams) {
    this.belongsToTeams = belongsToTeams;
  }


  public RestRelationResponse sharedCells(List<IdmWorkspace> sharedCells) {
    
    this.sharedCells = sharedCells;
    return this;
  }

  public RestRelationResponse addSharedCellsItem(IdmWorkspace sharedCellsItem) {
    if (this.sharedCells == null) {
      this.sharedCells = new ArrayList<>();
    }
    this.sharedCells.add(sharedCellsItem);
    return this;
  }

   /**
   * Get sharedCells
   * @return sharedCells
  **/
  @javax.annotation.Nullable

  public List<IdmWorkspace> getSharedCells() {
    return sharedCells;
  }


  public void setSharedCells(List<IdmWorkspace> sharedCells) {
    this.sharedCells = sharedCells;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestRelationResponse restRelationResponse = (RestRelationResponse) o;
    return Objects.equals(this.belongsToTeams, restRelationResponse.belongsToTeams) &&
        Objects.equals(this.sharedCells, restRelationResponse.sharedCells);
  }

  @Override
  public int hashCode() {
    return Objects.hash(belongsToTeams, sharedCells);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRelationResponse {\n");
    sb.append("    belongsToTeams: ").append(toIndentedString(belongsToTeams)).append("\n");
    sb.append("    sharedCells: ").append(toIndentedString(sharedCells)).append("\n");
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
    openapiFields.add("BelongsToTeams");
    openapiFields.add("SharedCells");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestRelationResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestRelationResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestRelationResponse is not found in the empty JSON string", RestRelationResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestRelationResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestRelationResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("BelongsToTeams") != null && !jsonObj.get("BelongsToTeams").isJsonNull()) {
        JsonArray jsonArraybelongsToTeams = jsonObj.getAsJsonArray("BelongsToTeams");
        if (jsonArraybelongsToTeams != null) {
          // ensure the json data is an array
          if (!jsonObj.get("BelongsToTeams").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `BelongsToTeams` to be an array in the JSON string but got `%s`", jsonObj.get("BelongsToTeams").toString()));
          }

          // validate the optional field `BelongsToTeams` (array)
          for (int i = 0; i < jsonArraybelongsToTeams.size(); i++) {
            IdmRole.validateJsonObject(jsonArraybelongsToTeams.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("SharedCells") != null && !jsonObj.get("SharedCells").isJsonNull()) {
        JsonArray jsonArraysharedCells = jsonObj.getAsJsonArray("SharedCells");
        if (jsonArraysharedCells != null) {
          // ensure the json data is an array
          if (!jsonObj.get("SharedCells").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `SharedCells` to be an array in the JSON string but got `%s`", jsonObj.get("SharedCells").toString()));
          }

          // validate the optional field `SharedCells` (array)
          for (int i = 0; i < jsonArraysharedCells.size(); i++) {
            IdmWorkspace.validateJsonObject(jsonArraysharedCells.get(i).getAsJsonObject());
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestRelationResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestRelationResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestRelationResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestRelationResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RestRelationResponse>() {
           @Override
           public void write(JsonWriter out, RestRelationResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestRelationResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestRelationResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestRelationResponse
  * @throws IOException if the JSON string is invalid with respect to RestRelationResponse
  */
  public static RestRelationResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestRelationResponse.class);
  }

 /**
  * Convert an instance of RestRelationResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

