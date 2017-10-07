package com.matsyuk.authcase.data.network;

import com.matsyuk.authcase.data.auth.AuthHolder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author e.matsyuk
 */
public class MainInterceptor implements Interceptor {

    private static final String ACCESS_TOKEN_HEADER = "Access-Token";
    private AuthHolder authHolder;

    public MainInterceptor(AuthHolder authHolder) {
        this.authHolder = authHolder;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder requestBuilder = chain.request().newBuilder();
        if (chain.request().header(ACCESS_TOKEN_HEADER) == null) {
            requestBuilder.addHeader(ACCESS_TOKEN_HEADER, authHolder.getToken());
        }

        return chain.proceed(requestBuilder.build());
    }

}
