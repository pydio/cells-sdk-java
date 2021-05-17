package com.pydio.cells.client.auth.jwt;

import com.google.gson.Gson;
import com.pydio.cells.client.encoding.B64;

import java.text.ParseException;

public class JWT {

    public Header header;
    public Claims claims;
    public String signature;

    public static JWT parse(String strJwt) throws ParseException {
        String[] parts = strJwt.split("\\.");
        if (parts.length != 3) {
            throw new ParseException("JWT string cannot be parsed in 3 parts as expected", -1);
        }

        JWT jwt = new JWT();
//        jwt.claims = new Claims();
//        jwt.header = new Header();

        String headerStr = B64.get().decode(parts[0]);
        jwt.header = new Gson().fromJson(headerStr, Header.class);

        String claimsStr = B64.get().decode(parts[1]);
        jwt.claims = new Gson().fromJson(claimsStr, Claims.class);

        jwt.signature = parts[2];

        return jwt;
    }
}

