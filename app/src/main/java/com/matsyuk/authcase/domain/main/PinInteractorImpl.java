package com.matsyuk.authcase.domain.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.matsyuk.authcase.presentation.main.MainActivity;
import com.matsyuk.authcase.repositories.main.AuthRepository;

/**
 * @author e.matsyuk
 */
public class PinInteractorImpl implements PinInteractor {

    // Context or Router
    private Context context;
    private AuthRepository authRepository;

    public PinInteractorImpl(Context context, AuthRepository authRepository) {
        this.context = context;
        this.authRepository = authRepository;
        subscribeToAuthRepos();
    }

    private void subscribeToAuthRepos() {
        authRepository.subscribePinCodeNeedUpdate(() -> {
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public void updatePinCode(@NonNull String pinCode) {
        authRepository.updatePinCode(pinCode);
    }

}
