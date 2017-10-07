package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.presentation.main.MainActivity;
import com.matsyuk.authcase.presentation.pincode.views.PinCodeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author e.matsyuk
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AuthNetworkModule.class,
        AuthModule.class,
        CommonNetworkModule.class,
        PinModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(PinCodeActivity pinCodeActivity);

}
