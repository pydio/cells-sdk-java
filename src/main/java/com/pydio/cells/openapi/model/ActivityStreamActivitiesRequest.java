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
 * ActivityStreamActivitiesRequest
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-03-16T11:01:01.368056162+01:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class ActivityStreamActivitiesRequest {
  public static final String SERIALIZED_NAME_AS_DIGEST = "AsDigest";
  @SerializedName(SERIALIZED_NAME_AS_DIGEST)
  private Boolean asDigest;

  public static final String SERIALIZED_NAME_BOX_NAME = "BoxName";
  @SerializedName(SERIALIZED_NAME_BOX_NAME)
  private String boxName;

  public static final String SERIALIZED_NAME_CONTEXT = "Context";
  @SerializedName(SERIALIZED_NAME_CONTEXT)
  private ActivityStreamContext context = ActivityStreamContext.MYFEED;

  public static final String SERIALIZED_NAME_CONTEXT_DATA = "ContextData";
  @SerializedName(SERIALIZED_NAME_CONTEXT_DATA)
  private String contextData;

  public static final String SERIALIZED_NAME_LANGUAGE = "Language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language;

  public static final String SERIALIZED_NAME_LIMIT = "Limit";
  @SerializedName(SERIALIZED_NAME_LIMIT)
  private String limit;

  public static final String SERIALIZED_NAME_OFFSET = "Offset";
  @SerializedName(SERIALIZED_NAME_OFFSET)
  private String offset;

  public static final String SERIALIZED_NAME_POINT_OF_VIEW = "PointOfView";
  @SerializedName(SERIALIZED_NAME_POINT_OF_VIEW)
  private ActivitySummaryPointOfView pointOfView = ActivitySummaryPointOfView.GENERIC;

  public static final String SERIALIZED_NAME_STREAM_FILTER = "StreamFilter";
  @SerializedName(SERIALIZED_NAME_STREAM_FILTER)
  private String streamFilter;

  public static final String SERIALIZED_NAME_UNREAD_COUNT_ONLY = "UnreadCountOnly";
  @SerializedName(SERIALIZED_NAME_UNREAD_COUNT_ONLY)
  private Boolean unreadCountOnly;

  public ActivityStreamActivitiesRequest() {
  }

  public ActivityStreamActivitiesRequest asDigest(Boolean asDigest) {
    this.asDigest = asDigest;
    return this;
  }

   /**
   * Get asDigest
   * @return asDigest
  **/
  @javax.annotation.Nullable
  public Boolean getAsDigest() {
    return asDigest;
  }

  public void setAsDigest(Boolean asDigest) {
    this.asDigest = asDigest;
  }


  public ActivityStreamActivitiesRequest boxName(String boxName) {
    this.boxName = boxName;
    return this;
  }

   /**
   * Get boxName
   * @return boxName
  **/
  @javax.annotation.Nullable
  public String getBoxName() {
    return boxName;
  }

  public void setBoxName(String boxName) {
    this.boxName = boxName;
  }


  public ActivityStreamActivitiesRequest context(ActivityStreamContext context) {
    this.context = context;
    return this;
  }

   /**
   * Get context
   * @return context
  **/
  @javax.annotation.Nullable
  public ActivityStreamContext getContext() {
    return context;
  }

  public void setContext(ActivityStreamContext context) {
    this.context = context;
  }


  public ActivityStreamActivitiesRequest contextData(String contextData) {
    this.contextData = contextData;
    return this;
  }

   /**
   * Get contextData
   * @return contextData
  **/
  @javax.annotation.Nullable
  public String getContextData() {
    return contextData;
  }

  public void setContextData(String contextData) {
    this.contextData = contextData;
  }


  public ActivityStreamActivitiesRequest language(String language) {
    this.language = language;
    return this;
  }

   /**
   * Provide language information for building the human-readable strings.
   * @return language
  **/
  @javax.annotation.Nullable
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }


  public ActivityStreamActivitiesRequest limit(String limit) {
    this.limit = limit;
    return this;
  }

   /**
   * Get limit
   * @return limit
  **/
  @javax.annotation.Nullable
  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }


  public ActivityStreamActivitiesRequest offset(String offset) {
    this.offset = offset;
    return this;
  }

   /**
   * Get offset
   * @return offset
  **/
  @javax.annotation.Nullable
  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }


  public ActivityStreamActivitiesRequest pointOfView(ActivitySummaryPointOfView pointOfView) {
    this.pointOfView = pointOfView;
    return this;
  }

   /**
   * Get pointOfView
   * @return pointOfView
  **/
  @javax.annotation.Nullable
  public ActivitySummaryPointOfView getPointOfView() {
    return pointOfView;
  }

  public void setPointOfView(ActivitySummaryPointOfView pointOfView) {
    this.pointOfView = pointOfView;
  }


  public ActivityStreamActivitiesRequest streamFilter(String streamFilter) {
    this.streamFilter = streamFilter;
    return this;
  }

   /**
   * Get streamFilter
   * @return streamFilter
  **/
  @javax.annotation.Nullable
  public String getStreamFilter() {
    return streamFilter;
  }

  public void setStreamFilter(String streamFilter) {
    this.streamFilter = streamFilter;
  }


  public ActivityStreamActivitiesRequest unreadCountOnly(Boolean unreadCountOnly) {
    this.unreadCountOnly = unreadCountOnly;
    return this;
  }

   /**
   * Get unreadCountOnly
   * @return unreadCountOnly
  **/
  @javax.annotation.Nullable
  public Boolean getUnreadCountOnly() {
    return unreadCountOnly;
  }

  public void setUnreadCountOnly(Boolean unreadCountOnly) {
    this.unreadCountOnly = unreadCountOnly;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityStreamActivitiesRequest activityStreamActivitiesRequest = (ActivityStreamActivitiesRequest) o;
    return Objects.equals(this.asDigest, activityStreamActivitiesRequest.asDigest) &&
        Objects.equals(this.boxName, activityStreamActivitiesRequest.boxName) &&
        Objects.equals(this.context, activityStreamActivitiesRequest.context) &&
        Objects.equals(this.contextData, activityStreamActivitiesRequest.contextData) &&
        Objects.equals(this.language, activityStreamActivitiesRequest.language) &&
        Objects.equals(this.limit, activityStreamActivitiesRequest.limit) &&
        Objects.equals(this.offset, activityStreamActivitiesRequest.offset) &&
        Objects.equals(this.pointOfView, activityStreamActivitiesRequest.pointOfView) &&
        Objects.equals(this.streamFilter, activityStreamActivitiesRequest.streamFilter) &&
        Objects.equals(this.unreadCountOnly, activityStreamActivitiesRequest.unreadCountOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asDigest, boxName, context, contextData, language, limit, offset, pointOfView, streamFilter, unreadCountOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityStreamActivitiesRequest {\n");
    sb.append("    asDigest: ").append(toIndentedString(asDigest)).append("\n");
    sb.append("    boxName: ").append(toIndentedString(boxName)).append("\n");
    sb.append("    context: ").append(toIndentedString(context)).append("\n");
    sb.append("    contextData: ").append(toIndentedString(contextData)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    pointOfView: ").append(toIndentedString(pointOfView)).append("\n");
    sb.append("    streamFilter: ").append(toIndentedString(streamFilter)).append("\n");
    sb.append("    unreadCountOnly: ").append(toIndentedString(unreadCountOnly)).append("\n");
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
    openapiFields.add("AsDigest");
    openapiFields.add("BoxName");
    openapiFields.add("Context");
    openapiFields.add("ContextData");
    openapiFields.add("Language");
    openapiFields.add("Limit");
    openapiFields.add("Offset");
    openapiFields.add("PointOfView");
    openapiFields.add("StreamFilter");
    openapiFields.add("UnreadCountOnly");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to ActivityStreamActivitiesRequest
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!ActivityStreamActivitiesRequest.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ActivityStreamActivitiesRequest is not found in the empty JSON string", ActivityStreamActivitiesRequest.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!ActivityStreamActivitiesRequest.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ActivityStreamActivitiesRequest` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("BoxName") != null && !jsonObj.get("BoxName").isJsonNull()) && !jsonObj.get("BoxName").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `BoxName` to be a primitive type in the JSON string but got `%s`", jsonObj.get("BoxName").toString()));
      }
      // validate the optional field `Context`
      if (jsonObj.get("Context") != null && !jsonObj.get("Context").isJsonNull()) {
        ActivityStreamContext.validateJsonElement(jsonObj.get("Context"));
      }
      if ((jsonObj.get("ContextData") != null && !jsonObj.get("ContextData").isJsonNull()) && !jsonObj.get("ContextData").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `ContextData` to be a primitive type in the JSON string but got `%s`", jsonObj.get("ContextData").toString()));
      }
      if ((jsonObj.get("Language") != null && !jsonObj.get("Language").isJsonNull()) && !jsonObj.get("Language").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Language` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Language").toString()));
      }
      if ((jsonObj.get("Limit") != null && !jsonObj.get("Limit").isJsonNull()) && !jsonObj.get("Limit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Limit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Limit").toString()));
      }
      if ((jsonObj.get("Offset") != null && !jsonObj.get("Offset").isJsonNull()) && !jsonObj.get("Offset").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `Offset` to be a primitive type in the JSON string but got `%s`", jsonObj.get("Offset").toString()));
      }
      // validate the optional field `PointOfView`
      if (jsonObj.get("PointOfView") != null && !jsonObj.get("PointOfView").isJsonNull()) {
        ActivitySummaryPointOfView.validateJsonElement(jsonObj.get("PointOfView"));
      }
      if ((jsonObj.get("StreamFilter") != null && !jsonObj.get("StreamFilter").isJsonNull()) && !jsonObj.get("StreamFilter").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `StreamFilter` to be a primitive type in the JSON string but got `%s`", jsonObj.get("StreamFilter").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ActivityStreamActivitiesRequest.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ActivityStreamActivitiesRequest' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ActivityStreamActivitiesRequest> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ActivityStreamActivitiesRequest.class));

       return (TypeAdapter<T>) new TypeAdapter<ActivityStreamActivitiesRequest>() {
           @Override
           public void write(JsonWriter out, ActivityStreamActivitiesRequest value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ActivityStreamActivitiesRequest read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ActivityStreamActivitiesRequest given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ActivityStreamActivitiesRequest
  * @throws IOException if the JSON string is invalid with respect to ActivityStreamActivitiesRequest
  */
  public static ActivityStreamActivitiesRequest fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ActivityStreamActivitiesRequest.class);
  }

 /**
  * Convert an instance of ActivityStreamActivitiesRequest to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

