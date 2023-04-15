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

/**
 * TreeNode
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class TreeNode {
  public static final String SERIALIZED_NAME_APPEARS_IN = "AppearsIn";
  @SerializedName(SERIALIZED_NAME_APPEARS_IN)
  private List<TreeWorkspaceRelativePath> appearsIn;

  public static final String SERIALIZED_NAME_COMMITS = "Commits";
  @SerializedName(SERIALIZED_NAME_COMMITS)
  private List<TreeChangeLog> commits;

  public static final String SERIALIZED_NAME_ETAG = "Etag";
  @SerializedName(SERIALIZED_NAME_ETAG)
  private String etag;

  public static final String SERIALIZED_NAME_MTIME = "MTime";
  @SerializedName(SERIALIZED_NAME_MTIME)
  private String mtime;

  public static final String SERIALIZED_NAME_META_STORE = "MetaStore";
  @SerializedName(SERIALIZED_NAME_META_STORE)
  private Map<String, String> metaStore = new HashMap<>();

  public static final String SERIALIZED_NAME_MODE = "Mode";
  @SerializedName(SERIALIZED_NAME_MODE)
  private Integer mode;

  public static final String SERIALIZED_NAME_PATH = "Path";
  @SerializedName(SERIALIZED_NAME_PATH)
  private String path;

  public static final String SERIALIZED_NAME_SIZE = "Size";
  @SerializedName(SERIALIZED_NAME_SIZE)
  private String size;

  public static final String SERIALIZED_NAME_TYPE = "Type";
  @SerializedName(SERIALIZED_NAME_TYPE)
  private TreeNodeType type = TreeNodeType.UNKNOWN;

  public static final String SERIALIZED_NAME_UUID = "Uuid";
  @SerializedName(SERIALIZED_NAME_UUID)
  private String uuid;

  public TreeNode() {
  }

  public TreeNode appearsIn(List<TreeWorkspaceRelativePath> appearsIn) {
    
    this.appearsIn = appearsIn;
    return this;
  }

  public TreeNode addAppearsInItem(TreeWorkspaceRelativePath appearsInItem) {
    if (this.appearsIn == null) {
      this.appearsIn = new ArrayList<>();
    }
    this.appearsIn.add(appearsInItem);
    return this;
  }

   /**
   * Get appearsIn
   * @return appearsIn
  **/
  @javax.annotation.Nullable

  public List<TreeWorkspaceRelativePath> getAppearsIn() {
    return appearsIn;
  }


  public void setAppearsIn(List<TreeWorkspaceRelativePath> appearsIn) {
    this.appearsIn = appearsIn;
  }


  public TreeNode commits(List<TreeChangeLog> commits) {
    
    this.commits = commits;
    return this;
  }

  public TreeNode addCommitsItem(TreeChangeLog commitsItem) {
    if (this.commits == null) {
      this.commits = new ArrayList<>();
    }
    this.commits.add(commitsItem);
    return this;
  }

   /**
   * Get commits
   * @return commits
  **/
  @javax.annotation.Nullable

  public List<TreeChangeLog> getCommits() {
    return commits;
  }


  public void setCommits(List<TreeChangeLog> commits) {
    this.commits = commits;
  }


  public TreeNode etag(String etag) {
    
    this.etag = etag;
    return this;
  }

   /**
   * Get etag
   * @return etag
  **/
  @javax.annotation.Nullable

  public String getEtag() {
    return etag;
  }


  public void setEtag(String etag) {
    this.etag = etag;
  }


  public TreeNode mtime(String mtime) {
    
    this.mtime = mtime;
    return this;
  }

   /**
   * Get mtime
   * @return mtime
  **/
  @javax.annotation.Nullable

  public String getMtime() {
    return mtime;
  }


  public void setMtime(String mtime) {
    this.mtime = mtime;
  }


  public TreeNode metaStore(Map<String, String> metaStore) {
    
    this.metaStore = metaStore;
    return this;
  }

  public TreeNode putMetaStoreItem(String key, String metaStoreItem) {
    if (this.metaStore == null) {
      this.metaStore = new HashMap<>();
    }
    this.metaStore.put(key, metaStoreItem);
    return this;
  }

   /**
   * Get metaStore
   * @return metaStore
  **/
  @javax.annotation.Nullable

  public Map<String, String> getMetaStore() {
    return metaStore;
  }


  public void setMetaStore(Map<String, String> metaStore) {
    this.metaStore = metaStore;
  }


  public TreeNode mode(Integer mode) {
    
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @javax.annotation.Nullable

  public Integer getMode() {
    return mode;
  }


  public void setMode(Integer mode) {
    this.mode = mode;
  }


  public TreeNode path(String path) {
    
    this.path = path;
    return this;
  }

   /**
   * Get path
   * @return path
  **/
  @javax.annotation.Nullable

  public String getPath() {
    return path;
  }


  public void setPath(String path) {
    this.path = path;
  }


  public TreeNode size(String size) {
    
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @javax.annotation.Nullable

  public String getSize() {
    return size;
  }


  public void setSize(String size) {
    this.size = size;
  }


  public TreeNode type(TreeNodeType type) {
    
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @javax.annotation.Nullable

  public TreeNodeType getType() {
    return type;
  }


  public void setType(TreeNodeType type) {
    this.type = type;
  }


  public TreeNode uuid(String uuid) {
    
    this.uuid = uuid;
    return this;
  }

   /**
   * Get uuid
   * @return uuid
  **/
  @javax.annotation.Nullable

  public String getUuid() {
    return uuid;
  }


  public void setUuid(String uuid) {
    this.uuid = uuid;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeNode treeNode = (TreeNode) o;
    return Objects.equals(this.appearsIn, treeNode.appearsIn) &&
        Objects.equals(this.commits, treeNode.commits) &&
        Objects.equals(this.etag, treeNode.etag) &&
        Objects.equals(this.mtime, treeNode.mtime) &&
        Objects.equals(this.metaStore, treeNode.metaStore) &&
        Objects.equals(this.mode, treeNode.mode) &&
        Objects.equals(this.path, treeNode.path) &&
        Objects.equals(this.size, treeNode.size) &&
        Objects.equals(this.type, treeNode.type) &&
        Objects.equals(this.uuid, treeNode.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appearsIn, commits, etag, mtime, metaStore, mode, path, size, type, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeNode {\n");
    sb.append("    appearsIn: ").append(toIndentedString(appearsIn)).append("\n");
    sb.append("    commits: ").append(toIndentedString(commits)).append("\n");
    sb.append("    etag: ").append(toIndentedString(etag)).append("\n");
    sb.append("    mtime: ").append(toIndentedString(mtime)).append("\n");
    sb.append("    metaStore: ").append(toIndentedString(metaStore)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
    openapiFields.add("AppearsIn");
    openapiFields.add("Commits");
    openapiFields.add("Etag");
    openapiFields.add("MTime");
    openapiFields.add("MetaStore");
    openapiFields.add("Mode");
    openapiFields.add("Path");
    openapiFields.add("Size");
    openapiFields.add("Type");
    openapiFields.add("Uuid");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to TreeNode
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!TreeNode.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in TreeNode is not found in the empty JSON string", TreeNode.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!TreeNode.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `TreeNode` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if (jsonObj.get("AppearsIn") != null && !jsonObj.get("AppearsIn").isJsonNull()) {
        JsonArray jsonArrayappearsIn = jsonObj.getAsJsonArray("AppearsIn");
        if (jsonArrayappearsIn != null) {
          // ensure the json data is an array
          if (!jsonObj.get("AppearsIn").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `AppearsIn` to be an array in the JSON string but got `%s`", jsonObj.get("AppearsIn").toString()));
          }

          // validate the optional field `AppearsIn` (array)
          for (int i = 0; i < jsonArrayappearsIn.size(); i++) {
            TreeWorkspaceRelativePath.validateJsonObject(jsonArrayappearsIn.get(i).getAsJsonObject());
          };
        }
      }
      if (jsonObj.get("Commits") != null && !jsonObj.get("Commits").isJsonNull()) {
        JsonArray jsonArraycommits = jsonObj.getAsJsonArray("Commits");
        if (jsonArraycommits != null) {
          // ensure the json data is an array
          if (!jsonObj.get("Commits").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `Commits` to be an array in the JSON string but got `%s`", jsonObj.get("Commits").toString()));
          }

          // validate the optional field `Commits` (array)
          for (int i = 0; i < jsonArraycommits.size(); i++) {
            TreeChangeLog.validateJsonObject(jsonArraycommits.get(i).getAsJsonObject());
          };
        }
      }
      if ((jsonObj.get("Etag") != null && !jsonObj.get("Etag").isJsonNull()) && !jsonObj.get("Etag").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Etag` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Etag").toString()));
      }
      if ((jsonObj.get("MTime") != null && !jsonObj.get("MTime").isJsonNull()) && !jsonObj.get("MTime").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `MTime` to be a primitive type in the JSON string but got `%s`", jsonObj.get("MTime").toString()));
      }
      if ((jsonObj.get("Path") != null && !jsonObj.get("Path").isJsonNull()) && !jsonObj.get("Path").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Path` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Path").toString()));
      }
      if ((jsonObj.get("Size") != null && !jsonObj.get("Size").isJsonNull()) && !jsonObj.get("Size").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Size` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Size").toString()));
      }
      if ((jsonObj.get("Uuid") != null && !jsonObj.get("Uuid").isJsonNull()) && !jsonObj.get("Uuid").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Uuid` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Uuid").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!TreeNode.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'TreeNode' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<TreeNode> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(TreeNode.class));

       return (TypeAdapter<T>) new TypeAdapter<TreeNode>() {
           @Override
           public void write(JsonWriter out, TreeNode value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public TreeNode read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of TreeNode given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of TreeNode
  * @throws IOException if the JSON string is invalid with respect to TreeNode
  */
  public static TreeNode fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, TreeNode.class);
  }

 /**
  * Convert an instance of TreeNode to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

