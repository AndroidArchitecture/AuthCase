package com.matsyuk.authcase.data.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.matsyuk.authcase.data.common_network.CommonApi;
import com.matsyuk.authcase.data.common_network.RequestTokenModel;

import java.util.concurrent.CountDownLatch;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class AuthHolder {

    private CommonApi commonApi;
    private SessionListener sessionListener;
    private volatile CountDownLatch countDownLatch;

    @NonNull
    private volatile String token = "StartToken";
    @Nullable
    private volatile String pinCode;

    public AuthHolder(CommonApi commonApi) {
        this.commonApi = commonApi;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public synchronized void refresh() {
        pinCode = null;
        if (sessionListener != null) {
            sessionListener.sessionExpired();
        }
        countDownLatch = new CountDownLatch(1);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateToken().blockingGet();
    }

    private Single<String> updateToken() {
        return commonApi.updateToken(new RequestTokenModel(pinCode))
                .singleOrError()
                .doOnSuccess(newToken -> token = newToken);
    }

    public synchronized void updatePinCode(@NonNull String pinCode) {
        this.pinCode = pinCode;
        countDownLatch.countDown();
    }

    public void subscribeToSessionExpired(SessionListener sessionListener) {
        this.sessionListener = sessionListener;
    }

}
