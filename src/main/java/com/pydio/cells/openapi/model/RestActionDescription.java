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
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RestActionDescription
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class RestActionDescription {
  public static final String SERIALIZED_NAME_CATEGORY = "Category";
  @SerializedName(SERIALIZED_NAME_CATEGORY)
  private String category;

  public static final String SERIALIZED_NAME_DESCRIPTION = "Description";
  @SerializedName(SERIALIZED_NAME_DESCRIPTION)
  private String description;

  public static final String SERIALIZED_NAME_FORM_MODULE = "FormModule";
  @SerializedName(SERIALIZED_NAME_FORM_MODULE)
  private String formModule;

  public static final String SERIALIZED_NAME_FORM_MODULE_PROPS = "FormModuleProps";
  @SerializedName(SERIALIZED_NAME_FORM_MODULE_PROPS)
  private String formModuleProps;

  public static final String SERIALIZED_NAME_HAS_FORM = "HasForm";
  @SerializedName(SERIALIZED_NAME_HAS_FORM)
  private Boolean hasForm;

  public static final String SERIALIZED_NAME_ICON = "Icon";
  @SerializedName(SERIALIZED_NAME_ICON)
  private String icon;

  public static final String SERIALIZED_NAME_INPUT_DESCRIPTION = "InputDescription";
  @SerializedName(SERIALIZED_NAME_INPUT_DESCRIPTION)
  private String inputDescription;

  public static final String SERIALIZED_NAME_IS_INTERNAL = "IsInternal";
  @SerializedName(SERIALIZED_NAME_IS_INTERNAL)
  private Boolean isInternal;

  public static final String SERIALIZED_NAME_LABEL = "Label";
  @SerializedName(SERIALIZED_NAME_LABEL)
  private String label;

  public static final String SERIALIZED_NAME_NAME = "Name";
  @SerializedName(SERIALIZED_NAME_NAME)
  private String name;

  public static final String SERIALIZED_NAME_OUTPUT_DESCRIPTION = "OutputDescription";
  @SerializedName(SERIALIZED_NAME_OUTPUT_DESCRIPTION)
  private String outputDescription;

  public static final String SERIALIZED_NAME_SUMMARY_TEMPLATE = "SummaryTemplate";
  @SerializedName(SERIALIZED_NAME_SUMMARY_TEMPLATE)
  private String summaryTemplate;

  public static final String SERIALIZED_NAME_TINT = "Tint";
  @SerializedName(SERIALIZED_NAME_TINT)
  private String tint;

  public RestActionDescription() {
  }

  public RestActionDescription category(String category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @javax.annotation.Nullable
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  public RestActionDescription description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @javax.annotation.Nullable
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public RestActionDescription formModule(String formModule) {
    this.formModule = formModule;
    return this;
  }

   /**
   * Get formModule
   * @return formModule
  **/
  @javax.annotation.Nullable
  public String getFormModule() {
    return formModule;
  }

  public void setFormModule(String formModule) {
    this.formModule = formModule;
  }


  public RestActionDescription formModuleProps(String formModuleProps) {
    this.formModuleProps = formModuleProps;
    return this;
  }

   /**
   * Get formModuleProps
   * @return formModuleProps
  **/
  @javax.annotation.Nullable
  public String getFormModuleProps() {
    return formModuleProps;
  }

  public void setFormModuleProps(String formModuleProps) {
    this.formModuleProps = formModuleProps;
  }


  public RestActionDescription hasForm(Boolean hasForm) {
    this.hasForm = hasForm;
    return this;
  }

   /**
   * Get hasForm
   * @return hasForm
  **/
  @javax.annotation.Nullable
  public Boolean getHasForm() {
    return hasForm;
  }

  public void setHasForm(Boolean hasForm) {
    this.hasForm = hasForm;
  }


  public RestActionDescription icon(String icon) {
    this.icon = icon;
    return this;
  }

   /**
   * Get icon
   * @return icon
  **/
  @javax.annotation.Nullable
  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public RestActionDescription inputDescription(String inputDescription) {
    this.inputDescription = inputDescription;
    return this;
  }

   /**
   * Get inputDescription
   * @return inputDescription
  **/
  @javax.annotation.Nullable
  public String getInputDescription() {
    return inputDescription;
  }

  public void setInputDescription(String inputDescription) {
    this.inputDescription = inputDescription;
  }


  public RestActionDescription isInternal(Boolean isInternal) {
    this.isInternal = isInternal;
    return this;
  }

   /**
   * If action is declared internal, it is hidden to avoid polluting the list.
   * @return isInternal
  **/
  @javax.annotation.Nullable
  public Boolean getIsInternal() {
    return isInternal;
  }

  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }


  public RestActionDescription label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Get label
   * @return label
  **/
  @javax.annotation.Nullable
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public RestActionDescription name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @javax.annotation.Nullable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public RestActionDescription outputDescription(String outputDescription) {
    this.outputDescription = outputDescription;
    return this;
  }

   /**
   * Get outputDescription
   * @return outputDescription
  **/
  @javax.annotation.Nullable
  public String getOutputDescription() {
    return outputDescription;
  }

  public void setOutputDescription(String outputDescription) {
    this.outputDescription = outputDescription;
  }


  public RestActionDescription summaryTemplate(String summaryTemplate) {
    this.summaryTemplate = summaryTemplate;
    return this;
  }

   /**
   * Get summaryTemplate
   * @return summaryTemplate
  **/
  @javax.annotation.Nullable
  public String getSummaryTemplate() {
    return summaryTemplate;
  }

  public void setSummaryTemplate(String summaryTemplate) {
    this.summaryTemplate = summaryTemplate;
  }


  public RestActionDescription tint(String tint) {
    this.tint = tint;
    return this;
  }

   /**
   * Get tint
   * @return tint
  **/
  @javax.annotation.Nullable
  public String getTint() {
    return tint;
  }

  public void setTint(String tint) {
    this.tint = tint;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestActionDescription restActionDescription = (RestActionDescription) o;
    return Objects.equals(this.category, restActionDescription.category) &&
        Objects.equals(this.description, restActionDescription.description) &&
        Objects.equals(this.formModule, restActionDescription.formModule) &&
        Objects.equals(this.formModuleProps, restActionDescription.formModuleProps) &&
        Objects.equals(this.hasForm, restActionDescription.hasForm) &&
        Objects.equals(this.icon, restActionDescription.icon) &&
        Objects.equals(this.inputDescription, restActionDescription.inputDescription) &&
        Objects.equals(this.isInternal, restActionDescription.isInternal) &&
        Objects.equals(this.label, restActionDescription.label) &&
        Objects.equals(this.name, restActionDescription.name) &&
        Objects.equals(this.outputDescription, restActionDescription.outputDescription) &&
        Objects.equals(this.summaryTemplate, restActionDescription.summaryTemplate) &&
        Objects.equals(this.tint, restActionDescription.tint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, formModule, formModuleProps, hasForm, icon, inputDescription, isInternal, label, name, outputDescription, summaryTemplate, tint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestActionDescription {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    formModule: ").append(toIndentedString(formModule)).append("\n");
    sb.append("    formModuleProps: ").append(toIndentedString(formModuleProps)).append("\n");
    sb.append("    hasForm: ").append(toIndentedString(hasForm)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
    sb.append("    inputDescription: ").append(toIndentedString(inputDescription)).append("\n");
    sb.append("    isInternal: ").append(toIndentedString(isInternal)).append("\n");
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    outputDescription: ").append(toIndentedString(outputDescription)).append("\n");
    sb.append("    summaryTemplate: ").append(toIndentedString(summaryTemplate)).append("\n");
    sb.append("    tint: ").append(toIndentedString(tint)).append("\n");
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
    openapiFields.add("Category");
    openapiFields.add("Description");
    openapiFields.add("FormModule");
    openapiFields.add("FormModuleProps");
    openapiFields.add("HasForm");
    openapiFields.add("Icon");
    openapiFields.add("InputDescription");
    openapiFields.add("IsInternal");
    openapiFields.add("Label");
    openapiFields.add("Name");
    openapiFields.add("OutputDescription");
    openapiFields.add("SummaryTemplate");
    openapiFields.add("Tint");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to RestActionDescription
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!RestActionDescription.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in RestActionDescription is not found in the empty JSON string", RestActionDescription.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!RestActionDescription.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `RestActionDescription` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("Category") != null && !jsonObj.get("Category").isJsonNull()) && !jsonObj.get("Category").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Category` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Category").toString()));
      }
      if ((jsonObj.get("Description") != null && !jsonObj.get("Description").isJsonNull()) && !jsonObj.get("Description").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Description` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Description").toString()));
      }
      if ((jsonObj.get("FormModule") != null && !jsonObj.get("FormModule").isJsonNull()) && !jsonObj.get("FormModule").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `FormModule` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FormModule").toString()));
      }
      if ((jsonObj.get("FormModuleProps") != null && !jsonObj.get("FormModuleProps").isJsonNull()) && !jsonObj.get("FormModuleProps").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `FormModuleProps` to be a primitive type in the JSON string but got `%s`", jsonObj.get("FormModuleProps").toString()));
      }
      if ((jsonObj.get("Icon") != null && !jsonObj.get("Icon").isJsonNull()) && !jsonObj.get("Icon").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Icon` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Icon").toString()));
      }
      if ((jsonObj.get("InputDescription") != null && !jsonObj.get("InputDescription").isJsonNull()) && !jsonObj.get("InputDescription").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `InputDescription` to be a primitive type in the JSON string but got `%s`", jsonObj.get("InputDescription").toString()));
      }
      if ((jsonObj.get("Label") != null && !jsonObj.get("Label").isJsonNull()) && !jsonObj.get("Label").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Label` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Label").toString()));
      }
      if ((jsonObj.get("Name") != null && !jsonObj.get("Name").isJsonNull()) && !jsonObj.get("Name").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Name").toString()));
      }
      if ((jsonObj.get("OutputDescription") != null && !jsonObj.get("OutputDescription").isJsonNull()) && !jsonObj.get("OutputDescription").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `OutputDescription` to be a primitive type in the JSON string but got `%s`", jsonObj.get("OutputDescription").toString()));
      }
      if ((jsonObj.get("SummaryTemplate") != null && !jsonObj.get("SummaryTemplate").isJsonNull()) && !jsonObj.get("SummaryTemplate").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `SummaryTemplate` to be a primitive type in the JSON string but got `%s`", jsonObj.get("SummaryTemplate").toString()));
      }
      if ((jsonObj.get("Tint") != null && !jsonObj.get("Tint").isJsonNull()) && !jsonObj.get("Tint").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Tint` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Tint").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!RestActionDescription.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'RestActionDescription' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<RestActionDescription> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(RestActionDescription.class));

       return (TypeAdapter<T>) new TypeAdapter<RestActionDescription>() {
           @Override
           public void write(JsonWriter out, RestActionDescription value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public RestActionDescription read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of RestActionDescription given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of RestActionDescription
  * @throws IOException if the JSON string is invalid with respect to RestActionDescription
  */
  public static RestActionDescription fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, RestActionDescription.class);
  }

 /**
  * Convert an instance of RestActionDescription to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

