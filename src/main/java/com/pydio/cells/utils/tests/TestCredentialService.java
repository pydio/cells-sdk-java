package com.pydio.cells.utils.tests;

import com.pydio.cells.api.ErrorCodes;
import com.pydio.cells.api.SDKException;
import com.pydio.cells.api.Store;
import com.pydio.cells.api.Transport;
import com.pydio.cells.transport.CellsTransport;
import com.pydio.cells.transport.auth.CredentialService;
import com.pydio.cells.transport.auth.Token;

public class TestCredentialService extends CredentialService {

    public TestCredentialService(Store<Token> tokenStore, Store<String> passwordStore) {
        super(tokenStore, passwordStore);
    }

    @Override
    public Token refreshToken(String id, Transport transport) throws SDKException {

        Token oldToken = get(id);
        if (oldToken == null) {
            throw new SDKException(
                    ErrorCodes.no_token_available,
                    "Cannot refresh unknown token for " + id
            );
        }
        if (transport instanceof CellsTransport)
            return ((CellsTransport) transport).getRefreshedOAuthToken(oldToken.refreshToken);
        else {
            throw new SDKException(ErrorCodes.internal_error, "Refresh OAuth token is not supported by P8");
        }
    }
}
