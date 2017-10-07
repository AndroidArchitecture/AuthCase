package com.matsyuk.authcase.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matsyuk.authcase.R;
import com.matsyuk.authcase.di.ComponentManager;
import com.matsyuk.authcase.domain.main.PinInteractor;
import com.matsyuk.authcase.repositories.main.AuthRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    // This app is example. That's why we simplified presentation layer
    // And we inject Repository for auth request starting
    @Inject
    AuthRepository authRepository;
    // Inject PinInteractor for initialising
    @Inject
    PinInteractor pinInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        startRequest();
    }

    private void startRequest() {
        authRepository.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(someModel -> {}, throwable -> {});
    }

}
