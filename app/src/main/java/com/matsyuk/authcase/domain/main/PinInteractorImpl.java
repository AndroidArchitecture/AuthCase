package com.matsyuk.authcase.domain.main;

import android.support.annotation.NonNull;

import com.matsyuk.authcase.GlobalNavigator;
import com.matsyuk.authcase.repositories.main.AuthRepository;

import ru.terrakok.cicerone.Router;

/**
 * @author e.matsyuk
 */
public class PinInteractorImpl implements PinInteractor {

    private AuthRepository authRepository;
    private Router router;

    public PinInteractorImpl(AuthRepository authRepository, Router router) {
        this.authRepository = authRepository;
        this.router = router;
        subscribeToAuthRepos();
    }

    private void subscribeToAuthRepos() {
        authRepository.subscribePinCodeNeedUpdate(() -> {
            router.navigateTo(GlobalNavigator.PIN_SCREEN);
        });
    }

    @Override
    public void updatePinCode(@NonNull String pinCode) {
        authRepository.updatePinCode(pinCode);
    }

}
