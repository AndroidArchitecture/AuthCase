package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.MyApplication;
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
        PinModule.class,
        NavigationModule.class})
public interface AppComponent {

    void inject(MyApplication myApplication);
    void inject(MainActivity mainActivity);
    void inject(PinCodeActivity pinCodeActivity);

}
