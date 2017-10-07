package com.matsyuk.authcase.repositories.main;

import com.matsyuk.authcase.data.auth_network.AuthApi;
import com.matsyuk.authcase.domain.main.SomeModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class AuthRepositoryImpl implements AuthRepository {

    private AuthApi authApi;

    public AuthRepositoryImpl(AuthApi authApi) {
        this.authApi = authApi;
    }

    @Override
    public Single<SomeModel> getData() {
        return authApi.getData().singleOrError();
    }

}
