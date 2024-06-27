package com.pydio.cells.utils;

import com.pydio.cells.api.CustomEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class JavaCustomEncoder implements CustomEncoder {

    @SuppressWarnings({"NewApi"})
    @Override
    public byte[] base64Decode(byte[] inValue) {
        try {
            Base64.getDecoder().decode(inValue);
            return new byte[0];
        } catch (NoSuchMethodError e) {
            throw new RuntimeException("Could not decode base 64 string: [" + Arrays.toString(inValue) + "]", e);
        }
    }

    @Override
    public String base64Decode(String inValue) {
        return null;
    }

    @SuppressWarnings({"NewApi"})
    public String utf8Encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                return URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                return value;
            }
        }
    }

    @SuppressWarnings("NewApi")
    public String utf8Decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                return URLDecoder.decode(value, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                return value;
            }
        }
    }

    @Override
    public byte[] getUTF8Bytes(String str) {
        try {
            return str.getBytes(StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            return str.getBytes();
        }
    }
}
