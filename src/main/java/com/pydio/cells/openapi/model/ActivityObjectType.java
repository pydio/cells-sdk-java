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

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Gets or Sets activityObjectType
 */
@JsonAdapter(ActivityObjectType.Adapter.class)
public enum ActivityObjectType {

    BASE_OBJECT("BaseObject"),

    ACTIVITY("Activity"),

    LINK("Link"),

    MENTION("Mention"),

    COLLECTION("Collection"),

    ORDERED_COLLECTION("OrderedCollection"),

    COLLECTION_PAGE("CollectionPage"),

    ORDERED_COLLECTION_PAGE("OrderedCollectionPage"),

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

    TENTATIVE_REJECT("TentativeReject"),

    TENTATIVE_ACCEPT("TentativeAccept"),

    TRAVEL("Travel"),

    UNDO("Undo"),

    UPDATE("Update"),

    UPDATE_COMMENT("UpdateComment"),

    UPDATE_META("UpdateMeta"),

    VIEW("View"),

    WORKSPACE("Workspace"),

    DIGEST("Digest"),

    FOLDER("Folder"),

    CELL("Cell"),

    SHARE("Share");

    private final String value;

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

    public static ActivityObjectType fromValue(String value) {
        for (ActivityObjectType b : ActivityObjectType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<ActivityObjectType> {
        @Override
        public void write(final JsonWriter jsonWriter, final ActivityObjectType enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public ActivityObjectType read(final JsonReader jsonReader) throws IOException {
            String value = jsonReader.nextString();
            return ActivityObjectType.fromValue(value);
        }
    }

    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        String value = jsonElement.getAsString();
        ActivityObjectType.fromValue(value);
    }
}

