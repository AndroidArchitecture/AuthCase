package com.matsyuk.authcase.presentation.pincode.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.matsyuk.authcase.R;
import com.matsyuk.authcase.di.ComponentManager;
import com.matsyuk.authcase.presentation.pincode.presenters.PinPresenter;

import javax.inject.Inject;

/**
 * @author e.matsyuk
 */
public class PinCodeActivity extends AppCompatActivity {

    @Inject
    PinPresenter pinPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getAppComponent().inject(this);
        setContentView(R.layout.activity_pincode);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(v -> pinPresenter.setNewPinCode("1234"));
    }

}
