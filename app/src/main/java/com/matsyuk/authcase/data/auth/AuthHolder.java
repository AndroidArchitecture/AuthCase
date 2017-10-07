package com.matsyuk.authcase.data.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.matsyuk.authcase.data.common_network.CommonApi;
import com.matsyuk.authcase.data.common_network.RequestTokenModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class AuthHolder {

    private CommonApi commonApi;
    private SessionListener sessionListener;

    @NonNull
    private volatile String token = "StartToken";
    @Nullable
    private volatile String pinCode;

    public AuthHolder(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    public void updatePinCode(@NonNull String pinCode) {
        this.pinCode = pinCode;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public void refresh() {
        pinCode = null;
        if (sessionListener != null) {
            sessionListener.sessionExpired();
        }
        updateToken().blockingGet();
    }

    private Single<String> updateToken() {
        return commonApi.updateToken(new RequestTokenModel(pinCode))
                .singleOrError()
                .doOnSuccess(newToken -> token = newToken);
    }

    public void subscribeToSessionExpired(SessionListener sessionListener) {
        this.sessionListener = sessionListener;
    }

}
