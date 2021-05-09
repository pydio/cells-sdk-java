package com.pydio.cells.api.callbacks;

import java.io.IOException;

public interface ServerResolver {

    String resolve(String id, boolean refresh) throws IOException;

}
