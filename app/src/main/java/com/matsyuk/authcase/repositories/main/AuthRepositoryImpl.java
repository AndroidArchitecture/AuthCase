package com.matsyuk.authcase.repositories.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.matsyuk.authcase.data.auth.AuthHolder;
import com.matsyuk.authcase.data.auth.SessionListener;
import com.matsyuk.authcase.data.auth_network.AuthApi;
import com.matsyuk.authcase.domain.main.PinCodeListener;
import com.matsyuk.authcase.domain.main.SomeModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class AuthRepositoryImpl implements AuthRepository {

    private AuthApi authApi;
    private AuthHolder authHolder;

    @Nullable
    private volatile PinCodeListener pinCodeListener;

    public AuthRepositoryImpl(AuthApi authApi, AuthHolder authHolder) {
        this.authApi = authApi;
        this.authHolder = authHolder;
        subscribeToAuthHolder();
    }

    private void subscribeToAuthHolder() {
        authHolder.subscribeToSessionExpired(() -> {
            if (pinCodeListener != null) pinCodeListener.needUpdatePinCode();
        });
    }

    @Override
    public Single<SomeModel> getData() {
        return authApi.getData().singleOrError();
    }

    @Override
    public void subscribePinCodeNeedUpdate(@NonNull PinCodeListener pinCodeListener) {
        this.pinCodeListener = pinCodeListener;
    }

    @Override
    public void updatePinCode(@NonNull String newPinCode) {
        authHolder.updatePinCode(newPinCode);
    }

}
