package com.pydio.sdk.core.common.callback;

import java.io.IOException;

public interface ServerResolver {
	String resolve(String id, boolean refresh) throws IOException;
}
