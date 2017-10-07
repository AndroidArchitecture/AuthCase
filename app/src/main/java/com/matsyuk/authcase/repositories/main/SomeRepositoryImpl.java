package com.matsyuk.authcase.repositories.main;

import com.matsyuk.authcase.data.network.SomeApi;
import com.matsyuk.authcase.domain.main.SomeModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public class SomeRepositoryImpl implements SomeRepository {

    private SomeApi someApi;

    public SomeRepositoryImpl(SomeApi someApi) {
        this.someApi = someApi;
    }

    @Override
    public Single<SomeModel> getData() {
        return someApi.getData().singleOrError();
    }

}
