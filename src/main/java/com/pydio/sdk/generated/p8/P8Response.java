package com.pydio.sdk.generated.p8;

import com.pydio.sdk.api.ErrorCodes;
import com.pydio.sdk.api.callbacks.StringHandler;
import com.pydio.sdk.api.callbacks.TransferProgressListener;
import com.pydio.sdk.core.utils.io;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
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

import static java.nio.charset.StandardCharsets.UTF_8;

public class P8Response implements Closeable {

    private int code;
    private InputStream concatStream;
    private InputStream netStream;
    private HttpURLConnection con;
    private ByteArrayOutputStream buffered;

    public static P8Response error(int code) {
        P8Response rsp = new P8Response();
        rsp.code = code;
        return rsp;
    }

    private P8Response() {
    }

    public P8Response(HttpURLConnection con) {
        this.con = con;
        try {
            parse();
        } catch (IOException e) {
            code = ErrorCodes.con_failed;
        }
    }

    private void parse() throws IOException {
        code = ErrorCodes.fromHttpStatus(con.getResponseCode());
        if (code != ErrorCodes.ok) {
            return;
        }

        buffered = new ByteArrayOutputStream();
        netStream = con.getInputStream();
        int read = -1;
        int left = 512;
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
            String xmlString = new String(Arrays.copyOfRange(buffer, 0, buffer.length), UTF_8);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new RegistryHandler();
            parser.parse(new InputSource(new StringReader(xmlString)), handler);
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
        } catch (Exception ignored) {
        }
    }

    private InputStream getInputStream() {
        if (concatStream == null) {
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

    public InputStream getContent() {
        return getInputStream();
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

    public JSONObject toJSON() throws ParseException {
        return new JSONObject(asString());
    }

    public Document toXMLDocument() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            InputStream in = con.getInputStream();
            return builder.parse(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Simply dump the outstream in a string as shortcut when the expected answer should be shorter than...
     */
    public String asString() {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            InputStream in = getInputStream();
            io.pipeRead(in, out);
            byte[] buffer = out.toByteArray();
            return new String(buffer, UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {

        return asString();

//        System.out.println("###### TO STRING CALLED");
//        Thread.dumpStack();
//        return super.toString();
        //  ByteArrayOutputStream out = new ByteArrayOutputStream();
        //  InputStream in = getInputStream();
        //  try {
        //      io.pipeRead(in, out);
        //  } catch (IOException e) {
        //      e.printStackTrace();
        //      return null;
        //  }
//
        //  byte[] buffer = out.toByteArray();
        //  String charset = "UTF-8";
        //  try {
        //      return new String(buffer, charset);
        //  } catch (UnsupportedEncodingException e) {
        //      return new String(buffer);
        //  }
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

    public int saxParse(DefaultHandler handler) {
        String content = asString();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new InputSource(new StringReader(content)), handler);
            return ErrorCodes.ok;
        } catch (Exception e) {
            return ErrorCodes.unexpected_content;
        }
    }

    public long write(OutputStream out) throws IOException {
        return io.pipeRead(getContent(), out);
    }

    public long write(OutputStream out, TransferProgressListener progressListener) throws IOException {
        return io.pipeReadWithProgress(getContent(), out, (progress) -> {
            if (progressListener != null) {
                progressListener.onProgress(progress);
            }
        });
    }

    @Override
    public void close() {
        io.consume(this.netStream);

        try {
            this.con.disconnect();
        } catch (Exception ignore) {
        }

        if (netStream != null) {
            io.close(netStream);
        }

        if (concatStream != null) {
            io.close(concatStream);
        }
    }


    private class RegistryHandler extends DefaultHandler {

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
                P8Response.this.code = ErrorCodes.authentication_required;//P8Client.this.auth_step = "LOG-USER";
                throw new SAXException("auth");
            }

            if (tag_auth && qName.equals("require_auth")) {
                P8Response.this.code = ErrorCodes.authentication_required;//P8Client.this.auth_step = "LOG-USER";
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
