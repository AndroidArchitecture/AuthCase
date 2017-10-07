package com.matsyuk.authcase.data.auth_network;

import android.support.annotation.Nullable;

import com.matsyuk.authcase.data.auth.AuthHolder;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/**
 * @author e.matsyuk
 */
public class MainAuthenticator implements Authenticator {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";

    private AuthHolder authHolder;

    public MainAuthenticator(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    @Nullable
    @Override
    public synchronized Request authenticate(Route route, Response response) throws IOException {
        String storedToken = authHolder.getToken();
        String requestToken = response.request().header(ACCESS_TOKEN_HEADER);

        Request.Builder requestBuilder = response.request().newBuilder();

        if (storedToken.equals(requestToken)) {
            authHolder.refresh();
        }

        return buildRequest(requestBuilder);
    }

    private Request buildRequest(Request.Builder requestBuilder) {
        return requestBuilder.header(ACCESS_TOKEN_HEADER, authHolder.getToken()).build();
    }

}
