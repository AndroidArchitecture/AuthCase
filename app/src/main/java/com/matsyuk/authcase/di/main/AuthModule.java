package com.matsyuk.authcase.di.main;

import android.support.annotation.NonNull;

import com.matsyuk.authcase.data.auth.AuthHolder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class AuthModule {

    @Provides
    @NonNull
    @Singleton
    public AuthHolder provideAuthHolder() {
        return new AuthHolder();
    }

}
