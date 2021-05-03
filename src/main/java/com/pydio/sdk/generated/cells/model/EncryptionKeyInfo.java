/*
 * Pydio Cells Rest API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.pydio.sdk.generated.cells.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * EncryptionKeyInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-04-23T18:11:59.271+02:00")



public class EncryptionKeyInfo {
  @SerializedName("Exports")
  private List<com.pydio.sdk.generated.cells.model.EncryptionExport> exports = null;

  @SerializedName("Imports")
  private List<com.pydio.sdk.generated.cells.model.EncryptionImport> imports = null;

  public EncryptionKeyInfo exports(List<com.pydio.sdk.generated.cells.model.EncryptionExport> exports) {
    this.exports = exports;
    return this;
  }

  public EncryptionKeyInfo addExportsItem(com.pydio.sdk.generated.cells.model.EncryptionExport exportsItem) {
    if (this.exports == null) {
      this.exports = new ArrayList<com.pydio.sdk.generated.cells.model.EncryptionExport>();
    }
    this.exports.add(exportsItem);
    return this;
  }

   /**
   * Get exports
   * @return exports
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.EncryptionExport> getExports() {
    return exports;
  }

  public void setExports(List<EncryptionExport> exports) {
    this.exports = exports;
  }

  public EncryptionKeyInfo imports(List<com.pydio.sdk.generated.cells.model.EncryptionImport> imports) {
    this.imports = imports;
    return this;
  }

  public EncryptionKeyInfo addImportsItem(com.pydio.sdk.generated.cells.model.EncryptionImport importsItem) {
    if (this.imports == null) {
      this.imports = new ArrayList<com.pydio.sdk.generated.cells.model.EncryptionImport>();
    }
    this.imports.add(importsItem);
    return this;
  }

   /**
   * Get imports
   * @return imports
  **/
  @ApiModelProperty(value = "")
  public List<com.pydio.sdk.generated.cells.model.EncryptionImport> getImports() {
    return imports;
  }

  public void setImports(List<EncryptionImport> imports) {
    this.imports = imports;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EncryptionKeyInfo encryptionKeyInfo = (EncryptionKeyInfo) o;
    return Objects.equals(this.exports, encryptionKeyInfo.exports) &&
        Objects.equals(this.imports, encryptionKeyInfo.imports);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exports, imports);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EncryptionKeyInfo {\n");
    
    sb.append("    exports: ").append(toIndentedString(exports)).append("\n");
    sb.append("    imports: ").append(toIndentedString(imports)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
