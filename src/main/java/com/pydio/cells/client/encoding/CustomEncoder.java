package com.pydio.cells.client.encoding;

import java.io.UnsupportedEncodingException;

public interface CustomEncoder {

    byte[] base64Encode(byte[] inValue);

    String base64Encode(String inValue);

    String utf8Encode(String value);

    String utf8Decode(String value);

    byte[] getUTF8Bytes(String str) throws UnsupportedEncodingException;

}



