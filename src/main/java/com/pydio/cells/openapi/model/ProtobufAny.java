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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * &#x60;Any&#x60; contains an arbitrary serialized protocol buffer message along with a URL that describes the type of the serialized message.  Protobuf library provides support to pack/unpack Any values in the form of utility functions or additional generated methods of the Any type.  Example 1: Pack and unpack a message in C++.      Foo foo &#x3D; ...;     Any any;     any.PackFrom(foo);     ...     if (any.UnpackTo(&amp;foo)) {       ...     }  Example 2: Pack and unpack a message in Java.      Foo foo &#x3D; ...;     Any any &#x3D; Any.pack(foo);     ...     if (any.is(Foo.class)) {       foo &#x3D; any.unpack(Foo.class);     }  Example 3: Pack and unpack a message in Python.      foo &#x3D; Foo(...)     any &#x3D; Any()     any.Pack(foo)     ...     if any.Is(Foo.DESCRIPTOR):       any.Unpack(foo)       ...  Example 4: Pack and unpack a message in Go       foo :&#x3D; &amp;pb.Foo{...}      any, err :&#x3D; anypb.New(foo)      if err !&#x3D; nil {        ...      }      ...      foo :&#x3D; &amp;pb.Foo{}      if err :&#x3D; any.UnmarshalTo(foo); err !&#x3D; nil {        ...      }  The pack methods provided by protobuf library will by default use &#39;type.googleapis.com/full.type.name&#39; as the type URL and the unpack methods only use the fully qualified type name after the last &#39;/&#39; in the type URL, for example \&quot;foo.bar.com/x/y.z\&quot; will yield type name \&quot;y.z\&quot;.   JSON  The JSON representation of an &#x60;Any&#x60; value uses the regular representation of the deserialized, embedded message, with an additional field &#x60;@type&#x60; which contains the type URL. Example:      package google.profile;     message Person {       string first_name &#x3D; 1;       string last_name &#x3D; 2;     }      {       \&quot;@type\&quot;: \&quot;type.googleapis.com/google.profile.Person\&quot;,       \&quot;firstName\&quot;: &lt;string&gt;,       \&quot;lastName\&quot;: &lt;string&gt;     }  If the embedded message type is well-known and has a custom JSON representation, that representation will be embedded adding a field &#x60;value&#x60; which holds the custom JSON in addition to the &#x60;@type&#x60; field. Example (for message [google.protobuf.Duration][]):      {       \&quot;@type\&quot;: \&quot;type.googleapis.com/google.protobuf.Duration\&quot;,       \&quot;value\&quot;: \&quot;1.212s\&quot;     }
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-04-15T17:35:14.400736592+02:00[Europe/Berlin]")
public class ProtobufAny {
  public static final String SERIALIZED_NAME_AT_TYPE = "@type";
  @SerializedName(SERIALIZED_NAME_AT_TYPE)
  private String atType;

  public ProtobufAny() {
  }

  public ProtobufAny atType(String atType) {
    
    this.atType = atType;
    return this;
  }

   /**
   * A URL/resource name that uniquely identifies the type of the serialized protocol buffer message. This string must contain at least one \&quot;/\&quot; character. The last segment of the URL&#39;s path must represent the fully qualified name of the type (as in &#x60;path/google.protobuf.Duration&#x60;). The name should be in a canonical form (e.g., leading \&quot;.\&quot; is not accepted).  In practice, teams usually precompile into the binary all types that they expect it to use in the context of Any. However, for URLs which use the scheme &#x60;http&#x60;, &#x60;https&#x60;, or no scheme, one can optionally set up a type server that maps type URLs to message definitions as follows:  * If no scheme is provided, &#x60;https&#x60; is assumed. * An HTTP GET on the URL must yield a [google.protobuf.Type][]   value in binary format, or produce an error. * Applications are allowed to cache lookup results based on the   URL, or have them precompiled into a binary to avoid any   lookup. Therefore, binary compatibility needs to be preserved   on changes to types. (Use versioned type names to manage   breaking changes.)  Note: this functionality is not currently available in the official protobuf release, and it is not used for type URLs beginning with type.googleapis.com.  Schemes other than &#x60;http&#x60;, &#x60;https&#x60; (or the empty scheme) might be used with implementation specific semantics.
   * @return atType
  **/
  @javax.annotation.Nullable

  public String getAtType() {
    return atType;
  }


  public void setAtType(String atType) {
    this.atType = atType;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProtobufAny protobufAny = (ProtobufAny) o;
    return Objects.equals(this.atType, protobufAny.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProtobufAny {\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
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
    openapiFields.add("@type");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Object and throws an exception if issues found
  *
  * @param jsonObj JSON Object
  * @throws IOException if the JSON Object is invalid with respect to ProtobufAny
  */
  public static void validateJsonObject(JsonObject jsonObj) throws IOException {
      if (jsonObj == null) {
        if (!ProtobufAny.openapiRequiredFields.isEmpty()) { // has required fields but JSON object is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in ProtobufAny is not found in the empty JSON string", ProtobufAny.openapiRequiredFields.toString()));
        }
      }

      Set<Entry<String, JsonElement>> entries = jsonObj.entrySet();
      // check to see if the JSON string contains additional fields
      for (Entry<String, JsonElement> entry : entries) {
        if (!ProtobufAny.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `ProtobufAny` properties. JSON: %s", entry.getKey(), jsonObj.toString()));
        }
      }
      if ((jsonObj.get("@type") != null && !jsonObj.get("@type").isJsonNull()) && !jsonObj.get("@type").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `@type` to be a primitive type in the JSON string but got `%s`", jsonObj.get("@type").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!ProtobufAny.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'ProtobufAny' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<ProtobufAny> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(ProtobufAny.class));

       return (TypeAdapter<T>) new TypeAdapter<ProtobufAny>() {
           @Override
           public void write(JsonWriter out, ProtobufAny value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public ProtobufAny read(JsonReader in) throws IOException {
             JsonObject jsonObj = elementAdapter.read(in).getAsJsonObject();
             validateJsonObject(jsonObj);
             return thisAdapter.fromJsonTree(jsonObj);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of ProtobufAny given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of ProtobufAny
  * @throws IOException if the JSON string is invalid with respect to ProtobufAny
  */
  public static ProtobufAny fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, ProtobufAny.class);
  }

 /**
  * Convert an instance of ProtobufAny to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

