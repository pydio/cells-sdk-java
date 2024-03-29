package com.pydio.cells.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.callbacks.ProgressListener;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Legacy inherited static helpers to simplify implementation of stream related methods
 * and {@code Exception} management.
 */
public class IoHelpers {

    private static Gson gson = new Gson();

    public static int bufferSize = 4096;

    public static void consume(InputStream in) throws IOException {
        byte[] buffer = new byte[bufferSize];
        //noinspection StatementWithEmptyBody
        for (int read = 0; read != -1; read = in.read(buffer)) ;
    }

    public static void closeQuietly(InputStream in) {
        try {
            if (in != null) {
                in.close();
            }
        } catch (Exception ignored) {
        }
    }

    public static void closeQuietly(OutputStream out) {
        try {
            if (out != null) {
                out.close();
            }
        } catch (Exception ignored) {
        }
    }

    public static void closeQuietly(HttpURLConnection con) {
        try {
            if (con != null) {
                con.disconnect();
            }
        } catch (Exception ignored) {
        }
    }

    public static long pipeRead(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[bufferSize];
        long total_read = 0;
        for (int read = 0; read > -1; read = in.read(buffer)) {
            total_read += read;
            out.write(buffer, 0, read);
        }
        return total_read;
    }

    public static long write(byte[] bytes, OutputStream out) throws IOException {
        InputStream in = new ByteArrayInputStream(bytes);
        byte[] buffer = new byte[bufferSize];
        long total_read = 0;
        int read;
        for (; ; ) {
            read = in.read(buffer);
            if (read == -1)
                break;
            total_read += read;
            out.write(buffer, 0, read);
        }
        closeQuietly(in);
        return total_read;
    }

    public static long pipeReadWithIncrementalProgress(InputStream in, OutputStream out, @Nullable ProgressListener listener)
            throws IOException, SDKException {

        if (listener == null) {
            return pipeRead(in, out);
        }

        byte[] buffer = new byte[bufferSize];
        long total_read = 0;
        for (int read = 0; read > -1; read = in.read(buffer)) {
            total_read += read;
            out.write(buffer, 0, read);
            String cancelMsg = listener.onProgress(read);
            if (Str.notEmpty(cancelMsg)) {
                throw SDKException.cancel(cancelMsg);
            }
        }
        return total_read;
    }

    public static long pipeReadWithProgress(InputStream in, OutputStream out, @Nullable ProgressListener listener)
            throws IOException, SDKException {

        if (listener == null) {
            return pipeRead(in, out);
        }

        byte[] buffer = new byte[bufferSize];
        long total_read = 0;
        for (int read = 0; read > -1; read = in.read(buffer)) {
            total_read += read;
            out.write(buffer, 0, read);
            String cancelMsg = listener.onProgress(read);
            if (Str.notEmpty(cancelMsg)) {
                throw SDKException.cancel(cancelMsg);
            }
        }
        return total_read;
    }

    public static byte[] readFile(String path) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = new FileInputStream(path);
        byte[] buffer = new byte[bufferSize];
        // long total_read = 0;
        int read;
        for (; ; ) {
            read = in.read(buffer);
            if (read == -1)
                break;
            //  total_read += read;
            out.write(buffer, 0, read);
        }
        closeQuietly(in);
        return out.toByteArray();
    }

    public static long writeFile(byte[] bytes, String filepath) throws IOException {
        OutputStream out = new FileOutputStream(filepath);
        InputStream in = new ByteArrayInputStream(bytes);
        byte[] buffer = new byte[bufferSize];
        long total_read = 0;
        int read;
        for (; ; ) {
            read = in.read(buffer);
            if (read == -1)
                break;
            total_read += read;
            out.write(buffer, 0, read);
        }
        closeQuietly(out);
        return total_read;
    }

    public static long writeFile(InputStream in, String filepath) throws IOException {
        long total_read = 0;
        try (OutputStream out = new FileOutputStream(filepath)) {
            byte[] buffer = new byte[bufferSize];
            int read;
            for (; ; ) {
                read = in.read(buffer);
                if (read == -1)
                    break;
                total_read += read;
                out.write(buffer, 0, read);
            }
        }
        return total_read;
    }


    @SuppressWarnings("NewApi")
    public static Map<String, Object> fromJsonByteArray(ByteArrayOutputStream data) {

        String strValue;
        try {
            strValue = data.toString(StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                strValue = data.toString("utf-8");
            } catch (NoSuchMethodError | UnsupportedEncodingException e2) {
                strValue = data.toString();
            }
        }
        Type objType = new TypeToken<Map<String, Object>>() {
        }.getType();
        return gson.fromJson(strValue, objType);
    }

    public static Map<String, Object> fromJsonString(String data) {
        Type objType = new TypeToken<Map<String, Object>>() {
        }.getType();
        return gson.fromJson(data, objType);
    }

    @SuppressWarnings("NewApi")
    public static String toUtf8String(ByteArrayOutputStream data) {
        try {
            return data.toString(StandardCharsets.UTF_8);
        } catch (NoSuchMethodError e) {
            try {
                return data.toString("utf-8");
            } catch (NoSuchMethodError | UnsupportedEncodingException e2) {
                return data.toString();
            }
        }
    }
}
