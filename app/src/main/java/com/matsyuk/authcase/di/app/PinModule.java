package com.matsyuk.authcase.di.app;

import com.matsyuk.authcase.domain.main.PinInteractor;
import com.matsyuk.authcase.domain.main.PinInteractorImpl;
import com.matsyuk.authcase.presentation.pincode.presenters.PinPresenter;
import com.matsyuk.authcase.repositories.main.AuthRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * @author e.matsyuk
 */
@Module
public class PinModule {

    @Singleton
    @Provides
    public PinInteractor providePinInteractor(AuthRepository authRepository, Router router) {
        return new PinInteractorImpl(authRepository, router);
    }

    // This app is example. That's why we simplified presentation layer
    // And we make Presenter with @Singleton scope
    @Singleton
    @Provides
    public PinPresenter providePinPresenter(PinInteractor pinInteractor) {
        return new PinPresenter(pinInteractor);
    }

}
