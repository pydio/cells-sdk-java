package com.pydio.sdk.generated.p8;

import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.callbacks.StringHandler;
import com.pydio.sdk.api.callbacks.TransferProgressListener;
import com.pydio.sdk.core.utils.IoHelpers;
import com.pydio.sdk.core.utils.Log;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Wraps the connection InputStream to ease implementation.
 * <p>
 * Upon creation we locally retrieve at max 512 bytes that we try to parse with Sax to insure
 * we do not have an error response: the Pydio 8 API returns an HTTP status 200 with an XML
 * error message in case something goes wrong.
 *
 * WARNING: this means that the connection is effectively opened upon P8Response instantiation.
 */
public class P8Response implements Closeable {

    private final HttpURLConnection con;
    private int code;

    private ByteArrayOutputStream buffered;
    private InputStream concatStream;
    private InputStream netStream;

    public static P8Response error(int code) {
        P8Response rsp = new P8Response();
        rsp.code = code;
        return rsp;
    }

    private P8Response() {
        con = null;
    }

    public P8Response(HttpURLConnection con) {
        this.con = con;
        try {
            code = ErrorCodes.fromHttpStatus(con.getResponseCode());
            if (code != ErrorCodes.ok) {
                return;
            }
            parseFirstBytes();

        } catch (IOException e) {
            Log.w("Unexpected runtime error", "Could not retrieve response code from connection: " + e.getMessage());
            e.printStackTrace();
            code = -1;
        }
    }

    public int code() {
        return code;
    }

    public List<String> getHeaders(String key) {
        try {
            return this.con.getHeaderFields().get(key);
        } catch (Exception e) {
            return null;
        }
    }

    public InputStream getInputStream() {
        if (concatStream == null) {
            // Concat already read bytes with the remaining ones from the original stream
            concatStream = new InputStream() {
                final InputStream buffered = new ByteArrayInputStream(P8Response.this.buffered.toByteArray());

                @Override
                public int read() throws IOException {
                    if (netStream == null) {
                        netStream = P8Response.this.con.getInputStream();
                    }
                    int read = buffered.read();
                    if (read == -1) {
                        read = netStream.read();
                    }
                    return read;
                }
            };
        }
        return concatStream;
    }

    /**
     * This workarounds the fact that errors are returned as XML and not with HTTP status by the
     * Pydio 8 API. We read the first 512 bytes (that is usually enough) and check if it is a known error message
     */
    private void parseFirstBytes() throws IOException {

        code = ErrorCodes.fromHttpStatus(con.getResponseCode());
        if (code != ErrorCodes.ok) {
            return;
        }

        buffered = new ByteArrayOutputStream();
        netStream = con.getInputStream();
        int left = 512, read;
        byte[] buffer = new byte[left];

        try {
            while (left > 0) {
                read = netStream.read(buffer);
                if (read == -1) {
                    break;
                }
                left -= read;
                if (read > 0) {
                    buffered.write(buffer, 0, read);
                }
            }

            buffer = buffered.toByteArray();
            String xmlString = new String(Arrays.copyOfRange(buffer, 0, buffer.length), StandardCharsets.UTF_8);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(xmlString)), new ErrorMessageHandler());

        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            String m = e.getMessage();
            if ("auth".equalsIgnoreCase(m)) {
                this.code = ErrorCodes.authentication_required;
            } else if ("token".equalsIgnoreCase(m)) {
                this.code = ErrorCodes.authentication_with_captcha_required;
            } else if (m.startsWith("redirect=")) {
                this.code = ErrorCodes.redirect;
            }
        }
    }

    public int saxParse(DefaultHandler handler) throws IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();

            // FIXME use temporary string to ease debugging.
            // String tmpStr = asString();
            // System.out.println("Before Sax parse, content is: " + tmpStr);
            // InputStream inputStream = new ByteArrayInputStream(tmpStr.getBytes());
            // parser.parse(new InputSource(inputStream), handler);
            parser.parse(new InputSource(getInputStream()), handler);

            return ErrorCodes.ok;
        } catch (ParserConfigurationException | SAXException e) {
            return ErrorCodes.internal_error;
        }
    }

    public Document toXMLDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream in = getInputStream();
            return builder.parse(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject toJSON() throws ParseException, IOException {
        return new JSONObject(asString());
    }

    public int lineByLine(String charset, String delimiter, StringHandler h) {
        InputStream in = getInputStream();
        Scanner sc = new Scanner(in, charset);
        sc.useDelimiter(delimiter);

        int lineCount = 0;
        while (true) {
            String line;
            try {
                line = sc.nextLine();
            } catch (NoSuchElementException e) {
                return lineCount;
            }

            if (line == null || "".equals(line)) {
                return lineCount;
            }

            lineCount++;
            h.onString(line);
        }
    }

    public long write(OutputStream out) throws IOException {
        return IoHelpers.pipeRead(getInputStream(), out);
    }

    public long write(OutputStream out, TransferProgressListener progressListener) throws IOException {
        return IoHelpers.pipeReadWithProgress(getInputStream(), out, (progress) -> {
            if (progressListener != null) {
                progressListener.onProgress(progress);
            }
        });
    }

    /**
     * Simply dumps the connection InputStream to a string
     */
    public String asString() throws IOException {
        StringBuilder builder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (getInputStream(), Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
        }

        return builder.toString();
    }

    @Override
    public void close() {

        if (netStream != null) {
            IoHelpers.quietlyClose(netStream);
        }

        if (concatStream != null) {
            IoHelpers.quietlyClose(concatStream);
        }
        try {
            con.disconnect();
        } catch (Exception ignore) {
            Log.w("Warning", "Could not correctly disconnect connection for P8Response");
        }
    }

    /* This is used to parse the beginning of the returned InputStream and check for API errors */
    private class ErrorMessageHandler extends DefaultHandler {

        boolean tag_auth = false;
        boolean tag_msg = false;

        boolean tag_repo = false;
        boolean xpathUser = false;
        boolean repoHasContent = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (tag_repo) {
                repoHasContent = true;
                return;
            }

            if (tag_auth) {
                if (qName.equals("message")) {
                    P8Response.this.code = ErrorCodes.authentication_required;
                    throw new SAXException("auth");
                    // throw new SAXException("Found error message ["+ attributes.getValue("message")+ "], breaking.");.");
                }
                return;
            }

            if (tag_msg) {
                return;
            }

            boolean registryPart = qName.equals("ajxp_registry_part") && attributes.getValue("xPath") != null;
            if (registryPart) {
                tag_repo = true;
                String attr = attributes.getValue("xPath");
                if (attr != null) {
                    String[] splits = attr.split("/");
                    xpathUser = "user".equals(splits[0]);
                }
            }

            tag_auth = qName.equals("require_auth");
            tag_msg = qName.equals("message");
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (tag_repo && xpathUser && !repoHasContent) {
                P8Response.this.code = ErrorCodes.authentication_required;
                throw new SAXException("auth");
            }

            if (tag_auth && qName.equals("require_auth")) {
                P8Response.this.code = ErrorCodes.authentication_required;
                throw new SAXException("auth");
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String str = new String(ch);
            if (tag_msg) {
                if (str.toLowerCase().contains("you are not allowed to access")) {
                    P8Response.this.code = ErrorCodes.authentication_required; //P8Client.this.auth_step = "RENEW-TOKEN";
                    throw new SAXException("token");
                }
            }
        }

        public void endDocument() {
        }
    }
}
