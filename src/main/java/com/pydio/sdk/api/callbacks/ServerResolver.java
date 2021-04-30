package com.pydio.sdk.api.callbacks;

import java.io.IOException;

public interface ServerResolver {

    String resolve(String id, boolean refresh) throws IOException;

}
