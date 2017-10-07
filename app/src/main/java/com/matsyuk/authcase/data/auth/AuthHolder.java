package com.matsyuk.authcase.data.auth;

import android.support.annotation.NonNull;

import com.matsyuk.authcase.data.common_network.CommonApi;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class AuthHolder {

    private CommonApi commonApi;

    @NonNull
    private volatile String token = "StartToken";

    public AuthHolder(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public void refresh() {
        updateToken().blockingGet();
    }

    private Single<String> updateToken() {
        return commonApi.updateToken()
                .singleOrError()
                .doOnSuccess(newToken -> token = newToken);
    }

}
