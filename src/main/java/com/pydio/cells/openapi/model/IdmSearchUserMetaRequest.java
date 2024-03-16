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
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * IdmSearchUserMetaRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class IdmSearchUserMetaRequest {
  public static final String SERIALIZED_NAME_META_UUIDS = "MetaUuids";
  @SerializedName(SERIALIZED_NAME_META_UUIDS)
  private List<String> metaUuids;

  public static final String SERIALIZED_NAME_NAMESPACE = "Namespace";
  @SerializedName(SERIALIZED_NAME_NAMESPACE)
  private String namespace;

  public static final String SERIALIZED_NAME_NODE_UUIDS = "NodeUuids";
  @SerializedName(SERIALIZED_NAME_NODE_UUIDS)
  private List<String> nodeUuids;

  public static final String SERIALIZED_NAME_RESOURCE_QUERY = "ResourceQuery";
  @SerializedName(SERIALIZED_NAME_RESOURCE_QUERY)
  private ServiceResourcePolicyQuery resourceQuery;

  public static final String SERIALIZED_NAME_RESOURCE_SUBJECT_OWNER = "ResourceSubjectOwner";
  @SerializedName(SERIALIZED_NAME_RESOURCE_SUBJECT_OWNER)
  private String resourceSubjectOwner;

  public IdmSearchUserMetaRequest() {
  }

  public IdmSearchUserMetaRequest metaUuids(List<String> metaUuids) {
    this.metaUuids = metaUuids;
    return this;
  }

  public IdmSearchUserMetaRequest addMetaUuidsItem(String metaUuidsItem) {
    if (this.metaUuids == null) {
      this.metaUuids = new ArrayList<>();
    }
    this.metaUuids.add(metaUuidsItem);
    return this;
  }

   /**
   * Get metaUuids
   * @return metaUuids
  **/
  @javax.annotation.Nullable
  public List<String> getMetaUuids() {
    return metaUuids;
  }

  public void setMetaUuids(List<String> metaUuids) {
    this.metaUuids = metaUuids;
  }


  public IdmSearchUserMetaRequest namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

   /**
   * Get namespace
   * @return namespace
  **/
  @javax.annotation.Nullable
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }


  public IdmSearchUserMetaRequest nodeUuids(List<String> nodeUuids) {
    this.nodeUuids = nodeUuids;
    return this;
  }

  public IdmSearchUserMetaRequest addNodeUuidsItem(String nodeUuidsItem) {
    if (this.nodeUuids == null) {
      this.nodeUuids = new ArrayList<>();
    }
    this.nodeUuids.add(nodeUuidsItem);
    return this;
  }

   /**
   * Get nodeUuids
   * @return nodeUuids
  **/
  @javax.annotation.Nullable
  public List<String> getNodeUuids() {
    return nodeUuids;
  }

  public void setNodeUuids(List<String> nodeUuids) {
    this.nodeUuids = nodeUuids;
  }


  public IdmSearchUserMetaRequest resourceQuery(ServiceResourcePolicyQuery resourceQuery) {
    this.resourceQuery = resourceQuery;
    return this;
  }

   /**
   * Get resourceQuery
   * @return resourceQuery
  **/
  @javax.annotation.Nullable
  public ServiceResourcePolicyQuery getResourceQuery() {
    return resourceQuery;
  }

  public void setResourceQuery(ServiceResourcePolicyQuery resourceQuery) {
    this.resourceQuery = resourceQuery;
  }


  public IdmSearchUserMetaRequest resourceSubjectOwner(String resourceSubjectOwner) {
    this.resourceSubjectOwner = resourceSubjectOwner;
    return this;
  }

   /**
   * Get resourceSubjectOwner
   * @return resourceSubjectOwner
  **/
  @javax.annotation.Nullable
  public String getResourceSubjectOwner() {
    return resourceSubjectOwner;
  }

  public void setResourceSubjectOwner(String resourceSubjectOwner) {
    this.resourceSubjectOwner = resourceSubjectOwner;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmSearchUserMetaRequest idmSearchUserMetaRequest = (IdmSearchUserMetaRequest) o;
    return Objects.equals(this.metaUuids, idmSearchUserMetaRequest.metaUuids) &&
        Objects.equals(this.namespace, idmSearchUserMetaRequest.namespace) &&
        Objects.equals(this.nodeUuids, idmSearchUserMetaRequest.nodeUuids) &&
        Objects.equals(this.resourceQuery, idmSearchUserMetaRequest.resourceQuery) &&
        Objects.equals(this.resourceSubjectOwner, idmSearchUserMetaRequest.resourceSubjectOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metaUuids, namespace, nodeUuids, resourceQuery, resourceSubjectOwner);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmSearchUserMetaRequest {\n");
    sb.append("    metaUuids: ").append(toIndentedString(metaUuids)).append("\n");
    sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
    sb.append("    nodeUuids: ").append(toIndentedString(nodeUuids)).append("\n");
    sb.append("    resourceQuery: ").append(toIndentedString(resourceQuery)).append("\n");
    sb.append("    resourceSubjectOwner: ").append(toIndentedString(resourceSubjectOwner)).append("\n");
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
    openapiFields.add("MetaUuids");
    openapiFields.add("Namespace");
    openapiFields.add("NodeUuids");
    openapiFields.add("ResourceQuery");
    openapiFields.add("ResourceSubjectOwner");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to IdmSearchUserMetaRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!IdmSearchUserMetaRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdmSearchUserMetaRequest is not found in the empty JSON string", IdmSearchUserMetaRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!IdmSearchUserMetaRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmSearchUserMetaRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      // ensure the optional json data is an array if present
      if (jsonObj.get("MetaUuids") != null && !jsonObj.get("MetaUuids").isJsonNull() && !jsonObj.get("MetaUuids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `MetaUuids` to be an array in the JSON string but got `%s`", jsonObj.get("MetaUuids").toString()));
      }
      if ((jsonObj.get("Namespace") != null && !jsonObj.get("Namespace").isJsonNull()) && !jsonObj.get("Namespace").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Namespace` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Namespace").toString()));
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("NodeUuids") != null && !jsonObj.get("NodeUuids").isJsonNull() && !jsonObj.get("NodeUuids").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `NodeUuids` to be an array in the JSON string but got `%s`", jsonObj.get("NodeUuids").toString()));
      }
      // validate the optional field `ResourceQuery`
      if (jsonObj.get("ResourceQuery") != null && !jsonObj.get("ResourceQuery").isJsonNull()) {
        ServiceResourcePolicyQuery.validateJsonElement(jsonObj.get("ResourceQuery"));
      }
      if ((jsonObj.get("ResourceSubjectOwner") != null && !jsonObj.get("ResourceSubjectOwner").isJsonNull()) && !jsonObj.get("ResourceSubjectOwner").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ResourceSubjectOwner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ResourceSubjectOwner").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdmSearchUserMetaRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdmSearchUserMetaRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdmSearchUserMetaRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdmSearchUserMetaRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<IdmSearchUserMetaRequest>() {
           @Override
           public void write(JsonWriter out, IdmSearchUserMetaRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdmSearchUserMetaRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdmSearchUserMetaRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdmSearchUserMetaRequest
  * @throws IOException if the JSON string is invalid with respect to IdmSearchUserMetaRequest
  */
  public static IdmSearchUserMetaRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdmSearchUserMetaRequest.class);
  }

 /**
  * Convert an instance of IdmSearchUserMetaRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

