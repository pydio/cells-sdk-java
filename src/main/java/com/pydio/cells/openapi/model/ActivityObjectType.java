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


package com.pydio.cells.openapi.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets activityObjectType
 */
@JsonAdapter(ActivityObjectType.Adapter.class)
public enum ActivityObjectType {
  
  BASEOBJECT("BaseObject"),
  
  ACTIVITY("Activity"),
  
  LINK("Link"),
  
  MENTION("Mention"),
  
  COLLECTION("Collection"),
  
  ORDEREDCOLLECTION("OrderedCollection"),
  
  COLLECTIONPAGE("CollectionPage"),
  
  ORDEREDCOLLECTIONPAGE("OrderedCollectionPage"),
  
  APPLICATION("Application"),
  
  GROUP("Group"),
  
  ORGANIZATION("Organization"),
  
  PERSON("Person"),
  
  SERVICE("Service"),
  
  ARTICLE("Article"),
  
  AUDIO("Audio"),
  
  DOCUMENT("Document"),
  
  EVENT("Event"),
  
  IMAGE("Image"),
  
  NOTE("Note"),
  
  PAGE("Page"),
  
  PLACE("Place"),
  
  PROFILE("Profile"),
  
  RELATIONSHIP("Relationship"),
  
  TOMBSTONE("Tombstone"),
  
  VIDEO("Video"),
  
  ACCEPT("Accept"),
  
  ADD("Add"),
  
  ANNOUNCE("Announce"),
  
  ARRIVE("Arrive"),
  
  BLOCK("Block"),
  
  CREATE("Create"),
  
  DELETE("Delete"),
  
  DISLIKE("Dislike"),
  
  FLAG("Flag"),
  
  FOLLOW("Follow"),
  
  IGNORE("Ignore"),
  
  INVITE("Invite"),
  
  JOIN("Join"),
  
  LEAVE("Leave"),
  
  LIKE("Like"),
  
  LISTEN("Listen"),
  
  MOVE("Move"),
  
  OFFER("Offer"),
  
  QUESTION("Question"),
  
  REJECT("Reject"),
  
  READ("Read"),
  
  REMOVE("Remove"),
  
  TENTATIVEREJECT("TentativeReject"),
  
  TENTATIVEACCEPT("TentativeAccept"),
  
  TRAVEL("Travel"),
  
  UNDO("Undo"),
  
  UPDATE("Update"),
  
  UPDATECOMMENT("UpdateComment"),
  
  UPDATEMETA("UpdateMeta"),
  
  VIEW("View"),
  
  WORKSPACE("Workspace"),
  
  DIGEST("Digest"),
  
  FOLDER("Folder"),
  
  CELL("Cell"),
  
  SHARE("Share");

  private String value;

  ActivityObjectType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static ActivityObjectType fromValue(String text) {
    for (ActivityObjectType b : ActivityObjectType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public static class Adapter extends TypeAdapter<ActivityObjectType> {
    @Override
    public void write(final JsonWriter jsonWriter, final ActivityObjectType enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public ActivityObjectType read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return ActivityObjectType.fromValue(String.valueOf(value));
    }
  }
}

