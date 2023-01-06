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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Workspace is composed of a set of nodes UUIDs and is used to provide accesses to the tree via ACLs.
 */
@ApiModel(description = "A Workspace is composed of a set of nodes UUIDs and is used to provide accesses to the tree via ACLs.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-01-06T14:22:40.613083+01:00[Europe/Berlin]")
public class IdmWorkspace {
  public static final String SERIALIZED_NAME_ATTRIBUTES = "Attributes";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
  private String attributes;

  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_LAST_UPDATED = "LastUpdated";
  @SerializedName(SERIALIZED_NAME_LAST_UPDATED)
  private Integer lastUpdated;

  public static final String SERIALIZED_NAME_POLICIES = "Policies";
  @SerializedName(SERIALIZED_NAME_POLICIES)
  private List<ServiceResourcePolicy> policies = null;

  public static final String SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE = "PoliciesContextEditable";
  @SerializedName(SERIALIZED_NAME_POLICIES_CONTEXT_EDITABLE)
  private Boolean policiesContextEditable;

  public static final String SERIALIZED_NAME_ROOT_NODES = "RootNodes";
  @SerializedName(SERIALIZED_NAME_ROOT_NODES)
  private Map<String, TreeNode> rootNodes = null;

  public static final String SERIALIZED_NAME_ROOT_U_U_I_DS = "RootUUIDs";
  @SerializedName(SERIALIZED_NAME_ROOT_U_U_I_DS)
  private List<String> rootUUIDs = null;

  public static final String SERIALIZED_NAME_SCOPE = "Scope";
  @SerializedName(SERIALIZED_NAME_SCOPE)
  private IdmWorkspaceScope scope = IdmWorkspaceScope.ANY;

  public static final String SERIALIZED_NAME_SLUG = "Slug";
  @SerializedName(SERIALIZED_NAME_SLUG)
  private String slug;

  public static final String SERIALIZED_NAME_U_U_I_D = "UUID";
  @SerializedName(SERIALIZED_NAME_U_U_I_D)
  private String UUID;

  public IdmWorkspace() {
  }

  public IdmWorkspace attributes(String attributes) {
    
    this.attributes = attributes;
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getAttributes() {
    return attributes;
  }


  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }


  public IdmWorkspace description(String description) {
    
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }


  public IdmWorkspace label(String label) {
    
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getLabel() {
    return label;
  }


  public void setLabel(String label) {
    this.label = label;
  }


  public IdmWorkspace lastUpdated(Integer lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Integer getLastUpdated() {
    return lastUpdated;
  }


  public void setLastUpdated(Integer lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public IdmWorkspace policies(List<ServiceResourcePolicy> policies) {
    
    this.policies = policies;
    return this;
  }

  public IdmWorkspace addPoliciesItem(ServiceResourcePolicy policiesItem) {
    if (this.policies == null) {
      this.policies = new ArrayList<>();
    }
    this.policies.add(policiesItem);
    return this;
  }

   /**
   * Get policies
   * @return policies
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<ServiceResourcePolicy> getPolicies() {
    return policies;
  }


  public void setPolicies(List<ServiceResourcePolicy> policies) {
    this.policies = policies;
  }


  public IdmWorkspace policiesContextEditable(Boolean policiesContextEditable) {
    
    this.policiesContextEditable = policiesContextEditable;
    return this;
  }

   /**
   * Get policiesContextEditable
   * @return policiesContextEditable
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Boolean getPoliciesContextEditable() {
    return policiesContextEditable;
  }


  public void setPoliciesContextEditable(Boolean policiesContextEditable) {
    this.policiesContextEditable = policiesContextEditable;
  }


  public IdmWorkspace rootNodes(Map<String, TreeNode> rootNodes) {
    
    this.rootNodes = rootNodes;
    return this;
  }

  public IdmWorkspace putRootNodesItem(String key, TreeNode rootNodesItem) {
    if (this.rootNodes == null) {
      this.rootNodes = new HashMap<>();
    }
    this.rootNodes.put(key, rootNodesItem);
    return this;
  }

   /**
   * Get rootNodes
   * @return rootNodes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public Map<String, TreeNode> getRootNodes() {
    return rootNodes;
  }


  public void setRootNodes(Map<String, TreeNode> rootNodes) {
    this.rootNodes = rootNodes;
  }


  public IdmWorkspace rootUUIDs(List<String> rootUUIDs) {
    
    this.rootUUIDs = rootUUIDs;
    return this;
  }

  public IdmWorkspace addRootUUIDsItem(String rootUUIDsItem) {
    if (this.rootUUIDs == null) {
      this.rootUUIDs = new ArrayList<>();
    }
    this.rootUUIDs.add(rootUUIDsItem);
    return this;
  }

   /**
   * Get rootUUIDs
   * @return rootUUIDs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public List<String> getRootUUIDs() {
    return rootUUIDs;
  }


  public void setRootUUIDs(List<String> rootUUIDs) {
    this.rootUUIDs = rootUUIDs;
  }


  public IdmWorkspace scope(IdmWorkspaceScope scope) {
    
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public IdmWorkspaceScope getScope() {
    return scope;
  }


  public void setScope(IdmWorkspaceScope scope) {
    this.scope = scope;
  }


  public IdmWorkspace slug(String slug) {
    
    this.slug = slug;
    return this;
  }

   /**
   * Get slug
   * @return slug
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getSlug() {
    return slug;
  }


  public void setSlug(String slug) {
    this.slug = slug;
  }


  public IdmWorkspace UUID(String UUID) {
    
    this.UUID = UUID;
    return this;
  }

   /**
   * Get UUID
   * @return UUID
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public String getUUID() {
    return UUID;
  }


  public void setUUID(String UUID) {
    this.UUID = UUID;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdmWorkspace idmWorkspace = (IdmWorkspace) o;
    return Objects.equals(this.attributes, idmWorkspace.attributes) &&
        Objects.equals(this.description, idmWorkspace.description) &&
        Objects.equals(this.label, idmWorkspace.label) &&
        Objects.equals(this.lastUpdated, idmWorkspace.lastUpdated) &&
        Objects.equals(this.policies, idmWorkspace.policies) &&
        Objects.equals(this.policiesContextEditable, idmWorkspace.policiesContextEditable) &&
        Objects.equals(this.rootNodes, idmWorkspace.rootNodes) &&
        Objects.equals(this.rootUUIDs, idmWorkspace.rootUUIDs) &&
        Objects.equals(this.scope, idmWorkspace.scope) &&
        Objects.equals(this.slug, idmWorkspace.slug) &&
        Objects.equals(this.UUID, idmWorkspace.UUID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, description, label, lastUpdated, policies, policiesContextEditable, rootNodes, rootUUIDs, scope, slug, UUID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdmWorkspace {\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
    sb.append("    policiesContextEditable: ").append(toIndentedString(policiesContextEditable)).append("\n");
    sb.append("    rootNodes: ").append(toIndentedString(rootNodes)).append("\n");
    sb.append("    rootUUIDs: ").append(toIndentedString(rootUUIDs)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    UUID: ").append(toIndentedString(UUID)).append("\n");
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
    openapiFields.add("Attributes");
    openapiFields.add("Description");
    openapiFields.add("Label");
    openapiFields.add("LastUpdated");
    openapiFields.add("Policies");
    openapiFields.add("PoliciesContextEditable");
    openapiFields.add("RootNodes");
    openapiFields.add("RootUUIDs");
    openapiFields.add("Scope");
    openapiFields.add("Slug");
    openapiFields.add("UUID");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to IdmWorkspace
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!IdmWorkspace.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in IdmWorkspace is not found in the empty JSON string", IdmWorkspace.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!IdmWorkspace.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `IdmWorkspace` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("Attributes") != null && !jsonObj.get("Attributes").isJsonNull()) && !jsonObj.get("Attributes").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Attributes` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Attributes").toString()));
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
      if (jsonObj.get("Policies") != null && !jsonObj.get("Policies").isJsonNull()) {
        JsonArray jsonArraypolicies = jsonObj.getAsJsonArray("Policies");
        if (jsonArraypolicies != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Policies").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Policies` to be an array in the JSON string but got `%s`", jsonObj.get("Policies").toString()));
          }

          // validate the optional field `Policies` (array)
          for (int i = 0; i < jsonArraypolicies.size(); i++) {
            ServiceResourcePolicy.validateJsonObject(jsonArraypolicies.get(i).getAsJsonObject());
          };
        }
      }
      // ensure the optional json data is an array if present
      if (jsonObj.get("RootUUIDs") != null && !jsonObj.get("RootUUIDs").isJsonArray()) {
        throw new IllegalArgumentException(String.format("Expected the field `RootUUIDs` to be an array in the JSON string but got `%s`", jsonObj.get("RootUUIDs").toString()));
      }
      if ((jsonObj.get("Slug") != null && !jsonObj.get("Slug").isJsonNull()) && !jsonObj.get("Slug").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Slug` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Slug").toString()));
      }
      if ((jsonObj.get("UUID") != null && !jsonObj.get("UUID").isJsonNull()) && !jsonObj.get("UUID").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `UUID` to be a primitive type in the JSON string but got `%s`", jsonObj.get("UUID").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!IdmWorkspace.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'IdmWorkspace' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<IdmWorkspace> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(IdmWorkspace.class));

       return (TypeAdapter<T>) new TypeAdapter<IdmWorkspace>() {
           @Override
           public void write(JsonWriter out, IdmWorkspace value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public IdmWorkspace read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of IdmWorkspace given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of IdmWorkspace
  * @throws IOException if the JSON string is invalid with respect to IdmWorkspace
  */
  public static IdmWorkspace fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, IdmWorkspace.class);
  }

 /**
  * Convert an instance of IdmWorkspace to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

