package com.pydio.cells.transport.auth.jwt;

import com.google.gson.Gson;
import com.pydio.cells.client.encoding.Base64Encoder;

import java.text.ParseException;

public class IdToken {

    public Header header;
    public Claims claims;
    public String signature;

    public static IdToken parse(Base64Encoder decoder, String strJwt) throws ParseException {
        String[] parts = strJwt.split("\\.");
        if (parts.length != 3) {
            throw new ParseException("IdToken string cannot be parsed in 3 parts as expected", -1);
        }

        IdToken idToken = new IdToken();

        String headerStr = decoder.decode(parts[0]);
        idToken.header = new Gson().fromJson(headerStr, Header.class);

        String claimsStr = decoder.decode(parts[1]);
        idToken.claims = new Gson().fromJson(claimsStr, Claims.class);

        idToken.signature = parts[2];

        return idToken;
    }
}

