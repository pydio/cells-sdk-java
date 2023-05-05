package com.pydio.cells.transport.auth;

import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Store;
import com.pydio.cells.transport.StateID;

import java.util.Map;

/**
 * Wraps a token store to add the feature to refresh tokens from password when
 * necessary
 */
public abstract class CredentialService implements Store<Token> {

    private final Store<Token> tokenStore;
    private final Store<String> passwordStore;

    public CredentialService(Store<Token> tokenStore, Store<String> passwordStore) {
        this.tokenStore = tokenStore;
        this.passwordStore = passwordStore;
    }

    public void putPassword(String id, String password) {
        passwordStore.put(id, password);
    }

    public String getPassword(String id) {
        return passwordStore.get(id);
    }

    public void removePassword(String id) {
        passwordStore.remove(id);
    }

    public void clearPasswords() {
        passwordStore.clear();
    }

    /**
     * Provides an entry point to cleanly handle refresh token process,
     * typically avoiding launching 2 parallel processes (or more) at the same time
     * that would lead to loosing the credentials.
     */
    public abstract void requestRefreshToken(StateID stateID) throws SDKException;

    /* Simply wraps passed tokenStore methods */

    @Override
    public void put(String id, Token obj) {
        tokenStore.put(id, obj);
    }

    @Override
    public Token get(String id) {
        return tokenStore.get(id);
    }

    @Override
    public Map<String, Token> getAll() {
        return tokenStore.getAll();
    }

    @Override
    public void remove(String id) {
        tokenStore.remove(id);
    }

    @Override
    public void clear() {
        tokenStore.clear();
    }
}
