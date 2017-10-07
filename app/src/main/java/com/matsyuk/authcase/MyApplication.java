package com.matsyuk.authcase;

import android.app.Application;

import com.matsyuk.authcase.di.ComponentManager;

/**
 * @author e.matsyuk
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ComponentManager.getInstance().initMainComponent();
    }

}
