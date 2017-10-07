package com.matsyuk.authcase.presentation.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matsyuk.authcase.R;
import com.matsyuk.authcase.di.ComponentManager;
import com.matsyuk.authcase.repositories.main.SomeRepository;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    SomeRepository someRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getMainComponent().inject(this);
        setContentView(R.layout.activity_main);
    }
}
