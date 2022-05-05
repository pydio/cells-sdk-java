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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.pydio.cells.openapi.model.TreeChangeLog;
import com.pydio.cells.openapi.model.TreeNodeType;
import com.pydio.cells.openapi.model.TreeWorkspaceRelativePath;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TreeNode
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-05T12:35:48.905699+02:00[Europe/Berlin]")
public class TreeNode {
  public static final String SERIALIZED_NAME_APPEARS_IN = "AppearsIn";
  @SerializedName(SERIALIZED_NAME_APPEARS_IN)
  private List<TreeWorkspaceRelativePath> appearsIn = null;

  public static final String SERIALIZED_NAME_COMMITS = "Commits";
  @SerializedName(SERIALIZED_NAME_COMMITS)
  private List<TreeChangeLog> commits = null;

  public static final String SERIALIZED_NAME_ETAG = "Etag";
  @SerializedName(SERIALIZED_NAME_ETAG)
  private String etag;

  public static final String SERIALIZED_NAME_MTIME = "MTime";
  @SerializedName(SERIALIZED_NAME_MTIME)
  private String mtime;

  public static final String SERIALIZED_NAME_META_STORE = "MetaStore";
  @SerializedName(SERIALIZED_NAME_META_STORE)
  private Map<String, String> metaStore = null;

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
      this.appearsIn = new ArrayList<TreeWorkspaceRelativePath>();
    }
    this.appearsIn.add(appearsInItem);
    return this;
  }

   /**
   * Get appearsIn
   * @return appearsIn
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

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
      this.commits = new ArrayList<TreeChangeLog>();
    }
    this.commits.add(commitsItem);
    return this;
  }

   /**
   * Get commits
   * @return commits
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
      this.metaStore = new HashMap<String, String>();
    }
    this.metaStore.put(key, metaStoreItem);
    return this;
  }

   /**
   * Get metaStore
   * @return metaStore
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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
  @ApiModelProperty(value = "")

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

}

