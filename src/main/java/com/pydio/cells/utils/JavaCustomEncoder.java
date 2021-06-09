package com.pydio.cells.utils;

import com.pydio.cells.api.CustomEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.util.Base64;

public class JavaCustomEncoder implements CustomEncoder {

    @SuppressWarnings("NewApi")
    @Override
    public byte[] base64Encode(byte[] inValue) {
        Base64.getEncoder().encode(inValue);
        return inValue;
    }

    @Override
    public String base64Encode(String inValue) {
        return new String(base64Encode(inValue.getBytes()));
    }

    @Override
    public byte[] base64Decode(byte[] inValue) {
        Base64.getDecoder().decode(inValue);

        return new byte[0];
    }

    @Override
    public String base64Decode(String inValue) {
        return null;
    }

    @Override
    public String utf8Encode(String value) {
        // TODO this method throws an exception in android context but not in the sdk-java, why ?
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected encoding issue", e);
        }
    }

    @Override
    public String utf8Decode(String value) {
        // TODO this method throws an exception in android context but not in the sdk-java, why ?
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unexpected decoding issue", e);
        }
        //return super.utf8Encode(value);
    }

    @Override
    public byte[] getUTF8Bytes(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }
}

