package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.data.auth_network.AuthApi;
import com.matsyuk.authcase.repositories.main.AuthRepository;
import com.matsyuk.authcase.repositories.main.AuthRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    public AuthRepository provideSomeRepository(AuthApi authApi) {
        return new AuthRepositoryImpl(authApi);
    }

}
