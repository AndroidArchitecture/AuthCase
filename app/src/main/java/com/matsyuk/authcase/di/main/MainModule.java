package com.matsyuk.authcase.di.main;

import com.matsyuk.authcase.data.network.SomeApi;
import com.matsyuk.authcase.repositories.main.SomeRepository;
import com.matsyuk.authcase.repositories.main.SomeRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class MainModule {

    @Singleton
    @Provides
    public SomeRepository provideSomeRepository(SomeApi someApi) {
        return new SomeRepositoryImpl(someApi);
    }

}
