package com.pydio.cells.api;

import java.net.HttpURLConnection;

/**
 * Enriches the base Transport interface with new methods
 * that are not meant to ever be supported by the legacy Pydio 8
 */
public interface ICellsTransport extends Transport {

    HttpURLConnection withAuth(HttpURLConnection con) throws SDKException;
}
