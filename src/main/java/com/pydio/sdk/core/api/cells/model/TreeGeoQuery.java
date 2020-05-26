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


package com.pydio.sdk.core.api.cells.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * TreeGeoQuery
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-30T14:51:15.861Z")
public class TreeGeoQuery {
  @SerializedName("Center")
  private TreeGeoPoint center = null;

  @SerializedName("Distance")
  private String distance = null;

  @SerializedName("TopLeft")
  private TreeGeoPoint topLeft = null;

  @SerializedName("BottomRight")
  private TreeGeoPoint bottomRight = null;

  public TreeGeoQuery center(TreeGeoPoint center) {
    this.center = center;
    return this;
  }

   /**
   * Get center
   * @return center
  **/
  @ApiModelProperty(value = "")
  public TreeGeoPoint getCenter() {
    return center;
  }

  public void setCenter(TreeGeoPoint center) {
    this.center = center;
  }

  public TreeGeoQuery distance(String distance) {
    this.distance = distance;
    return this;
  }

   /**
   * Example formats supported: \&quot;5in\&quot; \&quot;5inch\&quot; \&quot;7yd\&quot; \&quot;7yards\&quot; \&quot;9ft\&quot; \&quot;9feet\&quot; \&quot;11km\&quot; \&quot;11kilometers\&quot; \&quot;3nm\&quot; \&quot;3nauticalmiles\&quot; \&quot;13mm\&quot; \&quot;13millimeters\&quot; \&quot;15cm\&quot; \&quot;15centimeters\&quot; \&quot;17mi\&quot; \&quot;17miles\&quot; \&quot;19m\&quot; \&quot;19meters\&quot; If the unit cannot be determined, the entire string is parsed and the unit of meters is assumed.
   * @return distance
  **/
  @ApiModelProperty(value = "Example formats supported: \"5in\" \"5inch\" \"7yd\" \"7yards\" \"9ft\" \"9feet\" \"11km\" \"11kilometers\" \"3nm\" \"3nauticalmiles\" \"13mm\" \"13millimeters\" \"15cm\" \"15centimeters\" \"17mi\" \"17miles\" \"19m\" \"19meters\" If the unit cannot be determined, the entire string is parsed and the unit of meters is assumed.")
  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  public TreeGeoQuery topLeft(TreeGeoPoint topLeft) {
    this.topLeft = topLeft;
    return this;
  }

   /**
   * Get topLeft
   * @return topLeft
  **/
  @ApiModelProperty(value = "")
  public TreeGeoPoint getTopLeft() {
    return topLeft;
  }

  public void setTopLeft(TreeGeoPoint topLeft) {
    this.topLeft = topLeft;
  }

  public TreeGeoQuery bottomRight(TreeGeoPoint bottomRight) {
    this.bottomRight = bottomRight;
    return this;
  }

   /**
   * Get bottomRight
   * @return bottomRight
  **/
  @ApiModelProperty(value = "")
  public TreeGeoPoint getBottomRight() {
    return bottomRight;
  }

  public void setBottomRight(TreeGeoPoint bottomRight) {
    this.bottomRight = bottomRight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeGeoQuery treeGeoQuery = (TreeGeoQuery) o;
    return Objects.equals(this.center, treeGeoQuery.center) &&
        Objects.equals(this.distance, treeGeoQuery.distance) &&
        Objects.equals(this.topLeft, treeGeoQuery.topLeft) &&
        Objects.equals(this.bottomRight, treeGeoQuery.bottomRight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(center, distance, topLeft, bottomRight);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TreeGeoQuery {\n");
    
    sb.append("    center: ").append(toIndentedString(center)).append("\n");
    sb.append("    distance: ").append(toIndentedString(distance)).append("\n");
    sb.append("    topLeft: ").append(toIndentedString(topLeft)).append("\n");
    sb.append("    bottomRight: ").append(toIndentedString(bottomRight)).append("\n");
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

