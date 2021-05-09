package com.pydio.cells.sync.content;

import com.pydio.cells.sync.Error;

import java.io.IOException;
import java.io.InputStream;

public interface Content {

    Error getError();

    String getMd5();

    long getSize();

    boolean exists();

    InputStream getInputStream() throws IOException;
}
