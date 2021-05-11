package com.pydio.cells.api;

public interface IServerFactory {

    Server register(ServerURL serverURL) throws SDKException;

    String checkServer(ServerURL serverURL) throws SDKException;

    Transport registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException;

    Transport getSession(String login, ServerURL serverURL) throws SDKException;

}
