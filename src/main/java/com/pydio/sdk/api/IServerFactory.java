package com.pydio.sdk.api;

public interface IServerFactory {

    String TYPE_CELLS = "cells";
    String TYPE_LEGACY_P8 = "pydio";

    Server register(ServerURL serverURL) throws SDKException;

    String checkServer(ServerURL serverURL) throws SDKException;

    ISession registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException;

    ISession getSession(ServerURL serverURL, String login) throws SDKException;

}
