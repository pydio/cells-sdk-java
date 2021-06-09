package com.pydio.cells.api;

public interface IServerFactory {

    /**
     * Tries to contact a Pydio server at the given URL and returns the Server type (namely P8 or Cells) if found
     *
     * @param serverURL
     * @return
     * @throws SDKException
     */
    String checkServer(ServerURL serverURL) throws SDKException;


    /**
     * Caches the server object to be then easily retrieved with its url
     *
     * @param serverURL
     * @return
     * @throws SDKException
     */
    Server register(ServerURL serverURL) throws SDKException;


    /**
     * Register an account with the provided credentials.
     * The factory can then provide Transport objects with the corresponding AccountId
     *
     * @param serverURL
     * @param credentials
     * @throws SDKException
     */
    void registerAccount(ServerURL serverURL, Credentials credentials) throws SDKException;

    /**
     * Cleanly unregister an account, among others, this deletes the relate tokens from the token store.
     *
     * @param accountID
     * @throws SDKException
     */
    void unregisterAccount(String accountID) throws SDKException;

    /**
     * Simply get a well-configured transport for this account.
     * {@code registerAccount()} must have been called before at leat once.
     *
     * @param accountId
     * @return
     * @throws SDKException
     */
    Transport getTransport(String accountId) throws SDKException;

    //  Transport getTransport(String login, ServerURL serverURL) throws SDKException;

    /**
     * Until we find a better option, it is the factory responsibility to provide an encoder
     * that fits with the current runtime (typically Android or plain Java).
     *
     * @return
     */
    CustomEncoder getEncoder();
}
