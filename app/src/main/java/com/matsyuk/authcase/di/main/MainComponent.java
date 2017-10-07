package com.matsyuk.authcase.di.main;

import com.matsyuk.authcase.presentation.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author e.matsyuk
 */
@Singleton
@Component(modules = {MainModule.class, NetworkModule.class, AuthModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
