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

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RestMetaNamespaceRequest1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-05-09T15:35:02.533763+02:00[Europe/Berlin]")
public class RestMetaNamespaceRequest1 {
    public static final String SERIALIZED_NAME_NAMESPACE = "Namespace";
    @SerializedName(SERIALIZED_NAME_NAMESPACE)
    private List<String> namespace = null;

    public RestMetaNamespaceRequest1() {
    }

    public RestMetaNamespaceRequest1 namespace(List<String> namespace) {

        this.namespace = namespace;
        return this;
    }

    public RestMetaNamespaceRequest1 addNamespaceItem(String namespaceItem) {
        if (this.namespace == null) {
            this.namespace = new ArrayList<String>();
        }
        this.namespace.add(namespaceItem);
        return this;
    }

    /**
     * Get namespace
     *
     * @return namespace
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public List<String> getNamespace() {
        return namespace;
    }


    public void setNamespace(List<String> namespace) {
        this.namespace = namespace;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RestMetaNamespaceRequest1 restMetaNamespaceRequest1 = (RestMetaNamespaceRequest1) o;
        return Objects.equals(this.namespace, restMetaNamespaceRequest1.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMetaNamespaceRequest1 {\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
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

