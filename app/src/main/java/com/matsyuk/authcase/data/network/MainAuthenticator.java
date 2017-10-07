package com.matsyuk.authcase.data.network;

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

    private AuthHolder authHolder;

    public MainAuthenticator(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    @Nullable
    @Override
    public Request authenticate(Route route, Response response) throws IOException {
        return null;
    }

}
