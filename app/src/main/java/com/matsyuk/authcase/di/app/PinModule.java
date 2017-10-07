package com.matsyuk.authcase.di.app;

import android.content.Context;

import com.matsyuk.authcase.domain.main.PinInteractor;
import com.matsyuk.authcase.domain.main.PinInteractorImpl;
import com.matsyuk.authcase.presentation.pincode.presenters.PinPresenter;
import com.matsyuk.authcase.repositories.main.AuthRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class PinModule {

    private Context context;

    public PinModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public PinInteractor providePinInteractor(AuthRepository authRepository) {
        return new PinInteractorImpl(context, authRepository);
    }

    // This app is example. That's why we simplified presentation layer
    // And we make Presenter with @Singleton scope
    @Singleton
    @Provides
    public PinPresenter providePinPresenter(PinInteractor pinInteractor) {
        return new PinPresenter(pinInteractor);
    }

}
