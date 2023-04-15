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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * RestListPeersAddressesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class RestListPeersAddressesResponse {
  public static final String SERIALIZED_NAME_PEER_ADDRESSES = "PeerAddresses";
  @SerializedName(SERIALIZED_NAME_PEER_ADDRESSES)
  private List<String> peerAddresses;

  public RestListPeersAddressesResponse() {
  }

  public RestListPeersAddressesResponse peerAddresses(List<String> peerAddresses) {
    
    this.peerAddresses = peerAddresses;
    return this;
  }

  public RestListPeersAddressesResponse addPeerAddressesItem(String peerAddressesItem) {
    if (this.peerAddresses == null) {
      this.peerAddresses = new ArrayList<>();
    }
    this.peerAddresses.add(peerAddressesItem);
    return this;
  }

   /**
   * Get peerAddresses
   * @return peerAddresses
  **/
  @javax.annotation.Nullable

  public List<String> getPeerAddresses() {
    return peerAddresses;
  }


  public void setPeerAddresses(List<String> peerAddresses) {
    this.peerAddresses = peerAddresses;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestListPeersAddressesResponse restListPeersAddressesResponse = (RestListPeersAddressesResponse) o;
    return Objects.equals(this.peerAddresses, restListPeersAddressesResponse.peerAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(peerAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestListPeersAddressesResponse {\n");
    sb.append("    peerAddresses: ").append(toIndentedString(peerAddresses)).append("\n");
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
    openapiFields.add("PeerAddresses");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to RestListPeersAddressesResponse
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!RestListPeersAddressesResponse.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestListPeersAddressesResponse is not found in the empty JSON string", RestListPeersAddressesResponse.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!RestListPeersAddressesResponse.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestListPeersAddressesResponse` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("PeerAddresses") != null && !jsonObj.get("PeerAddresses").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `PeerAddresses` to be an array in the JSON string but got `%s`", jsonObj.get("PeerAddresses").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestListPeersAddressesResponse.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestListPeersAddressesResponse' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestListPeersAddressesResponse> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestListPeersAddressesResponse.class));

       return (TypeAdapter<T>) new TypeAdapter<RestListPeersAddressesResponse>() {
           @Override
           public void write(JsonWriter out, RestListPeersAddressesResponse value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestListPeersAddressesResponse read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestListPeersAddressesResponse given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestListPeersAddressesResponse
  * @throws IOException if the JSON string is invalid with respect to RestListPeersAddressesResponse
  */
  public static RestListPeersAddressesResponse fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestListPeersAddressesResponse.class);
  }

 /**
  * Convert an instance of RestListPeersAddressesResponse to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

