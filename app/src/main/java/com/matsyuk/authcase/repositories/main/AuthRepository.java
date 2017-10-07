package com.matsyuk.authcase.repositories.main;

import android.support.annotation.NonNull;

import com.matsyuk.authcase.domain.main.PinCodeListener;
import com.matsyuk.authcase.domain.main.SomeModel;

import io.reactivex.Single;

/**
 * @author e.matsyuk
 */
public interface AuthRepository {
    Single<SomeModel> getData();
    void subscribePinCodeNeedUpdate(PinCodeListener pinCodeListener);
    void updatePinCode(@NonNull String newPinCode);
}
