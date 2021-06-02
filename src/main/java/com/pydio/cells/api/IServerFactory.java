package com.pydio.cells.api;

import com.pydio.cells.client.encoding.CustomEncoder;

public interface IServerFactory {

    Server register(ServerURL serverURL) throws SDKException;

    String checkServer(ServerURL serverURL) throws SDKException;

    Transport registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException;

    Transport getTransport(String login, ServerURL serverURL) throws SDKException;

    CustomEncoder getEncoder();

}
