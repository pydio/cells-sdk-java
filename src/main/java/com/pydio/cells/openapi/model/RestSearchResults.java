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
 * RestSearchResults
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class RestSearchResults {
  public static final String SERIALIZED_NAME_FACETS = "Facets";
  @SerializedName(SERIALIZED_NAME_FACETS)
  private List<TreeSearchFacet> facets;

  public static final String SERIALIZED_NAME_RESULTS = "Results";
  @SerializedName(SERIALIZED_NAME_RESULTS)
  private List<TreeNode> results;

  public static final String SERIALIZED_NAME_TOTAL = "Total";
  @SerializedName(SERIALIZED_NAME_TOTAL)
  private Integer total;

  public RestSearchResults() {
  }

  public RestSearchResults facets(List<TreeSearchFacet> facets) {
    this.facets = facets;
    return this;
  }

  public RestSearchResults addFacetsItem(TreeSearchFacet facetsItem) {
    if (this.facets == null) {
      this.facets = new ArrayList<>();
    }
    this.facets.add(facetsItem);
    return this;
  }

   /**
   * Get facets
   * @return facets
  **/
  @javax.annotation.Nullable
  public List<TreeSearchFacet> getFacets() {
    return facets;
  }

  public void setFacets(List<TreeSearchFacet> facets) {
    this.facets = facets;
  }


  public RestSearchResults results(List<TreeNode> results) {
    this.results = results;
    return this;
  }

  public RestSearchResults addResultsItem(TreeNode resultsItem) {
    if (this.results == null) {
      this.results = new ArrayList<>();
    }
    this.results.add(resultsItem);
    return this;
  }

   /**
   * Get results
   * @return results
  **/
  @javax.annotation.Nullable
  public List<TreeNode> getResults() {
    return results;
  }

  public void setResults(List<TreeNode> results) {
    this.results = results;
  }


  public RestSearchResults total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * Get total
   * @return total
  **/
  @javax.annotation.Nullable
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
    RestSearchResults restSearchResults = (RestSearchResults) o;
    return Objects.equals(this.facets, restSearchResults.facets) &&
        Objects.equals(this.results, restSearchResults.results) &&
        Objects.equals(this.total, restSearchResults.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facets, results, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSearchResults {\n");
    sb.append("    facets: ").append(toIndentedString(facets)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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
    openapiFields.add("Facets");
    openapiFields.add("Results");
    openapiFields.add("Total");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RestSearchResults
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RestSearchResults.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestSearchResults is not found in the empty JSON string", RestSearchResults.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RestSearchResults.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestSearchResults` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("Facets") != null && !jsonObj.get("Facets").isJsonNull()) {
        JsonArray jsonArrayfacets = jsonObj.getAsJsonArray("Facets");
        if (jsonArrayfacets != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Facets").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Facets` to be an array in the JSON string but got `%s`", jsonObj.get("Facets").toString()));
          }

          // validate the optional field `Facets` (array)
          for (int i = 0; i < jsonArrayfacets.size(); i++) {
            TreeSearchFacet.validateJsonElement(jsonArrayfacets.get(i));
          };
        }
      }
      if (jsonObj.get("Results") != null && !jsonObj.get("Results").isJsonNull()) {
        JsonArray jsonArrayresults = jsonObj.getAsJsonArray("Results");
        if (jsonArrayresults != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Results").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Results` to be an array in the JSON string but got `%s`", jsonObj.get("Results").toString()));
          }

          // validate the optional field `Results` (array)
          for (int i = 0; i < jsonArrayresults.size(); i++) {
            TreeNode.validateJsonElement(jsonArrayresults.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestSearchResults.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestSearchResults' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestSearchResults> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestSearchResults.class));

       return (TypeAdapter<T>) new TypeAdapter<RestSearchResults>() {
           @Override
           public void write(JsonWriter out, RestSearchResults value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestSearchResults read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestSearchResults given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestSearchResults
  * @throws IOException if the JSON string is invalid with respect to RestSearchResults
  */
  public static RestSearchResults fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestSearchResults.class);
  }

 /**
  * Convert an instance of RestSearchResults to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

