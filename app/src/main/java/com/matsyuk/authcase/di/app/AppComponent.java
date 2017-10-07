package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.presentation.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author e.matsyuk
 */
@Singleton
@Component(modules = {AppModule.class, AuthNetworkModule.class, AuthModule.class, CommonNetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
