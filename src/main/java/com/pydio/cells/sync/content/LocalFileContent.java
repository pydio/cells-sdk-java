package com.pydio.cells.sync.content;

import com.pydio.cells.sync.Error;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LocalFileContent implements Content {

    private final File file;
    private Error error;

    public LocalFileContent(String path) {
        this.file = new File(path);
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public Error getError() {
        return error;
    }

    @Override
    public String getMd5() {
        return md5(file.getPath());
    }

    @Override
    public long getSize() {
        return file.length();
    }

    @Override
    public boolean exists() {
        return file != null && file.exists();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    private String md5(String path) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");

            FileInputStream fis = new FileInputStream(path);

            byte[] dataBytes = new byte[1024];

            int nread;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            byte[] mdbytes = md.digest();

            //convert the byte to hex format method 1
            /* StringBuilder sb = new StringBuilder();
            for (byte mdbyte : mdbytes) {
                sb.append(Integer.toString((mdbyte & 0xff) + 0x100, 16).substring(1));
            } */
            //convert the byte to hex format method 2
            StringBuilder hexString = new StringBuilder();
            for (byte mdbyte : mdbytes) {
                String hex = Integer.toHexString(0xff & mdbyte);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            //Log.e("Runtime", e.getMessage());
        } catch (IOException e) {
            //Log.e("IO", e.getMessage());
        }
        return "";
    }
}
