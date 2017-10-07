package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.data.auth.AuthHolder;
import com.matsyuk.authcase.data.common_network.CommonApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class AuthModule {

    @Provides
    @Singleton
    public AuthHolder provideAuthHolder(CommonApi commonApi) {
        return new AuthHolder(commonApi);
    }

}
