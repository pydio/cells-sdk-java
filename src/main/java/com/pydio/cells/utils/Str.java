package com.pydio.cells.utils;

/**
 * A few boiler plate helpers for conciseness while dealing with String objects
 */
public class Str {

    public static boolean empty(String value) {
        return  value == null || "".equals(value);
    }

    public static boolean notEmpty(String value) {
        return  value != null && !"".equals(value);
    }
}
