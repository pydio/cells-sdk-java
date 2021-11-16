package com.pydio.cells.api;

import java.io.InputStream;

public interface ILegacyTransport extends Transport {

    InputStream getCaptcha() throws SDKException;

    boolean useCaptcha();

}
